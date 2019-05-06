package com.zhangyu.passbook.merchants.vo;

import com.zhangyu.passbook.merchants.constant.ErrorCode;
import com.zhangyu.passbook.merchants.dao.MerchantsDao;
import com.zhangyu.passbook.merchants.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequest {
    private String name;
    private String logoUrl;
    /**商业营业执照**/
    private String businessLicenseUrl;
    private String phone;
    private String address;

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

    /**
     * 验证请求的有效性
     * @param merchantsDao{@link MerchantsDao}
     */
    public ErrorCode validate(MerchantsDao merchantsDao){
        if(merchantsDao.findByName(this.name)!=null){
            return ErrorCode.DUPLICATE_NAME;
        }
        if(null==this.logoUrl){
            return ErrorCode.EMPTY_LOGO;
        }
        if(null==this.businessLicenseUrl){
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if (null==this.phone){
            return ErrorCode.ERROR_PHONE;
        }
        if(null==this.address){
            return ErrorCode.EMPTY_ADDRESS;
        }
        return ErrorCode.SUCCESS;
    }
    //将请求对象转换为商户对象
    public Merchants toMerchants(){
        Merchants merchants=new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        return merchants;
    }
}
