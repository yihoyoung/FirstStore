import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by hoyounglee on 2016. 5. 29..
 */
public class GeneratorPassword {
    @Test
    public void testBCrypt(){
        System.out.println(new BCryptPasswordEncoder().encode("password"));
        
        // $2a$10$/6F7p3vr7e83Hyc591dlturNPdfC.SPYoMQc2N4JzvG3kzOMzusSG
    }
}
