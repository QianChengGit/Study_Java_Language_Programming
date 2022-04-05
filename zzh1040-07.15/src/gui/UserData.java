package gui;
public class UserData {
	private  String name;
	private  String student_number;
	private  String sex;
	private  String birthday;
	private  String address;
	private  String phone;
	private  String password;//static
	
	public UserData() {
		// TODO 自动生成的构造函数存根
	}
	
	public UserData(String name,String student_number,String sex,String birthday,String address,String phone,String password) {
		
		this.name = name;
		this.student_number =student_number;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.password=password;
		System.out.println(this.name+this.student_number+this.sex+this.birthday
				+this.address+this.phone+this.password);
	}
	
	public String getStudent_number() {
		
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getName() {
		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

