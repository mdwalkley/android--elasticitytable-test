package us.walkley.mw.elasticitytablefragmenttest;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by michael_walkley on 3/7/2018.
 * Resources:
 * https://www.androidhive.info/2013/07/android-expandable-list-view-tutorial/
 * https://www.youtube.com/watch?v=jZxZIFnJ9jE
 */

public class EValueListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<MaterialDetail>> listDataChild ;


    public EValueListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<MaterialDetail>> listDataChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.listDataChild.get(this.listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listDataChild.get(this.listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle = (String)getGroup(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.material_parent, null);
        }
        TextView lblListHeader = (TextView)view.findViewById(R.id.material_heading);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        MaterialDetail child = (MaterialDetail) getChild(i,i1);
        String childText1 = child.getName();
        String childText2 = NumberFormat.getNumberInstance(Locale.getDefault()).format(child.getEValue());

        if(view == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.material_child, null);
        }
        TextView txtListChild = (TextView)view.findViewById(R.id.material_structural_type);
        txtListChild.setText(childText1);
        txtListChild = (TextView)view.findViewById(R.id.e_value_text);
        txtListChild.setText(childText2);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}