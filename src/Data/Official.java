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