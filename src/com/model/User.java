package com.model;

public class User {
	private String uid;
	private String password;
	private int status;
	private String name;
	private String banji;
	private String yuanxi;
	private float finals;
	private float refinals;
	private int ispass;
	
	public void setIspass(int ispass){
		this.ispass=ispass;
	}
	public int getIspass(){
		return ispass;
	}

	public void setFinals(float finals) {
		this.finals = finals;
	}

	public float getFinals() {
		return finals;
	}

	public void setRefinals(float refinals) {
		this.refinals = refinals;
	}

	public float getRefinals() {
		return refinals;
	}

	public void setYuanxi(String yuanxi) {
		this.yuanxi = yuanxi;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getYuanxi() {
		return yuanxi;
	}

	public String getBanji() {
		return banji;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUid() {
		return uid;
	}

	public String getPassword() {
		return password;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
