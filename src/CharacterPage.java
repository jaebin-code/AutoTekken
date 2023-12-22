
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
public class CharacterPage extends JFrame{
	
	// Variables for GUI components (ex: button, panel ..)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel fightTypeLabel;
	private JLabel statLabel;
	private JLabel basicAttackLabel;
	private JLabel advancedAttackLabel;
	private JLabel specialAttackLabel;
	private JLabel firstLogoLabel;
	private JTextField nameText;
	private JTextField fightTypeText;
	private JTextField basicAttackText;
	private JTextField advancedAttackText;
	private JTextField specialAttackText;
	private JLabel secondLogoLabel;
	private JButton submitButton;
	private JFrame frame = CharacterPage.this;
	
	// Variables for GUI GridBag components
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_secondLogoLabel;
	private GridBagConstraints gbc_nameLabel;
	private GridBagConstraints gbc_nameText;
	private GridBagConstraints gbc_fightTypeLabel;
	private GridBagConstraints gbc_fightTypeText;
	private GridBagConstraints gbc_firstLogoLabel;
	private GridBagConstraints gbc_statLabel;
	private GridBagConstraints gbc_basicAttackLabel;
	private GridBagConstraints gbc_basicAttackText;
	private GridBagConstraints gbc_advancedAttackLabel;
	private GridBagConstraints gbc_advancedAttackText;
	private GridBagConstraints gbc_specialAttackLabel;
	private GridBagConstraints gbc_specialAttackText;
	private GridBagConstraints gbc_submitButton;
	
	
	
	// variables for saving text that are input on TextField or TextArea
	private String inputName;
	private String inputFightType;
	private String inputBasicAttackStat;
	private String inputAdvancedAttackStat;
	private String inputSpecialAttackStat;
	
	// variable for saving error message
	private String errorMessage = "";
	
	// variables for setting ability
	private int basicStat;
	private int advancedStat;
	private int specialStat;
	
	// method for valid name input
	public int checkName(String name) {
		
		// name must have at least 1 alphabet and only consist of alphabet, and length is less than 10
		if (name.matches("^[a-zA-Z]+$") && name.length() > 0 && name.length() < 10) {
		    return 1;
		} else {
		    return 0;
		}
	}	
	
