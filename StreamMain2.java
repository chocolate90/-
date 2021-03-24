package ramda.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMain2 {

	public static void main(String[] args) {
		
		/*
		 *  반복자 스트림은 중간 처리 메서드와 최종 처리 메서드로 나눠진다.
		 *  중간 처리 메서드 - 처리 결과를 Stream으로 반환함
		 *  최종 처리 메서드 - 처리 결과를 정수, 실수 등으로 반환함
		 *  
		 *  람다식을 적용하는 함수적 인터페이스의 종류
		 *  
		 *  Consumer - 매개변수를 받고 반환은 없는 유형
		 *  Predicate - 매개변수를 받고 반환은 Boolean
		 *  Function - 매개변수를 받고 반환은 임의로 결정
		 */
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= 100; i++) {
			
//			Random ran = new Random();
//			int num = ran.nextInt(100) + 1;
//			list.add(num);
			
			list.add( new Random().nextInt(100) + 1);
			
		}
		
		System.out.println(list.toString());
		
		// distinct - 중복 제거
		list.stream().distinct().forEach( (a) -> System.out.print(a + " "));
		
		System.out.println("\n------------------------------------------");
		// sorted - 정렬
		list.stream().distinct().sorted().forEach((a) -> System.out.print(a + " "));
		
		System.out.println("\n------------------------------------------");
		// filter - 걸러내는 기능(true인 경우에만 반환)
		list.stream().distinct().sorted().filter( (a) -> a % 2 == 0).forEach( (a) -> System.out.print(a + " "));
		
		System.out.println("\n------------------------------------------");
		// map - 람다식에 정의 된 새로운 Stream으로 반환
		list.stream()
			.distinct()
			.sorted()
			.filter((a) -> a % 2 == 0)
			.map((a) -> a % 2 == 0 ? "짝" : "홀")
			.forEach(a -> System.out.print(a + " "));
		
		System.out.println("\n------------------------------------------");
		list.stream()
			.map( (a) -> a >= 50 ? a : 0)
			.forEach(a -> System.out.print(a + " "));
		
		System.out.println("\n------------------------------------------");
		// 최종처리 메서드 collect
		
		List<Integer> newList = list.stream()
			.filter((a) -> a >= 50 && a % 3 == 0)
			.collect( Collectors.toList());
		
		System.out.println(newList.toString());
		
		System.out.println("\n------------------------------------------");
		// 정수 스트림 or 실수 스트림 -> 통계 관련 함수들을 사용 가능
		// mapToInt, mapToDouble .....
		
		long result = list.stream().mapToInt( (a) -> a).count();
		
		System.out.println("개수:" + result);
		
		int result1 = list.stream().mapToInt((a) -> a).sum();
		System.out.println("합:" + result1);
		
		Double result3 = list.stream().mapToInt( (a) -> a).average().getAsDouble();
		System.out.println("평균:" + result3);
		
		OptionalInt result2 = list.stream().mapToInt((a) -> a).max();
		System.out.println("가장 큰 값:" + result2.getAsInt());
	}
}
