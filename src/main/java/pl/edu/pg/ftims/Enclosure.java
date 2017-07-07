package pl.edu.pg.ftims;

public class Enclosure {
	private int aniNumb;

	public Enclosure() {
		aniNumb = 0;
	}

	public int getAniNumb() {
		return aniNumb;
	}

	public void setAniNumb(int aniNumb) {
		this.aniNumb = aniNumb;
	}

	public void incAniNumb() {
		aniNumb++;
	}

	public void decAniNumb() {
		aniNumb--;
	}

}
