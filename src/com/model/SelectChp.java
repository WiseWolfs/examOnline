package com.model;

public class SelectChp {

	private String chp;
	private float chp_r;
	private int id;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setChp(String chp){
		this.chp=chp;
	}
	public void setChp_r(float chp_r){
		this.chp_r=chp_r;
	}
	public String getChp(){
		return chp;
	}
	public float getChp_r(){
		return chp_r;
	}
}
