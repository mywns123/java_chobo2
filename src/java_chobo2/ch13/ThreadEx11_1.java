package java_chobo2.ch13;

public class ThreadEx11_1 extends Thread {
@Override
public void run() {
	for(int i = 0; i<300;i++) {
		System.out.print(new String("-"));
	}
}
}