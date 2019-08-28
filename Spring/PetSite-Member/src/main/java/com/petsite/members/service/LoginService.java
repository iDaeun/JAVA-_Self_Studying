package com.petsite.members.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petsite.members.dao.MemberDao;
import com.petsite.members.domain.MemberInfo;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	private MemberDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public int login(String id, String pw, HttpServletRequest request) {
		
		dao = template.getMapper(MemberDao.class);
		
		int cnt = 0;
		MemberInfo memberInfo = null;
		
		memberInfo = dao.selectById(id);
		
		// 인증처리된 아이디인지 확인
		char verify = memberInfo.getVerify();
		
		// 1. 인증 처리됨 -> 암호화된 비밀번호 비교
		if(verify == 'Y' && memberInfo!=null && encoder.matches(pw, memberInfo.getPw())) {
			cnt = 1;
			// 로그인 정보 session에 저장
			//request.getSession().setAttribute("login", memberInfo.change());
			//System.out.println(request.getSession().getAttribute("login"));
		} else if (verify == 'N') {
			cnt = 2; // 2. 미인증 회원
		} else {
			cnt = 3; // 3. 로그인 실패
		}
		
		// 암호화된 비밀번호 비교
		/*
		 * if(memberInfo!=null && encoder.matches(pw, memberInfo.getPw())) { cnt = 1; //
		 * 로그인 정보 session에 저장 request.getSession().setAttribute("login",
		 * memberInfo.change());
		 * System.out.println(request.getSession().getAttribute("login")); }
		 */
		
		return cnt; 
	}
}
