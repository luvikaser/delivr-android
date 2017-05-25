package nhutlm.lamodafashion.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */

public class Picture implements Serializable {
    @Expose
    private String id;
    @Expose
    private String url;
    @Expose
    private String filename;
    @Expose
    private int size;
    @Expose
    private String type;
    @Expose
    private Thumbnails thumbnails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }
}
