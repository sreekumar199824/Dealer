package com.capgemini.dealer.service;

import java.util.List;

import com.capgemini.dealer.dto.DealerProductInfoBean;
import com.capgemini.dealer.dto.OrderDetails;
import com.capgemini.dealer.dto.ProductInfoBean;
import com.capgemini.dealer.dto.UserInfoBean;

public interface DealerService {
	public OrderDetails placeOrder( UserInfoBean dealer);
	public boolean setSellingPrice(DealerProductInfoBean dealer);
	public DealerProductInfoBean getProduct(int id);
	public OrderDetails getPaymentDeatils(int orderId);
	public List<DealerProductInfoBean> getAllProducts(int userId);
	//public boolean checkNameAvailability(String name) ;
	public boolean setMinimumQuantity(DealerProductInfoBean dealer);
	public List<ProductInfoBean>  getProducts();
	public boolean update(DealerProductInfoBean dealer);
}
