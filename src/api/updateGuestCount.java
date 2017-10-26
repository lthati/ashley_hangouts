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
import model.Event;

/**
 * Servlet implementation class updateGuestCount
 */
@WebServlet("/updateGuestCount")
public class updateGuestCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateGuestCount() {
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
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	   		 JSONObject input = RpcParser.parseInput(request);
	   		 BusinessFunctions bf = new BusinessFunctions();
	   		 bf.updateGuestCount(input.getInt("eventId"), input.getString("email"), input.getString("name"));
	   		 RpcParser.writeOutput(response, new JSONObject().put("status", "OK"));
	   	 } catch (JSONException e) {
	   		 e.printStackTrace();
	   	 }
	}

}
