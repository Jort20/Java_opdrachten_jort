package demos.advanced.designpatterns.strategy;

public class Primer {
    private String sequence;
    private String name;
    private MeltingTemperatureCalculator meltingTemperatureCalculator;

    public Primer(String sequence, String name) {
        this.sequence = sequence;
        this.name = name;
    }

    void setMeltingTemperatureCalculator(MeltingTemperatureCalculator calculator) {
        this.meltingTemperatureCalculator = calculator;
    }

    public double getMeltingTemperature() {
        return meltingTemperatureCalculator.getMeltingTemperature(this);
    }

//    public double getBasicMeltingPoint() {
//        //LOGIC omitted
//        return 43;
//    }
//
//    public double getSaltAdjustedMeltingPoint() {
//        //LOGIC omitted
//        return 45;
//    }
//
//    public double getNearestNeighborMeltingPoint() {
//        //LOGIC omitted
//        return 47;
//    }

    //much more code
}

