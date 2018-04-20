package us.walkley.mw.elasticitytablefragmenttest;

/**
 * Created by michael_walkley on 4/4/2018.
 */

public class MaterialDetail {
    private String name = "";
    private double e_value = 0;

    MaterialDetail(String str, double e){
        name = str;
        e_value = e;
    }

    public double getEValue() {
        return e_value;
    }
    public void setEValue(double e) {
        e_value = e;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
