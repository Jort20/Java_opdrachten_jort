package demos.advanced.designpatterns.strategy;

public class PrimerAnalyser {

    public static void main(String[] args) {
        PrimerAnalyser analyser = new PrimerAnalyser();
        Primer primer = new Primer("atttaggtgacactatag", "self_annealing1");
        primer.setMeltingTemperatureCalculator(new SaltAdjustedMeltingTemperatureCalculator());
        double meltingTemperature = analyser.analysePrimer(primer);
        System.out.println("meltingTemperature = " + meltingTemperature);
    }

    public double analysePrimer(Primer primer) {  //, MeltingTempMethod method
        return primer.getMeltingTemperature();

//        switch (method) {
//            case BASIC:
//                return primer.getBasicMeltingPoint();
//            case SALT_ADJUSTED:
//                return primer.getSaltAdjustedMeltingPoint();
//            case NEAREST_NEIGHBOUR:
//                return primer.getNearestNeighborMeltingPoint();
//            default:
//                throw new IllegalArgumentException("Unknown method: " + method);
//        }
    }
}
