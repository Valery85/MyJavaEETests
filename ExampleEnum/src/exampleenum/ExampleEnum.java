
package exampleenum;

public class ExampleEnum {
  
    public static void main(String[] args) {
        
        System.out.println("From class  = " + (new MyClassAsEnum("ADD").str) + " "
                + MyClassAsEnum.ADD.str  );
        System.out.println("From enum = " + MyEnum.ADD + " " + MyEnum.ADD.getValue());

//output all field names of enum and correspondent values        
        for (MyEnum el : MyEnum.values()){
            System.out.println("field name = " + el + 
                                " value = " + el.getValue());
        }
        
    }
}
