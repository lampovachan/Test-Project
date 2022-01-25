package com.tk.test_project.service;

import com.tk.test_project.dto.CalculatedShoppingCartDTO;
import com.tk.test_project.dto.ShoppingCartDTO;

public interface ShoppingCartService {
    CalculatedShoppingCartDTO calculateShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
