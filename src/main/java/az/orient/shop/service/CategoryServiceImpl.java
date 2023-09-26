package az.orient.shop.service;

import az.orient.shop.dto.response.RespCategory;
import az.orient.shop.dto.response.RespProduct;
import az.orient.shop.dto.response.RespStatus;
import az.orient.shop.dto.response.Response;
import az.orient.shop.entity.Category;
import az.orient.shop.enums.EnumAviableStatus;
import az.orient.shop.exception.ExceptionConstants;
import az.orient.shop.exception.ShopException;
import az.orient.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public Response getCategoryList() {
        Response response=new Response();
        List<RespCategory> respCategoryList=new ArrayList<>();
       try {
           List<Category>categoryList =categoryRepository.findAllByActive(EnumAviableStatus.ACTIVE.value);
           if(categoryList.isEmpty()){
               throw new ShopException(ExceptionConstants.CATEGORY_NOT_FOUND,"Category bot found");
           }for (Category category:categoryList){
               RespCategory respCategory=new RespCategory();
               respCategory.setId(category.getId());
               respCategory.setName(category.getName());
               respCategoryList.add(respCategory);



           }
           response.setCategoryList(respCategoryList);
           response.setRespStatus(RespStatus.getSuccessMessage());
       }catch (ShopException e){
           e.printStackTrace();
           response.setRespStatus(new RespStatus(e.getCode(),e.getMessage()));
       }
        return response;
    }
}
