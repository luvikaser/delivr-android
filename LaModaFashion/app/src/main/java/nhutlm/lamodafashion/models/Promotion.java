package nhutlm.lamodafashion.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by cpu1-216-local on 22/05/2017.
 */

public class Promotion implements Serializable {
    @Expose
    private String id;
    @Expose
    private Fields fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}

