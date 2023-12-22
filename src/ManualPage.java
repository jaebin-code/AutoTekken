import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ManualPage extends JDialog {
	
	// This page is just for Manual. No function! Just UI. Don't be mind.
	
	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JLabel line1Label;
	private JLabel line2Label;
	private JLabel line3Label;
	private JLabel line4Label;
	private JLabel line5Label;


	/**
	 * Create the dialog.
	 */
	public ManualPage(JFrame parentFrame) {
		super(parentFrame, true);
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		titleLabel = new JLabel("Welcome to Auto Tekken");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		titleLabel.setBounds(119, 69, 341, 20);
		getContentPane().add(titleLabel);
		
		line1Label = new JLabel("Our goal is to beat Sumo Hulk. You will have your fighter.");
		line1Label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		line1Label.setHorizontalAlignment(SwingConstants.LEFT);
		line1Label.setForeground(new Color(255, 255, 255));
		line1Label.setBounds(119, 195, 356, 27);
		getContentPane().add(line1Label);
		
		line2Label = new JLabel("There are 3 Types of fight. Boxing, Taekwondo, Sumo.");
		line2Label.setForeground(new Color(255, 255, 255));
		line2Label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		line2Label.setBounds(119, 232, 341, 20);
		getContentPane().add(line2Label);
		
		line3Label = new JLabel("By setting stat. you can fight auto, with your own character.");
		line3Label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		line3Label.setForeground(new Color(255, 255, 255));
		line3Label.setBounds(119, 273, 356, 20);
		getContentPane().add(line3Label);
		
		line4Label = new JLabel("Attack type and success are based on the characteristics and probabilities.");
		line4Label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		line4Label.setHorizontalAlignment(SwingConstants.LEFT);
		line4Label.setForeground(new Color(255, 255, 255));
		line4Label.setBounds(119, 322, 455, 15);
		getContentPane().add(line4Label);
		
		line5Label = new JLabel("Good Luck!");
		line5Label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		line5Label.setForeground(new Color(255, 255, 255));
		line5Label.setBounds(119, 365, 99, 22);
		getContentPane().add(line5Label);
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
