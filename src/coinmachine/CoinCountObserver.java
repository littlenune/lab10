package coinmachine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Tunya Wittayasiripaiboon 5810546676
 * The GUI of coin count observer will update with the count of coin inserted.
 */
public class CoinCountObserver  extends JFrame implements Observer{
	private JPanel panel = new JPanel();
	private CoinMachine coinmachine = new CoinMachine(10);
	private JLabel label;
	private JTextField result;
	private JLabel statusLabel;
	private JPanel panel2;


/**
 * Constructor of coin count observer 
 * @param  coinmachine from Coin Machine class
 */
	public CoinCountObserver(CoinMachine coinmachine ){
		this.coinmachine = coinmachine;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();
	}
	/*
	 * Create components for the UI and position them using a layout manager.
	 */
	public void initComponents(){
		setBounds(0,300,200,100);
		
		panel = new JPanel();
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);

		panel2 = new JPanel();
		panel.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		label = new JLabel("#Coins:");
		panel2.add(label);

		result = new JTextField();
		panel2.add(result);
		result.setColumns(10);
		
		statusLabel = new JLabel();
		panel.add(statusLabel, BorderLayout.SOUTH);
		result.setEnabled(false);
	}
	/*
	 * This will update the result text field to the count of coin inserted. 
	 */
	@Override
	public void update(Observable o, Object arg) {
		result.setText(((CoinMachine) o).getCount()+"");
		if ( coinmachine.getCapacity() >= 1 && coinmachine.getCapacity() < coinmachine.getCount()){
			statusLabel.setText("Accepting Coins");
		}
		else if ( ((CoinMachine) o).getCapacity() == coinmachine.getCount()){
			statusLabel.setText("The machine is full");
		}

	}
}
