package java_chobo2.ch13;

class Thread04 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", "|");
		}
		System.out.println();
		System.out.printf("%s %d 나노초%n", "두번쨰 작업", System.currentTimeMillis() - ThreadEx03.startTime);
	}
}

public class ThreadEx03 {
	static long startTime = 0;

	public static void main(String[] args) {

		Thread04 thread = new Thread04();
		thread.start();
		startTime = System.currentTimeMillis();

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("-"));
		}
		System.out.println();
		System.out.printf("%s %d 나노초%n", "첫번쨰 작업", System.currentTimeMillis() - startTime);

	}// main
}