package com.capgemini.dealer.dao;

import java.util.List;

import com.capgemini.dealer.dto.*;


public interface DealerDAO {
	public OrderDetails placeOrder(UserInfoBean dealer);
	public boolean setSellingPrice(DealerProductInfoBean dealer);
	public DealerProductInfoBean getProduct(int id);
	public OrderDetails getPaymentDeatils(int orderId);
	public boolean checkNameAvailability(String name) ;
	public List<DealerProductInfoBean> getAllProducts(int userId);
	public boolean setMinimumQuantity(DealerProductInfoBean dealer);
	public List<ProductInfoBean>  getProducts();
	public boolean update(DealerProductInfoBean dealer);
}
