package org.zerock.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.JavaBean01;
import org.zerock.domain.board.PageInfo;
import org.zerock.domain.board.PageInfo2;
import org.zerock.service.board.BoardSerivce;

@Controller
@Component
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
	} //아무 입력없이 등록하면 null이 아니라 빈문자열로 등록됨
	
	
	// jsp에서 넘어온 객체는 자바의 프로퍼티명과 어트리뷰트명이 일치하면 서브밋할 때 자동으로 객체에 넣어짐 ?
		// 넣어진 객체는 자동으로 매개변수에 넣어짐 ?
	
	
	@PostMapping("register") //register.jsp에서 action으로 넘어온./그러면 action은 리디렉트 ?
	public String register(BoardDto board, 
			RedirectAttributes rttr) { //RedirectAttributes는 redirect로 '넘겨줄' 어트리뷰트. 
										// RedirectAttributes 안쓰고 모델로 넘겨줘도돼 ?
		
		// request param 수집/가공
		// jsp 폼으로 입력받은 title,content,writer 3개 어트리뷰트가 넘어옴( 보드에 담겨서 넘어와 ?? -> 보드에 어트리뷰트명이랑 일치하는 프로퍼티가 있어서? )
		
		// business logic
		int cnt = service.register(board);//서비스에 의존하고 있으니 의존성 주입 받아야함.
		                              //  xml 쿼리에서 인서트 반환타입 안적어줬는데 인트로 반환됨. 왜 ? 
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
		} else {
			rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
		}
		// ?? 넘겨주는 것들이 모델과 리퀘스트파람과 보드와 리디렉트어트리뷰트..등이 있음 -> 결국 어트리뷰트들이 어디붙어서 넘어감?
		

		return "redirect:/board/list";
	}
	
	
	
	
	
	//-------------------r-----------------
	//register에서 list로 넘어온건 없고 db에서 셀렉해서 보여줘야됨
	 // 현재page의 이름을 다 같게 page라고 해도 문제없어 보이는게 
	// 	  ->	모델은 ${어트리뷰트.page}, 리퀘파람은 ${param.page}, jstl태그 변수는 ${page}
	@GetMapping("list")    //여기서 포워드로 넘겨주는거라서 여기까지 객체?가 와야함.
	public void list(
			@RequestParam(name="page", defaultValue="1")int page, //page가 현재page // 쿼리의 limit offset,records와 page가 매칭되도록은 서비스에서 했음.
			@RequestParam(name="t", defaultValue="all") String type, 
			@RequestParam(name="q", defaultValue="") String keyword, 		
			PageInfo pageInfo, 
			Model model) { // 리퀘스트파람은 처음엔 넘어올게 없어서 기본값 세팅해준거로 넘어가고,
							// 페이지인포는 자동주입.페이인포타입의 매개변수명이 중요한게 아니라.. 클래스명의 앞글자를 소문자로 바꾼게 어트리뷰트명이되는거였음 ..; 
							// 모델도 스프링이 넣어주고 모델에는 아래에서 객체리스트 넣어줌. (모델은 디스페처서블릿이 관리해줌)
						    // ? ? 매개변수에 List<BoardDto>라고 쓰면 자동주입 안됨 ? (리스트는 자동주입 안됨?) 만약 되면, jsp어트리뷰트명 뭐로 넘어감 ?
							// 기본타입은 리퀘스트파람으로 간주되고, 참조타입은 모델어트리뷰트로 간주됨(어트리뷰트명은 클래스명 앞글자 소문자로 바꾼것!).
							
		// request param
		
		// business logic
		   // 셀렉해서 가져와서 보여줌
		List<BoardDto> list = service.listBoard(page, type, keyword, pageInfo); //서비스의 listBoard메서드를 실행해서 보드리스트를 가져옴
		
		
		// add attribute
		model.addAttribute("boardList", list); 
		
		// forward
	}
	// 존재하지 않으면 객체 생성.리퀘스트파라미터 네임과 일치하는 필드네임을? 쓴다. ->데이터바인딩.
	
	
	
	
	
	
	
//list에서 넘어온 id로 보드객체 쿼리에서 셀렉해서 보여주기
	@GetMapping("get") 
	public void get(
			// @RequestParam 생략 가능 -> 기본타입(String포함?)이면 리퀘스트파람으로 간주된대
			int id,
			Model model,
			BoardDto boardDto,
			PageInfo2 p
			
			) {
		
		// req param
		
		// business logic (게시물 db에서 가져오기)
		boardDto = service.get(id);
		boardDto.setTitle("titletitle..");
		System.out.println(boardDto);
		System.out.println(boardDto.getId()); //콘솔 출력됨 
		System.out.println(boardDto.getTitle()); // 콘솔 출력됨// ? ? 그런데 왜 id를 제외한 나머지는 어트리뷰트로 안넘어가지 ?
		p.setLastPageNumber(1111111); //이건 어트리뷰트로 넘어감.
		System.out.println(p.getLastPageNumber());
		
		BoardDto board = service.get(id);
		// add attribute 
		model.addAttribute("board", board);
		 
		// forward
		
	}
	
	
	
	// href(리퀘스트파람만 가능?),인풋폼(어트리뷰트,리퀘스트파람),fetch(어트리뷰트 가능,리퀘스트파람 가능 ? ) 로 넘김.
	// 인풋폼도 원래는 리퀘스트파람으로 넘어가는건데.. 프로퍼티명과 일치하면 자동주입되는거야 ?
	
	
	
	//-----------------u---------------------
	@GetMapping("modify")
	public void modify(int id, Model model) {
		BoardDto board = service.get(id);
		model.addAttribute("board", board);
	}
	
	
	
	//포워드하기 때문에 모델을 쓴거고, 리디렉트하니까  RedirectAttributes 쓴거임. ?
	// BoardDto board를 매개변수로 설정한 것이 리퀘스트파람을 수집,가공한거래
	
	@PostMapping("modify")
	public String modify(
			BoardDto board, 
			@RequestParam("files") MultipartFile[] addFiles,
			@RequestParam(name = "removeFiles", required = false) List<String> removeFiles,
			RedirectAttributes rttr) {
		
		int cnt = service.update(board, addFiles, removeFiles);
		
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




// @ResponseBody어노테이션이 있으면 리턴타입이 객체나 맵일 경우, 제이슨이 리스폰스바디에 붙어서 넘어감.
// 리스폰스바디에 붙어서 응답한다는 건 요청한 페이지로 응답하는거?
// 한글처리하려면 헤더도 변경해야함.
// 응답 후 실행해야하는 코드는 응답요청코드.then() 
// 함수도 then의 매개변수(?)로 들어갈 수 있음

// 엘리먼트(?).insertAdjacentHTML("엘리먼트 기준으로 넣을 위치","넣을 값")
// js에서 스트링을 리터럴하게 만드는 방법 (?) :
//   >>  1. ""  2.''  3.``
// ``(백틱?)을 js에서는 template literal(template string)(문자틀?)이라고 한대
// ``안의 ${}안에 변수를 넣을 수 있음..
// html변수는 el안에 ..   js변수는 ``내 ${}안에 ?







