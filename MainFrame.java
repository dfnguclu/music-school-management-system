package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import MainAndSystem.MusicCenterSystem;
import Inheritance.*;

public class MainFrame extends JFrame {
    private JPanel contentPane;
    private JTextField nameTF, ageTF, expTF, feeTF, instrNameTF, instrSpecTF, instrPhoneTF;
    private JComboBox<String> typeCMB;
    private JTextArea displayTA;
    
    SearchFrame sf = new SearchFrame(this);

    public MainFrame() {
        setTitle("Harmony Music Center - Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        int labelX = 20, tfX = 140, yInc = 30, currentY = 20;

        addLabelAndTF("Name:", labelX, currentY, nameTF = new JTextField());
        currentY += yInc;
        addLabelAndTF("Age:", labelX, currentY, ageTF = new JTextField());
        currentY += yInc;
        addLabelAndTF("Exp. Year:", labelX, currentY, expTF = new JTextField());
        currentY += yInc;
        addLabelAndTF("Monthly Fee:", labelX, currentY, feeTF = new JTextField());
        

        feeTF.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) e.consume();
            }
        });

        currentY += yInc + 10;
        JLabel lblInstr = new JLabel("INSTRUCTOR INFO:");
        lblInstr.setBounds(labelX, currentY, 200, 20);
        contentPane.add(lblInstr);
        
        currentY += 25;
        addLabelAndTF("Instr. Name:", labelX, currentY, instrNameTF = new JTextField());
        currentY += yInc;
        addLabelAndTF("Specialization:", labelX, currentY, instrSpecTF = new JTextField());
        currentY += yInc;
        addLabelAndTF("Phone:", labelX, currentY, instrPhoneTF = new JTextField());

        currentY += yInc + 10;
        String[] types = {"Guitarist", "Pianist"};
        typeCMB = new JComboBox<>(types);
        typeCMB.setBounds(labelX, currentY, 220, 25);
        contentPane.add(typeCMB);

        // --- Sağ Taraf: Display Alanı ---
        displayTA = new JTextArea();
        displayTA.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayTA);
        scroll.setBounds(380, 20, 330, 350);
        contentPane.add(scroll);

        // --- Butonlar ---
        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(20, 400, 100, 30);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameTF.getText();
                    int age = Integer.parseInt(ageTF.getText());
                    int exp = Integer.parseInt(expTF.getText());
                    double fee = Double.parseDouble(feeTF.getText());
                    
                    Instructor instr = new Instructor(instrNameTF.getText(), instrSpecTF.getText(), instrPhoneTF.getText());

                    if (typeCMB.getSelectedItem().equals("Guitarist")) {
                        MusicCenterSystem.addMusician(new Guitarist(name, age, exp, fee, instr, "Acoustic", 22, "Steel"));
                    } else {
                        MusicCenterSystem.addMusician(new Pianist(name, age, exp, fee, instr, "Grand", "Advanced"));
                    }
                    displayTA.setText("Musician added successfully!");
                    clearFields();
                } catch (Exception ex) {
                    displayTA.setText("Error: Check numeric fields (Age, Exp, Fee)!");
                }
            }
        });
        contentPane.add(btnAdd);

        JButton btnDisplay = new JButton("DISPLAY");
        btnDisplay.setBounds(130, 400, 110, 30);
        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String allData = MusicCenterSystem.displayAll();
                if(allData.isEmpty()) displayTA.setText("System is empty!");
                else displayTA.setText(allData);
            }
        });
        contentPane.add(btnDisplay);

        JButton btnSearchFrame = new JButton("GO TO SEARCH SCREEN");
        btnSearchFrame.setBounds(260, 400, 220, 30);
        btnSearchFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchFrame sf = new SearchFrame(MainFrame.this);
                sf.setVisible(true);
                setVisible(false);
            }
        });
        contentPane.add(btnSearchFrame);
    }

    private void addLabelAndTF(String text, int x, int y, JTextField tf) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 120, 20);
        tf.setBounds(x + 120, y, 100, 20);
        contentPane.add(lbl);
        contentPane.add(tf);
    }

    private void clearFields() {
        nameTF.setText(""); ageTF.setText(""); expTF.setText(""); feeTF.setText("");
        instrNameTF.setText(""); instrSpecTF.setText(""); instrPhoneTF.setText("");
    }
}