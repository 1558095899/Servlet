package MyListener;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterShow implements HttpSessionListener,HttpSessionAttributeListener,ServletContextListener{

	private ServletContext s=null;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		Set all=(Set)this.s.getAttribute("online");
		all.remove(se.getSession().getAttribute("name"));
		this.s.setAttribute("online", all);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		Set set=(Set)this.s.getAttribute("online");
		set.add(se.getValue());
		this.s.setAttribute("online", set);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		Set all=(Set)this.s.getAttribute("online");
		all.remove(se.getValue());
		this.s.setAttribute("online", all);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		this.s=sce.getServletContext();
		this.s.setAttribute("online", new TreeSet());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
