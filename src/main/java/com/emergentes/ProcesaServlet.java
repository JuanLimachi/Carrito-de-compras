package com.emergentes;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("En el metodo GET del servlet");
        //  Obtener acceso al objeto session
        HttpSession ses = request.getSession();
        //  Se elimina la sesion
        ses.invalidate();
        //  Transferir el control a index.jsp
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("En el metodo POST del servlet");
        //  Recuperar el producto enviado desde el formulario
        String producto = request.getParameter("producto");
        //  Se obtiene el acceso a la session
        HttpSession ses = request.getSession();
        //  Se obtiene la lista que esta como atributo de session
        ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
        //  A la coleccion se adiciona el elemento "producto"
        lista.add(producto);
        //  Se redirecciona a index.jsp
        response.sendRedirect("index.jsp");
    }
}
