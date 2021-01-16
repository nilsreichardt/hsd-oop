class _2_Verzweigung
{
public static void main(String[] args)
{ System.setOut(new FiveCodePrintStream(System.out));

double aktuelleGeschwindigkeit = 51.5;
double erlaubteMaxGeschwindigkeit = 50.0;

boolean istZuSchnell = aktuelleGeschwindigkeit > erlaubteMaxGeschwindigkeit;

if(istZuSchnell) {
  System.out.println("zu schnell");
} else {
  System.out.println("ok");
}


}


_2_Verzweigung() {
}
}