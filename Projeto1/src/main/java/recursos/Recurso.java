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
import org.json.JSONArray;

/**
 * Representa um recurso que pode ser solicitado por um Processo.
 *
 * @author Brendon
 */
public class Recurso {

    //Identificador do recurso, utilizado para requisitar um recurso específico.
    private final int id;

    /**
     * Identifica o estado de Solicitação desde Recurso pelo Processo que o
     * armazena.
     */
    private ProcessResourceState estadoSolicitacao;

    /**
     * Identifica o momento que o recurso foi solicitado pelo Processo que o
     * armazena.
     */
    private Instant momentoSolicitacao;
    
    /**
     * Fila de Processos que solicitaram o uso deste recurso. O JSON possui o ID
     * do Processo e o timestamp da solicitação do recurso.
     */
    private final List<JSONObject> processosSolicitantes;


    /**
     * Contados de mensagens recebidas. Utilizado para determinar se todos os
     * processos conhecidos responderam a uma data mensagem enviada.
     */
    private int receivedMessagesOk = 0;
    private int receivedMessagesDenial = 0;

    /**
     * Construtor do Recurso
     *
     * @param id
     * @param state
     * @param instant
     */
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
     *
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
     *
     * @return
     */
    public JSONObject removeProcessoSolicitante(){
        if(this.processosSolicitantes.isEmpty()){
            return null;
        }

        return this.processosSolicitantes.remove(0);
    }

    /**
     * Define o status desse recurso como WANTED, indicando que seu uso é de 
     * interesse do processo atual.
     */
    public void solicitar(){
        this.estadoSolicitacao = ProcessResourceState.WANTED;
        this.momentoSolicitacao = Instant.now();
    }

    /**
     * Define o status desse recurso como RELEASED, não sendo mais de interesse
     * do processo atual.
     */
    public void liberar(){
        this.estadoSolicitacao = ProcessResourceState.RELEASED;
        this.momentoSolicitacao = Instant.MAX;
    }

    /**
     * Define o status desse recurso como HELD, indicando que este recurso está
     * sob posse do processo atual.
     */
    public void alocado(){
        this.estadoSolicitacao = ProcessResourceState.HELD;
    }

    /**
     * Verifica se o processo atual tem prioridade de uso do atual recurso,
     * assim que este for liberado.
     * 
     * @param process
     * @return 
     */
    public boolean souOProximo(processos.Process process){
        if(this.estadoSolicitacao.equals(ProcessResourceState.WANTED)){
            if(this.processosSolicitantes.isEmpty()){
                return true;
            }

            long localTime = this.momentoSolicitacao.getEpochSecond();
            long nextTime = this.processosSolicitantes.get(0).getLong("request_time");
            long nextId = this.processosSolicitantes.get(0).getLong("id");

            if(localTime < nextTime){
                return true;
            } else if(localTime == nextTime && process.getId() < nextId){
                return true;
            }
        }

        return false;
    }
    
    /**
     * Converte um List para JSONArray, sendo possível transmitir seu conteúdo
     * através de um Datagram.
     * @return 
     */
    public JSONArray waitingListToString(){
        return new JSONArray(this.processosSolicitantes);
    }
    
    /**
     * Inicializa a lista de espera de processos solicitantes com a lista recebida.
     * Útil para manter a consitencia da fila de espera entre os processos do
     * grupo multicast.
     * 
     * @param array 
     */
    public void carregarWaitingList(JSONArray array){
        this.processosSolicitantes.clear();
        for(int indice = 0; indice < array.length(); indice++){
            this.processosSolicitantes.add(array.getJSONObject(indice));
        }
    }

    public void incrementReceivedMessagesOK(){
        receivedMessagesOk++;
    }

    public int getReceivedMessages(){
        return receivedMessagesOk;
    }

    public void clearReceivedMessagesOK(){
       receivedMessagesOk = 0;
    }

    public void incrementReceivedMessagesDenial(){
        receivedMessagesDenial++;
    }

    public void clearReceivedMessagesDenial(){
        receivedMessagesDenial = 0;
    }
}
