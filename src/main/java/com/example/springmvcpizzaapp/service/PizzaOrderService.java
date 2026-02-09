// 991705874, Sherjeel Khan
package com.example.springmvcpizzaapp.service;

import com.example.springmvcpizzaapp.model.PizzaOrder;
import java.util.List;

public interface PizzaOrderService {

    PizzaOrder placeOrder(PizzaOrder order);

    List<PizzaOrder> getOrderHistory();
}