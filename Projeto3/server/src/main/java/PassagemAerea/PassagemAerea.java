package PassagemAerea;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class PassagemAerea {
    ConcurrentHashMap<Long, JSONObject> passagensAereas = new ConcurrentHashMap<>();

    public PassagemAerea() {
        this.passagensAereas = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<Long, JSONObject> getPassagensAereas(){
        return passagensAereas;
    }

    public JSONArray consultarPassagens(){
        JSONArray listaPassagens = new JSONArray();
        for (Map.Entry<Long, JSONObject> entry : this.getPassagensAereas().entrySet()) {
            JSONObject jsonObject = entry.getValue();
            jsonObject.put("id", entry.getKey());
            listaPassagens.put(jsonObject);
        }
        return listaPassagens;
    }

    public JSONObject cadastrarNovaPassagem(String destino, String origem, int ida, int volta, String str_ida, String str_volta, int num_pessoas, double preco) {
        if (ida == 1 && (str_ida == null || str_ida.equalsIgnoreCase(""))){
            System.out.println("É necessário informar a data da passagem de ida.");
            return null;
        }
        if (volta == 1 && (str_volta == null || str_volta.isEmpty())){
            System.out.println("É necessário informar a data da passagem de volta.");
            return null;
        }

        String[] aux_ida = str_ida.split("/");
        String[] aux_volta = str_volta.split("/");
        if (ida == 1 && aux_ida.length < 3) {
            System.out.println("Data de ida inválida.");
            return null;
        }
        if (volta == 1 && aux_volta.length < 3) {
            System.out.println("Data de volta inválida.");
            return null;
        }

        Calendar cal = Calendar.getInstance();
        
        Date data_ida = null;
        if(ida == 1){
            cal.set(Integer.parseInt(aux_ida[2]), Integer.parseInt(aux_ida[1]), Integer.parseInt(aux_ida[0]));
            data_ida = cal.getTime();
        }
        
        Date data_volta = null;
        if(volta == 1){
            cal.set(Integer.parseInt(aux_volta[2]), Integer.parseInt(aux_volta[1]), Integer.parseInt(aux_volta[0]));
            data_volta = cal.getTime();
        }
        
        if (data_ida != null && data_volta != null && data_ida.after(data_volta)) {
            System.out.println("Data de entrada não pode ser posterior a data de saída.");
            return null;
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
        return jo;
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
