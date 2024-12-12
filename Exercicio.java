package ExercicioA;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exercicio {

    private JFrame frame;
    private JTextField txtNumero;
    private JTextField txtResultado;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Exercicio window = new Exercicio();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Exercicio() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 770, 434);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel verificar = new JLabel("Verificação");
        verificar.setFont(new Font("Serif", Font.PLAIN, 29));
        verificar.setBounds(301, 11, 141, 79);
        frame.getContentPane().add(verificar);

        JLabel digitarNumero = new JLabel("Digite um número");
        digitarNumero.setFont(new Font("Serif", Font.PLAIN, 20));
        digitarNumero.setBounds(53, 126, 192, 27);
        frame.getContentPane().add(digitarNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(208, 133, 108, 20);
        frame.getContentPane().add(txtNumero);
        txtNumero.setColumns(10);

        JLabel result = new JLabel("Resultado");
        result.setFont(new Font("Serif", Font.PLAIN, 20));
        result.setBounds(53, 192, 141, 27);
        frame.getContentPane().add(result);

        txtResultado = new JTextField();
        txtResultado.setBounds(208, 192, 234, 20);
        frame.getContentPane().add(txtResultado);
        txtResultado.setColumns(10);

        JButton btnPerfeito = new JButton("Perfeito");
        btnPerfeito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());
                    if (isNumeroPerfeito(numero)) {
                        txtResultado.setText("O número " + numero + " é perfeito!");
                    } else {
                        txtResultado.setText("O número " + numero + " não é perfeito.");
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, insira um número válido.");
                }
            }
        });
        btnPerfeito.setBounds(53, 312, 108, 23);
        frame.getContentPane().add(btnPerfeito);

        JButton btnDSU = new JButton("DSU");
        btnDSU.setFont(new Font("Serif", Font.PLAIN, 13));
        btnDSU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(txtNumero.getText());

                    if (numero >= 10 && numero <= 99) {
                        int dezena = numero / 10;     
                        int unidade = numero % 10;    
                        int soma = dezena + unidade;  

                       
                        String dsu = "" + dezena + soma + unidade;
                        txtResultado.setText("O número DSU é: " + dsu);
                    } else {
                        txtResultado.setText("Por favor, insira um número entre 10 e 99.");
                    }
                } catch (NumberFormatException ex) {
                    txtResultado.setText("Por favor, insira um número válido.");
                }
            }
        });
        btnDSU.setBounds(197, 312, 108, 23);
        frame.getContentPane().add(btnDSU);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNumero.setText("");
                txtResultado.setText("");
            }
        });
        btnLimpar.setBounds(407, 312, 108, 23);
        frame.getContentPane().add(btnLimpar);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSair.setBounds(555, 312, 108, 23);
        frame.getContentPane().add(btnSair);
    }

    private boolean isNumeroPerfeito(int numero) {
        int somaDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                somaDivisores += i;
            }
        }
        return somaDivisores == numero;
    }
}

