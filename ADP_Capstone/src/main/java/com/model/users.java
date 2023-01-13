public class users {
    int employeeID;
    String email, username, password;


    public users(){};
    public users(int employeeID, String email,
                 String username, String password){
        this.employeeID = employeeID;
        this.email = email;
        this.username= username;
        this.password= password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
