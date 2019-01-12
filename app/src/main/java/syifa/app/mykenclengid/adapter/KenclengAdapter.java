package syifa.app.mykenclengid.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import syifa.app.mykenclengid.MainActivity;
import syifa.app.mykenclengid.R;
import syifa.app.mykenclengid.model.KenclengModels;

/**
 * Created by USER on 12/01/2019.
 */

public class KenclengAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    List<KenclengModels> items;
    private View convertView;

    public KenclengAdapter(Activity activity, LayoutInflater inflater, List<KenclengModels> items) {
        this.activity = activity;
        this.inflater = inflater;
        this.items = items;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, null);

        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView status = (TextView) convertView.findViewById(R.id.radioPemasukan);
        TextView status2 = (TextView) convertView.findViewById(R.id.radiopengeluaran);
        TextView nominal = (TextView) convertView.findViewById(R.id.nominal);
        TextView catatan = (TextView) convertView.findViewById(R.id.catatan);
        TextView tanggal = (TextView) convertView.findViewById(R.id.tanggal);

        KenclengModels kenclengModels = items.get(i);

        id.setText(KenclengModels.getId());
        status.setText(KenclengModels.getStatus());
        status2.setText(KenclengModels.getStatus());
        nominal.setText(KenclengModels.getNominal());
        catatan.setText(KenclengModels.getCatatan());
        tanggal.setText(KenclengModels.getTanggal());

        return convertView;
    }
}
