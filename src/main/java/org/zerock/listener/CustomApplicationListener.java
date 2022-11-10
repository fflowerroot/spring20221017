package org.zerock.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class CustomApplicationListener
 *
 */

public class CustomApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CustomApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext application = sce.getServletContext();
        application.setAttribute("imgUrl", "https://study-20220802-20221110.s3.ap-northeast-2.amazonaws.com/prj1/board");
    	
    }
	
}
//error: The following untracked working tree files would be overwritten by merge:
//src/main/java/org/zerock/service/board/ReplyService.java
//Please move or remove them before you merge.
//Aborting
