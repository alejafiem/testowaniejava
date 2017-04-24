package CustomMatcher.Matcher;

public class OperatingSystem {
	private int	nbOfBits;
	private	String name;
	private	String version;
	private int	releaseYear;
	
	public int getNbOfBits() {
		return nbOfBits;
	}
	public void setNbOfBits(int nbOfBits) {
		this.nbOfBits = nbOfBits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
}
