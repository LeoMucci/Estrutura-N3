package n3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarNumerosFrame extends JFrame {
    private ArvoreBinaria<Integer> arvore;

    public ListarNumerosFrame(ArvoreBinaria<Integer> arvore) {
        this.arvore = arvore;
        setTitle("Listar N�meros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<Integer> modelo = new DefaultListModel<>();
        JList<Integer> lista = new JList<>(modelo);

        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoOrdemCrescente = new JButton("Ordem Crescente");
        JButton botaoPreOrdem = new JButton("Pr�-ordem");
        JButton botaoPosOrdem = new JButton("P�s-ordem");
        JButton botaoBuscar = new JButton("Buscar"); 

        arvore.listarEmOrdem(modelo);

        botaoOrdemCrescente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarEmOrdem(modelo);
            }
        });

        botaoPreOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarPreOrdem(modelo);
            }
        });

        botaoPosOrdem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
                arvore.listarPosOrdem(modelo);
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarNumerosFrame adicionarFrame = new AdicionarNumerosFrame(arvore);
                adicionarFrame.setVisible(true);
                setVisible(false);
            }
        });


        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Informe o n�mero a ser buscado:");
                try {
                    int numero = Integer.parseInt(input);

                    long startTime = System.nanoTime();

                    boolean encontrado = arvore.buscar(numero);


                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - startTime;

                    if (encontrado) {
                        JOptionPane.showMessageDialog(ListarNumerosFrame.this, "N�mero encontrado!\nTempo de busca: " + elapsedTime + " nanossegundos");
                    } else {
                        JOptionPane.showMessageDialog(ListarNumerosFrame.this, "N�mero n�o encontrado.\nTempo de busca: " + elapsedTime + " nanossegundos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ListarNumerosFrame.this, "Por favor, insira um n�mero v�lido.");
                }
            }
        });

        JPanel painelBotoes = new JPanel(new GridLayout(1, 5));
        painelBotoes.add(botaoOrdemCrescente);
        painelBotoes.add(botaoPreOrdem);
        painelBotoes.add(botaoPosOrdem);
        painelBotoes.add(botaoBuscar); 
        painelBotoes.add(botaoVoltar);

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(painelBotoes, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(lista), BorderLayout.CENTER);
        painelPrincipal.add(botaoVoltar, BorderLayout.SOUTH);

        add(painelPrincipal);
    }
}
