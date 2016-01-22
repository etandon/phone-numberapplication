package com.etandon.phonenumber.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etandon.phonenumber.util.Corelogic;
import com.google.gson.Gson;

/**
 * Servlet implementation class DataFetch
 */
public class DataFetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataFetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command=request.getParameter("command");
		String input=request.getParameter("input");
		int total=0;
		if("getCount".equals(command))
		  {
			Corelogic instance=new Corelogic();
			total= instance.findtotalCobmination(input);
			response.setContentType("text/plain");
			PrintWriter out=response.getWriter();
			out.print(total);
			out.flush();
			return;
		  }
		else if("getInitialList".equals(command))
		  {
			List<String> resultList=new ArrayList<String>();
			resultList.add(input);
			String previous=input;
			Corelogic instance=new Corelogic();
			for(int i=1;i<25;i++)
			   {
				 if(previous!=null)
				 {previous=instance.findNextWord(previous);}
				 if(previous!=null)
				 {resultList.add(previous);}
			   }
			String json=new Gson().toJson(resultList);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			return;
		  }
		else if("getOffsetList".equals(command))
		  {
			List<String> resultList=new ArrayList<String>();
			String previous=input;
			Corelogic instance=new Corelogic();
			for(int i=0;i<25;i++)
			   {
				 if(previous!=null)
				 {previous=instance.findNextWord(previous);}
				 if(previous!=null)
				 {resultList.add(previous);}
			   }
			String json=new Gson().toJson(resultList);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			return;
		  }
		else if("getPreviousList".equals(command))
		  {
			List<String> resultList=new ArrayList<String>();
			String previous=input;
			Corelogic instance=new Corelogic();
			for(int i=0;i<25;i++)
			   {
				 if(previous!=null)
				 {previous=instance.findPreviousWord(previous);}
				 if(previous!=null)
				 {resultList.add(previous);}
			   }
			Collections.reverse(resultList);
			String json=new Gson().toJson(resultList);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			return;
		  }
		else if("getLastList".equals(command))
		  {
			List<String> resultList=new ArrayList<String>();
			int remainder=Integer.parseInt(request.getParameter("remainder"));
			Corelogic instance=new Corelogic();
			String lastWord=instance.findLastWord(input);
			resultList.add(lastWord);
			for(int i=1;i<remainder;i++)
			   {
				 if(lastWord!=null)
				 {lastWord=instance.findPreviousWord(lastWord);}
				 if(lastWord!=null)
				 {resultList.add(lastWord);}
			   }
			Collections.reverse(resultList);
			String json=new Gson().toJson(resultList);
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print(json);
			out.flush();
			return;
		  }
	}

}
