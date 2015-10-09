package org.revo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

/**
 * Created by revo on 08/10/15.
 */
@Theme("valo")
@SpringUI(path = "me")
public class me extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout main = new VerticalLayout();
        Label selection = new Label("");
        selection.setVisible(false);
        main.addComponent(selection);
        MenuBar.Command mycommand = selectedItem -> {
            selection.setVisible(true);
            selection.setValue("Ordered a " +
                    selectedItem.getText() +
                    " from menu.");
        };
        MenuBar barmenu = new MenuBar();
        MenuBar.MenuItem drinks = barmenu.addItem("Beverages", null, null);
        MenuBar.MenuItem hots = drinks.addItem("Hot", null, null);
        hots.addItem("Tea",
                new ThemeResource("icons/tea-16px.png"), mycommand);
        hots.addItem("Coffee",
                new ThemeResource("icons/coffee-16px.png"), mycommand);
        MenuBar.MenuItem colds = drinks.addItem("Cold", null, null);
        colds.addItem("Milk", null, mycommand);
        colds.addItem("Weissbier", null, mycommand);
        MenuBar.MenuItem snacks = barmenu.addItem("Snacks", null, null);
        snacks.addItem("Weisswurst", null, mycommand);
        snacks.addItem("Bratwurst", null, mycommand);
        snacks.addItem("Currywurst", null, mycommand);
        MenuBar.MenuItem servs = barmenu.addItem("Services", null, null);
        servs.addItem("Car Service", null, mycommand);
        main.addComponent(barmenu);
        setContent(main);
    }
}
