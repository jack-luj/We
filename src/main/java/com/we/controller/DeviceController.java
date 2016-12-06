package com.we.controller;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.we.entity.Device;
import com.we.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    @RequestMapping(value = "/device", method = RequestMethod.GET)
    public PageResult findDevice(@RequestParam(value = "pageNumber",required = false) Integer pageNumber,
                             @RequestParam(value = "pageSize",required = false) Integer pageSize,
                             @RequestParam(value = "id",required = false) Integer id,
                             @RequestParam(value = "model",required = false) String model,
                             @RequestParam(value = "imei",required = false) String imei,
                             @RequestParam(value = "brandName",required = false) String brandName,
                             @RequestParam(value = "searchText",required = false) String searchText,
                             @RequestParam(value = "sortName",required = false) String orderByProperty,
                             @RequestParam(value = "sortOrder",required = false) String ascOrDesc,
                             @RequestParam(value = "fuzzy",required = false) Integer fuzzy,
                             HttpServletResponse response){

        pageNumber = pageNumber==null?1:pageNumber; //页号
        pageSize = pageSize==null?5:pageSize; //每页数据条数
        orderByProperty= orderByProperty==null?"id":orderByProperty;
        ascOrDesc= ascOrDesc==null?"asc":ascOrDesc;

        String sortString = orderByProperty+"."+ascOrDesc;//如果你想排序的话逗号分隔可以排序多列
        PageBounds pageBounds = new PageBounds(pageNumber, pageSize , Order.formString(sortString));
        imei=searchText;
        List devices =deviceService.findByKeys(model, imei, brandName, pageBounds);
        PageList pageList = (PageList)devices;
        PageResult pageResult=new PageResult(pageList.getPaginator().getTotalCount(),devices,pageList.getPaginator().getPage());
        return pageResult;
    }





}
