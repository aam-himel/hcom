package com.example.hcom.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductModel{

	@SerializedName("ProductModel")
	private List<ProductModelItem> productModel;

	public List<ProductModelItem> getProductModel(){
		return productModel;
	}
}