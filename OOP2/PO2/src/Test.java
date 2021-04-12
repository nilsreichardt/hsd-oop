public class Test {
    public static void main(String[] args) {
        // Task 2 d)
        Kreis kreis = new Kreis(0, 0, 0, 2);
        kreis.setX(1);
        kreis.setY(1);
        kreis.setFarbe(1);
        System.out.println(kreis);

        // Task 5 a)
        Warpable myWarp = new Rakete(0,0, 0);
        System.out.println(myWarp.warp(0f));

        myWarp = new Warbird();
        System.out.println(myWarp.warp(0f));

        // Task 5 b)
        Comparable myComp1 = "Nachts ist es kälter als draußen.";
        Comparable myComp2 = "Frage: Was essen Löwen? Antwort: Essen.";
        System.out.println("Vergleich von myComp1 & myComp2 (String): " + myComp1.compareTo(myComp2));

        myComp1 = new Rakete(0, 0, 0);
        myComp2 = new Rakete(1, 1, 1);
        System.out.println("Vergleich von myComp1 & myComp2 (Rakete): " + myComp1.compareTo(myComp2));

        /*
         Funktioniert nicht, weil Warbird nicht Comparable implementiert.
         myComp1 = new Warbird();
         myComp2 = new Warbird();
         System.out.println("Vergleich von myComp1 & myCom2 (Warbird): " + myComp1.compareTo(myComp2));
        */
    }
}
