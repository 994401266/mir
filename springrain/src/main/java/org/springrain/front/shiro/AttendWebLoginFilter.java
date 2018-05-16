package org.springrain.front.shiro;

import org.springframework.stereotype.Component;
import org.springrain.frame.shiro.BaseUserFilter;

@Component("frontindex")
public class AttendWebLoginFilter extends BaseUserFilter{

	public AttendWebLoginFilter(){
		//跳转到登录界面
		super.setLoginUrl("/front/movie/index");
	}
	
}
