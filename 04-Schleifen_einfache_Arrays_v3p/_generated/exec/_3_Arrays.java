class _3_Arrays
{
public static void main(String[] args)
{ System.setOut(new FiveCodePrintStream(System.out));

int[] zahlenFeld = new int[5];

for(int i = 0; i < zahlenFeld.length; i++) {
	zahlenFeld[i] = i + 1;
}
for(int i = 0; i < zahlenFeld.length; i++) {
	System.out.print(zahlenFeld[i] + " ");
}
int[] anderesFeld = zahlenFeld;

zahlenFeld[0] = 10;

System.out.println("");
System.out.println("zahlenFeld[0]: " + zahlenFeld[0]);
System.out.println("anderesFeld[0]: " + anderesFeld[0]);

}


_3_Arrays() {
}
}