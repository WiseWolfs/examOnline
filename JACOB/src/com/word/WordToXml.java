package com.word;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.*;
import org.dom4j.io.*;

import com.jacob.activeX.*;
import com.jacob.com.*;
import com.test.Character;
import com.test.Paragraph;

public class WordToXml {
	private static Paragraph paragraph[];
	private static int length;
	private int count_title;
	private int count_pf;
	private int count_main;
	private int count_table;
	private int count;// 正确的总数
	private Element root;
	private Element Table;
	public int ReadTable(String filename) {
		SAXReader saxReader = new SAXReader();
		String text;// 文本内容
		String label;// 文本格式
		String sum = "";// 文本内容加文本格式
		String sum1 = "";
		try {
			Document document = saxReader.read(new File(filename));
			Element root = document.getRootElement();
			Iterator iter = root.elementIterator("Table"); // 获取根节点下的子节点table
			if(iter.hasNext()){
			Element it = (Element) iter.next();// 获取第一个table节点
			Attribute Paralabel = it.attribute("label");
			String paralabel = Paralabel.getValue();
			sum = paralabel;
			Iterator its = it.elementIterator("Cell");// 获取第一个table节点下的cell节点
			while (its.hasNext()) {
				Element item = (Element) its.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}
			}else{
				sum="0";
			}
			System.out.println(sum + "sum");

			Document document1 = saxReader.read(new File("d:/wordTest/paper.xml"));
			Element root1 = document1.getRootElement();
			Iterator iter1 = root1.elementIterator("Table"); // 获取根节点下的子节点table
			if(iter1.hasNext()){
			Element it1 = (Element) iter1.next();// 获取第一个table节点
			Attribute Paralabel1 = it1.attribute("label");
			String paralabel1 = Paralabel1.getValue();
			sum1 = paralabel1;
			Iterator its1 = it1.elementIterator("Cell");// 获取第一个table节点下的cell节点
			while (its1.hasNext()) {
				Element item = (Element) its1.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum1 += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}
			}else{
				sum1="0";
			}
			System.out.println(sum1 + "sum1");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sum1.equals(sum)) {
			count_table = 1;
		} else {
			count_table = 0;
		}
		System.out.println(count_table + "table");
		return count_table;

	}

	public int ReadMain(String filename) {
		SAXReader saxReader = new SAXReader();
		String text;// 文本内容
		String label;// 文本格式
		String sum = "";// 文本内容加文本格式
		String sum1 = "";
		try {
			Document document = saxReader.read(new File(filename));
			Document document1 = saxReader.read(new File("d:/wordTest/paper.xml"));
			Element root = document.getRootElement();
			Iterator iter = root.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it_1 = (Element) iter.next();// 获取第一个Paragraph节点
			Element it_2 = (Element) iter.next();// 获取第二个paragraph节点
			Element it=(Element)iter.next();//获取第三个paragraph节点
			Iterator its = it.elementIterator("Font");// 获取第二个paragraph节点下的font节点
			while (its.hasNext()) {
				Element item = (Element) its.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}
			System.out.println(sum + "sum");

			Element root1 = document1.getRootElement();
			Iterator iter1 = root1.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it_11 = (Element) iter1.next();// 获取第一个Paragraph节点
			Element it_12=(Element)iter1.next();//获取第二个paragraph节点
			Element it1 = (Element) iter1.next();// 获取第三个paragraph节点
			
			Iterator its1 = it1.elementIterator("Font");// 获取第二个paragraph节点下的font节点
			while (its1.hasNext()) {
				Element item = (Element) its1.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum1 += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}
			System.out.println(sum1 + "sum1");
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sum1.equals(sum)) {
			count_main = 1;
		} else {
			count_main = 0;
		}
		System.out.println(count_main + "cm");
		return count_main;
	}

