package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{
    
	//public Items save(Items items);
	
	public Items findByWarehouseAndItemid(Warehouse wid, int id);
}
