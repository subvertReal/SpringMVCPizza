// 991705874, Sherjeel Khan

package com.example.springmvcpizzaapp.model;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class PizzaOrder {
    // Basic info
    private int id;

    @NotBlank(message = "Please enter your name")
    private String custName;

    private LocalDateTime orderTime;

    // quantity info

    @Min(value = 1, message = "The quantity must be 1 to 10")
    @Max(value = 10, message = "The quantity must be 1 to 10")
    private int quantity;

    // delivery info
    private boolean doDelivery;
    private String deliveryAddress; // only request if doDelivery == TRUE

    // if doDelivery == true, make sure there is a delivery address entered
    @AssertTrue(message = "Delivery address is required if delivery is selected")
    public boolean isDeliveryAddressValid() {
        if (doDelivery) {
            return deliveryAddress != null && !deliveryAddress.isBlank();
        }
        return true;
    }


    // info regarding pizza

    private PizzaSize size;

    private PizzaToppings topping;

    private PizzaCrust crust;

    // pricing info
    private double discountAmount;
    private double taxes = 0.13;

    private double subTotal;
    private double finalTotal;

    // getters and setters
    public void setOrderTime(LocalDateTime now) {
        this.orderTime = now;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void  setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCrust(){
        this.crust = crust;
    }

    public int getQuantity() {
        return quantity;
    }
    public PizzaSize getSize() {
        return size;
    }

    public PizzaToppings getTopping() {
        return topping;
    }

    public PizzaCrust getCrust() {
        return crust;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setTopping(PizzaToppings topping) {
        this.topping = topping;
    }

    public void setCrust(PizzaCrust crust) {
        this.crust = crust;
    }

    public boolean isDoDelivery() {
        return doDelivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public double getToppingsPrice(){
        return 1.25;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getSubTotal() {
        //size
        if (getSize() == PizzaSize.SMALL){
            subTotal = 8.00 + getToppingsPrice();
        }
        else if (getSize() == PizzaSize.MEDIUM){
            subTotal = 10.00 + getToppingsPrice();
        }
        else{
            subTotal = 12.00 + getToppingsPrice();
        }

        //discount
        if(quantity > 3){
            discountAmount = subTotal * 0.1;
            subTotal = subTotal - discountAmount;
        }

        //delivery
        if(doDelivery){
            subTotal = subTotal+3.99;
            System.out.println("Price: " + subTotal);
            return subTotal;

        }
        else {
            return subTotal;
        }

    }

    public double getTaxes() {
        return taxes;
    }

    public double getFinalTotal() {
        subTotal = subTotal + subTotal*taxes;


        return subTotal;
    }


    public void setDoDelivery(boolean doDelivery) {
        this.doDelivery = doDelivery;
    }
    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setPizzaSize(PizzaSize size) {
        this.size = size;
    }

    public void setPizzaToppings(PizzaToppings topping) {
        this.topping = topping;
    }

    public void setPizzaCrust(PizzaCrust crust) {
        this.crust = crust;
    }


}
