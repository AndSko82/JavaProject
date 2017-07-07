package pl.edu.pg.ftims;

public abstract class Animal {
	protected String name;
	protected int encNumb;
	int i;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEncNumb() {
		return encNumb;
	}

	public void setEncNumb(int encNumb) {
		this.encNumb = encNumb;
	}

	public abstract void set();
	public abstract void setf(int a);

	public abstract String show();
	
	public abstract void save();
	public abstract void load(int a);

}