	// method for valid name input
	public int checkType(String Type) {
		
		// type have to be "sumo" or "taekwondo" or "boxing"
		if (Type.equals("sumo") || Type.equals("taekwondo") || Type.equals("boxing")) {
		    return 1;
		} else {
		    return 0;
		}
	}	
	/**
	 * Create the frame.
	 */
	public CharacterPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{50, 0, 10, 0, 0, 15, 0, 15, 50, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0, 15, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		secondLogoLabel = new JLabel("Customize your own Character!");
		secondLogoLabel.setForeground(new Color(255, 255, 255));
		secondLogoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		gbc_secondLogoLabel = new GridBagConstraints();
		gbc_secondLogoLabel.anchor = GridBagConstraints.EAST;
		gbc_secondLogoLabel.gridwidth = 14;
		gbc_secondLogoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_secondLogoLabel.gridx = 11;
		gbc_secondLogoLabel.gridy = 7;
		contentPane.add(secondLogoLabel, gbc_secondLogoLabel);
		
		nameLabel = new JLabel("Character Name:");
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.gridwidth = 5;
		gbc_nameLabel.gridx = 5;
		gbc_nameLabel.gridy = 9;
		contentPane.add(nameLabel, gbc_nameLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		gbc_nameText = new GridBagConstraints();
		gbc_nameText.gridwidth = 14;
		gbc_nameText.insets = new Insets(0, 0, 5, 5);
		gbc_nameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameText.gridx = 12;
		gbc_nameText.gridy = 9;
		contentPane.add(nameText, gbc_nameText);
		nameText.setColumns(10);
		
		fightTypeLabel = new JLabel("Fight Type:");
		fightTypeLabel.setForeground(new Color(255, 255, 255));
		fightTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		fightTypeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_fightTypeLabel = new GridBagConstraints();
		gbc_fightTypeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fightTypeLabel.anchor = GridBagConstraints.EAST;
		gbc_fightTypeLabel.gridwidth = 5;
		gbc_fightTypeLabel.gridx = 5;
		gbc_fightTypeLabel.gridy = 11;
		contentPane.add(fightTypeLabel, gbc_fightTypeLabel);
		
		fightTypeText = new JTextField();
		fightTypeText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		fightTypeText.setText("Boxing, Taekwondo, Sumo");
		gbc_fightTypeText = new GridBagConstraints();
		gbc_fightTypeText.gridwidth = 14;
		gbc_fightTypeText.insets = new Insets(0, 0, 5, 5);
		gbc_fightTypeText.fill = GridBagConstraints.HORIZONTAL;
		gbc_fightTypeText.gridx = 12;
		gbc_fightTypeText.gridy = 11;
		contentPane.add(fightTypeText, gbc_fightTypeText);
		fightTypeText.setColumns(10);
		
		statLabel = new JLabel("Upgrade Stat : You can add 10 more stats. (Customize it!)");
		statLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statLabel.setForeground(new Color(255, 255, 255));
		statLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_statLabel = new GridBagConstraints();
		gbc_statLabel.insets = new Insets(0, 0, 5, 5);
		gbc_statLabel.anchor = GridBagConstraints.EAST;
		gbc_statLabel.gridwidth = 13;
		gbc_statLabel.gridx = 10;
		gbc_statLabel.gridy = 13;
		contentPane.add(statLabel, gbc_statLabel);
		
		basicAttackLabel = new JLabel("BasicAttack: ");
		basicAttackLabel.setForeground(new Color(255, 255, 255));
		basicAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_basicAttackLabel = new GridBagConstraints();
		gbc_basicAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_basicAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_basicAttackLabel.gridwidth = 5;
		gbc_basicAttackLabel.gridx = 5;
		gbc_basicAttackLabel.gridy = 15;
		contentPane.add(basicAttackLabel, gbc_basicAttackLabel);
		
		basicAttackText = new JTextField();
		basicAttackText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		gbc_basicAttackText = new GridBagConstraints();
		gbc_basicAttackText.gridwidth = 14;
		gbc_basicAttackText.insets = new Insets(0, 0, 5, 5);
		gbc_basicAttackText.fill = GridBagConstraints.HORIZONTAL;
		gbc_basicAttackText.gridx = 12;
		gbc_basicAttackText.gridy = 15;
		contentPane.add(basicAttackText, gbc_basicAttackText);
		basicAttackText.setColumns(10);
		
		advancedAttackLabel = new JLabel("AdvancedAttack: ");
		advancedAttackLabel.setForeground(new Color(255, 255, 255));
		advancedAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_advancedAttackLabel = new GridBagConstraints();
		gbc_advancedAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_advancedAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_advancedAttackLabel.gridwidth = 4;
		gbc_advancedAttackLabel.gridx = 6;
		gbc_advancedAttackLabel.gridy = 17;
		contentPane.add(advancedAttackLabel, gbc_advancedAttackLabel);
		
		advancedAttackText = new JTextField();
		advancedAttackText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		gbc_advancedAttackText = new GridBagConstraints();
		gbc_advancedAttackText.gridwidth = 14;
		gbc_advancedAttackText.insets = new Insets(0, 0, 5, 5);
		gbc_advancedAttackText.fill = GridBagConstraints.HORIZONTAL;
		gbc_advancedAttackText.gridx = 12;
		gbc_advancedAttackText.gridy = 17;
		contentPane.add(advancedAttackText, gbc_advancedAttackText);
		advancedAttackText.setColumns(10);
		
		specialAttackLabel = new JLabel("SpecialAttack: ");
		specialAttackLabel.setForeground(new Color(255, 255, 255));
		specialAttackLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		gbc_specialAttackLabel = new GridBagConstraints();
		gbc_specialAttackLabel.insets = new Insets(0, 0, 5, 5);
		gbc_specialAttackLabel.anchor = GridBagConstraints.EAST;
		gbc_specialAttackLabel.gridwidth = 5;
		gbc_specialAttackLabel.gridx = 5;
		gbc_specialAttackLabel.gridy = 19;
		contentPane.add(specialAttackLabel, gbc_specialAttackLabel);
		
		specialAttackText = new JTextField();
		specialAttackText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		gbc_specialAttackText = new GridBagConstraints();
		gbc_specialAttackText.gridwidth = 14;
		gbc_specialAttackText.insets = new Insets(0, 0, 5, 5);
		gbc_specialAttackText.fill = GridBagConstraints.HORIZONTAL;
		gbc_specialAttackText.gridx = 12;
		gbc_specialAttackText.gridy = 19;
		contentPane.add(specialAttackText, gbc_specialAttackText);
		specialAttackText.setColumns(10);
		
		submitButton = new JButton("Create Character");
		submitButton.setForeground(new Color(255, 255, 255));
		submitButton.setFont(new Font("돋움", Font.BOLD, 12));
		submitButton.setBackground(new Color(0, 64, 128));
		gbc_submitButton = new GridBagConstraints();
		gbc_submitButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_submitButton.anchor = GridBagConstraints.SOUTH;
		gbc_submitButton.gridwidth = 5;
		gbc_submitButton.insets = new Insets(0, 0, 5, 5);
		gbc_submitButton.gridx = 18;
		gbc_submitButton.gridy = 21;
		contentPane.add(submitButton, gbc_submitButton);
		// add listener that listen action about press submitButton
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// variables for saving text that are input on TextField or TextArea
		    	inputName = nameText.getText();
		    	inputFightType = fightTypeText.getText().toLowerCase();
		    	inputBasicAttackStat = basicAttackText.getText();
		    	inputAdvancedAttackStat = advancedAttackText.getText();
		    	inputSpecialAttackStat = specialAttackText.getText();
		    	
		    	// variable for saving error message
		    	errorMessage = "";
		    	
		    	int errorNumber = 1;
		    	
		    	// check exceptions that empty text is existed
		    	try {	
		    		if(inputName.length() == 0 || inputFightType.length() == 0 || inputBasicAttackStat.length() == 0 || inputAdvancedAttackStat.length() == 0 
		    				|| inputSpecialAttackStat.length() == 0) {
		    			throw new CharacterInputException();
		    			}
		    	}
		    	
		    	catch ( CharacterInputException exception ) {
		    		// add emptyTextException message on errorMessage, and plus 1 on errorNumber
		    		errorMessage += errorNumber + ". You forgot to fill some text field, Please fill it\n";
		    		errorNumber += 1;
		    	}
		    	
		    	try {
			    	// If exception occurs -> change textColor to red and update message and errorNumber.
			    	if(checkName(inputName) == 0) {
			    		nameText.setForeground(Color.RED);
			    		errorMessage += errorNumber + ". your name have to be one word and length have to be less than 10.\n";
			    		errorNumber += 1;
			    	}
			    	else {
			    		nameText.setForeground(Color.BLACK);
			    	}
			    	
			    	// Check FightType is correct Form
			    	if(checkType(inputFightType) == 0) {
			    		fightTypeText.setForeground(Color.RED);
			    		errorMessage += errorNumber + ". Fight type have to be sumo or boxing or taekwondo\n";
			    		errorNumber += 1;
			    	}
			    	else {
			    		fightTypeText.setForeground(Color.BLACK);
			    	}
			    	
			    	// If exception occurs -> parsing stat to int is Failed.
			    	try {
			    	    basicStat = Integer.parseInt(inputBasicAttackStat);
	
			    	    advancedStat = Integer.parseInt(inputAdvancedAttackStat);
	
			    	    specialStat = Integer.parseInt(inputSpecialAttackStat);
			    	    
			    	    if(basicStat >= 0 && advancedStat >= 0 && specialStat >= 0 && basicStat + advancedStat + specialStat == 10) {
			    	    	basicAttackText.setForeground(Color.BLACK);
			    	    	advancedAttackText.setForeground(Color.BLACK);
			    	    	specialAttackText.setForeground(Color.BLACK);
			    	    }
			    	    else {
			    	    	basicAttackText.setForeground(Color.RED);
			    	    	advancedAttackText.setForeground(Color.RED);
			    	    	specialAttackText.setForeground(Color.RED);
			    	    	errorMessage += errorNumber + ". You input wrong format of stat(ex: string, negative number) or sum is not 10.\n";
			    	    	errorNumber += 1;
			    	    }
	
			    	} catch (NumberFormatException exception) {
			    		errorMessage += errorNumber + ". You input wrong format of stat(number) or sum is not 10.\n";
			    		errorNumber += 1;
			    	}
			    	
		    		// If error message is not empty -> then use exception to alert exception message
		    		if(!errorMessage.equals("")) {
		    			throw new CharacterInputException();
		    		}
		    		
		    		// If all text doesn't have any exception, then alert successful message
		    		JOptionPane.showMessageDialog(null, "Successfully Submitted", "Success message",JOptionPane.INFORMATION_MESSAGE);
		    		
		    		// Using Generic class for flexible control
		    		if(inputFightType.equals("boxing")) {
		                Boxing Fighter = new Boxing(inputName);
		                Fighter.setBasicAttack(Fighter.getBasicAttack() + basicStat);
		                Fighter.setAdvancedAttack(Fighter.getAdvancedAttack() + advancedStat);
		                Fighter.setSpecialAttack(Fighter.getSpecialAttack() + specialStat);
		                // Create a player
		                Player<Boxing> player = new Player<>(Fighter);
		                new YourCharacterPage(player);
		                frame.setVisible(false);
		    		}
		    		else if(inputFightType.equals("taekwondo")) {
		    			Taekwondo Fighter = new Taekwondo(inputName);
		                Fighter.setBasicAttack(Fighter.getBasicAttack() + basicStat);
		                Fighter.setAdvancedAttack(Fighter.getAdvancedAttack() + advancedStat);
		                Fighter.setSpecialAttack(Fighter.getSpecialAttack() + specialStat);
		                // Create a player
		                Player<Taekwondo> player = new Player<>(Fighter);
		                new YourCharacterPage(player);
		                frame.setVisible(false);
		    		}
		    		else {
		    			Sumo Fighter = new Sumo(inputName);
		                Fighter.setBasicAttack(Fighter.getBasicAttack() + basicStat);
		                Fighter.setAdvancedAttack(Fighter.getAdvancedAttack() + advancedStat);
		                Fighter.setSpecialAttack(Fighter.getSpecialAttack() + specialStat);
		                // Create a player
		                Player<Sumo> player = new Player<>(Fighter);
		                new YourCharacterPage(player);
		                frame.setVisible(false);
		    		}
		    		
		    		
		    	}
		    	catch (CharacterInputException exception) {
		    		JOptionPane.showMessageDialog(null, errorMessage,"You have following problems:",JOptionPane.ERROR_MESSAGE);
		    	}
		    	
		    	
			} });
		
		setVisible(true);
	}
}
