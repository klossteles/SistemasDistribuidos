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
import java.time.Instant;

/**
 * Representa um recurso que pode ser solicitado por um Processo.
 * @author Brendon
 */
public class Recurso {
    //Identificador do recurso, utilizado para requisitar um recurso específico.
    private final int id;
    
    /**
     * Identifica o estado de Solicitação desde Recurso pelo Processo que o armazena.
     */
    private ProcessResourceState estadoSolicitacao;
    
    /**
     * Identifica o momento que o recurso foi solicitado pelo Processo que o armazena.
     */
    private Instant momentoSolicitacao;
    /**
     * Fila de Processos que solicitaram o uso deste recurso.
     * O JSON possui o ID do Processo e o timestamp da solicitação do recurso.
     */
    private final List<JSONObject> processosSolicitantes;

    public Recurso(int id, ProcessResourceState state, Instant instant){
        this.id = id;
        this.estadoSolicitacao = state;
        this.momentoSolicitacao = instant;
        this.processosSolicitantes = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public ProcessResourceState getEstadoSolicitacao(){
        return estadoSolicitacao;
    }

    public Instant getMomentoSolicitacao(){
        return momentoSolicitacao;
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
     * @return 
     */
    public JSONObject removeProcessoSolicitante(){
        if(this.processosSolicitantes.isEmpty()){
            return null;
        }
        
        return this.processosSolicitantes.remove(0);
    }
    
    public void solicitar(){
        this.estadoSolicitacao = ProcessResourceState.WANTED;
        this.momentoSolicitacao = Instant.now();
    }
    
    public void liberar(){
        this.estadoSolicitacao = ProcessResourceState.RELEASED;
        this.momentoSolicitacao = Instant.MAX;
    }
    
    public void alocado(){
        this.estadoSolicitacao = ProcessResourceState.HELD;
    }
}
