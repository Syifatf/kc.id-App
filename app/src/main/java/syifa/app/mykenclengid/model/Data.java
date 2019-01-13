package syifa.app.mykenclengid.model;

/**
 * Created by USER on 11/01/2019.
 */

public class Data {

    static String id;
    static String radio;
    static String nominal;
    static String catatan;
    static String tanggal;

    public Data() {
        this.id = id;
        this.radio = radio;
        this.nominal = nominal;
        catatan = catatan;
        tanggal = tanggal;
    }

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
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
