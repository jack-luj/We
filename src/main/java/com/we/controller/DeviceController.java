package com.we.controller;
import com.we.entity.Device;
import com.we.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by jackl on 2016/11/11.
 */

@RestController
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping(value="/device/{imei}",method = RequestMethod.GET)
    public JsonResult query(@PathVariable("imei") String imei){
        Device device= deviceService.findByImei(imei);
        if(device==null){
            return new JsonResult("false","设备不存在");
        }else{
            return new JsonResult("true",device);
        }
    }

}
