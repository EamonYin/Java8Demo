package com.java8.demo;


import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Controller
public class java8lambda {

    Integer[] num = {2, 5, null, 6, 7, null, 11};

    @Test
    public void haha() {

        List<Integer> list = new ArrayList<>(Arrays.asList(this.num));

        //stream+lambda
        Integer sum = list.stream().filter(x -> x != null).reduce((s, x) -> s + x).get();
        System.out.println(sum);

        List<User> users = new ArrayList<>();
        users.add(new User("lisi", 12));
        users.add(new User("zhangsan", 60));
        users.add(new User("wangwu", 75));

        Optional<User> first = users.stream().filter(x -> x.getName() == "zhangsan").findFirst();

        if (first.isPresent()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println(first);

    }

    @Test
    public void RestTemplate1(){
        RestTemplate restTemplate = new RestTemplate();
        /**
         * 接口地址 http://tool.bitefu.net/jiari/
         * 接口尾部输入yyyyMMDD格式的日期参数，就能知道当天是工作日（0）、休息日（1）和节假日（2）了
         */
        String url= "http://tool.bitefu.net/jiari/?d=";
        String date = "20191211";
        Integer result = restTemplate.getForObject(url + date, Integer.class);
        switch(result){
            case 0:
                System.out.println(date+"是工作日");
                break;
            case 1:
                System.out.println(date+"是休息日");
                break;
            case 2:
                System.out.println(date+"是节假日");
                break;
        }

    }




}
