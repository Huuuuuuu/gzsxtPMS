package com.gzsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gzsxt.dao.BaseDao;
import com.gzsxt.domain.Dept;
import com.gzsxt.domain.Role;
import com.gzsxt.domain.User;
import com.gzsxt.util.ConfigUtil;
import com.gzsxt.util.DBUtil;
import com.gzsxt.util.PageUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class BaseDaoImpl implements BaseDao{

	//初始化对象
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	User user = null;
	Role role = null;
	Dept dept = null;
	int result = 0;
	
	//1.用户登录
	@Override
	public User login(String username, String password) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "SELECT * FROM t_user WHERE t_username = ? AND t_password = ?";
		Object[] obj = {username,password};	
		try {
			//发送sql
			rs = DBUtil.dbExecuteQuery(conn, sql, obj);
			//判断是否存在此用户，存在则创建User对象
			if(rs.next()) {
				//创建User对象
				user = new User();
				user.setT_id(rs.getInt("t_id"));
				user.setT_username(rs.getString("t_username"));
				user.setT_realname(rs.getString("t_realname"));
				user.setT_password(rs.getString("t_password"));
				user.setT_gender(rs.getInt("t_gender"));
				user.setT_email(rs.getString("t_email"));
				user.setT_phone(rs.getString("t_phone"));
				user.setT_deptno(rs.getString("t_deptno"));
				user.setT_roleno(rs.getString("t_roleno"));
				user.setT_header_path(rs.getString("t_header_path"));
				user.setT_reg_time(rs.getDate("t_reg_time"));
				user.setT_um_count(rs.getInt("t_um_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return user;
	}
	//2.获取指定用户
	@Override
	public User getUser(int id) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "SELECT * FROM t_user WHERE t_id = ?";
		Object[] obj = {id};	
		try {
			//发送sql
			rs = DBUtil.dbExecuteQuery(conn, sql, obj);
			//判断是否存在此用户，存在则创建User对象
			if(rs.next()) {
				//创建User对象
				user = new User();
				user.setT_id(rs.getInt("t_id"));
				user.setT_username(rs.getString("t_username"));
				user.setT_realname(rs.getString("t_realname"));
				user.setT_password(rs.getString("t_password"));
				user.setT_gender(rs.getInt("t_gender"));
				user.setT_email(rs.getString("t_email"));
				user.setT_phone(rs.getString("t_phone"));
				user.setT_deptno(rs.getString("t_deptno"));
				user.setT_roleno(rs.getString("t_roleno"));
				user.setT_header_path(rs.getString("t_header_path"));
				user.setT_reg_time(rs.getDate("t_reg_time"));
				user.setT_um_count(rs.getInt("t_um_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//B1.角色列表
	@Override
	public List<Role> getRoleList(String name, int rolePageCount, int rolePieceCount) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		//判断参数name是否为空
		if(name == null) {
			sql = "SELECT * FROM t_role ORDER BY r_deptno LIMIT ?,?";
			list.add(rolePageCount);
			list.add(rolePieceCount);
		}else {
			sql = "SELECT * FROM t_role WHERE r_name LIKE ? ORDER BY r_deptno LIMIT ?,?";
			list.add("%"+name+"%");
			list.add(rolePageCount);
			list.add(rolePieceCount);
		}
		Object[] obj = list.toArray();
		//发送sql
		rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		//获取role集
		List<Role> roleList = new ArrayList<Role>();
		//创建BaseDao对象 DeptDao对象
		BaseDao dao = new BaseDaoImpl(); 
		try {
			while(rs.next()) {
				role = new Role();
				role.setR_id(rs.getInt("r_id"));
				role.setR_roleno(rs.getString("r_roleno"));
				role.setR_name(rs.getString("r_name"));
				role.setR_deptno(rs.getString("r_deptno"));
				role.setR_introduce(rs.getString("r_introduce"));
				role.setR_remarks(rs.getString("r_remarks"));
				role.setR_operator(rs.getInt("r_operator"));
				role.setR_setup_time(rs.getDate("r_setup_time"));
				role.setR_last_time(rs.getDate("r_last_time"));
				role.setUser(dao.getUser(rs.getInt("r_operator")));
				role.setDept(dao.getDept(rs.getString("r_deptno")));
				//将role对象存入list中
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return roleList;
	}
	//B2.角色管理——角色删除
	@Override
	public int roleRemove(int roleid) {
		//初始化变量
		int result = 0;
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "DELETE FROM t_role WHERE r_id = ?";
		Object[] obj = {roleid};
		//执行sql
		result = DBUtil.dbExecuteUpdata(conn, sql, obj, true);
		//关闭数据库连接
		DBUtil.close2(conn, stmt, rs);
		return result;
	}
	//B3.角色管理——获取指定角色的信息
	@Override
	public Role getRole(int roleid) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "SELECT * FROM t_role WHERE r_id = ?";		
		Object[] obj = {roleid};
		//发送sql
		rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		//创建BaseDao对象 DeptDao对象
		BaseDao dao = new BaseDaoImpl(); 
		try {
			if(rs.next()) {
				role = new Role();
				role.setR_id(rs.getInt("r_id"));
				role.setR_roleno(rs.getString("r_roleno"));
				role.setR_name(rs.getString("r_name"));
				role.setR_deptno(rs.getString("r_deptno"));
				role.setR_introduce(rs.getString("r_introduce"));
				role.setR_remarks(rs.getString("r_remarks"));
				role.setR_operator(rs.getInt("r_operator"));
				role.setR_setup_time(rs.getDate("r_setup_time"));
				role.setR_last_time(rs.getDate("r_last_time"));
				role.setDept(dao.getDept(rs.getString("r_deptno")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return role;
	}
	//B4.角色管理——角色修改
	@Override
	public int roleReplace(Connection conn,int roleid, String roleno, String roleName, String deptno, String remarks,int operator) {
		//创建数据库连接
		if(conn == null) {
			conn = DBUtil.open(true);
		}
		//创建sql
		String sql = "UPDATE t_role SET r_roleno=?,r_name=?,r_deptno=?,r_remarks=?,r_last_time=?,r_operator=? WHERE r_id=?";
		//绑定参数
		List<Object> list = new ArrayList<Object>();
		list.add(roleno);
		list.add(roleName);
		list.add(deptno);
		list.add(remarks);
		list.add(new Date());
		list.add(operator);
		list.add(roleid);
		Object[] obj = list.toArray();
		//发送sql
		result = DBUtil.dbExecuteUpdata(conn, sql, obj, false);
		return result;
	}
	//B5.角色管理——角色添加
	@Override
	public int roleAdd(Connection conn,String roleno, String roleName, String deptno, String remarks,
			String introduce, int operator) {
		//创建数据库连接
		if(conn == null) {
			conn = DBUtil.open(false);
		}
		//创建sql
		String sql = "INSERT INTO t_role(r_roleno,r_name,r_deptno,r_remarks,r_introduce,r_operator,r_setup_time,r_last_time) VALUES(?,?,?,?,?,?,?,?)";
		//绑定参数
		List<Object> list = new ArrayList<Object>();
		list.add(roleno);
		list.add(roleName);
		list.add(deptno);
		list.add(remarks);
		list.add(introduce);
		list.add(operator);
		list.add(new Date());
		list.add(new Date());
		Object[] obj = list.toArray();
		//发送sql
		result = DBUtil.dbExecuteUpdata(conn, sql, obj, false);
		return result;
	}
	
	
	//C1.部门列表
	@Override
	public List<Dept> getDeptList(String deptName,String deptno,int deptPageCount, int deptPieceCount) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		//判断参数name是否为空
		if(deptName == null) {
			if(deptno == null) {
				sql = "SELECT * FROM t_dept LIMIT ?,?";
				list.add(deptPageCount);
				list.add(deptPieceCount);
			}else {
				sql = "SELECT * FROM t_dept WHERE d_deptno != ? LIMIT ?,?";
				list.add(deptno);
				list.add(deptPageCount);
				list.add(deptPieceCount);
			}
		}else {
			sql = "SELECT * FROM t_dept WHERE d_name LIKE ? LIMIT ?,?";
			list.add("%"+deptName+"%");
			list.add(deptPageCount);
			list.add(deptPieceCount);
		}
		Object[] obj = list.toArray();
		//发送sql
		rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		//获取dept集
		List<Dept> deptList = new ArrayList<Dept>();
		try {
			while(rs.next()) {
				dept = new Dept();
				dept.setD_id(rs.getInt("d_id"));
				dept.setD_name(rs.getString("d_name"));
				dept.setD_deptno(rs.getString("d_deptno"));
				dept.setD_address(rs.getString("d_address"));
				dept.setD_introduce(rs.getString("d_introduce"));
				dept.setD_remarks(rs.getString("d_remarks"));
				dept.setD_operator(rs.getInt("d_operator"));
				dept.setD_setup_time(rs.getDate("d_setup_time"));
				dept.setD_last_time(rs.getDate("d_last_time"));
				//将role对象存入list中
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭数据库连接
			DBUtil.close2(conn, stmt, rs);
		}
		return deptList;
	}
	//C2.获取指定部门的信息
	@Override
	public Dept getDept(String deptno) {
		//创建数据库连接
		conn = DBUtil.open(true);
		//创建sql语句	
		String sql = "SELECT * FROM t_dept WHERE d_deptno = ?";	
		Object[] obj = {deptno};	
		try {
			//发送sql
			rs = DBUtil.dbExecuteQuery(conn, sql, obj);
			//判断是否存在数据
			if(rs.next()) {
				//创建Dept对象
				dept = new Dept();
				dept.setD_id(rs.getInt("d_id"));
				dept.setD_deptno(rs.getString("d_deptno"));
				dept.setD_name(rs.getString("d_name"));
				dept.setD_address(rs.getString("d_address"));
				dept.setD_introduce(rs.getString("d_introduce"));
				dept.setD_remarks(rs.getString("d_remarks"));
				dept.setD_operator(rs.getInt("d_operator"));
				dept.setD_setup_time(rs.getDate("d_setup_time"));
				dept.setD_last_time(rs.getDate("d_last_time"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	//获取指定数据库表table的数据总量的通用类
	//参数1：数据库表名tableName，参数2：servlet请求参数reqObject
	@Override
	public int getRowCount(String tableName,String reqObject) {		
		//创建数据库连接
		conn = DBUtil.open(true);
		//初始化变量
		int count = 0;
		String sql = "";
		List<Object> list = new ArrayList<Object>();
		if("t_role".equals(tableName)) {
			//创建sql
			if(reqObject==null || reqObject.length()==0) {
				sql = "SELECT count(*) FROM t_role";			
			}else {
				sql = "SELECT count(*) FROM t_role WHERE r_name LIKE ?";
				list.add("%"+reqObject+"%");
			}
		}else if("t_dept".equals(tableName)) {
			//创建sql
			if(reqObject==null || reqObject.length()==0) {
				sql = "SELECT count(*) FROM t_dept";
			}else {
				sql = "SELECT count(*) FROM t_dept WHERE d_name LIKE ?";
				list.add("%"+reqObject+"%");
			}
		}
		//将list集合转换成数组
		Object[] obj = list.toArray();
		//发送sql
		rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		try {
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
