package az.orient.shop.controller;

import az.orient.shop.dto.response.RespCategory;
import az.orient.shop.dto.response.Response;
import az.orient.shop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/GetCategoryList")
    public Response getCategoryList(){

        return categoryService.getCategoryList();
    }

}
