package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import analyzer.EmotionsAnalyzer;

/**
 * Servlet implementation class Analyzer
 */
@WebServlet(description = "Analyzes the given text", urlPatterns = { "/AnalyzeEmotions.do" })
public class Analyzer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmotionsAnalyzer emotionAnalyzer = new EmotionsAnalyzer();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Analyzer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("text");
		String result = "";

		result = emotionAnalyzer.Analyze(text);

		PrintWriter out = response.getWriter();
		out.write(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
