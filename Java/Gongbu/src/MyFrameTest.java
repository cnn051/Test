
public class MyFrameTest {

	public static void main(String[] args) {
		new MyFrame();
		
		long start = System.nanoTime();
		// ... ���� ����
		long end = System.nanoTime();
		System.out.println("����ð�: " + (end - start) + " ns");
	}

}
