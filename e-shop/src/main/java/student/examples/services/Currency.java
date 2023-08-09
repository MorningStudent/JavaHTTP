package student.examples.services;

public class Currency {
    public String charCode;
    public int numCode;
    public float ratio;

    public Currency(String charCode, int numCode, float ratio) {
        this.charCode = charCode;
        this.numCode = numCode;
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Currency [" + charCode + ", numCode=" + numCode + ", ratio=" + ratio + "]";
    }

}
