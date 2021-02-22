import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmCadastroImoveis extends JFrame {

	JLabel L0, L1, L2, L3, L4, L5, L6, L7, L8, L10, L11, L12;
	JButton b1, b2, b3, b4, b5;
	JTextField tfCodigo, tfTipo, tfBairro, tfArea, tfNumeroQuartos, tfNumeroBanheiros, tfPreco, tfGaragens;
	JPanel p1 = new JPanel();

	private RepositorioImovel repositorioImovel = new RepositorioImovel(10);

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		JFrame Janela = new FrmCadastroImoveis();
		Janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		Janela.setVisible(true);
	}

	public FrmCadastroImoveis() {

		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setSize(new Dimension(600, 120));
		L0 = new JLabel("           Cadastro de Imóveis           ");
		L0.setFont(new Font("Monotype Corsiva", Font.ITALIC + Font.BOLD, 36));
		L0.setForeground(Color.RED);

		L1 = new JLabel("Código:     ");
		L2 = new JLabel("Tipo imóvel: ");
		L3 = new JLabel("Bairro: ");
		L4 = new JLabel("Área:(m2) ");
		L5 = new JLabel("Número de quartos: ");
		L6 = new JLabel("Número de banheiros: ");
		L7 = new JLabel(" ");
		for (int i = 0; i < 180; i++)
			L7.setText(L7.getText() + " ");
		L8 = new JLabel(" ");
		for (int i = 0; i < 30; i++)
			L8.setText(L8.getText() + " ");
		L10 = new JLabel(" ");

		for (int i = 0; i < 200; i++)
			L10.setText(L10.getText() + " ");
		L11 = new JLabel("Preço imóvel: ");
		L12 = new JLabel("Garagens:");
		tfCodigo = new JTextField(8);
		tfTipo = new JTextField(10);
		tfBairro = new JTextField(15);
		tfArea = new JTextField(8);
		tfNumeroQuartos = new JTextField(6);
		tfNumeroBanheiros = new JTextField(7);
		tfPreco = new JTextField(9);
		tfGaragens = new JTextField(8);
		b1 = new JButton("Inserir");
		b2 = new JButton("Consultar");
		b3 = new JButton("Alterar");
		b4 = new JButton("Remover");
		b5 = new JButton("Limpar");
		b1.setBackground(new Color(180, 180, 250));
		b2.setBackground(new Color(180, 180, 250));
		b3.setBackground(new Color(180, 180, 250));
		b4.setBackground(new Color(180, 180, 250));
		b5.setBackground(new Color(180, 180, 250));
		p1.add(L0);
		p1.add(L10);
		p1.add(L1);
		p1.add(tfCodigo);
		p1.add(L2);
		p1.add(tfTipo);
		p1.add(L3);
		p1.add(tfBairro);
		p1.add(L4);
		p1.add(tfArea);
		p1.add(L5);
		p1.add(tfNumeroQuartos);
		p1.add(L6);
		p1.add(this.tfNumeroBanheiros);
		p1.add(L12);
		p1.add(tfGaragens);
		p1.add(L11);
		p1.add(tfPreco);
		p1.add(L7);
		p1.add(L8);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		getContentPane().add(p1);
		setTitle("Tabajara Imobiliária 0.01");

		setSize(630, 280);

		// Fazendo os botões funcionarem

		// Botão Inserir

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Imoveis imovel = new Imoveis();

				try {
					imovel.setCodigo(tfCodigo.getText());
					imovel.setTipoImoveis(tfTipo.getText());
					imovel.setBairro(tfBairro.getText());
					imovel.setArea(Double.parseDouble(tfArea.getText()));
					imovel.setNumeroQuartos(Integer.parseInt(tfNumeroQuartos.getText()));
					imovel.setNumroDeBanheiros(Integer.parseInt(tfNumeroBanheiros.getText()));
					imovel.setGaragens(Integer.parseInt(tfGaragens.getText()));
					imovel.setPrecoImoveis(Double.parseDouble(tfPreco.getText()));

					FrmCadastroImoveis.this.repositorioImovel.inserir(imovel);

					tfCodigo.setText("");
					tfTipo.setText("");
					tfBairro.setText("");
					tfArea.setText("");
					tfNumeroQuartos.setText("");
					tfNumeroBanheiros.setText("");
					tfGaragens.setText("");
					tfPreco.setText("");
					
					JOptionPane.showMessageDialog(null, "O imóvel foi adicionado!");

				} catch (Exception f) {
					if (tfCodigo.getText().isEmpty()) {
					}if (tfTipo.getText().isEmpty()) { 
					}if (tfBairro.getText().isEmpty()) {
					}if (tfArea.getText().isEmpty()) {
					}if (tfNumeroQuartos.getText().isEmpty()) {
					}if (tfNumeroBanheiros.getText().isEmpty()) {
					}if (tfGaragens.getText().isEmpty()) {
					}if (tfPreco.getText().isEmpty()) {
					}JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
					

					for (char c : tfCodigo.getText().toCharArray()) {
						if (!Character.isDigit(c)) {
							JOptionPane.showMessageDialog(null, "O campo Código aceita apenas números!");

							for (char a : tfArea.getText().toCharArray()) {
								if (!Character.isDigit(a)) {
									JOptionPane.showMessageDialog(null, "O campo Área aceita apenas números!");

									for (char b : tfPreco.getText().toCharArray()) {
										if (!Character.isDigit(b)) {
											JOptionPane.showMessageDialog(null, "O campo Preço aceita apenas números!");

										}
									}
								}
							}
						}
					} 
				}finally{
					imovel.setCodigo(tfCodigo.getText());
					imovel.setTipoImoveis(tfTipo.getText());
					imovel.setBairro(tfBairro.getText());
					imovel.setArea(Double.parseDouble(tfArea.getText()));
					imovel.setNumeroQuartos(Integer.parseInt(tfNumeroQuartos.getText()));
					imovel.setNumroDeBanheiros(Integer.parseInt(tfNumeroBanheiros.getText()));
					imovel.setGaragens(Integer.parseInt(tfGaragens.getText()));
					imovel.setPrecoImoveis(Double.parseDouble(tfPreco.getText()));

					FrmCadastroImoveis.this.repositorioImovel.inserir(imovel);
				}
				
				
			}
		});

		// Botão Consultar

		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Imoveis imovel = null;

				String codigo = tfCodigo.getText();

				if (codigo == null || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O código do imóvel é de preenchimento obrigatório!");
					return;
				}

				imovel = FrmCadastroImoveis.this.repositorioImovel.procurar(codigo);

				if (imovel == null) {
					JOptionPane.showMessageDialog(null, "O imóvel não foi encontrado!");
					return;
				}

				tfCodigo.setText(imovel.getCodigo());
				tfTipo.setText(imovel.getTipoImoveis());
				tfBairro.setText(imovel.getBairro());
				tfArea.setText(String.valueOf(imovel.getArea()));
				tfNumeroQuartos.setText(String.valueOf(imovel.getNumeroQuartos()));
				tfNumeroBanheiros.setText(String.valueOf(imovel.getNumroDeBanheiros()));
				tfGaragens.setText(String.valueOf(imovel.getGaragens()));
				tfPreco.setText(String.valueOf(imovel.getPrecoImoveis()));

			}
		});

		// Botão Alterar

		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Imoveis imovel = null;

				String codigo = tfCodigo.getText();

				if (codigo == null || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O código do imóvel é de preenchimento obrigatório!");
					return;
				}

				imovel = FrmCadastroImoveis.this.repositorioImovel.procurar(codigo);

				if (imovel == null) {
					JOptionPane.showMessageDialog(null, "O imóvel não foi encontrado!");
					return;
				}

				imovel.setCodigo(tfCodigo.getText());
				imovel.setTipoImoveis(tfTipo.getText());
				imovel.setBairro(tfBairro.getText());
				imovel.setArea(Double.parseDouble(tfArea.getText()));
				imovel.setNumeroQuartos(Integer.parseInt(tfNumeroQuartos.getText()));
				imovel.setNumroDeBanheiros(Integer.parseInt(tfNumeroBanheiros.getText()));
				imovel.setGaragens(Integer.parseInt(tfGaragens.getText()));
				imovel.setPrecoImoveis(Double.parseDouble(tfPreco.getText()));

				tfCodigo.setText("");
				tfTipo.setText("");
				tfBairro.setText("");
				tfArea.setText("");
				tfNumeroQuartos.setText("");
				tfNumeroBanheiros.setText("");
				tfGaragens.setText("");
				tfPreco.setText("");

				JOptionPane.showMessageDialog(null, "O imóvel foi atualizado!");
			}
		});

		// Botão remover

		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Imoveis imovel = null;

				String codigo = tfCodigo.getText();

				if (codigo == null || codigo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O código do imóvel é de preenchimento obrigatório!");
					return;
				}

				imovel = FrmCadastroImoveis.this.repositorioImovel.procurar(codigo);

				if (imovel == null) {
					JOptionPane.showMessageDialog(null, "O imóvel não foi encontrado!");
					return;
				}

				FrmCadastroImoveis.this.repositorioImovel.remover(codigo);

				tfCodigo.setText("");
				tfTipo.setText("");
				tfBairro.setText("");
				tfArea.setText("");
				tfNumeroQuartos.setText("");
				tfNumeroBanheiros.setText("");
				tfGaragens.setText("");
				tfPreco.setText("");

				JOptionPane.showMessageDialog(null, "O imóvel foi removido!");
			}
		});

		// Botão limpar

		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				tfCodigo.setText("");
				tfTipo.setText("");
				tfBairro.setText("");
				tfArea.setText("");
				tfNumeroQuartos.setText("");
				tfNumeroBanheiros.setText("");
				tfGaragens.setText("");
				tfPreco.setText("");

			}
		});

	}

}
