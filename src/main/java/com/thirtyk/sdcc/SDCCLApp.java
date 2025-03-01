package com.thirtyk.sdcc;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class SDCCLApp {
        private final JFrame frame;
        private final JTextArea textArea;
        private File selectedFile;

        public static void main(String[] args) {
            SwingUtilities.invokeLater(SDCCLApp::new);
        }
        public SDCCLApp() {
            frame = new JFrame("Steam Deck Control Layouts");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JButton loadButton = new JButton("Load VDF File");
            JButton injectButton = new JButton("Inject to Steam Deck");
            textArea = new JTextArea();
            textArea.setEditable(false);

            loadButton.addActionListener(e -> loadVDF());
            injectButton.addActionListener(e -> injectVDF());

            panel.add(loadButton, BorderLayout.NORTH);
            panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
            panel.add(injectButton, BorderLayout.SOUTH);

            frame.add(panel);
            frame.setVisible(true);
        }


    private void loadVDF() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            textArea.setText("Selected File: " + selectedFile.getAbsolutePath());

            // Placeholder for VDF parsing logic
            textArea.append("\n(VDF parsing logic not implemented yet)");
        }
    }

    private void injectVDF() {
        if (selectedFile != null) {
            String gameId = JOptionPane.showInputDialog(frame, "Enter Game ID:");
            if (gameId != null && !gameId.isEmpty()) {
                // Placeholder for VDF injection logic
                JOptionPane.showMessageDialog(frame, "Injection logic not implemented yet.");
            }
        }
    }

}