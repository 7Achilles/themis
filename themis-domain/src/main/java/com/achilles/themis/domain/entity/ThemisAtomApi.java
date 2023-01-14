package com.achilles.themis.domain.entity;

import com.achilles.themis.domain.valueObject.ThemisRestMethodType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ThemisAtomApi {

    private Long id;

    private String name;

    private String url;

    private ThemisRestMethodType methodType;

    private Map<String, String> header = new HashMap<>();

    private Map<String,String> parameter = new HashMap<>();

    private String body;

}
