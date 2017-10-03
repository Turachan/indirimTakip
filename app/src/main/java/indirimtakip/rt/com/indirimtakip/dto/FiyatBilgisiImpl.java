package indirimtakip.rt.com.indirimtakip.dto;

import java.util.Date;

/**
 * Created by Appledore on 03/10/2017.
 */

public class FiyatBilgisiImpl {

    private Integer _id;
    private String _markaWeb;
    private Double _fiyat;
    private Date _reqDate;

    public FiyatBilgisiImpl(){

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String get_markaWeb() {
        return _markaWeb;
    }

    public void set_markaWeb(String _markaWeb) {
        this._markaWeb = _markaWeb;
    }

    public Double get_fiyat() {
        return _fiyat;
    }

    public void set_fiyat(Double _fiyat) {
        this._fiyat = _fiyat;
    }

    public Date get_reqDate() {
        return _reqDate;
    }

    public void set_reqDate(Date _reqDate) {
        this._reqDate = _reqDate;
    }
}
