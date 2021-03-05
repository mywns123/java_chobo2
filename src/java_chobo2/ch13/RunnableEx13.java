package java_chobo2.ch13;


public class RunnableEx13 implements Runnable {
	Account2 acc = new Account2();

	@SuppressWarnings("unused")
	@Override
	public void run() {
		while(acc.getBalance()>0) {
			int money = (int) ((Math.random()*3+1) *100);
			acc.withdraw(100);
			System.out.println("balance : " + acc.getBalance());
		}
	}

}
