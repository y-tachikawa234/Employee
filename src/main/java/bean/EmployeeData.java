package bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeData implements Serializable {

    /**
     * 社員ID.
     */
    private Integer employeeId;

    /**
     * 所属コード.
     */
    private String affiliationCd;

    /**
     * 役職コード.
     */
    private String positionCd;

    /**
     * 氏名.
     */
    private String employeeNm;

    /**
     * 性別.
     */
    private String gender;

    /**
     * 生年月日.
     */
    private String birthday;

    /**
     * 外国籍.
     */
    private String foreignNationality;
    /**
     * 基本給料.
     */
    private BigDecimal baseSalary;

    /**
     * 備考.
     */
    private String memo;

    /**
     * hidden社員ID.
     */
    private Integer hiddenEmployeeId;

    /**
     * 削除フラグ.
     */
    private String deleteFlag;

    /**
     * @return employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @return affiliationCd
     */
    public String getAffiliationCd() {
        return affiliationCd;
    }

    /**
     * @return positionCd
     */
    public String getPositionCd() {
        return positionCd;
    }

    /**
     * @return employeeNm
     */
    public String getEmployeeNm() {
        return employeeNm;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @return foreignNationality
     */
    public String getForeignNationality() {
        return foreignNationality;
    }

    /**
     * @return baseSalary
     */
    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @return hiddenEmployeeId
     */
    public Integer getHiddenEmployeeId() {
        return hiddenEmployeeId;
    }

    /**
     * @return deleteFlag
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param employeeId セットする employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @param affiliationCd セットする affiliationCd
     */
    public void setAffiliationCd(String affiliationCd) {
        this.affiliationCd = affiliationCd;
    }

    /**
     * @param positionCd セットする positionCd
     */
    public void setPositionCd(String positionCd) {
        this.positionCd = positionCd;
    }

    /**
     * @param employeeNm セットする employeeNm
     */
    public void setEmployeeNm(String employeeNm) {
        this.employeeNm = employeeNm;
    }

    /**
     * @param gender セットする gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @param birthday セットする birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @param foreignNationality セットする foreignNationality
     */
    public void setForeignNationality(String foreignNationality) {
        this.foreignNationality = foreignNationality;
    }

    /**
     * @param baseSalary セットする baseSalary
     */
    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * @param memo セットする memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @param hiddenEmployeeId セットする hiddenEmployeeId
     */
    public void setHiddenEmployeeId(Integer hiddenEmployeeId) {
        this.hiddenEmployeeId = hiddenEmployeeId;
    }

    /**
     * @param deleteFlag セットする deleteFlag
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
