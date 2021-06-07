package com.example.assignment.Dialog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.assignment.Adapter.Adapter_Rcv_Mon;
import com.example.assignment.Adapter.Adapter_Rcv_Tkb;
import com.example.assignment.Adapter.Adapter_Sp_Chuyen_Nganh;
import com.example.assignment.Adapter.Adapter_Sp_Mon;
import com.example.assignment.Adapter.Adapter_Sp_Nganh;
import com.example.assignment.DAO.DAO_Chuyen_Nganh;
import com.example.assignment.DAO.DAO_Danh_Sach_Mon;
import com.example.assignment.DAO.DAO_Mon;
import com.example.assignment.DAO.DAO_Nganh;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.R;

import com.example.assignment.model.ChuyenNganh;
import com.example.assignment.model.DanhSachMon;
import com.example.assignment.model.Mon;
import com.example.assignment.model.Nganh;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Random;

import static com.example.assignment.Fragment.Fragment_TimeTable.adapter_rcv_mon;
import static com.example.assignment.Fragment.Fragment_TimeTable.adapter_rcv_tkb;
import static com.example.assignment.Fragment.Fragment_TimeTable.rcvDSMonHoc;
import static com.example.assignment.Fragment.Fragment_TimeTable.rcvLichHoc;


public class BottomSheet_List extends BottomSheetDialogFragment {
    ArrayList<Nganh> list_Nganh= new ArrayList<>(  );
    ArrayList<ChuyenNganh> list_ChuyenNganh= new ArrayList<>(  );
    ArrayList<Mon> list_Mon = new ArrayList<>(  );
    ArrayList<DanhSachMon> list_DSMon = new ArrayList<>(  );
    Spinner SpnNganhHoc,SpnChuyenNganh,SpnMon;
    DAO_Nganh dao_nganh;
    DAO_Chuyen_Nganh dao_chuyen_nganh;
    DAO_Mon dao_mon;
    DAO_Danh_Sach_Mon dao_danh_sach_mon;
    Adapter_Sp_Nganh adapter_sp_nganh;
    Adapter_Sp_Chuyen_Nganh adapter_sp_chuyen_nganh;
    Adapter_Sp_Mon adapter_sp_mon;
    TextView txtTinChi;
    Button btnDangKy;
    DbHelper dbHelper;
    public static int thang,nam;
    public BottomSheet_List(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view   = inflater.inflate( R.layout.bottom_list,container,false );
        SpnNganhHoc = view.findViewById( R.id.SpnNganhHoc );
        SpnChuyenNganh=view.findViewById( R.id.SpnChuyenNganh );
        SpnMon= view.findViewById( R.id.SpnMon );
        txtTinChi= view.findViewById( R.id.txtTinChi );
        btnDangKy= view.findViewById( R.id.btnDangKy );
        dao_nganh = new DAO_Nganh( getContext() );

        final String[] nganhID = {""};
        final String[] monID = {""};
        final String[] tenMon = {""};
        final int[] tinChi = {0};
        final String[] chuyenNganhID = {""};
        list_Nganh=dao_nganh.getALL();
        adapter_sp_nganh= new Adapter_Sp_Nganh( getContext(),list_Nganh );
        SpnNganhHoc.setAdapter( adapter_sp_nganh );

        SpnNganhHoc.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dao_chuyen_nganh= new DAO_Chuyen_Nganh( getContext() );

                list_ChuyenNganh=dao_chuyen_nganh.getALL( list_Nganh.get( i ).getNganhID() );
                adapter_sp_chuyen_nganh= new Adapter_Sp_Chuyen_Nganh( getContext(),list_ChuyenNganh );
                SpnChuyenNganh.setAdapter( adapter_sp_chuyen_nganh );
                nganhID[0]=list_Nganh.get( i ).getNganhID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        } );

        SpnChuyenNganh.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dao_mon= new DAO_Mon( getContext() );

                list_Mon = dao_mon.getALL( list_ChuyenNganh.get( i ).getChuyenNganhID() );
                adapter_sp_mon = new Adapter_Sp_Mon( getContext(),list_Mon );
                SpnMon.setAdapter( adapter_sp_mon );
                chuyenNganhID[0] = list_ChuyenNganh.get( i ).getChuyenNganhID();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );

        SpnMon.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                txtTinChi.setText( list_Mon.get( i ).getTinChi()+"" );
                monID[0]= list_Mon.get( i ).getMonID();
                tenMon[0]= list_Mon.get( i ).getTenMon();
                tinChi[0] = list_Mon.get( i ).getTinChi();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );
        btnDangKy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ngay = null,phong = null,gio=null;
                Random random = new Random();
                int n = 1+random.nextInt(30);
                int l = 3+random.nextInt(2);
                int p = random.nextInt(9);
                thang = 10+random.nextInt(2);
                nam =2020;
                int hourStart=7+random.nextInt(8);
                int hourEnd=9+random.nextInt(10);
                phong = l+"0"+p;
                ngay = n+"/"+thang+"/"+nam;
                gio = hourStart+"h - "+hourEnd+"h";
                int count=0;
                dao_danh_sach_mon = new DAO_Danh_Sach_Mon( getContext() );
                list_DSMon = dao_danh_sach_mon.getALL(dbHelper.IDuser.toString());
                for(int i=0;i<list_DSMon.size();i++){
                    if(tenMon[0].equalsIgnoreCase( list_DSMon.get( i ).getTenMon() )){
                        count++;
                    }
                    if(phong.equalsIgnoreCase( list_DSMon.get( i ).getPhong() ) && gio.equalsIgnoreCase( list_DSMon.get( i ).getGio() )){
                        while (phong.equalsIgnoreCase( list_DSMon.get( i ).getPhong() )){
                            p = random.nextInt(9);
                            l = 3+random.nextInt(2);
                            phong = l+"0"+p;
                        }
                    }
                }
                if(count==0){
                    int accountID = dbHelper.IDuser;
                    dao_danh_sach_mon = new DAO_Danh_Sach_Mon( getContext() );
                    DanhSachMon danhSachMon= new DanhSachMon( tenMon[0],monID[0],nganhID[0],chuyenNganhID[0],phong,gio,ngay,tinChi[0],accountID );
                    dao_danh_sach_mon.insert( danhSachMon );
                    Toast.makeText( getContext(), "Đăng ký thành công", Toast.LENGTH_SHORT ).show();
                    capNhat();
                    dismiss();
                }else{
                    Toast.makeText( getContext(), "Môn này bạn đã đăng ký rồi!", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        return view;
    }
    public void capNhat(){
        list_DSMon = dao_danh_sach_mon.getALL(dbHelper.IDuser.toString() );
        adapter_rcv_mon= new Adapter_Rcv_Mon(getContext(), list_DSMon);
        rcvDSMonHoc.setAdapter(adapter_rcv_mon);
        adapter_rcv_mon.notifyDataSetChanged();

        adapter_rcv_tkb= new Adapter_Rcv_Tkb(getContext(), list_DSMon);
        rcvLichHoc.setAdapter(adapter_rcv_tkb);
        adapter_rcv_tkb.notifyDataSetChanged();
    }
}
