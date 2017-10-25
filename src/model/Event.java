package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Event {
	
	public static String parseString(String str) {
		return str.replace("\"", "\\\"").replace("/", " or ");
	}

	public static String jsonArrayToString(JSONArray array) {
		
		StringBuilder sb = new StringBuilder();
		try {
			for (int i = 0; i < array.length(); i++) {
				String obj = (String) array.get(i);
				sb.append(obj);
				if (i != array.length() - 1) {
					sb.append(",");
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static JSONArray stringToJSONArray(String str) {
		String[] strArray = str.split(",");
		JSONArray ret = null;
		try {
			ret = new JSONArray(strArray);
		} catch (JSONException e) {
			System.out.println("Error: stringToJSONArray "+str);
			e.printStackTrace();
		}
		return ret;
	}
	
	private int eventId;
	private String description;
	private String organizerName;
	private String organizerEmail;
	private String location;
	private String eventDate;
	private String startTime;
	private String endTime;
	private int guestCount;
	
	
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(JSONObject object) {
		try {
			if (object != null) {
				this.eventId = object.getInt("EventsId");
				this.description = object.getString("Description");
				this.organizerName = object.getString("OrganizerName");
				this.organizerEmail = object.getString("OrganizerEmail");
				this.location = object.getString("Location");
				this.eventDate = object.getString("EventDate");
				this.startTime = object.getString("StartTime");
				this.endTime = object.getString("EndTime");
				this.guestCount = object.getInt("guestCount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Event(int eventId, String description, 
				String organizerName, String organizerEmail, 
				String location ,String eventDate, 
				String startTime, String endTime, int guestCount) {
		this.eventId = eventId;
		this.description = description;
		this.organizerName = organizerName;
		this.organizerEmail = organizerEmail;
		this.location = location;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.guestCount = guestCount;
	}
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("eventId", eventId);
			obj.put("description", description);
			obj.put("organizerName", organizerName);
			obj.put("organizerEmail", organizerEmail);
			obj.put("location", location);
			obj.put("eventDate", eventDate);
			obj.put("startTime", startTime);
			obj.put("endTime", endTime);
			obj.put("guestCount", guestCount);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganizerName() {
		return organizerName;
	}

	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}

	public String getOrganizerEmail() {
		return organizerEmail;
	}

	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getGuestCount() {
		return guestCount;
	}

	
	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	
}