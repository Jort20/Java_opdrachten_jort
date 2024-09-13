package demos.advanced.designpatterns.strategy;

public class BasicMeltingTemperatureCalculator implements MeltingTemperatureCalculator {
    @Override
    public double getMeltingTemperature(Primer primer) {
        //LOGIC omitted
        return 43;
    }
}
