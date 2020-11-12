package com.kh.livro.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class noticeInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(noticeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("[loginInterceptor] : mypage preHandle");

		if (request.getRequestURI().contains("insert.do") && request.getSession().getAttribute("logindto") == null) {
			response.sendRedirect("error.do");
			return false;
		}

		if (request.getRequestURI().contains("update.do") && request.getSession().getAttribute("logindto") == null) {
			response.sendRedirect("error.do");
			return false;
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("[loginInterceptor] : mypage afterCompletion");

	}

}
