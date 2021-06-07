package com.example.assignment.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Adapter.Adapter_Rcv_Exam;
import com.example.assignment.Adapter.Adapter_Rcv_Tkb;
import com.example.assignment.DAO.DAO_Danh_Sach_Mon;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.Dialog.BottomSheet_List;
import com.example.assignment.R;
import com.example.assignment.model.DanhSachMon;

import java.util.ArrayList;
import java.util.Random;


public class Fragment_Exam extends Fragment {
    public static RecyclerView rcvLichHoc;
    public static Adapter_Rcv_Exam adapter_rcv_exam;
    public static DAO_Danh_Sach_Mon dao_danh_sach_mon;
    public static ArrayList<DanhSachMon> list_DSMon;
    DbHelper dbHelper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_exam, container, false );
        rcvLichHoc=view.findViewById( R.id.rcvLichHoc );

        list_DSMon= new ArrayList<>(  );
        dao_danh_sach_mon= new DAO_Danh_Sach_Mon( getContext() );
        list_DSMon = dao_danh_sach_mon.getALL(dbHelper.IDuser.toString());
        rcvLichHoc.setLayoutManager( new LinearLayoutManager( getContext() ) );
        adapter_rcv_exam= new Adapter_Rcv_Exam( getContext(),list_DSMon );
        rcvLichHoc.setAdapter( adapter_rcv_exam );
        return view;
    }
}
