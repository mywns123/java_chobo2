package java_chobo2.ch13;

import javax.swing.JOptionPane;

public class ThreadEx05 {

	public static void main(String[] args) {
		Thread03 thread = new Thread03();
		thread.start();
		
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력");
		System.out.println("입력한 값은" + input +"입니다.");

	}

}
