import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FileFrame extends JFrame{
    private JPanel panel;
    private JTextField fileField;
    private JButton previousBtn;
    private JButton addBtn;
    private JButton nextBtn;
    private List<String> fileList = new ArrayList<>();
    private int index = 0;
    private JFileChooser fc = new JFileChooser(".");

    public FileFrame(){
        initWindow();
        update();
    }
    public void update(){
        fileField.setText(fileList.get(index));
    }
    public void add(){
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            fileList.add(String.valueOf(fc.getSelectedFile()));
            index = fileList.size()-1;
            update();
        }
    }

    public void initWindow(){
        setContentPane(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Listovač souborů");
        setSize(500, 250);

        nextBtn.addActionListener(e -> move(true));
        previousBtn.addActionListener(e -> move(false));
        addBtn.addActionListener(e -> add());

        fileList.add("K:\\simunek\\vysledky");
        fileList.add("K:\\simunek\\2b_sk1\\Frystak_Jan");
        fileList.add("P:\\2. Ročník\\TAN");

    }

    public static void main(String[] args) {
        FileFrame frame = new FileFrame();
    }
    public void move(boolean right){
        if (!fileList.isEmpty()){
            if (right & index+1 < fileList.size()){
                index++;
                update();
            } else if (!right & index >= 1 ) {
                index--;
                update();
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Couldn't load default files, please add default files");
        }
    }
}
