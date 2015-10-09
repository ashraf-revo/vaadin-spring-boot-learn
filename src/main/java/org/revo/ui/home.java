package org.revo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by revo on 08/10/15.
 */
@SpringUI(path = "home")
@Theme("cool")
@Title("home")
public class home extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        File baseDir = VaadinService.getCurrent().getBaseDirectory();
        String child = baseDir+"/WEB-INF/classes/VAADIN/themes/cool/layouts/layout.html";
//        child="/media/revo/revo/develope/important/vaddin/learn/src/main/resources/VAADIN/themes/cool/layouts/layout.html";
        File htmlFile = new File(child);
        CustomLayout content = null;

        try {
            content = new CustomLayout(new FileInputStream(htmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        }


        Panel loginPanel = new Panel("Login");
        content.setSizeUndefined();
        loginPanel.setContent(content);
        loginPanel.setSizeUndefined();
        content.addComponent(new TextField(), "username");
        content.addComponent(new TextField(), "password");
        content.addComponent(new Button("Login"), "okbutton");
        setContent(content);
    }
}
