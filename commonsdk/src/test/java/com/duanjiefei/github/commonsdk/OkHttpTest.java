package com.duanjiefei.github.commonsdk;

import com.commonsdk.okhttp.request.CommonRequest;
import com.commonsdk.okhttp.request.RequestParams;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {

    private static final String TAG = "OkHttpTest";

    /**
     * 测试OkHttp的get请求
     */
    @Test
    public void testGet() {
        //创建OkHttp对象
        OkHttpClient okHttpClient = new OkHttpClient();

        //创建Request对象
        Request request = new Request.Builder()
                .url("https://httpbin.org/get")
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response  "+ response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试OkHttpPost请求
     */
    @Test
    public void testPost(){
        //1 创建OkhttpClient
        OkHttpClient okHttpClient = new OkHttpClient();

        // 2 创建RequestBody
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        formBodyBuilder.add("name","daunjiefei");

        FormBody formBody = formBodyBuilder.build();

        //3 创建Request 对象

        Request request = new Request.Builder()
                .post(formBody)
                .url("https://httpbin.org/post?")
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response:  "+response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试拦截器
     */
    @Test
    public void testInterceptor(){
        //创建拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                long start = System.currentTimeMillis();
                Request request = chain.request();//通过Chain 拦截请求
                Response response = chain.proceed(request);//重新执行请求
                long end = System.currentTimeMillis();
                System.out.println("cost time: "+ (end-start));
                return response;//并将执行结果返回
            }
        };

        //创建OkHttp对象,并添加拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //创建Request对象
        Request request = new Request.Builder()
                .url("https://httpbin.org/get")
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response  "+ response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试缓存
     */
    @Test
    public void testCache(){
        //创建缓存
        Cache cache = new Cache(new File("Cache.txt"),50*1024*1024);


        //创建OkHttp对象,并添加拦截器
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        //创建Request对象
        Request request = new Request.Builder()
                .url("https://httpbin.org/get")
                .cacheControl(CacheControl.FORCE_CACHE)
                .get()
                .build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            Response responseCache = response.cacheResponse();
            Response responseNet = response.networkResponse();
            if (responseCache != null){
                System.out.println("responseCache != null");
            }

            if (responseNet != null){
                System.out.println("responseNet != null");
            }
            System.out.println("response  "+ response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 自定义的get请求
     */
    @Test
    public void testCustomGet(){
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "https://httpbin.org/get";
        RequestParams requestParams = new RequestParams();
        requestParams.put("name","duanjiefei");

        RequestParams requestHeaders = new RequestParams();
        requestHeaders.put("age","18");
        Request request = CommonRequest.createGetRequest(url,requestParams,requestHeaders);

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response "+ response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 自定义的get请求
     */
    @Test
    public void testCustomPost(){
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "https://httpbin.org/post";
        RequestParams requestParams = new RequestParams();
        requestParams.put("name","duanjiefei");

        RequestParams requestHeaders = new RequestParams();
        requestHeaders.put("age","18");
        Request request = CommonRequest.createPostRequest(url,requestParams,requestHeaders);

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("response "+ response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
