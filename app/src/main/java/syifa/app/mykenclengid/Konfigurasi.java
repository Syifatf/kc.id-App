package syifa.app.mykenclengid;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by USER on 11/01/2019.
 */

public class Konfigurasi extends AppCompatActivity {

    public static final String URL_ADD="http://192.168.43.162/Android/Kencleng/Add.php";
    public static final String URL_GET_ALL = "http://192.168.43.162/Android/Kencleng/tampilData.php";
    public static final String URL_GET_EMP = "http://192.168.43.162/Android/Kencleng/.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.162/Android/Kencleng/Update.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.162/Android/Kencleng/Hapus.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_STATUS = "status";
    public static final String KEY_EMP_NOMINAL = "nominal";
    public static final String KEY_EMP_CATATAN= "catatan";
    public static final String KEY_EMP_TANGGAL = "tanggal";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_STATUS = "status";
    public static final String TAG_NOMINAL = "nominal";
    public static final String TAG_CATATAN = "catatn";
    public static final String TAG_TANGGAL = "tanggal";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
