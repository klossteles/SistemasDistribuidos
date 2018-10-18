package PassagemAerea;

import java.time.Instant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassagemAerea {
    ConcurrentHashMap<Long, JSONObject> passagensAereas = new ConcurrentHashMap<>();
    private static final Logger LOG = Logger.getLogger(PassagemAerea.class.getName());

    public PassagemAerea() {
        this.passagensAereas = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, JSONObject> getPassagensAereas(){
        return passagensAereas;
    }

    public String consultarPassagens(){
        StringBuilder passagens = new StringBuilder();
        for (Map.Entry<Long, JSONObject> entry : this.getPassagensAereas().entrySet()) {
            JSONObject jsonObject = entry.getValue();
            passagens.append("\n");
            passagens.append("Identificador: ").append(entry.getKey());
            passagens.append("\nDestino: ").append(jsonObject.getString("DESTINO"));
            passagens.append("\nOrigem: ").append(jsonObject.getString("ORIGEM"));
            if (jsonObject.has("IDA") && jsonObject.has("DATA_IDA") && jsonObject.getInt("IDA") == 1) {
                passagens.append("\nIda: ").append("Sim");
                passagens.append("\nData ida: ").append(jsonObject.get("DATA_IDA"));
            } else {
                passagens.append("\nIda: ").append("Não");
            }
            if (jsonObject.has("VOLTA") && jsonObject.has("DATA_VOLTA") && jsonObject.getInt("VOLTA") == 1) {
                passagens.append("\nVolta: ").append("Sim");
                passagens.append("\nData volta: ").append(jsonObject.get("DATA_VOLTA"));
            } else {
                passagens.append("\nVolta: ").append("Não");
            }
            passagens.append("\nNum. pessoas: ").append(jsonObject.getInt("NUM_PESSOAS"));
            passagens.append("\nPreço: ").append(jsonObject.getLong("PRECO"));
            passagens.append("\n");
            passagens.append("\n");
        }
        return  passagens.toString();
    }

    public void cadastrarNovaPassagem(String destino, String origem, int ida, int volta, String str_ida, String str_volta, int num_pessoas, double preco) {
        if (ida == 1 && (str_ida == null || str_ida.equalsIgnoreCase(""))){
            System.out.println("É necessário informar a data da passagem de ida.");
            return;
        }
        if (volta == 1 && (str_volta == null || str_volta.equalsIgnoreCase(""))){
            System.out.println("É necessário informar a data da passagem de volta.");
            return;
        }

        String[] aux_ida = str_ida.split("/");
        String[] aux_volta = str_volta.split("/");
        if (aux_ida.length < 3) {
            System.out.println("Data de ida inválida.");
            return ;
        }
        if (aux_volta.length < 3) {
            System.out.println("Data de volta inválida.");
            return ;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(aux_ida[2]), Integer.parseInt(aux_ida[1]), Integer.parseInt(aux_ida[0]));
        Date data_ida = cal.getTime();
        cal.set(Integer.parseInt(aux_volta[2]), Integer.parseInt(aux_volta[1]), Integer.parseInt(aux_volta[0]));
        Date data_volta = cal.getTime();
        if (data_ida.after(data_volta)) {
            System.out.println("Data de entrada não pode ser posterior a data de saída.");
            return;
        }

        JSONObject jo = new JSONObject();
        jo.put("DESTINO", destino);
        jo.put("ORIGEM", origem);
        jo.put("IDA", ida);
        jo.put("VOLTA", volta);
        jo.put("DATA_IDA", data_ida);
        jo.put("DATA_VOLTA", data_volta);
        jo.put("NUM_PESSOAS", num_pessoas);
        jo.put("PRECO", preco);
        Long id = System.currentTimeMillis() + System.nanoTime();
        this.passagensAereas.put(id, jo);
        return;
    }

    public boolean comprarPassagem (Long identificador) {
        if (!this.getPassagensAereas().containsKey(identificador)) {
            return false;
        }
        JSONObject passagem = this.getPassagensAereas().get(identificador);
        int num_pessoas = passagem.getInt("NUM_PESSOAS");
        num_pessoas -= 1;
        if (num_pessoas <= 0) {
            this.getPassagensAereas().remove(identificador);
        } else {
            passagem.put("NUM_PESSOAS",num_pessoas);
            this.getPassagensAereas().put(identificador, passagem);
        }
        return true;
    }

    public boolean addPassagem (Long id) {
        if (!this.getPassagensAereas().containsKey(id)) {
            return false;
        }
        JSONObject passagem = this.getPassagensAereas().get(id);
        int num_pessoas = passagem.getInt("NUM_PESSOAS");
        num_pessoas += 1;
        passagem.put("NUM_PESSOAS",num_pessoas);
        this.getPassagensAereas().put(id, passagem);
        return true;
    }
}
