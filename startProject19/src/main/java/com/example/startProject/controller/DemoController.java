package com.example.startProject.controller;


import com.example.startProject.Service.ServiceImp.paymentService;
import com.example.startProject.config.CustomConfig;
import com.example.startProject.model.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1")
public class DemoController {

//  @RequestMapping(method = GET)

    private static Logger Logger  = LoggerFactory.getLogger(DemoController.class);

//    @Autowired
    private Demo demo;


//    Constructor Injection
    @Autowired
    public DemoController(Demo demo)
    {
        this.demo = demo;
        Logger.info("Demo : {} ", demo.toString());

    }

    public DemoController(@Value("${server.port}")int a)
    {
        Logger.info("a = {}", a);
    }



    @Autowired
    @Qualifier("PaymentService2Impl")
    private paymentService paymentService;


    @Autowired
    private CustomConfig customConfig;


    @GetMapping("/getTemplate")
    public void getTemplate(){
        Logger.info("In Demo Controller : {}", customConfig.getTemplate());
//        org.springframework.web.client.RestTemplate@149c320
    }

    @GetMapping("/demo")
      public Demo getdemo() {
//         Demo  demo = new Demo();
        Logger.info("Demo object is : {}", demo);
        paymentService.printMessage();
        return demo;
    }


      @PostMapping("/demo")
      public Demo getdemo1(){
//         Demo  demo = new Demo();
         Logger.info ("Demo1  object is : {}", demo);
         paymentService.printMessage();
         return demo;
    }

    @GetMapping("/requestParam")
    public void requestParamMethod(@RequestParam String name){
        Logger.info("Request param received with name : {}", name);
    }




    @GetMapping("/pathVariable/{id}")
    public void pathVariableMethod(@PathVariable int id){
          Logger.info("Path Variable received with id : {} ", id);
    }

    @GetMapping("/requestBody")
    public Demo requestBodyMethod(@RequestBody Demo demoobj)
    {
        return demoobj;
    }

}




