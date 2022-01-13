package bean;

import java.math.BigDecimal;
import java.sql.Date;

public class EmployeeData implements java.io.Serializable {

    private String employeeId;
    private String affiliationCd;
    private String positionCd;
    private String employeeNm;
    private String gender;
    private String foreignNationality;
    private Date birthday;
    private BigDecimal baseSalary;
    private String memo;
    private String hiddenEmployeeId;
    private Boolean deleteFlag;

    public String getEmployeeId() {
        return employeeId;
    }
    public String getAffiliationCd() {
        return affiliationCd;
    }
    public String getPositionCd() {
        return positionCd;
    }
    public String getEmployeeNm() {
        return employeeNm;
    }
    public String getGender() {
        return gender;
    }
    public String getForeignNationality() {
        return foreignNationality;
    }
    public Date getBirthday() {
        return birthday;
    }
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }
    public String getMemo() {
        return memo;
    }
    public String getHiddenEmployeeId() {
        return hiddenEmployeeId;
    }
    public Boolean getDeleteFlag() {
        return deleteFlag;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public void setAffiliationCd(String affiliationCd) {
        this.affiliationCd = affiliationCd;
    }
    public void setPositionCd(String positionCd) {
        this.positionCd = positionCd;
    }
    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setForeignNationality(String foreignNationality) {
        this.foreignNationality = foreignNationality == null ? "0" : foreignNationality;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public void setHiddenEmployeeId(String hiddenEmployeeId) {
        this.hiddenEmployeeId = hiddenEmployeeId;
    }
    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}