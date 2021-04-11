package Matrix;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatrixJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField JTextA;
	private JTextField JTextB;
	private JTextField JTextC;
	private JTextField FileInputJText;
	private JTextField ColumnJText;
	private JTextField RowJText;

	/**
	 * Launch the application.
	 */
	private MaTran matran1,matran2;
	private JLabel PhepTinhLbl;
	/**
	 * Create the frame.
	 */
	public MatrixJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextA = new JTextField();
		JTextA.setBorder(new LineBorder(Color.BLACK));
		JTextA.setEditable(false);
		JTextA.setBounds(10, 175, 194, 105);
		contentPane.add(JTextA);
		JTextA.setColumns(10);
		
		JTextB = new JTextField();
		JTextB.setBorder(new LineBorder(Color.BLACK));
		JTextB.setEditable(false);
		JTextB.setColumns(10);
		JTextB.setBounds(237, 175, 194, 105);
		contentPane.add(JTextB);
		
		JTextC = new JTextField();
		JTextC.setBorder(new LineBorder(Color.BLACK));
		JTextC.setEditable(false);
		JTextC.setColumns(10);
		JTextC.setBounds(475, 175, 194, 105);
		contentPane.add(JTextC);
		
		PhepTinhLbl = new JLabel("");
		PhepTinhLbl.setBounds(190, 220, 46, 14);
		contentPane.add(PhepTinhLbl);
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setBounds(449, 211, 46, 33);
		contentPane.add(lblNewLabel);
		
		FileInputJText = new JTextField();
		FileInputJText.setBounds(237, 11, 194, 20);
		contentPane.add(FileInputJText);
		FileInputJText.setColumns(10);
		
		ColumnJText = new JTextField();
		ColumnJText.setBounds(237, 56, 194, 20);
		contentPane.add(ColumnJText);
		ColumnJText.setColumns(10);
		
		RowJText = new JTextField();
		RowJText.setBounds(237, 107, 194, 20);
		contentPane.add(RowJText);
		RowJText.setColumns(10);
		
		JButton GetFileButton = new JButton("Get info");
		GetFileButton.addActionListener(new ActionListener() {//Khai báo 2 ma trận và ép kiểu string => integer
			public void actionPerformed(ActionEvent e) {
				try{
			         matran1 = new MaTran(Integer.parseInt(ColumnJText.getText()), Integer.parseInt(ColumnJText.getText()));//khai báo và ép kiểu ma trận 1
			         matran2 = new MaTran(Integer.parseInt(RowJText.getText()), Integer.parseInt(RowJText.getText()));//khai báo và ép kiểu ma trận 2
			         JTextA.setText(matran1.toString()); //hiện thị ma trận 1 khung A
			         JTextB.setText(matran2.toString());// hiện thị ma trận 2 khung B
			        }catch(NumberFormatException a){
			            JOptionPane.showMessageDialog(null, "Số hàng và số cột phải là số nguyên. Vui lòng nhập lại"); //pop up thông báo
			        }
			}
		});
		GetFileButton.setBounds(504, 55, 89, 23);
		contentPane.add(GetFileButton);
		GetFileButton.setToolTipText("Click to get file!");
		
		JButton SumButton = new JButton("Sum");
		SumButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(!JTextA.getText().equals("") && !JTextB.getText().equals("")) //If(Khung ma trận A và khung ma trận B khác rỗng)
				 { 	
					   PhepTinhLbl.setText("+");									// Đổi chữ "phép tính" thành dấu "+"
			           MaTran result = matran1.cong(matran2);					// kết quả = Ma trận 1 + Ma trận 2(gọi bên class MaTran
			           JTextC.setText(result.toString());						// hiển thị kết quả vào Khung C
			     }
			}
		});
		SumButton.setBounds(31, 141, 93, 23);
		contentPane.add(SumButton);
		SumButton.setToolTipText("Click to sum the matrix!");
		
		JLabel FileLabel = new JLabel("File input:");
		FileLabel.setBounds(147, 14, 89, 14);
		contentPane.add(FileLabel);
		
		JLabel ColLabel = new JLabel("Column:");
		ColLabel.setBounds(147, 59, 46, 14);
		contentPane.add(ColLabel);
		
		JLabel RowLabel = new JLabel("Row:");
		RowLabel.setBounds(147, 110, 46, 14);
		contentPane.add(RowLabel);
		
		JButton DifferenceButton = new JButton("Difference");
		DifferenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!JTextA.getText().equals("") && !JTextB.getText().equals("")){ //If(Khung ma trận A và khung ma trận B khác rỗng)
		        	PhepTinhLbl.setText("-");							// Đổi chữ "phép tính" thành dấu "+"
		            MaTran result = matran1.tru(matran2);				// kết quả = Ma trận 1 + Ma trận 2(gọi bên class MaTran
		            JTextC.setText(result.toString());					// hiển thị kết quả vào Khung C
		        }
			}
		});
		DifferenceButton.setBounds(134, 141, 93, 23);
		contentPane.add(DifferenceButton);
		DifferenceButton.setToolTipText("Click to minus the matrix!");
		
		JButton MultiplicationButton = new JButton("Multiplication");
		MultiplicationButton.setBounds(237, 141, 93, 23);
		contentPane.add(MultiplicationButton);
		MultiplicationButton.setToolTipText("Click to multiply the matrix!");
		
		JButton DeterminantButton = new JButton("Determinant");
		DeterminantButton.setBounds(348, 141, 93, 23);
		contentPane.add(DeterminantButton);
		DeterminantButton.setToolTipText("Click to determinant the matrix!");
		
		JButton RankButton = new JButton("Rank");
		RankButton.setBounds(451, 141, 93, 23);
		contentPane.add(RankButton);
		RankButton.setToolTipText("Click to compute rank of a specifed matrix!");
		
		JButton ExplainButton = new JButton("Explain");
		ExplainButton.setBounds(554, 141, 93, 23);
		contentPane.add(ExplainButton);
		ExplainButton.setToolTipText("Click to see explain about the linear equations of a specifed matrix (by Gauss method)");
	}
}
