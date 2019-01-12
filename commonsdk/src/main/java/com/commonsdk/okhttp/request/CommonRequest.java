package com.commonsdk.okhttp.request;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;

/***
 * 创建不同方式的请求
 */
public class CommonRequest {


    /**
     * 创建不包含请求头的get方式请求
     */
    public static Request createGetRequest(String url,RequestParams params){
        return createGetRequest(url,params,null);
    }

    /**
     * 创建不包含请求头的post 方式请求
     * @param url
     * @param params
     * @return
     */
    public static  Request createPostRequest(String url,RequestParams params){
        return createPostRequest(url,params,null);
    }

    /**
     * 创建包含请求头Header的get 方式的请求
     */
    public static Request createGetRequest(String url, RequestParams params, RequestParams headers){
        StringBuilder urlBuilder =  new StringBuilder(url).append("?");

        if (params != null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                urlBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        Headers.Builder headBuilder = new Headers.Builder();
        if (headers != null){
            for (Map.Entry<String,String> entry : headers.urlParams.entrySet()){
                headBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        Headers requestHeader =  headBuilder.build();
        Request request = new Request.Builder()
                .headers(requestHeader)
                .url(urlBuilder.substring(0,urlBuilder.length()-1))
                .get()
                .build();
        return request;

    }


    /**
     * 创建包含请求头的 post请求
     */

    public static Request createPostRequest(String url, RequestParams params,RequestParams headers){

        Headers.Builder mHeadersBuilder = new Headers.Builder();
        if (headers != null){
            for (Map.Entry<String,String> entry : headers.urlParams.entrySet()){
                mHeadersBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        if (params != null){
            for (Map.Entry<String,String> entry : params.urlParams.entrySet()){
                formBodyBuilder.add(entry.getKey(),entry.getValue());
            }
        }

        FormBody formBody = formBodyBuilder.build();
        Headers mHeaders = mHeadersBuilder.build();

        return new Request.Builder()
                .headers(mHeaders)
                .post(formBody)
                .url(url)
                .build();
    }
}
