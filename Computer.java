package anonymous.basic2;

public class Computer {

	// 멤버변수
	
	private int sound;
	private RemoteControl remote;
	
	// 생성자
	
	public Computer() {
		remote = new RemoteControl() {
			
			@Override
			public void volumeUp() {
				sound++;
				System.out.println("볼륨:" + sound);
			}
			
			@Override
			public void volumeDown() {
				sound--;
				System.out.println("볼륨" + sound);
				
			}
			
			@Override
			public void turnOn() {
				System.out.println("켜다");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("끄다");
				
			}
		};
	}
	
	
}
