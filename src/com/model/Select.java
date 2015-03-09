package com.model;

public class Select {
	private int timu_id;
	private String timu;
	private String ans;
	private String a;
	private String b;
	private String c;
	private String d;
	private int chp;
	private int diff;
	public void setChp(int chp){
		this.chp=chp;
	}
	public void setDiff(int diff){
		this.diff=diff;
	}
	public int getChp(){
		return chp;
	}
	public int getDiff(){
		return diff;
	}

	public void setTime_id(int timu_id) {
		this.timu_id = timu_id;
	}

	public void setTimu(String timu) {
		this.timu = timu;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public void setA(String a) {
		this.a = a;
	}

	public void setB(String b) {
		this.b = b;
	}

	public void setC(String c) {
		this.c = c;
	}

	public void setD(String d) {
		this.d = d;
	}

	public int getTimu_id() {
		return timu_id;
	}

	public String getTimu() {
		return timu;
	}

	public String getAns() {
		return ans;
	}

	public String getA() {
		return a;
	}

	public String getB() {
		return b;
	}

	public String getC() {
		return c;
	}

	public String getD() {
		return d;
	}
}
