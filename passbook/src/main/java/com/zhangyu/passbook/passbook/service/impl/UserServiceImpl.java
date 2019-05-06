//zhangyu de code
package com.zhangyu.passbook.passbook.service.impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.zhangyu.passbook.passbook.constant.Constants;
import com.zhangyu.passbook.passbook.service.IUserService;
import com.zhangyu.passbook.passbook.vo.Response;
import com.zhangyu.passbook.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//创建用户服务实现
@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    //HBase 客户端
    @Autowired
    private HbaseTemplate hbaseTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public Response createUser(User user) throws Exception {
        byte[] FAMILY_B= Constants.UserTable.FAMILY_B.getBytes();
        byte[] NAME = Constants.UserTable.NAME.getBytes();
        byte[] AGE = Constants.UserTable.AGE.getBytes();
        byte[] SEX = Constants.UserTable.SEX.getBytes();

        byte[] FAMILY_O = Constants.UserTable.FAMILY_O.getBytes();
        byte[] PHONE = Constants.UserTable.PHONE.getBytes();
        byte[] ADDRESS = Constants.UserTable.ADDRESS.getBytes();
        //当前的用户总数
        Long curCount=redisTemplate.opsForValue().increment(Constants.USE_COUNT_KEY,1);
        Long userId=genUserId(curCount);

        List<Mutation> datas=new ArrayList<Mutation>();
        Put put=new Put(Bytes.toBytes(userId));
        put.addColumn(FAMILY_B,NAME,Bytes.toBytes(user.getBaseInfo().getName()));
        put.addColumn(FAMILY_B, AGE, Bytes.toBytes(user.getBaseInfo().getAge()));
        put.addColumn(FAMILY_B, SEX, Bytes.toBytes(user.getBaseInfo().getSex()));

        put.addColumn(FAMILY_O, PHONE, Bytes.toBytes(user.getOtherInfo().getPhone()));
        put.addColumn(FAMILY_O, ADDRESS, Bytes.toBytes(user.getOtherInfo().getAddress()));
        datas.add(put);
        hbaseTemplate.saveOrUpdates(Constants.UserTable.TABLE_NAME,datas);
        user.setId(userId);

        return new Response(user);
    }
    //根据当前用户数生成UserId
    private Long genUserId(Long prefix){
        String suffix= RandomStringUtils.randomNumeric(5);
        return Long.valueOf(prefix+suffix);
    }
}
