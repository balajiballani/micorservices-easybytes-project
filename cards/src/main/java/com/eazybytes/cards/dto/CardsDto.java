package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class CardsDto {
    @Schema(description = "Card Number",example = "1234567")
    @NotEmpty
    @Size(min = 1,max = 12)
    private String cardNumber;
    @NotEmpty
    @Schema(description = "name on the card",example = "Balaji")
    private String name;
    @NotNull
    @Schema(description = "expiryDate",example = "12/02/2030")
    private Date expiryDate;
    @NotEmpty
    @Schema(description = "Last three digits",example = "758")
    private String securityCode;
}
