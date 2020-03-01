package com.gzsxt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.gzsxt.dao.BaseDao;
import com.gzsxt.dao.impl.BaseDaoImpl;
import com.gzsxt.domain.Dept;
import com.gzsxt.domain.Message;
import com.gzsxt.domain.Role;
import com.gzsxt.domain.User;
import com.gzsxt.service.UserService;
import com.gzsxt.service.impl.UserServiceImpl;
import com.gzsxt.util.ConfigUtil;
import com.gzsxt.util.PageUtil;

@WebServlet("/user.action")
public class UserServlet extends HttpServlet{	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建BaseDao对象
		UserService service = new UserServiceImpl();
		//创建session对象
		HttpSession session = req.getSession();
		//创建输出流对象
		PrintWriter out = resp.getWriter();
		//创建User对象
		User user = null;
		//创建Message对象
		Message message = null;	
		//获取标识符cmd
		String cmd = req.getParameter("cmd");
		//初始化变量
		int result = 0;
		
		//A1.用户登录
		if("login".equals(cmd)) {
			//获取用户提交的表单信息
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String code = req.getParameter("code");
			//获取session中的code
			String sysCode = (String) session.getAttribute("rand");
			//比较code
			if(sysCode.toLowerCase().equals(code.toLowerCase())) {
				//校验登录信息
				user = service.login(username, password);
				//判断是否此用户
				if(user != null) {
					//将用户信息存入session中
					session.setAttribute("user",user);
					//响应消息
					message = new Message(1,"登录成功！");
					out.write(JSON.toJSONString(message));
				}else {
					//响应消息
					message = new Message(2,"账号或者密码错误，请重新输入！");
					out.write(JSON.toJSONString(message));
				}
			}else {
				//响应消息
				message = new Message(3,"验证码错误，请重新输入！");
				out.write(JSON.toJSONString(message));
			}			
		}
		
		//A2.用户退出
		if("loginout".equals(cmd)) {
			//判断用户是否处于登录状态
			if(session.getAttribute("user") != null) {
				//销毁session中的user
				session.removeAttribute("user");
				//重定向
				session.setAttribute("msg", "感谢您的使用！");
				resp.sendRedirect("page/login.jsp");
			}else {
				//重定向
				session.setAttribute("msg", "请先登录！");
				resp.sendRedirect("page/login.jsp");
			}
		}
		
		//B1.角色管理——角色列表
		if("roleList".equals(cmd)) {
			//获取每页角色数量的配置信息
			int loadCount = ConfigUtil.getLoadCount("rolePieceCount");
			//获取当前页码
			int pageCount = 0;
			String rolePageCount = req.getParameter("pageCount");
			if(rolePageCount == null) {
				pageCount = 1;
			}else {
				pageCount = Integer.parseInt(rolePageCount);
			}			
			//获取用户提交的表单信息
			String roleName = req.getParameter("roleName");
			//获取角色总数
			int roleCount = service.getRowCount("t_role", roleName);
			PageUtil pageUtil = new PageUtil(pageCount,loadCount,1,roleCount);			
			//判断是否存在角色
			List<Role> list = service.getRoleList(roleName,pageUtil.getStartRow(), loadCount);
			if(list != null) {
				//请求转发
				req.setAttribute("roleName", roleName);
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("totalPage",pageUtil.getPageCount());
				req.setAttribute("roleList",list);
				req.getRequestDispatcher("page/user/roleList.jsp").forward(req, resp);
			}
		}
		
		//B2.角色管理-角色删除
		if("roleRemove".equals(cmd)) {
			//获取需要删除的角色编号
			int roleid = Integer.parseInt(req.getParameter("roleid"));
			//执行删除
			result = service.roleRemove(roleid);
			//判断是否删除成功
			if(result>0) {
				//响应消息
				message = new Message(1,"删除成功！");
				out.write(JSON.toJSONString(message));
			}else {
				//响应消息
				message = new Message(1,"删除失败！");
				out.write(JSON.toJSONString(message));
			}
		}
		
		//B3.角色管理——获取指定角色的信息
		if("roleReplaceBefore".equals(cmd)) {
			//获取需要修改的角色编号
			int roleid = Integer.parseInt(req.getParameter("roleid"));
			//执行查询
			Role role = service.getRole(roleid);
			if(role != null) {
				//将需要修改的角色信息存入session
				session.setAttribute("role", role);
				//响应消息
				message = new Message(1,"");
				out.write(JSON.toJSONString(message));
			}else {
				//响应消息
				message = new Message(2,"此角色不存在！");
				out.write(JSON.toJSONString(message));
			}
		}
		
