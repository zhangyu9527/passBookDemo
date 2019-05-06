package com.zhangyu.passbook.merchants.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 商户对象模型
 */
@Data
@NoArgsConstructor//无参的构造函数
@AllArgsConstructor//全参的构造函数
@Entity//实体对象
@Table(name = "merchants")
public class Merchants {
    //商户id 主键
    @Id
    @GeneratedValue
    @Column(name = "id",nullable = false)
    private Integer id;

    //商户名称 全局唯一
    @Basic//这个字段属于这张表  @Transient 表示不属于
    @Column(name="name",unique = true,nullable = false)
    private String name;

    //商户logourl地址
    @Basic
    @Column(name = "logo_url",nullable = false)
    private String logoUrl;

    //商户营业执照
    @Basic
    @Column(name = "business_license_url",nullable = false)
    private String businessLicenseUrl;

    //商户的联系电话
    @Basic
    @Column(name = "phone",nullable=false)
    private String phone;

    //商户的地址
    @Basic
    @Column(name = "address", nullable=false)
    private String address;

    //商户是否通过审核
    @Basic
    @Column(name = "is_audit",nullable = false)
    private Boolean isAudit=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getAudit() {
        return isAudit;
    }

    public void setAudit(Boolean audit) {
        isAudit = audit;
    }
}
