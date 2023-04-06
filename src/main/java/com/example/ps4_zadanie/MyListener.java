package com.example.ps4_zadanie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class MyListener implements HttpSessionListener, HttpSessionAttributeListener {

    public MyListener() {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("MyListener sessionCreated(): Session is created.");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("MyListener sessionDestroyed(): Session is destroyed.");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        System.out.println("MyListener attributeAdded(): Attribute is added to a session.");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
        System.out.println("MyListener attributeRemoved(): Attribute is removed from a session.");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
        System.out.println("MyListener attributeReplaced(): Attribute is replaced in a session.");
    }
}
