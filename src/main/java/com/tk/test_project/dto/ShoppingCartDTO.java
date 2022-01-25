package com.tk.test_project.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Optional;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    @NotNull
    private Collection<InputItemDTO> items;

    @NotNull
    private PaymentType paymentType;
    private Optional<Long> addressId;
}
