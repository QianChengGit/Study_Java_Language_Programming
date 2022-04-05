package ch32;

public class Student {
		private String name;
		private String ID;
		private int age;



public Student(String name,int age,String ID){

			this.name = name;

			this.age = age;
			
			this.ID=ID;

		}		

		

public String getName() {

			return name;

		}
		


public void setName(String name) {

			this.name = name;

		}
		


public int getAge() {

			return age;

		}
		


public void setAge(int age) {

			this.age = age;

		}		

public String getID() {

	return ID;

}

public void setID(String ID) {

	this.ID = ID;

}
		@Override

public String toString() {

			return "ĞÕÃû:" + name + "\nÄêÁä£º" + age + "Ëê\nÑ§ºÅ£º"+ID;

		}		

}

