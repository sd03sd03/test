package day22;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;



import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JTextField tfname;
	private JLabel lblNewLabel;
	private JLabel label;
	private JTextField tfbirth;
	private JLabel label_1;
	private JTextField tftel;
	private JLabel label_2;
	private JTextField tfaddr;
	private JButton btup;
	private JButton btvi;
	private JPanel panel_1;
	private JTextField tfsearch;
	private JTextArea textArea;
	private JButton btsearch;
	private JComboBox comboBox;
	
	TestDBA dba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setLeftComponent(getPanel());
			splitPane.setDividerLocation(300);
		}
		return splitPane;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getTextArea());
			splitPane_1.setDividerLocation(300);
		}
		return splitPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0)), "개인정보등록", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getTfname());
			panel.add(getLblNewLabel());
			panel.add(getLabel());
			panel.add(getTfbirth());
			panel.add(getLabel_1());
			panel.add(getTftel());
			panel.add(getLabel_2());
			panel.add(getTfaddr());
			panel.add(getBtup());
			panel.add(getBtvi());
		}
		return panel;
	}
	private JTextField getTfname() {
		if (tfname == null) {
			tfname = new JTextField();
			tfname.setBounds(81, 43, 179, 21);
			tfname.setColumns(10);
		}
		return tfname;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이름");
			lblNewLabel.setBounds(12, 43, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("생일");
			label.setBounds(12, 93, 57, 15);
		}
		return label;
	}
	private JTextField getTfbirth() {
		if (tfbirth == null) {
			tfbirth = new JTextField();
			tfbirth.setColumns(10);
			tfbirth.setBounds(81, 93, 179, 21);
		}
		return tfbirth;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("전화번호");
			label_1.setBounds(12, 145, 57, 15);
		}
		return label_1;
	}
	private JTextField getTftel() {
		if (tftel == null) {
			tftel = new JTextField();
			tftel.setColumns(10);
			tftel.setBounds(81, 145, 179, 21);
		}
		return tftel;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("주소");
			label_2.setBounds(12, 208, 57, 15);
		}
		return label_2;
	}
	private JTextField getTfaddr() {
		if (tfaddr == null) {
			tfaddr = new JTextField();
			tfaddr.setColumns(10);
			tfaddr.setBounds(81, 208, 179, 21);
		}
		return tfaddr;
	}
	private JButton getBtup() {
		if (btup == null) {
			btup = new JButton("추가");
			btup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					   TestBean b = new TestBean();
					   b.setName(tfname.getText());
		               b.setBirth(Integer.parseInt(tfbirth.getText()));
		               b.setTel(Integer.parseInt(tftel.getText()));
		               b.setAddr(tfaddr.getText());
		               dba.testInsert(b);
				}
			});
			btup.setBounds(37, 298, 97, 23);
		}
		return btup;
	}
	private JButton getBtvi() {
		if (btvi == null) {
			btvi = new JButton("전체보기");
			btvi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<TestBean>	arr = dba.bookView();
					for(TestBean f:arr) {
						textArea.append("이름 "+f.getName()+"\n");
						textArea.append("생일 "+f.getBirth()+"\n");
						textArea.append("전화번호 "+f.getTel()+"\n");
						textArea.append("주소 "+f.getAddr()+"\n");
						
						
						tfname.setText(f.getName());
						tfbirth.setText(f.getBirth()+"");
						tftel.setText(f.getTel()+"");
						tfaddr.setText(f.getAddr());
					}
					
				}

				

				
			});
			btvi.setBounds(165, 298, 97, 23);
		}
		return btvi;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getTfsearch());
			panel_1.add(getBtsearch());
			panel_1.add(getComboBox());
		}
		return panel_1;
	}
	private JTextField getTfsearch() {
		if (tfsearch == null) {
			tfsearch = new JTextField();
			tfsearch.setBounds(77, 10, 142, 21);
			tfsearch.setColumns(10);
		}
		return tfsearch;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new TitledBorder(null, "전체보기", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return textArea;
	}
	private JButton getBtsearch() {
		if (btsearch == null) {
			btsearch = new JButton("찾기");
			btsearch.setBounds(231, 9, 71, 23);
		}
		return btsearch;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"선택"}));
			comboBox.setBounds(12, 10, 53, 21);
		}
		return comboBox;
	}
}
