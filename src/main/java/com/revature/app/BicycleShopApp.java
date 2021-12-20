package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

// this static import is for the path and get/post/put methods
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;
import com.revature.beans.Bicycle;


public class BicycleShopApp {
	private static UserService userServ = new UserServiceImpl();
	

	public static void main(String[] args) {
		Javalin app = Javalin.create();
		
		app.start(8080);
		
		/*
		 what endpoints do we need?
		 in other words, what actions would a user need to do
		 and what address + HTTP method combo would represent
		 each of those actions?
		 (in your p0, these endpoints are provided to you.)
		*/
		app.routes(() -> {
			// localhost:8080/pets
			path("/bicycles", () -> {
				get(ctx -> {
					// checking if they did /pets?species=
					String DescriptionSearch = ctx.queryParam("Description");
					String BrandSearch = ctx.queryParam("Brand");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (DescriptionSearch != null && !"".equals(DescriptionSearch)) {
						Set<Bicycle> bicyclesFound = userServ.searchBicyclesByDescription(DescriptionSearch);
						ctx.json(bicyclesFound);
						
					}else if (BrandSearch!= null && !"".equals(BrandSearch)) {
							Set<Bicycle> bicyclesFound = userServ.searchBicyclesByBrand(BrandSearch);
							ctx.json(bicyclesFound);
								
							
					}else{
						// if they didn't put ?species
						Set<Bicycle> availableBicycles = userServ.viewAllBicycles();
						ctx.json(availableBicycles);
					}
				});
				
				post(ctx -> {
					// bodyAsClass turns JSON into a Java object based on the class you specify
					Bicycle newBicycle = ctx.bodyAsClass(Bicycle.class);
					if (newBicycle !=null) {
						userServ.addNewBicycle(newBicycle);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				
				
				
				// localhost:8080/pets/8
				path("/{id}", () -> {
					
					get(ctx -> {
						try {
							int bicicycleId= Integer.parseInt(ctx.pathParam("id")); // num format exception
							Bicycle bicycle = userServ.viewBicyclesById(bicicycleId);
							if (bicycle  != null)
								ctx.json(bicycle);
							else
								ctx.status(404);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Pet ID must be a numeric value");
						}
					});
					
					put(ctx -> {
						try {
							
								int bicycleId = Integer.parseInt(ctx.pathParam("id"));
								Bicycle bicycleToUpdate = ctx.bodyAsClass(Bicycle.class);
								if (bicycleToUpdate != null && bicycleToUpdate.getId() == bicycleId) {
									bicycleToUpdate = userServ.updateBicycle(bicycleToUpdate);
									if (bicycleToUpdate != null)
											ctx.json(bicycleToUpdate);
									else
											ctx.status(404);
								} else {
									ctx.status(HttpCode.CONFLICT);
								}
							} catch (NumberFormatException e) {
								ctx.status(400);
								ctx.result("Bicycle ID must be a numeric value");
							}
							
						
					});
					
				});
			});
		});
	}
	
}
