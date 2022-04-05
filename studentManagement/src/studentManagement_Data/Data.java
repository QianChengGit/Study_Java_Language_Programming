package studentManagement_Data;

public class Data {
	private String StudentNumber;
	private String Password;
	private String Name;
	private String Sex;
	private String College;
	private String Major;
	private String StudentClass;
	private String State;
	
	public Data(){
		
	}
	
	public Data(String StudentNumber){
		this.setStudentNumber(StudentNumber); 
	}
	
	public Data(String StudentNumber,String Password,String Name,
			String Sex,String College,String Major,String StudentClass){
		this.setStudentNumber(StudentNumber);
		this.setPassword(Password);
		this.setName(Name);
		this.setSex(Sex);
		this.setCollege(College);
		this.setMajor(Major);
		this.setStudentClass(StudentClass);
		System.out.println(StudentNumber+" "+Password+" "+Name+" "+Sex+" "+
		College+" "+Major+" "+StudentClass);
	}
	
	public Data(String StudentNumber,String Password,String Name,
			String Sex,String College,String Major,String StudentClass,String State){
		this.setStudentNumber(StudentNumber);
		this.setPassword(Password);
		this.setName(Name);
		this.setSex(Sex);
		this.setCollege(College);
		this.setMajor(Major);
		this.setStudentClass(StudentClass);
		this.setState(State);
		System.out.println(StudentNumber+" "+Password+" "+Name+" "+Sex+" "+
		College+" "+Major+" "+StudentClass+" "+State);
	}

	public String getStudentNumber() {
		return StudentNumber;
	}
	
	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getCollege() {
		return College;
	}

	public void setCollege(String college) {
		College = college;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

	public String getStudentClass() {
		return StudentClass;
	}

	public void setStudentClass(String studentClass) {
		StudentClass = studentClass;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}
