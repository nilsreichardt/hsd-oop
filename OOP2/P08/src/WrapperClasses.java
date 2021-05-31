public class WrapperClasses {
    public static void main(String[] args) {
        Integer wrapi = Integer.valueOf(3);
        wrapi = 23;

        Boolean bool = true;
        bool = false;
        Boolean booleanFromBool = bool.booleanValue();

        Character character = 'A';

        Double d = 125.23;
        Double fromD = d.doubleValue();

        Double d1 = new Double("asdf");
    }
}
