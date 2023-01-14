package com.achilles.themis.domain.policy.rest;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import java.util.Map;
import java.util.Optional;

public class ThemisHttpClient {

    private static final Logger logger = LoggerFactory.getLogger(ThemisHttpClient.class);

    public static String restGet(@NonNull String url, @NonNull Map<String, String> header,
                          @NonNull Map<String, String> param) throws Exception {

        CloseableHttpResponse response = null;
        CloseableHttpClient client = HttpClients.createDefault();

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            param.forEach(uriBuilder::addParameter);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            header.forEach(httpGet::addHeader);


            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(60000)
                    .build();
            httpGet.setConfig(requestConfig);

            response = client.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != 200){
                throw new Exception(String.format("rest api error,code is %s",statusCode));
            }

            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity);


        } catch (Exception e) {
            logger.error(String.format("rest get method is error,caused by %s",e.getMessage()), e);
            throw e;
        } finally {
            if(Optional.ofNullable(response).isPresent()){
                response.close();
            }
            if(Optional.ofNullable(client).isPresent()){
                client.close();
            }
        }

    }

    public static String restPost(@NonNull String url, @NonNull Map<String, String> header,
                           @NonNull String body) throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            header.forEach(httpPost::addHeader);
            HttpEntity entity = new StringEntity(body, "UTF-8");
            httpPost.setEntity(entity);


            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000)
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(60000)
                    .build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-type", "application/json");


            response = client.execute(httpPost);

            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode != 200){
                throw new Exception(String.format("rest api error,code is %s",statusCode));
            }
            HttpEntity respEntity = response.getEntity();
            return EntityUtils.toString(respEntity);

        } catch (Exception e) {
            logger.error("rest post method is error,caused by", e);
            throw e;
        } finally {
            if(response != null){
                response.close();
            }
            if(client != null){
                client.close();
            }


        }


    }



}
