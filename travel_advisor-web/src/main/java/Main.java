import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by myPc on 19/09/2016.
 */
public class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {

        String webappDirLocation = "travel_advisor-web/src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        String webPort=System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort="8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));
        tomcat.addWebapp("/traveladvisor",new File(webappDirLocation).getAbsolutePath());
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }

}
