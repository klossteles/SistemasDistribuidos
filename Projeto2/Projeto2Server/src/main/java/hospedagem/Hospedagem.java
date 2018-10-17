package hospedagem;

import java.time.Instant;
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

    ConcurrentHashMap<String, JSONArray> hospedagens;
    private static final Logger LOG = Logger.getLogger(Hospedagem.class.getName());

    public Hospedagem(){
        this.hospedagens = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, JSONArray> getHospedagens(){
        return hospedagens;
    }

    public JSONArray consultarHospedagemPorDestino(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Qual destino? ");

        for(Map.Entry<String, JSONArray> entry : hospedagens.entrySet()){
            System.out.print("    - " + entry.getKey() + "\n");
        }
        System.out.println("Digite 'sair' para sair");
        String destino = scan.nextLine();

        if(destino.equalsIgnoreCase("sair")){
            return null;
        }
        if(!hospedagens.containsKey(destino)){
            LOG.log(Level.INFO, "Não existem hospedagens com esse destino cadastradas.");
            return null;
        }

        System.out.println(hospedagens.get(destino).toString(4));
        return hospedagens.get(destino);
    }

    public boolean cadastrarNovaHospedagem(String destino, String dataEntrada, String dataSaida, int numeroQuartos, int numeroPessoas, double preco){
        if(destino == null || destino.isEmpty()){
            System.out.println("É necessário informar o NOME/CIDADE da Hospedagem.");
            return false;
        }

        if(dataSaida == null || dataEntrada == null || dataSaida.isEmpty() || dataEntrada.isEmpty()){
            System.out.println("As datas de Entrada e Saída não estão no formato esperado.");
            return false;
        }

        if(numeroPessoas < 0 || preco < 0){
            System.out.println("O número de Pessoas e o Preço da Hospedagem não podem ser negativos.");
            return false;
        }

        JSONObject hospedagem = new JSONObject();
        hospedagem.put("ID", Instant.now().getNano());
        hospedagem.put("NOME", destino);
        hospedagem.put("DATA_ENTRADA", dataEntrada);
        hospedagem.put("DATA_SAIDA", dataSaida);
        hospedagem.put("NUMERO_QUARTOS", numeroQuartos);
        hospedagem.put("NUMERO_PESSOAS", numeroPessoas);
        hospedagem.put("PRECO", preco);

        JSONArray jsonArray;
        if(this.hospedagens.containsKey(destino)){
            jsonArray = this.hospedagens.get(destino);
        } else{
            jsonArray = new JSONArray();
        }
        jsonArray.put(hospedagem);
        this.hospedagens.put(destino, jsonArray);
        return true;
    }

}
