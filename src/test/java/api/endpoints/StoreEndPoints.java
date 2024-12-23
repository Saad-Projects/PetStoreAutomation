package api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import api.payload.Store;

public class StoreEndPoints {

	public static Response placeOrder(Store payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
			.post(Routes.postStore_url);
		
		return response;
	}
	
	public static Response getOderById(int orderId)
	{
		Response response = given()
				.pathParam("orderId", orderId)
		.when()
			.get(Routes.getStore_url);
		
		return response;
	}
	
	public static Response updateOderById(int orderId, Store payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)
				.body(payload)
		.when()
			.put(Routes.updateStore_url);
		
		return response;
	}
	
	public static Response deleteOderById(int orderId)
	{
		Response response = given()
				.pathParam("orderId", orderId)
		.when()
			.delete(Routes.deleteStore_url);
		
		return response;
	}
}

