package com.example.assignment.ManHinh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.DAO.DAO_User;
import com.example.assignment.R;
import com.example.assignment.model.User;

public class ManHinhDangKy extends AppCompatActivity {
    EditText edtUser,edtPass,edtFullName,edtAddress,edtPhoneNumber;
    Button btnDangKy;
    DAO_User userDAO;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_signup );
        edtUser= findViewById( R.id.edtUser );
        edtPass= findViewById( R.id.edtPass );
        edtFullName= findViewById( R.id.edtFullName );
        edtAddress= findViewById( R.id.edtAddress );
        edtPhoneNumber= findViewById( R.id.edtPhoneNumber );
        btnDangKy=findViewById( R.id.btnDangKy );
        btnDangKy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDAO = new DAO_User( ManHinhDangKy.this );
                int count=0;
                String User = edtUser.getText().toString();
                String Pass = edtPass.getText().toString();
                String FullName = edtFullName.getText().toString();
                String Adress = edtAddress.getText().toString();
                String PhoneNumber = edtPhoneNumber.getText().toString();
                if (!User.equals( "" ) && !Pass.equals( "" ) && !FullName.equals( "" ) && !Adress.equals( "" ) && !PhoneNumber.equals( "" ) && PhoneNumber.length()==10){
                    for(int i= 0;i<userDAO.getUser(  ).size();i++){
                        if(edtUser.getText().toString().equalsIgnoreCase( userDAO.getUser().get( i ).getUsername() )){
                            count++;
                        }
                    }if(count==0) {
                        user = new User( User, Pass, FullName, Adress, PhoneNumber );
                        userDAO.insert( user );
                        Toast.makeText( ManHinhDangKy.this, "Th??m tha??nh c??ng", Toast.LENGTH_SHORT ).show();
                        Intent intentManHinhLogin = new Intent( getBaseContext(), ManHinhDangNhap.class );
                        startActivity( intentManHinhLogin );
                        overridePendingTransition( android.R.anim.slide_out_right,android.R.anim.fade_out);
                    }else{
                        edtUser.setError( "User ???? t???n t???i, b???n h??y ch???n t??n m???i" );
                    }
                }else if(User.equals( "" ) || Pass.equals( "" ) || FullName.equals( "" ) || Adress.equals( "" ) || PhoneNumber.equals( "" )){
                    if(User.equals( "" )){
                        edtUser.setError( "B???n ch??a nh???p User Name" );
                    }
                    if (Pass.equals( "" )){
                        edtPass.setError( "B???n ch??a nh???p Password" );
                    }
                    if (FullName.equals( "" )){
                        edtFullName.setError( "B???n ch??a nh???p Full Name" );
                    }
                    if (Adress.equals( "" )){
                        edtAddress.setError( "B???n ch??a nh???p Address" );
                    }
                    if (PhoneNumber.equals( "" )){
                        edtPhoneNumber.setError( "B???n ch??a nh???p Phone Number" );
                    }
                }else if(PhoneNumber.length()!=10){
                    edtPhoneNumber.setError( "S??? ??i???n tho???i ch??? c?? 10 s???" );
                }
            }
        } );
    }
}
