package com.gzsxt.service;

import java.util.List;

import com.gzsxt.domain.Salplan;

public interface SalesPlanService {
	//获取销售计划表
	public List<Salplan> getSalePlanList(String str);
	//添加销售计划
	public int addSalePlan(String spno,String planmonth,Integer status,String pname,String context,String auditor);
	//删除销售计划
	public int delSalePlan(String[] spnoArr);
	//查看销售计划
	public Salplan seeSalePlan(String spno); 
	//修改销售计划
	public int updatSalePlan(String spno,String planmonth,Integer status,String pname,String context);
	//查询上级名称
	public String getAuditorName(String roleno);
	//提交计划
	public int submitSalePlan(String[] spnoArr);
	
}
