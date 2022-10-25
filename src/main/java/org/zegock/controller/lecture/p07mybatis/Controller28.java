package org.zegock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zegock.mapper.lecture.Mapper01;

@Controller
@RequestMapping("ex28")
public class Controller28 {
	@Autowired
	private Mapper01 mapper;
	@RequestMapping("sub01")
	public void m1() {
		String time = mapper.getCurrentTime();
		System.out.println(time);
	}
}
