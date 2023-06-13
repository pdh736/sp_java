package sp_java.thread;

class ThreadRunnableSample implements Runnable{
	public void run() {
		System.out.println("threa id running");
	}
}

public class ThreadRunnable{
	public void runThread() {
		ThreadRunnableSample m1 = new ThreadRunnableSample();
		Thread t1 = new Thread(m1);
		t1.start();
		try {
			t1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//코드 단위로 뮤텍스 잡을때는 
/*
 * static ReentrantLock lock  = new ReentrantLock();
 * public void run() {
 * lock.lock();
 * try {
 * 	SaveFile(data);
 * }finally {
 * 	lock.unlock();
 * }
*/

// 함수 단위로 잡을때는 synchronized 사용
/*
 * public synchronized void Savefile2(String data) {
 *  //이 함수는 한번에 한 쓰드에서만 접근 가능함
 * }
 */
