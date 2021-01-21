package widgetstore.web;

import desserts.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DrinkDetailsServlet extends HttpServlet {

    GenericDAO<DrinkDTO> drinkDAO;

    public DrinkDetailsServlet() {
        drinkDAO = new DrinkDAOImpl();
        
    }

    @Override
	public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<form action='' method='POST'>");
        out.println("<label>Enter Product (Drink) ID to Get the Details: <input type='text' name='drink-id'></input></label>");
        out.println("<input type='submit'></input>");
        out.println("</form>");
    }

    @Override
	public void doPost(HttpServletRequest request,
			           HttpServletResponse response) throws ServletException, IOException {
        String drinkIdStr = request.getParameter("drink-id");
        Long drinkIdLong = -1L;
        try {
        	drinkIdLong = Long.valueOf(drinkIdStr);
        }catch(Exception e){
        	System.out.println("A Number Should Be Entered.");
        }
        PrintWriter out = response.getWriter();
        
        List<DrinkDTO> drinks = new ArrayList<>();
        drinks = drinkDAO.getSpecific(drinkIdLong);
        
        out.println("<h4>The detailed result of the item you requested is as follow: </h4>" + "\n");
        if(drinks.isEmpty()) {
        	out.println("The ID Number Is Not Valid");
        }else {
        	for(DrinkDTO drink : drinks) {
        		out.println("The Item Is Found:  " );
        		out.println("The ID Number is " + drink.getId() + ". ");
                out.println("The Name of the Product is " + drink.getName() + ".");
                if(drink.isGood() == true) {
                	out.println("It Is Good");
                }else {
                	out.println("It Is Not Good");
                }
        	}
        }
    }
}
