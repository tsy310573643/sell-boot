package com.neuedu.sell.controller;

import com.neuedu.sell.VO.ProductCategoryVO;
import com.neuedu.sell.VO.ProductInfoVO;
import com.neuedu.sell.VO.ResultVO;
import com.neuedu.sell.entity.ProductCategory;
import com.neuedu.sell.entity.ProductInfo;
import com.neuedu.sell.service.ProductCategroyService;
import com.neuedu.sell.service.ProductInfoService;
import com.neuedu.sell.utils.ResultVOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class ProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategroyService productCategroyService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.根据商品集合构建一个商品类别编号的集合
        List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }

        //3查询所有商品类别编号对应的类别
        List<ProductCategory> productCategoryList = productCategroyService.findByCategoryTypeIn(categoryTypeList);

        //4.数据拼接
        List<ProductCategoryVO> productCategoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            //1.创建vo对象
            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
            //2.将源类目对象赋值给vo对象，spring提供了方法
            BeanUtils.copyProperties(productCategory,productCategoryVO);

            //将商品源数据转化成上架的vo商品集合
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }


            productCategoryVO.setProductInfoVOList(productInfoVOList);
            //3.将vo对象添加到vo集合中
            productCategoryVOList.add(productCategoryVO);
        }
        return ResultVOUtils.success(productCategoryVOList);
    }
}
