import java.util.List;

import com.sun.istack.internal.FinalArrayList;

import bean.Category;
import utils.JsonUtil;

/**   
 * @Title: TestFinal.java
 * @Package  
 * @Description: TODO
 * @author LiQinglin 
 * @date 2015-9-12 下午3:08:23 
 * @version V1.0   
 */

/** 
 * @ClassName: TestFinal 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-9-12 下午3:08:23 
 *  
 */
public class TestFinal {

	//private static List<Category> qq=null;

	public static void main(String[] args) {
		new TestFinalClass().tt();
		/*qq=JsonUtil.json2Objects(JsonUtil.readJson("Category.json").toString());
		System.out.println("1--------------------");
		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());
		test(qq);
		System.out.println("4--------------------");
		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());*/
	}

/*	*//** 
	* @Title: test 
	* @Description: TODO
	* @param @param qq2
	* @return void
	* @throws 
	*//*
	private static void test(List<Category> qq2) {
		// TODO Auto-generated method stub
		System.out.println("2--------------------");

		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());
		
		qq.get(1).setCategoryName("testtest");
		System.out.println("3--------------------");

		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());
		
	}
	
*/
}
