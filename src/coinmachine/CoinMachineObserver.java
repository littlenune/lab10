package coinmachine;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Tunya Wittayasiripaiboon 5810546676
 *  Coin machine observer will update the balance of the machine.
 */
public class CoinMachineObserver implements Observer{
/**
 * This will update the balance.
 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println( "Machine balance : " +((CoinMachine) o).getBalance() );
	}

}
