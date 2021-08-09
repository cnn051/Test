
public class MyFrameTest {

	public static void main(String[] args) {
		new MyFrame();
		
		long start = System.nanoTime();
		// ... 로직 생략
		long end = System.nanoTime();
		System.out.println("수행시간: " + (end - start) + " ns");
	}

}
