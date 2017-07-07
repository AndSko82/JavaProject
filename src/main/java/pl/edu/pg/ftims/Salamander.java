package pl.edu.pg.ftims;

public class Salamander extends Animal {
	private String color;
	private int weight;
	Salamander(){
		name="Salamander";
		color="";
		weight=0;
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
		Main.f.field.setText("Enter weight (kg):");
		Main.f.StrInput=false;
		break;
		case 3: 	
		weight= Integer.valueOf(Main.f.tf.getText());
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
		case 3:
		Main.f.field.setText("Enter weight (kg):");
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
			case 3:
			weight=Integer.valueOf(Main.f.tf.getText());
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
		return "Scale color: "+color+". Weight: "+weight;
		
	}

	@Override
	public void save() {
		Main.out.println(color);
		Main.out.println(weight);
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
			weight=Integer.valueOf(FileInputOutput.input);
			break;
		}		
	}
}
