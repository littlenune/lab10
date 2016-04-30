package coinmachine;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JProgressBar;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/*
 * @ author Tunya Wittayasiripaiboon 5810546676
 * @ The observer class which will update the status and balance of the coin machine.
 */
public class BalanceStatusObserver  extends JFrame implements Observer{
	
	private JPanel panel ;
	private JButton oneBaht;
	private JButton fiveBaht;
	private JButton tenBaht;
	private JPanel panel2;
	private JLabel balanceLabel;
	private JProgressBar progressBar;
	private JLabel statusLabel;
	private CoinMachine coinmachine = new CoinMachine(10);

/**
 * Constructor of BalanceStatusObserver 
 * @param coinmachine from Coin Machine class
 */ 
	public BalanceStatusObserver( CoinMachine coinmachine ) {
		this.coinmachine = coinmachine;
		this.setSize(500,  200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();

	}
	/**
	 * Create components for the UI and position them using a layout manager.
	 */
	public void initComponents(){
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBorder(BorderFactory.createTitledBorder("InsertMoney"));
		
		oneBaht = new JButton();
		oneBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/1baht.png")));
		panel.add(oneBaht);

		fiveBaht = new JButton();
		fiveBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/5baht.png")));
		panel.add(fiveBaht);

		tenBaht = new JButton();
		tenBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/10baht.png")));
		panel.add(tenBaht);

		panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.NORTH);

		balanceLabel = new JLabel("Balance: 0");
		panel2.add(balanceLabel);

		statusLabel = new JLabel("Status :");
		panel2.add(statusLabel);

		progressBar = new JProgressBar();
		panel2.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(coinmachine.getCapacity());
		progressBar.setStringPainted(true);
		progressBar.setString("0");
		
		oneBaht.addActionListener(new ButtonListener());
		fiveBaht.addActionListener(new ButtonListener());
		tenBaht.addActionListener(new ButtonListener());

	}

	/**
	 * This will update the status and balance when inserted the coin.
	 */
	@Override
	public void update(Observable o, Object arg) {
		progressBar.setValue(((CoinMachine) o).getCount());
		progressBar.setString(Integer.toString(((CoinMachine) o).getCount()));
		balanceLabel.setText("Balance: "+((CoinMachine) o).getBalance());

	}
	 /**
	  * @ author Tunya Wittayasiripaiboon 5810546676
	  * Perform an action when user click on the coin buttons will add the different values of each coin .
	  */
	class ButtonListener implements ActionListener {
		
		public void compution (){
			if ( oneBaht.isFocusOwner() ){
				coinmachine.insert(new Coin(1));
			}
			else if (fiveBaht.isFocusOwner()){
				coinmachine.insert(new Coin(5));
			}
			else if ( tenBaht.isFocusOwner()){
				coinmachine.insert(new Coin(10));
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if ( oneBaht.isFocusOwner() || fiveBaht.isFocusOwner() || tenBaht.isFocusOwner()){
				this.compution();
			}
		}
	}
}

