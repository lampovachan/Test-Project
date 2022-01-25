package com.tk.test_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedShoppingCartDTO {
    private Collection<CalculatedItemDTO> items;
    private float generalSum;
}
