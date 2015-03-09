package com.test;

public class Character{ //设计字符类
	public String size; //字体大小
	public String color; //字体颜色
	public String name; //字体类型
	public String text; //字符内容
	public String lable; //字体大小
	public String bold;//字体粗细 加粗-1 不加粗0
	public String italic;//字体正斜 倾斜-1 不倾斜0
	public String underline;//字体加下划线为-1，否则为0
	public String BackgroundPatternColor;//字体底纹颜色
	public boolean compare(Character ch){ //字符比较
	if(this.lable.equals(ch.lable))
		return true;
	else
		return false;
	}
	}