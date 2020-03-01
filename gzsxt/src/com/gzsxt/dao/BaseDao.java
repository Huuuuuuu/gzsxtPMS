package com.gzsxt.dao;

import java.sql.Connection;
import java.util.List;

import com.gzsxt.domain.Dept;
import com.gzsxt.domain.Role;
import com.gzsxt.domain.User;

public interface BaseDao {
	//A1.用户登录
	public User login(String username,String password);
	//A2.获取指定用户
	public User getUser(int id);
	//B1.角色管理——角色列表
	public List<Role> getRoleList(String roleName,int rolePageCount,int rolePieceCount);
	//B2.角色管理——角色删除
	public int roleRemove(int roleid);
	//B3.角色管理——角色信息
	public Role getRole(int roleid);
	//B4.角色管理——角色修改
	public int roleReplace(Connection conn,int roleid,String roleno,String roleName,String deptno,String remarks,int operator);
	//B5.角色管理——角色添加
	public int roleAdd(Connection conn,String roleno,String roleName,String deptno,String remarks,String introduce,int operator);
	//C1.部门列表
	public List<Dept> getDeptList(String deptName,String deptno,int deptPageCount,int deptPieceCount);
	//C2.获取指定部门
	public Dept getDept(String deptno);
	//获取指定数据库表table的数据总量的通用类
	public int getRowCount(String tableName,String reqObject);
}
