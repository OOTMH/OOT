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

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private JLabel lblIvanovic;
	private JLabel lblMatic;
	private JLabel lblKolarov;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();

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
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(Color.PINK);
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);
		
		JToggleButton tglbtnIvanovic = new JToggleButton("Ivanovic");
		tglbtnIvanovic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(tglbtnIvanovic.isSelected()) {
					lblKolarov.setForeground(Color.BLACK);
					lblIvanovic.setForeground(Color.BLUE);
					lblMatic.setForeground(Color.BLACK);
					dlm.addElement(lblIvanovic.getText());
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
		tglbtnMatic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(lblMatic.getText());
				if(tglbtnMatic.isSelected()){
					lblKolarov.setForeground(Color.BLACK);
					lblIvanovic.setForeground(Color.BLACK);
					lblMatic.setForeground(Color.BLUE);
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
		
		JList lstIgraci = new JList();
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
		tglbtnKolarov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnKolarov.isSelected()) {
					lblKolarov.setForeground(Color.BLUE);
					lblIvanovic.setForeground(Color.BLACK);
					lblMatic.setForeground(Color.BLACK);
				}
			}
		});
		GridBagConstraints gbc_tglbtnKolarov = new GridBagConstraints();
		gbc_tglbtnKolarov.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnKolarov.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnKolarov.gridx = 0;
		gbc_tglbtnKolarov.gridy = 2;
		pnlCentar.add(tglbtnKolarov, gbc_tglbtnKolarov);
		
		lblKolarov = new JLabel("Aleksandar Kolarov");
		GridBagConstraints gbc_lblKolarov = new GridBagConstraints();
		gbc_lblKolarov.insets = new Insets(0, 0, 0, 5);
		gbc_lblKolarov.gridx = 1;
		gbc_lblKolarov.gridy = 2;
		pnlCentar.add(lblKolarov, gbc_lblKolarov);
	}

}
