package bean;

import java.math.BigDecimal;

public class EmployeeData implements java.io.Serializable{
	
	private Integer employee_id;
	private String affiliation_cd;
	private String position_cd;
	private String employee_nm;
	private String gender;
	private String foreign_nationality;
	private String birthday;
	private BigDecimal base_salary;
	private String memo;
	private Integer hidden_employee_id;
	private String delete_flag;

	public Integer getEmployee_id() {
		return employee_id;
	}
	
	public String getAffiliation_cd() {
		return affiliation_cd;
	}
	
	public String getPosition_cd() {
		return position_cd;
	}
	
	public String getEmployee_nm() {
		return employee_nm;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getForeign_nationality() {
		return foreign_nationality;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public BigDecimal getBase_salary() {
		return base_salary;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public Integer getHidden_employee_id() {
		return hidden_employee_id;
	}
	
	public String getDelete_flag() {
		return delete_flag;
	}
	
	
	public void setEmployee_id(Integer employee_id) {
		this.employee_id=employee_id;
	}
	
	public void setAffiliation_cd(String affiliation_cd) {
		this.affiliation_cd=affiliation_cd;
	}
	
	public void setPosition_cd(String position_cd) {
		this.position_cd=position_cd;
	}
	
	public void setEmployee_nm(String employee_nm) {
		this.employee_nm=employee_nm;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public void setForeign_nationality(String foreign_nationality) {
		this.foreign_nationality=foreign_nationality;
	}
	
	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}
	
	public void setBase_salary(BigDecimal base_salary) {
		this.base_salary=base_salary;
	}
	
	public void setMemo(String memo) {
		this.memo=memo;
	}
	
	public void setHidden_employee_id(Integer hidden_employee_id) {
		this.hidden_employee_id=hidden_employee_id;
	}
	
	public void setDelete_flag(String delete_flag) {
		this.delete_flag=delete_flag;
	}
	
}