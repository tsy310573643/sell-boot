package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void createTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13333333333");
        orderDTO.setBuyerAddress("西七道");
        orderDTO.setBuyerOpenid("abc123");
        List<OrderDetail> list = new ArrayList<>();
        list.add(new OrderDetail("1",10));
        list.add(new OrderDetail("2",2));
        orderDTO.setOrderDetailList(list);
        orderService.create(orderDTO);
    }

    @Test
    public void findOneTest(){
        OrderDTO orderDTO = orderService.findOne("1541321803144912784");
        System.out.println(orderDTO);
    }

    @Test
    public void findListTest(){
        Page<OrderDTO> page = orderService.findList("abc123",new PageRequest(0,2));
        for (OrderDTO orderDTO : page.getContent()) {
            System.out.println(orderDTO);
        }
    }

    @Test
    public void cancelTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1541483374616161734");
        List<OrderDetail> list = new ArrayList<>();
        list.add(new OrderDetail("1",10));
        list.add(new OrderDetail("2",2));
        orderDTO.setOrderDetailList(list);
        orderService.cancel(orderDTO);
    }

    @Test
    public void finishTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1541483374616161734");
        orderService.finish(orderDTO);
    }

    @Test
    public void paidTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1541488181858334301");
        orderService.paid(orderDTO);
    }
}