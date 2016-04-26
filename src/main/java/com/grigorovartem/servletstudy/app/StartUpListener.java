package com.grigorovartem.servletstudy.app;

import com.grigorovartem.servletstudy.export.dvach.Exporter;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartUpListener implements ServletContextListener
{
   private Thread DvachExporterThread;

   @Override
   public void contextDestroyed(ServletContextEvent arg0)
   {
      System.out.println("ServletContextListener destroyed");
      if (DvachExporterThread != null)
      {
         DvachExporterThread.interrupt();
      }
   }

   @Override
   public void contextInitialized(ServletContextEvent arg0)
   {
      System.out.println("StartUpListener started.");
      DvachExporterThread = new Thread(new Exporter());
      DvachExporterThread.start();
   }

   /*public static void main(String[] args) {
      ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
      System.out.println(ac.getBean("webmDao"));

   }*/

}
