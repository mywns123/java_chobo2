package java_chobo2.ch14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamFinalEx3 {

	public static void main(String[] args) {
		
		//스트림을 리듀싱 reducing
		OptionalInt maxValue = new Random(1234).ints(1,46)				
				.distinct().limit(6)
				.peek(s ->System.out.print(s + ","))				
				.reduce(Integer::max);
		
		Optional<Integer> maxValue2 = new Random(1234).ints(1,46)				
				.distinct().limit(6) // StreamInt
				.boxed()			//Stream<Integer>
				.collect(Collectors.reducing(Integer::max));
		
		System.out.println("max =" + maxValue.getAsInt());
		System.out.println("max =" + maxValue2.get());
		
		int sum1 = new Random(1234).ints(1,46).
				distinct().limit(6)
				.reduce(0, (a,b) -> a+b);
		
		int sum2 = new Random(1234).ints(1,46).
				distinct().limit(6)
				.boxed()
				.collect(Collectors.reducing(0, (a,b) -> a+b));
		
		
		
		System.out.printf("sum1 = %d, sum2 = %d%n", sum1, sum2);
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 95));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("감자바", 3, 80));
		
	int grandTotal = list.parallelStream()
			.map(Student::getTotalScore)
			.reduce(0, Integer::sum);
	System.out.println(grandTotal);
		
	int grandTota2 =list.parallelStream()
			.collect(Collectors.reducing(0,Student::getTotalScore, Integer::sum));
	System.out.println(grandTota2);
	
	//문자열스트림을 모두 연결(joinnig)
	String names1 =  list.parallelStream().map(Student::getName).collect(Collectors.joining());
	String names2 =  list.parallelStream().map(Student::getName).collect(Collectors.joining(","));
	String names3 =  list.parallelStream().map(Student::getName).collect(Collectors.joining(",","[","]"));
//	String studentInfo = list.parallelStream().collect(Collectors.joining(","));
	
	System.out.println(names1);
	System.out.println(names2);
	System.out.println(names3);
//	System.out.println(studentInfo);
	
	
	
	}

}
