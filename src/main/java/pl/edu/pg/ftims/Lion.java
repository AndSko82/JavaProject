package pl.edu.pg.ftims;

public class Lion extends Animal {
	private int height;
	private int weight;
	Lion(){
		name="Lion";
		height=0;
		weight=0;
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
		Main.f.field.setText("Enter height (cm):");		
		break;
		case 2: 
		height= Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter weight (kg):");
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
		case 4:
		Main.f.field.setText("Enter height (cm):");
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
			case 4:
			height=Integer.valueOf(Main.f.tf.getText());
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
		return "Height: "+height+". Weight: "+weight;
		
	}

	@Override
	public void save() {
		Main.out.println(weight);
		Main.out.println(height);
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
		}	
	}
}
