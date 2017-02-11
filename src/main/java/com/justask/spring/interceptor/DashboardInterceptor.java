package com.justask.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class DashboardInterceptor extends HandlerInterceptorAdapter	{

	
	@SuppressWarnings("null")
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		HttpSession session=req.getSession(false);
		System.out.println("in interceptor");
		if(null!=session){
			String username= (String) session.getAttribute("username");
			if(username!=null || !username.isEmpty()){
				return true;
			}
		}
		res.sendRedirect("/home.htm");
		return false;
	}
}
