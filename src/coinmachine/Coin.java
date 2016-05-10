package coinmachine;
/**
 * A Coin represents metalic money with a value.
 */
public class Coin implements Comparable<Coin> {
	/** value of the coin */
	private final int value;
	private final String currency;

	/**
	 * Initialize a new Coin.
	 * @param value is the value of the Coin
	 * @pre the value is positive
	 */
	public Coin(int value) {
		this(value, "Baht");
	}

	public Coin(int value, String currency) {
		assert value > 0;  // if not, its YOUR fault
		if (currency == null) throw new IllegalArgumentException("currency cannot be null");
		this.value = value;
		this.currency = currency;
	}
	/**
	 * Get the coin's value.
	 * @return the value of this coin.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Get the coin's currency.
	 * @return the currency of this coin.
	 */
	public String getCurrency() { return currency; }


	/**
	 * Hashcode is used by collections like HashSet and HashMap.
	 * It should be a value that is unlikely to change and
	 * usually returns different hash values for objects with
	 * different attribute values.
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + value;
		return result;
	}
	/**
	 * Two coins are equal if they have the same currency and value.
	 * @param obj an Object to compare to this coin.
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return Return true if the currency and values of two objects are equal.
	 */
	//	@Override
	public boolean equals(Object obj) {
		if ( obj instanceof Coin){
			Coin coin = (Coin) obj;
			if ( coin.getValue() == this.getValue() && coin.getCurrency().equals(this.getCurrency()))
			{
				return true;
			}
		}

		return false;
		//     You can assume that the currency is never null.
	}

	/**
	 * Return string of value and currency.
	 */
	@Override
	public String toString() {
		return value+"-"+currency;
	}
	/*
	 * This will compare the value of two coins and will arrangement it in lower and greater.
	 * @return position of it.
	 */
	@Override
	public int compareTo(Coin o) {
		int compareNum= 0;
		if ( this.getValue() > o.getValue()){
			compareNum =1;
		}
		else if ( this.getValue() == o.getValue()){
			compareNum = 0;
		}
		else if ( this.getValue() < o.getValue()){
			compareNum = -1;
		}
		return compareNum;
	}

}
