package org.zerock.service.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;
import org.zerock.mapper.board.ReplyMapper;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service    //원래 @Component를 붙임 --> 비지니스로직을 담고 있는 component를 service라고 함
public class BoardSerivce {

	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private S3Client s3Client;
	
	@Value("${aws.s3.bucket}") //@Value("aws.s3.bucket") ?
	private String bucketName;
	
	// ---------c-----------
	public int register(BoardDto board) {  //아무 역할 없이 mapper.insert(board) 호출 / 단지 메서드명이 register에서 insert로 바뀜.
		return boardMapper.insert(board);
	}
	
	public int register(BoardDto board, MultipartFile[] files) {
		// db에 게시물 정보 저장
		int cnt = boardMapper.insert(board);
		
		for (MultipartFile file : files) {
			if (file != null && file.getSize() > 0) {
				// db에 파일 정보 저장
				boardMapper.insertFile(board.getId(), file.getOriginalFilename());
				
				uploadFile(board.getId(), file);
			}
		}
				
//				// 파일 저장
//				// board id 이름의 새폴더 만들기
//				File folder = new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
//				folder.mkdirs();
//				
//				File dest = new File(folder, file.getOriginalFilename());
//				
//				try {
//					file.transferTo(dest);
//				} catch (Exception e) {
//					// @Transactional은 RuntimeException에서만 rollback 됨
//					e.printStackTrace();
//					throw new RuntimeException(e);
//				}
//			}
//		}
		
		return cnt;
	}

	

	// ---------r-----------
	public List<BoardDto> listBoard(int page, String type, String keyword, PageInfo pageInfo) {
		//쿼리에서 사용할 변수들 작업해서 넘겨줌
		//뷰파일에 넘겨줄 변수도 작업함
		
		int records = 10;
		int offset = (page - 1) * records;//Limit offset,records
		int countAll = boardMapper.countAll(type, "%" + keyword + "%"); // db작업한 것 호출 가능
		int lastPage = (countAll - 1) / records + 1;
		int leftPageNumber = (page - 1) / 10 * 10 + 1;
		int rightPageNumber = leftPageNumber + 9;
		rightPageNumber = Math.min(lastPage, rightPageNumber);
		// 이전버튼 유무
		boolean hasPrevButton = page > 10;
		// 다음버튼 유무
		boolean hasNextButton = page <= (lastPage - 1) / 10 * 10;
		// 이전버튼 눌렀을 때 가는 페이지 번호
		int jumpPrevPageNumber = (page - 1) / 10 * 10 - 9;
		int jumpNextPageNumber = (page - 1) / 10 * 10 + 11;
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setJumpNextPageNumber(jumpNextPageNumber);
		pageInfo.setJumpPrevPageNumber(jumpPrevPageNumber);
		pageInfo.setPage(page);
		pageInfo.setLastPageNumber(lastPage);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		return boardMapper.list(offset, records, type, "%" + keyword + "%"); // 매개변수에 값을 넣어준게 아니라 함수 호출한거니까 헷갈리면 안됨
	}
	
	
	
	
	//동적 sql -> sql 태그를 사용
	
	

	public BoardDto get(int id) {
		return boardMapper.select(id);
	}

	// ---------u-----------
	public int update(BoardDto board, MultipartFile[] addFiles, List<String> removeFiles) {
		int boardId = board.getId();
		
		// removeFiles 에 있는 파일명으로 
		
		if (removeFiles != null) {
			for (String fileName : removeFiles) {
				boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);
				deleteFile(boardId, fileName);
				
				// 1. File 테이블에서 record 지우기
				boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);
				// 2. 저장소에 실제 파일 지우기
//				String path = "C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + boardId + "\\" + fileName;
//				File file = new File(path);
//				
//				file.delete();
				
				// 2. S3 저장소에 실제 파일(object) 지우기
				deleteFile(boardId, fileName);
			}
		}
		
		
		for (MultipartFile file : addFiles) {
			if (file != null && file.getSize() > 0) {
				String name = file.getOriginalFilename();
				// File table에 해당파일명 지우기
				boardMapper.deleteFileByBoardIdAndFileName(boardId, name);
				
				// File table에 파일명 추가
				boardMapper.insertFile(boardId, name);
				
				// 저장소에 실제 파일 추가
//				File folder = new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
//				folder.mkdirs();
//				
//				File dest = new File(folder, name);
//				
//				try {
//					file.transferTo(dest);
//				} catch (Exception e) {
//					// @Transactional은 RuntimeException에서만 rollback 됨
//					e.printStackTrace();
//					throw new RuntimeException(e);
//				}
				// S3 저장소에 실제 파일(object) 추가
				uploadFile(boardId, file);
			}
			
		}
		
		
		return boardMapper.update(board);	
	}

	// ---------d-----------
	public int remove(int id) {
		
		BoardDto board = boardMapper.select(id);
		List<String> fileNames= board.getFileName();
		if(fileNames!=null) {
			for(String fileName: fileNames) {
				
				deleteFile(id, fileName);
			}
		}
		
		
		// 저장소의 파일 지우기
//		String path = "C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + id;
//		File folder = new File(path);
//		
//		File[] listFiles = folder.listFiles();
//		
//		if (listFiles != null) {
//			for (File file : listFiles) {
//				file.delete();
//			}
//		}
//		
//		folder.delete();
		
		// db 파일 records 지우기
		boardMapper.deleteFileByBoardId(id);
		
		
		// 게시물의 댓글들 지우기
		replyMapper.deleteByBoardId(id);
		
//		int a = 3 / 0; // runtime exception
		
		// 게시물 지우기
		return boardMapper.delete(id);
	}
	
	
	

	//-------------------------------------------------------
	
	
	private void deleteFile(int id, String fileName) {
		String key="prj1/board/"+id+fileName;
		DeleteObjectRequest deleteObjectRequest= DeleteObjectRequest.builder().bucket(bucketName).key(key).build();
		s3Client.deleteObject(deleteObjectRequest);
	}
	
	private void uploadFile(int id, MultipartFile file) {
		try {
			// S3에 파일 저장
			// 키 생성
			String key = "prj1/board/" + id + "/" + file.getOriginalFilename();
			
			// putObjectRequest
			PutObjectRequest putObjectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key(key)
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			// requestBody
			RequestBody requestBody = RequestBody.fromInputStream(file.getInputStream(), file.getSize());
			
			// object(파일) 올리기
			s3Client.putObject(putObjectRequest, requestBody);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
