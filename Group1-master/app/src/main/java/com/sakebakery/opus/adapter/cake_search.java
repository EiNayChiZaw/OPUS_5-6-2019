package com.sakebakery.opus.adapter;

public class cake_search {
    private String id;
    private String name;
    private String flavor;
    private Long price;
    private String cakeimage;
    private int active;
    private String description;
    private String icing;
    private String top_deco;
    private String image;
    private String side_deco;

    public cake_search(String id, String name, String flavor, Long price, String cakeimage, int active) {

        this.id = id;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
        this.cakeimage = cakeimage;
        this.active = active;
    }

    public cake_search(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public cake_search() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcing() {
        return icing;
    }

    public void setIcing(String icing) {
        this.icing = icing;
    }

    public String getTop_deco() {
        return top_deco;
    }

    public void setTop_deco(String top_deco) {
        this.top_deco = top_deco;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSide_deco() {
        return side_deco;
    }

    public void setSide_deco(String side_deco) {
        this.side_deco = side_deco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCakeimage() {
        return cakeimage;
    }

    public void setCakeimage(String cakeimage) {
        this.cakeimage = cakeimage;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}