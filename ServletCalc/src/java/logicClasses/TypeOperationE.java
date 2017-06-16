package logicClasses;

public enum TypeOperationE {
    ADD("+"),
    SUBSTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");
    
String operationSign;

    private TypeOperationE(String operationSign) {
        this.operationSign = operationSign;
    }

public String getSingOfOperation(){
    return operationSign;
}
    
}
