package RaceResults;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

import TimeDuration.TimeDuration;
import TimeDuration.BadBadValueException;


/**
 * 
 * @author jeandavid
 * The code doesn't handle the equality case of 2 racers. 
 *
 */
public class RaceResults {

	class Racer {
		TimeDuration time;
		String tagNumbers;

		public Racer(TimeDuration time, String tagNumbers) {
			this.time = Objects.requireNonNull(time);
			this.tagNumbers = Objects.requireNonNull(tagNumbers);
		}

		public int getTime() {
			return time.getSeconds();
		}

		@Override
		public String toString() {
			return "Tag : " + tagNumbers + " result time : " + time;
		}
	}

	private HashSet<Racer> set;

	public RaceResults() {
		this.set = new HashSet<>();
	}

	private void onNewResults(String tagNumber, TimeDuration resultTime) {
		if (tagNumber == null) {
			throw new NullPointerException("Tag number cannot be null");
		}
		if (resultTime == null) {
			throw new NullPointerException("resultTime cannot be null");
		}
		if (resultTime.getSeconds() < 0) {
			throw new IllegalArgumentException("resultTime cannot be negativ");
		}
		set.add(new Racer(resultTime, tagNumber));
	}

	public void printResults() {
		set.stream().sorted(Comparator.comparing(Racer::getTime)).forEach(System.out::println);
	}

	public static void main(String[] args) throws BadBadValueException {
		RaceResults race = new RaceResults();
		race.onNewResults("david", new TimeDuration(58188));
		race.onNewResults("jean-david", new TimeDuration(148));
		race.onNewResults("jeanne", new TimeDuration(745));
		race.onNewResults("christophe", new TimeDuration(5888));
		race.onNewResults("jean", new TimeDuration(27528));
		race.printResults();
	}
}
