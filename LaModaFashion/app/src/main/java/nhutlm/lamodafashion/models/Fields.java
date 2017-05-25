package nhutlm.lamodafashion.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cpu1-216-local on 23/05/2017.
 */
public class Fields implements Serializable {
    @Expose
    private String Link;
    @Expose
    private String Name;
    @Expose
    private String Start;
    @Expose
    private String Category;
    @Expose
    private String End;
    @Expose
    private String Currency;
    @Expose
    private String Price;
    @Expose
    private String Discount;
    @Expose
    private String Description;
    @Expose
    private List<Picture> Picture;

    public List<String> getMarket() {
        return Market;
    }

    public void setMarket(List<String> market) {
        Market = market;
    }

    @Expose
    private List<String> Market;
    @Expose
    private String createdTime;

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getEnd() {
        return End;
    }

    public void setEnd(String end) {
        End = end;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<nhutlm.lamodafashion.models.Picture> getPicture() {
        return Picture;
    }

    public void setPicture(List<nhutlm.lamodafashion.models.Picture> picture) {
        Picture = picture;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
