package pl.edu.pg.ftims;

public class Newt extends Animal {
	private String color;
	private int length;
	Newt(){
		name="Newt";
		color="";
		length=0;
	}

	@Override
	public void set() {
		switch(Main.f.counter){
		case 0:
		Main.f.field.setText("Enter Enclosure number:");
		Main.f.StrInput=false;
		break;
		case 1:
		encNumb=Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter scale color:");	
		Main.f.StrInput=true;
		break;
		case 2: 
		color= Main.f.tf.getText();
		Main.f.field.setText("Enter length (cm):");
		Main.f.StrInput=false;
		break;
		case 3: 	
		length= Integer.valueOf(Main.f.tf.getText());
		Main.f.counter=0;
		Main.f.enter.dispose();
		ManageZOO.display();
		break;
		}
		Main.f.tf.setText("");	
	}
	@Override
	public void setf(int a) {
		if (Main.f.counter==0){
		switch(a){
		case 0:
		Main.f.field.setText("Enter enclosure number:");
		Main.f.StrInput=false;
		break;
		case 7:
		Main.f.field.setText("Enter scale color:");
		Main.f.StrInput=true;
		break;
		case 6:
		Main.f.field.setText("Enter length (cm):");
		Main.f.StrInput=false;
		break;
		}
		}
		else{
			switch(a){
			case 0:
			encNumb=Integer.valueOf(Main.f.tf.getText());
			break;
			case 7:
			color=Main.f.tf.getText();
			break;
			case 6:
			length=Integer.valueOf(Main.f.tf.getText());
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
		return "Scale color: "+color+". Length: "+length;
		
	}

	@Override
	public void save() {
		Main.out.println(color);
		Main.out.println(length);
	}

	@Override
	public void load(int a) {
		switch(a){
		case 1:
			encNumb=Integer.valueOf(FileInputOutput.input);
			break;
		case 2:
			color=FileInputOutput.input;
			break;
		case 3:
			length=Integer.valueOf(FileInputOutput.input);
			break;
		}	
	}
}
