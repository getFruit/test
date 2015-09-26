import java.util.HashMap;
import java.util.Map;


  public class TestToString {
	  public static final String[] header=new String[]{"添加","教学班名称"};
	  public static Map<String,Boolean> map=new HashMap();

	  
	  public static void main(String[] args) {
		  new testThread().startA();
		  
	/*	 // doo(10);
		  System.out.println("ta  r  "+map.size());
		  while(map.size()<9){
			  doo(10-map.size());
		  }
		  
		  System.out.println(map.size()+"done");
			
		  //System.out.println("ttt"+HuntClassThread.n);
*/		}


	public static void doo(int q) {
		HuntClassThread threads[]=new HuntClassThread[q];
			for(int i=0;i<threads.length;i++){
				threads[i]=new HuntClassThread();
			}
			
			for(int i=0;i<threads.length;i++){
				threads[i].start();
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
    	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  /*SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
			long timeto = 0;
			try {
				timeto = (sd.parse("2015年06月04日 18:53").getTime()-System.currentTimeMillis())/1000;
				System.out.println(timeto);
				System.out.println(System.currentTimeMillis());
				System.out.println(timeto/3600);
				System.out.println((timeto%3600)/60);
				System.out.println(((timeto%3600)%60));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
    	 
}
  
  
  
