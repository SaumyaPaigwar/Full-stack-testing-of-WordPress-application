package test.java.Integration.FunctionalRest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCsv 
{
public List<String> csvRead() throws IOException
{
	List<String> list = new ArrayList<String>();
	CSVReader csv = new CSVReader(new FileReader(new File("data/csvFile.csv")));
	String []line;
	while((line = csv.readNext())!=null)
	{
		for(int i =0 ;i<line.length;i++)
		{
			list.add(line[i]);
			//System.out.println(line[i]);
		}
	}
	//System.out.println(list);
	return list;
	
}

/*public static void main(String []args) throws IOException
{
	ReadFile r = new ReadFile();
	r.csvRead();
}*/
}
