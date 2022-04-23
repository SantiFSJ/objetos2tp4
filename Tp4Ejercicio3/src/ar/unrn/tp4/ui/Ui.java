package ar.unrn.tp4.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp4.modelo.Concurso;
import ar.unrn.tp4.modelo.Inscripto;
import ar.unrn.tp4.modelo.LectorConcursos;
import ar.unrn.tp4.modelo.RepositorioInscriptos;

public class Ui {
	private JPanel contentPane;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JComboBox<String> comboBox;
	private JButton btnOk;
	private JLabel lblCompetition;

	private ArrayList<Concurso> concursosAbiertos = new ArrayList<>();

	private LectorConcursos lector;
	private String archivoConcursos;
	private RepositorioInscriptos repoInscriptos;

	public Ui(LectorConcursos lector, String archivoConcursos, RepositorioInscriptos repoInscriptos) {

		this.lector = lector;
		this.archivoConcursos = archivoConcursos;
		this.repoInscriptos = repoInscriptos;

		var frame = new JFrame("Inscription to Competition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 451, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formElements();
		layout();
		frame.setVisible(true);
	}

	private void formElements() {
		lblName = new JLabel("Nombre:");
		txtName = new JTextField();
		txtName.setColumns(10);
		lblLastName = new JLabel("Apellido:");
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		lblId = new JLabel("Dni:");
		txtId = new JTextField();
		txtId.setColumns(10);
		lblPhone = new JLabel("Telefono:");
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		lblEmail = new JLabel("Email:");
		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		lblCompetition = new JLabel("Concurso:");
		comboBox = new JComboBox<String>();
		todosLosConcursos();

		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOk.setEnabled(false);
				saveInscription();
				btnOk.setEnabled(true);
			}
		});

	}

	private void todosLosConcursos() {
		// carga del archivo de texto concursos.txt los concursos
		ArrayList<Concurso> concursos = new ArrayList<>();

		try {
			concursos = lector.leerConcuros(this.archivoConcursos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Concurso c : concursos) {
			if (c.estaAbierto()) {
				this.comboBox.addItem(c.nombre());
				this.concursosAbiertos.add(c);
			}
		}

	}

	private void saveInscription() {
		if (validations()) {

			ArrayList<Concurso> concursos = new ArrayList<>();

			try {
				concursos = lector.leerConcuros(this.archivoConcursos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (Concurso c : concursos) {
				if (c.estaAbierto())
					;

			}

			Concurso c = concursosAbiertos.get(comboBox.getSelectedIndex());

			Inscripto temp = new Inscripto(txtName.getText(), txtLastName.getText(), txtPhone.getText(),
					txtEmail.getText());
			repoInscriptos.guardarInscripto(temp, c.id());
		}
	}

	private boolean validations() {
		if ("".equals(txtName.getText())) {
			JOptionPane.showMessageDialog(this.contentPane, "Nombre no puede ser vacio");
			return false;
		}
		if ("".equals(txtLastName.getText())) {
			JOptionPane.showMessageDialog(this.contentPane, "apellido no puede ser vacio");
			return false;
		}
		if ("".equals(txtId.getText())) {
			JOptionPane.showMessageDialog(this.contentPane, "dni no puede ser vacio");
			return false;
		}
		if (!checkEmail(txtEmail.getText())) {
			JOptionPane.showMessageDialog(this.contentPane, "email debe ser v�lido");
			return false;
		}
		if (!checkPhone(txtPhone.getText())) {
			JOptionPane.showMessageDialog(this.contentPane,
					"El tel�fono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
			return false;
		}
		if (this.comboBox.getSelectedIndex() < 0) {
			JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
			return false;
		}
		return true;
	}

	private boolean checkEmail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	private boolean checkPhone(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

	private void layout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblLastName)
								.addComponent(lblId).addComponent(lblPhone).addComponent(lblEmail).addComponent(lblName)
								.addComponent(lblCompetition))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtEmail, Alignment.TRAILING).addComponent(txtPhone, Alignment.TRAILING)
								.addComponent(txtId, Alignment.TRAILING).addComponent(txtLastName, Alignment.TRAILING)
								.addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298,
										Short.MAX_VALUE)))
						.addComponent(btnOk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblLastName).addComponent(
						txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblId).addComponent(txtId,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblEmail))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCompetition))))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOk).addContainerGap(67, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
