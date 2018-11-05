package com.neuedu.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInfoVO {
    @JsonProperty("Id")
    private String ProductId;
    @JsonProperty("name")
    private String productName;
    /* 商品单价 */
    @JsonProperty("price")
    private BigDecimal productPrice;
    /* 商品描述 */
    @JsonProperty("description")
    private String productDescription;
    /* 商品小图 */
    @JsonProperty("icon")
    private String productIcon;
}
