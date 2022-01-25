package com.tk.test_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPriceDTO implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    private Long id;
    private float itemPrice;
}
