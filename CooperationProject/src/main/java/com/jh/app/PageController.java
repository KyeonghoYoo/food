package com.jh.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping(value = "/pm", method = RequestMethod.GET)
	public String pmPage() {
		System.out.println("==> indexPage()");
		return "/resources/pm.html";
	}
	
	@RequestMapping(value = "/cu", method = RequestMethod.GET)
	public String cuPage() {
		System.out.println("==> indexPage()");
		return "/resources/cu.html";
	}

	@RequestMapping(value = "/de", method = RequestMethod.GET)
	public String dePage() {
		System.out.println("==> indexPage()");
		return "/resources/de.html";
	}
	
}
