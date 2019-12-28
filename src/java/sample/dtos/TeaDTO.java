/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;

/**
 *
 * @author Bui Be Bong
 */
public class TeaDTO implements Serializable{
    private String teaID;
    private String teaName;
    private int quantity;
    private float price, size;
    private int sugar;
    private int ice;
    private String topping;
    private float total;

    public TeaDTO() {
    }
    
    public TeaDTO(String teaID, int quantity, float size, int sugar, int ice, String topping) {
        this.teaID = teaID;
        this.quantity = quantity;
        this.size = size;
        this.sugar = sugar;
        this.ice = ice;
        this.topping = topping;
    }
    
    
    public TeaDTO(String teaID, String teaName, float price) {
        this.teaID = teaID;
        this.teaName = teaName;
        this.price = price;
    }

    public float getTotal() {
        return (price + size + (topping != null ? 10000 : 0)) * quantity;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    
    public String getTeaID() {
        return teaID;
    }

    public void setTeaID(String teaID) {
        this.teaID = teaID;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getIce() {
        return ice;
    }

    public void setIce(int ice) {
        this.ice = ice;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
    
    
}
