package nhutlm.lamodafashion.models;

import com.google.gson.annotations.Expose;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */

public class Thumbnails {
    @Expose
    private Image small;
    @Expose
    private Image large;

    public class Image{
        @Expose
        private String url;
        @Expose
        private int width;
        @Expose
        private int height;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public Image getSmall() {
        return small;
    }

    public void setSmall(Image small) {
        this.small = small;
    }

    public Image getLarge() {
        return large;
    }

    public void setLarge(Image large) {
        this.large = large;
    }
}
