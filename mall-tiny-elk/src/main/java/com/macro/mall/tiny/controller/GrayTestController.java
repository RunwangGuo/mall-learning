package com.macro.mall.tiny.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "GrayTestController", description = "灰度测试接口")
@RestController
@RequestMapping("/grayTest")
public class GrayTestController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String grayTest() {
        return "Gray Test - Version B";
    }
}
