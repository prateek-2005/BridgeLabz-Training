public class VolumeOfEarth {
    public static void main(String[] args) {
        int radius=6378;
        double volume=((double)((4/3)*3.14*radius*radius*radius));
        double volinmiles=(double)(1.6*volume);
        System.out.println("The volume of earth in cubic kilometers is "+volume + " and cubic miles is "+ volinmiles);
    }
}
