package com.gzsxt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzsxt.domain.User;

@WebFilter(value = {"*.action","*.jsp"})
public class SysFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//类型转换
		HttpServletRequest request = (HttpServletRequest)req ;
		HttpServletResponse response = (HttpServletResponse)resp ;
		//获取资源路径
		String requestURI = request.getRequestURI();
		//获取标识符cmd
		String cmd = request.getParameter("cmd");
		//获取session中的user对象
		User user = (User)request.getSession().getAttribute("user");
		//判断用户是否处于登录状态
		if(user != null) {
			//当用户处于登录状态时，不允许其再次访问login.jsp、register.jsp
			if(requestURI.lastIndexOf("login.jsp")!=-1 || requestURI.lastIndexOf("register.jsp")!=-1) {
				//重定向回到首页
				response.sendRedirect(request.getContextPath() + "/page/index.jsp");
			}else {
				//放行
				chain.doFilter(req, resp);
			}			
		}else {
			if(//登录页面不拦截
					requestURI.lastIndexOf("login.jsp")!=-1 ||
					//注册页面不拦截
					requestURI.lastIndexOf("register.jsp")!=-1 ||
					//验证码页面不拦截
					requestURI.lastIndexOf("image.jsp")!=-1 || 
					//登录注册等请求不拦截
					"login".equals(cmd) || "register".equals(cmd))
				{
					//放行
					chain.doFilter(req, resp);
			} else {
				//重定向到登录页面
				response.sendRedirect(request.getContextPath() + "/page/login.jsp");
			}
		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
