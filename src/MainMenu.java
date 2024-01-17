import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {
    JFrame box;
    JMenu menu;
    JMenuBar topBar;
    Toolbar toolbar;

    JMenuItem open, save, exit;
    JMenuItem option4, option5;
    JList sidebar;
    JPanel center = new JPanel();
    JPanel top = new JPanel();
    JPanel left = new JPanel();
    JMenu submenu = new JMenu("submenu");
    FSUtils fsUtils;



    MainMenu(){
        init();
        box.setVisible(true);
    }
    private void init(){
        box = new JFrame("Zadanie");
        box.setSize(new Dimension(500, 300));
        box.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initTopBar();
        toolbar = new Toolbar(topBar);
        initTopPanel();
        box.add(top, BorderLayout.PAGE_START);
        initLeftPanel();
        box.add(left, BorderLayout.LINE_START);
    }

    private void initTopBar(){
        topBar = new JMenuBar();
        menu = new JMenu("Plik");

        open = new JMenuItem("Otwórz");
        open.addActionListener(this);
        menu.add(open);

        save = new JMenuItem("Zapisz");
        save.addActionListener(this);
        menu.add(save);


        option4 = new JMenuItem("Opcja4");
        option4.addActionListener(this);
        option5 = new JMenuItem("Opcja5");
        option5.addActionListener(this);
        submenu.add(option4);
        submenu.add(option5);
        menu.add(submenu);

        exit = new JMenuItem("Wyjście");
        exit.addActionListener(this);
        menu.add(exit);
        topBar.add(menu);
    }

    private void initTopPanel(){
        top.setLayout(new GridLayout(2, 1));
        top.add(topBar);
        top.add(toolbar);
    }

    private void initLeftPanel(){
        String []items = {"pusty-plik.txt", "plik1.txt", "plik2.txt", "dokument5.txt"};
        sidebar = new JList(items);
        left.add(sidebar);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object src = e.getSource();
        if(src == this.open){
            topBar.setBackground(Color.RED);
            fsUtils = new FSUtils();
            String print = fsUtils.readFile("plik1.txt");
            JLabel label = new JLabel(print);
            center.add(label);
            box.add(center, BorderLayout.CENTER);
            box.revalidate();

        }
        if(src == save){
            topBar.setBackground(Color.GREEN);
            fsUtils = new FSUtils();
            fsUtils.saveFile("plik1.txt", "tkest1 \r\n tekst2");
        }
        if(src == option4){
            topBar.setBackground(Color.BLUE);
        }
        if(src == option5){
            topBar.setBackground(Color.YELLOW);
        }
        if(src == exit){
            box.dispose();
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
