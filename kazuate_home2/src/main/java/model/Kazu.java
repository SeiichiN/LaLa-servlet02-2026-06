package model;

import java.io.Serializable;

public class Kazu implements Serializable {
	private int com;
	private int user;
	private String msg;
	public Kazu() { }
	public int getCom() {
		return com;
	}
	public void setCom(int com) {
		this.com = com;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
