import org.apache.poi.hslf.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.hslf.model.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Paragraph;
import java.io.*;
/**
* Demonstrates how you can extract misc embedded data from a ppt file
*
* @author Yegor Kozlov
*/
public final class DataExtraction {
    public static void main(String args[]) throws Exception {
       
        SlideShow ppt = new SlideShow(new HSLFSlideShow("c:\\ppt.ppt"));
       
        //extract embedded OLE documents
        Slide[] slide = ppt.getSlides();
       
        //Pictures
        for (int i = 0; i < slide.length; i++) {
            Shape[] shape = slide[i].getShapes();
            for (int j = 0; j < shape.length; j++) {
                if (shape[j] instanceof Picture) {
                    Picture p = (Picture) shape[j];
                    PictureData data = p.getPictureData();
                    String name = p.getPictureName();//读取图片的名字
                    System.out.println(""+p.getOutline().getBounds().height);//读取图片的高度
                    System.out.println("width"+p.getOutline().getBounds().x);
                    
                    System.out.println("name"+name);
                    int type = data.getType();
                    String ext;
                    switch (type) {
                        case Picture.JPEG:
                            ext = ".jpg";
                            break;
                        case Picture.PNG:
                            ext = ".png";
                            break;
                        case Picture.WMF:
                            ext = ".wmf";
                            break;
                        case Picture.EMF:
                            ext = ".emf";
                            break;
                        case Picture.PICT:
                            ext = ".pict";
                            break;
                        case Picture.DIB:
                            ext = ".dib";
                            break;
                        default:
                            continue;
                    }
                    FileOutputStream out = new FileOutputStream("pict-" + j + ext);
                    out.write(data.getData());
                    out.close();
                }
            }
        }
    }
    private static void usage(){
        System.out.println("Usage: DataExtraction  ppt");
    }
}