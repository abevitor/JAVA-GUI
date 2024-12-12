import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerificarCpf {

    private JFrame frameCPF;
    private JTextField txtCPF;
    private JTextField txtResultado;

    public VerificarCpf() {
        initialize();
    }

    private void initialize() {
        frameCPF = new JFrame();
        frameCPF.setBounds(100, 100, 500, 300);
        frameCPF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCPF.getContentPane().setLayout(null);

        JLabel lblCPF = new JLabel("Digite o CPF:");
        lblCPF.setFont(new Font("Serif", Font.PLAIN, 20));
        lblCPF.setBounds(53, 56, 140, 27);
        frameCPF.getContentPane().add(lblCPF);

        txtCPF = new JTextField();
        txtCPF.setBounds(200, 56, 200, 27);
        frameCPF.getContentPane().add(txtCPF);
        txtCPF.setColumns(10);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = txtCPF.getText().replaceAll("[^0-9]", "");
                if (cpfValido(cpf)) {
                    txtResultado.setText("CPF válido.");
                } else {
                    txtResultado.setText("CPF inválido.");
                }
            }
        });
        btnVerificar.setBounds(53, 100, 100, 27);
        frameCPF.getContentPane().add(btnVerificar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCPF.setText("");
                txtResultado.setText("");
            }
        });
        btnLimpar.setBounds(200, 100, 100, 27);
        frameCPF.getContentPane().add(btnLimpar);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSair.setBounds(350, 100, 100, 27);
        frameCPF.getContentPane().add(btnSair);

        txtResultado = new JTextField();
        txtResultado.setBounds(53, 150, 400, 27);
        frameCPF.getContentPane().add(txtResultado);
        txtResultado.setColumns(10);
    }

    public void showWindow() {
        frameCPF.setVisible(true);
    }

    private boolean cpfValido (String cpf) {
        if (cpf.length() != 11) return false;

        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) digito1 = 0;

        if (digito1 != Character.getNumericValue(cpf.charAt(9))) return false;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;

        return digito2 == Character.getNumericValue(cpf.charAt(10));
    }

}
