package image;
 
import java.util.concurrent.ThreadPoolExecutor;
/**
 * ׼�����ص�URL
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
                //��category��Ķ�̬�����滻,���ͺ�ҳ��
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