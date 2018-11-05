package com.neuedu.sell.entity;

import com.neuedu.sell.enums.OrderStatusEnum;
import com.neuedu.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 * */
@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    /* 订单状态，0为新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /* 支付状态, 0为未支付 */
    private Integer payStatus = PayStatusEnum.NOT_PAY.getCode();

    /* 创建时间 */
    private Date createTime;

    /* 修改时间 */
    private Date updateTime;
}
