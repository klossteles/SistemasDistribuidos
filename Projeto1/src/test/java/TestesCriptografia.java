
import constantes.MessageType;
import criptografia.RSA;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Brendon
 */
public class TestesCriptografia {
    
    public static void main(String[] args){
        
        JSONObject json = new JSONObject("{\"request_time\":1536863327,\"message_type\":5,\"id\":1536863319536,\"id_resource\":1}");
        
        KeyPair keys = RSA.gerarChavePublicaPrivada();
        String stringPublicKey = RSA.publicKeyToString(keys.getPublic());
        String stringPrivateKey = RSA.privateKeyToString(keys.getPrivate());
        System.out.println("PUBLIC: " + stringPublicKey);
        System.out.println("PRIVATE: " + stringPrivateKey);
        
        PublicKey castPublic = RSA.StringToPublicKey(stringPublicKey);
        PrivateKey castPrivate = RSA.StringToPrivateKey(stringPrivateKey);
        
        System.out.println("() PUBLIC: " + RSA.publicKeyToString(castPublic));
        System.out.println("() PRIVATE: " + RSA.privateKeyToString(castPrivate));
        
        String data = RSA.criptografar(keys.getPrivate(), json.toString(), StandardCharsets.ISO_8859_1);
        
        System.out.println("JSON: " + json.toString());
        System.out.println("KEY: " + RSA.publicKeyToString(keys.getPublic()));
        System.out.println("CRIP: " + data);
        System.out.println("DESCRIP: " + RSA.descriptografar(keys.getPublic(), data, StandardCharsets.ISO_8859_1));                       
        
        byte[] dados = Base64.getEncoder().encode("teste".getBytes(StandardCharsets.ISO_8859_1));
        
        System.out.println("aaa: " + new String(dados, StandardCharsets.ISO_8859_1));
        System.out.println("bbb: " + new String(Base64.getDecoder().decode(new String(dados, StandardCharsets.ISO_8859_1)), StandardCharsets.ISO_8859_1));
    }
    
}
