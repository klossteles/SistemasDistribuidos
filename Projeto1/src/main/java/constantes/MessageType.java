/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

/**
 * 
 * @author Brendon
 */
public enum MessageType {
    
    GROUP_IN(0),
    GROUP_OUT(1),
    RESOURCE_REQUEST(2),
    RESOURCE_RELEASE(3),
    ANNOUNCE(4),
    RESOURCE_OK(5),
    RESOURCE_DENIAL(6);

    private final int typeCode;

    private MessageType(int typeCode){
        this.typeCode = typeCode;
    }

    /**
     * Retorna o número inteiro que representa o tipo da Mensagem.
     * @return 
     */
    public int getTypeCode(){
        return typeCode;
    }
 
    /**
     * Dado um código inteiro de uma message, retorna o objeto constante que 
     * representa esse tipo.
     * @param code
     * @return 
     */
    public static MessageType getTypeByCode(int code){
        MessageType[] types = values();
        for(MessageType type : types){
            if(type.getTypeCode() == code){
                return type;
            }
        }
        
        return null;
    }
}
