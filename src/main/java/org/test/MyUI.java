package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.HtmlImport;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.elements.ElementIntegration;
import org.vaadin.elements.Root;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@JavaScript("vaadin://bower_components/webcomponentsjs/webcomponents-lite.js")
@HtmlImport("vaadin://bower_components/game-card/game-card.html")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Layout layout = Layout.horizontal();
        layout.appendChild(GameCard.create("♠", "3"));
        CssLayout wrapper = new CssLayout();
        Root root = ElementIntegration.getRoot(wrapper);
        root.appendChild(layout);
        setContent(wrapper);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
