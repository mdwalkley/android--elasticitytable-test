package us.walkley.mw.elasticitytablefragmenttest;

import java.util.ArrayList;

/**
 * Created by michael_walkley on 4/4/2018.
 */

public class MaterialHeader {
    private String name;
    private ArrayList<MaterialDetail> StructuralList = new ArrayList<MaterialDetail>();

    MaterialHeader(String str, ArrayList<MaterialDetail> arrayList){
        name = str;
        StructuralList = arrayList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<MaterialDetail> getStructuralList() {
        return StructuralList;
    }
    public void setStructuralList(ArrayList<MaterialDetail> list) {
        this.StructuralList = list;
    }
}

