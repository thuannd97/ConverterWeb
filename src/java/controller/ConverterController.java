/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import converter.ejb.Converter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nguye
 */
@WebServlet(name = "ConverterController", urlPatterns = {"/convert"})
public class ConverterController extends HttpServlet {

    private converter.ejb.Converter converter = null;

    @Override
    public void init() throws ServletException {
       try{
            InitialContext ic = new InitialContext();
            converter = (Converter)ic.lookup(Converter.class.getName());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
         converter = null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DecimalFormat twoDigits = new DecimalFormat ("0.00");         
        String degree = request.getParameter("degree");
        System.out.println("degree:" + degree);
        if ( degree != null && degree.length() > 0 ) { 
                   double d = Double.parseDouble(degree); 
                   System.out.println("degree:" + d); 
            if (request.getParameter("fToC") != null ) { 
                System.out.println(twoDigits.format(converter.fToC(d))); 
                request.setAttribute("fToC", twoDigits.format(converter.fToC(d)));
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }     
            if (request.getParameter("cToF") != null ) { 
                System.out.println(twoDigits.format(converter.cToF(d))); 
                request.setAttribute("cToF", twoDigits.format(converter.fToC(d)));
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }  
        } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}
