package n3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarNumerosFrame extends JFrame {
    private ArvoreBinaria<Integer> arvore;

    public AdicionarNumerosFrame(ArvoreBinaria<Integer> arvore) {
        this.arvore = arvore;
        setTitle("Adicionar Números");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 1));

        JTextField campoEntrada = new JTextField();
        JButton botaoAdicionar = new JButton("Adicionar");
        JButton botaoListar = new JButton("Listar Números");

        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(campoEntrada.getText());
                    arvore.inserir(numero);
                    campoEntrada.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AdicionarNumerosFrame.this, "Por favor, insira um número válido.");
                }
            }
        });
        
        

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarNumerosFrame listarFrame = new ListarNumerosFrame(arvore);
                listarFrame.setVisible(true);
                setVisible(false);
            }
        });

        painel.add(campoEntrada);
        painel.add(botaoAdicionar);
        painel.add(botaoListar);

        add(painel);
    }
}


