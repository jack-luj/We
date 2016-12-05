package com.we.mapper;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
/**
 * Created by jackl on 2016/12/5.
 */
public class DeviceDynaSqlProvider {



    public String getDevices(final Map<String,Object> map){
        return new SQL(){
            {
                SELECT("*");
                FROM("t_device");
                if(map.containsKey("model")){
                    if(map.get("model")!=null) {
                        WHERE("model = #{model}");
                    }
                }
                if(map.containsKey("imei")){
                    if(map.get("imei")!=null) {
                        WHERE("imei like CONCAT('%',#{imei},'%')");
                    }
                }
                if(map.containsKey("brandName")){
                    if(map.get("brandName")!=null) {
                        WHERE("brand_name = #{brandName}");
                    }
                }
            }
        }.toString();
    }


}
