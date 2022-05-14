package com.example.goodsprovider.controller;

import com.example.goodscommon.pojo.Book;
import com.example.goodsprovider.service.GoodsProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {

    @Resource
    private GoodsProviderService goodsProviderService;

    /**
     * 测试goods-ui调用是否成功
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("进入了goods-provider");
        return "调用成功";
    }

    /**
     * 返回所有图书
     */
    @RequestMapping("/findAll")
    public List<Book> findAll(){
        return goodsProviderService.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return goodsProviderService.findById(id);
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Book book){
        goodsProviderService.insert(book);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50")
            /*@HystrixProperty(name = "circuitBreaker.enabled",value="true"),//开启熔断器
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000"),//时间
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")//服务错误率*/
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random() * 100);
        int result = n/num;
        return "服务器正常返回: "+n+"/"+num+"="+result;
    }
    public String fallback(@RequestParam("num")Integer num){
        return "服务降级反应:num为0";
    }
}
