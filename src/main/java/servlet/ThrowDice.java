package servlet;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import model.HandledException;
import model.Model;

/**
 * Servlet responsible for throwing a dice and displaying results
 * @author Krystian Gagracz
 */
@WebServlet(name = "ThrowDice", urlPatterns = {"/ThrowDice"})
public class ThrowDice extends HttpServlet {
    private Model model;
    
    @Override
    public void init() {
        ServletContext context = getServletContext();
        model = (Model) context.getAttribute("model");
    }
    
    /**
     * Method parsing input from user to List (throwTimes, diceSize)
     * @param userInput input provided by user
     * @return List of integer (throwTimes, diceSize)
     */ 
    private List<Integer> parseUserInput(String userInput) {
        String userInputUpperCase = userInput.toUpperCase().trim();
        int numberOfThrows = Integer.parseInt(userInputUpperCase.split("K")[0]);
        int diceSize = Integer.parseInt(userInputUpperCase.split("K")[1]);
        return Arrays.asList(numberOfThrows, diceSize);
    }

    /**
    * Method checking if given string is in throw type format and displays validation fail massage
    * @param input string to check for correctness
    * @return boolean 
    */
    private boolean validateUserInput(String input){ 
        Pattern numberPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        /* this code looks like spaghetti, 
        beacouse is more reqdable than all conditions in one line */
        if(input == null) {
            return false;
        }
        //has proper length
        if(input.length() < 3 || input.isBlank()) {
            return false;
        }
        //has K letter
        if(!input.toUpperCase().contains("K")) {
            return false;
        }
        List<String> values = Arrays.asList(input.toUpperCase().split("K"));
        //throwType and diceSize are number
        if(!numberPattern.matcher(values.get(1)).matches() || !numberPattern.matcher(values.get(0)).matches()) {
            return false;
        }
        return true;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Integer> results = null;
        String throwType = "";
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("throwType")) {
                    throwType = cookie.getValue();
                    break;
                }
            }
        }
        
        try {
            throwType = request.getParameter("throwType");
            if(!validateUserInput(throwType)) {
                throw new HandledException(HandledException.ErrorCode.BAD_INPUT, "Nie podano danych wejściowych");
            }         
            Cookie throwTypeCookie = new Cookie("throwType", throwType);
            response.addCookie(throwTypeCookie);
            
            List<Integer> throwData = parseUserInput(throwType);
            results = model.throwDice(throwData.get(0), throwData.get(1));
        } catch (HandledException e) {
            getServletContext().getRequestDispatcher("/Error?errorCode="+e.getCode()+"&errorMessage="+e.getMessage()).forward(request, response);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Rzut kostką</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Wynik rzutów kostką " + throwType + ":</h1>");
            
            out.println("<ul>");
            results.forEach(result -> out.println("<li>"+result+"</li>"));
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
