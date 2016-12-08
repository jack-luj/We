package com.we.mapper;

import com.we.entity.Device;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

/**
 * Created by jackl on 2016/12/2.
 */
@Mapper
public interface DeviceMapper {

    @Select("SELECT * FROM t_device WHERE imei = #{imei} limit 1")
    Device findByImei(@Param("imei") String imei);

    @SelectProvider(type=DeviceDynaSqlProvider.class,method="getDevices")
    List<Device> findByKeys(Map<String,Object> map);


    @Insert("INSERT INTO t_device(model, odm_model,imei,imsi,hw_ver,sw_ver,odm_sw_ver,wifi_mac,bt_mac,vendor,brand_name,receive_time)" +
            "VALUES(#{device.model}, #{device.odmModel},#{device.imei},#{device.imsi},#{device.hwVer}, #{device.swVer}, #{device.odmSwVer}," +
            " #{device.wifiMac}, #{device.btMac}, #{device.vendor}, #{device.brandName}, #{device.receiveTime})")
    void save(@Param("device")Device device);

    @Insert("update t_device set model=#{device.model}, odm_model=#{device.odmModel},imei=#{device.imei},imsi=#{device.imsi},hw_ver=#{device.hwVer}," +
            "sw_ver=#{device.swVer},odm_sw_ver=#{device.odmSwVer},wifi_mac=#{device.wifiMac},bt_mac=#{device.btMac},vendor=#{device.vendor},brand_name=#{device.brandName},receive_time=#{device.receiveTime} where imei=#{device.imei}")
    void update(@Param("device")Device device);

    @Delete("delete from t_device where imei=#{imei}")
    void delete(@Param("imei")String imei);
}
