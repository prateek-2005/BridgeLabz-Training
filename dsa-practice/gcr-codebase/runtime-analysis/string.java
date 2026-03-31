public class string{
    public static void main(String[] args) {
        int n = 10000;
        long startString = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + "a";
        }
        long endString = System.nanoTime();
        System.out.println("String Time: " + (endString - startString) + " ns");
        long startBuilder = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        long endBuilder = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ns");
        long startBuffer = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        long endBuffer = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ns");
    }
}
