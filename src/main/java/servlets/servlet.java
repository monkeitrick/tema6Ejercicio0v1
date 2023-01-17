package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Catalogo;
import beans.Catalogo;

public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	doPost(request, response);	
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset-UTF-8");
		PrintWriter out = response.getWriter();
		String[] libros=Catalogo.getLIBRO();
		ArrayList<String> seleccionados = new ArrayList<String>();
		if(request.getSession().getAttribute("seleccionados")!=null) {
			seleccionados=(ArrayList<String>) request.getSession().getAttribute("seleccionados");
		}
		String seleccionado = request.getParameter("selectLibro");
		if(seleccionados.contains(seleccionado)) {
			out.println("<h1>YA has seleccionado esto</h1>");
		}
		seleccionados.add(seleccionado);
		request.getSession().setAttribute("seleccionados",seleccionados );
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"es\">");
			out.println("<head>");
			out.println("<title>tema 6 ejercicio 0</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Ejercicio 0</h1>");
			out.println("<form action=\"index.html\" method=\"post\">");
			out.println("<select name=\"selectLibro\" id=\"selectLibro\">");
			for(int i=0; i<libros.length;i++) {
				if(seleccionado.equals(libros[i])) {
					out.println("<option value='"+libros[i]+"' selected>"+libros[i]+"</option>");
				}
				else {
					out.println("<option value='"+libros[i]+"'>"+libros[i]+"</option>");
				}
			}
			out.println("</select>");
			out.println("<input type=\"submit\" value=\"AGREGAR\" />");
			out.println("</form>");
			if(seleccionados.size()>0) {
				out.println("<h1>TU ELECCION</h1>");
				out.println("<ul>");
				for(int z=0;z<seleccionados.size();z++) {
					out.println("<li>"+seleccionados.get(z)+"</li>");
				}
				out.println("</ul>");
				
			}
			else {
				out.println("<h1>No se han elegido libros</h1>");
			}
			
		} finally {
			out.println("</body>");
			out.println("</html>");
		}
	}

}
