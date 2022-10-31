package org.zerock.controller.board.tmp;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")// web inf의 view에서 찾으라고 언제 지정해줬어?
public class BoardController_ay {
	@Autowired
	private BoardService service; 
	
	@GetMapping("register")
	public void register() {
		
	}
	@PostMapping("register")
	public String register2(BoardDto board, RedirectAttributes rttr) {
		System.out.println(board);
		
		int cnt = service.register(board); //서비스에 의존하고 있으니 의존성 주입 받아야함.
		System.out.println(cnt);
		if(cnt==1) {
			rttr.addFlashAttribute("message","새 게시물이 등록되었습니다.");
		}else {
			rttr.addFlashAttribute("message","등록되지 않았습니다.");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		ArrayList<BoardDto> list =service.listBoard();
		model.addAttribute("boardList",list);
	}
	
	@GetMapping("get")
//	public void get( int id, Model model) {
	public void get(@RequestParam(name="id") int id,Model model) {  //리퀘스트파람 생략 가능
		
		BoardDto board = service.get(id);
		model.addAttribute("board",board);
		System.out.println(board);
		
	}
	@GetMapping("modify")
	public void modify(int id , Model model) {
		BoardDto board = service.get(id);
		model.addAttribute("board",board);
	}
	
	//포워드하기 때문에 모델을 쓴거고, 리디렉트하니까  RedirectAttributes 쓴거임.
	@PostMapping("modify")
	public String modify(BoardDto board, RedirectAttributes rttr) {
		int cnt=service.uptade(board);
		if(cnt==1) {
			rttr.addFlashAttribute("message", board +"번 게시물이 수정되었습니다.");
		}else {
			rttr.addFlashAttribute("message","수정되지 않았습니다.");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("remove")
	public String remove(int id,RedirectAttributes rttr) {
		int cnt=service.remove(id);
		if(cnt==1) {
			rttr.addFlashAttribute("message", id +"번 게시물이 삭제되었습니다.");
		}else {
			rttr.addFlashAttribute("message","삭제되지 않았습니다.");
		}
		return "redirect:/board/list";
	}

	
}













