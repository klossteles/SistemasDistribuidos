package hospedagem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Brendon & Lucas
 */
public class Hospedagem {
    //Lista de Atributos de uma Hospedagem
    //id Hospedagem
    //Destino (Nome Cidade ou Hotel)
    //Data Entrada
    //Data Saída
    //Número Quartos
    //Número Pessoas
    //Preço

    ConcurrentHashMap<Long, JSONObject> hospedagens;

    public Hospedagem(){
        this.hospedagens = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, JSONObject> getHospedagens(){
        return hospedagens;
    }

    public JSONArray consultarHospedagem(){
    	JSONArray listaHospedagens = new JSONArray();
        
        for (Map.Entry<Long, JSONObject> entry : this.getHospedagens().entrySet()) {
            JSONObject jsonObject = entry.getValue();
            jsonObject.put("id", entry.getKey());
            listaHospedagens.put(jsonObject);
        }
        
        return listaHospedagens;
    }

    public JSONObject cadastrarNovaHospedagem(String destino, String entrada, String saida, int num_pessoas, double preco, int num_quartos) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    	LocalDateTime data_entrada = LocalDateTime.parse(entrada, format);
        LocalDateTime data_saida = LocalDateTime.parse(saida, format);
        if (data_entrada.isAfter(data_saida)) {
            System.out.println("Data de entrada não pode ser posterior a data de saída.");
            return null;
        }

        JSONObject jo = new JSONObject();
        jo.put("DESTINO", destino);
        jo.put("DATA_ENTRADA", data_entrada);
        jo.put("DATA_SAIDA", data_saida);
        jo.put("NUM_PESSOAS", num_pessoas);
        jo.put("PRECO", preco);
        jo.put("NUM_QUARTOS", num_quartos);
        Long id = System.currentTimeMillis() + System.nanoTime();
        this.hospedagens.put(id, jo);
        return jo;
    }

    public boolean comprarHospedagem (Long identificador) {
        if (!this.getHospedagens().containsKey(identificador)) {
            return false;
        }
        JSONObject hospedagem = this.getHospedagens().get(identificador);
        int num_quartos = hospedagem.getInt("NUM_QUARTOS");
        num_quartos -= 1;
        if (num_quartos <= 0) {
            this.getHospedagens().remove(identificador);
        } else {
            hospedagem.put("NUM_QUARTOS", num_quartos);
            this.getHospedagens().put(identificador, hospedagem);
        }
        return true;
    }

    public boolean addHospedagem (Long id) {
        if (!this.getHospedagens().containsKey(id)) {
            return false;
        }
        JSONObject hospedagem = this.getHospedagens().get(id);
        int num_quartos = hospedagem.getInt("NUM_QUARTOS");
        num_quartos += 1;
        hospedagem.put("NUM_QUARTOS", num_quartos);
        this.getHospedagens().put(id, hospedagem);
        return true;
    }
}
