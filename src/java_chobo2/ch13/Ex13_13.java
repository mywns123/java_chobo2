package java_chobo2.ch13;

public class Ex13_13 {

	public static void main(String[] args) {
	Runnable r = new RunnableEx13();
	new Thread(r).start();
	new Thread(r).start();
	

	}

}
