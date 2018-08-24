import java.security.PublicKey;
import java.security.PrivateKey;
import javax.crypto.Cipher;

public class RSA{
    public static byte[] criptografar(PrivateKey privateKey, String message){
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        
        return cipher.doFinal(message.getBytes());
    }

    public static descriptografar(PublicKey publicKey, byte[] data){
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

}