package vn.edu.ntu.ngocdoan.vungocdoan_59130336_simplewidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtNgaySinh, edtSoThich;
    RadioGroup rdgGioiTinh;
    CheckBox cbXemPhim, cbNgheNhac, cbCafe, cbNha, cbNauAn;
    Button btnXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddView();
        AddEvent();
    }

    private void AddView()
    {
        edtTen = findViewById(R.id.edtTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtSoThich = findViewById(R.id.edtSoThich);
        rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
        cbXemPhim = findViewById(R.id.cbXemPhim);
        cbNgheNhac = findViewById(R.id.cbNgheNhac);
        cbCafe = findViewById(R.id.cbCafe);
        cbNha = findViewById(R.id.cbNha);
        cbNauAn = findViewById(R.id.cbNauAn);
        btnXacNhan = findViewById(R.id.btnXacNhan);
    }

    private void AddEvent()
    {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xacNhan();
            }
        });
    }

    private void xacNhan()
    {
        //Hiển thị tên & ngày sinh
        String hienThi = "";
        hienThi = "Tên: " + edtTen.getText() + "\n"
                + "Ngày Sinh: " + edtNgaySinh.getText() + "\n";

        //Hiển thị giới tính
        switch (rdgGioiTinh.getCheckedRadioButtonId())
        {
            //Nếu click vào rb Nam
            case R.id.rbNam:
                hienThi = hienThi + "Giới tính: " + "Nam" + "\n";
            //Nếu clik vào rb Nữ
            case R.id.rbNu:
                hienThi = hienThi + "Giới tính: " + "Nữ" + "\n";
        }

        //Hiển thị sở thích
        hienThi = hienThi + "Sở thích: " + checkBox();
        Toast.makeText(MainActivity.this, hienThi, Toast.LENGTH_SHORT).show();
    }

    private String checkBox()
    {
        String hienThi = "";
        CheckBox[] cb = new CheckBox[]{cbXemPhim, cbNgheNhac, cbCafe, cbNha, cbNauAn};
        for (int i = 0; i < cb.length; i++)
        {
            if (cb[i].isChecked())
            {
                hienThi = hienThi + cb[i].getText().toString() + ";";
            }
        }
        //Sở thích khác
        hienThi = hienThi + edtSoThich.getText();
        return hienThi;
    }
}
