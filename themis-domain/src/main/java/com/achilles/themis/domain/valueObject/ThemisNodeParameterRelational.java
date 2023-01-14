package com.achilles.themis.domain.valueObject;

import lombok.Data;

@Data
public class ThemisNodeParameterRelational {

    private String sourceId;

    private String fromId;

    private String sourceField;

    private ThemisNodeParameterType sourceType;

    private String fromField;

    private ThemisNodeParameterType fromType;

}
