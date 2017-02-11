package com.justask.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SendMailController {

	 @Autowired
	 private JavaMailSender mailSender;
	
	
	@RequestMapping(value="/sendMail.htm",method=RequestMethod.POST)
	public String sendMail(HttpServletRequest request,HttpServletResponse response){
		System.out.println("inside sendMail controller");
		String emailId= request.getParameter("emailId");
		String textMessage= "Hello,\nWe are extremely sorry but you are being blocked from JustAsk \n\nThanks,\nJustAsk Admin";
		
		 SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(emailId);
	       // email.setFrom("JustAskAdmin@justAsk.com");
	        email.setSubject("JustAsk: You are being blocked!!");
	        email.setText(textMessage);
	         
	        // sends the e-mail
	        mailSender.send(email);
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(true);
			System.out.println("everything is perfect, json data is set");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return null;
		
	}
}
