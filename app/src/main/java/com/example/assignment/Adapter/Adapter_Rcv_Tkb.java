package com.example.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;
import com.example.assignment.model.DanhSachMon;

import java.util.ArrayList;

public class Adapter_Rcv_Tkb extends RecyclerView.Adapter<Adapter_Rcv_Tkb.DSMonHolder>  {
    Context context;
    ArrayList<DanhSachMon> list_DSMon;

    public Adapter_Rcv_Tkb(Context context, ArrayList<DanhSachMon> list_DSMon) {
        this.context = context;
        this.list_DSMon = list_DSMon;
    }
    public static class DSMonHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView tvPhong,tvNgay,tvGio,tvTen;
        public DSMonHolder(View view){
            super(view);
            tvPhong= view.findViewById( R.id.tvPhong );
            tvNgay= view.findViewById( R.id.tvNgay );
            tvGio= view.findViewById( R.id.tvGio );
            tvTen= view.findViewById( R.id.tvTen );
        }
    }

    @NonNull
    @Override
    public Adapter_Rcv_Tkb.DSMonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_tkb,parent,false );
        DSMonHolder dsMonHolder= new DSMonHolder( view );
        return dsMonHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter_Rcv_Tkb.DSMonHolder holder, int position) {
        holder.tvTen.setText( "Môn học: "+list_DSMon.get( position).getTenMon());
        holder.tvPhong.setText("Phòng: "+ list_DSMon.get( position).getPhong());
        holder.tvNgay.setText("Ngày: "+ list_DSMon.get( position).getNgay());
        holder.tvGio.setText("Giờ: "+ list_DSMon.get( position).getGio());
    }


    @Override
    public int getItemCount() {
        return list_DSMon.size();
    }


}
