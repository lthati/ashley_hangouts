package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.BusinessFunctions;
import model.Event;

/**
 * Servlet implementation class getEvents
 */
@WebServlet("/getAllEvents")
public class getEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEvents() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *return a json
	 */
    //http://localhost:8082/Hangouts/getAllEvents
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 JSONArray array = new JSONArray();
		 BusinessFunctions bf = new BusinessFunctions();
		 List<Event> eventList = bf.getAllEvents();
		 
		 for (Event event : eventList) {
			 array.put(event.toJSONObject());
		 }
	   	 RpcParser.writeOutput(response, array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
