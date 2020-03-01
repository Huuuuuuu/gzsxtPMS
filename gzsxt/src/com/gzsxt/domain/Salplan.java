package com.gzsxt.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Salplan {
	private String spno;
	private String planmonth;
	private Integer pstatus;
	private String pname;
	private String context;
	private java.sql.Timestamp createtime;
	private java.sql.Timestamp lastaltertime;
	private String auditor;
	
	public Salplan() {
		// TODO 自动生成的构造函数存根
	}

	public Salplan(String spno, String planmonth, Integer pstatus, String pname, String context, Timestamp createtime,
			Timestamp lastaltertime, String auditor) {
		super();
		this.spno = spno;
		this.planmonth = planmonth;
		this.pstatus = pstatus;
		this.pname = pname;
		this.context = context;
		this.createtime = createtime;
		this.lastaltertime = lastaltertime;
		this.auditor = auditor;
	}

	public String getSpno() {
		return spno;
	}

	public void setSpno(String spno) {
		this.spno = spno;
	}

	public String getPlanmonth() {
		return planmonth;
	}

	public void setPlanmonth(String planmonth) {
		this.planmonth = planmonth;
	}

	public Integer getPstatus() {
		return pstatus;
	}

	public void setPstatus(Integer pstatus) {
		this.pstatus = pstatus;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}

	public java.sql.Timestamp getLastaltertime() {
		return lastaltertime;
	}

	public void setLastaltertime(java.sql.Timestamp lastaltertime) {
		this.lastaltertime = lastaltertime;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	@Override
	public String toString() {
		return "Salplan [spno=" + spno + ", planmonth=" + planmonth + ", pstatus=" + pstatus + ", pname=" + pname
				+ ", context=" + context + ", createtime=" + createtime + ", lastaltertime=" + lastaltertime
				+ ", auditor=" + auditor + "]";
	}

}
