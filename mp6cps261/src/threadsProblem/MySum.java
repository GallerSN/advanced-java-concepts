package threadsProblem;

public class MySum implements Runnable{
	
	private int sum = 0;
	
//	synchronized public void increaseSum(){
	public void increaseSum(){
		
//		synchronized(this){
			try {
				Thread.sleep(100);
				sum++;
				System.out.println(Thread.currentThread().getName() + " sum is: " + sum);
			}
			catch(InterruptedException e) {
			}
//		}
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.increaseSum();
		
	}
	

}
