package restResources;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


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
