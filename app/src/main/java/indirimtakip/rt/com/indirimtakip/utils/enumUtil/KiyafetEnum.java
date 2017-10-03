package indirimtakip.rt.com.indirimtakip.utils.enumUtil;

/**
 * Created by Appledore on 03/10/2017.
 */

public enum KiyafetEnum {

    MONT("Mont", 0),
    KAZAK("Kazak", 1),
    T_SHIRT("T-Shirt", 2),
    GOMLEK("GÖMLEK", 3);

    private Integer code;
    private String desc;

    private KiyafetEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
