package com.example.assignment.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.DAO.DAO_Danh_Sach_Mon;
import com.example.assignment.R;
import com.example.assignment.model.DanhSachMon;
import com.example.assignment.model.Mon;
import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class Adapter_Rcv_Mon extends RecyclerView.Adapter<Adapter_Rcv_Mon.DSMonHolder>  {
    Context context;
    ArrayList<DanhSachMon> list_DSMon;
    DAO_Danh_Sach_Mon dao_danh_sach_mon;

    public Adapter_Rcv_Mon(Context context, ArrayList<DanhSachMon> list_DSMon) {
        this.context = context;
        this.list_DSMon = list_DSMon;
    }
    public static class DSMonHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView tvTen,tvTien,tvTinChi;
        public ImageView imgDelete;
        public DSMonHolder(View view){
            super(view);
            tvTen= view.findViewById( R.id.tvTen );
            tvTien= view.findViewById( R.id.tvTien );
            tvTinChi= view.findViewById( R.id.tvTinChi );
            imgDelete=view.findViewById( R.id.imgDelete );
        }
    }

    @NonNull
    @Override
    public Adapter_Rcv_Mon.DSMonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_mon_hoc,parent,false );
        DSMonHolder dsMonHolder= new DSMonHolder( view );
        return dsMonHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter_Rcv_Mon.DSMonHolder holder, final int position) {
        holder.tvTen.setText( "Môn học: "+list_DSMon.get( position).getTenMon());
        holder.tvTinChi.setText("Số tín chỉ: "+ list_DSMon.get( position).getTinChi());
        int tienHoc= (list_DSMon.get( position).getTinChi())*100;
        holder.tvTien.setText("Tiền học: "+tienHoc + " USD"  );;
        holder.imgDelete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Ban co muon xoa "+list_DSMon.get( position ).getTenMon()+ "khong?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Goi function Delete
                                dao_danh_sach_mon = new DAO_Danh_Sach_Mon(context);
                                dao_danh_sach_mon.delete( list_DSMon.get(position).getDanhSachMonID()+"");
                                list_DSMon.remove( position );
                                //ds_khoanTC.clear();
                                Toast.makeText(context, "Xóa thành công ",Toast.LENGTH_SHORT ).show();
                                notifyDataSetChanged();

                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        } );
    }


    @Override
    public int getItemCount() {
        return list_DSMon.size();
    }


}
