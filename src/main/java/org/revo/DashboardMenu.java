package org.revo;

import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by revo on 08/10/15.
 */
public class DashboardMenu extends CustomComponent {

    public static final String ID = "dashboard-menu";

    public DashboardMenu() {
        setPrimaryStyleName("valo-menu");
        setId(ID);
        setSizeUndefined();
        setCompositionRoot(buildContent());
    }

    private Component buildContent() {
        final CssLayout menuContent = new CssLayout();
        menuContent.addStyleName("sidebar");
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName("no-vertical-drag-hints");
        menuContent.addStyleName("no-horizontal-drag-hints");
        menuContent.setWidth(null);
        menuContent.setHeight("100%");
        menuContent.addComponent(buildTitle());
        menuContent.addComponent(buildUserMenu());
        return menuContent;
    }

    private Component buildTitle() {
        Label logo = new Label("QuickTickets <strong>Dashboard</strong>",
                ContentMode.HTML);
        logo.setSizeUndefined();
        HorizontalLayout logoWrapper = new HorizontalLayout(logo);
        logoWrapper.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
        logoWrapper.addStyleName("valo-menu-title");
        return logoWrapper;
    }

    private User getCurrentUser() {
        return new User();
    }

    private Component buildUserMenu() {
        final MenuBar settings = new MenuBar();
        settings.addStyleName("user-menu");
        final User user = getCurrentUser();
        MenuBar.MenuItem settingsItem = settings.addItem("", new ThemeResource("img/profile-pic-300px.jpg"), null);
        settingsItem.setText(user.getFirstName() + " " + user.getLastName());
        settingsItem.addItem("Edit Profile", s -> ProfilePreferencesWindow.open(user, false));
        settingsItem.addItem("Preferences", s -> ProfilePreferencesWindow.open(user, true));
        settingsItem.addSeparator();
        settingsItem.addItem("Sign Out", selectedItem -> {
            //              DashboardEventBus.post(new UserLoggedOutEvent());
        });
        return settings;
    }
}
