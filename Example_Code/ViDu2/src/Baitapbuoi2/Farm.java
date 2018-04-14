package Baitapbuoi2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Farm {
	private List<Animal> animals;
	public Farm(List<Animal> _animals)
	{
		animals =_animals;
	}
	public int TotalAnimals() {
		System.out.println("=======================Total Animals====================");
		return animals.size();
	}

	public int TotalDucks() {
		System.out.println("=======================Total Ducks====================");
		int total = 0;
		for(int i=0;i<animals.size();i++)
		{
			if(animals.get(i) instanceof Duck)
			{
				total++;
			}
		}
		return total;
	}

	public int TotalSheeps() {
		System.out.println("=======================Total Sheeps====================");
		int total = 0;
		for(int i=0;i<animals.size();i++)
		{
			//if(animals.get(i).name.equals("Sheep"))
			if(animals.get(i) instanceof Sheep)
			{
				total++;
			}
		}
		return total;
	}
	
	public int TotalSick() {
		System.out.println("=======================Total Sicks====================");
		int total = 0;
		for(int i=0;i<animals.size();i++)
		{
			if(animals.get(i).hp<40)
			{
				//System.out.println(i+" "+animals.get(i).name+ " "+animals.get(i).hp);
				total++;
			}
		}
		return total;
	}
	
	public void WriteInfAnimals()
	{
		System.out.println("=======================Write file====================");
		try {
			File file =new File("D:\\data\\Data.txt");
			//PrintStream fileStream = new PrintStream(new File("D:\\Data.txt"));
			PrintWriter fileStream = new PrintWriter(new FileOutputStream(file)) ;

			StringBuffer str = new StringBuffer();
			for(int i =0;i<animals.size();i++)
			{
				str.delete(0, str.length());
				if(animals.get(i) instanceof Duck)
				{
					str.append("D ");
				}else{
					str.append("S ");
				}
				str.append(animals.get(i).hp+" "+animals.get(i).eager+" "+animals.get(i).age+" "+animals.get(i).x+" "+animals.get(i).y);

				fileStream.println(str.toString());
				fileStream.flush();
			}
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ReadInfAnimals()
	{
		System.out.println("=======================Read file====================");
		try {
			File file =new File("D:\\data\\Data.txt");
			//PrintStream fileStream = new PrintStream(new File("D:\\Data.txt"));
			BufferedReader bf = new BufferedReader(new FileReader(file));
			//StringBuffer str = new StringBuffer();
			List<Animal> lst = new ArrayList<Animal>();
			String line;
			while((line = bf.readLine())!=null)
			{
				if(line.charAt(0)=='D') {
					String[] duck = new String[line.split(" ").length];
					duck = line.split(" ");
					Duck d = new Duck(Integer.parseInt(duck[1]),Integer.parseInt(duck[2]),
							Integer.parseInt(duck[3]),Integer.parseInt(duck[4]),Integer.parseInt(duck[5]));
					lst.add(d);
				}
				else{
					String[] sheep = new String[line.split(" ").length];
					sheep =line.split(" ");
					Sheep s = new Sheep(Integer.parseInt(sheep[1]),Integer.parseInt(sheep[2]),
							Integer.parseInt(sheep[3]),Integer.parseInt(sheep[4]),Integer.parseInt(sheep[5]));
					lst.add(s);
				}
			}
			bf.close();
			for(int i =0;i<animals.size();i++)
			{
				System.out.println(animals.get(i).name+", HP= "+animals.get(i).hp+", Eager= "+animals.get(i).eager+", Age= "+
						animals.get(i).age+", Position ("+animals.get(i).x+","+animals.get(i).y+") ");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
