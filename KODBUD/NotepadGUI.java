import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class NotepadGUI extends JFrame implements ActionListener {
    private final JTextArea textArea;
    private final JMenuItem newFile;
    private final JMenuItem openFile;
    private final JMenuItem saveFile;
    private final JMenuItem exit;
    public NotepadGUI() {
        setTitle("Notepad");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        add(new JScrollPane(textArea));
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(exit);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            textArea.setText("");
        }
        else if (e.getSource() == openFile) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader br = new BufferedReader(
                        new FileReader(chooser.getSelectedFile()))) {
                    textArea.read(br, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file");
                }
            }
        }
        else if (e.getSource() == saveFile) {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter(chooser.getSelectedFile()))) {
                    textArea.write(bw);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file");
                }
            }
        }
        else if (e.getSource() == exit) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotepadGUI::new);
    }
}