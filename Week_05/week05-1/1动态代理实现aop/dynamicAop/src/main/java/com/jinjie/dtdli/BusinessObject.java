package com.jinjie.dtdli;

import java.util.logging.Logger;

/**
 * @author Mr JinJun
 * @version 1.0
 * @date 2021/2/18 19:40
 * @Description ${description}
 */
public class BusinessObject implements BusinessInterface {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void processBusiness() {
        // business processing
        System.out.println("here is business logic");
    }
}
