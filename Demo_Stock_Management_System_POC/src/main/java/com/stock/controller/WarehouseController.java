package com.stock.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.DemoStockManagementSystemPocApplication;
import com.stock.entity.Items;
import com.stock.entity.Warehouse;
import com.stock.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	private static final Logger LOGGER=LoggerFactory.getLogger(WarehouseController.class);
	

	private final WarehouseService warehouseService;
	
	public WarehouseController(WarehouseService warehouseService) {
		super();
		this.warehouseService = warehouseService;
	}

	@PostMapping("/add")
	public ResponseEntity<Warehouse> addwarehouse(@RequestBody Warehouse warehouse){
		
		List<Items> items = new ArrayList<>();
		items =warehouse.getItems();
		warehouse.setItems(null);
		Warehouse warehouse2 = warehouseService.addWarehouse(warehouse);
		
		for(Items items2: items) {
			items2.setWarehouse(warehouse2);
		}
		
		warehouse2.setItems(items);
		LOGGER.info("Warehouse controller");
		return ResponseEntity.ok(warehouseService.addWarehouse(warehouse2));
	}
	
	
}
