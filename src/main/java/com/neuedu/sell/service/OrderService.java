package com.neuedu.sell.service;

import com.neuedu.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    /**
     * 创建订单
     * */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 根据订单ID来查询
     * */
    OrderDTO findOne(String orderId);

    /**
     * 查询订单列表
     * */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /**
     * 取消订单
     * */
    OrderDTO cancel(OrderDTO orderDTO);
    /**
     * 完成订单
     * */
    OrderDTO finish(OrderDTO orderDTO);
    /**
     * 支付
     * */
    OrderDTO paid(OrderDTO orderDTO);
}
