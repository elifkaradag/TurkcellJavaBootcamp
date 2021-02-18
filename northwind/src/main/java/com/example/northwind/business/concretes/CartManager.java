package com.example.northwind.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.northwind.business.abstracts.ICartService;
import com.example.northwind.dataaccess.concretes.CartRepository;
import com.example.northwind.entities.concretes.Cart;
import com.example.northwind.entities.concretes.Category;
import com.example.northwind.entities.concretes.Customer;
import com.example.northwind.entities.concretes.Product;

@Service
public class CartManager implements ICartService{

	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> viewCart(Customer customer) {
		List<Cart> cartToView = cartRepository.getCartsByCustomerId(customer.getId());
		return cartToView;
	}

	@Override
	public Cart addProduct(Cart cart) {
		
		List<Cart> carts = cartRepository.existByCustomerIdAndProductId(cart.getCustomerId(), cart.getProductId());

		if(carts.size() == 0) {
			cart.setNumberOfProducts(1);
			
			return cartRepository.save(cart);
			
		}
		else {
			Cart setCart = carts.get(0);
			setCart.setNumberOfProducts(setCart.getNumberOfProducts()+1);

			return cartRepository.save(setCart);

		}
	}

	@Override
	public Cart removeProduct(Cart cart, int number) {
		//BURAYI SOR
		List<Cart> cartToView = cartRepository.getCartsByCustomerId(cart.getCustomerId());
		Cart deleteCartToProduct = null;

		for(Cart cart1 : cartToView) {

			if(cart.getProductId() == cart1.getProductId()){

				if(cart1.getNumberOfProducts() > number) {
					cart1.setNumberOfProducts(cart1.getNumberOfProducts() - number);
					deleteCartToProduct = cartRepository.save(cart1);

				}
				else {
					cartRepository.delete(cart1);
					deleteCartToProduct = cart1;
				}

				break;
			}
		}

		return deleteCartToProduct;
	}

}
