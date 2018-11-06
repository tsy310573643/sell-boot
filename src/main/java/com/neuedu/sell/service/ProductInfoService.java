package com.neuedu.sell.service;

import com.neuedu.sell.dto.CartDTO;
import com.neuedu.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {

    /**
     * 查询所有上架商品
     * */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询商品
     * */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 通过编号查询
     * */
    ProductInfo findOne(String productInfoId);

    /**
     * 添加或修改
     * */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 扣库存
     * */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 增加库存
     * */
    void increaseStock(List<CartDTO> cartDTOList);
}
