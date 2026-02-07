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

    @Min(value = 1, message = "The quanitity must be 1 to 10")
    @Max(value = 10, message = "The quanitity must be 1 to 10")
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

    // pricing info
    private double subTotal;
    private double discountAmount;
    private double taxes;
    private double finalTotal;

    // info regarding pizza
    @NotNull(message = "Please enter a pizza size")
    private PizzaSize size;
    @NotNull(message = "Please enter a pizza topping to add")
    private PizzaToppings topping;
    @NotNull(message = "Please enter a pizza crust to add")
    private PizzaCrust crust;


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

    public boolean isDoDelivery() {
        return doDelivery;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
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
