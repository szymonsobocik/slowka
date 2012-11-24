package pl.ssobocik.slowka;

import pl.ssobocik.slowka.domain.Word;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MainFrame extends JFrame {

    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
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
        mainMenuBar = new JMenuBar();
        menuFile = new JMenu();
        menuItemImport = new JMenuItem();
        menuItemExport = new JMenuItem();
        scrollPane1 = new JScrollPane();
        tableCreationAndConfiguration();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== mainMenuBar ========
        {

            //======== menuFile ========
            {
                menuFile.setText("File");

                //---- menuItemImport ----
                menuItemImport.setText("Import words");
                menuItemImport.setEnabled(false);
                menuFile.add(menuItemImport);

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
                menuFile.add(menuItemExport);
            }

            JMenuItem addWordMenuItem = new JMenuItem("Add word");
            addWordMenuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Word word = new Word();
                    word.setWord("new word");
                    ((WordsTableModel) table1.getModel()).addWord(word);

                }
            });

            JMenu menuWords = new JMenu("Words");
            menuWords.add(addWordMenuItem);

            mainMenuBar.add(menuFile);
            mainMenuBar.add(menuWords);
        }
        setJMenuBar(mainMenuBar);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JMenuBar mainMenuBar;
    private JMenu menuFile;
    private JMenuItem menuItemImport;
    private JMenuItem menuItemExport;
    private JScrollPane scrollPane1;
    private JTable table1;
}
