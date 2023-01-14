package com.achilles.themis.domain.entity;

import com.achilles.themis.domain.policy.rest.ThemisHttpClient;
import com.achilles.themis.domain.valueObject.ThemisChainContext;
import com.achilles.themis.domain.valueObject.ThemisRestMethodType;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class ThemisRestNode extends ThemisBaseNode {

    private final ThemisAtomApi atomApi;

    private static final Logger logger = LoggerFactory.getLogger(ThemisRestNode.class);

    public ThemisRestNode(ThemisAtomApi atomApi) {
        this.atomApi = atomApi;
    }


    @Override
    protected void before(ThemisChainContext chainContext) {
        logger.info(String.format("start execute pre rest node id by %s", getId()));
        chainContext.checkAndPrepare(this);
    }

    @Override
    protected void after(ThemisChainContext chainContext, String value) {
        logger.info(String.format("start execute post rest node id by %s", getId()));
        chainContext.addResponse(getId(), value);
    }

    @Override
    protected String doExecute(ThemisChainContext chainContext) throws Exception {
        String response;
        if (atomApi.getMethodType().equals(ThemisRestMethodType.GET)) {
            response = ThemisHttpClient.restGet(atomApi.getUrl(), atomApi.getHeader(), atomApi.getParameter());
        } else {
            response = ThemisHttpClient.restPost(atomApi.getUrl(), atomApi.getHeader(), atomApi.getBody());
        }
        return response;
    }


}
