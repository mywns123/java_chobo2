package java_chobo2.ch12;

import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) {
		Box1<String> box = new Box1<String>();
		box.add("abc");
//		box.add(new object());
		box.add("def");		
		
		String item = box.get(0);
		System.out.println("item > " + item);

		ArrayList<String> list = box.getList();
		list.stream().forEach(System.out::println);
		
		System.out.println(box);
	}

}
