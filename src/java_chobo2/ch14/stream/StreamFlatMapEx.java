package java_chobo2.ch14.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamFlatMapEx {

	public static void main(String[] args) {
		/*	
		String[][] strArrs = {
				{ "abc", "def", "jkl" },
				{ "ABC", "GHI", "JKL" }
		};
		
		
		Stream<String[]> strArrStrm = Stream.of(strArrs);
		Stream<Stream<String>> StrStrmStrm = strArrStrm.map(Arrays::stream);		
		StrStrmStrm
		.peek(System.out::println);	
		*/		
	
		Stream<String[]> strArrStrm = Stream.of(
				new String[] { "abc", "def", "jkl" },
				new String[] { "ABC", "GHI", "JKL" });
		
//		Stream<Stream<String>> StrStrmStrm = strArrStrm.map(Arrays::stream);
		Stream<String> StrStrm = strArrStrm.flatMap(Arrays::stream);
		
		StrStrm.map(String::toLowerCase)
			   .distinct()
			   .sorted()
			   .forEach(System.out::println);
		System.out.println();
		
		String[] lineArr = {
				"Belive or not It is true",
				"Do or not There is no try",
		};
		
		Stream<String> lineStream =  Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
				   .map(String::toLowerCase)
				   .distinct()
				   .sorted()
				   .forEach(System.out::println);
			System.out.println();
		
		
		
	}

}
