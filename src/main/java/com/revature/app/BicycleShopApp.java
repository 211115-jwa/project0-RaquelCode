package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;


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

		app.routes(() -> {

			path("/bicycles", () -> {
				get(ctx -> {

					String DescriptionSearch = ctx.queryParam("Description");
					String BrandSearch = ctx.queryParam("Brand");

					if (DescriptionSearch != null && !"".equals(DescriptionSearch)) {
						Set<Bicycle> bicyclesFound = userServ.searchBicyclesByDescription(DescriptionSearch);
						ctx.json(bicyclesFound);

					}else if (BrandSearch!= null && !"".equals(BrandSearch)) {
						Set<Bicycle> bicyclesFound = userServ.searchBicyclesByBrand(BrandSearch);
						ctx.json(bicyclesFound);


					}else{

						Set<Bicycle> availableBicycles = userServ.viewAllBicycles();
						ctx.json(availableBicycles);
					}
				});

				post(ctx -> {

					Bicycle newBicycle = ctx.bodyAsClass(Bicycle.class);
					if (newBicycle !=null) {
						userServ.addNewBicycle(newBicycle);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});



				path("/{id}", () -> {

					get(ctx -> {
						try {
							int bicicycleId= Integer.parseInt(ctx.pathParam("id")); 
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
