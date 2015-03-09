package com.model;

public class Paper {
	String paper_user;
	String paper_timu;
	int blank_num;
	int operate_num;
	int select_num;
	int blank_value;
	int operate_value;
	int select_value;
	int paper_type;
	public void setPp(int pp){
		this.paper_type=pp;
	}
	public int getPp(){
		return paper_type;
	}
	public void setPu(String pu){
		this.paper_user=pu;
	}
	public void setPt(String pt){
		this.paper_timu=pt;
	}
	public void setBn(int  bn){
		this.blank_num=bn;
	}
	public void setOn(int on){
		this.operate_num=on;
	}
	public void setSn(int sn){
		this.select_num=sn;
	}
	public void setBv(int bv){
		this.blank_value=bv;
	}
	public void setOv(int ov){
		this.operate_value=ov;
	}
	public void setSv(int sv){
		this.select_value=sv;
	}
	public String getPt(){
		return paper_timu;
	}
	public String getPu(){
		return paper_user;
	}
	public int getBn(){
		return blank_num;
	}
	public int getOn(){
		return operate_num;
	}
	public int getSn(){
		return select_num;
	}
	public int getBv(){
		return blank_value;
	}
	public int getOv(){
		return operate_value;
	}
	public int getSv(){
		return select_value;
	}

}
