public abstract class Usuario {
    private String username;
    private String password;

    public Usuario(String username, String password) {
        username = username;
        password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String usr) {
        username = usr;
    }

    public void setPassword(String psswd) {
        password = psswd;
    }
}