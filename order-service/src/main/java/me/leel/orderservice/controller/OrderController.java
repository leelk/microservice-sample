package me.leel.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import me.leel.orderservice.dto.OrderRequest;
import me.leel.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallBackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully.";
    }hjbhfzkb
dbmnshbsnbjnsjbhe
    private String fallBackMethod(OrderRequest orderRequest, RuntimeException e){
        return "Oops.. Something went wrong. Please place order after some times..";
    }
}

