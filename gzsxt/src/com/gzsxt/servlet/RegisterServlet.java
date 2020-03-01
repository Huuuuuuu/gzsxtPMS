package com.gzsxt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.gzsxt.dao.impl.BaseDaoImpl;
import com.gzsxt.util.DBUtil;


@WebServlet("/regservlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		Connection conn = DBUtil.open(true);
		int result;
		
		BaseDaoImpl baseDaoImp = new BaseDaoImpl();
		String sql = "INSERT INTO t_user(t_realname,t_username,t_password,t_phone,t_email,t_gender,t_deptno,t_roleno,t_reg_time,t_um_count) VALUES(?,?,?,?,?,'0','A','A',NOW(),'0')";
		Object[] obj ={name,username,password,phone,email};
		try {
			result = DBUtil.dbExecuteUpdata(conn, sql, obj, true);
			
			if(result>0){
				ServletContext servletContext = getServletContext();
				//����Ҫ��ֵ���ý������
				servletContext.setAttribute("result", result);
				req.getRequestDispatcher("page/regresult.jsp").forward(req, resp);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			DBUtil.close2(conn, null, null);
		}
	}
}
