package entity;

/**
 * Created by yapiti on 03/04/15.
 */
public class OutputResult {
    public int status;

    public OutputResult(int status) {
        this.status = status;
    }

    public OutputResult() {
        status=SUCCESSS;
    }


    public static final int FIELD_MISSING=2;
    public static final int ENTITY_ALREADY_EXIST=8;
    public static final int BAD_PASSWORD=6;
    public static final int FIELD_DATE=4;
    public static final int SUCCESSS=42;
}
