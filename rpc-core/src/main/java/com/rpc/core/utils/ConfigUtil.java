package com.rpc.core.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import java.net.URL;

/**
 * @ClassName 配置prc属性
 * @Description TODO
 * @synposis TODO
 */
public class ConfigUtil {
    /**
     * @descrieptiaion 加载配置对象
     * @param tClass
     * @param prefix
     * @return
     * @author weidingqian
     * @date 2024/3/8 18:31
     */

    public static <T> T loadConfig(Class<T> tClass,String prefix){
            return loadConfig(tClass,prefix,"");
    }
    //加载配置文件 优先级 application.properties  application.yml   application.yaml
    private static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuilder=new StringBuilder("application");
        if(StrUtil.isNotBlank(environment)){
                configFileBuilder.append("-")
                        .append(environment);
        }
        Props props=null;

//        try {
            configFileBuilder.append(".properties");
            props=new Props(configFileBuilder.toString());
//        }catch (Exception e){
//            configFileBuilder.replace(11,configFileBuilder.length(),".yml");
//            props=new Props(configFileBuilder.toString());
//
//        }
        //当文件更新时自动加载配置文件
        props.autoLoad(true);
        return  props.toBean(tClass,prefix);
    }
}
