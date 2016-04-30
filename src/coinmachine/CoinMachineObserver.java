package coinmachine;

import java.util.Observable;
import java.util.Observer;

public class CoinMachineObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		System.out.println( "Machine balance : " +((CoinMachine) o).getBalance() );
	}

}
