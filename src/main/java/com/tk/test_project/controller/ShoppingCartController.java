package com.tk.test_project.controller;

import com.tk.test_project.dto.CalculatedShoppingCartDTO;
import com.tk.test_project.dto.ShoppingCartDTO;
import com.tk.test_project.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PostMapping("/calculate-cart")
    public CalculatedShoppingCartDTO calculateShoppingCartDTO(@Valid @RequestBody ShoppingCartDTO shoppingCartDTO) {
        return shoppingCartService.calculateShoppingCart(shoppingCartDTO);
    }
}
