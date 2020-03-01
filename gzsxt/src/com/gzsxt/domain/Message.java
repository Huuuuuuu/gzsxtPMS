package com.gzsxt.domain;

//消息类
public class Message {
	
	private int id;
	private String info;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Message(int id, String info) {
		super();
		this.id = id;
		this.info = info;
	}

	public Message() {
		super();
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", info=" + info + "]";
	}

}
