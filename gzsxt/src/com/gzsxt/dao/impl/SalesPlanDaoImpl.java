package com.gzsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gzsxt.dao.SalesPlanDao;
import com.gzsxt.domain.Salplan;
import com.gzsxt.util.DBUtil;

public class SalesPlanDaoImpl implements SalesPlanDao{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Salplan salplan = null;
	int result = 0;

	//销售管理——销售计划
	@Override
	public List<Salplan> getSalePlanList(String str) {
		//创建数据库连接对象
		 conn = DBUtil.open(false);
		 //创建sql语句
		 String sql = "SELECT * FROM `t_salplan`";
		 if(str!=null){
			 sql+=" WHERE pname LIKE '%"+str+"%'";
		 }
		 //进行查询
		 rs = DBUtil.dbExecuteQuery(conn, sql, null);
		 ArrayList<Salplan> salplanlist = new ArrayList<>();
		 try {
			while(rs.next()){
				salplan = new Salplan();
				salplan.setSpno(rs.getString("spno"));
				salplan.setPname(rs.getString("pname"));
				salplan.setPlanmonth(rs.getString("planmonth"));
				salplan.setPstatus(rs.getInt("pstatus"));
				salplan.setContext(rs.getString("context"));
				salplan.setCreatetime(rs.getTimestamp("createtime"));
				salplan.setLastaltertime(rs.getTimestamp("lastaltertime"));
				salplan.setAuditor(rs.getString("auditor"));
				salplanlist.add(salplan);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close2(conn, ps, rs);
		}
		return salplanlist;
	}

	
	//销售管理——添加计划
	@Override
	public int addSalePlan(String spno,String planmonth,Integer status,String pname,String context,String auditor) {
		//创建连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "INSERT INTO t_salplan(spno,planmonth,pstatus,pname,context,createtime,lastaltertime,auditor)VALUES(?,?,?,?,?,NOW(),NOW(),?)";
		Object[] obj = {spno,planmonth,status,pname,context,auditor};
		result = DBUtil.dbExecuteUpdata(conn, sql, obj, false);
		
		DBUtil.close2(conn, ps, rs);
		return result;
	}

	
	//销售管理——删除计划
	@Override
	public int delSalePlan(String[] spnoArr) {
		//创建连接
		conn = DBUtil.open(true);
		//创建sql语句
		String sql = "DELETE FROM t_salplan WHERE spno in (";
		for(int i=0;i<spnoArr.length;i++){
			if(i==spnoArr.length-1){
				sql+="?)";
			}else{
				sql+="?,";
			}
		}
		
		try {
			result = DBUtil.dbExecuteUpdata(conn, sql, spnoArr, false);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close2(conn, ps, rs);
		}
		return result;
	}

	//销售管理——查看计划
	@Override
	public Salplan seeSalePlan(String spno) {
		//创建数据库连接对象
		 conn = DBUtil.open(false);
		 //创建sql语句
		 String sql = "SELECT * FROM `t_salplan` WHERE spno=?";
		 Object[] obj = {spno};
		 //进行查询
		 rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		 try {
			while(rs.next()){
				salplan = new Salplan();
				salplan.setSpno(rs.getString("spno"));
				salplan.setPname(rs.getString("pname"));
				salplan.setPlanmonth(rs.getString("planmonth"));
				salplan.setPstatus(rs.getInt("pstatus"));
				salplan.setContext(rs.getString("context"));
				salplan.setCreatetime(rs.getTimestamp("createtime"));
				salplan.setLastaltertime(rs.getTimestamp("lastaltertime"));
				salplan.setAuditor(rs.getString("auditor"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close2(conn, ps, rs);
		}
		return salplan;
	}

	//销售管理——修改计划
	@Override
	public int updataSalePlan(String spno,String planmonth,Integer status,String pname,String context) {
		//创建连接
		Connection conn = DBUtil.open(true);
		//创建sql语句
		String sql = "UPDATE t_salplan SET planmonth=?, pstatus=?, pname=?, context=? WHERE spno=?";
		//参数数组
		Object[] obj = {planmonth,status,pname,context,spno};
		//进行更新
		result = DBUtil.dbExecuteUpdata(conn, sql, obj, false);
		
		return result;
	}

	//销售管理——查询上级
	@Override
	public String getAuditorName(String roleno) {
		String auditor = null;
		//创建连接
		Connection conn = DBUtil.open(true);
		//创建sql语句
		String sql ="SELECT u.t_realname "
						+"FROM t_role r "
						+"INNER JOIN t_user u "
						+"ON r.r_leader_no=u.t_roleno "
						+"WHERE r.r_roleno=?";
		//参数数组
		Object[] obj = {roleno};
		//查询
		ResultSet rs = DBUtil.dbExecuteQuery(conn, sql, obj);
		
		try {
			while(rs.next()){
				auditor = rs.getString("t_realname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auditor;
	}


	//提交计划
	@Override
	public int submitSalePlan(String[] spnoArr) {
		//创建连接对象
		Connection conn = DBUtil.open(true);
		//创建sql语句
		String sql = "UPDATE t_salplan SET pstatus=pstatus+1 WHERE spno in(";
		for(int i=0;i<spnoArr.length;i++){
			if(i==spnoArr.length-1){
				sql+="?)";
			}else{
				sql+="?,";
			}
		}
		result = DBUtil.dbExecuteUpdata(conn, sql, spnoArr, false);
		
		return result;
	}
}
