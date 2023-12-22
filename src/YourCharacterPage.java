import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// This class is just for UI and Using Generic class for showing ability
public class YourCharacterPage extends JFrame {

	// Variables for GUI components (ex: button, panel ..)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel fightTypeLabel;
	private JLabel speedLabel;
	private JLabel basicAttackLabel;
	private JLabel advancedAttackLabel;
	private JLabel specialAttackLabel;
	private JLabel firstLogoLabel;
	private JLabel secondLogoLabel;
	private JButton submitButton;
	private JFrame frame = YourCharacterPage.this;
		
	// Variables for GUI GridBag components
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_secondLogoLabel;
	private GridBagConstraints gbc_nameLabel;
	private GridBagConstraints gbc_fightTypeLabel;
	private GridBagConstraints gbc_firstLogoLabel;
	private GridBagConstraints gbc_speedLabel;
	private GridBagConstraints gbc_basicAttackLabel;
	private GridBagConstraints gbc_advancedAttackLabel;
	private GridBagConstraints gbc_specialAttackLabel;
	private GridBagConstraints gbc_submitButton;
	private GridBagConstraints gbc_userNameLabel;
	private GridBagConstraints gbc_userFightTypeLabel;
	private GridBagConstraints gbc_userBasicAttackLabel;
	private GridBagConstraints gbc_userAdvancedAttackLabel;
	private GridBagConstraints gbc_userSpecialAttackLabel;
	private GridBagConstraints gbc_userSpeedLabel;
	
	private JLabel userNameLabel;
	private JLabel userFightTypeLabel;
	private JLabel userBasicAttackLabel;
	private JLabel userAdvancedAttackLabel;
	private JLabel userSpecialAttackLabel;
	private JLabel userSpeedLabel;
	
