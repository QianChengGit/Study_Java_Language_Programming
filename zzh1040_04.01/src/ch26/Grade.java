package ch26;

public class Grade {
	
	private String gName;
	private Student[] stuArr;
	
	public Grade(){}
	public Grade(String n){
		this.gName=n;
	}
	public void setStuArr(Student[] ss){
		this.stuArr=ss;
	}
	public Student[] getStuArr(){
		return this.stuArr;
	}
	public void printStuArr(){
		int i;
		for(i=0;i<this.stuArr.length;i++){
			stuArr[i].showStu();
		}
	}
	
}
