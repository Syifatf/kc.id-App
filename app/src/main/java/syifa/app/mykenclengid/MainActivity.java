package syifa.app.mykenclengid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import syifa.app.mykenclengid.adapter.Adapter;
import syifa.app.mykenclengid.handler.DatabaseHandler;
import syifa.app.mykenclengid.model.Data;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> itemList = new ArrayList<Data>();
    Adapter adapter;
    DatabaseHandler SQLite = new DatabaseHandler(this);

    public static final String TAG_ID = "id";
    public static final String TAG_RADIOBUTTON = "radio";
    public static final String TAG_NOMINAL = "nominal";
    public static final String TAG_CATATAN = "catatan";
    public static final String TAG_TANGGAL = "tanggal";

//    RadioButton radio_masuk, radio_keluar;
//    EditText nominal, catatan, tanggal;
//    Button btnSimpan, btnBatal;
//    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SQLite = new DatabaseHandler(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.lst_kencleng);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        adapter = new Adapter(MainActivity.class, itemList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, final long id) {

                final String idx = itemList.get(position).getId();
                final String radio = itemList.get(position).getRadio();
                final String nominal = itemList.get(position).getNominal();
                final String catatan = itemList.get(position).getCatatan();
                final String tanggal = itemList.get(position).getTanggal();

                final CharSequence[] dialogitem = {"Edit", "Delete"};
                dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setCancelable(true);
                AlertDialog show = dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                                intent.putExtra(TAG_ID, idx);
                                intent.putExtra(TAG_RADIOBUTTON, radio);
                                intent.putExtra(TAG_CATATAN, catatan);
//                                intent.putExtra(TAG_TANGGAL), tanggal;
                                startActivity(intent);
                                break;

                            case 1:
                                SQLite.delete(Integer.parseInt(idx));
                                itemList.clear();
                                getAllData();
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });

        getAllData();
    }

    private void getAllData() {
        ArrayList<HashMap<String, String>> row = SQLite.getAllData();

        for (int i = 0; i < row.size(); i++) {
            String id = row.get(i).get(TAG_ID);
            String radio = row.get(i).get(TAG_RADIOBUTTON);
            String nominal = row.get(i).get(TAG_NOMINAL);
            String catatan = row.get(i).get(TAG_CATATAN);
            String tanggal = row.get(i).get(TAG_TANGGAL);

            Data data = new Data();

            data.setId(id);
            data.setRadio(radio);
            data.setNominal(nominal);
            data.setCatatan(catatan);
            data.setTanggal(tanggal);

            itemList.add(data);
        }
        adapter.notify();
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemList.clear();
        getAllData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
