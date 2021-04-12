import java.lang.reflect.Method; 
import java.lang.reflect.InvocationTargetException; 
import java.lang.IllegalAccessException; 
class Xhsush_hd86shdf_dfs 
{
public static void main(String[] args) throws Throwable
{
try {
// setup print stream to add positions to output
System.setOut(new FiveCodePrintStream(System.out));
} catch(Exception e) {
System.err.println("Internal 5Code setup error. Please contact support.");
}
Method s = null;
try {
s = Main.class.getMethod("main", String[].class); 
} catch(Exception findMainException) {
System.err.println("Error: Main method not found in class Main, please define the main method as:");
System.err.println("   public static void main(String[] args)");
System.err.println("or a JavaFX application class must extend javafx.application.Application");
throw new Exception("Xhsush_hd86shdf_dfs");
} 
if (s != null) { 
try {
s.invoke(new Xhsush_hd86shdf_dfs(), (Object)args); 
} catch(IllegalAccessException illegalAccessException) {
} catch(InvocationTargetException ivocationException) {
throw ivocationException.getCause();
}
}
}
}