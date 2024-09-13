package demos.advanced.designpatterns.template_method;


public enum AlignmentAlgorithm {

    LOCAL("local alignment"),
    SEMIGLOBAL("semiglobal alignment"),
    GLOBAL("global alignment");

    private String type;

    private AlignmentAlgorithm(String type){
        this.type = type;
    }

    public String toString(){
        return type;
    }
}
