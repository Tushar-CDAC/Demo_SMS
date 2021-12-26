package com.stock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Items;
import com.stock.entity.Warehouse;
import com.stock.repository.ItemsRepository;
import com.stock.service.ItemsService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/item")
@Slf4j
public class ItemsController {
	
//	private static final Logger LOGGER=LoggerFactory.getLogger(ItemsController.class);
	
	private final ItemsService itemsService;
	
	private final ItemsRepository itemsRepository;
	
	public ItemsController(ItemsService itemsService, ItemsRepository itemsRepository) {
		super();
		this.itemsService = itemsService;
		this.itemsRepository = itemsRepository;
	}

//	@PostMapping("order/{wid}/{iid}/{qty}")
//	public ResponseEntity<Integer> orderQty(@PathVariable("wid") Warehouse id2, @PathVariable("iid") int id1, @PathVariable("qty") int quantity) {
//		Items items=itemsService.findByWarehouseIdAndName(id2, id1);
//		int newQty = items.getCurrentStock() - quantity;
//		items.setCurrentStock(newQty);
//		itemsRepository.save(items);
//		//LOGGER.info("Order quantity");
//		log.info("Order quantity");
//		return ResponseEntity.ok(items.getCurrentStock());		
//	}
	
//	@PostMapping("order/{wid}/{iid}/{qty}")
//	public ResponseEntity<?> orderQtyy(@RequestBody testItemModule itemModule){
//	Items items=itemsService.findByWarehouseIdAndName(id2, id1);
//	int newQty = items.getCurrentStock() - quantity;
//	items.setCurrentStock(newQty);
//	itemsRepository.save(items);
//	//LOGGER.info("Order quantity");
//	log.info("Order quantity");
//	return ResponseEntity.ok(items.getCurrentStock());	
//	}
//	
//	@PostMapping("order/stock")
//	public ResponseEntity<?> orderQuantity1001(@RequestBody testItemModule itemModule){
//		Items items = itemsService.findByWarehouseIdAndName(itemModule.getWarehouseId(), itemModule.getItemid());	
//		return ResponseEntity.ok(itemModule.getQuantityToreduce());	
//}
	
	@GetMapping("getById/{wid}/{iid}")
	public ResponseEntity<Integer> getStockDetails(@PathVariable("wid") Warehouse id2, @PathVariable("iid") int id1) {	
	Items items=itemsService.findByWarehouseIdAndName(id2, id1);
		//LOGGER.info("Current stock");
		log.info("Current stock");
		return ResponseEntity.ok(items.getCurrentStock());
	}
	
}
