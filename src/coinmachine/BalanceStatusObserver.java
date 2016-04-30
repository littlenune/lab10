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
 * @ implements Observer
 * @ extends JFrame 
 */
public class BalanceStatusObserver  extends JFrame implements Observer{
/*
 * 
 */
	private JPanel panel = new JPanel();
	private JButton oneBaht = new JButton();
	private JButton fiveBaht = new JButton();
	private JButton tenBaht = new JButton();
	private JPanel panel2 = new JPanel();
	private JLabel balanceLabel = new JLabel("Balance: 0");
	private JProgressBar progressBar = new JProgressBar();
	private JLabel statusLabel = new JLabel("Status :");
	private CoinMachine coinmachine = new CoinMachine(10);
/*
 * Constructor of BalanceStatusObserver 
 */
	public BalanceStatusObserver( CoinMachine cm ) {
		this.coinmachine = cm;
		this.setSize(500,  200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();

	}
	public void initComponents(){

		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBorder(BorderFactory.createTitledBorder("InsertMoney"));

		oneBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/1baht.png")));
		panel.add(oneBaht);

		fiveBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/5baht.png")));
		panel.add(fiveBaht);

		tenBaht.setIcon(new ImageIcon(BalanceStatusObserver.class.getResource("/images/10baht.png")));
		panel.add(tenBaht);

		getContentPane().add(panel2, BorderLayout.NORTH);

		panel2.add(balanceLabel);

		panel2.add(statusLabel);

		panel2.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(coinmachine.getCapacity());
		
		oneBaht.addActionListener(new ButtonListener());
		fiveBaht.addActionListener(new ButtonListener());
		tenBaht.addActionListener(new ButtonListener());

	}

	@Override
	public void update(Observable o, Object arg) {
		progressBar.setValue(((CoinMachine) o).getCount());
		balanceLabel.setText("Balance: "+((CoinMachine) o).getBalance());

	}
	
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

