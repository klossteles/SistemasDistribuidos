package criptografia;

import java.util.Base64;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSA {

    /**
     * Gera uma par de chaves Públic/Privada utilizando o algoritmo RSA.
     *
     * @return [{@link java.security.KeyPair}] contendo um par de chaves Pública e
     * Privada.
     */
    public static KeyPair gerarChavePublicaPrivada(){
        KeyPairGenerator kpg;

        try {
            kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(4096);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao Gerar par de Chaves Pública/Privada com algoritmo RSA.");
        }

        return kpg.generateKeyPair();
    }

    /**
     * Criptografa uma mensagem em texto puro com uma chave (pública ou privada) RSA.
     *
     * @param key     [Obrigatório] - Chave para criptografia.
     * @param message [Obrigatório] - Mensagem que será criptografada.
     *
     * @return [byte[]] contendo a mensagem criptografada.
     */
    public static byte[] criptografar(Key key, String message){
        if(key == null || message == null){
            return null;
        }

        Cipher cipher;
        byte[] dadosCriptografados = null;

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            dadosCriptografados = cipher.doFinal(message.getBytes());
        } catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dadosCriptografados;
    }

    /**
     * Descriptografa um conjunto de bytes com uma chave (pública ou privada) RSA.
     *
     * @param key    [Obrigatório] - Chave para descriptografia.
     * @param data   [Obrigatório] - Array de Bytes que serão descriptografados.
     * @param encode [Obrigatório] - O encoding da mensagem original. Necessário
     * para conversão entre bytes para String.
     *
     * @return [{@link java.lang.String}] contendo a mensagem descriptografada.
     */
    public static String descriptografar(Key key, byte[] data, Charset encode){
        if(key == null || data == null || encode == null){
            return null;
        }

        Cipher cipher;
        byte[] dadosDescriptografados = null;

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, key);
            dadosDescriptografados = cipher.doFinal(data);
        } catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new String(dadosDescriptografados, encode);
    }
    
    public static String privateKeyToString(PrivateKey key){
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec spec = factory.getKeySpec(key, PKCS8EncodedKeySpec.class);
            return Base64.getEncoder().encodeToString(spec.getEncoded());
        } catch(NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static String publicKeyToString(PublicKey key){
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec spec = factory.getKeySpec(key, X509EncodedKeySpec.class);
            return Base64.getEncoder().encodeToString(spec.getEncoded());
        } catch(NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static PrivateKey StringToPrivateKey(String key){
        try {
            byte[] data = Base64.getDecoder().decode(key);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(spec);
        } catch(NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static PublicKey StringToPublicKey(String key){
        try {
            byte[] data = Base64.getDecoder().decode(key);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePublic(spec);
        } catch(NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
