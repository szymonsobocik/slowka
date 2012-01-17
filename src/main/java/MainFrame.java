import pl.ssobocik.domain.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/*
 * Created by JFormDesigner on Sun Jan 15 09:22:06 CET 2012
 */



/**
 * @author User #2
 */
public class MainFrame extends JFrame {

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                MainFrame mainFrame = null;
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
            }
        });

    }

    public MainFrame() {
        initComponents();
        java.util.List<Word> words = WordsController.loadWords();
        ((WordsTableModel) table1.getModel()).setWords(words);
    }

    private void tableCreationAndConfiguration() {
        table1 = new JTable(new WordsTableModel());
    }

    private void initComponents() {
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItemImport = new JMenuItem();
        menuItemExport = new JMenuItem();
        scrollPane1 = new JScrollPane();
        tableCreationAndConfiguration();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItemImport ----
                menuItemImport.setText("Import words");
                menuItemImport.setEnabled(false);
                menu1.add(menuItemImport);

                //---- menuItemExport ----
                menuItemExport.setText("Export Words");
                menuItemExport.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            WordsController.saveWords(((WordsTableModel) table1.getModel()).getWords());
                        } catch (IOException e1) {
                            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    }
                });
                menu1.add(menuItemExport);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItemImport;
    private JMenuItem menuItemExport;
    private JScrollPane scrollPane1;
    private JTable table1;
}
