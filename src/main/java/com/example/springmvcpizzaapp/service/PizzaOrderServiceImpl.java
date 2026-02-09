// 991705874, Sherjeel Khan
package com.example.springmvcpizzaapp.service;

import com.example.springmvcpizzaapp.model.PizzaOrder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {

    private final List<PizzaOrder> orders = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public PizzaOrder placeOrder(PizzaOrder order) {


        order.setId(idCounter++);
        order.setOrderTime(LocalDateTime.now());



        orders.add(order);
        System.out.println("Order: " + order.getTaxes());
        return order;
    }

    @Override
    public List<PizzaOrder> getOrderHistory() {
        return orders;
    }
}
