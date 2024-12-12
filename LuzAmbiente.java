package ExercicioC;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;

public class LuzAmbiente extends JFrame {
    private JPanel lightPanel;
    private boolean aLuzEstaLigada = false;
    private Color corAtual = Color.WHITE;
    private int brilho = 255;

    public LuzAmbiente() {
        setTitle("Controle de Luz de Ambiente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
   
        lightPanel = new JPanel();
        lightPanel.setBackground(Color.BLACK);
        add(lightPanel, BorderLayout.CENTER);
      
        JPanel painelControle = new JPanel(new GridLayout(3, 2, 10, 10));

        JButton botaoLigar = new JButton("Ligar");
        painelControle.add(new JLabel("Estado:"));
        painelControle.add(botaoLigar);
        
        String[] cor = {"Branco", "Vermelho", "Azul", "Verde"};
        JComboBox<String> comboCor = new JComboBox<>(cor);
        painelControle.add(new JLabel("Cor:"));
        painelControle.add(comboCor);

        JSlider controleBrilho = new JSlider(0, 255, 255);
        controleBrilho.setMajorTickSpacing(50);
        controleBrilho.setPaintTicks(true);
        painelControle.add(new JLabel("Brilho:"));
        painelControle.add(controleBrilho);

        add(painelControle, BorderLayout.SOUTH);

        botaoLigar.addActionListener(e -> {
            aLuzEstaLigada = !aLuzEstaLigada;
            botaoLigar.setText(aLuzEstaLigada ? "Desligar" : "Ligar");
            atualizandoPainel();
        });

        comboCor.addActionListener(e -> {
            String corSelecionada = (String) comboCor.getSelectedItem();
            corAtual = switch (corSelecionada) {
                case "Vermelho" -> Color.RED;
                case "Azul" -> Color.BLUE;
                case "Verde" -> Color.GREEN;
                default -> Color.WHITE;
            };
            atualizandoPainel();
        });

        controleBrilho.addChangeListener((ChangeEvent e) -> {
            brilho = controleBrilho.getValue();
            atualizandoPainel();
        });

        setVisible(true);
    }

    private void atualizandoPainel() {
        if (aLuzEstaLigada) {
         
            int vermelho = (corAtual.getRed() * brilho) / 255;
            int verde = (corAtual.getGreen() * brilho) / 255;
            int azul = (corAtual.getBlue() * brilho) / 255;
            lightPanel.setBackground(new Color(vermelho, verde, azul));
        } else {
            lightPanel.setBackground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LuzAmbiente::new);
    }
}


