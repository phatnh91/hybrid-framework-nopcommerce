package eclipseTips;

public class Topic_02_Getter_Setter {
	
	private String carName;
	private String carType;
	private String carColor;
	private String carMachine;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	/**
	 * @return the carType
	 * @author Phat Nguyen
	 */
	public String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * @return the carColor
	 */
	public String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carMachine
	 */
	public String getCarMachine() {
		return carMachine;
	}

	/**
	 * @param carMachine the carMachine to set
	 */
	public void setCarMachine(String carMachine) {
		this.carMachine = carMachine;
	}

}
