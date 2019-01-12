package syifa.app.mykenclengid.model;

/**
 * Created by USER on 11/01/2019.
 */

public class KenclengModels {

    static int id;
    static String status;
    static String nominal;
    static String catatan;
    static String tanggal;

    public KenclengModels(int id, String status, String nominal) {
        this.id = id;
        this.status = status;
        this.nominal = nominal;
        this.catatan = catatan;
        this.tanggal = tanggal;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public static String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public static String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }


}
