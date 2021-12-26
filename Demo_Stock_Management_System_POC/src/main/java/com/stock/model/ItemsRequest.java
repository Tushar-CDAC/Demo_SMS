package com.stock.model;

import lombok.Data;

@Data
public class ItemsRequest {
	
	private Integer warehouseId;
	private String itemId;
	private Integer reduceQuantity;
}
