package com.zhangyu.passbook.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 商户对象模型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="merchants")
public class Merchants {
    /**
     * 商户id
     */
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;

    @Basic
    @Column(name="name" ,unique = true ,nullable = false)
    private String name;

    @Basic
    @Column(name = "log_url" ,nullable = false)
    private String logUrl;

    @Basic
    @Column(name = "business_license_url",nullable = false)
    private String businessLicenseUrl;

    @Basic
    @Column(name = "phone",nullable = false)
    private String phone;

    @Basic
    @Column(name="adddress" ,nullable=false)
    private String address;

    @Basic
    @Column(name="is_audit" ,nullable = false)
    private Boolean isAudit;
}
