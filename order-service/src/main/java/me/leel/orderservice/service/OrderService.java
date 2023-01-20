package me.leel.orderservice.service;

import lombok.RequiredArgsConstructor;
import me.leel.orderservice.dto.OrderLineItemsDto;
import me.leel.orderservice.dto.OrderRequest;
import me.leel.orderservice.model.Order;
import me.leel.orderservice.model.OrderLineItems;
import me.leel.orderservice.repository.OderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OderRepository oderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItems(orderLineItems);

        //Call Inventory service, and place order if product in stock.
        Boolean result = webClient.get()
                .uri("http://localhost:8082/api/inventory").retrieve()
                .bodyToMono(Boolean.class).
                block();

        if (result) {
            oderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock.");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {

        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
