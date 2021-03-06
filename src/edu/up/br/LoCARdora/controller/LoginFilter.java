package edu.up.br.LoCARdora.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.up.LoCARdora.entity.Funcionario;

@WebFilter("/CadastroDeVeiculo.jsf")
public class LoginFilter implements Filter  {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse res = (HttpServletResponse)arg1;

		Funcionario u = (Funcionario) req.getSession().
				getAttribute("funcionario");

		if (u == null) {
			req.getSession().setAttribute("pagina", "CadastroDeVeiculo.jsf");
			res.sendRedirect("LoginFuncionario.jsf");
		}
		
		arg2.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}
	
	@Override
	public void destroy() {	
	}

}