package commands;

public abstract class Command {

	private String[] argumentList;
	private String shortVersion;
	private String longVersion;
	
	public Command(String[] argumentList, String shortVersion, String longVersion) {
		super();
		this.argumentList = argumentList;
		this.shortVersion = shortVersion;
		this.longVersion = longVersion;
	}

	public String getShortVersion() {
		return shortVersion;
	}

	public void setShortVersion(String shortVersion) {
		this.shortVersion = shortVersion;
	}

	public String getLongVersion() {
		return longVersion;
	}

	public void setLongVersion(String longVersion) {
		this.longVersion = longVersion;
	}

	public String[] getArgument() {
		return argumentList;
	}

	public void setArgument(String[] argument) {
		this.argumentList = argument;
	}

	
	public abstract boolean input();

	public abstract boolean process();

	public abstract boolean output();

	public void execute() {

		input();
		process();
		output();
	}

}
