package com.jinjie.hm.config;

/**

 * @date 2021/5/16 11:29
 * @Description ${description}
 */

import org.dromara.hmily.spring.annotation.RefererAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class HmilyConfiguration {

    @Bean
    @Primary
    public BeanPostProcessor refererAnnotationBeanPostProcessor() {
        return new RefererAnnotationBeanPostProcessor();
    }

}
