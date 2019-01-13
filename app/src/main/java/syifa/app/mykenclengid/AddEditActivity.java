package syifa.app.mykenclengid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import syifa.app.mykenclengid.handler.DatabaseHandler;

import static android.widget.Toast.makeText;

public class AddEditActivity extends AppCompatActivity {

    private ListView lst_View;

    EditText text_id, txt_radio, txt_catatan, txt_nominal, txt_tgl;
//    RadioButton radio_masuk, radio_keluar;
//    EditText tanggal;
    Button btnSimpan, btnBatal;
    DatabaseHandler SQLite = new DatabaseHandler(this);

    String id, radio, nominal, catatan, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text_id = (EditText) findViewById(R.id.text_id);
        txt_nominal = (EditText) findViewById(R.id.nominal);
        txt_catatan = (EditText) findViewById(R.id.catatan);
        txt_tgl = (EditText) findViewById(R.id.tanggal);


        id = getIntent().getStringExtra(MainActivity.TAG_ID);
        radio = getIntent().getStringExtra(MainActivity.TAG_RADIOBUTTON);
        nominal = getIntent().getStringExtra(MainActivity.TAG_NOMINAL);
        catatan = getIntent().getStringExtra(MainActivity.TAG_CATATAN);
        tanggal = getIntent().getStringExtra(MainActivity.TAG_TANGGAL);

        if (id == null || id == "") {
            setTitle("Add Data");
        } else {
            setTitle("Edit Data");
            text_id.setText(id);
            txt_nominal.setText(nominal);
            txt_catatan.setText(catatan);
            txt_tgl.setText(tanggal);
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (text_id.getText().toString().equals("")) {
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e) {
                    Log.e("Submit", e.toString());
                }
            }
        });

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blank();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                blank();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void blank() {
        txt_nominal.requestFocus();
        text_id.setText(null);
        txt_radio.setText(null);
        txt_catatan.setText(null);
        txt_tgl.setText(null);
    }

    private void save(){
        if (String.valueOf(txt_radio.getText()).equals(null) || String.valueOf(txt_radio.getText()).equals("") ||
                String.valueOf(txt_nominal.getText()).equals(null) || String.valueOf(txt_nominal.getText()).equals("") ||
                String.valueOf(txt_catatan.getText()).equals(null) || String.valueOf(txt_catatan.getText()).equals("") ||
                String.valueOf(txt_tgl.getText()).equals(null) || String.valueOf(txt_tgl.getText()).equals(""))
            Toast.makeText(getApplicationContext(),
                    "mohon isi nominal dan catatan, serta tanggal ", Toast.LENGTH_SHORT).show();
        else {
            SQLite.insert(txt_radio.getText().toString().trim(),
                    txt_nominal.getText().toString().trim(),
                    txt_catatan.getText().toString().trim(),
                    txt_tgl.getText().toString().trim());
            blank();
            finish();
        }
    }


    private void edit() {
        if (String.valueOf(txt_radio.getText()).equals(null) || String.valueOf(txt_radio.getText()).equals("") ||
                String.valueOf(txt_nominal.getText()).equals(null) || String.valueOf(txt_nominal.getText()).equals("") ||
                String.valueOf(txt_catatan.getText()).equals(null) || String.valueOf(txt_tgl.getText()).equals("")) {
            Toast.makeText(getApplicationContext(),
                    "silahkan isi nominal, catatndan teggal nyaa ", Toast.LENGTH_SHORT).show();
        } else {
            SQLite .update(Integer.parseInt(text_id.getText().toString().trim()), txt_nominal.getText().toString().trim()); txt_catatan.getText().toString().trim();
        }
    }


    }
