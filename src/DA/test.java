package DA;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class test{
    public static void main (String args[]){
        String password = "asdasdasd";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println("BCrypt hash: " + hash);
        boolean valuate = BCrypt.checkpw(password, "$2a$12$ifNgDqfCpli06jsADJ8UZu84YS8NGGk06fyzJ0TWSYWP0pta.3IF6");
        System.out.println(valuate);
    }
}