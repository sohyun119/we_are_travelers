package com.travelers.common;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class PermissionInterceptor implements HandlerInterceptor{
	
	// 요청이 들어올때
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		// 로그인 정보
		HttpSession session = request.getSession();
		
		// 현재 요청한 url path (uri)
		String uri = request.getRequestURI();
		
		// 로그인 상태
		if(session.getAttribute("userCd") != null) {
			// 로그인 화면과, 회원가입 화면 접근 못하도록 이동
			if(uri.startsWith("/user")) {
				response.sendRedirect("/post/home");
				return false;
			}
		}
		// 비로그인 상태
		else {
			if(uri.startsWith("/post")){
				response.sendRedirect("/user/signInView");
				return false;
			}
		}
		
		return true;
	}
	
	// response 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler, ModelAndView modelAndView) {
		
	}
	
	// 모든 것이 완료 되었을때
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		
	}

}
