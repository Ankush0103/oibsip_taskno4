import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {

        try {

            LoginForm form = new LoginForm();
            form.setSize(500, 175);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

