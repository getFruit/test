package bean;
/**   
* @Title: Category.java
* @Package com.get.fruit.bean 
* @Description: TODO
* @author LiQinglin 
* @date 2015-8-13 ����9:48:38 
* @version V1.0   
*/


/** 
 * @ClassName: Category 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-8-13 ����9:48:38 
 *  
 */

public class Category {
	private String categoryName;
	private String[] functions;
	private Taste taste;
	
	
	
	public Taste getTaste() {
		return taste;
	}
	public void setTaste(Taste taste) {
		this.taste = taste;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String[] getFunctions() {
		return functions;
	}
	public void setFunctions(String[] functions) {
		this.functions = functions;
	}
	public Category(String categoryName, String[] functions,Taste taste) {
		super();
		this.categoryName = categoryName;
		this.functions = functions;
		this.taste=taste;
	}
	
	public Category() {
		super();
	}
	
	
	
	public enum Taste{
	
		酸酸的,甜甜的,小清新,重口味;
		
	}
	
	public enum Function{
		调胃,美容,降血糖,营养,补血,利肺,利尿,减肥,壮阳,解酒
	}
	
	public enum CategoryName{
		西瓜,苹果,柠檬,柑橘,猕猴桃,樱桃,葡萄,草莓,菠萝,哈密瓜,甘蔗,橙子,荔枝,蓝莓,榴莲,柚子,杨桃,火龙果,石榴,香蕉,木瓜,梨,树莓,杏,芒果,桃,山竹
	}
}
