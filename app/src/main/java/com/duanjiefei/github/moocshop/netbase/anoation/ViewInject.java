package com.duanjiefei.github.moocshop.netbase.anoation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//  注解的保留期   运行时
@Target(ElementType.TYPE)
public @interface ViewInject {
    int BindViewId()    default -1;
}
