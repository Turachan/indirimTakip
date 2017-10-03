package indirimtakip.rt.com.indirimtakip.utils.enumUtil;

/**
 * Created by Appledore on 03/10/2017.
 */

public enum MarkaEnum {
    KOTON("Koton", 0),
    LCW("Lcw", 1),
    BOYNER("Boyner", 2),
    DEFACTO("Defacto", 3);

    private Integer code;
    private String desc;

    private MarkaEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
