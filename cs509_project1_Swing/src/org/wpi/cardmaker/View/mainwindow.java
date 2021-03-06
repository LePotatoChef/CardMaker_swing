package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.VisualElementController;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;
import org.wpi.cardmaker.SwingTestCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainwindow extends JDialog {
    private JPanel contentPane;
    private JPanel ButtonPanel;
    private JScrollPane CardPanel;
    private JButton addVisualElementButton;
    private JButton deleteVisualElementButton;
    private JButton copyVisualElementButton;
    private JButton pasteVisualElementButton;
    private JButton saveButton;
    private JButton button6;
    private JPanel Pages;
    private JPanel FrontPage;
    private JPanel BackPage;
    private JPanel LeftPage;
    private JPanel RightPage;
    private JLabel BackPageText;
    private JLabel BackImage;
    private JLabel FrontImage;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel FrontText;
    private JButton buttonOK;
    private JButton buttonCancel;

    //Controller
    private VisualElementController visualElementController;

    // Card
    private Card card;

    public mainwindow(Card card) {
        setContentPane(contentPane);
        setModal(true);


        // Initialize
        this.card = card;
        card.getFrontPage().setImageLabel(FrontImage);
        card.getFrontPage().setTextLabel(FrontText);
        card.getBackPage().setImageLabel(BackImage);
        card.getBackPage().setTextLabel(BackPageText);

        // Controller
        visualElementController = new VisualElementController(card);

        // add Listener
        addVisualElementButton.addActionListener(new AddVisualElementActionListener());
        //addVisualElementButton.addActionListener(new AddVisualElementActionListener());
        deleteVisualElementButton.addActionListener(new DelVisualElementActionListener());

        copyVisualElementButton.addActionListener(new CopyVisualElementActionListener());
        pasteVisualElementButton.addActionListener(new PasteVisualElementActionListener());
    }

    /*public mainwindow() {


    }*/


    // Button's Listener method
    private class AddVisualElementActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            visualElementController.ChoosePage("Add");
        }
    }

    private class DelVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Delete");
        }
    }
    private class CopyVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Copy");
        }
    }
    private class PasteVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Paste");
        }
    }


    public void createUI(Card card){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        System.out.println(name);
        JFrame frame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType);
        // JFrame frame = new JFrame("Card Maker");
        frame.setContentPane(new mainwindow(card).contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,600);
        frame.pack();
        frame.setVisible(true);
    }



    public class HighlightMouseListener extends MouseAdapter {
        private JLabel previous;

        @Override
        public void mouseClicked(MouseEvent e) {
            Component source = e.getComponent();
            if (!(source instanceof JLabel)) {
                return;
            }
            JLabel label = (JLabel) source;
            if (previous != null) {
                previous.setBackground(null);
                previous.setForeground(null);
                previous.setOpaque(false);
                previous.setText("null");
            }
            previous = label;
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLUE);
            label.setOpaque(true);
            label.setText("Clicked");
        }

    }








    // main function
    public static void main(String[] args) {
        Card card = new Card();
        new mainwindow(card).createUI(card);
    }
}
