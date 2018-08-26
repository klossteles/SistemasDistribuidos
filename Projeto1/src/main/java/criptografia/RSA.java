package criptografia;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.PrivateKey;
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
     * @return [java.security.KeyPair] contendo um par de chaves Pública e Privada.
     */
    public static KeyPair gerarChavePublicaPrivada(){
        KeyPairGenerator kpg;
        
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
        } catch(NoSuchAlgorithmException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao Gerar par de Chaves Pública/Privada com algoritmo RSA.");
        }
        
        return kpg.generateKeyPair();
    }

    /**
     * Criptografa uma mensagem em texto puro com uma chave Privada RSA.
     * 
     * @param privateKey [Obrigatório] - Chave Privada para criptografia.
     * @param message    [Obrigatório] - Mensagem que será criptografada.
     * 
     * @return [byte[]] contendo a mensagem criptografada.
     */
    public static byte[] criptografar(PrivateKey privateKey, String message){
        if(privateKey == null || message == null){
            return null;
        }
        
        Cipher cipher;
        byte[] dadosCriptografados = null;

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            dadosCriptografados = cipher.doFinal(message.getBytes());
        } catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dadosCriptografados;
    }

    /**
     * Descriptografa um conjunto de bytes com uma chave pública RSA.
     * 
     * @param publicKey [Obrigatório] - Chave Pública para descriptografia.
     * @param data      [Obrigatório] - Array de Bytes que serão descriptografados.
     * @param encode    [Obrigatório] - O encoding da mensagem original. Necessário para conversão entre bytes para String.
     * 
     * @return [java.lang.String] contendo a mensagem descriptografada.
     */
    public static String descriptografar(PublicKey publicKey, byte[] data, Charset encode){
        if(publicKey == null || data == null || encode == null){
            return null;
        }
        
        Cipher cipher;
        byte[] dadosDescriptografados = null;

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            dadosDescriptografados = cipher.doFinal(data);
        } catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(RSA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new String(dadosDescriptografados, encode);
    }
}
