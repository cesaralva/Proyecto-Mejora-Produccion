package menu;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gui.ayuda;
import produccion.InsertarDato;
import produccion.MainFrame;
import produccion.ModificarDato;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

public class MenuPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu btnArchivo;
	private JMenu btnMantenimiento;
	private JMenuItem btnConsultar;
	private JMenuItem btnModificar;
	private JMenuItem btnListar;
	private JMenu btnConfiguracion;
	private JMenu btnAlmacen;
	private JMenuItem btnConfiDescuento;
	private JMenuItem btnConfiObsequio;
	private JMenuItem btnConfiCantOptima;
	private JMenuItem btnConfiCuotaDiaria;
	private JMenuItem btnVender;
	private JMenuItem btnGenerarReportes;
	private JMenu btnAyuda;
	private JMenuItem btnAcercaTienda;
	public static ayuda formAyuda;

	public static InsertarDato formInsertarDato;
	public static MainFrame formMainFrame;

	private JDesktopPane desktopPane;
	private JMenuItem btnExit;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);

					// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/img/entrega.png")));
		setBounds(100, 100, 928, 583);
		this.setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		btnArchivo = new JMenu("Archivo");
		btnArchivo.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/icons8-página-principal-16.png")));
		menuBar.add(btnArchivo);

		btnExit = new JMenuItem("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnExit(e);
			}
		});
		btnArchivo.add(btnExit);

		JMenu btnProduccion = new JMenu("Produccion");
		btnProduccion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/produccion.png")));
		menuBar.add(btnProduccion);

		JMenuItem btnModificarStock = new JMenuItem("Modificar datos");
		btnModificarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnModificarStock(e);
			}
		});

		JMenuItem btnIngresarStock = new JMenuItem("Ingresar datos");
		btnIngresarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnIngresarStock(e);
			}
		});
		btnProduccion.add(btnIngresarStock);
		btnProduccion.add(btnModificarStock);

		JMenuItem btnListarStock = new JMenuItem("Listar de Stock");
		btnListarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListarStock(e);
			}
		});
		btnProduccion.add(btnListarStock);

		btnMantenimiento = new JMenu("Mantenimiento");
		btnMantenimiento.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(btnMantenimiento);

		btnConsultar = new JMenuItem("Consultar ");
		btnConsultar.addActionListener(this);

		btnMantenimiento.add(btnConsultar);

		btnModificar = new JMenuItem("Modificar ");
		btnModificar.addActionListener(this);
		btnMantenimiento.add(btnModificar);

		btnListar = new JMenuItem("Listar ");
		btnListar.addActionListener(this);

		btnMantenimiento.add(btnListar);

		btnAlmacen = new JMenu("Armacen");
		btnAlmacen.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/venta.png")));
		menuBar.add(btnAlmacen);

		btnVender = new JMenuItem("Kardex");
		btnVender.addActionListener(this);
		btnAlmacen.add(btnVender);

		btnGenerarReportes = new JMenuItem("Generar Reportes");
		btnGenerarReportes.addActionListener(this);
		btnAlmacen.add(btnGenerarReportes);

		btnConfiguracion = new JMenu("Configuración");
		btnConfiguracion.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/confguracion.png")));
		menuBar.add(btnConfiguracion);

		btnConfiDescuento = new JMenuItem("Configurar descuentos");
		btnConfiDescuento.addActionListener(this);
		btnConfiguracion.add(btnConfiDescuento);

		btnConfiObsequio = new JMenuItem("Configurar obsequios");
		btnConfiObsequio.addActionListener(this);
		btnConfiguracion.add(btnConfiObsequio);

		btnConfiCantOptima = new JMenuItem("Configurar cantidad óptima");
		btnConfiCantOptima.addActionListener(this);
		btnConfiguracion.add(btnConfiCantOptima);

		btnConfiCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		btnConfiCuotaDiaria.addActionListener(this);
		btnConfiguracion.add(btnConfiCuotaDiaria);

		btnAyuda = new JMenu("Ayuda");
		btnAyuda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/Help.png")));
		menuBar.add(btnAyuda);

		btnAcercaTienda = new JMenuItem("Acerca del Producto");
		btnAcercaTienda.addActionListener(this);
		btnAyuda.add(btnAcercaTienda);

		desktopPane = new JDesktopPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
		);
		desktopPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/img/My project-1 (2).png")));
		desktopPane.add(lblNewLabel);
		getContentPane().setLayout(groupLayout);

	}

	protected void actionPerformedBtnModificarStock(ActionEvent e) {
		ModificarDato modificarDatoFrame = new ModificarDato();
		modificarDatoFrame.setVisible(true);
	}

	protected void actionPerformedBtnExit(ActionEvent e) {
		int resp = javax.swing.JOptionPane.showConfirmDialog(null, "¿Desea salir, seguro que guardaste?", null,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (resp == 0) {

			System.exit(0);

		}
	}

	protected void actionPerformedBtnListarStock(ActionEvent e) {
		if (formMainFrame == null || formMainFrame.isClosed()) {
			formMainFrame = new MainFrame();
			desktopPane.add(formMainFrame);
			formMainFrame.show();
		}
	}

	public void actionPerformed(ActionEvent e) {
		actionPerformedBtnAcercaTienda(e);
	}

	protected void actionPerformedBtnAcercaTienda(ActionEvent e) {
		if (formAyuda == null || formAyuda.isClosed()) {
			formAyuda = new ayuda();
			desktopPane.add(formAyuda);
			formAyuda.show();
		}

	}

	protected void actionPerformedBtnIngresarStock(ActionEvent e) {
		InsertarDato insertarDatoFrame = new InsertarDato();
		insertarDatoFrame.setVisible(true);

	}
}