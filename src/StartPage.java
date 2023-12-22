
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StartPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton startButton;
	private JButton explainationButton;
	private JLabel backgroundImg;
	private JLabel logoLabel;
	private JFrame frame = StartPage.this;

	/**
	 * Create the frame.
	 */
	public StartPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		startButton = new JButton("Start");
		startButton.setForeground(new Color(255, 255, 255));
		startButton.setBackground(new Color(0, 128, 255));
		startButton.setBounds(870, 279, 150, 51);
		startButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		// change a frame to CharacterPage
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CharacterPage();
				frame.setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(startButton);
		
		explainationButton = new JButton("Explanation");
		explainationButton.setForeground(new Color(255, 255, 255));
		explainationButton.setBackground(new Color(0, 128, 255));
		explainationButton.setBounds(870, 367, 150, 51);
		explainationButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		// make new frame -> explanation page
		explainationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManualPage(frame);
			}
		});
		contentPane.add(explainationButton);
		
		backgroundImg = new JLabel("New label");
		backgroundImg.setIcon(new ImageIcon(StartPage.class.getResource("/images/firstPageBackground.jpg")));
		backgroundImg.setBounds(0, 0, 810, 700);
		contentPane.add(backgroundImg);
		
		logoLabel = new JLabel("Auto Tekken");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		logoLabel.setBounds(833, 62, 215, 71);
		contentPane.add(logoLabel);
		
		setVisible(true);
	}
}
