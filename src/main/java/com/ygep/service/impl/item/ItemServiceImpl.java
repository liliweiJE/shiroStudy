package com.ygep.service.impl.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygep.mapper.item.ItemMapper;
import com.ygep.model.item.Item;
import com.ygep.service.item.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemMapper itemMapper;
	
	public Item selectByKey(Long id){
		return itemMapper.selectByPrimaryKey(id);
	}
}
