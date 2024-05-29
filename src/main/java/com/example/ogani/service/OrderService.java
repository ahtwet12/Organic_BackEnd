package com.example.ogani.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ogani.entity.Order;
import com.example.ogani.model.request.CreateCategoryRequest;
import com.example.ogani.model.request.CreateOrderRequest;

public interface OrderService {

    void placeOrder(CreateOrderRequest request);

    List<Order> getList();

    List<Order> getOrderByUser(String username);

    Order updateOrder(long orderId, CreateOrderRequest request);

    void deleteOrder(long orderId);

    void updateOrderStatus(Long orderId, String status);
}