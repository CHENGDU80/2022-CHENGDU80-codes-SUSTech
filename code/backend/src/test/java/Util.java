public class Util {
    private static int called = 0;

    public static synchronized void report_method(String name) {
        called++;
        System.out.println("Called:" + name);
    }

    public static synchronized void report_infor(int total) {
        System.out.println("There are "+total + " methods, "+called+" methods are called");
        System.out.println("ratio:"+called*1.0/total);
    }

}