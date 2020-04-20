package com.capgemini.dealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dealer.dto.*;

import com.capgemini.dealer.service.DealerService;

@RestController
@CrossOrigin(origins = "*",allowCredentials = "true",allowedHeaders = "*",exposedHeaders="Access-Control-Allow-Origin")
public class DealerController {
	
	@Autowired
	private DealerService service;
	
	@PostMapping(path = "/dealerOrder",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass placeOrder(@RequestBody UserInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.placeOrder(bean);
		if(order!=null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Order Placed Successfully");
			resp.setOrder(order);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("/Failed");
			resp.setDescription("Placing Order Unsuccessfull");
			return resp;
		}
	}
	
	@PostMapping(path = "/setSellingPrice",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass setSellingPrice(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if(service.setSellingPrice(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Updation Successfull");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Updation Product Failed");
			return resp;
		}
	}
	
	@GetMapping(path = "/getProds",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getAllProducts(@RequestParam("userId")int userId) {
		ResponseClass resp = new ResponseClass();
		List<DealerProductInfoBean> prods = service.getAllProducts(userId);
		if(prods!=null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setDealerProds(prods);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products Not Found");
			return resp;
		}
	}
	
	@GetMapping(path = "/getProd",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getProduct(@RequestParam("dealersProductId")int dealersProductId) {
		ResponseClass resp = new ResponseClass();
		DealerProductInfoBean prod = service.getProduct(dealersProductId);
		if(prod!=null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Product Found");
			resp.setDealerProd(prod);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Product Not Found");
			return resp;
		}
	}
	
	@GetMapping(path = "/getOrderDetails",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getOrder(@RequestParam("orderId")int orderId ) {
		ResponseClass resp = new ResponseClass();
		OrderDetails order = service.getPaymentDeatils(orderId);
		if(order!=null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Order Found");
			resp.setOrder(order);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Order Not Found");
			return resp;
		}
	}
	
	@PostMapping(path = "/setMin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass setMinimumQuantity(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if(service.setMinimumQuantity(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Updation Successfull");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Updation Product Failed");
			return resp;
		}
	}
	
	
	@GetMapping(path = "/getMansProds",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass getManufacturersProducts() {
		ResponseClass resp = new ResponseClass();
		List<ProductInfoBean> products = service.getProducts();
		if(products!=null) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Products Found");
			resp.setProducts(products);
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Products Not Found");
			return resp;
		}
	}
	
	@PostMapping(path = "/updateDealerProduct",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseClass updateDealerProduct(@RequestBody DealerProductInfoBean bean) {
		ResponseClass resp = new ResponseClass();
		if(service.update(bean)) {
			resp.setStatusCode(201);
			resp.setMessage("Success");
			resp.setDescription("Updation Successfull");
			return resp;
		} else {
			resp.setStatusCode(401);
			resp.setMessage("Failed");
			resp.setDescription("Updation Product Failed");
			return resp;
		}
	}
	
	
}
