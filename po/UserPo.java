package po;

/**
 * id           用户ID
 * userName     用户姓名
 * birthday     用户生日
 * phone        用户电话
 * credit	           用户信用
 * company		所属公司
 * @author summer
 */

public class UserPo {
	
	private int id;
	
	private String userName;
	
	private String birthday;
	
	private String phone;
	
	private int credit;
	
	private String company;
	
	public UserPo(){
		super();
	}
	
	public UserPo(int id,String userName,String birthday,String phone,
			int credit,String company){
		super();
		this.id = id;
		this.userName = userName;
		this.birthday = birthday;
		this.phone = phone;
		this.credit = credit;
		this.company = company;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public int getCredit(){
		return credit;
	}
	
	public void setCredit(int credit){
		this.credit = credit;
	}
	
	public String getCompany(){
		return company;
	}
	
	public void setCompany(String company){
		this.company = company;
	}

}
