package com.ldb.truck.Model.Login.staft;

public class stafReq {
    private String id;
    private String staftId;
    private String name;
    private String surname;
    private String idCard;
    private String licenceId;
    private String verBy;
    private String licenceExp;
    private String vaillage;
    private String district;
    private String province;
    private String mobile;
    private String mobile1;
    private String gender;
    private String genderStatus;
    private String userId;
    private String dataTime;

    public stafReq() {
    }

    public stafReq(String staftId) {
        this.staftId = staftId;
    }

    public stafReq(String staftId, String name, String surname, String idCard, String licenceId, String verBy, String licenceExp, String vaillage, String district, String province, String mobile, String mobile1, String gender, String genderStatus, String userId, String dataTime) {
        this.staftId = staftId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.licenceId = licenceId;
        this.verBy = verBy;
        this.licenceExp = licenceExp;
        this.vaillage = vaillage;
        this.district = district;
        this.province = province;
        this.mobile = mobile;
        this.mobile1 = mobile1;
        this.gender = gender;
        this.genderStatus = genderStatus;
        this.userId = userId;
        this.dataTime = dataTime;
    }

    public stafReq(String staftId, String name, String surname, String idCard, String licenceId, String verBy, String licenceExp, String vaillage, String district, String province, String mobile, String mobile1, String gender, String genderStatus, String userId) {
        this.staftId = staftId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.licenceId = licenceId;
        this.verBy = verBy;
        this.licenceExp = licenceExp;
        this.vaillage = vaillage;
        this.district = district;
        this.province = province;
        this.mobile = mobile;
        this.mobile1 = mobile1;
        this.gender = gender;
        this.genderStatus = genderStatus;
        this.userId = userId;
    }

    public stafReq(String id, String staftId, String name, String surname, String idCard, String licenceId, String verBy, String licenceExp, String vaillage, String district, String province, String mobile, String mobile1, String gender, String genderStatus, String userId, String dataTime) {
        this.id = id;
        this.staftId = staftId;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.licenceId = licenceId;
        this.verBy = verBy;
        this.licenceExp = licenceExp;
        this.vaillage = vaillage;
        this.district = district;
        this.province = province;
        this.mobile = mobile;
        this.mobile1 = mobile1;
        this.gender = gender;
        this.genderStatus = genderStatus;
        this.userId = userId;
        this.dataTime = dataTime;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getStaftId() {
        return staftId;
    }

    public void setStaftId(String staftId) {
        this.staftId = staftId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public String getVerBy() {
        return verBy;
    }

    public void setVerBy(String verBy) {
        this.verBy = verBy;
    }

    public String getLicenceExp() {
        return licenceExp;
    }

    public void setLicenceExp(String licenceExp) {
        this.licenceExp = licenceExp;
    }

    public String getVaillage() {
        return vaillage;
    }

    public void setVaillage(String vaillage) {
        this.vaillage = vaillage;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenderStatus() {
        return genderStatus;
    }

    public void setGenderStatus(String genderStatus) {
        this.genderStatus = genderStatus;
    }

    @Override
    public String toString() {
        return "stafReq{" +
                "staftId='" + staftId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idCard='" + idCard + '\'' +
                ", licenceId='" + licenceId + '\'' +
                ", verBy='" + verBy + '\'' +
                ", licenceExp='" + licenceExp + '\'' +
                ", vaillage='" + vaillage + '\'' +
                ", district='" + district + '\'' +
                ", province='" + province + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobile1='" + mobile1 + '\'' +
                ", gender='" + gender + '\'' +
                ", genderStatus='" + genderStatus + '\'' +
                ", userId='" + userId + '\'' +
                ", dataTime='" + dataTime + '\'' +
                '}';
    }
}
