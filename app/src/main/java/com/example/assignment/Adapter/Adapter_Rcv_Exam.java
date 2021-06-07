package com.example.assignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Dialog.BottomSheet_List;
import com.example.assignment.R;
import com.example.assignment.model.DanhSachMon;

import java.util.ArrayList;
import java.util.Random;

public class Adapter_Rcv_Exam extends RecyclerView.Adapter<Adapter_Rcv_Exam.DSMonHolder>  {
    Context context;
    ArrayList<DanhSachMon> list_DSMon;
    BottomSheet_List bottomSheet_list;
    public Adapter_Rcv_Exam(Context context, ArrayList<DanhSachMon> list_DSMon) {
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
    public Adapter_Rcv_Exam.DSMonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_tkb,parent,false );
        DSMonHolder dsMonHolder= new DSMonHolder( view );
        return dsMonHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Adapter_Rcv_Exam.DSMonHolder holder, int position) {
        int thangExam= bottomSheet_list.thang+3;
        int namExam=0;
        if(thangExam>12){
            thangExam=thangExam-12;
            namExam=bottomSheet_list.nam+1;
        }
        Random random = new Random();
        int ngayExam=1+random.nextInt(30);
        int hourStart=7+random.nextInt(8);
        int hourEnd=9+random.nextInt(10);
        String date=ngayExam+"/"+thangExam+"/"+namExam;
        String hour=hourStart+"h - "+hourEnd+"h";

        holder.tvTen.setText( "Môn học: "+list_DSMon.get( position).getTenMon());
        holder.tvPhong.setText("Phòng: "+ list_DSMon.get( position).getPhong());
        holder.tvNgay.setText("Ngày: "+date );
        holder.tvGio.setText("Giờ: "+ hour);
    }


    @Override
    public int getItemCount() {
        return list_DSMon.size();
    }


}
