import java.io.IOException;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.*;
import org.apache.poi.hslf.usermodel.*;

public class PptRead {
	private String title[];
	private String title1[];//读取的标题
	private String back[];
	private String back1[];//读取的背景颜色
	private String imgName;//读取图片的名字
	private String Format;//
	private String Format1;//图片的格式
	
	private int height;//图片的高度
	private int width;//图片的宽度
	private int count_title;
	private int count_back;
	private int count_img;
	private int count_main;
	private int count;
	private int x;//图片的位置的横坐标
	private int y;//图片的位置的纵坐标
	private String address;//正文的超链接的地址
	private String address1;
	private TextRun t[];//获取幻灯片的文字内容
	private Hyperlink h[];//获取幻灯内容的超链接
	public static void main(String args[]){
		PptRead pr=new PptRead();
		String filepath="d:/pptTest/answer.ppt";
		pr.mainRead(filepath);
		System.out.println(pr.titleRead(filepath)+pr.mainRead(filepath)+
				pr.imgRead(filepath)+pr.backRead(filepath));
		
	}
	
	public int titleRead(String filepath){
		try {
			
			SlideShow ss = new SlideShow(new HSLFSlideShow(filepath));
			Slide[] slides = ss.getSlides();// 获得每一张幻灯片
			title =new String[slides.length];
			SlideShow ss1 = new SlideShow(new HSLFSlideShow("d:/pptTest/paper.ppt"));
			Slide[] slides1 = ss1.getSlides();// 获得每一张幻灯片
			
			title1=new String[slides.length];
			
			for(int i=0;i<slides.length;i++){
				title[i]=slides[i].getTitle();//获取每张PPT的标题
			}
			for(int j=0;j<slides1.length;j++){
				title1[j]=slides1[j].getTitle();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(title.length!=title1.length){
			count_title=0;
		}else{
			for(int i=0;i<title.length;i++){
				if(!title[i].equals(title1[i])){
					count_title=0;
					break;
				}else{
					count_title=1;
				}
			}
		}
		return count_title;
	}
	public int mainRead(String filepath){
		 try {
			
			SlideShow ss = new SlideShow(new HSLFSlideShow(filepath));
			Slide slide = ss.getSlides()[0];// 获得第一张幻灯片
			
			SlideShow ss1 = new SlideShow(new HSLFSlideShow("d:/pptTest/paper.ppt"));
			Slide slide1 = ss1.getSlides()[0];// 获得第一张幻灯片
			
			t=slide.getTextRuns();
			h=t[1].getHyperlinks();//获取正文中的超链接
			address="";
			if(h==null){//不能用h.length来判断，因为此时的h为空，对其操作就会出现问题
				address="";
			}else{
			for(int i=0;i<h.length;i++){
				address+=h[i].getAddress();
			}
			}
			System.out.println("123"+address);
			
			t=slide1.getTextRuns();
			h=t[1].getHyperlinks();//获取正文中的超链接
			address1="";
			if(h==null){//不能用h.length来判断，因为此时的h为空，对其操作就会出现问题
				address1="";
			}else{
			for(int i=0;i<h.length;i++){
				address1+=h[i].getAddress();
			}
			}
			System.out.println("321"+address1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(address.equals(address1)){
			count_main=1;
		}else{
			count_main=0;
		}
		return count_main;
	}
	public int backRead(String filepath){//获取图片的背景颜色
		try {
			
			SlideShow	ss = new SlideShow(new HSLFSlideShow(filepath));
			Slide[] slides = ss.getSlides();// 获得每一张幻灯片
			back=new String[slides.length];
			for(int i=0;i<slides.length;i++){
				System.out.println(slides[i].getBackground().getFill().getForegroundColor().toString());
				back[i]=slides[i].getBackground().getFill().getForegroundColor().toString();
			}

			SlideShow	ss1 = new SlideShow(new HSLFSlideShow("d:/pptTest/paper.ppt"));
			Slide[] slides1 = ss1.getSlides();// 获得每一张幻灯片
			back1=new String[slides.length];
			for(int j=0;j<slides1.length;j++){
				back1[j]=slides1[j].getBackground().getFill().getForegroundColor().toString();
				System.out.println(slides1[j].getBackground().getFill().getForegroundColor().toString());
			}
			if(back.length!=back1.length){
				count_back=0;
			}else{
				for(int i=0;i<back.length;i++){
					if(!back[i].equals(back1[i])){
						count_back=0;
						break;
					}else{
						count_back=1;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count_back;
		
	}
	public int imgRead(String filepath){
		try {
			SlideShow	ss = new SlideShow(new HSLFSlideShow(filepath));
			Slide[] slide=ss.getSlides();
			 for (int i = 0; i < slide.length; i++) {
		            Shape[] shape = slide[i].getShapes();
		            for (int j = 0; j < shape.length; j++) {
		                if (shape[j] instanceof Picture) {
		                    Picture p = (Picture) shape[j];
		                    PictureData data = p.getPictureData();
		                    String imgName = p.getPictureName();//读取图片的名字
		                    height=p.getOutline().getBounds().height;//读取图片的高度
		                    width=p.getOutline().getBounds().width;//读取图片的宽度
		                    y=p.getOutline().getBounds().y;
		                    x=p.getOutline().getBounds().x;
		                    Format=imgName+height+width+x+y;
		                    System.out.println(Format);
		                    
		                }
		            }
			 }
			 SlideShow	ss1 = new SlideShow(new HSLFSlideShow("d:/pptTest/paper.ppt"));
				Slide[] slide1=ss1.getSlides();
				 for (int i = 0; i < slide1.length; i++) {
			            Shape[] shape = slide1[i].getShapes();
			            for (int j = 0; j < shape.length; j++) {
			                if (shape[j] instanceof Picture) {
			                    Picture p = (Picture) shape[j];
			                    PictureData data = p.getPictureData();
			                    String imgName = p.getPictureName();//读取图片的名字
			                    height=p.getOutline().getBounds().height;//读取图片的高度
			                    width=p.getOutline().getBounds().width;//读取图片的宽度
			                    y=p.getOutline().getBounds().y;
			                    x=p.getOutline().getBounds().x;
			                    Format1=imgName+height+width+x+y;
			                    System.out.println(Format1);
			                    
			                }
			            }
				 
				 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Format.equals(Format1)){
			count_img=1;
		}else{
			count_img=0;
		}
		return count_img;
	}

}