	public int ReadTitle(String filename) {
		SAXReader saxReader = new SAXReader();
		String text;// 文本
		String label;// 文本格式
		String sum = "";// 文本加文本格式
		String sum1 = "";

		try {
			Document document = saxReader.read(new File(filename));
			Document document1 = saxReader.read(new File("d:/wordTest/paper.xml"));

			Element root = document.getRootElement();
			Iterator iter = root.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it = (Element) iter.next();// 获取第一个Paragraph节点
			Attribute Paralabel = it.attribute("label");
			String paralabel = Paralabel.getValue();
			sum = paralabel;
			Iterator its = it.elementIterator("Font");// 获取第一个paragraph节点下的font节点
			while (its.hasNext()) {
				Element item = (Element) its.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}
			System.out.println(sum + "sum");

			Element root1 = document1.getRootElement();
			Iterator iter1 = root1.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it1 = (Element) iter1.next();// 获取第一个Paragraph节点
			Attribute Paralabel1 = it1.attribute("label");
			String paralabel1 = Paralabel1.getValue();
			sum1 = paralabel1;
			Iterator its1 = it1.elementIterator("Font");// 获取第一个paragraph节点下的font节点
			while (its1.hasNext()) {
				Element item = (Element) its1.next();
				Attribute Fontlabel = item.attribute("label");
				text = item.getText().toString().trim();// 获得font节点下的文本内容
				label = Fontlabel.getValue();// 获得font节点下的文本格式
				sum1 += label + text;// 将paragraph下的所有属性与文本内容全部放在fontText中

			}

			System.out.println("sum1" + sum1);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sum.equals(sum1)) {
			count_title = 1;
		} else {
			count_title = 0;
		}
		System.out.println(count_title);
		return count_title;
	}

	public int ReadParagraphFormat(String filename) {
		String sum = "";
		String sum1 = "";
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new File(filename));
			Element root = document.getRootElement();
			Iterator iter = root.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it_1 = (Element) iter.next();// 获取第一个Paragraph节点
			Element it = (Element) iter.next();// 获取第二个paragraph节点
			Attribute Paralabel = it.attribute("label");
			String paralabel = Paralabel.getValue();
			sum = paralabel;
			System.out.println(sum + "sum");

