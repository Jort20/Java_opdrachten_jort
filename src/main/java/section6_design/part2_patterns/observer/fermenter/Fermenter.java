package section6_design.part2_patterns.observer.fermenter;

public class Fermenter {
    private static final double FATAL_PH = 2;
    private static final double FATAL_TEMP = 40;
    private static final double FATAL_GLUCOSE = 5;

    private double pH = 7.0;
    private double temperatureCelcius = 37.0;
    private double glucoseMilliMolar = 100;
    private boolean stop;

    public void ferment() {
        while(! stop) {
            double pHchange = Math.random() * -0.5;
            this.pH += pHchange;
            double tempChange = Math.random() * 0.4;
            this.temperatureCelcius += tempChange;
            double glucoseChange = Math.random() * -8;
            this.glucoseMilliMolar += glucoseChange;
            //report status
            System.out.println("this = " + this);
            if (crashConditionReached()) {
                System.out.println("FATAL CONDITION REACHED!");
                stop();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean crashConditionReached() {
        return (this.pH < FATAL_PH || this.temperatureCelcius > FATAL_TEMP || this.glucoseMilliMolar < FATAL_GLUCOSE);
    }

    public void addBase() {
        this.pH += 1;
    }

    public void cool() {
        this.temperatureCelcius -= 1;
    }

    public void addGlucose() {
        this.glucoseMilliMolar = 100;
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public String toString() {
        return "Fermenter{" +
                "pH=" + pH +
                ", temperatureCelcius=" + temperatureCelcius +
                ", glucoseMilliMolar=" + glucoseMilliMolar +
                '}';
    }
}
