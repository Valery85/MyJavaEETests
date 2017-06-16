
package logicClasses;


public class Calc {
    
    public int calculation (int one, int two, String operation){
//        if (operation.equalsIgnoreCase("add")){
//           return one + two; 
//        }
        if (operation.equalsIgnoreCase(TypeOperationE.ADD.toString())){
           return one + two;
        }
        else if (operation.equalsIgnoreCase(TypeOperationE.DIVIDE.toString())){
            return one/two;
        }
        else if (operation.equalsIgnoreCase(TypeOperationE.SUBSTRACT.toString())){
            return one - two;
        }
        else if (operation.equalsIgnoreCase(TypeOperationE.MULTIPLY.toString())){
            return one * two;
        }
        else 
            return -1 ;
    }
    
    public void outputConsole( int result ){
        if (result != -1){
            System.out.println(result);
        }
        else 
            System.out.println("Wrong operation or parameter");
    }
    
    public String outputPage(String operation){
        if (operation.equalsIgnoreCase(TypeOperationE.ADD.toString())){
           return TypeOperationE.ADD.getSingOfOperation(); 
        }
        
        else if (operation.equalsIgnoreCase(TypeOperationE.DIVIDE.toString())){
            return TypeOperationE.DIVIDE.getSingOfOperation();
        }
        else if (operation.equalsIgnoreCase(TypeOperationE.SUBSTRACT.toString())){
            return TypeOperationE.SUBSTRACT.getSingOfOperation();
        }
        else if (operation.equalsIgnoreCase(TypeOperationE.MULTIPLY.toString())){
            return TypeOperationE.MULTIPLY.getSingOfOperation();
        }
        else return "Wrong operation";

    }
    
}
