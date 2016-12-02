package com.we.service;

import com.we.entity.Device;
import com.we.mapper.DeviceMapper;
import com.we.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jackl on 2016/12/1.
 */
@Component
public class DeviceService {

   // @Autowired
    //DeviceRepository deviceRepository;

    @Autowired
    DeviceMapper deviceRepository;

    public Device findByImei(String imei) {
        return deviceRepository.findByImei(imei);
    }
}
