package az.orient.shop.service;

import az.orient.shop.dto.response.RespProduct;
import az.orient.shop.entity.Product;
import az.orient.shop.enums.EnumAviableStatus;
import az.orient.shop.exception.ExceptionConstants;
import az.orient.shop.exception.ShopException;
import az.orient.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<RespProduct> getProductList() {
        List<RespProduct> response = new ArrayList<>();
        try {
            List<Product> productList = productRepository.findAllByActive(EnumAviableStatus.ACTIVE.value);
            if (productList.isEmpty()) {
                throw new ShopException(ExceptionConstants.PRODUCT_NOT_FOUND, "Product not found");

            }
            for (Product product : productList) {
                RespProduct respProduct = new RespProduct();
                respProduct.setId(product.getId());
                respProduct.setName(product.getName());
                respProduct.setBrand(product.getBrand());
                respProduct.setPrice(product.getPrice());
                response.add(respProduct);

            }
        } catch (ShopException e) {
            e.printStackTrace();
        }
        return response;
    }
}
