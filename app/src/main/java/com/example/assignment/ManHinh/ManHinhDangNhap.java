package com.example.assignment.ManHinh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

;import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.DAO.DAO_User;
import com.example.assignment.Database.DbHelper;
import com.example.assignment.R;

public class ManHinhDangNhap extends AppCompatActivity {
    Button btnDangNhap,btnDangKy;
    EditText edtUser,edtPass;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    public DAO_User userDAO;
    public DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_login );
        btnDangNhap=findViewById( R.id.btnDangNhap );
        btnDangKy=findViewById( R.id.btnDangKy );
        edtUser=findViewById( R.id.edtUser );
        edtPass=findViewById( R.id.edtPass );

        saveLoginCheckBox = (CheckBox)findViewById(R.id.saveLoginCheckBox);
        userDAO = new DAO_User( this );

        loginPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edtUser.setText(loginPreferences.getString("username", ""));
            edtPass.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        final int[] count = {0};
        btnDangNhap.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUser.getText().toString();
                String password = edtPass.getText().toString();

                for(int i=0; i<userDAO.getUser().size();i++) {
                    if(edtUser.getText().toString().equalsIgnoreCase( userDAO.getUser().get( i ).getUsername()) && edtPass.getText().toString().equalsIgnoreCase( userDAO.getUser().get( i ).getPassword())  ) {
                        Intent intentManHinhKH = new Intent( ManHinhDangNhap.this, ManHinhChinhAdmin.class );
                        dbHelper.IDuser = userDAO.getUser().get( i ).getAccountID();
                        dbHelper.PassUser = userDAO.getUser().get( i ).getPassword();
                        dbHelper.Username = userDAO.getUser().get( i ).getUsername();
                        count[0]++;
                        if (saveLoginCheckBox.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username", username);
                            loginPrefsEditor.putString("password", password);
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }
                        startActivity( intentManHinhKH );
                        overridePendingTransition( android.R.anim.fade_in,android.R.anim.fade_out);
                    }
                }
                if(count[0]==0) {
                    edtUser.setError( "Bạn đã nhập sai thông tin User Name hoặc Password" );
                    edtPass.setError( "Bạn đã nhập sai thông tin User Name hoặc Password" );
                }

            }
        } );
        btnDangKy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentActivitySignin = new Intent(getBaseContext(), ManHinhDangKy.class);
                startActivity( intentActivitySignin );
                overridePendingTransition( android.R.anim.slide_in_left,android.R.anim.fade_out);
            }
        } );
    }
}
