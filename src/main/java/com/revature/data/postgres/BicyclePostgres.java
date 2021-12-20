package com.revature.data.postgres;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Bicycle;
import com.revature.data.BicycleDAO;
import com.revature.utils.ConnectionUtil;

public class BicyclePostgres implements BicycleDAO {

	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public int create(Bicycle dataToAdd) {
		int orderId = 0;

		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sql = "insert into Orders1 (orderId, Order_Date, OrderNumber) values (default, ?, ?)";
			String[] keys = { "id" };
			PreparedStatement pStmt = conn.prepareStatement(sql, keys);
			pStmt.setString(1, dataToAdd.getDescription());
			pStmt.setString(2, dataToAdd.getBrand());

			pStmt.executeUpdate();
			ResultSet resultSetDescription = pStmt.getGeneratedKeys();

			if (resultSetDescription.next()) {

				orderId = resultSetDescription.getInt(1);
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int generatedId = 0;

		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);
			String sqlmyBicycle = "insert into Bicycles1 (id, brand, description) values (default, ?,?)";
			String[] keysmyBicycle = { "id" };
			PreparedStatement pStmt = conn.prepareStatement(sqlmyBicycle, keysmyBicycle);
			pStmt.setString(1, dataToAdd.getDescription());
			pStmt.setInt(2, orderId);

			pStmt.executeUpdate();
			ResultSet resultSetBicycle = pStmt.getGeneratedKeys();

			if (resultSetBicycle.next()) {

				generatedId = resultSetBicycle.getInt(1);
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedId;
	}

	@Override
	public Bicycle getById(int id) {
		Bicycle bicycle = null;

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from Bicycles1 where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			ResultSet resultSet = pStmt.executeQuery();

			if (resultSet.next()) {
				bicycle = new Bicycle();
				bicycle.setId(resultSet.getInt(1));
				bicycle.setDescription(resultSet.getString("description"));
				bicycle.setBrand(resultSet.getString("Brand"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bicycle;
	}

	@Override
	public Set<Bicycle> getAll() {
		Set<Bicycle> allBicycles = new HashSet<Bicycle>();

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from Bicycles1 ";
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				Bicycle bicycle = new Bicycle();
				bicycle.setId(resultSet.getInt("id"));
				bicycle.setDescription(resultSet.getString("brand"));
				bicycle.setBrand(resultSet.getString("description"));

				allBicycles.add(bicycle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBicycles;
	}

	@Override
	public void update(Bicycle dataToUpdate) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "update Bicycles1 set description=?, orderId=? where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, dataToUpdate.getDescription());
			pStmt.setString(2, dataToUpdate.getBrand());
			pStmt.setInt(3, dataToUpdate.getId());

			int rowsAffected = pStmt.executeUpdate();

			if (rowsAffected == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Bicycle dataToDelete) {
		try (Connection conn = connUtil.getConnection()) {
			conn.setAutoCommit(false);

			String sql = "delete from Bicyclels1 where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, dataToDelete.getId());

			int rowsAffected = pStmt.executeUpdate();

			if (rowsAffected == 1) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Bicycle> getByBrand(String brand) {
		Set<Bicycle> bicycleSet = new HashSet<Bicycle>();
		Bicycle bicycle = null;

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from Bicycles1 where brand = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, brand);

			ResultSet resultSet = pStmt.executeQuery();

			if (resultSet.next()) {
				bicycle = new Bicycle();
				bicycle.setId(resultSet.getInt("id"));
				bicycle.setDescription(resultSet.getString("description"));
				bicycle.setBrand(resultSet.getString("brand"));
				bicycleSet.add(bicycle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bicycleSet;
	}

	@Override
	public Set<Bicycle> getByDescription(String Description) {
		Set<Bicycle> bicycleSet = new HashSet<Bicycle>();
		Bicycle bicycle = null;

		try (Connection conn = connUtil.getConnection()) {
			String sql = "select * from Bicycles1 where description =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Description);

			ResultSet resultSet = pStmt.executeQuery();

			if (resultSet.next()) {
				bicycle = new Bicycle();
				bicycle.setId(resultSet.getInt(1));
				bicycle.setDescription(resultSet.getString("description"));
				bicycle.setBrand(resultSet.getString("brand"));
				bicycleSet.add(bicycle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bicycleSet;

	}

}