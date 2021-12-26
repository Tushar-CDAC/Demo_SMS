package com.stock.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;
import com.stock.repository.ItemsRepository;

@Service
@Transactional
public class ItemsService {
	

	private final ItemsRepository itemsRepository;
	
	public ItemsService(ItemsRepository itemsRepository) {
		super();
		this.itemsRepository = itemsRepository;
	}

	public Items findByWarehouseIdAndName(Warehouse wid, int iid) {
		return itemsRepository.findByWarehouseAndItemid(wid, iid);	
	}

}
