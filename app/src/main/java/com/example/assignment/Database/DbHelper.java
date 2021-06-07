package com.example.assignment.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper
{
    public static Integer IDuser= null;
    public static String PassUser= null;
    public static String Username= null;
    static final String DbName = "QLHS";
    static final int Version = 1;
    public DbHelper(@Nullable Context context) {
        super(context, DbName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE ACCOUNT(" +
                "accountID INTEGER primary key autoincrement," +
                "userName CHAR(20)," +
                "passWord CHAR(50)," +
                "fullName CHAR(50)," +
                "address CHAR(100)," +
                "phoneNumber CHAR(10))");

        db.execSQL("INSERT INTO ACCOUNT(userName,passWord,fullName,address,phoneNumber) VALUES('admin','123','Hoàng Thiên Chương','Long Khánh - Đồng Nai','0933961814')");
        db.execSQL("INSERT INTO ACCOUNT(userName,passWord,fullName,address,phoneNumber) VALUES('chuong','123','Hoàng Thiên Chương','Long Khánh - Đồng Nai','0933961814')");
        db.execSQL("INSERT INTO ACCOUNT(userName,passWord,fullName,address,phoneNumber) VALUES('phong','123','Dương Tấn Nhật Phong','An Giang','0936733444')");

        db.execSQL("CREATE TABLE NGANH(" +
                "nganhID CHAR(20) primary key ," +
                "tenNganh CHAR(20))");
        db.execSQL("INSERT INTO NGANH(nganhID,tenNganh) VALUES('CNTT','CÔNG NGHỆ THÔNG TIN')");
        db.execSQL("INSERT INTO NGANH(nganhID,tenNganh) VALUES('KT','KINH TẾ')");
        db.execSQL("INSERT INTO NGANH(nganhID,tenNganh) VALUES('QL','DU LỊCH - NHÀ HÀNG - KHÁCH SẠN')");

        db.execSQL("CREATE TABLE CHUYEN_NGANH(" +
                "chuyenNganhID CHAR(20) primary key ," +
                "tenChuyenNganh CHAR(20)," +
                "nganhID CHAR(20) REFERENCES NGANH(nganhID))");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('UDPM','Ứng dụng phần mềm','CNTT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('LTAD','Lập trình Android','CNTT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('LTW','Lập trình web','CNTT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('TKDH','Thiết kế đồ họa','CNTT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('DMO','Digital Marketing Online','KT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('PR','PR & Tổ chức sự kiện','KT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('SALE','Sales','KT')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('KS','QT Khách sạn','QL')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('NH','QT Nhà hàng','QL')");
        db.execSQL("INSERT INTO CHUYEN_NGANH(chuyenNganhID,tenChuyenNganh,nganhID) VALUES('HDVDL','Hướng dẫn viên du lịch','QL')");

        db.execSQL("CREATE TABLE MONHOC(" +
                "monID CHAR(20) primary key ," +
                "tenMon CHAR(20)," +
                "tinChi INTEGER," +
                "chuyenNganhID CHAR(20) REFERENCES CHUYEN_NGANH(chuyenNganhID))");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KTHTCS','Kiến thức học tập cơ sở',10,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('CSPTS','Chỉnh sửa hình ảnh với Photoshop',15,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('HTML','Cơ bản về HTML/ CSS',15,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('CSDL','Cơ bản về cơ sở dữ liệu',5,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('JV1','Java 1',20,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('JV2','Java 2',20,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QTSW','Quản trị server windows 2008',15,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('XTJV','Chuyên đề các xu thế mới của công nghệ Java ,framework',15,'UDPM')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('NMMT','Nhập môn máy tính',5,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('PTS','Photoshop',10,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('LTAD','Lập trình Android',10,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('LTADNC','Lập trình Android nâng cao',20,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('DAM','Dự án mẫu',20,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TKG','Thiết kế game với Unity',20,'LTAD')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('CBDT','Chế bản điện tử với InDesign',15,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('HTML1','Cơ bản về HTML/ CSS',15,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QTW','Quản trị website',20,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('JVS','Lập trình cơ bản với JavaScript',20,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('PHP','PHP nâng cao',10,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('SEO',' SEO website',20,'LTW')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KNHT',' Kỹ năng học tập',5,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('THCS',' Tin học cơ sở',10,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('THVP',' Tin học văn phòng',5,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('CSPTS1','Chỉnh sửa hình ảnh với Photoshop',25,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('FLASH','Thiết kế đa truyền thông với Flash',5,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('HTML5','Thiết kế web với HTML5/CSS3',10,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('3DMAX','Thiết kế đồ họa động với 3D Studio Max',20,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('2D','Autocad 2D',10,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('NV3D','Thiết kế tạo hình nhân vật trong 3D',20,'TKDH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KNHT1',' Kỹ năng học tập',5,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('MKT','Marketing căn bản',10,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('THVP1',' Tin học văn phòng',5,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TMDT','Tổng quan thương mại điện tử',20,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('XDW','Xây dựng trang web',20,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('XDW2','Xây dựng trang web 2',10,'DMO')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('NMQH','Nhập môn Quan hệ',10,'PR')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KNPV','Kỹ năng phỏng vấn và trả lời phỏng vấn',5,'PR')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QTSK','Quản trị sự kiện',10,'PR')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TTCC','Kỹ năng thuyết trình trước công chúng',10,'PR')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KNST','Kỹ năng sáng tạo',15,'PR')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KTQC','Kiến thức về Quảng cáo',5,'SALE')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KTQHCC','Kiến thức về Quan hệ công chúng',10,'SALE')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KTQTDN','Kiến thức cơ bản về quản trị doanh nghiệp',10,'SALE')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QTBH','Nhập môn quản trị doanh nghiệp',15,'SALE')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KTBH','Kiến thức về kỹ năng bán hàng',10,'SALE')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TQDLNHKS','Tổng quan Du lịch – Nhà hàng – Khách sạn',10,'KS')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TLKN','Tâm lý và kỹ năng giao tiếp, ứng xử với du khách',20,'KS')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('THVP2',' Tin học văn phòng',5,'KS')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TACN','Tiếng Anh chuyên ngành',10,'KS')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TCSK','Tổ chức sự kiện',20,'NH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('NVLT','Nghiệp vụ lễ tân',10,'NH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('NVB1','Nghiệp vụ bar 1',15,'NH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QTNNL','Quản trị nguồn nhân lực',5,'NH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('VHAT','Văn hóa ẩm thực',20,'NH')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('DLDL','Địa lý du lịch và tài nguyên Việt Nam',10,'HDVDL')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('CTPL','Chính trị, pháp luật',10,'HDVDL')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('QLCLDL','Quản lý chất lượng dịch vụ trong du lịch',5,'HDVDL')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('KSDN','Khởi sự doanh nghiệp',20,'HDVDL')");
        db.execSQL("INSERT INTO MONHOC(monID,tenMon,tinChi,chuyenNganhID) VALUES('TTNVHD','Thực tập nghiệp vụ hướng dẫn',20,'HDVDL')");

        db.execSQL("CREATE TABLE DANHSACHMON(" +
                "danhSachMonID INTEGER primary key AUTOINCREMENT ," +
                "tenMon CHAR(20)," +
                "tinChi INTEGER," +
                "ngay CHAR(20)," +
                "phong CHAR(20)," +
                "gio CHAR(20)," +
                "monID CHAR(20) REFERENCES MONHOC(monID)," +
                "nganhID CHAR(20)REFERENCES NGANH(nganhID)," +
                "chuyenNganhID CHAR(20) REFERENCES CHUYEN_NGANH(chuyenNganhID)," +
                "accountID INTEGER REFERENCES ACCOUNT(accountID))");
}

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS NGANH");
        db.execSQL("DROP TABLE IF EXISTS CHUYEN_NGANH");
        db.execSQL("DROP TABLE IF EXISTS MONHOC");
    }
}
