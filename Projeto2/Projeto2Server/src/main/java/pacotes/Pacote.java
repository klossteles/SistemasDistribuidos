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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Brendon & Lucas
 */
public class Pacote {

    ConcurrentHashMap<String, JSONArray> pacotes;
    private static final Logger LOG = Logger.getLogger(Pacote.class.getName());

    public Pacote(){
        this.pacotes = new ConcurrentHashMap<>();
    }

    public JSONArray consultarPacotesPorDestino(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual destino? ");

        for(Map.Entry<String, JSONArray> entry : pacotes.entrySet()){
            System.out.print("    - " + entry.getKey() + "\n");
        }
        System.out.println("Digite 'sair' para sair");
        String destino = scan.nextLine();

        if(destino.equalsIgnoreCase("sair")){
            return null;
        }
        if(!pacotes.containsKey(destino)){
            LOG.log(Level.INFO, "Não existem pacotes cadastradas para esse destino.");
            return null;
        }

        JSONArray pacotesEncontrados = pacotes.get(destino);
        System.out.println(pacotesEncontrados.toString(4));
        return pacotesEncontrados;
    }

    /**
     * Cria um novo pacote, utilizando o destino da passagem como KEY.
     * 
     * @param passagem
     * @param hospedagem
     * @return 
     */
    public boolean cadastrarNovoPacote(JSONObject passagem, JSONObject hospedagem){
        String passagemDestino = passagem.getString("DESTINO");
        
        JSONObject pacote = new JSONObject();
        pacote.put("passagem", passagem);
        pacote.put("hospedagem", hospedagem);
        
        if(this.pacotes.containsKey(passagemDestino)){
            this.pacotes.get(passagemDestino).put(pacote);
        }else{
            JSONArray array = new JSONArray();
            array.put(pacote);
            
            this.pacotes.put(passagemDestino, array);
        }
        return true;
    }
    
}
