package PassagemAerea;

import java.time.Instant;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassagemAerea {
    ConcurrentHashMap<String, JSONArray> passagensAereas; //HashMap para salvar o destino, json com as outras informações
    private static final Logger LOG = Logger.getLogger(PassagemAerea.class.getName());

    public PassagemAerea() {
        this.passagensAereas = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, JSONArray> getPassagensAereas(){
        return passagensAereas;
    }

    public JSONArray consultarPassagensPorDestino(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual destino? ");

        for (Map.Entry<String, JSONArray> entry : passagensAereas.entrySet()) {
            System.out.print("    - " + entry.getKey() +"\n");
        }
        System.out.println("Digite 'sair' para sair");
        String destino = scan.nextLine();

        if (destino.equalsIgnoreCase("sair")) {
            return null;
        }
        if (!passagensAereas.containsKey(destino)) {
            LOG.log(Level.INFO, "Não existem passagens com esse destino cadastradas.");
            return null;
        }
        
        System.out.println(passagensAereas.get(destino).toString(4));
        return passagensAereas.get(destino);
    }

    public boolean cadastrarNovaPassagem(String destino, String origem, int ida, int volta, String data_ida, String data_volta, int num_pessoas) {
        if (ida == 1 && (data_ida == null || data_ida.equalsIgnoreCase(""))){
            System.out.println("É necessário informar a data da passagem de ida.");
            return false;
        }
        if (volta == 1 && (data_volta == null || data_volta.equalsIgnoreCase(""))){
            System.out.println("É necessário informar a data da passagem de volta.");
            return false;
        }

        JSONObject jo = new JSONObject();
        jo.put("ID", Instant.now().getNano());
        jo.put("DESTINO", destino);
        jo.put("ORIGEM", origem);
        jo.put("IDA", ida);
        jo.put("VOLTA", volta);
        jo.put("DATA_IDA", data_ida);
        jo.put("DATA_VOLTA", data_volta);
        jo.put("NUM_PESSOAS", num_pessoas);
        JSONArray jsonArray;
        if (this.passagensAereas.containsKey(destino)) {
            jsonArray = this.passagensAereas.get(destino);
        } else {
            jsonArray = new JSONArray();
        }
        jsonArray.put(jo);
        passagensAereas.put(destino, jsonArray);
        return true;
    }
}
