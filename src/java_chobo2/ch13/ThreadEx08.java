package java_chobo2.ch13;

class Thread06 extends Thread{
	@Override
	public void run() {
		while(!interrupted()) {
			System.out.println("a");
		}
		System.out.println("end");
	}
}
public class ThreadEx08 {

	public static void main(String[] args) throws InterruptedException {
		Thread06 t = new Thread06();
		t.start();
		
		Thread.sleep(3000);
		t.interrupt();

	}

}
