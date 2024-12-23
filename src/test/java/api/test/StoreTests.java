package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Store storePayload;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		storePayload = new Store();
//		int petId;
//		int quantity;
//		Date shipDate;
//		String status;
//		boolean complete;
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(1);
		//storePayload.setShipDate(faker.date());
		storePayload.setStatus("placed");
		storePayload.setComplete(true);		
		
	}
	
	@Test(priority=1)
	public void testPostOrder()
	{
		Response response=StoreEndPoints.placeOrder(storePayload);	
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetOrderById()
	{
		Response response=StoreEndPoints.getOderById(this.storePayload.getId());	
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	//@Test(priority=3)
	public void testUpdateOrderById()
	{
		// update data using payload
		
		storePayload.setQuantity(3);
//		storePayload.setShipDate(faker.date());
		storePayload.setStatus("not placed");
		
		Response response=StoreEndPoints.updateOderById(this.storePayload.getId(), storePayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// Checking data after update
		Response responseAfterUpdate=StoreEndPoints.getOderById(this.storePayload.getId());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
//		Assert.assertEquals(responseAfterUpdate.body(firstName), faker.name().firstName());
		
	}
	
	@Test(priority=3)
	public void testDeleteOrderById()
	{
		Response response=StoreEndPoints.deleteOderById(this.storePayload.getId());			
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
