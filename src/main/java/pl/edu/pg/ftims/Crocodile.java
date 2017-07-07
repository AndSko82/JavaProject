package pl.edu.pg.ftims;

public class Crocodile extends Animal {
	private int length;
	private int weight;
	Crocodile(){
		name="Crocodile";
		length=0;
		weight=0;
	}

	@Override
	public void set() {
		Main.f.StrInput=false;
		switch(Main.f.counter){
		case 0:
		Main.f.field.setText("Enter Enclosure number: ");
		break;
		case 1:
		encNumb=Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter length (cm): ");		
		break;
		case 2: 
		length= Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter weight (kg): ");
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
		Main.f.StrInput=false;
		if (Main.f.counter==0){
		switch(a){
		case 0:
		Main.f.field.setText("Enter enclosure number:");
		break;
		case 6:
		Main.f.field.setText("Enter length (cm):");
		break;
		case 3:
		Main.f.field.setText("Enter weight (kg):");
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
		return "Length: "+length+". Weight: "+weight;
		
	}

	@Override
	public void save() {
		Main.out.println(length);
		Main.out.println(weight);
	}

	@Override
	public void load(int a){
		switch(a){
		case 1:
			encNumb=Integer.valueOf(FileInputOutput.input);
			break;
		case 2:
			length=Integer.valueOf(FileInputOutput.input);
			break;
		case 3:
			weight=Integer.valueOf(FileInputOutput.input);
			break;
		}
		
	}

}
