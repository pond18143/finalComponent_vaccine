/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentTable;
import model.Vaccine;

/**
 *
 * @author poramet
 */
public class updateVaccine extends HttpServlet {

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
        int inpId = Integer.parseInt(request.getParameter("id"));
        List<Integer> using = (List<Integer>) getServletContext().getAttribute("using");
        Vaccine std = StudentTable.findStudentById(inpId);
        synchronized (getServletContext()) {
            if (std != null) {
                model.Vaccine stuObj = new Vaccine();
                stuObj.setId(Integer.parseInt(request.getParameter("id")));
                stuObj.setDose(Integer.parseInt(request.getParameter("dose")));
                stuObj.setVaccine1(request.getParameter("vaccine1"));
                stuObj.setVaccine2(request.getParameter("vaccine2"));
                stuObj.setVaccine3(request.getParameter("vaccine3"));
                model.StudentTable.updateStudent(stuObj);
                request.getRequestDispatcher("updateVaccine.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("updateVaccine.jsp").forward(request, response);
            }
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
