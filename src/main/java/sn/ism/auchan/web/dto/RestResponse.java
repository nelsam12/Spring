package sn.ism.auchan.web.dto;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponse {
    public static Map<String, Object> response (HttpStatus status, Object data, String type) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", status.value());
        response.put("data", data);
        response.put("type", type);
        return response;
    }

    public static Map<String, Object> responseError (BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<String, Object>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return response;
    }

    public static Map<String, Object> responsePaginate (HttpStatus status,
                                                 Object results,
                                                 Object pages,
                                                 Object CurrentPage,
                                                 Object TotalPages,
                                                 Object TotalElements,
                                                 Boolean first,
                                                 Boolean last,
                                                 String type) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("status", status.value());
        response.put("results", results);
        response.put("pages", pages);
        response.put("CurrentPage", CurrentPage);
        response.put("TotalPages", TotalPages);
        response.put("TotalElements", TotalElements);
        response.put("first", first);
        response.put("last", last);
        response.put("type", type);

        return response;
    }
}
