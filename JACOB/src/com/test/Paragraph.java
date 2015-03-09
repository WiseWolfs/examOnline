package com.test;

public class Paragraph { // 设计段落类
	public Character[] characters; // 字符类数组
	private int count = 0; // 每段的字符个数
	public String linespacingrule;// 段落的行间距
	public String characterunitleftindent;// 段落的左缩进量
	public String characterunitrightindent;// 段落的右缩进量
	public String lineunitafter;// 段后间距
	public String lineunitbefore;// 段前间距
	public String baselinealignment;// 文本对齐方式
	public String firstlineindent;// 首行缩进的字符
	public String alignment;// 段落的对齐方式
	public String label;
	public Paragraph(){
		
	}
	public Paragraph(int count) {
		this.count = count;
		characters = new Character[this.count];
		
	}

	public int getCount() {
		return this.count;
	}
}