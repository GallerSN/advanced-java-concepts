package threadsProblem;


public class ThreadsMain {

	public static void main(String[] args) {
		MySum mySum = new MySum();
		Thread threads;
		for(int i = 0; i < 100; i++) {
			threads = new Thread(mySum);
			threads.start();
		}
	}
}
