package services.recipe;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import connectionprovider.ConnectionProvider;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;

@Path("/")
public class RecipeServices {

	@GET
	@Path("/recipe")
	@Produces(MediaType.TEXT_PLAIN)
	public String getRecipe() {
		return "Recipe will be returned here";
	}
	@POST
	@Path("/addimage")
	@Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getImage(@FormParam("image") String image) throws SQLException, ClassNotFoundException{
		ConnectionProvider.getInstance().executeUpdateQuery("INSERT INTO images(image) VALUES('"+image+"');");
		return "image successfully added";
	}
	@POST
	@Path("/readimage")
	@Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String getImageUrl(@FormParam("id") String id) throws SQLException, ClassNotFoundException {
		return ConnectionProvider.getInstance().executeQuery("select * from images where id='"+id+"';");
	}
	@POST
	@Path("/updateimage")
	@Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateImage(@FormParam("id") String id,@FormParam("image") String image) throws SQLException, ClassNotFoundException {
	   ConnectionProvider.getInstance().executeUpdateQuery("update images set image='"+image+"' where id='"+id+"';");
		return "image successfully updated";
	}
	@POST
	@Path("/deleteimage")
	@Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteImage(@FormParam("id") String id) throws SQLException, ClassNotFoundException {
	    ConnectionProvider.getInstance().executeUpdateQuery("delete from images where id='"+id+"';");
		return "image successfully deleted";
	}
	@GET
	@Path("/getallimages")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllImages() throws SQLException, ClassNotFoundException {
	    return ConnectionProvider.getInstance().executeQuery("select * from images;");
	}
}

