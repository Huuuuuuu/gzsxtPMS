package com.gzsxt.domain;

import java.util.Date;

//用户类
public class User {

	private int t_id; // 用户id
	private String t_username; // 用户名
	private String t_realname; // 真实姓名
	private String t_password; // 密码
	private int t_gender; // 性别
	private String t_email; // 邮箱
	private String t_phone; // 电话
	private String t_deptno; // 部门编号
	private String t_roleno; // 职位编号
	private String t_header_path; // 头像路径
	private Date t_reg_time; // 注册时间
	private int t_um_count; // 用户名修改次数

	public User() {
		// TODO 自动生成的构造函数存根
	}

	public User(int t_id, String t_username, String t_realname, String t_password, int t_gender, String t_email,
			String t_phone, String t_deptno, String t_roleno, String t_header_path, Date t_reg_time, int t_um_count) {
		super();
		this.t_id = t_id;
		this.t_username = t_username;
		this.t_realname = t_realname;
		this.t_password = t_password;
		this.t_gender = t_gender;
		this.t_email = t_email;
		this.t_phone = t_phone;
		this.t_deptno = t_deptno;
		this.t_roleno = t_roleno;
		this.t_header_path = t_header_path;
		this.t_reg_time = t_reg_time;
		this.t_um_count = t_um_count;
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_username() {
		return t_username;
	}

	public void setT_username(String t_username) {
		this.t_username = t_username;
	}

	public String getT_realname() {
		return t_realname;
	}

	public void setT_realname(String t_realname) {
		this.t_realname = t_realname;
	}

	public String getT_password() {
		return t_password;
	}

	public void setT_password(String t_password) {
		this.t_password = t_password;
	}

	public int getT_gender() {
		return t_gender;
	}

	public void setT_gender(int t_gender) {
		this.t_gender = t_gender;
	}

	public String getT_email() {
		return t_email;
	}

	public void setT_email(String t_email) {
		this.t_email = t_email;
	}

	public String getT_phone() {
		return t_phone;
	}

	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}

	public String getT_deptno() {
		return t_deptno;
	}

	public void setT_deptno(String t_deptno) {
		this.t_deptno = t_deptno;
	}

	public String getT_roleno() {
		return t_roleno;
	}

	public void setT_roleno(String t_roleno) {
		this.t_roleno = t_roleno;
	}

	public String getT_header_path() {
		return t_header_path;
	}

	public void setT_header_path(String t_header_path) {
		this.t_header_path = t_header_path;
	}

	public Date getT_reg_time() {
		return t_reg_time;
	}

	public void setT_reg_time(Date t_reg_time) {
		this.t_reg_time = t_reg_time;
	}

	public int getT_um_count() {
		return t_um_count;
	}

	public void setT_um_count(int t_um_count) {
		this.t_um_count = t_um_count;
	}

	@Override
	public String toString() {
		return "User [t_id=" + t_id + ", t_username=" + t_username + ", t_realname=" + t_realname + ", t_password="
				+ t_password + ", t_gender=" + t_gender + ", t_email=" + t_email + ", t_phone=" + t_phone
				+ ", t_deptno=" + t_deptno + ", t_roleno=" + t_roleno + ", t_header_path=" + t_header_path
				+ ", t_reg_time=" + t_reg_time + ", t_um_count=" + t_um_count + "]";
	}
	
	
	
}
