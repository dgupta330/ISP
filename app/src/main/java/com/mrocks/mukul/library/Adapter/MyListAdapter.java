package com.mrocks.mukul.library.Adapter;

import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mrocks.mukul.library.Models.Plan;
import com.mrocks.mukul.library.R;

import java.util.ArrayList;

/**
 * Created by Er.Deepak_kumar on 16-01-2018.
 */

public class MyListAdapter extends ArrayAdapter<Plan> {

    private final Activity context;
    private final ArrayList<Plan> plandetail;
    public MyListAdapter(@NonNull Activity context, ArrayList<Plan> plandetail) {
        super(context, R.layout.plandisplay,plandetail);
        this.context=context;
        this.plandetail=plandetail;
    }
    public View getView(int position, View view , ViewGroup parent)
    {
        LayoutInflater inflater= context.getLayoutInflater();
        View mview= inflater.inflate(R.layout.plandisplay,null,true);
        TextView planid= (TextView)mview.findViewById(R.id.planenameid);
        TextView plandetailname= (TextView)mview.findViewById(R.id.plandetailname);
        TextView type= (TextView)mview.findViewById(R.id.plantypename);
        ImageView teamimg=(ImageView)mview.findViewById(R.id.companynameimg);

        planid.setText(plandetail.get(position).getPlanid());
        plandetailname.setText(plandetail.get(position).getPlandetail());
        type.setText(plandetail.get(position).getType());
       try{
           Glide.with(context).load(Uri.parse(plandetail.get(position).getImagepath())).into(teamimg);
         //  Glide.with(context).load(plandetail.get(position).getImagepath()).into(teamimg);

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        return mview;
    }




}
