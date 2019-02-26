package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import model.Artista;
import model.Canzone;

import persistance.DatabaseManager;
import persistence.dao.ArtistaDao;
import persistence.dao.CanzoneDao;
import persistence.dao.PlaylistDao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
     
		String action = request.getParameter("action");
	
		String searchQuer = request.getParameter("string");
		
		 CanzoneDao udao = DatabaseManager.getInstance().getDaoFactory().getCanzoneDao() ; 
		 ArtistaDao adao = DatabaseManager.getInstance().getDaoFactory().getArtistaDAO() ; 

		 if (action.equalsIgnoreCase("artista")) {
			out.print(gson.toJson(adao.findArtista(searchQuer)));
			out.flush();
			out.close();
		}else
			if (action.equalsIgnoreCase("canzoneArtista")) {
				
				out.print(gson.toJson(udao.findCanzoneByArtista(searchQuer)));
				out.flush();
				out.close();
				

			}
		 if (action.equalsIgnoreCase("artista1")) {
			 out.print(gson.toJson(udao.findByAlbum(searchQuer)));
				out.flush();
				out.close();
				
			 
		 }
		 if (action.equalsIgnoreCase("canzone")) {
				out.print(gson.toJson(udao.findCanzone(searchQuer)));
				out.flush();
				out.close();
		//	System.err.println(udao.findCanzone(searchQuer).size() + searchQuer+"***********");
			}
		 if (action.equalsIgnoreCase("tuttiGliArtista")) {
				out.print(gson.toJson(adao.findAll()));
				out.flush();
				out.close();
		//	System.err.println(adao.findAll().size()+"****************");
			}
		 
		   
	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		 }
		
		
	}
