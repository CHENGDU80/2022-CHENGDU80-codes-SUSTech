
public class Target {
	private static int calls = 0;

	public static void foo(){
		calls = 1;
	}
	public static void bar(){
		calls = -1;
	}
	public static void main(String[] args) {
		foo();
	}

}