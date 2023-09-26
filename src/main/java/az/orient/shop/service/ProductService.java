package az.orient.shop.service;

import az.orient.shop.dto.response.RespCategory;
import az.orient.shop.dto.response.RespProduct;

import java.util.List;

public interface ProductService {
    List<RespProduct> getProductList();
}
