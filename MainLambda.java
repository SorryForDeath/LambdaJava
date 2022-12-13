import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;


@FunctionalInterface 
interface Str {
   String lam(String a, String b);
}


public class MainLambda {
	public static void main(String[] args) throws Exception {
		 //Вывод файла
		 FileReader r = new FileReader("C:\\T.txt");
		    try (Scanner s = new Scanner(r)) {
				while (s.hasNextLine()) {
					 System.out.println(s.nextLine());
				}
				s.close();
			}
		    r.close();
		    System.out.println();
		    
		    
		//Блок с поиском строки наибольшей длины
	    Str str = (a, b) -> {if((a.length() - b.length()) > 0) return a; else return b;};
	    String x = "";
	    FileReader reader = new FileReader("C:\\T.txt");
	    try (Scanner scan = new Scanner(reader)) {
			while (scan.hasNextLine()) {
		        x = str.lam(scan.nextLine(), x);
			}
			scan.close();
		}
	    reader.close();
	    
	    System.out.println("The biggest string is: " + x); 
	   
	    //Блок с поиском строки, в которой наибольшее кол-во гласных
	    HashSet<Character> CharSet = new HashSet<>(); 
	    CharSet.add('a'); CharSet.add('A'); CharSet.add('E'); CharSet.add('e'); CharSet.add('i'); CharSet.add('I'); 
	    CharSet.add('o'); CharSet.add('O'); CharSet.add('U'); CharSet.add('u'); CharSet.add('Y'); CharSet.add('y');
	    FileReader re = new FileReader("C:\\T.txt");
		x = "";
		Str gl = (a, b) -> {int s1 = 0; int s2 = 0;
		for (int i = 0; i < a.length(); i++) {
			if (CharSet.contains(a.charAt(i))) s1++;
		};
		for (int i = 0; i < b.length(); i++) {
		    if (CharSet.contains(b.charAt(i))) s2++;
		};
		if (s1 - s2 > 0) return a; else return b;
		};
		   try (Scanner sc = new Scanner(re)) {
			   while (sc.hasNextLine()) {
				    x = gl.lam(x, sc.nextLine());
			   }
			   sc.close();
		   }
		 re.close();
		 System.out.println("The string with the most vowels: " + x);
		    
	   //Блок с поиском строки, в которой наибольшее число заглавных
	    FileReader rea = new FileReader("C:\\T.txt");
	    x = "";
		Str lim = (a, b) -> {String buff; int s1 = 0; int s2 = 0;
		for (int i = 0; i < a.length(); i++) {
			buff = a.charAt(i) + " ";
		if (buff.matches("[A-Z]\s")) s1++;
		};
		for (int i = 0; i < b.length(); i++) {
			buff = b.charAt(i) + " ";
			if (buff.matches("[A-Z]\s")) s2++;
		};
		if (s1 - s2 > 0) return a; else return b;
		};
			 try (Scanner sca = new Scanner(rea)) {
				  while (sca.hasNextLine()) {
					   x = lim.lam(x, sca.nextLine());
				  }
				   sca.close();
			   }
			 rea.close();
			 System.out.println("The string with the most capital letters: " + x);
	}
}
