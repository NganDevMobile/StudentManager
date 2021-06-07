package com.example.assignment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Adapter.Adapter_Rcv_Mon;
import com.example.assignment.Adapter.Adapter_Rcv_Tkb;
import com.example.assignment.DAO.DAO_Danh_Sach_Mon;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.Dialog.BottomSheet_List;
import com.example.assignment.R;
import com.example.assignment.model.DanhSachMon;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class Fragment_TimeTable extends Fragment {
    public static FloatingActionButton flTimeTable;
    public BottomSheet_List bottomSheet_list= new BottomSheet_List();
    public static RecyclerView rcvDSMonHoc,rcvLichHoc;
    public static Adapter_Rcv_Mon adapter_rcv_mon;
    public static Adapter_Rcv_Tkb adapter_rcv_tkb;
    public static DAO_Danh_Sach_Mon dao_danh_sach_mon;
    public static ArrayList<DanhSachMon> list_DSMon;
    DbHelper dbHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_timetable, container, false );
        flTimeTable=view.findViewById( R.id.flTimeTable );
        rcvDSMonHoc=view.findViewById( R.id.rcvDSMonHoc );
        rcvLichHoc=view.findViewById( R.id.rcvLichHoc );

        flTimeTable.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog( getContext() );

            }
        } );

        rcvDSMonHoc.setLayoutManager( new LinearLayoutManager( getContext() ) );
        list_DSMon= new ArrayList<>(  );
        dao_danh_sach_mon= new DAO_Danh_Sach_Mon( getContext() );
        list_DSMon = dao_danh_sach_mon.getALL(dbHelper.IDuser.toString());
        adapter_rcv_mon= new Adapter_Rcv_Mon( getContext(),list_DSMon );
        rcvDSMonHoc.setAdapter( adapter_rcv_mon );

        rcvLichHoc.setLayoutManager( new LinearLayoutManager( getContext() ) );
        adapter_rcv_tkb= new Adapter_Rcv_Tkb( getContext(),list_DSMon );
        rcvLichHoc.setAdapter( adapter_rcv_tkb );
        return view;
    }

    public void openDialog(Context context){
        bottomSheet_list.show(((AppCompatActivity) context).getSupportFragmentManager(),bottomSheet_list.getTag());
    }
}
