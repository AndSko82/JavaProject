package pl.edu.pg.ftims;

public class Turtle extends Animal {
	private int length;
	private int age;
	Turtle(){
		name="Turtle";
		length=0;
		age=0;
	}

	@Override
	public void set() {
		Main.f.StrInput=false;
		switch(Main.f.counter){
		case 0:
		Main.f.field.setText("Enter Enclosure number:");
		break;
		case 1:
		encNumb=Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter length (cm):");		
		break;
		case 2: 
		length= Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter age:");
		break;
		case 3: 	
		age= Integer.valueOf(Main.f.tf.getText());
		Main.f.counter=0;
		Main.f.enter.dispose();
		ManageZOO.display();
		break;
		}
		Main.f.tf.setText("");	
	}

	@Override
	public void setf(int a) {
		Main.f.StrInput=false;
		if (Main.f.counter==0){
		switch(a){
		case 0:
		Main.f.field.setText("Enter enclosure number:");
		break;
		case 6:
		Main.f.field.setText("Enter length (cm):");
		break;
		case 5:
		Main.f.field.setText("Enter age:");
		break;
		}
		}
		else{
			switch(a){
			case 0:
			encNumb=Integer.valueOf(Main.f.tf.getText());
			break;
			case 6:
			length=Integer.valueOf(Main.f.tf.getText());
			break;
			case 5:
			age=Integer.valueOf(Main.f.tf.getText());
			break;
			}
			Main.f.counter=0;
			Main.f.enter.dispose();
			ManageZOO.display();
			Main.f.tf.setText("");
		}
	}
	@Override
	public String show() {
		return "Length: "+length+". Age: "+age;
		
	}

	@Override
	public void save() {
		Main.out.println(length);
		Main.out.println(age);
	}

	@Override
	public void load(int a) {
		switch(a){
		case 1:
			encNumb=Integer.valueOf(FileInputOutput.input);
			break;
		case 2:
			length=Integer.valueOf(FileInputOutput.input);
			break;
		case 3:
			age=Integer.valueOf(FileInputOutput.input);
			break;
		}
		
	}
}
