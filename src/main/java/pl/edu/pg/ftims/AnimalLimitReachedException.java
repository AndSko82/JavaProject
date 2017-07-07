package pl.edu.pg.ftims;

public class AnimalLimitReachedException extends Exception {

	private static final long serialVersionUID = 2017224953675097369L;

	@Override
	public String getMessage() {
		return "Warning. Animal Limit Reached.";
	}
}
