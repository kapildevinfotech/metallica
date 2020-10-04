package com.metallica.trade.controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.metallica.refdata.domain.Commodity;
import com.metallica.refdata.domain.Counterparty;
import com.metallica.refdata.domain.Location;
import com.metallica.trade.TradeServiceApplication;
import com.metallica.trade.domain.Side;
import com.metallica.trade.domain.Trade;
import com.metallica.trade.domain.TradeStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TradeServiceApplication.class)
public class TradeControllerTest {

	@InjectMocks
    TradeController controller;
	
	@Autowired
	WebApplicationContext context;
	  
	private MockMvc mockMvc;
	
	@Before
    public void initTests() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	@Test
	public void createTrade() throws Exception{
		Trade mockTrade=new Trade(Side.SELL,34,98,new Date(),TradeStatus.OPEN,
				new Commodity("AL","Aluminium"),
				new Location("NY","NewYork"),
				new Counterparty("Ipsum","Ipsum")
				);
		
		/*Mockito.when(
				controller.getTradeById(Mockito.anyInt())).thenReturn(mockTrade);*/

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/trade")
				.accept(MediaType.APPLICATION_JSON).content(mockTrade.toJson())
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		 System.out.println(result.getResponse()
			.getContentAsString());
		assertEquals(HttpStatus.SC_OK, response.getStatus());

	}
	
	@Test
	public void getTrade() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/trade/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{'id':1,'side':'SELL','quantity':34,'price':98.0,'tradeDate':'2018-01-25','status':'OPEN','commodity':{'id':1,'code':'AL','description':'Aluminium'},'location':{'id':2,'code':'LN','description':'London'},'counterparty':{'id':1,'code':'Ipsum','description':'Ipsum'}}";
		
		JSONAssert.assertEquals(result.getResponse()
				.getContentAsString(), expected, false);
	}
	
}
