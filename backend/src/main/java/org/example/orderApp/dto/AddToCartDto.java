package org.example.orderApp.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class AddToCartDto {

    private @NotNull Integer itemId;
    private @NotNull Integer quantity;

    public AddToCartDto(Integer itemId, Integer quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
