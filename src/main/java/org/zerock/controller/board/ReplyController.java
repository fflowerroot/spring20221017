package org.zerock.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.board.ReplyDto;
import org.zerock.service.board.Replyservice;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	private Replyservice service;
	
	@GetMapping("list/{boardId}")
	@ResponseBody
	public List<ReplyDto> list(@PathVariable int boardId) {
		return service.listReplyByBoardId(boardId);
	}

	@PostMapping("add")
	@ResponseBody
	public Map<String, String> add(@RequestBody ReplyDto reply) { //리퀘스트파람이 아니라 리퀘스트 바디로 받음
		System.out.println(reply);
		Map <String,String> map = new HashMap<String, String>();
		int cnt = service.addReply(reply); // 댓글 인서트
		
		if(cnt==1) {
			map.put("message","새 댓글이 등록되었습니다.");
		}else {
			map.put("message","새 댓글이 등록되지 않았습니다.");
		}
		return map; //리퀘스트바디로 리턴됨
	}
}
