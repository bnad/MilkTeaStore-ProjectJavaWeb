/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.dtos.TeaDTO;

/**
 *
 * @author Bui Be Bong
 */
public class CartObject {

    private List<TeaDTO> items;
    private float total;

    public CartObject() {
    }

    public CartObject(List<TeaDTO> items, float total) {
        this.items = items;
        this.total = total;
    }

    public List<TeaDTO> getItems() {
        return items;
    }

    public void setItems(List<TeaDTO> items) {
        this.items = items;
    }

    public void addItem(TeaDTO dto) {
        if (items == null) {
            items = new ArrayList<>();
        }

        if (items.isEmpty()) {
            items.add(dto);
        } else {
            for (TeaDTO tea : items) {
                if (tea.getTeaID().equalsIgnoreCase(dto.getTeaID())
                        && tea.getSize() == dto.getSize() && tea.getIce() == dto.getIce() && tea.getSugar() == dto.getSugar()
                        && ((tea.getTopping() == null && dto.getTopping() == null) || tea.getTopping().equalsIgnoreCase(dto.getTopping()))) {
                    int quantity = tea.getQuantity() + dto.getQuantity();
                    tea.setQuantity(quantity);
                } else {
                    items.add(dto);
                    break;
                }
            }
        }
    }

    public void removeItem(TeaDTO dto) {
        if (items == null) {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTeaID().equalsIgnoreCase(dto.getTeaID())
                    && items.get(i).getSize() == dto.getSize() && items.get(i).getIce() == dto.getIce() && items.get(i).getSugar() == dto.getSugar()
                    && ((items.get(i).getTopping() == null && dto.getTopping() == null) || items.get(i).getTopping().equalsIgnoreCase(dto.getTopping()))) {
                items.remove(i);
                break;
            }
        }
        if (items.isEmpty()) {
            items = null;
        }
    }

    public void updateItem(TeaDTO dto) {
        if (items == null) {
            return;
        }
        for (TeaDTO tea : items) {
            if (tea.getTeaID().equalsIgnoreCase(dto.getTeaID())
                    && tea.getSize() == dto.getSize() && tea.getIce() == dto.getIce() && tea.getSugar() == dto.getSugar()
                    && ((tea.getTopping() == null && dto.getTopping() == null) || tea.getTopping().equalsIgnoreCase(dto.getTopping()))) {
                tea.setQuantity(dto.getQuantity());
            }
        }
    }

    public float getTotal() {
        float total = 0;
        for (TeaDTO tea : items) {
            total += tea.getTotal();
        }
        return total;
    }
}
