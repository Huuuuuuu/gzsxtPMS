package com.gzsxt.domain;
//部门类

import java.util.Date;

public class Dept {

	private int d_id; // 部门id
	private String d_deptno; // 部门编号
	private String d_name; // 部门名称
	private String d_address; // 部门地址
	private String d_introduce; // 部门简介
	private String d_remarks; // 备注说明
	private int d_operator; // 操作人id
	private Date d_setup_time; // 部门创建时间
	private Date d_last_time; // 最后修改时间
	
	public Dept() {
		// TODO 自动生成的构造函数存根
	}

	public Dept(int d_id, String d_deptno, String d_name, String d_address, String d_introduce, String d_remarks,
			int d_operator, Date d_setup_time, Date d_last_time) {
		super();
		this.d_id = d_id;
		this.d_deptno = d_deptno;
		this.d_name = d_name;
		this.d_address = d_address;
		this.d_introduce = d_introduce;
		this.d_remarks = d_remarks;
		this.d_operator = d_operator;
		this.d_setup_time = d_setup_time;
		this.d_last_time = d_last_time;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_deptno() {
		return d_deptno;
	}

	public void setD_deptno(String d_deptno) {
		this.d_deptno = d_deptno;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getD_address() {
		return d_address;
	}

	public void setD_address(String d_address) {
		this.d_address = d_address;
	}

	public String getD_introduce() {
		return d_introduce;
	}

	public void setD_introduce(String d_introduce) {
		this.d_introduce = d_introduce;
	}

	public String getD_remarks() {
		return d_remarks;
	}

	public void setD_remarks(String d_remarks) {
		this.d_remarks = d_remarks;
	}

	public int getD_operator() {
		return d_operator;
	}

	public void setD_operator(int d_operator) {
		this.d_operator = d_operator;
	}

	public Date getD_setup_time() {
		return d_setup_time;
	}

	public void setD_setup_time(Date d_setup_time) {
		this.d_setup_time = d_setup_time;
	}

	public Date getD_last_time() {
		return d_last_time;
	}

	public void setD_last_time(Date d_last_time) {
		this.d_last_time = d_last_time;
	}

	@Override
	public String toString() {
		return "Dept [d_id=" + d_id + ", d_deptno=" + d_deptno + ", d_name=" + d_name + ", d_address=" + d_address
				+ ", d_introduce=" + d_introduce + ", d_remarks=" + d_remarks + ", d_operator=" + d_operator
				+ ", d_setup_time=" + d_setup_time + ", d_last_time=" + d_last_time + "]";
	}
	
	

}
