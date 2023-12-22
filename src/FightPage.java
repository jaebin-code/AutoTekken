import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import java.util.Random;


import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FightPage extends JFrame {

	// Variables for GUI components (ex: button, panel ..)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel userNameLabel;
	private JProgressBar userHealthProgressBar;
	private JLabel enemyNameLabel;
	private JProgressBar enemyHealthProgressBar;
	private JScrollPane userPane;
	private JScrollPane enemyPane;
	private JTextArea userTextArea;
	private JTextArea enemyTextArea;
	private JButton againButton;
	private JButton fightButton;
	private JFrame frame = FightPage.this;
	
	// Variables for GUI GridBag components
	private GridBagLayout gbl_contentPane;
	private GridBagConstraints gbc_userNameLabel;
	private GridBagConstraints gbc_enemyNameLabel;
	private GridBagConstraints gbc_userHealthProgressBar;
	private GridBagConstraints gbc_enemyHealthProgressBar;
	private GridBagConstraints gbc_userPane;
	private GridBagConstraints gbc_enemyPane;
	private GridBagConstraints gbc_fightButton;
	private GridBagConstraints gbc_againButton;
	
	private Player<?> player;							// Generic class for User
	private Player<?> enemy;							// Generic class for Sumo Hulk
	
	// save value of probability -> my program core points 
	private int[] playerAttackProbability = new int[3];	
	private int[] enemyAttackProbability = new int[3];
	private int[] attackTypeProbability = new int[3];
	
	// variables for the fight process( while two thread execute )
	private int attackType;
	private int randomNumber;
	private boolean flag;
	private boolean endingFlag;
	private int userHealth;
	private int enemyHealth;
	private String resultText;
	
	// Two thread -> User, Enemy
	private SwingWorker<Void, Integer> userThread;
	private SwingWorker<Void, Integer> enemyThread;
	/**
	 * Create the frame.
	 */
	public FightPage(Player<?> player) {
		this.player = player;
		Sumo Fighter = new Sumo("Sumo Hulk");
        this.enemy = new Player<>(Fighter);
        
        flag = true;
        endingFlag = true;
        
        userHealth = 100;
        enemyHealth = 100;
        resultText = "";
        
        // Set attack success probability. 8 means 80%
        // I will use random number(1 to 10), and decide success by probability
        if(player.getPlayerCharacter().getFightType().equals("Boxing")) {
        	playerAttackProbability[0] = 8;
        	playerAttackProbability[1] = 7;
        	playerAttackProbability[2] = 5;
        }
        else if(player.getPlayerCharacter().getFightType().equals("Taekwondo")) {
        	playerAttackProbability[0] = 7;
        	playerAttackProbability[1] = 8;
        	playerAttackProbability[2] = 5;
        }
        else{
        	playerAttackProbability[0] = 8;
        	playerAttackProbability[1] = 7;
        	playerAttackProbability[2] = 4;
        }
        
        // Initialize attack information probability
        enemyAttackProbability[0] = 8;
        enemyAttackProbability[1] = 7;
        enemyAttackProbability[2] = 4;
        
        attackTypeProbability[0] = 4;
        attackTypeProbability[1] = 8;
        attackTypeProbability[2] = 10;
        
        
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 20, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		userNameLabel = new JLabel(player.getPlayerCharacter().getName() + "");
		userNameLabel.setForeground(new Color(255, 255, 255));
		userNameLabel.setBackground(new Color(0, 64, 128));
		userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		userNameLabel.setOpaque(true);
		gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLabel.gridx = 2;
		gbc_userNameLabel.gridy = 0;
		contentPane.add(userNameLabel, gbc_userNameLabel);
		
		enemyNameLabel = new JLabel("Hulk");
		enemyNameLabel.setForeground(new Color(255, 255, 255));
		enemyNameLabel.setBackground(new Color(0, 128, 0));
		enemyNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		enemyNameLabel.setOpaque(true);
		gbc_enemyNameLabel = new GridBagConstraints();
		gbc_enemyNameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_enemyNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_enemyNameLabel.gridx = 27;
		gbc_enemyNameLabel.gridy = 0;
		contentPane.add(enemyNameLabel, gbc_enemyNameLabel);
		
		userHealthProgressBar = new JProgressBar();
		userHealthProgressBar.setValue(100);
		userHealthProgressBar.setStringPainted(true);
		userHealthProgressBar.setBackground(new Color(255, 255, 255));
		userHealthProgressBar.setForeground(new Color(255, 0, 0));
		gbc_userHealthProgressBar = new GridBagConstraints();
		gbc_userHealthProgressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_userHealthProgressBar.insets = new Insets(0, 0, 5, 5);
		gbc_userHealthProgressBar.gridx = 2;
		gbc_userHealthProgressBar.gridy = 1;
		contentPane.add(userHealthProgressBar, gbc_userHealthProgressBar);
		
		enemyHealthProgressBar = new JProgressBar();
		enemyHealthProgressBar.setBackground(new Color(255, 255, 255));
		enemyHealthProgressBar.setValue(100);
		enemyHealthProgressBar.setStringPainted(true);
		enemyHealthProgressBar.setForeground(new Color(255, 0, 0));
		gbc_enemyHealthProgressBar = new GridBagConstraints();
		gbc_enemyHealthProgressBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_enemyHealthProgressBar.insets = new Insets(0, 0, 5, 5);
		gbc_enemyHealthProgressBar.gridx = 27;
		gbc_enemyHealthProgressBar.gridy = 1;
		contentPane.add(enemyHealthProgressBar, gbc_enemyHealthProgressBar);
		
		userPane = new JScrollPane();
		gbc_userPane = new GridBagConstraints();
		gbc_userPane.insets = new Insets(0, 0, 5, 5);
		gbc_userPane.fill = GridBagConstraints.BOTH;
		gbc_userPane.gridx = 2;
		gbc_userPane.gridy = 2;
		contentPane.add(userPane, gbc_userPane);
		
		userTextArea = new JTextArea();
		userPane.setViewportView(userTextArea);
		
		enemyPane = new JScrollPane();
		gbc_enemyPane = new GridBagConstraints();
		gbc_enemyPane.insets = new Insets(0, 0, 5, 5);
		gbc_enemyPane.fill = GridBagConstraints.BOTH;
		gbc_enemyPane.gridx = 27;
		gbc_enemyPane.gridy = 2;
		contentPane.add(enemyPane, gbc_enemyPane);
		
		enemyTextArea = new JTextArea();
		enemyPane.setViewportView(enemyTextArea);
		
		fightButton = new JButton("Fight!");
		fightButton.setBackground(new Color(0, 0, 160));
		fightButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		fightButton.setForeground(new Color(255, 255, 255));
		gbc_fightButton = new GridBagConstraints();
		gbc_fightButton.insets = new Insets(0, 0, 0, 5);
		gbc_fightButton.gridx = 25;
		gbc_fightButton.gridy = 3;
		contentPane.add(fightButton, gbc_fightButton);
		fightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				userHealthProgressBar.setValue(100);					// Initialized progressBar value
				userHealthProgressBar.setString("100%");				// Initialized progressBar String
				userTextArea.setText("");								// Initialized userText to blank
											
							
				enemyHealthProgressBar.setValue(100);					// Initialized progressBar value
				enemyHealthProgressBar.setString("100%");				// Initialized progressBar String
				enemyTextArea.setText("");								// Initialized enenyText to blank
				fightButton.setEnabled(false);							// set fightButton enabled false
				againButton.setEnabled(false);							// set againButton enabled false
				start();
			}
		}
	);
		
		againButton = new JButton("Again!");
		againButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		againButton.setBackground(new Color(0, 0, 160));
		againButton.setForeground(new Color(255, 255, 255));
		gbc_againButton = new GridBagConstraints();
		gbc_againButton.insets = new Insets(0, 0, 0, 5);
		gbc_againButton.gridx = 26;
		gbc_againButton.gridy = 3;
		contentPane.add(againButton, gbc_againButton);
		againButton.addActionListener(new ActionListener() {
			// Restart the game
			@Override
			public void actionPerformed(ActionEvent e) {
				new StartPage();
                frame.setVisible(false);
			}
		}
	);
		setVisible(true);
	}
	
	
	private void start() {
		

	    userThread = new SwingWorker<Void, Integer>() {
	    	
	    	// process about long computation, it will publish level of progress and value of progress
	        @Override
	        protected Void doInBackground() throws Exception {
	            
	        	// Create a Random object
	            Random random = new Random();
	        	// Generate a random number in the range of 1 to 10
	            randomNumber = random.nextInt(10) + 1;

	        	while(flag && !isCancelled()) {
	        		// sleep sumThread for player speed
	        		try {
						Thread.sleep(player.getPlayerCharacter().getSpeed());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
	        		
	        		// Process that is selected by probability
	        		if(randomNumber < attackTypeProbability[0]) {
	        			attackType = 0;
	        		}
	        		else if(randomNumber > attackTypeProbability[1]) {
	        			attackType = 2;
	        		}
	        		else {
	        			attackType = 1;
	        		}
	        		
	        		// Generate a random number in the range of 1 to 10
		            randomNumber = random.nextInt(10) + 1;
		            if(randomNumber <= playerAttackProbability[attackType]) {
		            	publish(1);
		            	publish(attackType);
		            }
		            else {
		            	publish(0);
		            	publish(4);
		            }
	        	}
	        	
	            return null;
	        }
	        
	        // safely update GUI here
	        // Here is for control Health problem, change Progress Bar statement
	        @Override
	        protected void process(List<Integer> chunks) {
	        	if(userHealth != 0 && enemyHealth !=0) {
	        		// chunks(0) -> attack success information, chunk(O) -> which type attack?
	        		if(chunks.get(0) == 1) {
	        			if(chunks.get(1) == 0) {
	        				enemyHealth -= player.getPlayerCharacter().getBasicAttack();
	        				// Check Health value is negative.
	        				if(enemyHealth <= 0) {
	        					enemyHealth = 0;
	        					flag = false;
	        					userThread.cancel(true);
	        				}
	        				enemyHealthProgressBar.setValue(enemyHealth);
	        				enemyHealthProgressBar.setString(enemyHealth + "%");
	        				userTextArea.append(player.getPlayerCharacter().getName() + player.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			else if(chunks.get(1) == 1){
	        				enemyHealth -= player.getPlayerCharacter().getAdvancedAttack();
	        				if(enemyHealth <= 0) {
	        					enemyHealth = 0;
	        					flag = false;
	        					userThread.cancel(true);
	        				}
	        				enemyHealthProgressBar.setValue(enemyHealth);
	        				enemyHealthProgressBar.setString(enemyHealth + "%");
	        				userTextArea.append(player.getPlayerCharacter().getName() + player.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			else {
	        				enemyHealth -= player.getPlayerCharacter().getSpecialAttack();
	        				if(enemyHealth <= 0) {
	        					enemyHealth = 0;
	        					flag = false;
	        					userThread.cancel(true);
	        				}
	        				enemyHealthProgressBar.setValue(enemyHealth);
	        				enemyHealthProgressBar.setString(enemyHealth + "%");
	        				userTextArea.append(player.getPlayerCharacter().getName() + player.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			
	        		}
	        		else {
	        			userTextArea.append(player.getPlayerCharacter().getName() + player.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        		}
	        	}
	        	else {
	        		flag = false;
	        		userThread.cancel(true);
	        		if(userHealth == 0 && endingFlag) {
	        			userTextArea.append("Game Over. You lose..\n");
	        			endingFlag = false;
	        			// FILE I/O
	    	        	try {	
	    	        		
	    	        	
	    	        		resultText += "User Info  \n\n" + "name: " + player.getPlayerCharacter().getName() + "\n" +
	    	        		"type: " + player.getPlayerCharacter().getFightType() + "\n" +
	    	        		"speed: " + (double) player.getPlayerCharacter().getSpeed() / 1000 + "\n" + 
	    	        		"basicAttack: " + player.getPlayerCharacter().getBasicAttack() + "\n" +
	    	        		"advancedAttack: " + player.getPlayerCharacter().getAdvancedAttack() + "\n" +
	    	        		"specialAttack: " + player.getPlayerCharacter().getSpecialAttack() + "\n" +
	    	        		"Result is lose. Try again.";
	    	        		
	    	        		// print dataText on data.txt
	    	                FileWriter fileWriter = new FileWriter("./src/textfile/data.txt", false);		// use false to clear data.txt
	    	                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	    	                bufferedWriter.write(resultText);
	    	                
	    	                bufferedWriter.close();
	    	                
	    	                // initialized resultText
	    	                resultText = "";
	    	            } catch (IOException e) {
	    	                e.printStackTrace();
	    	            }
	    	        	
	    	        	againButton.setEnabled(true);	// set againButton enabled true
	        		}
	        		else{
	        			if(endingFlag == true) {
	        				userTextArea.append("Game Over. You Win!!\n");
	        				endingFlag = false;
		    	        	try {	
		    	        		
			    	        	
		    	        		resultText += "User Info  \n\n" + "name: " + player.getPlayerCharacter().getName() + "\n" +
		    	        		"type: " + player.getPlayerCharacter().getFightType() + "\n" +
		    	        		"speed: " + (double) player.getPlayerCharacter().getSpeed() / 1000 + "\n" + 
		    	        		"basicAttack: " + player.getPlayerCharacter().getBasicAttack() + "\n" +
		    	        		"advancedAttack: " + player.getPlayerCharacter().getAdvancedAttack() + "\n" +
		    	        		"specialAttack: " + player.getPlayerCharacter().getSpecialAttack() + "\n" +
		    	        		"Result is win. Great!";
		    	        		
		    	        		// print dataText on data.txt
		    	                FileWriter fileWriter = new FileWriter("./src/textfile/data.txt", false);		// use false to clear data.txt
		    	                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		    	                bufferedWriter.write(resultText);
		    	                
		    	                bufferedWriter.close();
		    	                
		    	                // initialized resultText
		    	                resultText = "";
		    	            } catch (IOException e) {
		    	                e.printStackTrace();
		    	            }
		    	        	
		    	        	
		    	        	againButton.setEnabled(true);	// set againButton enabled true
	        			}
	        			
	        		}
	        		
	        	}

	        }
	        
	    };
	    
	    // As same as userThread
	    enemyThread = new SwingWorker<Void, Integer>() {
	    	
	    	// process about long computation, it will publish level of progress and value of progress
	        @Override
	        protected Void doInBackground() throws Exception {
	            
	        	// Create a Random object
	            Random random = new Random();
	        	// Generate a random number in the range of 1 to 10
	            randomNumber = random.nextInt(10) + 1;

	        	while(flag && !isCancelled()) {
	        		// sleep sumThread for player speed
	        		try {
						Thread.sleep(enemy.getPlayerCharacter().getSpeed());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
	        		
	        		if(randomNumber < attackTypeProbability[0]) {
	        			attackType = 0;
	        		}
	        		else if(randomNumber > attackTypeProbability[1]) {
	        			attackType = 2;
	        		}
	        		else {
	        			attackType = 1;
	        		}
	        		
	        		// Generate a random number in the range of 1 to 10
		            randomNumber = random.nextInt(10) + 1;
		            if(randomNumber <= enemyAttackProbability[attackType]) {
		            	publish(1);
		            	publish(attackType);
		            }
		            else {
		            	publish(0);
		            	publish(4);
		            }
	        	}
	        	
	            return null;
	        }
	        
	        // safely update GUI here
	        @Override
	        protected void process(List<Integer> chunks) {
	        	if(userHealth != 0 && enemyHealth !=0) {
	        		if(chunks.get(0) == 1) {
	        			if(chunks.get(1) == 0) {
	        				userHealth -= enemy.getPlayerCharacter().getBasicAttack();
	        				if(userHealth <= 0) {
	        					userHealth = 0;
	        					flag = false;
	        					enemyThread.cancel(true);
	        				}
	        				userHealthProgressBar.setValue(userHealth);
	        				userHealthProgressBar.setString(userHealth + "%");
	        				enemyTextArea.append(enemy.getPlayerCharacter().getName() + enemy.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			else if(chunks.get(1) == 1){
	        				userHealth -= enemy.getPlayerCharacter().getAdvancedAttack();
	        				if(userHealth <= 0) {
	        					userHealth = 0;
	        					flag = false;
	        					enemyThread.cancel(true);
	        				}
	        				userHealthProgressBar.setValue(userHealth);
	        				userHealthProgressBar.setString(userHealth + "%");
	        				enemyTextArea.append(enemy.getPlayerCharacter().getName() + enemy.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			else {
	        				userHealth -= enemy.getPlayerCharacter().getSpecialAttack();
	        				if(userHealth <= 0) {
	        					userHealth = 0;
	        					flag = false;
	        					enemyThread.cancel(true);
	        				}
	        				userHealthProgressBar.setValue(userHealth);
	        				userHealthProgressBar.setString(userHealth + "%");
	        				enemyTextArea.append(enemy.getPlayerCharacter().getName() + enemy.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        			}
	        			
	        		}
	        		else {
	        			enemyTextArea.append(enemy.getPlayerCharacter().getName() + enemy.getPlayerCharacter().characterLine(chunks.get(1)) + "\n");
	        		}
	        	}
	        	else {
	        		flag = false;
	        		enemyThread.cancel(true);
	        	}
	        }
	        
	    };
	    

	    // execute two thread
	    userThread.execute();
	    enemyThread.execute();
	}
}
