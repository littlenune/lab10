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

public class CoinCountObserver  extends JFrame implements Observer{
	private JPanel panel = new JPanel();
	private CoinMachine coinmachine = new CoinMachine(10);
	private JLabel label = new JLabel("#Coins:");
	private JTextField result = new JTextField();
	private JLabel statusLabel = new JLabel("Accepting Coins");

	public CoinCountObserver(CoinMachine cm ){
		this.coinmachine = cm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initComponents();
	}
	public void initComponents(){
		setBounds(0,300,200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);

		JPanel panel2 = new JPanel();
		panel.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel2.add(label);

		result = new JTextField();
		panel2.add(result);
		result.setColumns(10);

		panel.add(statusLabel, BorderLayout.SOUTH);
		result.setEnabled(false);
	}
	@Override
	public void update(Observable o, Object arg) {
		result.setText(((CoinMachine) o).getCount()+"");
//		if
	}
}
