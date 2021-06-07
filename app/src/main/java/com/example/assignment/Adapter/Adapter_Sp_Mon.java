package com.example.assignment.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.Mon;
import com.example.assignment.model.Nganh;

import java.util.ArrayList;

public class Adapter_Sp_Mon extends BaseAdapter {
    Context context;
    ArrayList<Mon> list_Mon;
    TextView tv_sp;

    public Adapter_Sp_Mon(Context context, ArrayList<Mon> list_Mon) {
        this.context = context;
        this.list_Mon = list_Mon;
    }

    @Override
    public int getCount() {
        return list_Mon.size();
    }

    @Override
    public Object getItem(int i) {
        return list_Mon.get( i );
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
        tv_sp.setText( list_Mon.get( i).getTenMon());
        return view;
    }
}