		//B4.角色管理——部门列表(roleReplace.jsp)
		if("roleDeptReplace".equals(cmd)) {
			//获取部门数量
			int deptCount = service.getRowCount("t_dept", null);
			//获取不需要从数据库中取出的编号
			Role role = (Role) session.getAttribute("role");
			String deptno = role.getR_deptno();
			//获取部门列表
			//参数1：需要搜索的部门名称，参数2：不需要提取的部门编号，参数3：页码，参数4：每页显示的数据条数
			List<Dept> deptList = service.getDeptList(null,deptno,0,deptCount-1);
			//响应消息
			out.write(JSON.toJSONString(deptList));
		}
		
		//B4.角色管理——部门列表(roleAdd.jsp)
		if("roleDeptAdd".equals(cmd)) {
			//获取部门数量
			int deptCount = service.getRowCount("t_dept", null);
			//获取部门列表
			//参数1：需要搜索的部门名称，参数2：不需要提取的部门编号，参数3：页码，参数4：每页显示的数据条数
			List<Dept> deptList = service.getDeptList(null,null,0,deptCount);
			//响应消息
			out.write(JSON.toJSONString(deptList));
		}
		
		//B5.角色管理——角色修改
		if("roleReplace".equals(cmd)) {
			//获取用户提交的表单信息
			int roleid = Integer.parseInt(req.getParameter("roleid"));
			String roleno = req.getParameter("roleno");
			String roleName = req.getParameter("roleName");
			String deptno = req.getParameter("deptno");
			String remarks = req.getParameter("remarks");
			//获取当前操作者的用户id
			user = (User) session.getAttribute("user");
			int operator = user.getT_id();
			//判断是否修改成功
			result = service.roleReplace(null, roleid, roleno, roleName, deptno, remarks, operator);
			if(result == 1) {
				//响应消息
				message = new Message(1,"修改成功");
				out.write(JSON.toJSONString(message));
			}else {
				//响应消息
				message = new Message(2,"发生了未知的错误");
				out.write(JSON.toJSONString(message));
			}
		}
		
		//B6.角色管理——角色添加
		if("roleAdd".equals(cmd)) {
			//获取用户提交的表单信息
			String roleno = req.getParameter("roleno");
			String roleName = req.getParameter("roleName");
			String deptno = req.getParameter("deptno");
			String introduce = req.getParameter("introduce");
			String remarks = req.getParameter("remarks");
			//获取当前操作者的用户id
			user = (User)session.getAttribute("user");
			int operator = user.getT_id();
			//执行添加
			result = service.roleAdd(null, roleno, roleName, deptno, remarks, introduce, operator);
			if(result == 1) {
				//响应消息
				message = new Message(1,"添加成功");
				out.write(JSON.toJSONString(message));
			}else {
				//响应消息
				message = new Message(2,"发生了未知的错误");
				out.write(JSON.toJSONString(message));
			}
		}
		
		//C1.部门管理——部门列表
		if("deptList".equals(cmd)) {
			//获取每页角色数量的配置信息
			int loadCount = ConfigUtil.getLoadCount("deptPieceCount");
			//获取当前页码
			int pageCount = 0;
			String deptPageCount = req.getParameter("pageCount");
			if(deptPageCount == null) {
				pageCount = 1;
			}else {
				pageCount = Integer.parseInt(deptPageCount);
			}			
			//获取用户提交的表单信息
			String deptName = req.getParameter("deptName");
			//获取部门总数
			int deptCount = service.getRowCount("t_dept", deptName);
			PageUtil pageUtil = new PageUtil(pageCount,loadCount,1,deptCount);			
			//判断是否存在部门
			List<Dept> list = service.getDeptList(deptName,null,pageUtil.getStartRow(), loadCount);
			if(list != null) {
				//请求转发
				req.setAttribute("deptName", deptName);
				req.setAttribute("pageCount", pageCount);
				req.setAttribute("totalPage",pageUtil.getPageCount());
				req.setAttribute("deptList",list);
				req.getRequestDispatcher("page/user/deptList.jsp").forward(req, resp);
			}
		}
	}		
}
