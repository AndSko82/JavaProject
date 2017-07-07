package pl.edu.pg.ftims;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class MainFrame extends Frame{
	private static final long serialVersionUID = 1L;
	Frame enter = new Frame();
	Frame Msg = new Frame();
	Label warning = new Label();
	Label field = new Label("Enter feather color: ");
	TextField tf=new TextField();
	Button Ok = new Button("Ok");
	Button MsgOk= new Button("Ok");
	Button[] GUI = new Button[7];
	boolean StrInput;
	int add;
	final JTable table;
	int counter;
	DefaultTableModel model = new DefaultTableModel();
	MainFrame(){	
		setBounds(300,300,700,500);
		setBackground(new Color(212,208,200));
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){		
				System.exit(0);
			}
		   });	
		setLayout(null);
		setTitle("ZOO Manager v1.0");
		int y=70;
		for(int i=0;i<7;i++){
		switch(i){
		case 0:GUI[i] = new Button("Show table");
		break;
		case 1:GUI[i] = new Button("Add Animal");	
		break;
		case 2:GUI[i] = new Button("Modify Animal");	
		break;
		case 3:GUI[i] = new Button("Modify Field");		
		break;
		case 4:GUI[i] = new Button("Delete Animal");
		break;
		case 5:GUI[i] = new Button("Save");
		break;
		case 6:GUI[i] = new Button("Load");
		break;
		}
		if (i<5){
		GUI[i].setBounds(20,y,90,40);
		y+=50;
		}
		add(GUI[i]);
		}
		GUI[2].setEnabled(false);
		GUI[3].setEnabled(false);
		GUI[4].setEnabled(false);
		GUI[5].setBounds(150,400,75,40);
		GUI[6].setBounds(225,400,75,40);
		String[]column={"ID","Animal","Attributes","Enc. No"};
		for(int i=0;i<column.length;i++){
		model.addColumn(column[i]);
		}
		table = new JTable(model){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
	            return false;               
	    };
		};
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(45);
		table.getColumnModel().getColumn(2).setPreferredWidth(280);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	table.addMouseListener(new java.awt.event.MouseAdapter() {
	        	    public void mouseClicked(java.awt.event.MouseEvent evt) {
						if (!table.getSelectionModel().isSelectionEmpty()) {
							GUI[2].setEnabled(true);
							GUI[3].setEnabled(true);
							GUI[4].setEnabled(true);
						}
	        	    	else{
	        	    		GUI[2].setEnabled(false);
	        	    		GUI[3].setEnabled(false);	
	        	    		GUI[4].setEnabled(false);
	        	    	}
	        	        }   	    
	        	});
	           
	        }
	    });
		final JScrollPane pane= new JScrollPane(table);
		pane.setBounds(150,70,500,300);
		pane.setVisible(false);
		add(pane);
		GUI[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			if (GUI[0].getLabel()=="Show table"){
				pane.setVisible(true);
				GUI[0].setLabel("Hide table");
			}
			else{
				pane.setVisible(false);
				GUI[0].setLabel("Show table");	
			}
			
			}		
		});
		GUI[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {			
				try{
				if (Main.list.size()>=Main.ANIMAL_MAX)
				{
					
					throw new AnimalLimitReachedException();
				}
				ManageZOO.addAnimal();	
				add=1;
				}catch(AnimalLimitReachedException e){
				Msg.setVisible(true);
				warning.setText("Warning! Animal Limit Reached.");
				}
			}			
		});
		GUI[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			ManageZOO.modify();	
			add=2;
			}		
		});
		GUI[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			ManageZOO.modField();
			add=3;
			}		
		});
		GUI[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			ManageZOO.del();	
			}		
		});
		GUI[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			try {
				FileInputOutput.save();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			}		
		});
		GUI[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
			try {
				FileInputOutput.load();
				ManageZOO.display();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
			}		
		});
		enter.setLayout(null);
		field.setBounds(35, 40, 140, 20);
		enter.setBounds(400,400,180,150);
		tf.setBounds(40,65,100,20);
		Ok.setBounds(70,110,40,25);
		Ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
				if (!StrInput&&(Integer.valueOf(tf.getText())>10000||Integer.valueOf(tf.getText())<0)){
						throw new InputOutOfRangeException();
					}
				counter++;
				switch(add){
				case 1:
				Main.list.get(Main.list.size()-1).set();
				break;
				case 2:
				Main.list.get(ManageZOO.currRow).set();
				break;
				case 3:
				Main.list.get(ManageZOO.currRow).setf(ManageZOO.selected);
				break;
				}
				}catch(NumberFormatException|InputOutOfRangeException e1){
				Msg.setVisible(true);
				warning.setText("Warning! Enter value 0-10000");
				}
			}
			
		});
		enter.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
			enter.dispose();
			counter=0;
			}			
		});
		enter.setBackground(new Color(212,208,200));
	enter.add(field);
	enter.add(tf);
	enter.add(Ok);
	enter.setVisible(false);
	Msg.setLayout(null);
	Msg.setBackground(new Color(212,208,200));
	Msg.setBounds(400,400,220,160);
	warning.setBounds(20,50,180,20);
	Msg.add(warning);
	MsgOk.setBounds(90,115,40,25);
	MsgOk.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			Msg.dispose();			
		}		
	});
	Msg.add(MsgOk);
	Msg.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			Msg.dispose();
		}
	});
	}
public void setButtons(){
	GUI[2].setEnabled(false);
	GUI[3].setEnabled(false);
	GUI[4].setEnabled(false);
	
}
}
