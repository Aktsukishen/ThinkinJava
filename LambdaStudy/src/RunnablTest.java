
public class RunnablTest {

	public static void main(String[] args) {
		System.out.println("RunnableTest");
		Runnable r1=new Runnable(){
			@Override
			public void run(){
				System.out.println("r1.run()");
			}
		};
		Runnable r2=() -> {System.out.println("r2.run()");};
		r1.run();
		r2.run();
	}

}
