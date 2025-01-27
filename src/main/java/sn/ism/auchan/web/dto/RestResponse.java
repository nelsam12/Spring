package sn.ism.auchan.web.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponse {
    public static Map<String, Object> response (HttpStatus status, Object data, String type) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("result", data);
        response.put("type", type);
        return response;
    }

    public static Map<String, Object> responseError (BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            response.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return response;
    }

    public static Map<String, Object> responsePaginate (HttpStatus status,
                                                 Object results,
                                                 Integer currentPage,
                                                        Integer totalPages,
                                                        Object totalElements,
                                                 Boolean first,
                                                 Boolean last,
                                                 String type) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status.value());
        response.put("results", results);
        response.put("pages", new int[totalPages]);
        response.put("CurrentPage", currentPage);
        response.put("TotalPages", totalPages);
        response.put("TotalElements", totalElements);
        response.put("first", first);
        response.put("last", last);
        response.put("type", type);

        return response;
    }
}
