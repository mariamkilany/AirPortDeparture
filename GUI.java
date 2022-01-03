import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private static JLabel labelA;
    private static JLabel label1;
    private static JLabel label2;
    private static JLabel label3;
    private static JLabel label4;
    private static JLabel label5;
    private static JLabel label6;
    private static JLabel label7;
    private static JLabel labelD;
    private static JLabel label1D;
    private static JLabel label1U;
    private static JLabel label2U;
    private static JLabel label3U;
    private static JLabel label1S;
    private static JLabel label2S;
    private static JLabel label3S;
    private static JLabel labelDB1;
    private static JLabel added;
    private static JLabel deleted;
    private static JLabel updated;
    private static JTextField text1;
    private static JTextField text2;
    private static JTextField text3;
    private static JTextField text4;
    private static JTextField text5;
    private static JTextField text6;
    private static JTextField text7;
    private static JTextField text1D;
    private static JTextField text1U;
    private static JTextField text2U;
    private static JTextField text1S;
    private static JButton button1;
    private static JButton button1C;
    private static JButton button2;
    private static JButton button2D;
    private static JButton button3;
    private static JButton button3U;
    private static JButton button4;
    private static JButton button5;
    private static JButton buttonR;
    private static JButton buttonT1;
    private static JButton buttonT2;
    private static JFrame frame;
    private static JPanel panel;
    private static Main s;
    public GUI(){

        frame = new JFrame();
        frame.setSize(500, 500);
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Departure");
        frame.pack();
        panel.setLayout(null);
        //panel.setBackground(Color.BLACK);
//        labelDB1=new JLabel("DEPARTURE");
//        labelDB1.setBounds(600, 10, 200, 25);
//        labelDB1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
//        labelDB1.setOpaque(true);
//        labelDB1.setBackground(Color.BLACK);
//        labelDB1.setForeground(Color.white);
//        labelDB1.setFont(new Font("Tahome", Font.BOLD, 25));
//        panel.add(labelDB1);
        labelA = new JLabel("Enter new Flight : ");
        labelA.setBounds(5, 30, 150, 25);
        labelA.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        labelA.setOpaque(true);
        labelA.setBackground(Color.BLACK);
        panel.add(labelA);
        labelA.setForeground(Color.white);
        label1 = new JLabel("Flight Number : ");
        label1.setBounds(10, 60, 100, 25);
        panel.add(label1);
        label2 = new JLabel("Destination : ");
        label2.setBounds(10, 100, 100, 25);
        panel.add(label2);
        label3 = new JLabel("No.passengers : ");
        label3.setBounds(10, 140, 100, 25);
        panel.add(label3);
        label4 = new JLabel("Take Off time : ");
        label4.setBounds(10, 180, 100, 25);
        panel.add(label4);
        label5 = new JLabel("Arrival Time : ");
        label5.setBounds(10, 220, 100, 25);
        panel.add(label5);
        label6 = new JLabel("Gate number : ");
        label6.setBounds(10, 260, 100, 25);
        panel.add(label6);
        label7 = new JLabel("Remarks : ");
        label7.setBounds(10, 300, 100, 25);
        panel.add(label7);


        text1 = new JTextField(20);
        text1.setBounds(120, 60, 165, 25);
        panel.add(text1);
        text2 = new JTextField(20);
        text2.setBounds(120, 100, 165, 25);
        panel.add(text2);
        text3 = new JTextField(20);
        text3.setBounds(120, 140, 165, 25);
        panel.add(text3);
        text4 = new JTextField(20);
        text4.setBounds(120, 180, 165, 25);
        panel.add(text4);
        text5 = new JTextField(20);
        text5.setBounds(120, 220, 165, 25);
        panel.add(text5);
        text6 = new JTextField(20);
        text6.setBounds(120, 260, 165, 25);
        panel.add(text6);
        text7 = new JTextField(20);
        text7.setBounds(120, 300, 165, 25);
        panel.add(text7);

        button1 = new JButton(new AbstractAction("ADD") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNum = text1.getText();
                String destination = text2.getText();
                String pass = text3.getText();
                String takeOffTime = text4.getText();
                String arrTime = text5.getText();
                String gate = text6.getText();
                String remarks = text7.getText();
                Main.insert(new Flight(flightNum, destination, pass, takeOffTime, arrTime, gate, remarks));
                added=new JLabel("FLIGHT ADDED SUCCESSFULLY");
                added.setBounds(500,340,200,25);
                added.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
                added.setOpaque(true);
                panel.add(added);
            }
        });
        button1.setBounds(120, 340, 165, 25);
        panel.add(button1);
        button1C = new JButton(new AbstractAction("CLEAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                text1.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                text7.setText("");
                panel.remove(added);
                panel.revalidate();
                panel.repaint();
            }
        });
        button1C.setBounds(320, 340, 165, 25);
        panel.add(button1C);

        labelD = new JLabel("Enter the Flight NUMBER to Delete : ");
        labelD.setBounds(5, 380, 250, 25);
        labelD.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        labelD.setOpaque(true);
        labelD.setBackground(Color.BLACK);
        labelD.setForeground(Color.white);
        panel.add(labelD);
        label1D = new JLabel("Flight number :");
        label1D.setBounds(10, 420, 100, 25);
        panel.add(label1D);
        text1D = new JTextField(20);
        text1D.setBounds(120, 420, 165, 25);
        panel.add(text1D);
        button2 = new JButton(new AbstractAction("DELETE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNum = text1D.getText();
                if(Main.deleteRec(flightNum))
                    deleted=new JLabel("Deleted Successfully");
                else
                    deleted=new JLabel("Not Found");
                deleted.setBounds(500,460,200,25);
                deleted.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
                deleted.setOpaque(true);
                panel.add(deleted);
                text1D.setText("");
            }
        });
        button2.setBounds(120, 460, 165, 25);
        panel.add(button2);
        button2D = new JButton(new AbstractAction("CLEAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(deleted);
                panel.revalidate();
                panel.repaint();
            }
        });
        button2D.setBounds(320, 460, 165, 25);
        panel.add(button2D);
        label1U = new JLabel("Enter the Flight NUMBER and new Remarks to Update : ");
        label1U.setBounds(5, 500, 350, 25);
        label1U.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        label1U.setOpaque(true);
        label1U.setBackground(Color.BLACK);
        label1U.setForeground(Color.white);
        panel.add(label1U);
        label2U = new JLabel("Flight number :");
        label2U.setBounds(10, 540, 100, 25);
        panel.add(label2U);
        text1U = new JTextField(20);
        text1U.setBounds(120, 540, 165, 25);
        panel.add(text1U);
        label3U = new JLabel("New Remarks :");
        label3U.setBounds(10, 580, 100, 25);
        panel.add(label3U);
        text2U = new JTextField(20);
        text2U.setBounds(120, 580, 165, 25);
        panel.add(text2U);
        button3 = new JButton(new AbstractAction("UPDATE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNum = text1U.getText();
                String remarks=text2U.getText();
                if(Main.update(flightNum,remarks))
                    updated=new JLabel("UPDATED SUCCESSFULLY");
                else
                    updated=new JLabel("NOT FOUND");
                updated.setBounds(500,620,200,25);
                updated.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
                updated.setOpaque(true);
                panel.add(updated);
                text1U.setText("");
                text2U.setText("");
            }
        });
        button3.setBounds(120, 620, 165, 25);
        panel.add(button3);
        button3U = new JButton(new AbstractAction("CLEAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(updated);
                panel.revalidate();
                panel.repaint();
            }
        });
        button3U.setBounds(320, 620, 165, 25);
        panel.add(button3U);
        label1S = new JLabel("Enter the Flight NUMBER  you want to display : ");
        label1S.setBounds(5, 660, 350, 25);
        label1S.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        label1S.setOpaque(true);
        label1S.setBackground(Color.BLACK);
        label1S.setForeground(Color.white);
        panel.add(label1S);
        label2S = new JLabel("Flight number : ");
        label2S.setBounds(10, 700, 350, 25);
        panel.add(label2S);
        text1S = new JTextField(20);
        text1S.setBounds(120, 700, 165, 25);
        panel.add(text1S);
        button4 = new JButton(new AbstractAction("SEARCH") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNum = text1S.getText();
                label3S = new JLabel(Main.search(flightNum));
                label3S.setBounds(10, 780, 350, 25);
                label3S.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
                label3S.setOpaque(true);
                label3S.setBackground(Color.BLACK);
                label3S.setForeground(Color.white);
                panel.add(label3S);
                text1S.setText("");
            }
        });
        button4.setBounds(120, 740, 165, 25);
        panel.add(button4);
        button5 = new JButton(new AbstractAction("CLEAR") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.remove(label3S);
                panel.revalidate();
                panel.repaint();
            }
        });
        button5.setBounds(320, 740, 165, 25);
        panel.add(button5);
        buttonR = new JButton(new AbstractAction("REFRESH") {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.invalidate();
                panel.validate();
                panel.repaint();
            }
        });
        buttonR.setBounds(200, 900, 165, 50);
        panel.add(buttonR);
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("FlightNUM");
//        model.addColumn("Destination");
//        model.addColumn("FlightNUM");
//        model.addColumn("Destination");
//        model.addColumn("FlightNUM");
//        model.addColumn("Destination");
//        model.addColumn("FlightNUM");
//        String [][]s=Main.readAllRow();
//        for (int i=0;i< Main.RowNum();i++){
//            model.addRow(s[i]);
//        }
//        JTable table = new JTable(model);
//        table.setBounds(600,40,500,300);
        //panel.add(table);
        buttonT1 = new JButton(new AbstractAction("SHOW TABLE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel();
                JTable table= new JTable(model);
                model.addColumn("");
                model.addColumn("");
                model.addColumn("");
                model.addColumn("");
                model.addColumn("");
                model.addColumn("");
                model.addColumn("");
                String [][]s=Main.readAllRow();
                for (int i=0;i< Main.rowNum();i++){
                    model.addRow(s[i]);
                }
                table.setBounds(600,40,800,400);
                table.setOpaque(true);
                table.setFillsViewportHeight(true);
                table.setBackground(Color.BLACK);
                table.setForeground(Color.white);
                table.setFont(new Font("Tahome", Font.BOLD, 15));
               panel.add(table);
                labelDB1=new JLabel("DEPARTURE");
                labelDB1.setBounds(920, 16, 170, 25);
                labelDB1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
                labelDB1.setOpaque(true);
                labelDB1.setBackground(Color.BLACK);
                labelDB1.setForeground(Color.white);
                labelDB1.setFont(new Font("Tahome", Font.BOLD, 25));
                panel.add(labelDB1);
                buttonT2 = new JButton(new AbstractAction("CLEAR TABLE") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.remove(table);
                        panel.remove(buttonT2);
                        panel.remove(labelDB1);
                        panel.revalidate();
                        panel.repaint();
                    }
                });
                buttonT2.setBounds(320, 820, 165, 25);
                panel.add(buttonT2);
            }
        });
        buttonT1.setBounds(120, 820, 165, 25);
        panel.add(buttonT1);
        frame.setVisible(true);
    }
    }

