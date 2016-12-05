package com.we.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.we.entity.Device;
import com.we.mapper.DeviceMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackl on 2016/12/1.
 */
@Component
public class DeviceService {

   // @Autowired
    //DeviceRepository deviceRepository;

    @Autowired
    DeviceMapper deviceRepository;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public Device findByImei(String imei) {
        return deviceRepository.findByImei(imei);
    }



    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public List findByKeys(String model,String imei,String brandName, PageBounds pageBounds){

        SqlSession session = null;
        try{
            session = getSqlSession();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("model",model);
            params.put("imei",imei);
            params.put("brandName",brandName);
            return session.selectList("findByKeys", params, pageBounds);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            session.close();
        }

    }
}
