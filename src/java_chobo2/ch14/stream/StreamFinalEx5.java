package java_chobo2.ch14.stream;



import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamFinalEx5 {

	public static void main(String[] args) {
		Student2[] stuArr = {
	            new Student2("나자바", true,  1, 1, 300),   
	            new Student2("김지미", false, 1, 1, 250),   
	            new Student2("김자바", true,  1, 1, 200),   
	            new Student2("이지미", false, 1, 2, 150),   
	            new Student2("남자바", true,  1, 2, 100),   
	            new Student2("안지미", false, 1, 2,  50),   
	            new Student2("황지미", false, 1, 3, 100),   
	            new Student2("강지미", false, 1, 3, 150),   
	            new Student2("이자바", true,  1, 3, 200),   
	            new Student2("나자바", true,  2, 1, 300),   
	            new Student2("김지미", false, 2, 1, 250),   
	            new Student2("김자바", true,  2, 1, 200),   
	            new Student2("이지미", false, 2, 2, 150),   
	            new Student2("남자바", true,  2, 2, 100),   
	            new Student2("안지미", false, 2, 2,  50),   
	            new Student2("황지미", false, 2, 3, 100),   
	            new Student2("강지미", false, 2, 3, 150),   
	            new Student2("이자바", true,  2, 3, 200)   
	         };
		//학생목록에서 반별로 그룹화
		Map<Integer, List<Student2>> StuByBan =
		Stream.of(stuArr).collect((groupingBy(Student2:: getBan)));

		for(Entry<Integer, List<Student2>> e :StuByBan.entrySet()) {
			System.out.printf("%d반 %s%n", e.getKey(), e.getValue());
		}
		//다중 그룹화(학년, 반)
			Map<Integer,Map<Integer,List<Student2>>> stdHakAndBan =
		Stream.of(stuArr).collect(groupingBy(
				Student2::getHak // 학년별 구분
				, groupingBy(Student2::getBan))); //같은 학년에서 반별구분
			
			for(Entry<Integer, Map<Integer, List<Student2>>> e :stdHakAndBan.entrySet()) {
				System.out.println(e.getKey() + "학년");
				Map<Integer, List<Student2>> values = e.getValue();
				for(Entry<Integer, List<Student2>> sube :values.entrySet()) {
					System.out.println("  " + sube.getKey() + "반");
					System.out.println("    "+ sube.getValue() );
				}
			}
		
		//모든 학생을 세 등급(HIGH, MID, LOW)로 카운팅	
			
			Map<Level, Long> StuByLevel =
			Stream.of(stuArr)
			.collect(groupingBy(
					s -> {
						if (s.getScore() >= 200)
							return Level.HIGH;
						else if (s.getScore() >= 100)
							return Level.MID;
						else
							return Level.LOW;
			}, counting()));
			/*	
			for(Entry<Level, Long> e : StuByLevel.entrySet()) {
				System.out.println(e.getKey() +"" + e.getValue() + "");
				}		
				*/
			System.out.println("HIGH : " + StuByLevel.get(Level.HIGH));
			System.out.println("MID : " + StuByLevel.get(Level.MID));
			System.out.println("LOW : " + StuByLevel.get(Level.LOW));
			
			
			
			//모든 학생을 세 등급(HIGH, MID, LOW)로  Set으로 저장
			Map<Level, List<Student2>> StuByLevel1 =
					Stream.of(stuArr)
					.collect(groupingBy(
							s -> {
								if (s.getScore() >= 200)
									return Level.HIGH;
								else if (s.getScore() >= 100)
									return Level.MID;
								else
									return Level.LOW;
					}));
		/*	
			for(Entry<Level, List<Student2>> e : StuByLevel1.entrySet()) {
				System.out.println(e.getKey() +"" + e.getValue() + "");
				}
				*/
			System.out.println("HIGH : " + StuByLevel1.get(Level.HIGH));
			System.out.println("MID : " + StuByLevel1.get(Level.MID));
			System.out.println("LOW : " + StuByLevel1.get(Level.LOW));
			
	}
}
