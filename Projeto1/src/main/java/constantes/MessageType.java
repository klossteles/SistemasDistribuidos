/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

/**
 * Define os tipos de mensagens que podem ser trocadas entre os processos do
 * grupo multicast.
 * 
 * @author Brendon
 */
public enum MessageType {
    
    GROUP_IN(0),//Anunciar entrada no grupo multicast
    GROUP_OUT(1),//Anunciar saída do grupo multicast
    RESOURCE_REQUEST(2),//Requisitar o uso exclusivo de um recurso.
    RESOURCE_RELEASE(3),//Liberar o uso exclusivo de um recurso.
    ANNOUNCE(4),//Anunciar um processo no grupo multicast, após um timeout.
    RESOURCE_OK(5),//Resposta positiva a requisição de um recurso por outro processo.
    RESOURCE_DENIAL(6);//Resposta negativa a requisição de um recurso por outro processo.

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
