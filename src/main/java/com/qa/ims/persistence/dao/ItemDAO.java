package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_id = resultSet.getLong("item_id");
		String item_name = resultSet.getString("item_name");
		Long item_value = resultSet.getLong("item_value");
		return new Item(item_id, item_name, item_value);
	}
	@Override
	public List<Item> readAll() {
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");){
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		}
		catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Item read(Long item_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?");) {
			statement.setLong(1, item_id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO items(item_name, item_value) VALUES (?, ?)");) {
			statement.setString(1, item.getItemName());
			statement.setLong(2, item.getItemValue());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Item update(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE items SET item_name = ?, item_value = ? WHERE item_id = ?");) {
			statement.setString(1, item.getItemName());
			statement.setLong(2, item.getItemValue());
			statement.setLong(3, item.getItemID());
			statement.executeUpdate();
			return read(item.getItemID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long item_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?");) {
			statement.setLong(1, item_id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
}