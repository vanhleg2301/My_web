/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    private Item getItemById(int id) {
        for (Item i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    // Them san pham vao cart
    public void addItem(Item t) {
        // San pham ton tai
        if (getItemById(t.getProduct().getId()) != null) {
            Item i = getItemById(t.getProduct().getId());
            i.setQuantity(i.getQuantity() + t.getQuantity());
            
        }else{
        // chua co san pham
            items.add(t);
        }
    }
    
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney() {
        double t = 0;
        for(Item i:items) {
            t += i.getQuantity()*i.getPrice();
        }
        return t;
    }
    
}
