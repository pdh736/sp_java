package sp_java.json;

import java.util.ArrayList;

public class Department {
	public int id;
	public String name;
	public ArrayList<String> users;
	
	public Department() {
	}
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
		users = new ArrayList<String>();
		users.add("park");
		users.add("kim");
	}
	
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

}