			Document document1 = saxReader.read(new File(
					"d:/wordTest/paper.xml"));
			Element root1 = document1.getRootElement();
			Iterator iter1 = root1.elementIterator("Paragraph"); // 获取根节点下的子节点paragraph
			Element it_11 = (Element) iter1.next();// 获取第一个Paragraph节点
			Element it1 = (Element) iter1.next();// 获取第二个paragraph节点
			Attribute Paralabel1 = it1.attribute("label");
			String paralabel1 = Paralabel1.getValue();
			sum1 = paralabel1;
			System.out.println(sum1 + "sum1");

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sum1.equals(sum)) {
			count_pf = 1;
		} else {
			count_pf = 0;
		}
		System.out.println(count_pf + "count_pf");
		return count_pf;
	}

	public static void main(String args[]) {
		WordToXml wtx = new WordToXml();
		//String inFile = "d:/wordTest/answer.doc"; // 指定要打开的word文档
		//paragraph=wtx.readWord(inFile);
	//	length=paragraph.length;
		 String filename="d:/wordTest/answer.xml";
		 wtx.ReadMain(filename);
		//wtx.createXmlDocument(inFile);

	}

	public Paragraph[] readWord(String inFile) {
		ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
		app.setProperty("Visible", new Variant(false)); // 设置可见
		Dispatch docs = app.getProperty("Documents").toDispatch();// 打开编辑器
		Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method,
				new Object[] { inFile, new Variant(false), new Variant(true) },
				new int[1]).toDispatch(); // 打开word文档
		Dispatch wordContent = Dispatch.get(doc, "Content").toDispatch(); // 取得word文件的内容
		Dispatch paragraphs = Dispatch.get(wordContent, "Paragraphs")
				.toDispatch(); // 所有段落
		int paragraphCount = Dispatch.get(paragraphs, "Count").toInt(); // 一共的段落数
		paragraph = new Paragraph[paragraphCount];
		for (int i = 0; i < paragraphCount; i++) {
			Dispatch Paragraph = Dispatch.call(paragraphs, "Item",
					new Variant(i + 1)).toDispatch(); // 获得该段内容
			Dispatch ParagraphRange = Dispatch.get(Paragraph, "Range")
					.toDispatch();
			Dispatch ParagraphFormat = Dispatch.get(ParagraphRange,
					"ParagraphFormat").toDispatch();
			// System.out.println("basealign"+paragraph[i].alignment);
			Dispatch chars = Dispatch.get(ParagraphRange, "Characters")
					.toDispatch(); // 获取该段字符
			int charCount = Dispatch.get(chars, "Count").toInt(); // 取获字符个数
			paragraph[i] = new Paragraph(charCount);
			paragraph[i].linespacingrule = Dispatch.get(ParagraphFormat,
					"LineSpacingRule").toString();
			// 获得段落的行间距 单倍行距到多倍行距为0~5
			// System.out.println("align"+linespacingrule);
			paragraph[i].characterunitleftindent = Dispatch.get(
					ParagraphFormat, "CharacterUnitLeftIndent").toString();
			// 获得段落的左缩进量
			// System.out.println("char"+characterunitleftindent);
			paragraph[i].characterunitrightindent = Dispatch.get(
					ParagraphFormat, "CharacterUnitRightIndent").toString();
			// 获得段落的右缩进量
			paragraph[i].lineunitafter = Dispatch.get(ParagraphFormat,
					"LineUnitAfter").toString();
			// 获得段落的段后间距
			paragraph[i].lineunitbefore = Dispatch.get(ParagraphFormat,
					"LineUnitBefore").toString();
			// 获得段落的段前间距
			paragraph[i].baselinealignment = Dispatch.get(ParagraphFormat,
					"BaseLineAlignment").toString();
			// 获得段落的文本对齐方式 居中到自动的值为0~4
			paragraph[i].firstlineindent = Dispatch.get(ParagraphFormat,
					"FirstLineIndent").toString();
			// 获得段落的首行缩进或悬挂缩进的字符
			paragraph[i].alignment = Dispatch.get(ParagraphFormat, "Alignment")
					.toString();
			// 获得段落的对齐方式

			paragraph[i].label = paragraph[i].linespacingrule
					+ paragraph[i].characterunitleftindent
					+ paragraph[i].characterunitrightindent
					+ paragraph[i].lineunitafter + paragraph[i].lineunitbefore
					+ paragraph[i].baselinealignment
					+ paragraph[i].firstlineindent + paragraph[i].alignment;
			// 获得段落的格式
			for (int j = 0; j < paragraph[i].getCount(); j++) {
				paragraph[i].characters[j] = new Character();
				Dispatch chs = Dispatch.call(chars, "Item", new Variant(j + 1))
						.toDispatch();
				Dispatch font = Dispatch.get(chs, "Font").toDispatch();
				/*
				 * Dispatch shading=Dispatch.get(chs,"Shading").toDispatch();
				 * paragraph
				 * [i].characters[j].BackgroundPatternColor=Dispatch.get
				 * (shading, "BackgroundPatternColor").toString();
				 * System.out.println
				 * ("backcolor"+paragraph[i].characters[j].BackgroundPatternColor
				 * );
				 */
				paragraph[i].characters[j].size = Dispatch.get(font, "Size")
						.toString();
				// 获取字符大小
				paragraph[i].characters[j].bold = Dispatch.get(font, "Bold")
						.toString();
				// 获取字符粗细

				paragraph[i].characters[j].color = Dispatch.get(font, "Color")
						.toString();
				// 获取字符颜色
				paragraph[i].characters[j].name = Dispatch.get(font, "Name")
						.toString();
				// 获取字符类型
				paragraph[i].characters[j].text = Dispatch.get(chs, "Text")
						.toString();
				// 获取字符内容
				paragraph[i].characters[j].italic = Dispatch
						.get(font, "Italic").toString();
				// 获取字符正斜
				paragraph[i].characters[j].underline = Dispatch.get(font,
						"Underline").toString();
				// 获取字符下划线
				paragraph[i].characters[j].lable = paragraph[i].characters[j].size
						+ paragraph[i].characters[j].color
						+ paragraph[i].characters[j].name
						+ paragraph[i].characters[j].bold
						+ paragraph[i].characters[j].italic
						+ paragraph[i].characters[j].underline;
				// 获取字符各属性
				// System.out.print(paragraph[i].characters[j].text+" ");
			}
			// System.out.println("eee"+charCount);
		}
		return paragraph;
	}

	public Document createXmlDocument(String inFile) {
		Document doc = null;
		doc = DocumentHelper.createDocument();
		
		ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
		doc.setXMLEncoding("gbk");
		app.setProperty("Visible", new Variant(false)); // 设置可见
		Dispatch docs = app.getProperty("Documents").toDispatch();// 打开编辑器
		Dispatch doc1 = Dispatch.invoke(docs, "Open", Dispatch.Method,
				new Object[] { inFile, new Variant(false), new Variant(true) },
				new int[1]).toDispatch(); // 打开word文档
		root = doc.addElement("Article");// 创建根节点
		Dispatch tables = Dispatch.get(doc1, "Tables").toDispatch();
		System.out.println("mmmmm"+Dispatch.get(tables,"Count").toInt());
		int table_sum=Dispatch.get(tables,"Count").toInt();
		
		if(table_sum!=0){
		Dispatch table = Dispatch.call(tables, "Item", new Variant(1))
				.toDispatch();
		Dispatch cols = Dispatch.get(table, "Columns").toDispatch();// 读取word中表格所有列
		Dispatch rows = Dispatch.call(table, "Rows").toDispatch();// 读取word中表格所有行
		Dispatch tableRange = Dispatch.get(table, "Range").toDispatch();
		Dispatch borders = Dispatch.get(tableRange, "Borders").toDispatch();
		String insidelinewidth = Dispatch.get(borders, "InsideLineWidth")
				.toString();// 内部边框的线的宽度
		String outsidelinewidth = Dispatch.get(borders, "OutsideLineWidth")
				.toString();
		Dispatch tableFormat = Dispatch.get(tableRange, "ParagraphFormat")
				.toDispatch();
		String align = Dispatch.get(tableFormat, "Alignment").toString();
		System.out.println("align" + align);// 输出表格的位置

		int rowCount = Dispatch.get(rows, "Count").toInt();
		int colCount = Dispatch.get(cols, "Count").toInt();// 表格的列数
		String Rowcount = "" + rowCount;
		String Colcount = "" + colCount;
		String label = insidelinewidth + outsidelinewidth + align + Rowcount
				+ Colcount;
		 
		Table = root.addElement("Table");// 创建Table节点
		Table.addAttribute("label", label);

		for (int p = 1; p <= colCount; p++) {
			Dispatch col = Dispatch.call(cols, "Item", new Variant(p))
					.toDispatch(); // 循环出每一列
			Dispatch cells = Dispatch.get(col, "Cells").toDispatch();// 当前列中单元格
			int cellCount = Dispatch.get(cells, "Count").toInt();// 当前列中单元格数
			// 实际上这个数等于row
			for (int q = 1; q <= cellCount; q++) {
				Dispatch cell = Dispatch.call(cells, "Item", new Variant(q))
						.toDispatch(); // 当前单元格
				Dispatch range = Dispatch.get(cell, "Range").toDispatch();
				Dispatch cellShading = Dispatch.get(range, "Shading")
						.toDispatch();
				String cellColor = Dispatch.get(cellShading,
						"BackgroundPatternColor").toString();
				System.out.print(cellColor + "Color");// 读取单元格的背景颜色
				String cellText = Dispatch.get(range, "Text").toString();

				cellText = cellText.substring(0, cellText.length() - 1);
				String cellWidth = Dispatch.get(cell, "Width").toString();// 读取单元格的宽度
				String cellHeight = Dispatch.get(cell, "Height").toString();// 读取单元格的高度
				String cellLabel = cellColor + cellWidth + cellHeight;
				Element Cell = Table.addElement("Cell");
				Cell.setText(cellText);
				Cell.addAttribute("label", cellLabel);

			}
		}
		}
		for (int i = 0; i < length; i++) {
			Element Paragraph = root.addElement("Paragraph");
			Paragraph.addAttribute("label", paragraph[i].label);
			Character[] C = new Character[paragraph[i].characters.length];
			C = paragraph[i].characters;
			Character[] S = new Character[paragraph[i].characters.length];
			S = C;
			int k = 0, count = 0;
			for (int j = 1; j < C.length; j++) {
				if (S[k].compare(C[j]) == true) {
					S[count].text += C[j].text.trim();
					S[count].color = C[j].color;
					S[count].lable = C[j].lable;
					S[count].name = C[j].name;
					S[count].size = C[j].size;
					S[count].bold = C[j].bold;
					S[count].italic = C[j].italic;
					S[count].underline = C[j].underline;
					System.out.println(S[j - 1].lable + " " + C[j].lable);

				} else {
					Element Font = Paragraph.addElement("Font");
					Font.setText(S[count].text.trim());
					Font.addAttribute("label", S[count].lable);

					k = j;
					j--;
					count++;
					S[count].text = "";
					continue;
				}

			}
			Element Font = Paragraph.addElement("Font");
			Font.setText(S[count].text.trim());
			Font.addAttribute("label", S[count].lable);
			// k=j;
			// j--;
			// count++;
			// S[count].text="";
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("gbk");
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(new File(
					"d:/wordTest/answer.xml")), format);
			// XMLWriter writer = new XMLWriter( new FileWriter( "output.xml"
			// ));
			writer.write(doc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

}
