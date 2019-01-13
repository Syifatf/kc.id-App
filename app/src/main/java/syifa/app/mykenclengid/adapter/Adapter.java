package syifa.app.mykenclengid.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import syifa.app.mykenclengid.MainActivity;
import syifa.app.mykenclengid.R;
import syifa.app.mykenclengid.model.Data;

/**
 * Created by USER on 12/01/2019.
 */

public class Adapter extends BaseAdapter {

    private Class<MainActivity> activity;
    private LayoutInflater inflater;
    List<Data> items;

    public Adapter(Class<MainActivity> activity, List<Data> items) {
        this.activity = activity;
//        this.inflater = inflater;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if (inflater == null) {
//            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);

        TextView id = convertView.findViewById(R.id.text_id);
        TextView radio = convertView.findViewById(R.id.txt_radio);
        TextView nominal = convertView.findViewById(R.id.nominal);
        TextView catatan = convertView.findViewById(R.id.catatan);
        TextView tanggal = convertView.findViewById(R.id.tanggal);

        Data data = items.get(position);

        id.setText(Data.getId());
        radio.setText(Data.getRadio());
        nominal.setText(Data.getNominal());
        catatan.setText(Data.getCatatan());
        tanggal.setText(Data.getTanggal());

        return convertView;
    }
}
