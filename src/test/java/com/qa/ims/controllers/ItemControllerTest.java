package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	@Mock
	private Utils utils;
	@Mock
	private ItemDAO dao;
	@InjectMocks
	private ItemController controller;
	
	@Test
	public void testCreate() {
		final String itemName = "Nintendo Switch";
		final Long itemValue = (long) 300;
		
		final Item create = new Item(itemName, itemValue);
		Mockito.when(utils.getString()).thenReturn(itemName, itemValue.toString());
		Mockito.when(dao.create(create)).thenReturn(create);

		assertEquals(create, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(create);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "GameBoy", 100L));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "GameBoy", 100L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getLong()).thenReturn(updated.getItemValue());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

	
}
