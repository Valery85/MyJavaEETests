
package logicClasses;


public class Calc {
    
    public int calculation (int one, int two, String operation){
        if (operation.equalsIgnoreCase("add")){
           return one + two; 
        }
        else if (operation.equalsIgnoreCase("divide")){
            return one/two;
        }
        else if (operation.equalsIgnoreCase("substract")){
            return one - two;
        }
        else if (operation.equalsIgnoreCase("myltiply")){
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
        if (operation.equalsIgnoreCase("add")){
           return "+"; 
        }
        
        else if (operation.equalsIgnoreCase("divide")){
            return "/";
        }
        else if (operation.equalsIgnoreCase("substract")){
            return "-";
        }
        else if (operation.equalsIgnoreCase("myltiply")){
            return "*";
        }
        else return "Wrong operation";

    }
    
}
