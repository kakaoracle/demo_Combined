package com.iss.shirodemo.service;

import com.iss.shirodemo.vo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("授权....");
		// 存放的是登陆用户的所有权限信息
		SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo(); 
		
		sai.addRole("test");
		
		return sai;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("认证....");
		UsernamePasswordToken upt = (UsernamePasswordToken)token;
		String username = upt.getUsername();
		String pwd = new String(upt.getPassword());
		// 查数据库
		if("admin".equals(username) && "admin".equals(pwd)){
			User user = new User();
			user.setUsername(username);
			user.setPwd(pwd);
			// 认证信息
			SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user,pwd,getName());
			return sai;
		}
		return null;
	}

}
