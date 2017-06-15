
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicClasses.Calc;


public class CalcServler extends HttpServlet {
    ArrayList strStore = new ArrayList();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            
            
            Calc c = new Calc();
            
            String one = request.getParameter("one");
            String two = request.getParameter("two");
            String operation = request.getParameter("operation");
            
           Integer oneI = Integer.valueOf(one);
           Integer twoI = Integer.valueOf(two);
          
           String resultStr = one + " " + c.outputPage(operation) + " " + two +
                   " = " + c.calculation(oneI, twoI, operation);
           strStore.add(resultStr);
  //         c.outputConsole(c.calculation( oneI, twoI, operation));
          
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

// output all operation which user calculate
            for (Object s: strStore){
                out.println("<h1> " + s.toString() +  "</h1>");
            }

            out.println("</body>");
            out.println("</html>");
        }
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
