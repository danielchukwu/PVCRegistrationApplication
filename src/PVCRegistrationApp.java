import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PVCRegistrationApp {

    Queue<String[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        PVCRegistrationApp startapp = new PVCRegistrationApp();
        startapp.run();
    }

    public void run() {
        // Frame Setup
        JFrame frame = new JFrame("PVC Registration App");
        frame.setLayout(new GridLayout(8, 2));
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Labels
        JLabel infoText = new JLabel("The text entered here will be used to create your voters card");

        JLabel surnameLabel = new JLabel("SURNAME:");
        JLabel firstNameLabel = new JLabel("FIRSTNAME:");
        JLabel lastNameLabel = new JLabel("LASTNAME:");
        JLabel emailLabel = new JLabel("EMAIL:");
        JLabel SOOLabel = new JLabel("STATE OF ORIGIN:");
        JLabel DOBLabel = new JLabel("DATE OF BIRTH:");


        // TexFields
        JTextField surname = new JTextField();
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        JTextField email = new JTextField();
        JTextField SOO = new JTextField();
        JTextField DOB = new JTextField();

        // Button
        JButton applyButton = new JButton("Apply");
        JButton seeNextButton = new JButton("See Next");
        JButton removeNextButton = new JButton("Remove Next");
        JButton printQueueButton = new JButton("Print Queue Queue");


        // Apply Button
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create list that contains all the input fields text
                String[] cardInfo = new String[]{
                        surname.getText(),
                        firstName.getText(),
                        lastName.getText(),
                        email.getText(),
                        SOO.getText(),
                        DOB.getText(),
                };

                // Check that all the input fields are not empty
                for (int i = 0; i < cardInfo.length; i++) {
                    if (cardInfo[i].isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please check that you filled up this form");
                        return;
                    }
                }

                queue.add(cardInfo);
                JOptionPane.showMessageDialog(null, "New Card Application has been submitted");
                JOptionPane.showMessageDialog(null, "Applications Count: " + queue.size());

                // Empty fields
                surname.setText("");
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                SOO.setText("");
                DOB.setText("");
            }
        });

        // See Next Button
        seeNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if queue has no application don't remove anything
                if (queue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are NO APPLICATIONS");
                    return;
                }
                // Show Message on the next user application on the queue
                String[] nextApplication = queue.peek();
                JOptionPane.showMessageDialog(null, Arrays.toString(nextApplication));
            }
        });

        // Remove Next Button
        removeNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if queue has no application don't remove anything
                if (queue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are NO APPLICATIONS");
                    return;
                }
                // Show message on the next user application in the queue
                // and then remove the user
                String[] removedApplication = queue.remove();
                JOptionPane.showMessageDialog(null,
                        "Removed Application: " + Arrays.toString(removedApplication));
                JOptionPane.showMessageDialog(null, "Applications Count: " + queue.size());
            }
        });

        // Print Queue Button
        printQueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if queue has no application don't print
                if (queue.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "There are NO APPLICATIONS");
                    return;
                }
                System.out.println("\nApplications Available: " + queue.size());
                for (String[] item: queue) {
                    System.out.println(Arrays.toString(item));
                }
            }
        });


        // Add
        frame.add(surnameLabel);
        frame.add(surname);
        frame.add(firstNameLabel);
        frame.add(firstName);
        frame.add(lastNameLabel);
        frame.add(lastName);
        frame.add(emailLabel);
        frame.add(email);
        frame.add(SOOLabel);
        frame.add(SOO);
        frame.add(DOBLabel);
        frame.add(DOB);

        frame.add(applyButton);
        frame.add(seeNextButton);
        frame.add(removeNextButton);
        frame.add(printQueueButton);

        // Show frame
        frame.setVisible(true);
    }
}
