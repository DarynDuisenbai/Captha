package org.example;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.security.MessageDigest;

public class Login extends JFrame {
    SlackNotifier slackNotifier = new SlackNotifier();
    public void check_login(String login, String password) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Login", "postgres", "mother1978");

        // Hash the provided password using MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        String hashedPassword = sb.toString();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM test1 WHERE Login_user = ? and Password_user = ?");

        ps.setString(1, login);
        ps.setString(2, password);

        ResultSet result = ps.executeQuery();
        if (result.next()) {
            // Compare the provided password hash with the stored hash in the database
            String storedHashedPassword = result.getString("Password_user");
            if (password.equals(storedHashedPassword)) {
                // Create a new JFrame object
                JFrame welcomeFrame = new JFrame("Checking Page");

                // Add a JLabel with the "Welcome" message to the JFrame
                JLabel welcomeLabel = new JLabel("Welcome");
                welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
                welcomeFrame.getContentPane().add(welcomeLabel);

                // Set the size of the JFrame and make it visible
                welcomeFrame.setSize(200, 100);
                welcomeFrame.setLocationRelativeTo(null);
                welcomeFrame.setVisible(true);
                slackNotifier.sendMassage("A user logged into the system");
                // Create a new Captcha object
                new Captcha();

            }

        } else {
            JFrame Login_not_foundFrame = new JFrame("Checking Page");

            // Add a JLabel with the "Login not found" message to the JFrame
            JLabel Login_not_foundLabel = new JLabel("Incorrect");
            Login_not_foundLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Login_not_foundFrame.getContentPane().add(Login_not_foundLabel);
            slackNotifier.sendMassage("Someone tried to log into the system, a refusal came");
            // Set the size of the JFrame and make it visible
            Login_not_foundFrame.setSize(200, 100);
            Login_not_foundFrame.setLocationRelativeTo(null);
            Login_not_foundFrame.setVisible(true);
        }


        con.close();
    }

}





