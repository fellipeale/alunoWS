package br.com.ufpr.ees.soa.alunows.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import br.com.ufpr.ees.soa.alunows.helper.AlunoWSHelper;
import br.com.ufpr.ees.soa.alunows.model.Aluno;

@WebServlet(name = "alunoServlet", urlPatterns = { "/buscarAlunos", "/inserirAluno", "/buscarAlunoNR", "removerAluno" })
public class AlunoControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AlunoWSHelper wsHelper = new AlunoWSHelper();
		List<Aluno> result = new ArrayList<Aluno>();

		String nr = request.getParameter("nr");

		if (nr != null) {
			result.add(wsHelper.buscarAluno(nr));
		}
		else {
			result = wsHelper.buscarAlunos();
		}

		request.setAttribute("alunos", result);
		RequestDispatcher rd = request.getRequestDispatcher("/listarAlunos.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoWSHelper wsHelper = new AlunoWSHelper();

		Aluno aluno = new Aluno();

		try {
			BeanUtils.populate(aluno, request.getParameterMap());
			aluno = wsHelper.inserirAluno(aluno);
			request.setAttribute("resultMsg", "Aluno inserido com sucesso!");
			// request.setAttribute("aluno", aluno);
		} catch (IllegalAccessException e) {
			request.setAttribute("resultMsg", "Erro ao inserir aluno.");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			request.setAttribute("resultMsg", "Erro ao inserir aluno.");
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/dadosAluno.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoWSHelper wsHelper = new AlunoWSHelper();

		String id = request.getParameter("id");

		if (id != null) {
			wsHelper.removerAluno(Long.valueOf(id));
			request.setAttribute("resultMsg", "Aluno removido com sucesso.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
