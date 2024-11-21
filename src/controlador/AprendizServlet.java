package controlador;

import dao.AprendizDAO;
import modelo.Aprendiz;
import controlador.ConexionBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/AprendizServlet")
public class AprendizServlet extends HttpServlet {
    private AprendizDAO dao;

    @Override
    public void init() throws ServletException {
        Connection conexion = ConexionBD.getConnection();
        dao = new AprendizDAO(conexion);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Aprendiz> aprendices = dao.listarAprendices();
        request.setAttribute("aprendices", aprendices);
        request.getRequestDispatcher("formularios/listarAprendices.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String documento = request.getParameter("documento");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        Aprendiz aprendiz = new Aprendiz(0, nombre, apellido, documento, correo, telefono);
        dao.agregarAprendiz(aprendiz);

        response.sendRedirect("AprendizServlet");
    }
}
