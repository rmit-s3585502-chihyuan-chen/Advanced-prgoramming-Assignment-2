package Data;

/**
 * @date 14.05.2017
 * @author Chih Yuan Chen S3585502
 * @version 2.0
 * @Description setting the role of athletes 
 */


public class Official{
	   private String id;      //set id parameter  
	   private String type;   //set type parameter  
	   private String name;   //set name parameter   
	   private int age;       //set age parameter
	   private String state;  //set state parameter
	   private int point;    //set point parameter
	   //set attributes of official
	   public Official (String id,String type,String name,int age,String state,int point){
		   this.setId(id);
		   this.setType(type);
		   this.setName(name);
		   this.setAge(age);
		   this.setState(state);
		   this.setPoint(point);
	   }
	   public String getId() { //get officer id
			return id;
		}
		
		public String getName() {//get officer name
			return name;
		}
		
		public int getAge() { //get officer age
			return age;
		}

		public int getPoint() {//get officer point
			return point;
		}
		
		public String getState() { //get officer's state
			return state;
		}

		public void setState(String state) { //set officer state
			this.state = state;
		}

		public void setId(String id) { //set officer id
			this.id = id;
		}
		
		public void setName(String name) {// set officer name
			this.name = name;
		}

		public void setAge(int age) { //set officer age
			this.age = age;
		}	
		
		public void setPoint(int i) {//set officer point
			point = point + i;
		}
		
		public String getType() { //get officer type
			return type;
		}

		public void setType(String type) {//set officer type
			this.type = type;
		}
}