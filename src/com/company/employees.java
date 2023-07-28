package com.company;

public class employees {
    private  int employeesId;
    private String employeesName;
    private String employeesPhone;
    private String employeestCity;

    public employees(int employeesId, String employeesName, String employeesPhone, String employeestCity) {
        super();
        this.employeesId = employeesId;
        this.employeesName = employeesName;
        this.employeesPhone = employeesPhone;
        this.employeestCity = employeestCity;
    }
    public employees(String employeesName, String employeesPhone, String employeestCity) {
        super();
        this.employeesName = employeesName;
        this.employeesPhone = employeesPhone;
        this.employeestCity = employeestCity;
    }
    public employees() {
        super();

    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public String getEmployeesPhone() {
        return employeesPhone;
    }

    public void setEmployeesPhone(String employeesPhone) {
        this.employeesPhone = employeesPhone;
    }

    public String getEmployeestCity() {
        return employeestCity;
    }

    public void setEmployeestCity(String employeestCity) {
        this.employeestCity = employeestCity;
    }

    @Override
    public String toString() {
        return "employees{" +
                "employeesId=" + employeesId +
                ", employeesName='" + employeesName + '\'' +
                ", employeesPhone='" + employeesPhone + '\'' +
                ", employeestCity='" + employeestCity + '\'' +
                '}';
    }
}
