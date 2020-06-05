package edu.up.br.LoCARdora.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.up.LoCARdora.entity.Veiculo;
import edu.up.br.LoCARdora.dao.VeiculoDao;

@WebServlet("/ServletImagemVeiculos")
public class ServletImagemVeiculos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public ServletImagemVeiculos() {
    	
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		if (id == null || id.equals("")) {
			
			return;
			
		}
		
		Veiculo veiculo = new VeiculoDao().buscar(Integer.parseInt(id));
		File f = new File(veiculo.getCaminhoImagem());
		@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(f);
		byte[] arrayImagem = new byte[(int) f.length()];
		fis.read(arrayImagem);
		response.getOutputStream().write(arrayImagem);
		
	}

}
