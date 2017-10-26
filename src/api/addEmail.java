package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import db.BusinessFunctions;
/**
 * Servlet implementation class addEmail
 */
@WebServlet("/addEmail")
public class addEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * http://localhost:8082/Hangouts/addEmail
	 * {'email':'rhu19921201@gmail.com'}
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	   		 JSONObject input = RpcParser.parseInput(request);
   			 String email_string=input.getString("email");
   			 BusinessFunctions bf = new BusinessFunctions();
   			 bf.addEmailAddress(email_string);
	   		 RpcParser.writeOutput(response, new JSONObject().put("status", "OK"));
	   	 } catch (JSONException e) {
	   		 e.printStackTrace();
	   	 }
	}

}
