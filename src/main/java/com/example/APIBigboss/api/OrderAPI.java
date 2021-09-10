package com.example.APIBigboss.api;

import com.example.APIBigboss.models.Orders;
import com.example.APIBigboss.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/order")
public class OrderAPI {

      @Autowired
   private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Orders>> getAllOrder(){
        return ResponseEntity.ok(orderRepository.getAllOrder());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderByID(@PathVariable int id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        return optionalOrders.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.unprocessableEntity().build());
    }
    @PostMapping("/add")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Orders order) {

        Orders orderSaved = orderRepository.save(order);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();
        return ResponseEntity.created(location).body(orderSaved);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable int id,
                                            @Valid @RequestBody Orders order){
        Optional<Orders> optionalOrders= orderRepository.findById(id);

        if(!optionalOrders.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        order.setId(optionalOrders.get().getId());
        orderRepository.save(order);
        return ResponseEntity.ok(optionalOrders.get());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable int id){
        Optional<Orders> ordersOptional = orderRepository.findOrderById(id);

        if(!ordersOptional.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        orderRepository.delete(ordersOptional.get());
        return ResponseEntity.noContent().build();
    }
}
