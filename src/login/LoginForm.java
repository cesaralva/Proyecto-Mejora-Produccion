package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import conexion.MySQLConnector;
import menu.MenuPrincipal;

public class LoginForm extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JTextField campoUsuario;
    private JPasswordField campoContraseña;
    private JButton botonLogin;
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;
    private JLabel etiquetaUsuario;
    private JPanel panel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel;

    public LoginForm() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/img/OIP.jpg")));
    	
        setTitle("Produccion");
        setSize(680, 401);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(64, 224, 208));
        getContentPane().add(panel);
        panel.setLayout(null);
        
        panel_1 = new JPanel();
        panel_1.setBounds(306, 0, 358, 362);
        panel_1.setForeground(new Color(255, 255, 255));
        panel_1.setBackground(new Color(255, 255, 255));
        panel.add(panel_1);
                panel_1.setLayout(null);
        
                etiquetaUsuario = new JLabel("USUARIO:");
                etiquetaUsuario.setBounds(10, 170, 110, 21);
                panel_1.add(etiquetaUsuario);
                etiquetaUsuario.setFont(new Font("TangoSans", Font.BOLD, 18));
                etiquetaUsuario.setForeground(new Color(0, 0, 0));
                lblNewLabel_1 = new JLabel("PRODUCCION");
                lblNewLabel_1.setBounds(70, 123, 276, 36);
                panel_1.add(lblNewLabel_1);
                lblNewLabel_1.setForeground(Color.RED);
                lblNewLabel_1.setFont(new Font("Roboto Bk", Font.BOLD, 30));
                JLabel etiquetaPassword = new JLabel("CONTRASEÑA:");
                etiquetaPassword.setBackground(new Color(0, 255, 0));
                etiquetaPassword.setBounds(10, 211, 149, 30);
                panel_1.add(etiquetaPassword);
                etiquetaPassword.setFont(new Font("TangoSans", Font.BOLD, 18));
                etiquetaPassword.setForeground(new Color(0, 0, 0));
                botonLogin = new JButton("INICIAR SESION");
                botonLogin.setForeground(new Color(255, 255, 255));
                botonLogin.setBackground(new Color(255, 69, 0));
                botonLogin.setBounds(175, 252, 140, 29);
                panel_1.add(botonLogin);
                botonLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
                campoContraseña = new JPasswordField(10);
                campoContraseña.setBounds(175, 219, 140, 20);
                panel_1.add(campoContraseña);
                campoUsuario = new JTextField(10);
                campoUsuario.setBounds(175, 173, 140, 20);
                panel_1.add(campoUsuario);
                
                btnNewButton = new JButton("SALIR");
                btnNewButton.setBounds(175, 299, 140, 29);
                panel_1.add(btnNewButton);
                btnNewButton.setForeground(new Color(255, 255, 255));
                btnNewButton.setBackground(new Color(255, 0, 0));
                btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
                
                lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2.setIcon(new ImageIcon(LoginForm.class.getResource("/img/OIP.jpg")));
                lblNewLabel_2.setBounds(117, 11, 174, 114);
                panel_1.add(lblNewLabel_2);
                
                lblNewLabel = new JLabel("");
                lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 6));
                lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/img/tuberia.jpg")));
                lblNewLabel.setBounds(0, 0, 308, 362);
                panel.add(lblNewLabel);
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		System.exit(0);
                	}
                });
                botonLogin.addActionListener(this);
    }

     public void actionPerformed(ActionEvent e) {
        char[] contraseña = campoContraseña.getPassword();
        String claveFinal = new String(contraseña);

        if (validarCredenciales(campoUsuario.getText(), claveFinal)) {
            dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Produccion", "Ingresaste", JOptionPane.INFORMATION_MESSAGE);
            MenuPrincipal a = new MenuPrincipal();
            a.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Escriba correctamente el usuario o contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            campoUsuario.setText("");
            campoContraseña.setText("");
            campoUsuario.requestFocus();
        }
    }

    private boolean validarCredenciales(String usuario, String contraseña) {
        try (Connection conn = MySQLConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND contraseña = ?")) {
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.setVisible(true);
    }
}