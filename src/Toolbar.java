import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {
    JToolBar toolBar;
    JButton hideMenu, floatToolBar, open, save, copy, paste;

    Toolbar(JMenuBar topBar){
        init();
        initToolBarContent(topBar);
    }

    private void init(){
        toolBar = this;
        toolBar.setFloatable(false);
        toolBar.setRollover(true);

    }

    private void initToolBarContent(JMenuBar topBar){
        hideMenu = new JButton("\u2630");
        hideMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topBar.setVisible(!topBar.isVisible());
            }
        });
        toolBar.add(hideMenu);
        floatToolBar = new JButton("\u2756");
        floatToolBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBar.setFloatable(!toolBar.isFloatable());
            }
        });
        toolBar.add(floatToolBar);

        open = new JButton("Otwórz");
        save = new JButton("Zapisz");
        copy = new JButton("Kopiuj");
        paste = new JButton("Wklej");
        toolBar.add(open);
        toolBar.add(save);
        toolBar.add(copy);
        toolBar.add(paste);
    }
}
