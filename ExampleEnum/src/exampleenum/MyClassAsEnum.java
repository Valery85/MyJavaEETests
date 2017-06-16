
package exampleenum;

public class MyClassAsEnum {
    
    public static final MyClassAsEnum ADD  = new MyClassAsEnum("+"); 
    public static final MyClassAsEnum SUB  = new MyClassAsEnum("-");
    public static final MyClassAsEnum MUL  = new MyClassAsEnum("*");
    public static final MyClassAsEnum DIV  = new MyClassAsEnum("/");

    String str;
    
    public MyClassAsEnum(String str) {
        this.str = str;
    }

}
