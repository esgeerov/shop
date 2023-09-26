package az.orient.shop.controller;

import az.orient.shop.dto.response.RespProduct;
import az.orient.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping("GetProductList")
    private List<RespProduct> getProductList(){

        return productService.getProductList();
    }

}
