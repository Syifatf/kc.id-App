package syifa.app.mykenclengid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import syifa.app.mykenclengid.handler.DatabaseHandler;
import syifa.app.mykenclengid.handler.RequestHandler;

public class AddEditActivity extends AppCompatActivity {

    private ListView lst_View;
    private String JSON_STRING;

    RadioButton radio_masuk, radio_keluar;
    EditText nominal, catatan, tanggal;
    Button btnSimpan, btnBatal;

    DatabaseHandler SQLite = new DatabaseHandler(this);

    RequestHandler requestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addEdit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radio_masuk = (RadioButton) findViewById(R.id.radioPemasukan);
//        radio_keluar = (RadioButton) findViewById(R.id.radiopengeluaran);
        nominal = (EditText) findViewById(R.id.nominal);
        catatan = (EditText) findViewById(R.id.catatan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnBatal = (Button) findViewById(R.id.btnBatal);

        id = getIntent().getStringExtra(MainActivity.TAG_ID);
        status = getIntent().getStringExtra(MainActivity.TAG_STATUS);
        nominal = getIntent().getStringExtra(MainActivity.TAG_NOMINAL);
        catatan = getIntent().getStringExtra(MainActivity.TAG_CATATAN);
        tanggal = getIntent().getStringExtra(MainActivity.TAG_TANGGAL);

        if (id == null || id "") {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            id.setText(id);
            nominal.setText(nominal);
            catatan.setText(catatan);
            tanggal.setText(tanggal);
        }

        btnSimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    if (id.getText().toString().equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e) {
                    log.e("Submit", e.toString());
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                blank();
                finish();
            }
        });

        private void blank() {
        nominal.requestFocus();
        id.setText(null);
        catatan.setText(null);
        tanggal.setText(null);
    }

    private void save(){
        if ( //String.valueOf(status.getText()).equals(null) || String.valueOf(status.getText()).equals("") ||
            String.valueOf(nominal.getText()).equals(null) || String.valueOf(nominal.getText()).equals("") ||
            String.valueOf(catatan.getText()).equals(null) || String.valueOf(catatan.getText()).equals("") ||
            String.valueOf(tanggal.getText()).equals(null) || String.valueOf(tanggal.getText()).equals("")) {

            Toast,makeText(getApplicationContext(),
                    "mohon isi nominal dan catatann, serta tanggal ", Toast.LENGTH_SHORT).show();
        } else {
            SQLite.update(Integer.perseInt(id.getText().toString().trim()), nominal.getText().toString().trim(), catatan.getText().toString().trim());
            blank();
            finish();
        }

    }

    // pengkondisian

//        String type [] = {"Pengeluaran", "Pemasukan"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, type);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spnType.setAdapter(adapter);
}
