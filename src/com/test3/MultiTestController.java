package com.test3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//여러개의 controller를 하나로 합치는 방법
public class MultiTestController extends MultiActionController{

	public ModelAndView list (HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		request.setAttribute("message", "list 페이지");
		
		return new ModelAndView("test3/testlist");
		
	}
	
	public ModelAndView view (HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		request.setAttribute("message", "view 페이지");
		
		return new ModelAndView("test3/testview");
		
	}
}
