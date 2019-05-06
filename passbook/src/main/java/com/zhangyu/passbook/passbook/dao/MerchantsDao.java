package com.zhangyu.passbook.passbook.dao;

import com.zhangyu.passbook.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MerchantsDao extends JpaRepository<Merchants,Integer> {
    Merchants findById(Integer id);

    Merchants findByName(String name);

    List<Merchants> findByIdIn(List<Integer> ids);
}
