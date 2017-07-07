package pl.edu.pg.ftims;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ManageZOO {
	static int selected;
	static int i;
	static int currRow;
	
	public static void display(){
		String[]data=new String[4];
		Main.f.model.setRowCount(0);
		for(int i=0;i<Main.list.size();i++){
		data[0]=String.valueOf(i+1);
		data[1]=Main.list.get(i).getName();
		data[2]=Main.list.get(i).show();
		data[3]=String.valueOf(Main.list.get(i).getEncNumb());
		Main.f.model.addRow(data);
		}
		Main.f.setButtons();
	}
	
	public static void addAnimal(){
		final Frame select = new Frame();
		
		select.setBounds(400,350,250,300);
		select.setLayout(null);
		select.setBackground(new Color(212,208,200));
		select.setVisible(true);
		select.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				select.dispose();				
			}			
		});
		Label choose=new Label("Choose animal:");
		JRadioButton[] rb= {new JRadioButton("Eagle"),new JRadioButton("Ostrich"),
				new JRadioButton("Lion"),new JRadioButton("Elephant"),
				new JRadioButton("Crocodile",false),new JRadioButton("Turtle"),
				new JRadioButton("Newt"),new JRadioButton("Salamander")};
		ButtonGroup cb=new ButtonGroup();
		final Button Ok=new Button("Ok");
		choose.setBounds(75,50,100,20);
		Ok.setBounds(100,250,40,25);
		Ok.setEnabled(false);
		select.add(Ok);
		select.add(choose);
		int y=75;
		for(i=0;i<rb.length;i++){
			rb[i].setBounds(75,y,100,20);
			rb[i].setSelected(false);
			rb[i].setBackground(new Color(212,208,200));
			y+=20;
			cb.add(rb[i]);
			select.add(rb[i]);
			rb[i].addActionListener(new ActionListener(){
				int j=i;
				public void actionPerformed(ActionEvent e) {
					selected=j;
					Ok.setEnabled(true);
				}
				
			});
		}
		Ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			select.dispose();
			Main.f.enter.setVisible(true);
			switch(selected){
			case 0:
				Main.list.add(new Eagle());
			break;
			case 1:
				Main.list.add(new Ostrich());		
				break;
			case 2:
				Main.list.add(new Lion());
				break;
			case 3:
				Main.list.add(new Elephant());
				break;
			case 4:
				Main.list.add(new Crocodile());
				break;
			case 5:
				Main.list.add(new Turtle());
				break;
			case 6:
				Main.list.add(new Newt());
				break;
			case 7:
				Main.list.add(new Salamander());
				break;
			}
			Main.f.counter=0;
			Main.list.get(Main.list.size()-1).set();		
			}
			
		});
		Main.f.setButtons();
	}
	public static void modify(){
		Main.f.enter.setVisible(true);
		currRow=Main.f.table.getSelectedRow();
		Main.list.get(currRow).set();
	}
	public static void modField(){
		final Frame choice = new Frame();
		ButtonGroup fg= new ButtonGroup();
		Label choose=new Label("Choose field:");
		final Button Ok = new Button("Ok");
		JRadioButton[]fields = {new JRadioButton("Enclosure"),new JRadioButton("Feather color"),
		new JRadioButton("Wingspan"),new JRadioButton("Weight"),new JRadioButton("Height"),
		new JRadioButton("Age"),new JRadioButton("Length"),new JRadioButton("Scale color")};
		for(i=0;i<fields.length;i++){
			fg.add(fields[i]);
			fields[i].setSelected(false);
			fields[i].setBackground(new Color(212,208,200));
			choice.add(fields[i]);
			fields[i].addActionListener(new ActionListener(){
				int j=i;
				public void actionPerformed(ActionEvent e) {
				selected=j;	
				Ok.setEnabled(true);
				}
				
			});
		}
		choose.setBounds(75, 50, 100, 20);
		fields[0].setBounds(75,75,100,20);
		choice.add(choose);
		choice.setBounds(450,350,250,220);
		choice.setLayout(null);
		choice.setBackground(new Color(212,208,200));
		choice.setVisible(true);
		choice.add(Ok);
		Ok.setBounds(100,180,40,25);
		choice.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				choice.dispose();				
			}
		});
		Ok.setEnabled(false);
		Ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			choice.dispose();
			Main.f.enter.setVisible(true);
			currRow=Main.f.table.getSelectedRow();
			Main.f.counter=0;
			Main.list.get(currRow).setf(selected);
			}			
		});
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Eagle")){
		fields[1].setBounds(75,95,100,20);
		fields[2].setBounds(75,115,100,20);
		}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Ostrich")){
			fields[1].setBounds(75,95,100,20);
			fields[3].setBounds(75,115,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Lion")){
			fields[4].setBounds(75,95,100,20);
			fields[3].setBounds(75,115,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Elephant")){
			fields[4].setBounds(75,95,100,20);
			fields[3].setBounds(75,115,100,20);
			fields[5].setBounds(75,135,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Crocodile")){
			fields[6].setBounds(75,95,100,20);
			fields[3].setBounds(75,115,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Turtle")){
			fields[6].setBounds(75,95,100,20);
			fields[5].setBounds(75,115,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Newt")){
			fields[7].setBounds(75,95,100,20);
			fields[6].setBounds(75,115,100,20);
			}
		if (Main.list.get(Main.f.table.getSelectedRow()).getName().equals("Salamander")){
			fields[7].setBounds(75,95,100,20);
			fields[3].setBounds(75,115,100,20);
			}
	}
	
	public static void del(){
	Main.list.remove(Main.list.get(Main.f.table.getSelectedRow()));
	display();
	Main.f.setButtons();
	}

}
