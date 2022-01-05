package bean;

public class ErrorMessage implements java.io.Serializable{
	
	private String checkNullOfId;
	private String checkNullOfName;
	private String checkNullOfBirthday;
	private String checkFormatOfId;
	private String checkDigitOfBirthday;
	private String checkDigitOfBase_salary;
	private String checkDigitOfId;
	
	
	public String getCheckNullOfId() {
		return checkNullOfId;
	}
	
	public String getCheckNullOfName() {
		return checkNullOfName;
	}
	
	public String getCheckNullOfBirthday() {
		return checkNullOfBirthday;
	}
	
	public String getCheckFormatOfId() {
		return checkFormatOfId;
	}
	
	public String getCheckDigitOfBirthday() {
		return checkDigitOfBirthday;
	}
	
	public String getCheckDigitOfBase_salary() {
		return checkDigitOfBase_salary;
	}
	
	public String getCheckDigitOfId() {
		return checkDigitOfId;
	}
	

	public void setCheckNullOfId(String checkNullOfId) {
		this.checkNullOfId=checkNullOfId;
	}
	
	public void setCheckNullOfName(String checkNullOfName) {
		this.checkNullOfName=checkNullOfName;
	}
	
	public void setCheckNullOfBirthday(String checkNullOfBirthday) {
		this.checkNullOfBirthday=checkNullOfBirthday;
	}
	
	public void setCheckFormatOfId(String checkFormatOfId) {
		this.checkFormatOfId=checkFormatOfId;
	}
	
	public void setCheckDigitOfBirthday(String checkDigitOfBirthday) {
		this.checkDigitOfBirthday=checkDigitOfBirthday;
	}
	
	public void setCheckDigitOfBase_salary(String checkDigitOfBase_salary) {
		this.checkDigitOfBase_salary=checkDigitOfBase_salary;
	}
	
	public void setCheckDigitOfId(String checkDigitOfId) {
		this.checkDigitOfId=checkDigitOfId;
	}

}