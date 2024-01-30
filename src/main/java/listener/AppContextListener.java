package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import model.Model;

/**
 * Application context including application model
 * @author Krystian Gagracz
 * @version 1.0.0
 */
@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent context) {
        ServletContext appContext = context.getServletContext();
        Model model = new Model();
        appContext.setAttribute("model", model);
    }
}
