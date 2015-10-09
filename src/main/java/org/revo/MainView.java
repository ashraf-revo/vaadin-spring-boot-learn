package org.revo;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class MainView extends HorizontalLayout {

    public MainView() {
        setSizeFull();
        addStyleName("mainview");
        addComponent(new DashboardMenu());
        ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        content.addComponent(new Label("gfhgf"));
        addComponent(content);
    }
}