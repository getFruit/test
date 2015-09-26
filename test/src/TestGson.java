import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import bean.Category;
import bean.Category.Function;
import bean.Category.Taste;
import utils.JsonUtil;

/**   
 * @Title: TestGson.java
 * @Package  
 * @Description: TODO
 * @author LiQinglin 
 * @date 2015-8-24 ����7:08:38 
 * @version V1.0   
 */

/** 
 * @ClassName: TestGson 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-8-24 ����7:08:38 
 *  
 */
public class TestGson {

	/** 
	 * @Title: main 
	 * @Description: TODO
	 * @param @param args
	 * @return void
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------------");
		Set<String> set=new HashSet<>();
		for(Category c:JsonUtil.json2Objects((String) JsonUtil.readJson("Category.json"))){
			for(String s:c.getFunctions()){
				set.add(s);
			}
		}
		
		System.out.println("----------------");
		for(String s:set){
			System.out.print(s+",");
		}
	}

}
