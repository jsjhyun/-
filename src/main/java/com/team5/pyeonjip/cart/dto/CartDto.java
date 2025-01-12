package com.team5.pyeonjip.cart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDto {
    private Long optionId;
    private Long quantity;

    public CartDto(Long optionId, Long quantity) {
        this.optionId = optionId;
        this.quantity = quantity;
    }

    public CartDto() {
    }
}
