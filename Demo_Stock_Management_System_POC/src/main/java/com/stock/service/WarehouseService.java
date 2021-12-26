package com.stock.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stock.entity.Warehouse;
import com.stock.repository.WarehouseRepository;

@Service
@Transactional
public class WarehouseService {
	
	private final WarehouseRepository warehouseRepository;
	
	public WarehouseService(WarehouseRepository warehouseRepository) {
		super();
		this.warehouseRepository = warehouseRepository;
	}

	public Warehouse addWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}
}
