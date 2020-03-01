package com.gzsxt.domain;

import java.util.Date;

//角色类
public class Role {

	private int r_id; // 角色id
	private String r_name; // 角色名
	private String r_roleno; // 角色编号
	private String r_deptno; // 部门编号
	private String r_introduce; // 角色简介
	private String r_remarks; // 备注说明
	private int r_operator; // 操作人id
	private Date r_setup_time; // 部门创建时间
	private Date r_last_time; // 最后修改时间
	private User user;
	private Dept dept;
	private String r_leader_no;
	
	public Role() {
		// TODO 自动生成的构造函数存根
	}

	public Role(int r_id, String r_name, String r_roleno, String r_deptno, String r_introduce, String r_remarks,
			int r_operator, Date r_setup_time, Date r_last_time, User user, Dept dept, String r_leader_no) {
		super();
		this.r_id = r_id;
		this.r_name = r_name;
		this.r_roleno = r_roleno;
		this.r_deptno = r_deptno;
		this.r_introduce = r_introduce;
		this.r_remarks = r_remarks;
		this.r_operator = r_operator;
		this.r_setup_time = r_setup_time;
		this.r_last_time = r_last_time;
		this.user = user;
		this.dept = dept;
		this.r_leader_no = r_leader_no;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_roleno() {
		return r_roleno;
	}

	public void setR_roleno(String r_roleno) {
		this.r_roleno = r_roleno;
	}

	public String getR_deptno() {
		return r_deptno;
	}

	public void setR_deptno(String r_deptno) {
		this.r_deptno = r_deptno;
	}

	public String getR_introduce() {
		return r_introduce;
	}

	public void setR_introduce(String r_introduce) {
		this.r_introduce = r_introduce;
	}

	public String getR_remarks() {
		return r_remarks;
	}

	public void setR_remarks(String r_remarks) {
		this.r_remarks = r_remarks;
	}

	public int getR_operator() {
		return r_operator;
	}

	public void setR_operator(int r_operator) {
		this.r_operator = r_operator;
	}

	public Date getR_setup_time() {
		return r_setup_time;
	}

	public void setR_setup_time(Date r_setup_time) {
		this.r_setup_time = r_setup_time;
	}

	public Date getR_last_time() {
		return r_last_time;
	}

	public void setR_last_time(Date r_last_time) {
		this.r_last_time = r_last_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getR_leader_no() {
		return r_leader_no;
	}

	public void setR_leader_no(String r_leader_no) {
		this.r_leader_no = r_leader_no;
	}

	@Override
	public String toString() {
		return "Role [r_id=" + r_id + ", r_name=" + r_name + ", r_roleno=" + r_roleno + ", r_deptno=" + r_deptno
				+ ", r_introduce=" + r_introduce + ", r_remarks=" + r_remarks + ", r_operator=" + r_operator
				+ ", r_setup_time=" + r_setup_time + ", r_last_time=" + r_last_time + ", user=" + user + ", dept="
				+ dept + ", r_leader_no=" + r_leader_no + "]";
	}
	
	

}
