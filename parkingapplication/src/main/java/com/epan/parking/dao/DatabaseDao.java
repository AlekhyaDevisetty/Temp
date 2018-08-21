package com.epan.parking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import com.epam.parking.dbutil.DBUtil;
import com.epam.parking.dbutil.Test;

public class DatabaseDao implements DAO {
	public Connection setup() {
		Test test = new Test();
		Connection conn = null;
		try {
			conn = test.maindb();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return conn;
	}

	@Override
	public void initializeSlotSize(int numberOfSlots) {
		Connection conn = setup();

		try {
			PreparedStatement ps = conn.prepareStatement("insert into vehicledata values(?,?)");

			for (int i = 1; i <= 40; i++) {
				ps.setInt(1, i);
				ps.setString(2, "novalue");
				ps.executeUpdate();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void write(String vehicleNumber, int slotNumber) {
		Connection conn = setup();

		try {
			PreparedStatement ps = conn.prepareStatement("update vehicledata set vehiclenumber=? where slotnumber=?");
			ps.setString(1, vehicleNumber);
			ps.setInt(2, slotNumber);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int searchForEmptySlot() {
		int slotNumber = -1;
		Connection conn = setup();
		try {

			PreparedStatement ps = conn
					.prepareStatement("select * from vehicledata where vehiclenumber = 'novalue' limit 1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				slotNumber = rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return slotNumber;
	}

	@Override
	public int delete(String vehicleNumber) {
		int slotNumber = -1;
		Connection conn = setup();

		try {
			PreparedStatement ps1 = conn.prepareStatement("select slotnumber from vehicledata where vehicleNumber = ?");

			ps1.setString(1, vehicleNumber);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				slotNumber = rs.getInt(1);
			}

			PreparedStatement ps = conn.prepareStatement("update vehicledata set vehiclenumber=? where slotnumber=?");
			ps.setString(1, "novalue");
			ps.setInt(2, slotNumber);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slotNumber;
	}

}
