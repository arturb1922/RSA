import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class RSA {

    private  static BigInteger p;
    private  static BigInteger q ;
    private  static BigInteger n;
    private static BigInteger phi;
    private static BigInteger d;
    private static BigInteger e;
    static ArrayList<BigInteger> temp = new ArrayList<>();
    Random random = new SecureRandom();
    public RSA(BigInteger p, BigInteger q)
    {
        this.p=p;
        this.q=q;

        n=p.multiply(q);
        phi=(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        do e = new BigInteger(phi.bitLength(), random);
        while (e.compareTo(BigInteger.ONE) <= 0
                || e.compareTo(phi) >= 0
                || !e.gcd(phi).equals(BigInteger.ONE));
        d = e.modInverse(phi);
    }

    public static String encrypt(String message)
    {



        for(int i=0;i<message.length();i++)
        {
            BigInteger pom = new BigInteger(String.valueOf((int)message.charAt(i)));
            temp.add(pom.modPow(e,n));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.size();i++)
        {
            BigInteger pom = temp.get(i);
            sb.append(Character.toString((char) pom.intValue()));
        }
        String encryptedMessage = sb.toString();
        return encryptedMessage;
    }

    public static String decrypt(String message)
    {
        ArrayList<BigInteger> temp1 = new ArrayList<>();


        for(int i=0;i<message.length();i++)
        {
            BigInteger pom = temp.get(i);
            temp1.add(pom.modPow(d,n));
        }
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<temp1.size();i++)
        {
            BigInteger pom = temp1.get(i);
            sb1.append(Character.toString((char) pom.intValue()));
        }
        String decryptedMessage = sb1.toString();
        return decryptedMessage;
    }
}
