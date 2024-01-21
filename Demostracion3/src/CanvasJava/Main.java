package CanvasJava;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Canvas en Java Swing");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CanvasPersonalizado canvas = new CanvasPersonalizado();
            frame.add(canvas);

            frame.setVisible(true);
        });
    }
}

