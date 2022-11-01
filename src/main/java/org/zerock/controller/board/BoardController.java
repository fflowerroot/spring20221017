package org.zerock.controller.board;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.service.board.BoardSerivce;

@Controller
@RequestMapping("board") // web inf의 view에서 찾으라고 언제 지정해줬어?
public class BoardController {
	
	@Autowired //필드에 주입   ?
	private BoardSerivce service;
	
//	private BoardSerivce service = new BoardSerivce(); //new로 생성했더니 BoardSerivce클래스에서 mapper인터페이스를 못가져옴?
	//java.lang.NullPointerException: Cannot invoke "org.zerock.mapper.board.BoardMapper.insert(org.zerock.domain.board.BoardDto)" because "this.mapper" is null


	//------------------c----------------
	
	@GetMapping("register")
	public void register() {
		// 게시물 작성 view로 포워드
		// /WEB-INF/views/board/register.jsp
	} //어떻게 조건이  not null인데 아무입력 없이 등록이 되지 ?
	
	
	@PostMapping("register")
	public String register(BoardDto board, RedirectAttributes rttr) {
		// request param 수집/가공
		
		// business logic
		int cnt = service.register(board);//서비스에 의존하고 있으니 의존성 주입 받아야함.
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
		}
		
		// /board/list로 redirect
		return "redirect:/board/list";
	}
	
	
	//-------------------r-----------------
	@GetMapping("list")    //여기서 포워드로 넘겨주는거라서 여기까지 객체?가 와야함.
	public void list(
			@RequestParam(name="page", defaultValue="1")int page,
			@RequestParam(name="t", defaultValue="all") String type, 
			@RequestParam(name="q", defaultValue="") String keyword, 
			
			PageInfo pageInfo, 
			Model model) {
					
		// request param
		// business logic
		List<BoardDto> list = service.listBoard(page,type,keyword, pageInfo);
		
		// add attribute
		model.addAttribute("boardList", list); //모델에 꼭 넣어줘야함?
		// forward
	}
	// 존재하지 않으면 객체 생성.리퀘스트파라미터 네임과 일치하는 필드네임을? 쓴다. ->데이터바인딩.
	

	@GetMapping("get") 
	public void get(
			// @RequestParam 생략 가능
			@RequestParam(name = "id") int id,
			Model model) {
		// req param
		// business logic (게시물 db에서 가져오기)
		BoardDto board = service.get(id);
		// add attribute
		model.addAttribute("board", board);
		// forward
		
	}
	
	//-----------------u---------------------
	@GetMapping("modify")
	public void modify(int id, Model model) {
		BoardDto board = service.get(id);
		model.addAttribute("board", board);
		
	}
	//포워드하기 때문에 모델을 쓴거고, 리디렉트하니까  RedirectAttributes 쓴거임.
	@PostMapping("modify")
	public String modify(BoardDto board, RedirectAttributes rttr) {
		int cnt = service.update(board);
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되었습니다.");
		} else {
			rttr.addFlashAttribute("message", board.getId() + "번 게시물이 수정되지 않았습니다.");
		}
		
		return "redirect:/board/list";
	}
	
	
	//----------------d-------------------
	@PostMapping("remove")
	public String remove(int id, RedirectAttributes rttr) {
		int cnt = service.remove(id);
		
		if (cnt == 1) {
			// id번 게시물이 삭제되었습니다.
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되었습니다.");
		} else {
			// id번 게시물이 삭제되지 않았습니다.
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되지 않았습니다.");
		}
		
		return "redirect:/board/list";
	}
	
	
}

//org.springframework.jdbc.BadSqlGrammarException: 
//### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: (conn=1678) You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near '' at line 2
//### The error may exist in org/zerock/mapper/board/BoardMapper.xml
//### The error may involve defaultParameterMap
//### The error occurred while setting parameters
//### SQL: SELECT COUNT(*) FROM Board  WHERE
//### Cause: java.sql.SQLSyntaxErrorException: (conn=1678) You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near '' at line 2
//; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: (conn=1678) You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near '' at line 2








