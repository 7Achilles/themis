package com.achilles.themis.domain.valueObject;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ThemisNodeParameterRelationalConfig {

    Map<String, HashMap<String, List<ThemisNodeParameterRelational>>> parameterMap;

}
