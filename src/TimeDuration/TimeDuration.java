package TimeDuration;

public class TimeDuration {
	private int seconds;

	

	public TimeDuration(Integer seconds) throws BadBadValueException {
		if (seconds == null) {
			throw new NullPointerException("seconds cannot be null.");
		}
		if (seconds < 0) {
			throw new BadBadValueException();
		}
		this.seconds = seconds;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TimeDuration)) {
			return false;
		}
		TimeDuration time = (TimeDuration) o;
		return seconds == time.getSeconds();
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int heure, minute, seconde;
		heure = seconds / 3600;
		minute = ((seconds % 3600) / 60);
		seconde = ((seconds % 3600) % 60);
		if (heure != 0) {
			sb.append(heure + "h ");
		}
		if (minute != 0) {
			sb.append(minute + "m ");
		}
		sb.append(seconde + "s");
		return sb.toString();
	}

	public static void main(String[] args) throws BadBadValueException {
		System.out.println(new TimeDuration(0).toString());
		System.out.println(new TimeDuration(732).toString());
		System.out.println(new TimeDuration(7242).toString());
		System.out.println(new TimeDuration(-7242).toString());
	}
}
