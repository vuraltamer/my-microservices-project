package com.project.controller;

import com.project.data.entity.BaseEntity;
import com.project.data.entity.Order;
import com.project.dto.OrderDto;
import com.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController extends BaseController<Order, OrderDto> {

    @Autowired
    OrderService orderService;

    @Override
    @GetMapping("/id/{id}")
    protected ResponseEntity<OrderDto> findById(@PathVariable("id") String id) {

        return toDto(orderService.getEntity(id), new OrderDto());
    }

    @Override
    @PostMapping(value = "/save", produces = "application/json")
    protected ResponseEntity save(@RequestBody @Valid OrderDto dto) {

        final BaseEntity entity = toEntity(new Order(), dto);

        return ResponseEntity.ok(orderService.save((Order) entity));
    }

    @Override
    @GetMapping("/delete/{id}")
    protected ResponseEntity delete(@PathVariable String id) {

        return ResponseEntity.ok(orderService.delete(id));
    }

    @Override
    @PostMapping(value = "/update", produces = "application/json")
    protected ResponseEntity update(@RequestBody @Valid OrderDto dto) {

        final BaseEntity entity = toEntity(new Order(), dto);

        return ResponseEntity.ok(orderService.update((Order) entity));
    }

    @Override
    @GetMapping("/list")
    protected ResponseEntity list() {

        final List<Order> orders = orderService.getRepository().findAll();

        return toDto(orders, new OrderDto());
    }

}
