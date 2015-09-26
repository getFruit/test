package image;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.beans.LinkBean;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.util.NodeList;

public class HtmlParserTool extends Thread {
	private  String resource;
    private  String category;

    public static int num=0;
    public void run(){
        try {
        	num++;
            Parser myParser = new Parser(resource);
            myParser.setEncoding("GBK");
            String filterImage = "img";
            NodeFilter filter = new TagNameFilter(filterImage);
            NodeList nodeList = myParser.extractAllNodesThatMatch(filter);
            int n=0;
            for (int i = 1; i < nodeList.size(); i++) {
                ImageTag imgtag = (ImageTag) nodeList.elementAt(i);
                String imageUrl = imgtag.getImageURL();
                try {
					downLoadPic(imageUrl,category);
				} catch (IOException e) {
					//System.out.println("挂掉了一张");
					n++;
					continue;
				}
            }
            System.out.println(category+"---   第  "+num+"   页----下载完成     "+nodeList.size()+"--     挂"+n);
            
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("该页无内容");
        }
    }
    
    
    
/*
 *  获取链接
 *  Parser myParser = new Parser();
    LinkBean linkBean = new LinkBean();
    linkBean.setURL(resource);
    for (URL url:linkBean.getLinks()) {
				if (url.toString().contains("http://6666tp.com/tupianqu/"+category+"/index_")) {
					  Parser myParser2 = new Parser();
			          LinkBean linkBean2 = new LinkBean();
			          linkBean2.setURL(url.toString());
			          for (URL url2:linkBean2.getLinks()) {
			        	
		    				if (url2.toString().matches("http://6666tp.com/tupianqu/"+category+"/\\d{5}"+".html")) {
		    					 resources.add(url2.toString());
						     }
					  }
			    }
				
		}*/
 
    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public static void downLoadPic(String picUrl,String category) throws IOException {
        URL url = new URL(picUrl);
        URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();
        String picName = picUrl.substring(picUrl.lastIndexOf("/")+1);
        String s="E:/new/" + category + "/"+ picName;
        File dir = new File("E:/new/" + category);
        if(!dir.exists()){
            dir.mkdirs();
        } 
        File imageFile = new File("E:/new/" + category + "/"+ picName);
        FileOutputStream out=new FileOutputStream(imageFile);
        int i = 0;
        while ((i = is.read()) != -1) {
            out.write(i);
        }
        is.close();
        out.close();
    }
     
}