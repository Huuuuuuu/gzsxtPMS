package com.gzsxt.dao;

import java.util.List;

import com.gzsxt.domain.Salplan;

public interface SalesPlanDao {
	//销售管理——销售计划列表
	public List<Salplan> getSalePlanList(String str);
	//销售管理——添加计划
	public int addSalePlan(String spno,String planmonth,Integer status,String pname,String context,String auditor);
	//销售管理——删除计划
	public int delSalePlan(String[] spnoArr);
	//销售管理——查看计划
	public Salplan seeSalePlan(String spno);
	//销售管理——修改计划
	public int updataSalePlan(String spno,String planmonth,Integer status,String pname,String context);
	//销售管理——查询上级
	public String  getAuditorName(String roleno);
	//销售管理——提交计划
	public int submitSalePlan(String[] spnoArr);
	
}
