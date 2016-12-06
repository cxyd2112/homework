package vo;

import po.UserPo;

public class UserVo {

    private int id;
	
	private String userName;
	
	private String birthday;
	
	private String phone;
	
	private int credit;
	
	private String company;
	
	public UserVo(){
		super();
	}
	
	public UserVo(UserPo userPo){
		super();
		this.id = userPo.getId();
		this.userName = userPo.getUserName();
		this.birthday = userPo.getBirthday();
		this.phone = userPo.getPhone();
		this.credit = userPo.getCredit();
		this.company = userPo.getCompany();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
}
