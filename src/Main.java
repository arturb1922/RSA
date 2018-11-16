import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        RSA rsa = new RSA(BigInteger.valueOf(6829),BigInteger.valueOf(3881));


        String message = "Lorem ipsum dolor sit amet, consectetur cras amet.";
        System.out.println(message);


        String encrypted = rsa.encrypt(message);
        System.out.println(encrypted);
        String decrytpted=rsa.decrypt(encrypted);
        System.out.println(decrytpted);
    }
}


