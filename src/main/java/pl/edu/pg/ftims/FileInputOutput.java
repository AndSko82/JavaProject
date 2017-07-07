package pl.edu.pg.ftims;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileInputOutput{
	static Scanner sc;
	static String input;
	public static void save() throws FileNotFoundException{
		Main.out=new PrintWriter("lista.txt");
		for(int i=0;i<Main.list.size();i++){
			Main.out.println(Main.list.get(i).getName());
			Main.out.println(Main.list.get(i).getEncNumb());
			Main.list.get(i).save();
		}
		Main.out.close();
	}
	
	public static void load() throws FileNotFoundException{
		Main.list.clear();
		sc=new Scanner(new File("lista.txt"));
	int line=1;
	int aniName=0;
	while(sc.hasNextLine()){
		input=sc.nextLine();
	if (input.equals("Eagle")){
		aniName=line;
		Main.list.add(new Eagle());
	}
	else if (input.equals("Ostrich")){
			aniName=line;
			Main.list.add(new Ostrich());
		}
	else if (input.equals("Lion")){
		aniName=line;
		Main.list.add(new Lion());
	}
	else if (input.equals("Elephant")){
		aniName=line;
		Main.list.add(new Elephant());
	}
	else if (input.equals("Crocodile")){
		aniName=line;
		Main.list.add(new Crocodile());
	}
	else if (input.equals("Turtle")){
		aniName=line;
		Main.list.add(new Turtle());
	}
	else if (input.equals("Newt")){
		aniName=line;
		Main.list.add(new Newt());
	}
	else if (input.equals("Salamander")){
		aniName=line;
		Main.list.add(new Salamander());
	}
	else{
	Main.list.get(Main.list.size()-1).load(line-aniName);
	}
	line++;
	}
	sc.close();	
	}
}