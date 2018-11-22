package modelo;

/**
 * Created by guido on 20/05/2016.
 */
public class Usuario {
    private String name;
    private String email;
    private String username;
    private String pass;

    public Usuario() {
    }

    public Usuario(String name, String username, String pass, String email) {
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {this.username = user;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                "user='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
