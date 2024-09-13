package demos.advanced.designpatterns.strategy;

public class SaltAdjustedMeltingTemperatureCalculator implements MeltingTemperatureCalculator{
    @Override
    public double getMeltingTemperature(Primer primer) {
        //LOGIC omitted
        return 45;
    }
}
