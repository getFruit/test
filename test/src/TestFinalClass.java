import java.util.List;

import utils.JsonUtil;
import bean.Category;

/**   
 * @Title: TestFinalClass.java
 * @Package  
 * @Description: TODO
 * @author LiQinglin 
 * @date 2015-9-12 下午3:25:19 
 * @version V1.0   
 */

/** 
 * @ClassName: TestFinalClass 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-9-12 下午3:25:19 
 *  
 */
public class TestFinalClass {

	
	private List<Category> qq=null;

	public void tt() {
		qq=JsonUtil.json2Objects(JsonUtil.readJson("Category.json").toString());
		System.out.println("1--------------------");
		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());
		test(qq);
		System.out.println("4--------------------");
		System.out.println(qq);
		System.out.println(qq.get(1));
		System.out.println(qq.get(1).getCategoryName());
	}

	/** 
	* @Title: test 
	* @Description: TODO
	* @param @param qq2
	* @return void
	* @throws 
	*/
	private static void test(List<Category> qq2) {
		// TODO Auto-generated method stub
		System.out.println("2--------------------");

		System.out.println(qq2);
		System.out.println(qq2.get(1));
		System.out.println(qq2.get(1).getCategoryName());
		
		qq2.get(1).setCategoryName("testtest");
		System.out.println("3--------------------");

		System.out.println(qq2);
		System.out.println(qq2.get(1));
		System.out.println(qq2.get(1).getCategoryName());
		
	}
}
