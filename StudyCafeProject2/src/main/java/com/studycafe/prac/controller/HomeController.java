package com.studycafe.prac.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.studycafe.prac.dao.TodayTicketDao;

@Controller
public class HomeController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/loginpage")//이용금액표
	public String loginpage() {
		
		
		return "loginpage";
	}
	
	@RequestMapping(value="/TicketPrice")//이용금액표
	public String TicketPrice() {
		
		
		return "TicketPrice";
	}
	
	@RequestMapping(value="/ChooseTicket")//이용권선택
	public String chooseTicket() {
		
		
		return "ChooseTicket";
	}
	
	@RequestMapping(value="/TodayTicketView")
	public String TodayTicketView() {
		
		
		return "TodayTicketView";
	}
	
	@RequestMapping(value="/registToday")
	public String regist(HttpServletRequest request ) {
		
		TodayTicketDao dao = sqlSession.getMapper(TodayTicketDao.class);
		
		String seatNo = request.getParameter("seatNo");
		String userId = request.getParameter("userId");
		String ticketName = request.getParameter("ticketName");
		String selectedDate = request.getParameter("selectedDate");
		String selectedTime = request.getParameter("selectedTime");
		
		dao.regist(seatNo, userId, ticketName, selectedDate, selectedTime);
		
		
		return "registTodayConfirm";
	}	
	
	
	@RequestMapping(value="/registTodayConfirm")
	public String confirm() {
		
		
		return "registTodayConfirm";
	}
}
