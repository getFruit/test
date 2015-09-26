package image;
 
import java.util.concurrent.ThreadPoolExecutor;
/**
 * 准备下载的URL
 * @author CheWenliang
 *
 */
public class DownImage {
    public static ThreadPoolExecutor threadPool;
    private String category = "http://www.dbmeizi.com/category/:category?p=:page";
    static{
        threadPool = ThreadPool.getInstance();
    }
    
    
    
    public static void main(String[] args) {
    	new DownImage().runTask();
    }

    
    
    
    
    public void runTask(){
        HtmlParserTool parserTool = new HtmlParserTool();
        threadPool.execute(parserTool);
        String cateArr[] = {"zipai","yazhou","oumei","katong","luanlun","siwa","tongxing","taotu",};
        for(int i = 0;i < cateArr.length;i++){
            for(int j = 0;j <= 4;j++){
                //将category里的动态参数替换,类型和页码
                String categoryUrl = category.replaceAll(":category", ""+cateArr[i]).
                                    replaceAll(":page", ""+j);
                HtmlParserTool parserHtml = new HtmlParserTool();
                parserHtml.setResource(categoryUrl);
                parserHtml.setCategory(cateArr[i]);
                threadPool.execute(parserHtml);
            }
        }
    }
    

}