package com.gzsxt.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.gzsxt.dao.SalesPlanDao;
import com.gzsxt.dao.impl.SalesPlanDaoImpl;
import com.gzsxt.domain.Salplan;
import com.gzsxt.service.SalesPlanService;

public class SalesPlanServiceImpl implements SalesPlanService {
	
	SalesPlanDao spdao = new SalesPlanDaoImpl();
	
	//销售管理——销售计划列表
	@Override
	public List<Salplan> getSalePlanList(String str) {
		return spdao.getSalePlanList(str);
	}
	//销售管理——添加销售计划
	@Override
	public int addSalePlan(String spno,String planmonth,Integer status,String pname,String context,String auditor) {
		return spdao.addSalePlan(spno, planmonth, status, pname, context, auditor);
	}
	//销售管理——删除销售计划
	@Override
	public int delSalePlan(String[] spnoArr) {
		return spdao.delSalePlan(spnoArr);
	}
	//销售管理——查看销售计划
	@Override
	public Salplan seeSalePlan(String spno) {
		return spdao.seeSalePlan(spno);
	}
	//销售管理——修改销售计划
	@Override
	public int updatSalePlan(String spno, String planmonth, Integer status, String pname, String context) {
		return spdao.updataSalePlan(spno, planmonth, status, pname, context);
	}
	@Override
	public String getAuditorName(String roleno) {
		return spdao.getAuditorName(roleno);
	}
	@Override
	public int submitSalePlan(String[] spnoArr) {
		return spdao.submitSalePlan(spnoArr);
	}

}
