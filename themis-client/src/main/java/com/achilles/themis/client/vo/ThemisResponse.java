package com.achilles.themis.client.vo;

import lombok.Data;

@Data
public class ThemisResponse<T> {

    private String code;

    private String message;

    private Boolean success;

    private T data;

    private ThemisResponse(String code, Boolean success, String message, T data){
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> ThemisResponse<T> success(T data){
        return new ThemisResponse<>("200", true, "success", data);
    }

    public static ThemisResponse<Object> error(String message){
        return new ThemisResponse<>("500",false,message,null);
    }



}
