import java.util.Random;


public class HuntClassThread extends Thread {
	public static volatile int n=0;
	public boolean ss=false;
	
	public void run(){
		
		/*for (int i = 0; i < new Random().nextInt(100); i++) {
			inc();
			System.out.println(Thread.currentThread().getName()+"      "+n);
		}*/
		//System.out.println(Thread.currentThread().getName());
		
		
		try {
			System.out.println("aaa");
			Thread.currentThread().sleep(3000);
			ch();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public    void inc(){
		synchronized (HuntClassThread.class) {
			n++;
			System.out.print(n+"  ");
			
		}
	}
	
	public    void ch(){
		synchronized (HuntClassThread.class) {
			TestToString.map.put(Thread.currentThread().getName(), ss);
			System.out.println(TestToString.map.size()+"   done    "+Thread.currentThread().getName());
		}
	}
}
