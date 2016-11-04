package fr.insalyon.telecom.mgl;



public class RomanNumberConverter {

	public static int convert(String romanNumber) {

		int [] tab =new int[127];
		for (int i=0; i<127; i++)
			tab[i]=-1;
		tab[73]=1;
		tab[86]=5;
		tab[88]=10;
		tab[76]=50;
		tab[67]=100;
		tab[68]=500;
		tab[77]=1000;
		
		int s=0;

		int l=romanNumber.length();
		
		boolean valid=true;
		for (int i=0; i<l;i++)
			if (tab[(int)(romanNumber.charAt(i))]==-1)
				valid=false;

		if (valid==false) {
			throw new IllegalArgumentException("Only I V X L C D M are available.");
		}
		else {
			for (int i=0; i<l-1; i++)
				if (tab[(int)(romanNumber.charAt(i))]<tab[(int)(romanNumber.charAt(i+1))])
					s=s-tab[(int)(romanNumber.charAt(i))];
				else
					s=s+tab[(int)(romanNumber.charAt(i))];
			s=s+tab[(int)(romanNumber.charAt(l-1))];
		}
		return s;
	}
	
	public static String convert(int number) {
		int th=number/1000;
		int hu=(number % 1000)/100;
		int de=(number % 100)/10;
		int un=number % 10;
		
		String s="";
		
		if ((number<=0) || (number>3333))
			throw new IllegalArgumentException("number between 0 and 3333");
		else {
			int i;
			for (i=0; i<th; i++)
				s=s+"M";
			
			if (hu<4)
				for (i=0; i<hu; i++)
					s=s+"C";
			else if (hu==4)
				s=s+"CD";
			else if (hu<9) {
				s=s+"D";
				for (i=5;i<hu;i++)
					s=s+"C";
			}
			else
				s=s+"CM";
				
			if (de<4)
				for (i=0; i<de; i++)
					s=s+"X";
			else if (de==4)
				s=s+"XL";
			else if (de<9) {
				s=s+"L";
				for (i=5;i<de;i++)
					s=s+"X";
			}
			else
				s=s+"XC";
				
			if (un<4)
				for (i=0; i<un; i++)
					s=s+"I";
			else if (un==4)
				s=s+"IV";
			else if (un<9) {
				s=s+"V";
				for (i=5;i<un;i++)
					s=s+"I";
			}
			else
				s=s+"IX";
			
			return s;
		}		
		
	}
	
	public static void main (String args[]) {
		System.out.println(convert(1437));
		System.out.println(convert("MCDXXXVII"));
	}
}
