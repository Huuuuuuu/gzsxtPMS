package com.gzsxt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzsxt.dao.impl.BaseDaoImpl;
import com.gzsxt.util.DBUtil;

@WebServlet("/cnservlet")
public class CNameServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		Connection conn = DBUtil.open(true);
		//��ѯ���ݿ��Ƿ������ͬ������
		String sql = "select * from t_user where t_realname=?";
		Object[] obj = {name};
		 ResultSet resultSet = DBUtil.dbExecuteQuery(conn, sql, obj);
		
		try {
			if(!resultSet.next()){
				resp.getWriter().append("0");
			}else{
				resp.getWriter().append("1");
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
}
