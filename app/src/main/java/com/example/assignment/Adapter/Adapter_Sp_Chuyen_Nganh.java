package com.example.assignment.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.ChuyenNganh;
import com.example.assignment.model.Nganh;

import java.util.ArrayList;

public class Adapter_Sp_Chuyen_Nganh extends BaseAdapter {
    Context context;
    ArrayList<ChuyenNganh> list_ChuyenNganh;
    TextView tv_sp;

    public Adapter_Sp_Chuyen_Nganh(Context context, ArrayList<ChuyenNganh> list_ChuyenNganh) {
        this.context = context;
        this.list_ChuyenNganh = list_ChuyenNganh;
    }

    @Override
    public int getCount() {
        return list_ChuyenNganh.size();
    }

    @Override
    public Object getItem(int i) {
        return list_ChuyenNganh.get( i );
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = ((Activity)context).getLayoutInflater().inflate( R.layout.item_sp_nganh,viewGroup,false );
        tv_sp= view.findViewById( R.id.tv_sp );
        tv_sp.setText( list_ChuyenNganh.get( i).getTenChuyenNganh());
        return view;
    }
}
