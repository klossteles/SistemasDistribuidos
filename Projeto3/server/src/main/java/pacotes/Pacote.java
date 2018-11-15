package pacotes;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import PassagemAerea.PassagemAerea;
import hospedagem.Hospedagem;

/**
 *
 * @author Brendon & Lucas
 */
public class Pacote {

    ConcurrentHashMap<Long, JSONObject> pacotes;
    PassagemAerea passagens;
    Hospedagem hospedagens;

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

    /**
     * Consulta os pacotes cadastrados. Se não houver pacotes um JSONArray vazio é retornado.
     * @return
     */
    public JSONArray consultarPacotes(){
        JSONArray listaPacotes = new JSONArray();
        for (Map.Entry<Long, JSONObject> entry : this.getPacotes().entrySet()) {
            JSONObject jsonObject = entry.getValue();
            jsonObject.put("id", entry.getKey());
            listaPacotes.put(jsonObject);            
        }
        return listaPacotes;
    }


    /**
     * Cria um novo pacote, considerando os identificadores de passagem e hospedagem.
     * O destino do pacote é definido como o destino da Passagem.
     * O valor do pacote é a soma dos valores da passagem e da hospedagem.
     *
     * @param id_hospedagem
     * @param id_passagem
     * @param hospedagens
     * @param passagens
     * @return 
     */
    public JSONObject cadastrarNovoPacote(Long id_hospedagem, Long id_passagem, ConcurrentHashMap<Long, JSONObject> hospedagens, ConcurrentHashMap<Long, JSONObject> passagens) {
        if (!hospedagens.containsKey(id_hospedagem)) {
            System.out.println("Identificador da hospedagem inválido.");
            return null;
        }
        if (!passagens.containsKey(id_passagem)) {
            System.out.println("Identificador da passagem inválido.");
            return null;
        }
        
        String destino = passagens.get(id_passagem).getString("DESTINO");
        double precoTotal = passagens.get(id_passagem).getDouble("PRECO") +
                            hospedagens.get(id_hospedagem).getDouble("PRECO");
        
        JSONObject jo = new JSONObject();
        jo.put("ID_HOSPEDAGEM", id_hospedagem);
        jo.put("ID_PASSAGEM", id_passagem);
        jo.put("DESTINO", destino);
        jo.put("PRECO", precoTotal);
                
        Long id = System.currentTimeMillis() + System.nanoTime();
        this.getPacotes().put(id, jo);
        return jo;
    }

    /**
     * Método responsável pela compra de pacotes
     * Na compra é removida uma pacotes, quando o número de pacotes chega a 
     * zero, o pacotes é removida do HashMap
     * 
     * @param id
     * @return 
     */
    public boolean comprarPacote(Long id) {
        JSONObject pacote = this.getPacotes().get(id);
        Long id_passagem = pacote.getLong("ID_PASSAGEM");
        Long id_hospedagem = pacote.getLong("ID_HOSPEDAGEM");

        PassagemAerea passagem = this.getPassagens();
        Hospedagem hospedagem = this.getHospedagens();
        boolean comprou_passagem = passagem.comprarPassagem(id_passagem);
        boolean comprou_hospedagem = hospedagem.comprarHospedagem(id_hospedagem);
        if (comprou_passagem && !comprou_hospedagem) {
            passagem.addPassagem(id_passagem);
            return false;
        }
        if (!comprou_passagem && comprou_hospedagem) {
            hospedagem.addHospedagem(id_hospedagem);
            return false;
        }
        return true;
    }
}
