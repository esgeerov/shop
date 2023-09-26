package az.orient.shop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespStatus {
    private Integer code;
    private String message;

    private  static Integer SUCCESS_CODE=1;
    private  static String SUCCESS_MESSAGE="success";
    public static RespStatus getSuccessMessage(){
        return new RespStatus(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
}
