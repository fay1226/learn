import java.util.*;

class Student
{
	//id学号
	private String id;
	private String name;
	public void setIdName(String id,String name){
		this.id=id;
		this.name=name;
	}
	public String getIdName(){
		if(id.length()!=8){
			return "非法!学号为6位数字"+"\n姓名:"+name;
		}else
		return "学号:"+id+"\n姓名:"+name;
	}
	//性别
	char sex;
	public void setSex(char s){
		sex=s;
	}
	public char getSex(){
		if(sex=='男'||sex=='女'){
			return sex;
		}
		return 0;
	}
	//生日
	String birth;
	public void setBirth(String b){
		this.birth=b;
	}
	public String getBirth(){
		return birth;
	}
	//年龄
	private int age;
	public void setAge(int a){
		age=a;
	}
	public int getAge(){
		return age>=0&&age<150?age:0;
	}
	//身高
	double high;
	public void setHigh(double dh){
		high=dh;
	}
	public double getHigh(){
		return high>15&&high<250?high:160;
	}
	//体重
	double weight;
	public void setWeight(double dw){
		weight=dw;
	}
	public double getWeight(){
		return weight>60&&weight<350?weight:125;
	}
}
