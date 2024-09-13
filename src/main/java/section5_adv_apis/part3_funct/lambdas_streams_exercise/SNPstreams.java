package section5_adv_apis.part3_funct.lambdas_streams_exercise;

import java.util.List;
import java.util.Map;

public class SNPstreams {


    private static final List<SNP> SNP_COLLECTION = SNP.getSnpCollection();
    private static final String[] SNP_DATA = new String[14];

    static {
        SNP_DATA[0] = "100273;A;G;0.0123";
        SNP_DATA[1] = "100275;A;C;0.00323";
        SNP_DATA[2] = "117807;T;G;0.1915";
        SNP_DATA[3] = "162889;C;G;8.72E-4";
        SNP_DATA[4] = "190199;T;C;0.1019";
        SNP_DATA[5] = "277614;A;G;0.0168";
        SNP_DATA[6] = "372778;C;A;4.24E-5";
        SNP_DATA[7] = "417752;A;G;1.8474E-10";
        SNP_DATA[8] = "478808;A;G;1.535689E-8";
        SNP_DATA[9] = "556920;T;G;0.1097";
        SNP_DATA[10] = "676255;G;C;0.0016672";
        SNP_DATA[11] = "667280;A;G;0.00287";
        SNP_DATA[12] = "719876;C;A;0.006649";
        SNP_DATA[13] = "828771;A;C;0.097706";
    }

    public static void getDiseaseCandidateSnps() {
        //Your code
    }

    public static Map<String, List<SNP>> getTransversionsTransitions() {
        return null;
        //YOUR CODE
    }

}
