import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


// ENUNCIADO:
//Um funcionario de uma empresa estava em ligação com um cliente. Esse cliente queria comprar um serviço da empresa. Então o funcionario pediu o CPF do cliente.
//Para confirmar se o CPF era valído. O funcionario precisava de um programa que confirisse se os numeros digitados eram validos. Que esse programa retorne que o cpf é verdadeiro se tiver 11 numeros e nenhuma letra. e que se tiver mais que 11 numeros, menos que 11 numeros
//e letras retorne falso. Para acessar o verificador de cpf o funcionario deve colocar seu nome de login e sua senha.

public class LoginPage {

    private JFrame frameLogin;
    private JTextField txtLogin;
    private JTextField txtSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginPage window = new LoginPage();
                window.frameLogin.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginPage() {
        initializeLogin();
    }

    private void initializeLogin() {
        frameLogin = new JFrame();
        frameLogin.setBounds(100, 100, 400, 300);
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("Login:");
        lblLogin.setFont(new Font("Serif", Font.PLAIN, 20));
        lblLogin.setBounds(53, 56, 100, 27);
        frameLogin.getContentPane().add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(150, 56, 200, 27);
        frameLogin.getContentPane().add(txtLogin);
        txtLogin.setColumns(10);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Serif", Font.PLAIN, 20));
        lblSenha.setBounds(53, 113, 100, 27);
        frameLogin.getContentPane().add(lblSenha);

        txtSenha = new JTextField();
        txtSenha.setBounds(150, 113, 200, 27);
        frameLogin.getContentPane().add(txtSenha);
        txtSenha.setColumns(10);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(e -> {
            String login = txtLogin.getText();
            String senha = txtSenha.getText();

            if (login.equals("admin") && senha.equals("123456")) {
                frameLogin.setVisible(false);

                VerificarCpf cpfWindow = new VerificarCpf();
                cpfWindow.showWindow();
            } else {
                JOptionPane.showMessageDialog(frameLogin, "Login ou senha incorretos.");
            }
        });
        btnEntrar.setBounds(53, 180, 100, 27);
        frameLogin.getContentPane().add(btnEntrar);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(e -> System.exit(0));
        btnSair.setBounds(250, 180, 100, 27);
        frameLogin.getContentPane().add(btnSair);
    }
}





