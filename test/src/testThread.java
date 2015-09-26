
/**   
 * @Title: testThread.java
 * @Package  
 * @Description: TODO
 * @author LiQinglin 
 * @date 2015-5-29 обнГ11:12:41 
 * @version V1.0   
 */

/** 
 * @ClassName: testThread 
 * @Description: TODO
 * @author LiQinglin
 * @date 2015-5-29 обнГ11:12:41 
 *  
 */
public class testThread {

	public static ThreadA threads[] = new ThreadA[8];

	public void startA(){
		for (int i = 0; i < threads.length; i++) {
			threads[i]=new ThreadA(9000+i);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----");
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	class ThreadA extends Thread{

		public int y=9;
		
		public ThreadA(int y) {
			super();
			this.y = y;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0 ;i<y ;i++){
				System.out.println(Thread.currentThread().getName()+"-------"+i);
			}
		}
		
		
	}
}
