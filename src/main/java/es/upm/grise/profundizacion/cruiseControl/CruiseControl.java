package es.upm.grise.profundizacion.cruiseControl;

public class CruiseControl {
	
	@SuppressWarnings("unused")
	private Speedometer speedometer;
	private Integer speedSet;
	private Integer speedLimit;

	/*
	 * Constructor
	 */
	public CruiseControl(Speedometer speedometer) {
		
		this.speedometer = speedometer;

	}
	
	/*
	 * Method to code
	 */
	public void setSpeedSet(int speedSet) throws IncorrectSpeedException, SpeedSetAboveSpeedLimitException {
		if (speedSet <= 0) {
			throw new IncorrectSpeedException("Speed set cannot be negative");
		}
		if(speedLimit != null && speedSet > speedLimit) {
			throw new SpeedSetAboveSpeedLimitException("Speed set cannot be higher than speed limit");
		}
		this.speedSet = speedSet;
	}

	/*
	 * Other setters & getters
	 */
	/*
	 * Other setters & getters
	 */
	public Integer getSpeedLimit() {
		return speedLimit;
	}

	public void setSpeedLimit(Integer speedLimit) {
		this.speedLimit = speedLimit;
	}

	public Integer getSpeedSet() {
		return speedSet;
	}

}
