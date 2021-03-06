
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logicClasses.Calc;
import logicClasses.TypeOperationE;


public class ServletCalc extends HttpServlet {
 
// for storing all users operations    
    HashMap<String, ArrayList> operationsAllUsers = new HashMap<>();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
// create session for store user param       
        HttpSession session = request.getSession(true);
        
     //   ArrayList strStore  ;
        ArrayList strStoreInSession;
    
        if (session.isNew()){
            strStoreInSession = new ArrayList();
        }
        else {
        strStoreInSession = (ArrayList)session.getAttribute("strCalc");
                }          
        
        
        try  {
            
            
            Calc c = new Calc();
            
            String one = request.getParameter("one");
            String two = request.getParameter("two");
            String operation = request.getParameter("operation");
            
           Integer oneI = Integer.valueOf(one);
           Integer twoI = Integer.valueOf(two);
          
           String resultStr = one + " " + c.outputPage(operation) + " " + two +
                   " = " + c.calculation(oneI, twoI, operation);
           strStoreInSession.add(resultStr);
  //         c.outputConsole(c.calculation( oneI, twoI, operation));
         
           session.setAttribute("strCalc", strStoreInSession);
           
  // add Session attribute
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalcServler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalcServler at " + request.getContextPath() + "</h1>");
//            out.println("<h1> " + oneI + c.outputPage(operation) +
//                    twoI  + " = " + c.calculation(oneI, twoI, operation) + "</h1>");
            out.println ("<h1> " + resultStr + "</h1>" );
       
            operationsAllUsers.put(request.getSession().getId(), strStoreInSession);
            
            out.println("<h1> " + "KeySet" +   operationsAllUsers.keySet()  + " " +
              operationsAllUsers.keySet().getClass() + "</h1>");
           
            for (String s : operationsAllUsers.keySet()){
      // s - key (sessionId)   ;  operationsAllUsers.get(s) -- value (ArrayList of operation)           
            out.println ("<h1> " + s + " " + operationsAllUsers.get(s)  + "<h1> "); 
            
//                for ( String str : operationsAllUsers.get(s) ){
//                    
//                }
                    }
            
            
// output all operation which user calculate from ArrayList
//            for (Object s: strStore){
//                out.println("<h1> " + s.toString() +  "</h1>");
//            }
//store user operation in Session


// output all operation which user calculate from Session attribute              
           out.println("<h1> " + "Session id: " + request.getSession().getId() +  "</h1>");
            for (Object str: strStoreInSession){
                 out.println("<h1 style =\"color: red\">" +  str+ "</h1>");
             }
             
             
             
            out.println("</body>");
            out.println("</html>");
        }
  // add page with error 
        catch (Exception e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
