package com.zhangyu.passbook.merchants.dao;

import com.zhangyu.passbook.merchants.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Merchants Dao 接口
 */
public interface MerchantsDao extends JpaRepository<Merchants,Integer> {
    /**
     *
     * @param id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     *
     * @param name
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
