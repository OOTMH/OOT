package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private JLabel lblIvanovic;
	private JLabel lblMatic;
	private JLabel lblKolarov;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JTextField txtUnos;
	private JCheckBox chckbxUnesiIgraca;
	private JComboBox cbxIgraci;
	private JList lstIgraci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNaslov = new JLabel("Naslov");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNaslov, BorderLayout.NORTH);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		JButton btnIspis = new JButton("Ispisi");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)");
			}
		});
		pnlJug.add(btnIspis);
		
		JButton btnDijalogIgrac = new JButton("Dijalog igrac");
		btnDijalogIgrac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlgIgrac = new DlgIgrac();
				dlgIgrac.setVisible(true);
				if(dlgIgrac.isOk)
					dlm.addElement(dlgIgrac.txtIme.getText()+" "+dlgIgrac.txtPrezime.getText());
				System.out.println("prosao");
			}
		});
		pnlJug.add(btnDijalogIgrac);
		
		JButton btnModifikacija = new JButton("Modifikacija");
		btnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlgModifikacija = new DlgIgrac();
				String[] split = dlm.getElementAt(lstIgraci.getSelectedIndex()).toString().split(" ");
				dlgModifikacija.txtIme.setText(split[0]);
				dlgModifikacija.txtPrezime.setText(split[1]);
				dlgModifikacija.setVisible(true);
			}
		});
		pnlJug.add(btnModifikacija);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(Color.PINK);
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JPopupMenu popMnuDodavanje = new JPopupMenu();
		addPopup(pnlCentar, popMnuDodavanje);
		
		JMenuItem mntmDodajIgraca = new JMenuItem("Dodaj igraca u listu");
		mntmDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlm.addElement(cbxIgraci.getSelectedItem().toString());
			}
		});
		popMnuDodavanje.add(mntmDodajIgraca);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JToggleButton tglbtnIvanovic = new JToggleButton("Ivanovic");
		tglbtnIvanovic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(tglbtnIvanovic.isSelected()) {
					lblIvanovic.setForeground(Color.BLUE);
					dlm.addElement(lblIvanovic.getText());
				}else {
					lblIvanovic.setForeground(Color.BLACK);
				}
			}
		});
		buttonGroup.add(tglbtnIvanovic);
		/*tglbtnIvanovic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});*/
		GridBagConstraints gbc_tglbtnIvanovic = new GridBagConstraints();
		gbc_tglbtnIvanovic.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnIvanovic.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnIvanovic.gridx = 0;
		gbc_tglbtnIvanovic.gridy = 0;
		pnlCentar.add(tglbtnIvanovic, gbc_tglbtnIvanovic);
		
		lblIvanovic = new JLabel("Branislav Ivanovic");
		GridBagConstraints gbc_lblIvanovic = new GridBagConstraints();
		gbc_lblIvanovic.insets = new Insets(0, 0, 5, 5);
		gbc_lblIvanovic.gridx = 1;
		gbc_lblIvanovic.gridy = 0;
		pnlCentar.add(lblIvanovic, gbc_lblIvanovic);
		
		JToggleButton tglbtnMatic = new JToggleButton("Matic");
		buttonGroup.add(tglbtnMatic);
		tglbtnMatic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(tglbtnMatic.isSelected()) {
					lblMatic.setForeground(Color.BLUE);
					dlm.addElement(lblMatic.getText());
				}else {
					lblMatic.setForeground(Color.BLACK);
				}
			}
		});
		
		JScrollPane scrlPaneIgraci = new JScrollPane();
		GridBagConstraints gbc_scrlPaneIgraci = new GridBagConstraints();
		gbc_scrlPaneIgraci.fill = GridBagConstraints.BOTH;
		gbc_scrlPaneIgraci.gridheight = 3;
		gbc_scrlPaneIgraci.insets = new Insets(0, 0, 5, 0);
		gbc_scrlPaneIgraci.gridx = 2;
		gbc_scrlPaneIgraci.gridy = 0;
		pnlCentar.add(scrlPaneIgraci, gbc_scrlPaneIgraci);
		
		lstIgraci = new JList();
		scrlPaneIgraci.setViewportView(lstIgraci);
		lstIgraci.setModel(dlm);
		GridBagConstraints gbc_tglbtnMatic = new GridBagConstraints();
		gbc_tglbtnMatic.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnMatic.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnMatic.anchor = GridBagConstraints.NORTH;
		gbc_tglbtnMatic.gridx = 0;
		gbc_tglbtnMatic.gridy = 1;
		pnlCentar.add(tglbtnMatic, gbc_tglbtnMatic);
		
		lblMatic = new JLabel("Nemanja Matic");
		GridBagConstraints gbc_lblMatic = new GridBagConstraints();
		gbc_lblMatic.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatic.gridx = 1;
		gbc_lblMatic.gridy = 1;
		pnlCentar.add(lblMatic, gbc_lblMatic);
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		buttonGroup.add(tglbtnKolarov);
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(tglbtnKolarov.isSelected()) {
					lblKolarov.setForeground(Color.BLUE);
					dlm.addElement(lblKolarov.getText());
				}else {
					lblKolarov.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnKolarov = new GridBagConstraints();
		gbc_tglbtnKolarov.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKolarov.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKolarov.gridx = 0;
		gbc_tglbtnKolarov.gridy = 2;
		pnlCentar.add(tglbtnKolarov, gbc_tglbtnKolarov);
		
		lblKolarov = new JLabel("Aleksandar Kolarov");
		GridBagConstraints gbc_lblKolarov = new GridBagConstraints();
		gbc_lblKolarov.insets = new Insets(0, 0, 5, 5);
		gbc_lblKolarov.gridx = 1;
		gbc_lblKolarov.gridy = 2;
		pnlCentar.add(lblKolarov, gbc_lblKolarov);
		
		txtUnos = new JTextField();
		txtUnos.setEnabled(false);
		txtUnos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnos.getText());
					txtUnos.setText("");
				}
			}
		});
		
		chckbxUnesiIgraca = new JCheckBox("Unesi igraca");
		chckbxUnesiIgraca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				/*if(chckbxUnesiIgraca.isSelected())
					txtUnos.setEnabled(true);
				else
					txtUnos.setEnabled(false);*/
				txtUnos.setEnabled(chckbxUnesiIgraca.isSelected());
			}
		});
		GridBagConstraints gbc_chckbxUnesiIgraca = new GridBagConstraints();
		gbc_chckbxUnesiIgraca.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxUnesiIgraca.gridx = 0;
		gbc_chckbxUnesiIgraca.gridy = 3;
		pnlCentar.add(chckbxUnesiIgraca, gbc_chckbxUnesiIgraca);
		GridBagConstraints gbc_txtUnos = new GridBagConstraints();
		gbc_txtUnos.insets = new Insets(0, 0, 5, 5);
		gbc_txtUnos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnos.gridx = 1;
		gbc_txtUnos.gridy = 3;
		pnlCentar.add(txtUnos, gbc_txtUnos);
		txtUnos.setColumns(10);
		
		JLabel lblIgraci = new JLabel("Igraci");
		GridBagConstraints gbc_lblIgraci = new GridBagConstraints();
		gbc_lblIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_lblIgraci.gridx = 0;
		gbc_lblIgraci.gridy = 4;
		pnlCentar.add(lblIgraci, gbc_lblIgraci);
		
		cbxIgraci = new JComboBox();
		cbxIgraci.setModel(new DefaultComboBoxModel(new String[] {"Tirke", "Mosa", "Bek"}));
		cbxIgraci.setSelectedIndex(1);
		GridBagConstraints gbc_cbxIgraci = new GridBagConstraints();
		gbc_cbxIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_cbxIgraci.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxIgraci.gridx = 1;
		gbc_cbxIgraci.gridy = 4;
		pnlCentar.add(cbxIgraci, gbc_cbxIgraci);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
