package com.tk.test_project.service.impl;

import com.tk.test_project.dto.CalculatedShoppingCartDTO;
import com.tk.test_project.dto.CalculatedItemDTO;
import com.tk.test_project.dto.ShoppingCartDTO;
import com.tk.test_project.service.ShoppingCartService;
import com.tk.test_project.utils.FloatFieldRounder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ItemPriceServiceImpl itemPriceDTOService;

    @Override
    public CalculatedShoppingCartDTO calculateShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        Collection<CalculatedItemDTO> items = shoppingCartDTO.getItems().stream().
                map(i -> CalculatedItemDTO.builder().id(i.getId()).numberOfItems(i.getNumberOfItems())
                        .sumForPosition(itemPriceDTOService.getItemPrice(i.getId()).getItemPrice() * i.getNumberOfItems())
                        .build())
                .collect(Collectors.toList());
        float generalSum = FloatFieldRounder.roundFloatField
                (items.stream().map(CalculatedItemDTO::getSumForPosition).reduce(0F, Float::sum));
        return CalculatedShoppingCartDTO
                .builder()
                .items(items)
                .generalSum(generalSum)
                .build();
    }
}
