package indirimtakip.rt.com.indirimtakip.core;

/**
 * Created by Appledore on 28/09/2017.
 */

public class BaseModelImpl {
    private Double fiyat;

    private String markaAdi;

    private String urunAdi;


    public Double getFiyat() {
        return fiyat;
    }

    public void setFiyat(Double fiyat) {
        this.fiyat = fiyat;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }
}
