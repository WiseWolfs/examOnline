import java.io.IOException;
import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.model.*;
import org.apache.poi.hslf.usermodel.*;

public class PptReader {

    /**
     * @param args
     */
    public static String getTextFromPPT2003(String path) {

        StringBuffer content = new StringBuffer("");
        TextRun[]t;//获取幻灯片的文字内容
        Hyperlink h[];//获取文字的超链接
        try {
        	
            SlideShow ss = new SlideShow(new HSLFSlideShow(path));// path为文件的全路径名称，建立SlideShow
            PictureData[] pda=  ss.getPictureData();
            System.out.println(pda[0].getSize());
            Slide[] slides = ss.getSlides();// 获得每一张幻灯片
            for (int i = 0; i < slides.length; i++) {
                t = slides[i].getTextRuns();// 为了取得幻灯片的文字内容，建立TextRun
          //      Hyperlink h[]=t[0].getHyperlinks();//
           //     System.out.println("123"+h[0].getAddress());
                for (int j = 0; j < t.length; j++) {
                    content.append(t[j].getText());// 这里会将文字内容加到content中去
                }
            //    content.append(slides[i].getTitle());
            }
            System.out.println(slides[0].getBackground().getFill().getForegroundColor());//读取背景颜色
            System.out.println(slides[1].getTitle());//读取每张PPT的标题
            System.out.println();
            System.out.println(slides.length+"slide");//读取ppt的张数
            Shape s[]=slides[0].getShapes();
            if(s[0] instanceof Picture){
            	  Picture p=(Picture)s[0];
            	  System.out.println("picture"+p.getPictureName());
            }
          
           
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return content.toString();

    }



    public static void main(String[] args) {
        System.out.println(PptReader.getTextFromPPT2003("c:\\ppt.ppt"));
     //   System.out.println(PptReader.getTextFromPPT2007("c:/test.pptx"));
    }

}