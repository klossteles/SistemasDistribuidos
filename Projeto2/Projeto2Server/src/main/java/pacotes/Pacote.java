/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacotes;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import PassagemAerea.PassagemAerea;
import hospedagem.Hospedagem;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Brendon & Lucas
 */
public class Pacote {

    ConcurrentHashMap<Long, JSONObject> pacotes;
    PassagemAerea passagens;
    Hospedagem hospedagens;
    private static final Logger LOG = Logger.getLogger(Process.class.getName());

    public Pacote(PassagemAerea passagens, Hospedagem hospedagens) {
        this.pacotes = new ConcurrentHashMap<>();
        this.passagens = passagens;
        this.hospedagens = hospedagens;
    }

    public ConcurrentHashMap<Long, JSONObject> getPacotes() {
        return pacotes;
    }

    public PassagemAerea getPassagens() {
        return passagens;
    }

    public Hospedagem getHospedagens() {
        return hospedagens;
    }

    public String consultarPacotes(){
        StringBuilder passagens = new StringBuilder();
        for (Map.Entry<Long, JSONObject> entry : this.getPacotes().entrySet()) {
            JSONObject jsonObject = entry.getValue();

            passagens.append("\n");
            passagens.append("Identificador do pacote: ").append(entry.getKey());
            passagens.append("\nIdentificador da hospedagem: ").append(jsonObject.getLong("ID_HOSPEDAGEM"));
            passagens.append("\nIdentificador da passagem: ").append(jsonObject.getLong("ID_PASSAGEM"));
            passagens.append("\n");
            passagens.append("\n");
        }
        return  passagens.toString();
    }


    /**
     * Cria um novo pacote, utilizando o destino da passagem como KEY.
     *
     * @param id_hospedagem
     * @param id_passagem
     * @param hospedagens
     * @param passagens
     */
    public void cadastrarNovoPacote(Long id_hospedagem, Long id_passagem, ConcurrentHashMap<Long, JSONObject> hospedagens, ConcurrentHashMap<Long, JSONObject> passagens) {
        if (!hospedagens.containsKey(id_hospedagem)) {
            System.out.println("Identificador da hospedagem inválido.");
            return;
        }
        if (!passagens.containsKey(id_passagem)) {
            System.out.println("Identificador da passagem inválido.");
            return;
        }
        JSONObject jo = new JSONObject();
        jo.put("ID_HOSPEDAGEM", id_hospedagem);
        jo.put("ID_PASSAGEM", id_passagem);
        Long id = System.currentTimeMillis() + System.nanoTime();
        this.getPacotes().put(id, jo);
    }

    public boolean comprarPacote(Long id) {
        JSONObject pacote = this.getPacotes().get(id);
        Long id_passagem = pacote.getLong("ID_PASSAGEM");
        Long id_hospedagem = pacote.getLong("ID_HOSPEDAGEM");

        PassagemAerea passagens = this.getPassagens();
        Hospedagem hospedagem = this.getHospedagens();
        boolean comprou_passagem = passagens.comprarPassagem(id_passagem);
        boolean comprou_hospedagem = hospedagem.comprarHospedagem(id_hospedagem);
        if (comprou_passagem && !comprou_hospedagem) {
            passagens.addPassagem(id_passagem);
            return false;
        }
        if (!comprou_passagem && comprou_hospedagem) {
            hospedagem.addHospedagem(id_hospedagem);
            return false;
        }
        return true;
    }
}
