package com.gzsxt.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzsxt.domain.Salplan;
import com.gzsxt.domain.User;
import com.gzsxt.service.impl.SalesPlanServiceImpl;

@WebServlet("/spservlet")
public class SalesPlanServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
			
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取服务对象
				SalesPlanServiceImpl salePlanService = new SalesPlanServiceImpl();
				//获取标识参数
				String cmd = req.getParameter("cmd");
				
				//销售管理——销售计划列表
				if("salplanlist".equals(cmd)){
					//调用业务
					List<Salplan> salePlanList = salePlanService.getSalePlanList(null);
					//将结果存入域对象
					req.setAttribute("salesPlanList", salePlanList);
					//请求转发
					req.getRequestDispatcher("page/sales/salplan.jsp").forward(req, resp);
				}
				
				
				//销售管理——添加销售计划
				if("addplan".equals(cmd)){
					//获取登录对象
					User user = (User)req.getSession().getAttribute("user");
					//获取对象信息
					String pname = user.getT_realname();
					String roleno = user.getT_roleno();
					String auditor = salePlanService.getAuditorName(roleno);
					
					//获取提交信息
					String spno = req.getParameter("spno");
					String planmonth = req.getParameter("planmonth");
					String context = req.getParameter("context");
					
					
					int status = 0;
					
					if(spno==""||planmonth==""||context==""){
						resp.getWriter().append("0");
					}else{
						//调用业务
						int result = salePlanService.addSalePlan(spno, planmonth, status, pname, context,auditor);
						System.out.println("添加情况"+result);
						resp.getWriter().append(result+"");
					}
					
				}
				
				//销售管理——删除销售计划
				if("delplan".equals(cmd)){
					String spnoArrStr = req.getParameter("spnoArrStr");
					String[] spnoArr = spnoArrStr.split(",");
					
					if(spnoArr!=null){
						//调用业务——删除计划
						int result = salePlanService.delSalePlan(spnoArr);
						resp.getWriter().append(result+"");
					}else{
						resp.getWriter().append("0");
					}
				}
				
				//销售管理——查看销售计划
				if("seeplan".equals(cmd)||"getplan".equals(cmd)){
					String spno = req.getParameter("spno");
					if(spno!=null){
						//调用业务——查看计划
						Salplan plan = salePlanService.seeSalePlan(spno);
						req.setAttribute("plan", plan);
						//请求转发
						if("seeplan".equals(cmd)){
							req.getRequestDispatcher("/page/sales/salplancontext.jsp").forward(req, resp);
						}else if("getplan".equals(cmd)){
							req.getRequestDispatcher("/page/sales/alterplan.jsp").forward(req, resp);
						}
						
					}
				}
				
				//销售管理——修改销售计划
				if("alterplan".equals(cmd)){
					String spno = req.getParameter("spno");
					String pname = req.getParameter("pname");
					int pstatus = Integer.parseInt(req.getParameter("pstatus"));
					String planmonth = req.getParameter("planmonth");
					String context = req.getParameter("context");
					//调用业务层——更新销售计划
					int result = salePlanService.updatSalePlan(spno, planmonth, pstatus, pname, context);
					resp.getWriter().append(""+result);
				}
				
				//销售管理——模糊查询
				if("sltlike".equals(cmd)){
					String sltval = req.getParameter("sltval");
					List<Salplan> salePlanList = salePlanService.getSalePlanList(sltval);
					//将结果
					req.setAttribute("salesPlanList", salePlanList);
					//请求转发
					req.getRequestDispatcher("/page/sales/salplan.jsp").forward(req, resp);
				}
				
				//销售管理——提交计划
				if("submitplan".equals(cmd)){
					String spnoArrStr = req.getParameter("spnoArrStr");
					String[] spnoArr = spnoArrStr.split(",");
					
					int result = salePlanService.submitSalePlan(spnoArr);
					resp.getWriter().append(""+result);
				}
		
				
	}

}
