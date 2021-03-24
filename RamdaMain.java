package ramda.basic;

public class RamdaMain {

	public static void main(String[] args) {
		
		// Person greeting 메서드를 어떤 방법으로든 실행
		
		Person p = new Person();
		
		p.greeting(new Say01() {
			
			@Override
			public void talking() {
				System.out.println("hello");
				
			}
		});
		
		p.greeting(new Say02() {
			
			@Override
			public String talking() {
				
				return "안녕하세요";
			}
		});
		
		p.greeting(new Say03() {
			
			@Override
			public String talking(String word) {
				
				return word + "홍길동";
			}
		});
		
		
		String r = p.greeting(new Say04() {
			
			@Override
			public String talking(String word, int i) {
				
				// 3번 인사하는 기능
				String result = "";
				for(int j = 1; j <= i; j++) {
					result += word;
				}
				
				return result;
			}
		});
		System.out.println(r);
		
		
		
		
		// 함수적 인터페이스를 매개변수로 받는 형식은 람다식 표현으로 변경 가능하다.
		
		p.greeting( () -> System.out.println("hello")); // 한줄 표현은 중괄호 생략 가능
		
//		p.greeting( () -> {return "안녕하세요";}); 
		
		p.greeting( () -> "안녕하세요"); // 한줄이면서 리턴값만 적는다. 생략가능
		
//		p.greeting( (word) -> {return word + "홍길동";}) ;
		
		p.greeting( (word) -> word + "홍길동"); // 한줄이면서 리턴값만 적는다. 생략가능
		// 매개변수는 변수명만 적는다.
		
		String r2 = p.greeting( (word, i) -> {
			String result = "";
			for(int j = 1; j <= i; j++) {
				result += word;
			}
			
			return result;
		});
		System.out.println(r2);
	}
}
