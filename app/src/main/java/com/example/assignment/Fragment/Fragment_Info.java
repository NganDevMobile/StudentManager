package com.example.assignment.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignment.DAO.DAO_User;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.R;
import com.example.assignment.model.User;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class Fragment_Info extends Fragment {

    public DAO_User userDAO;
    ArrayList<User> list;
    TextView tvName,tvPhoneNumber,tvAddress,tvUser;
    EditText edtFullName,edtAddress,edtPhoneNumber,edtUser;
    DbHelper dbHelper;
    User user;
    Button btnChangeIf,btnChange;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_info, container, false );
        userDAO = new DAO_User( getContext() );
        tvName = view.findViewById( R.id.tvName );
        tvPhoneNumber = view.findViewById( R.id.tvPhoneNumber );
        tvAddress = view.findViewById( R.id.tvAddress );
        tvUser = view.findViewById( R.id.tvUser );
        btnChangeIf= view.findViewById( R.id.btnChangeIf );
        tvUser.setText( dbHelper.Username );

        setData();
        btnChangeIf.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog( getContext() );
            }
        } );
        return view;
    }
    public void openDialog(Context context){
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog( context );
        bottomSheetDialog.setContentView( R.layout.bottom_sheet_edit_inf );
        final String userName= dbHelper.Username;
        btnChange = bottomSheetDialog.findViewById( R.id.btnChange );
        edtFullName = bottomSheetDialog.findViewById( R.id.edtFullName );
        edtAddress = bottomSheetDialog.findViewById( R.id.edtAddress );
        edtPhoneNumber = bottomSheetDialog.findViewById( R.id.edtPhoneNumber );
        edtUser= bottomSheetDialog.findViewById( R.id.edtUser );
        edtPhoneNumber.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getPhoneNumber(  ));
        edtUser.setText( userName );
        edtFullName.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getFullName(  ));
        edtAddress.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getAddress(  ) );
        btnChange.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ID= dbHelper.IDuser;
                String fullName =edtFullName.getText().toString();
                String adress = edtAddress.getText().toString();
                String phoneNumber = edtPhoneNumber.getText().toString();
                if(phoneNumber.length()==10) {
                    user = new User( ID, userName, fullName, adress, phoneNumber );
                    userDAO = new DAO_User( getContext() );
                    userDAO.update( user );
                    Toast.makeText( getContext(), "Đổi thông tin thành công", Toast.LENGTH_SHORT ).show();
                    bottomSheetDialog.dismiss();
                    setData();
                }else{
                    Toast.makeText( getContext(), "Số điện thoại chỉ có 10 số, hãy kiểm tra lại.", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        bottomSheetDialog.show();
    }
    public void setData(){
        tvName.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getFullName(  ));
        tvPhoneNumber.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getPhoneNumber(  ));
        tvAddress.setText( userDAO.getUser( dbHelper.IDuser ).get( 0 ).getAddress(  ) );
    }

}
