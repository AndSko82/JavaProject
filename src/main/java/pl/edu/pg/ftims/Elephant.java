package pl.edu.pg.ftims;

public class Elephant extends Animal {
	private int weight;
	private int height;
	private int age;
	Elephant(){
		name="Elephant";
		weight=0;
		height=0;
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
		Main.f.field.setText("Enter weight (kg):");		
		break;
		case 2: 
		weight= Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter height (cm):");
		break;
		case 3: 	
		height= Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter age:");
		break;
		case 4:
		age=Integer.valueOf(Main.f.tf.getText());
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
		case 4:
		Main.f.field.setText("Enter height (cm):");
		break;
		case 3:
		Main.f.field.setText("Enter weight (kg):");
		break;
		case 5:
		Main.f.field.setText("Enter age: ");
		break;
		}
		}
		else{
			switch(a){
			case 0:
			encNumb=Integer.valueOf(Main.f.tf.getText());
			break;
			case 4:
			height=Integer.valueOf(Main.f.tf.getText());
			break;
			case 3:
			weight=Integer.valueOf(Main.f.tf.getText());
			break;
			case 5:
			age=Integer.valueOf(Main.f.tf.getText());
			}
			Main.f.counter=0;
			Main.f.enter.dispose();
			ManageZOO.display();
			Main.f.tf.setText("");
		}
	}
		
	@Override
	public String show() {
		return "Weight: "+weight+". Height: "+height+". Age: "+age;
		
	}

	@Override
	public void save() {
		Main.out.println(weight);
		Main.out.println(height);
		Main.out.println(age);
	}


	@Override
	public void load(int a) {
		switch(a){
		case 1:
			encNumb=Integer.valueOf(FileInputOutput.input);
			break;
		case 2:
			weight=Integer.valueOf(FileInputOutput.input);
			break;
		case 3:
			height=Integer.valueOf(FileInputOutput.input);
			break;
		case 4:
			age=Integer.valueOf(FileInputOutput.input);
			break;	
		}		
	}
}
