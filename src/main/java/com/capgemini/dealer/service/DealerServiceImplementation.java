package com.capgemini.dealer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dealer.dao.DealerDAO;
import com.capgemini.dealer.dto.DealerProductInfoBean;
import com.capgemini.dealer.dto.OrderDetails;
import com.capgemini.dealer.dto.ProductInfoBean;
import com.capgemini.dealer.dto.UserInfoBean;

@Service
public class DealerServiceImplementation implements DealerService {
	
	@Autowired
	private DealerDAO dao;


	@Override
	public OrderDetails placeOrder( UserInfoBean dealer) {
		return dao.placeOrder(dealer);
	}

	@Override
	public boolean setSellingPrice(DealerProductInfoBean dealer) {
		return dao.setSellingPrice(dealer);
	}

	@Override
	public OrderDetails getPaymentDeatils(int id) {
		return dao.getPaymentDeatils(id);
	}


	@Override
	public DealerProductInfoBean getProduct(int id) {
		return dao.getProduct(id);
	}

	@Override
	public List<DealerProductInfoBean> getAllProducts(int userId) {
		return dao.getAllProducts(userId);
	}

	@Override
	public boolean setMinimumQuantity(DealerProductInfoBean dealer) {
		return dao.setMinimumQuantity(dealer);
	}

	@Override
	public List<ProductInfoBean> getProducts() {
		return dao.getProducts();
	}

	@Override
	public boolean update(DealerProductInfoBean dealer) {
		return dao.update(dealer);
	}
}
