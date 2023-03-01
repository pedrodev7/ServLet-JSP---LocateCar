import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cadastro")
public class CadastroPessoaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");

        if(name.equals("") || cpf.equals("") || email.equals("")){
            resp.setContentType("text/html");
            resp.getWriter().println("<h3> Dados Obrigatorios não preenchidos: Nome, CPF e Email </h3>");
        } else {
            req.setAttribute("name", name);
            req.setAttribute("cpf", cpf);
            req.setAttribute("email", email);

            RequestDispatcher rd = req.getRequestDispatcher("data.jsp");

            rd.forward(req, resp);

        }
    }
}
