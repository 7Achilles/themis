package com.achilles.themis.domain.entity;

import lombok.Data;


@Data
public class ThemisNodeRecord {

    private String id;

    private String nodeId;

    private String response;

    private ThemisAtomApi atomApi;

}
