/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

/**
 * Conjunto de constantes que definem os possíveis estados de solicitação de um
 * recurso por um processo.
 * 
 * @author Brendon
 */
public enum ProcessResourceState {

    RELEASED(0),
    WANTED(1),
    HELD(2);
    
    private final int stateCode;
    
    private ProcessResourceState(int state){
        this.stateCode = state;
    }

    /**
     * Retorna o número inteiro que representa o estado de solicitação do Recurso.
     * @return 
     */
    public int getStateCode(){
        return stateCode;
    }
    
    /**
     * Dado um código inteiro de um state, retorna o objeto constante que 
     * representa esse tipo.
     * @param code
     * @return 
     */
    public static ProcessResourceState getStateByCode(int code){
        ProcessResourceState[] states = values();
        for(ProcessResourceState s : states){
            if(s.getStateCode() == code){
                return s;
            }
        }
        
        return null;
    }
}
