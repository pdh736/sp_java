package sp_java;

class ThreadExtendSample extends Thread{
	public void run() {
		System.out.println("Thread is running");
	}
}

public class ThreadExtends {
	void runThread() {
		ThreadExtendSample tc1 = new ThreadExtendSample();
		
		tc1.start();
		try {
			tc1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}