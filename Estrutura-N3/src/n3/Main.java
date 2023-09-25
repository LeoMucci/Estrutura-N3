package n3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArvoreBinaria tree = new ArvoreBinaria();
            AdicionarNumerosFrame addFrame = new AdicionarNumerosFrame(tree);
            addFrame.setVisible(true);
            
            
            
        });
        
        
        
    }
}
