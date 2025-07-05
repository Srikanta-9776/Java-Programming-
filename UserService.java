import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private User currentUser = null;

    public boolean registerUser(String username, String password, String fullname, String contact) {

        if (userMap.containsKey(username)) {
            System.out.println("Username altready exits,please choose another");
            return false;
        }

        User user = new User(username, password, fullname, contact);
        userMap.put(username, user);
        System.out.println("register scceesfull");
        return true;
    }
    public boolean loginUser(String username,String password){
        if (!userMap.containsKey(username)) {
            System.out.println("No user found with this username");
            return false;
        }
        User user =userMap.get(username);
        if(!user.getPassword().equals(password)){
            System.out.println("wrong password");
            return false;
        }
        currentUser =user;
        System.out.println("welcom:"+currentUser.getFullname()+"!");
        return true;

    }
    public void logpOutUser(){
        if(currentUser!=null){
            System.out.println("logged out:"+currentUser.getFullname());

        }
        currentUser=null;
    }
    public User getCurrentUser(){
        return currentUser;
    }
    public boolean isloggedIn(){
        return currentUser!=null;
    }

    public void logOutUSer() {

    }
}
