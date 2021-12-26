package com.stock.model;

import java.util.List;

import lombok.Data;

@Data
public class WarehouseRequest {
	private List<ItemsRequest> items;
}
