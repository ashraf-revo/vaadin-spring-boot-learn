package org.revo.ui;

import com.google.gwt.thirdparty.guava.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.NavigationStateManager;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import org.revo.DashboardMenu;
import org.revo.MainView;
import org.revo.User;

import java.util.Locale;

/**
 * Created by revo on 08/10/15.
 */
@SpringUI(path = "you")
@Theme("cool")
@Title("you")
public class you extends UI {


    @Override
    protected void init(final VaadinRequest request) {
        Responsive.makeResponsive(this);
        updateContent();
        Page.getCurrent().addBrowserWindowResizeListener(
                event -> {
                });
    }

    private void updateContent() {
        User user = new User();
        if (user != null && "admin".equals(user.getRole())) {
            setContent(new MainView());
            removeStyleName("loginview");
        } else {
//            setContent(new LoginView());
            addStyleName("loginview");
        }
    }
}
