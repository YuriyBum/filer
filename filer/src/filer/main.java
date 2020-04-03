package filer;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.InputStreamReader;
import java.net.*;
import java.net.URL;

public class main {

	public static void main(String[] args) {
		

		//FILE REST-API CODE	
	System.out.println("Insert data creating started: ");
		 
		 BufferedWriter br = null;

 
 File kushat = new File("kushat.txt");
		  
		  File export = new File("ans.txt");
		  
		  File exportask = new File("ask.txt");
		  
		  try { if (!export.exists()) export.createNewFile();
		  System.out.println("Answer file created");} catch (IOException e)
		  {System.out.println("Export file creating failed: " + e);}
		  
		  try { if (!exportask.exists()) exportask.createNewFile();
		  System.out.println("Ask file created");} catch (IOException e)
		  {System.out.println("Export file creating failed: " + e);}
		  
		  
		  try { PrintWriter pw = new PrintWriter(kushat);
		  
		  
		  } catch (FileNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		  
		  
		  //«аписываем строку до начала текста 
		  String s = "('"; String sa =
		  "INSERT INTO `wp_ansDATA` (`ID`, `ANS`) VALUES "; String squ =
		  "INSERT INTO `wp_askDATA` (`ID`, `ASK`) VALUES ";
		  
		  int askid = 0; 
		  int ansid = 0;
		  
		 
		  try(FileReader reader = new FileReader("kushat.txt")) { // читаем посимвольно
		  int c; 
		  while((c=reader.read())!=-1){
		  
		  System.out.print((char)c); if ((char)c!='\n' || (char)c!='-'|| (char)c!='=')
		  s=s+(char)c;
		  
		  switch ((char)c) // начало оператора 
		   { case '.': { ansid++; 
		   String temp_str = String.valueOf(ansid); 
		   sa = sa + "('" + temp_str + "', '" + s +
		  "'),"; 
		  System.out.println(""); temp_str = "";  s = "";
		  
		  break; } 
		   case '!': { ansid++; 
		   String temp_str = String.valueOf(ansid); 
		   sa =
		  sa + "('" + temp_str + "', '" + s + "'),"; 
		  System.out.println(""); s = "";
		  temp_str = "";  
		  break;
		  } case '?': 
		  { askid++;
		  String temp_str = String.valueOf(askid); 
		  squ = squ + "('" + temp_str + "', '" + s + "'),";
		  System.out.println(""); 
		  temp_str = "";  s = ""; break; }
		  
		  };
		  
		  } try { PrintWriter pw = new PrintWriter(export); 
		  PrintWriter pwa = new
		  PrintWriter(exportask); 
		  pw.print(sa); 
		  pwa.print(squ); 
		  pw.close();
		  pwa.close();
		  } catch (IOException ex) {System.out.println("Write failed 33 "
		  + ex);}
		  
		  } catch(IOException ex){
		  
		 System.out.println("Failed reading: " + ex.getMessage());
		 } finally {
		  System.out.println("Query writing finished successfully! "); }
		

	}

}
