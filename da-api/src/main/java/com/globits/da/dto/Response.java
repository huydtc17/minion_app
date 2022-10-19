package com.globits.da.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Response<T> {
    private int statusCode;
    private String message;
    private T data;

    public Response(String errorMessage){
        this.message=errorMessage;
    }
    public Response(T data){
        this.data=data;
    }

}
