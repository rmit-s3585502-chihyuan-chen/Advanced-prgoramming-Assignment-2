package Data;
/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description setting the role of athletes 
 */


public class Athletes {
	private String id;
	private String type;
	private String name;
	private int age;
	private String state;
	private int point;
	public Athletes(String id, String type,String name, int age, String state,int point) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.age = age;
		this.state = state;
		this.point = point;
	}
	public int compete(String superName) {
		return 0;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}

	public int getPoint() {
		return point;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}	
	
	public void setPoint(int i) {
		point = point + i;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}