package game1model;

public class Score implements Comparable<Score> {
	int number;
	String name;
	
	public Score(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int compareTo(Score s) {
		return s.number - this.number;
	}
	
	public String toString() {
		return name + " " + number;
	}
}


