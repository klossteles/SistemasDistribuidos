package restResources;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Classe que implementa um filtro de requisições e é responsável por inserir
 * em cada requisição o objeto Server, que gerência os dados referentes a
 * passagens, hospedagens e pacotes.
 *  
 * @author Brendon
 */
@WebFilter("/*")
public class FiltroRequisicoes implements Filter{

	private static final Logger LOG = Logger.getLogger(FiltroRequisicoes.class.getName());
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext context = request.getServletContext();
		Server server = (Server) context.getAttribute("server");
		
		LOG.info("Inserir Objeto Server na RequisiÃ§Ã£o");
		request.setAttribute("server", server);

		chain.doFilter(request, response);
		LOG.info("Finalizar Filtro");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

}
