package com.example.springmvcpizzaapp.controller;

import com.example.springmvcpizzaapp.model.*;
import com.example.springmvcpizzaapp.service.PizzaOrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PizzaController {

    private final PizzaOrderService service;

    public PizzaController(PizzaOrderService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showForm(Model model) {

        int a = 0;
        model.addAttribute("pizzaOrder", new PizzaOrder());
        model.addAttribute("sizes", PizzaSize.values());
        model.addAttribute("crusts", PizzaCrust.values());
        model.addAttribute("toppings", PizzaToppings.values());



        return "OrderForm";
    }

    @PostMapping("/submit")
    public String submitOrder(
            @Valid @ModelAttribute PizzaOrder pizzaOrder,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("sizes", PizzaSize.values());
            model.addAttribute("crusts", PizzaCrust.values());
            model.addAttribute("toppings", PizzaToppings.values());
            return "OrderForm";
        }


//        System.out.println("Crust: " + pizzaOrder.getCrust());
//        System.out.println("Topping: " + pizzaOrder.getTopping());
        model.addAttribute("order", service.placeOrder(pizzaOrder));
        return "Summary";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("orders", service.getOrderHistory());
        return "History";
    }
}
