public class ComparisonTime {

	public static void main(String[] args) {
		int count = 1_000_000;
        StringBuilder sbd = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < count; i++) {
            sbd.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;
        StringBuffer sbf = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < count; i++) {
            sbf.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;
        System.out.println("Time taken by StringBuilder: " + builderTime + " ns");
        System.out.println("Time taken by StringBuffer : " + bufferTime + " ns");
	}

}
