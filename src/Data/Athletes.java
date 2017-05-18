package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description setting the role of athletes 
 */


public class Athletes {
	private String id;    //define id is string value
	private String type;  //define game type is string value
	private String name;  //define name is string value
	private int age;      //define age is integer value
	private String state; //define state is string value
	private int point;    //define point is integer value
	public Athletes(String id, String type,String name, int age, String state,int point) {// set all attributes of athletes
		this.id = id;
		this.type = type;
		this.name = name;
		this.age = age;
		this.state = state;
		this.point = point;
	}
	public int compete(String superName) { //set compete method to let subclass to run the game
		return 0;
	}
	
	public String getId() { //get id
		return id;
	}
	
	public String getName() {//get name
		return name;
	}
	
	public int getAge() { //get age
		return age;
	}

	public int getPoint() { //get point
		return point;
	}
	
	public String getState() { //get state
		return state;
	}

	public void setState(String state) { //set state
		this.state = state;
	}

	public void setId(String id) { //set id
		this.id = id;
	}
	
	public void setName(String name) { //set name
		this.name = name;
	}

	public void setAge(int age) { //set age
		this.age = age;
	}	
	
	public void setPoint(int i) { //set point
		point = point + i;
	}
	
	public String getType() {  //get the type of athletes
		return type;
	} 

	public void setType(String type) { //set the type of athletes
		this.type = type;
	}
}