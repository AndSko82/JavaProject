package pl.edu.pg.ftims;

public class Eagle extends Animal {
	private String color;
	private int wingspan;
	Eagle(){
		name="Eagle";
		color="";
		wingspan=0;
	}

	@Override
	public void set() {
		switch(Main.f.counter){
		case 0:
		Main.f.field.setText("Enter enclosure number:");
		Main.f.StrInput=false;
		break;
		case 1:
		encNumb=Integer.valueOf(Main.f.tf.getText());
		Main.f.field.setText("Enter feather color:");
		Main.f.StrInput=true;
		break;
		case 2: 
		color= Main.f.tf.getText();
		Main.f.field.setText("Enter wingspan (cm):");
		Main.f.StrInput=false;
		break;
		case 3: 	
		wingspan= Integer.valueOf(Main.f.tf.getText());
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
		case 1:
		Main.f.field.setText("Enter feather color:");
		Main.f.StrInput=true;
		break;
		case 2:
		Main.f.field.setText("Enter wingspan (cm):");
		Main.f.StrInput=false;
		break;
		}
		}
		else{
			switch(a){
			case 0:
			encNumb=Integer.valueOf(Main.f.tf.getText());
			break;
			case 1:
			color=Main.f.tf.getText();
			break;
			case 2:
			wingspan=Integer.valueOf(Main.f.tf.getText());
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
		return "Feather color: "+color+". Wingspan: "+wingspan;
		
	}

	@Override
	public void save() {
		Main.out.println(color);
		Main.out.println(wingspan);
		
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
		wingspan=Integer.valueOf(FileInputOutput.input);
		break;
	}		
	}



}
