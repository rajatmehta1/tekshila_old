import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    public static void main(String[] args) {
        String encoded = new BCryptPasswordEncoder().encode("Admin123");
        System.out.println(encoded);
    }
}
