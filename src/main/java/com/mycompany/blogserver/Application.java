package com.mycompany.blogserver;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author ekcdr
 */
public class Application extends ResourceConfig {

    public Application() {
        LoggerLib.Logger.print("application");
        register(new ApplicationBinder());
        packages(true, "com.mycompany.blogserver");
    }
}
