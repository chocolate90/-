package anonymous.basic;

interface Car {
	void run();
}

/*
class Tico implements Car {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
*/

public class Garage {
	
//	public Car car1 = new Tico();

	public Car car = new Car() {
		
		@Override
		public void run() {
		System.out.println("사용할 때마다 내용이 바뀐다면 익명클래스로 생성 가능");
			
		}
	};
	
}
