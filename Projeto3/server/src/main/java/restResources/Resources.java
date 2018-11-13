package restResources;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

@Path("agencia")
public class Resources {

	@Context
	HttpServletRequest request;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String teste() {
		return "Rota OK";
	}
	
	@GET
	@Path("consultar_passagens")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarPassagens() {
		Server server = (Server) request.getAttribute("server");
		return server.getPassagens().consultarPassagens().toString();
	}
	
	@GET
	@Path("consultar_hospedagens")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarHospedagens() {
		Server server = (Server) request.getAttribute("server");
		return server.getHospedagens().consultarHospedagem().toString();
	}
	
	@GET
	@Path("consultar_pacotes")
	@Produces(MediaType.APPLICATION_JSON)
	public String consultarPacotes() {
		Server server = (Server) request.getAttribute("server");
		return server.getPacotes().consultarPacotes().toString();
	}
	
	@POST
	@Path("cadastrar_passagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarPassagem(@NotNull @FormParam("destino")   	    String destino, 
									  @NotNull @FormParam("origem")  	    String origem,
									  @NotNull @FormParam("ida")	   	   	int ida,
									  @NotNull @FormParam("volta")   	    int volta,
									  @NotNull @FormParam("data_ida")	    String dataIda,
									  @DefaultValue("") @FormParam("data_volta") 	String dataVolta,
									  @NotNull @FormParam("numero_pessoas") int numeroPessoas,
									  @NotNull @FormParam("preco") 	   	    double preco) {
		
		Server server = (Server) request.getAttribute("server");
		JSONObject resposta = server.getPassagens().cadastrarNovaPassagem(destino, origem, ida, volta, dataIda, dataVolta, numeroPessoas, preco);
		return resposta == null ? Response.status(Status.BAD_REQUEST).build() : Response.status(Status.CREATED).build();
	}
	
	@POST
	@Path("cadastrar_hospedagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarHospedagem(@NotNull @FormParam("destino")   	  String destino, 
									    @NotNull @FormParam("data_entrada")   String dataEntrada,
									    @NotNull @FormParam("data_saida")	  String dataSaida,
									    @NotNull @FormParam("numero_pessoas") int numeroPessoas,
									    @NotNull @FormParam("numero_quartos") int numeroQuartos,
									    @NotNull @FormParam("preco") 	   	  double preco) {
		
		Server server = (Server) request.getAttribute("server");
		JSONObject resposta = server.getHospedagens().cadastrarNovaHospedagem(destino, dataEntrada, dataSaida, numeroPessoas, preco, numeroQuartos);
		return resposta == null ? Response.status(Status.BAD_REQUEST).build() : Response.status(Status.CREATED).build();
	}
	
	@POST
	@Path("cadastrar_pacote")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarHospedagem(@NotNull @FormParam("id_hospedagem") Long idHospedagem, 
									    @NotNull @FormParam("id_passagem")   Long idPassagem) {
		
		Server server = (Server) request.getAttribute("server");
		ConcurrentHashMap<Long, JSONObject> passagens = server.getPassagens().getPassagensAereas();
		ConcurrentHashMap<Long, JSONObject> hospedagens = server.getHospedagens().getHospedagens();
		JSONObject resposta = server.getPacotes().cadastrarNovoPacote(idHospedagem, idPassagem, hospedagens, passagens);
		return resposta == null ? Response.status(Status.BAD_REQUEST).build() : Response.status(Status.CREATED).build();
	}
}
