package az.orient.shop.dto.response;

import lombok.Data;

import java.util.List;

@Data

public class Response {
    private List<RespCategory>categoryList;
    private RespStatus respStatus;
}
