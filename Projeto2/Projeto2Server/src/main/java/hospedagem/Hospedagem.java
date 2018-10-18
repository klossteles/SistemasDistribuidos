package hospedagem;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
    private static final Logger LOG = Logger.getLogger(Hospedagem.class.getName());

    public Hospedagem(){
        this.hospedagens = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, JSONObject> getHospedagens(){
        return hospedagens;
    }

    public String consultarHospedagem(){
        StringBuilder passagens = new StringBuilder();
        for (Map.Entry<Long, JSONObject> entry : this.getHospedagens().entrySet()) {
            JSONObject jsonObject = entry.getValue();
            passagens.append("\n");
            passagens.append("Identificador: ").append(entry.getKey());
            passagens.append("\nData de entrada: ").append(jsonObject.get("DATA_ENTRADA"));
            passagens.append("\nData de saída: ").append(jsonObject.get("DATA_SAIDA"));
            passagens.append("\nNum. pessoas: ").append(jsonObject.getInt("NUM_PESSOAS"));
            passagens.append("\nNum. quartos: ").append(jsonObject.getInt("NUM_QUARTOS"));
            passagens.append("\nPreço: ").append(jsonObject.getLong("PRECO"));
            passagens.append("\n");
            passagens.append("\n");
        }
        return  passagens.toString();
    }

    public void cadastrarNovaHospedagem(String nome, String entrada, String saida, int num_pessoas, double preco, int num_quartos) {
        String[] aux_entrada = entrada.split("/");
        String[] aux_saida = saida.split("/");
        if (aux_entrada.length < 3) {
            System.out.println("Data de entrada inválida.");
            return ;
        }
        if (aux_saida.length < 3) {
            System.out.println("Data de saída inválida.");
            return ;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(aux_entrada[2]), Integer.parseInt(aux_entrada[1]), Integer.parseInt(aux_entrada[0]));
        Date data_entrada = cal.getTime();
        cal.set(Integer.parseInt(aux_saida[2]), Integer.parseInt(aux_saida[1]), Integer.parseInt(aux_saida[0]));
        Date data_saida = cal.getTime();
        if (data_entrada.after(data_saida)) {
            System.out.println("Data de entrada não pode ser posterior a data de saída.");
            return;
        }

        JSONObject jo = new JSONObject();
        jo.put("NOME", nome);
        jo.put("DATA_ENTRADA", data_entrada);
        jo.put("DATA_SAIDA", data_saida);
        jo.put("NUM_PESSOAS", num_pessoas);
        jo.put("PRECO", preco);
        jo.put("NUM_QUARTOS", num_quartos);
        Long id = System.currentTimeMillis() + System.nanoTime();
        this.hospedagens.put(id, jo);
    }

}
