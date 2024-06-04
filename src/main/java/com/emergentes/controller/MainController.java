
package com.emergentes.controller;

import com.emergentes.Estudiantes;
import com.emergentes.bean.BeanEstudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            BeanEstudiantes dao = new BeanEstudiantes();

            int id;
            Estudiantes estudiante = new Estudiantes();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            System.out.println(action);

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    estudiante=dao.buscar(id);
                                        
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(id);
                    
                    response.sendRedirect(request.getContextPath()+"/MainController");
                    break;
                case "view":
                    List<Estudiantes> lista = dao.listarTodos();
                                       
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        int id = Integer.parseInt(request.getParameter("id"));      
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        
        

        Estudiantes estudiante = new Estudiantes();
                
        estudiante.setFechaNacimiento(convertirFecha(fechaNacimiento));
        
        estudiante.setId(id);
        estudiante.setNombre(nombre);
        estudiante.setApellidos(apellidos);
        estudiante.setEmail(email);

        BeanEstudiantes dao = new BeanEstudiantes();
        
        if (id == 0) {
            
            try {
                dao.insertar(estudiante);
                response.sendRedirect(request.getContextPath() + "/MainController");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            
            try {
                dao.editar(estudiante);
                response.sendRedirect(request.getContextPath() + "/MainController");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        
        
    }
    
    public Date convertirFecha(String fecha){
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return fechaBD;
        
    }
    
    
}
