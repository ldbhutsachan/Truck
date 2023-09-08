package com.ldb.truck.Model.Login.Login;

public class GetUserLoginOut {
    private String staftName;
    private String role;
    private String staftId;

    public GetUserLoginOut() {
    }

    public GetUserLoginOut(String staftName, String role, String staftId) {
        this.staftName = staftName;
        this.role = role;
        this.staftId = staftId;
    }

    public String getStaftName() {
        return staftName;
    }

    public void setStaftName(String staftName) {
        this.staftName = staftName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStaftId() {
        return staftId;
    }

    public void setStaftId(String staftId) {
        this.staftId = staftId;
    }

    @Override
    public String toString() {
        return "GetUserLoginOut{" +
                "staftName='" + staftName + '\'' +
                ", role='" + role + '\'' +
                ", staftId='" + staftId + '\'' +
                '}';
    }
}
