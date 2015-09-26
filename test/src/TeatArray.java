import utils.JsonUtil;

/**   
 * @Title: TeatArray.java
 * @Package  
 * @Description: TODO
 * @author LiQinglin 
 * @date 2015-8-26 下午3:11:52 
 * @version V1.0   
 */

/** 
 * @ClassName: TeatArray 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-8-26 下午3:11:52 
 *  
 */
public class TeatArray {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] files = new String[]{"sdcard/png0.png","sdcard/test0.jpg"};
		
		
		System.out.println(JsonUtil.getGson().toJson(files).substring(1, -2));
		System.out.println(files);
		System.out.println(files.length);
	}

}
