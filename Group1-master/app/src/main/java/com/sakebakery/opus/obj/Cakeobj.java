package com.sakebakery.opus.obj;

import java.io.Serializable;

public class Cakeobj implements Serializable {

    private String cake_id= "";

    private String cake_name= "";

    private String cake_flavor= "";

    private String icing_flavor= "";

    private String cake_price= "";

    private String side_deco= "";

    private String top_deco= "";

    private String description= "";

    private String cake_image= "";

    private String cake_thumbnail= "";

    private int active= 0;

    public String getCake_id() {
        return cake_id;
    }

    public void setCake_id(String cake_id) {
        this.cake_id = cake_id;
    }

    public String getCake_name() {
        return cake_name;
    }

    public void setCake_name(String cake_name) {
        this.cake_name = cake_name;
    }

    public String getCake_flavor() {
        return cake_flavor;
    }

    public void setCake_flavor(String cake_flavor) {
        this.cake_flavor = cake_flavor;
    }

    public String getIcing_flavor() {
        return icing_flavor;
    }

    public void setIcing_flavor(String icing_flavor) {
        this.icing_flavor = icing_flavor;
    }

    public String getCake_price() {
        return cake_price;
    }

    public void setCake_price(String cake_price) {
        this.cake_price = cake_price;
    }

    public String getSide_deco() {
        return side_deco;
    }

    public void setSide_deco(String side_deco) {
        this.side_deco = side_deco;
    }

    public String getTop_deco() {
        return top_deco;
    }

    public void setTop_deco(String top_deco) {
        this.top_deco = top_deco;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCake_image() {
        return cake_image;
    }

    public void setCake_image(String cake_image) {
        this.cake_image = cake_image;
    }

    public String getCake_thumbnail() {
        return cake_thumbnail;
    }

    public void setCake_thumbnail(String cake_thumbnail) {
        this.cake_thumbnail = cake_thumbnail;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return "Cakeobj{" +
                "cake_id='" + cake_id + '\'' +
                ", cake_name='" + cake_name + '\'' +
                ", cake_flavor='" + cake_flavor + '\'' +
                ", icing_flavor='" + icing_flavor + '\'' +
                ", cake_price='" + cake_price + '\'' +
                ", side_deco='" + side_deco + '\'' +
                ", top_deco='" + top_deco + '\'' +
                ", description='" + description + '\'' +
                ", cake_image='" + cake_image + '\'' +
                ", cake_thumbnail='" + cake_thumbnail + '\'' +
                ", active=" + active +
                '}';
    }
}
