package syifa.app.mykenclengid;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import syifa.app.mykenclengid.handler.DatabaseHandler;
import syifa.app.mykenclengid.handler.RequestHandler;

public class EditActivity extends AppCompatActivity {

    RadioButton radio_masuk, radio_keluar;
    EditText nominal;
    EditText catatan;
    EditText tanggal;
    Button btnSimpan, btnBatal;

    String status;

    RequestHandler requestHandler;
//    DatabaseHandler SQLite = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        radio_masuk = (RadioButton) findViewById(R.id.radioPemasukan);
        radio_keluar = (RadioButton) findViewById(R.id.radioPengeluaran);
        nominal = (EditText) findViewById(R.id.nominal);
        catatan = (EditText) findViewById(R.id.catatan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnBatal = (Button) findViewById(R.id.btnBatal);




//        SQLiteDatabase db = DatabaseHandler.g
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
