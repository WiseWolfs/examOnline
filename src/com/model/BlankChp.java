package com.model;

public class BlankChp {
	private int id;//章节号
	private float chp_r;//章节比重
	private String chp;//章节名称
	
	public void setId(int id){
		this.id=id;
	}
	public void setChp_r(float chp_r){
		this.chp_r=chp_r;
	}
	public void setChp(String chp){
		this.chp=chp;
	}
	
	public String getChp(){
		return chp;
	}
	public float getChp_r(){
		return chp_r;
	}
	public int getId(){
		return id;
	}

}
