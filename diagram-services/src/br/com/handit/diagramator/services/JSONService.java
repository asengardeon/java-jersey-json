package br.com.handit.diagramator.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.handit.diagramator.db.DiagramConnection;

@Path("/json/metallica")
public class JSONService {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/cubes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCubes() {
		DiagramConnection c = new DiagramConnection();
		Connection conn = c.getInstance();
		List<String> list = new ArrayList() ;

		final String sql = "select * from CUBE_T";

		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				list.add(result.getString("DESCRIPTION"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(201).entity(list).build();
	}

}
