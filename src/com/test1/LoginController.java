package com.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController{

	//Authenticator라는 interface선언
	private Authenticator authenticator;

	//의존성 주입(IoC에 의해) -> 뭘로 주입? method로 주입
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		
		LoginCommand login = (LoginCommand)command;
		
		//예외처리 - try catch문안에 넣어 사용
		try {
		
			authenticator.authen(login.getUserId(), login.getUserPwd());
			
			String message = "id: " + login.getUserId();
			message+= ", pwd: " + login.getUserPwd();
			message+= ", type: " + login.getLoginType();
			
			request.setAttribute("message", message);
	
			return new ModelAndView("test1/login_ok");
			
		} catch (UserException e) {
			return showForm(request, response, errors);
		}
		
	}

	@Override
	protected Map<String,List<String>> referenceData(HttpServletRequest request) throws Exception {
		
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("특별회원");
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("loginTypes", loginTypes);
		
		return map;
	}
	
	
	
}