	private Player<?> player;
	/**
	 * Create the frame.
	 */
	public YourCharacterPage(Player<?> player) {
		this.player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 150, 0, 0, 0, 0, 1, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{50, 0, 10, 0, 0, 15, 0, 15, 50, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		firstLogoLabel = new JLabel("");
		firstLogoLabel.setIcon(new ImageIcon(CharacterPage.class.getResource("/images/title_label.jpg")));
		gbc_firstLogoLabel = new GridBagConstraints();
		gbc_firstLogoLabel.insets = new Insets(0, 0, 0, 20);
		gbc_firstLogoLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstLogoLabel.anchor = GridBagConstraints.NORTH;
		gbc_firstLogoLabel.gridheight = 27;
		gbc_firstLogoLabel.gridx = 0;
		gbc_firstLogoLabel.gridy = 0;
		contentPane.add(firstLogoLabel, gbc_firstLogoLabel);
		
		secondLogoLabel = new JLabel("Check your own Character!");
		secondLogoLabel.setForeground(new Color(255, 255, 255));
		secondLogoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		gbc_secondLogoLabel = new GridBagConstraints();
		gbc_secondLogoLabel.anchor = GridBagConstraints.EAST;
		gbc_secondLogoLabel.gridwidth = 15;
		gbc_secondLogoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_secondLogoLabel.gridx = 6;
		gbc_secondLogoLabel.gridy = 7;
		contentPane.add(secondLogoLabel, gbc_secondLogoLabel);
		
		nameLabel = new JLabel("Character Name:");
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.gridwidth = 6;
		gbc_nameLabel.gridx = 5;
		gbc_nameLabel.gridy = 9;
		contentPane.add(nameLabel, gbc_nameLabel);
		
		userNameLabel = new JLabel(player.getPlayerCharacter().getName() + "");
		userNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		userNameLabel.setForeground(new Color(255, 255, 255));
		gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.gridwidth = 8;
		gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLabel.gridx = 12;
		gbc_userNameLabel.gridy = 9;
		contentPane.add(userNameLabel, gbc_userNameLabel);
		
		fightTypeLabel = new JLabel("Fight Type:");
		fightTypeLabel.setForeground(new Color(255, 255, 255));
		fightTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		fightTypeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_fightTypeLabel = new GridBagConstraints();
		gbc_fightTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fightTypeLabel.anchor = GridBagConstraints.EAST;
		gbc_fightTypeLabel.gridwidth = 6;
		gbc_fightTypeLabel.gridx = 5;
		gbc_fightTypeLabel.gridy = 11;
		contentPane.add(fightTypeLabel, gbc_fightTypeLabel);
		
		userFightTypeLabel = new JLabel(player.getPlayerCharacter().getFightType() + "");
		userFightTypeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userFightTypeLabel.setForeground(new Color(255, 255, 255));
		userFightTypeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_userFightTypeLabel = new GridBagConstraints();
		gbc_userFightTypeLabel.gridwidth = 8;
		gbc_userFightTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userFightTypeLabel.gridx = 12;
		gbc_userFightTypeLabel.gridy = 11;
		contentPane.add(userFightTypeLabel, gbc_userFightTypeLabel);
		
		speedLabel = new JLabel("Speed: ");
		speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		speedLabel.setForeground(new Color(255, 255, 255));
		speedLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_speedLabel = new GridBagConstraints();
		gbc_speedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_speedLabel.anchor = GridBagConstraints.EAST;
		gbc_speedLabel.gridwidth = 2;
		gbc_speedLabel.gridx = 9;
		gbc_speedLabel.gridy = 13;
		contentPane.add(speedLabel, gbc_speedLabel);
		
		userSpeedLabel = new JLabel((double)player.getPlayerCharacter().getSpeed()/1000 + " Sec");
		userSpeedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userSpeedLabel.setForeground(new Color(255, 255, 255));
		userSpeedLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_userSpeedLabel = new GridBagConstraints();
		gbc_userSpeedLabel.gridwidth = 8;
		gbc_userSpeedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userSpeedLabel.gridx = 12;
		gbc_userSpeedLabel.gridy = 13;
		contentPane.add(userSpeedLabel, gbc_userSpeedLabel);
		
		basicAttackLabel = new JLabel("BasicAttack: ");
		basicAttackLabel.setForeground(new Color(255, 255, 255));
		basicAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_basicAttackLabel = new GridBagConstraints();
		gbc_basicAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_basicAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_basicAttackLabel.gridwidth = 6;
		gbc_basicAttackLabel.gridx = 5;
		gbc_basicAttackLabel.gridy = 15;
		contentPane.add(basicAttackLabel, gbc_basicAttackLabel);
		
		userBasicAttackLabel = new JLabel(player.getPlayerCharacter().getBasicAttack()+"");
		userBasicAttackLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userBasicAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		userBasicAttackLabel.setForeground(new Color(255, 255, 255));
		gbc_userBasicAttackLabel = new GridBagConstraints();
		gbc_userBasicAttackLabel.gridwidth = 8;
		gbc_userBasicAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userBasicAttackLabel.gridx = 12;
		gbc_userBasicAttackLabel.gridy = 15;
		contentPane.add(userBasicAttackLabel, gbc_userBasicAttackLabel);
		
		advancedAttackLabel = new JLabel("AdvancedAttack: ");
		advancedAttackLabel.setForeground(new Color(255, 255, 255));
		advancedAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_advancedAttackLabel = new GridBagConstraints();
		gbc_advancedAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_advancedAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_advancedAttackLabel.gridwidth = 5;
		gbc_advancedAttackLabel.gridx = 6;
		gbc_advancedAttackLabel.gridy = 17;
		contentPane.add(advancedAttackLabel, gbc_advancedAttackLabel);
		
		userAdvancedAttackLabel = new JLabel(player.getPlayerCharacter().getAdvancedAttack()+"");
		userAdvancedAttackLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userAdvancedAttackLabel.setForeground(new Color(255, 255, 255));
		userAdvancedAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_userAdvancedAttackLabel = new GridBagConstraints();
		gbc_userAdvancedAttackLabel.gridwidth = 8;
		gbc_userAdvancedAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userAdvancedAttackLabel.gridx = 12;
		gbc_userAdvancedAttackLabel.gridy = 17;
		contentPane.add(userAdvancedAttackLabel, gbc_userAdvancedAttackLabel);
		
		specialAttackLabel = new JLabel("SpecialAttack: ");
		specialAttackLabel.setForeground(new Color(255, 255, 255));
		specialAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_specialAttackLabel = new GridBagConstraints();
		gbc_specialAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_specialAttackLabel.gridwidth = 6;
		gbc_specialAttackLabel.gridx = 5;
		gbc_specialAttackLabel.gridy = 19;
		contentPane.add(specialAttackLabel, gbc_specialAttackLabel);
		
		userSpecialAttackLabel = new JLabel(player.getPlayerCharacter().getSpecialAttack() + "");
		userSpecialAttackLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userSpecialAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		userSpecialAttackLabel.setForeground(new Color(255, 255, 255));
		gbc_userSpecialAttackLabel = new GridBagConstraints();
		gbc_userSpecialAttackLabel.gridwidth = 8;
		gbc_userSpecialAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userSpecialAttackLabel.gridx = 12;
		gbc_userSpecialAttackLabel.gridy = 19;
		contentPane.add(userSpecialAttackLabel, gbc_userSpecialAttackLabel);
		
		submitButton = new JButton("Ready to Fight?");
		submitButton.setForeground(new Color(255, 255, 255));
		submitButton.setFont(new Font("돋움", Font.BOLD, 12));
		submitButton.setBackground(new Color(0, 64, 128));
		gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitButton.anchor = GridBagConstraints.SOUTH;
		gbc_submitButton.gridwidth = 5;
		gbc_submitButton.insets = new Insets(0, 0, 5, 5);
		gbc_submitButton.gridx = 13;
		gbc_submitButton.gridy = 21;
		contentPane.add(submitButton, gbc_submitButton);
		// If you submit your information. then go to fight
		submitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
		                new FightPage(player);
		                frame.setVisible(false);
					}
		});
		setVisible(true);
	}
}


