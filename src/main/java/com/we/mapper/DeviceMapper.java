package com.we.mapper;

import com.we.entity.Device;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * Created by jackl on 2016/12/2.
 */
@Mapper
public interface DeviceMapper {

    @Select("SELECT * FROM t_device WHERE imei = #{imei} limit 1")
   /* @Results(value = {
         //   @Result(property = "odmModel", column = "odm_model", javaType = String.class, jdbcType = JdbcType.VARCHAR),
          //  @Result(property = "hwVer", column = "hw_ver", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "swVer", column = "sw_ver", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "odmSwVer", column = "odm_sw_ver", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "wifiMac", column = "wifi_mac", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "btMac", column = "bt_mac", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "brandName", column = "brand_name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "receiveTime", column = "receive_time", javaType = Date.class, jdbcType = JdbcType.TIMESTAMP) })*/
    Device findByImei(@Param("imei") String imei);

    @Insert("INSERT INTO ip_device(model, odm_model,imei,imsi,hw_ver,sw_ver,odm_sw_ver,wifi_mac,bt_mac,vendor,brand_name,receive_time)" +
            "VALUES(#{device.model}, #{device.odmModel},#{device.imei},#{device.imsi},#{device.hwVer}, #{device.swVer}, #{device.odmSwVer}," +
            " #{device.wifiMac}, #{device.btMac}, #{device.vendor}, #{device.brandName}, #{device.receiveTime})")
    void save(@Param("device")Device device);
}
