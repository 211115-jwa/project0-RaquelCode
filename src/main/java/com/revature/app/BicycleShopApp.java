
  package com.revature.app;
  
  
  
  import com.revature.data.collections.BicycleCollection;
  
  import io.javalin.Javalin;
  
  import static io.javalin.apibuilder.ApiBuilder.*;
  
  public class BicycleShopApp{ static int currentIndex; static BicycleCollection
  BicycleCollection = new BicycleCollection();
  
  public static void main(String[] args) { currentIndex = 0;
  
  Javalin app = Javalin.create();
  
  app.start();
  
  app.routes(() -> { path("/bicycles", () -> { get(ctx -> { String brandSearch
  = ctx.queryParam("brand"); String modelSearch = ctx.queryParam("model");
  String colorSearch = ctx.queryParam("color");
  
  
  if (brandSearch != null && !"".equals(brandSearch)) {
  
  ctx.result("GET to /bicycles?brand=" + brandSearch +" successful");
  
  
  } else if (modelSearch != null && !"".equals(modelSearch)) {
  
  ctx.result("GET to /bicycles?model=" + modelSearch +" successful");
  
  
  
  }else if (colorSearch != null && !"".equals(colorSearch)) {
  
  ctx.result("GET to /bicycles?model=" + colorSearch +" successful");
  
  
  } else {
  
  ctx.result("GET to /bicycles successful"); } }); post(ctx -> {
  ctx.result("POST to /bicycles successful"); });
  
  path("/{id}", () -> { get(ctx -> { String id = ctx.pathParam("id");
  ctx.result("GET to /bicycles/" + id + " successful"); }); put(ctx -> { String
  id = ctx.pathParam("id"); ctx.result("PUT to /bicycles/" + id +
  " successful"); }); }); }); }); } }
 