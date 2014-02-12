package User;

public class Users {
	
	public String matriculation;
	public String permission;
	
	public Users(String matric, String perm){
		matriculation = matric;
		permission = perm;
	}

	public String getPermissions(){
		return permission;
	}

	public String getMatriculation(){
		return matriculation;
	}

}
