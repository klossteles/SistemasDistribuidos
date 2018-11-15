package restResources;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Classe que instância um objeto Server, responsável por gerenciar a camada
 * de negócios da aplicação.
 * Essa classe garante que o objeto Server é criado apenas uma vez, fazendo
 * com que todas as threads da aplicação "enxergem" os mesmos dados.
 * 
 * @author Brendon
 */
@WebListener
public class InicializarRecursos implements ServletContextListener{

	private static final Logger LOG = Logger.getLogger(InicializarRecursos.class.getName());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("Criar Objeto Server");
		Server server = new Server();
		
		LOG.info("Inserir Objeto Server no Contexto");
		ServletContext context = sce.getServletContext();
		context.setAttribute("server", server);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("Encerrar Contexto");
	}

}
