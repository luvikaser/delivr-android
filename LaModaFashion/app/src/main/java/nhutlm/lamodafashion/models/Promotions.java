package nhutlm.lamodafashion.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class Promotions {
    @Expose
    private List<Promotion> records;

    public List<Promotion> getRecords() {
        return records;
    }

    public void setRecords(List<Promotion> records) {
        this.records = records;
    }
}
