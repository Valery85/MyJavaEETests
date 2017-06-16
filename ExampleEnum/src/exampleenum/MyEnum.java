
package exampleenum;

public enum MyEnum {
    ADD("+"),
// public static final MyEnum ADD  = new MyEnum("+");     
    
    SUB("-"),
    MULT("*"),
    DIV("/");
    
String operation;

// constructor for enum

    private MyEnum(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }

}
