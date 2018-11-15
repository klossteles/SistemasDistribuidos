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

/**
 * Classe que implementa os recursos da aplicação (URIs, Endpoints).
 * 
 * @author Brendon
 *
 */
@Path("agencia")
public class Resources {

	@Context
	HttpServletRequest request;

	/**
	 * URI para teste da aplicação.
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String teste() {
		return "Rota OK";
	}
	
	/**
	 * URI para consulta das passagens cadastradas na aplicação.
	 * @return
	 */
	@GET
	@Path("consultar_passagens")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPassagens() {
		Server server = (Server) request.getAttribute("server");
		return Response.status(Status.OK).entity(server.getPassagens().consultarPassagens().toString()).build();
	}
	
	/**
	 * URI para consulta das hospedagens cadastradas na aplicação.
	 * @return
	 */
	@GET
	@Path("consultar_hospedagens")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarHospedagens() {
		Server server = (Server) request.getAttribute("server");
		return Response.status(Status.OK).entity(server.getHospedagens().consultarHospedagem().toString()).build();
	}
	
	/**
	 * URI para consulta dos pacotes cadastradas na aplicação.
	 * @return
	 */
	@GET
	@Path("consultar_pacotes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPacotes() {
		Server server = (Server) request.getAttribute("server");
		return Response.status(Status.OK).entity(server.getPacotes().consultarPacotes().toString()).build();
	}
	
	/**
	 * URI para cadastro de uma nova passagem. O parâmetro 'data_volta' é opcional.
	 * 
	 * @param destino
	 * @param origem
	 * @param ida
	 * @param volta
	 * @param dataIda
	 * @param dataVolta
	 * @param numeroPessoas
	 * @param preco
	 * @return
	 */
	@POST
	@Path("cadastrar_passagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarPassagem(@NotNull @FormParam("destino")   	    String destino, 
									  @NotNull @FormParam("origem")  	    String origem,
									  @NotNull @FormParam("ida")	   	   	String ida,
									  @NotNull @FormParam("volta")   	    String volta,
									  @NotNull @FormParam("data_ida")	    String dataIda,
									  @DefaultValue("") @FormParam("data_volta") 	String dataVolta,
									  @NotNull @FormParam("numero_pessoas") String numeroPessoas,
									  @NotNull @FormParam("preco") 	   	    String preco) {
		
		Server server = (Server) request.getAttribute("server");
		JSONObject resposta = server.getPassagens().cadastrarNovaPassagem(destino, origem, Integer.parseInt(ida), Integer.parseInt(volta), dataIda, dataVolta, Integer.parseInt(numeroPessoas), Double.parseDouble(preco));
		return resposta == null ? getError("Falha ao Cadastrar Passagem") : getSucess("Passagem Cadastrada.");
	}
	
	/**
	 * URI para a compra de uma nova passagem.
	 * 
	 * @param id - Identificador da passagem a ser comprada.
	 * @return
	 */
	@POST
	@Path("comprar_passagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response comprarPassagem(@NotNull @FormParam("id_passagem") Long id) {
		Server server = (Server) request.getAttribute("server");
		
		boolean resposta = server.getPassagens().comprarPassagem(id);
		return resposta ? getSucess("Passagem Comprada.") : getError("Falha ao Comprar Passagem.");
	}
	
	/**
	 * URI para cadastro de uma nova hospedagem. Todos os parâmetros são obrigatórios.
	 * 
	 * @param destino
	 * @param dataEntrada
	 * @param dataSaida
	 * @param numeroPessoas
	 * @param numeroQuartos
	 * @param preco
	 * @return
	 */
	@POST
	@Path("cadastrar_hospedagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarHospedagem(@NotNull @FormParam("destino")   	  String destino, 
									    @NotNull @FormParam("data_entrada")   String dataEntrada,
									    @NotNull @FormParam("data_saida")	  String dataSaida,
									    @NotNull @FormParam("numero_pessoas") String numeroPessoas,
									    @NotNull @FormParam("numero_quartos") String numeroQuartos,
									    @NotNull @FormParam("preco") 	   	  String preco) {
		
		Server server = (Server) request.getAttribute("server");
		JSONObject resposta = server.getHospedagens().cadastrarNovaHospedagem(destino, dataEntrada, dataSaida, Integer.parseInt(numeroPessoas), Double.parseDouble(preco), Integer.parseInt(numeroQuartos));
		return resposta == null ? getError("Falha ao Cadastrar Passagem") : getSucess("Passagem Cadastrada.");
	}

	/**
	 * URI para a compra de uma nova hospedagem.
	 * 
	 * @param id - Identificador da hospedagem a ser comprada.
	 * @return
	 */
	@POST
	@Path("comprar_hospedagem")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response comprarHospedagem(@NotNull @FormParam("id_hospedagem") Long id) {
		Server server = (Server) request.getAttribute("server");
		
		boolean resposta = server.getHospedagens().comprarHospedagem(id);
		return resposta ? getSucess("Hospedagem Comprada.") : getError("Falha ao Comprar Hospedagem.");
	}
	
	/**
	 * URI para cadastro de um novo pacote. Todos os parâmetros são obrigatórios.
	 * 
	 * @param idHospedagem
	 * @param idPassagem
	 * @return
	 */
	@POST
	@Path("cadastrar_pacote")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarHospedagem(@NotNull @FormParam("id_hospedagem") String idHospedagem, 
									    @NotNull @FormParam("id_passagem")   String idPassagem) {
		
		Server server = (Server) request.getAttribute("server");
		ConcurrentHashMap<Long, JSONObject> passagens = server.getPassagens().getPassagensAereas();
		ConcurrentHashMap<Long, JSONObject> hospedagens = server.getHospedagens().getHospedagens();
		JSONObject resposta = server.getPacotes().cadastrarNovoPacote(Long.parseLong(idHospedagem), Long.parseLong(idPassagem), hospedagens, passagens);
		return resposta == null ?  getError("Falha ao Cadastrar Pacote.") : getSucess("Pacote Cadastrado.");
	}

	/**
	 * URI para a compra de um novo pacote.
	 * 
	 * @param id - Identificador do pacote a ser comprado.
	 * @return
	 */
	@POST
	@Path("comprar_pacote")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public Response comprarPacote(@NotNull @FormParam("id_pacote") Long id) {
		Server server = (Server) request.getAttribute("server");
		
		boolean resposta = server.getPacotes().comprarPacote(id);
		return resposta ? getSucess("Passagem Comprada.") : getError("Falha ao Comprar Passagem.");
	}
	
	/**
	 * Método que constrói um objeto 'Response' com status OK (HTTP 200) e com a mensagem
	 * recebida por parâmetro.
	 * 
	 * @param mensagem
	 * @return
	 */
	private Response getSucess(String mensagem) {
		return Response.status(Status.OK).entity(mensagem).build();
	}
	
	/**
	 * Método que constrói um objeto 'Response' com status BAD_REQUEST (HTTP 400) e com a mensagem
	 * recebida por parâmetro.
	 * 
	 * @param mensagem
	 * @return
	 */
	private Response getError(String mensagem) {
		return Response.status(Status.BAD_REQUEST).entity(mensagem).build();
	}
}
