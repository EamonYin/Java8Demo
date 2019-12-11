package com.java8.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/swagger")
@Api("Swagger测试日期类型")
public class SwaggerTestController {

    @ApiOperation("通过输入日期判断类型")
    @GetMapping("/test")
    @ResponseBody
    @ApiImplicitParam(name = "date",value = "要判断的日期",dataType = "String",paramType = "query",required = true)
    public String testInfo(String date) {

        System.out.println(date);

        RestTemplate restTemplate = new RestTemplate();
        /**
         * 接口地址 http://tool.bitefu.net/jiari/
         * 接口尾部输入yyyyMMDD格式的日期参数，就能知道当天是工作日（0）、休息日（1）和节假日（2）了
         */
        String url = "http://tool.bitefu.net/jiari/?d=";
//        String date = "20191211";
        Integer result = restTemplate.getForObject(url + date, Integer.class);

        switch (result) {
            case 0:
                return date + "是工作日";
            case 1:
                return date + "是休息日";
            case 2:
                return date + "是节假日";
            default:
                return "日期错误";
        }
    }
}
