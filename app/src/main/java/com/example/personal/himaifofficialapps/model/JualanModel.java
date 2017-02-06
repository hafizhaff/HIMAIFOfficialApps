package com.example.personal.himaifofficialapps.model;

/**
 * Created by rahmatridham on 8/17/2016.
 */
public class JualanModel {
    String urlPhoto,namaItem,desc,price;

    public JualanModel(String urlPhoto, String namaItem, String desc, String price) {
        this.urlPhoto = urlPhoto;
        this.namaItem = namaItem;
        this.desc = desc;
        this.price = price;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
