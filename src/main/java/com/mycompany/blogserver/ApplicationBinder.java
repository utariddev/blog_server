package com.mycompany.blogserver;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 *
 * @author ekcdr
 */
public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(Engine.class).to(Engine.class);
        bind(DatabaseManager.class).to(DatabaseManager.class);
    }
}
