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
        this.orderTime = orderTime;
    }

    public void setId(long l) {
        this.id = id;
    }
}
