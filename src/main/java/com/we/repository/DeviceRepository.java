package com.we.repository;

import com.we.entity.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jackl on 2016/12/1.
 */
@Repository
public interface DeviceRepository extends CrudRepository<Device,Long> {
    Device findByImei(String imei);
}