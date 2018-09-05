/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import constantes.ProcessResourceState;

/**
 *
 * @author Brendon
 */
public class Recurso {
    private final int id;
    
    /**
     * Identifica o estado de Solicitação desde Recurso pelo Processo que o armazena.
     */
    private ProcessResourceState estadoSolicitacao;
    
    /**
     * Fila de Processos que solicitaram o uso deste recurso.
     * O JSON possui o ID do Processo e o timestamp da solicitação do recurso.
     */
    private final List<JSONObject> processosSolicitantes;

    public Recurso(int id, ProcessResourceState state){
        this.id = id;
        this.estadoSolicitacao = state;
        this.processosSolicitantes = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public ProcessResourceState getEstadoSolicitacao(){
        return estadoSolicitacao;
    }

    public List<JSONObject> getProcessosSolicitantes(){
        return processosSolicitantes;
    }

    public void setEstadoSolicitacao(ProcessResourceState estadoSolicitacao){
        this.estadoSolicitacao = estadoSolicitacao;
    }
    
    /**
     * Adiciona um Processo ao fim da fila de solicitantes.
     * @param process 
     */
    public void addProcessoSolicitante(JSONObject process){
        if(process == null){
            return;
        }
        
        this.processosSolicitantes.add(process);
    }
    
    /**
     * Remove o primeiro Processo da fila de solicitantes.
     */
    public void removeProcessoSolicitante(){
        if(this.processosSolicitantes.isEmpty()){
            return;
        }
        
        this.processosSolicitantes.remove(0);
    }    
}
