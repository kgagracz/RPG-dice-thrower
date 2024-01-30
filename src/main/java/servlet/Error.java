package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

/**
 * Servlet handling errors
 *
 * @author Krystian Gagracz
 * @version 1.0
 */
@WebServlet("/Error")
public class Error extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException when a servlet-specific error occurs
     * @throws IOException when an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();
        String throwType = request.getParameter("throwType");
        String errorCode = request.getParameter("errorCode");
        String errorMessage = request.getParameter("errorMessage");
        out.println("<h1>Niepoprawne dane wejściowe:</h1>");
        if (throwType != null && !throwType.isBlank()) {
            out.println("<h3>" + throwType + " nie jest prawidłowym typem rzutu</h3>");
        }
        if (!errorCode.isBlank() || !errorMessage.isBlank()) {
            out.println("<br/><span><b>" + errorCode + "</b>" + " " + errorMessage + "</span>");

        }
    }
}
