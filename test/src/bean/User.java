package bean;


import java.util.Date;

public class User  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8520852L;

	/**
	 * //ÐÔ±ð-true-ÄÐ
	 */
	private boolean sex;
	
	private Date birthday;
	
	private String school;
	
	private String qqNumber;
	
	private String realName;
	

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
}
