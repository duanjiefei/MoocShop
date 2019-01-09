package com.duanjiefei.github.moocshop.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;


public class GlideImageUtils {

    private static GlideImageUtils instance = null;

    public static GlideImageUtils getInstance(){
        if (instance == null){
            synchronized (GlideImageUtils.class){
                if (instance == null){
                    instance = new GlideImageUtils();
                }
            }
        }
        return instance;
    }

    private GlideImageUtils(){
    }

    /**
     * (1)
     * 显示图片Imageview
     *
     * @param context  上下文
     * @param errorimg 错误的资源图片
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showImageView(Context context, int errorimg, String url,
                                     ImageView imgeview) {

        RequestOptions options = new RequestOptions()
                .error(errorimg)
                .placeholder(errorimg)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        Glide.with(context).load(url)
                .apply(options)
                .transition(DrawableTransitionOptions.withCrossFade())// 设置淡入淡出效果，默认300ms，可以传参
                .into(imgeview);// 加载图片
    }

}
