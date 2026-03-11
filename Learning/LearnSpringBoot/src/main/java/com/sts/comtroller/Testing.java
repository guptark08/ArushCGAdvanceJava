package com.sts.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Testing {

	@RequestMapping("/testing")
	@ResponseBody
	public String test() {
		return "this SpringBoot Application for test purpose.";
	}
	
}