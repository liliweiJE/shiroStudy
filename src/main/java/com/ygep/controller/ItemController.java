package com.ygep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ygep.model.item.Item;
import com.ygep.service.item.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item")
	public String toPage(){
		Item item = itemService.selectByKey(536563L);
		System.out.println(item.getTitle());
		return "index";
	}
}
