package org.revo.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by revo on 07/10/15.
 */
@SpringUI
@Theme("valo")
public class index extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout verticalLayout = new VerticalLayout();
        List<Label> data = new ArrayList<Label>();
        List<TextField> filds = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add(new Label("welcome" + i));
            filds.add(new TextField());
            verticalLayout.addComponent(new HorizontalLayout(data.get(i), filds.get(i)));
        }

        Button hide = new Button("hide all");
        Button show = new Button("show all");
        Button print = new Button("print");
        hide.addClickListener(clickEvent -> data.forEach(label -> label.setVisible(false)));
        show.addClickListener(clickEvent -> data.forEach(label -> label.setVisible(true)));
        print.addClickListener(clickEvent -> {
            String collect = filds.stream().map(textField -> textField.getValue()).collect(Collectors.joining(" "));
            Notification notification = new Notification(collect);
            notification.setPosition(Position.BOTTOM_RIGHT);
            notification.setDelayMsec(5000);
            notification.setDescription("welcome");
            notification.setIcon(FontAwesome.EYE);
            notification.show(Page.getCurrent());
        });
        verticalLayout.setSpacing(true);
        verticalLayout.setMargin(true);
        HorizontalLayout h = new HorizontalLayout(show, hide, print);
        h.setSpacing(true);
        h.setMargin(true);
        verticalLayout.addComponent(h);
        setContent(verticalLayout);

    }
}
