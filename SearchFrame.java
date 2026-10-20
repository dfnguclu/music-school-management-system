package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import MainAndSystem.MusicCenterSystem;
import Inheritance.Musician;

public class SearchFrame extends JFrame {
    private JPanel contentPane;
    private MainFrame mainF;
    private JComboBox<Integer> idCMB; 
    private JTextArea resTA;

    public SearchFrame(MainFrame frame) {
    	mainF = frame;
        setTitle("Search & Delete Panel");
        setBounds(100, 100, 500, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl = new JLabel("Select Student ID:");
        lbl.setBounds(30, 20, 120, 20);
        contentPane.add(lbl);

        
        idCMB = new JComboBox<>();
        fillComboBox(); 
        idCMB.setBounds(150, 20, 100, 25);
        contentPane.add(idCMB);

        resTA = new JTextArea();
        resTA.setEditable(false);
        JScrollPane sp = new JScrollPane(resTA);
        sp.setBounds(30, 60, 420, 280);
        contentPane.add(sp);

       
        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(260, 18, 90, 30);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idCMB.getSelectedItem() != null) {
                    int selectedId = (int) idCMB.getSelectedItem();
                    Musician m = MusicCenterSystem.searchById(selectedId);
                    if (m != null) resTA.setText(m.toString());
                } else {
                    resTA.setText("No student selected or system is empty!");
                }
            }
        });
        contentPane.add(btnSearch);

       
        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(360, 18, 90, 30);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (idCMB.getSelectedItem() != null) {
                    int selectedId = (int) idCMB.getSelectedItem();
                    if (MusicCenterSystem.deleteMusician(selectedId)) {
                        resTA.setText("Student with ID " + selectedId + " has been removed.");
                        fillComboBox();
                    }
                }
            }
        });
        contentPane.add(btnDelete);

        JButton btnClose = new JButton("CLOSE");
        btnClose.setBounds(190, 360, 100, 30);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainF.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnClose);
    }

   
    private void fillComboBox() {
        idCMB.removeAllItems(); 
        Integer[] ids = MusicCenterSystem.getAllIds(); 
        for (Integer id : ids) {
            idCMB.addItem(id);
        }
    }
}