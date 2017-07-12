package com.nasa_api.nasa_api.sound;

import base.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class ApiTest extends BaseApiTest {



    @DataProvider(name = "search-data")
    public Object[][] getSearchQuery() {
        return new Object[][]{{"planetary/sounds?api_key=DEMO_KEY"}};
    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "search-data")
    public void testValidResponse(String query)throws Exception{
            restUtil.getJSONEntity(query);
            assertNotEquals(restUtil.isValidResponse(), null);
            assertEquals(restUtil.getStatusCode(), HttpStatus.SC_OK);         
            }

/*  
    
    
    @Test (alwaysRun =true, dataProvider= "search-data")
    public void getpropertCount(String query)throws Exception{
    	 restUtil.getJSONEntity(query);
    	 assertEquals(restUtil.getJson().getPropertyCount(),4);
    }
    
    @Test (alwaysRun =true, dataProvider= "search-data")
    public void arraycount(String query)throws Exception{
    	 restUtil.getJSONEntity(query);
    	 assertTrue(restUtil.getJson().isPropertyArray("items"));
         assertEquals(restUtil.getJson().getArrayCount(),30);
    }
    */

}
