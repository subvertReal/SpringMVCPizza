package com.example.springmvcpizzaapp.model;

import jakarta.validation.constraints.*;

public class PizzaOrder {
    // Basic info
    private int id;

    @NotBlank(message = "Please enter your name")
    private String custName;

    // quantity info
    @NotBlank
    @Min(value = 1, message = "The quanitity must be 1 to 100")
    @Max(value = 10, message = "The quanitity must be 1 to 100")
    private int quantity;

    // delivery info
    private boolean doDelivery;
    private String deliveryAddre; // only request if doDelivery == TRUE

    // if doDelivery == true, make sure there is a delivery address entered
    @AssertTrue(message = "Delivery address is required if delivery is selected")
    public boolean isDeliveryAddressValid() {
        if (doDelivery) {
            return deliveryAddre != null && !deliveryAddre.isBlank();
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
    private PizzaOrder crust;

}
