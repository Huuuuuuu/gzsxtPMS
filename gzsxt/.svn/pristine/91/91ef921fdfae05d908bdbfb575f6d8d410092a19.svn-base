package com.gzsxt.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gzsxt.dao.BaseDao;
import com.gzsxt.dao.impl.BaseDaoImpl;
import com.gzsxt.domain.Dept;
import com.gzsxt.domain.Role;
import com.gzsxt.domain.User;
import com.gzsxt.service.UserService;
import com.gzsxt.util.ConfigUtil;
import com.gzsxt.util.DBUtil;
import com.gzsxt.util.PageUtil;

public class UserServiceImpl implements UserService{

	//创建service对象
	BaseDao dao = new BaseDaoImpl();
	//初始化对象
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int result = 0;
	
	//A1.用户登录
	public User login(String username,String password) {
		return dao.login(username, password);
	}
	//A2.获取指定用户
	public User getUser(int id){
		return dao.getUser(id);
	}
	//B1.角色管理——角色列表
	public List<Role> getRoleList(String roleName,int rolePageCount,int rolePieceCount){
		return dao.getRoleList(roleName, rolePageCount, rolePieceCount);
	}
	//B2.角色管理——角色删除
	public int roleRemove(int roleid){
		return dao.roleRemove(roleid);
	}
	//B3.角色管理——获取指定角色的信息
	public Role getRole(int roleid){
		return dao.getRole(roleid);
	}
	//B4.角色管理——角色修改
	public int roleReplace(Connection conn,int roleid, String roleno, String roleName, String deptno, String remarks,int operator) {
		//创建数据库连接
		conn = DBUtil.open(false);
		result = dao.roleReplace(conn,roleid, roleno, roleName, deptno, remarks,operator);
		try {
			if(result == 1) {			
				//提交
				conn.commit();
			}else {
				//回滚
				conn.rollback();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return result;
	}
	//B5.角色管理——角色添加
	public int roleAdd(Connection conn,String roleno, String roleName, String deptno, String remarks,
			String introduce, int operator) {
		//创建数据库连接
		conn = DBUtil.open(false);
		//执行添加
		result = dao.roleAdd(conn, roleno, roleName, deptno, remarks, introduce, operator);
		try {
			if(result == 1) {
				//提交
				conn.commit();
			}else {
				//回滚
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return result;
	}
	//C1.部门列表
	public List<Dept> getDeptList(String deptName,String deptno,int deptPageCount,int deptPieceCount){
		return dao.getDeptList(deptName,deptno,deptPageCount, deptPieceCount);
	}
	//C2.获取指定部门
	public Dept getDept(String deptno){
		return dao.getDept(deptno);
	}
	//获取指定数据库表table的数据总量的通用类
	public int getRowCount(String tableName, String reqObject) {
		return dao.getRowCount(tableName, reqObject);
	}
		
}
