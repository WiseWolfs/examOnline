package com.test;

import java.io.*;

import org.dom4j.*;
import org.dom4j.io.*;

import com.jacob.activeX.*;
import com.jacob.com.*;


public class T {   
	public T(){
		
	}
	
	Paragraph  []paragraph;
	ActiveXComponent app = new ActiveXComponent( "Word.Application"); //啟動word
	  
	public void saveXMLto(String str){
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gbk");
		try {
			XMLWriter writer =new XMLWriter(new FileWriter(new File("12.xml")),format);
		//	 XMLWriter writer = new XMLWriter( new FileWriter( "output.xml" ));
			writer.write(this.createXMLDocument());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public Document createXMLDocument(){
		Document doc=null;
		doc=DocumentHelper.createDocument();
		doc.setXMLEncoding("gb2312");
		T t=new T();
		t.readWord();
		Element root=doc.addElement("Article");//创建根节点
		for(int i=0;i<t.readWord().length;i++){
			Element Paragraph=root.addElement("Paragraph");
			Character []C=new Character[t.readWord()[i].characters.length];
			C=t.readWord()[i].characters;
			Character []S=new Character[t.readWord()[i].characters.length];
			S=C;
			int k=0,count=0;
			for(int j=1;j<C.length;j++){
				if(S[k].compare(C[j])==true){
					S[count].text+=C[j].text;
					S[count].color=C[j].color;
					S[count].lable=C[j].lable;
					S[count].name=C[j].name;
					S[count].size=C[j].size;
					System.out.println(S[j-1].lable+" "+C[j].lable);
				
				}else{
					Element Font=Paragraph.addElement("Font");
					Font.setText(S[count].text);
					Font.addAttribute("Size", S[count].size);
					Font.addAttribute("Color", S[count].color); 
					Font.addAttribute("Name", S[count].name);
					k=j;
					j--;
					count++;
					S[count].text="";
				}
			
		}
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gb2312");
		try {
			XMLWriter writer =new XMLWriter(new FileWriter(new File("c:\\12.xml")),format);
		//	 XMLWriter writer = new XMLWriter( new FileWriter( "output.xml" ));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return doc;
		
		
	}
	public static void main(String args[]){
		T t=new T();
	//	t.readWord();
		t.createXMLDocument();
	}
	
	
		public Paragraph [] readWord(){
		   try {
			 
		       String inFile = "c:\\Word.doc"; //指定要打開的word文件
		       app.setProperty("Visible", new Variant(true)); //為false時設置word不可見，為true時是可見要不然看不到Word打開文件的過程
		       Dispatch docs = app.getProperty("Documents").toDispatch();//打開編輯囂
		       Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method, 
		    		   new Object[] {
		    		   inFile, new Variant(false), new Variant(true)
		    		   } , new int[1]).toDispatch(); //打開word文檔 
		      // int paragraphsCount=Dispatch.get(doc, "Count").toInt(); 
		   
		       Dispatch tables=Dispatch.get(doc, "Tables").toDispatch();
		       Dispatch table=Dispatch.call(tables,"Item",new Variant(1)).toDispatch();
		       Dispatch cols=Dispatch.get(table,"Columns").toDispatch();
		      
		       Dispatch rows = Dispatch.call(table, "Rows").toDispatch();
		       Dispatch tableRange=Dispatch.get(table,"Range").toDispatch();
		       Dispatch borders=Dispatch.get(tableRange,"Borders").toDispatch();
		       String borderStyle=Dispatch.get(borders,"InsideLineWidth").toString();
		       System.out.println(borderStyle+"Style");
		       
		       
		       Dispatch tableFormat=Dispatch.get(tableRange,"ParagraphFormat").toDispatch();
		       String align=Dispatch.get(tableFormat,"Alignment").toString();
		       System.out.println("align"+align);//输出表格的位置
		       
		       
		       int colCount = Dispatch.get(cols, "Count").toInt();
		       System.out.println("表格的cols为"+colCount);
		       for(int p=1;p<=colCount;p++){
		    	   Dispatch col = Dispatch.call(cols, "Item", new Variant(p)).toDispatch();  //循环出每一列
		    	   Dispatch cells=Dispatch.get(col, "Cells").toDispatch();//当前列中单元格
		    	   int cellCount = Dispatch.get(cells, "Count").toInt();// 当前列中单元格数 实际上这个数等于row  
		    	   for(int q=1;q<=cellCount;q++){
		    		   Dispatch cell = Dispatch.call(cells, "Item", new  Variant(q)).toDispatch(); //当前单元格 
		    		   Dispatch range=Dispatch.get(cell,"Range").toDispatch();
		    		   
		    		   Dispatch cellShading=Dispatch.get(range,"Shading").toDispatch();
		    		   String cellColor=Dispatch.get(cellShading,"BackgroundPatternColor").toString();
		    		   System.out.print(cellColor+"Color");//读取单元格的背景颜色
		    		   String cellText=Dispatch.get(range, "Text").toString();
		    		   
		    		   cellText=cellText.substring(0,cellText.length()-1);
		    		   String height=Dispatch.get(cell,"Width").toString();
		   
		    		//   Dispatch shading=Dispatch.get(cell,"Shading").toDispatch();
		    		   
		    		   
		    		   
		    		//   System.out.println("当前列中的值为：");
		    		   
		    	   }
		       }
		       
		       
		       
		       Dispatch wordContent = Dispatch.get(doc, "Content").toDispatch(); // 取得word文件的内容
		       Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs").toDispatch(); // 所有段落
		       int paragraphCount = Dispatch.get(paragraphs, "Count").toInt(); // 一共的段落数
		       paragraph=new Paragraph[paragraphCount];
		       for(int i=0;i<paragraphCount;i++){
		    	   Dispatch Paragraph=Dispatch.call(paragraphs,
		    			   "Item",
		    			   new Variant(i +1)).toDispatch(); //获得该段内容
		    	   Dispatch ParagraphRange =Dispatch.get(Paragraph, "Range").toDispatch();
		    	   Dispatch ParagraphFormat=Dispatch.get(ParagraphRange, "ParagraphFormat").toDispatch();
		    //	   String Align=Dispatch.get(ParagraphFormat,"Shading").toString();
		    	//   System.out.println(Align);
		    	   Dispatch chars=Dispatch.get (ParagraphRange, "Characters").toDispatch(); // 获取该段字符
		    	 
		    	   int charCount =Dispatch.get (chars, "Count").toInt(); // 取获字符个数
		    	   paragraph[i] =new Paragraph(charCount);
		    	   for(int j =0; j <paragraph[i].getCount(); j++){
		    		   paragraph[i].characters[j]=new Character();
		    		   
		    		   Dispatch chs=Dispatch.call(chars, "Item", new Variant(j +1)).toDispatch();
		    		   Dispatch font =Dispatch.get (chs, "Font").toDispatch();
		    
		    		//   Dispatch shading=Dispatch.get(chs,"Shading").toDispatch();
		    		//   paragraph[i].characters[j].BackgroundPatternColor=Dispatch.get(shading, "BackgroundPatternColor").toString();
		    		   
		    		   
		    		   
		    		   paragraph[i].characters[j].size=Dispatch.get(font, "Size").toString();
		    		   //获取字符大小
		    		   
		    		   paragraph[i].characters[j].color=Dispatch.get(font,"Color").toString();
		    		   //获取字符颜色
		    		   
		    		   paragraph[i].characters[j].name=Dispatch.get(font, "Name").toString();
		    		   //获取字符类型
		    		   
		    		   paragraph[i].characters[j].text =Dispatch.get(chs, "Text").toString();
		    		   //获取字符内容
		    		   
		    		   paragraph[i].characters[j].lable =  paragraph[i].characters[j].size+paragraph[i].characters[j].color+paragraph[i].characters[j].name;
		    		   //获取字符各属性
		    		   
		    		   
		    		//   System.out.print(paragraph[i].characters[j].BackgroundPatternColor+" ");
		    	   }
		    	   
		    	   
		    	 //  System.out.println("eee"+charCount);
		       }
		       
		       
		       
		    //   System.out.println(paragraphCount);
		   }catch (Exception e) {
		         e.printStackTrace();
		   }
		   finally {
			//   System.out.println();
		//	   app.invoke("Quit", new Variant[]{}); 
			 
		   }
		   return this.paragraph;
	
}
}