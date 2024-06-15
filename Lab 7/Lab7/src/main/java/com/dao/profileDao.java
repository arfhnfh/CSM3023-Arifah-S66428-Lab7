/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Profile;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arifah S66428
 */
public class profileDao {
    private Connection connection;
    
    private static final String INSERT_PROFILE = "INSERT INTO userprofile VALUES (?, ?, ?)";
    private static final String SELECT_PROFILE_BY_USERNAME = "SELECT * FROM userprofile WHERE username = ?";

    public profileDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void addProfile(Profile profile) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            
            preparedStatement.setString(1, profile.getUsername());
            preparedStatement.setString(2, profile.getIcno());
            preparedStatement.setString(3, profile.getFirstname());
            
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public Profile getProfileByUsername(String username) {
        
        Profile profile = new Profile();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROFILE_BY_USERNAME);
            
            preparedStatement.setString(1, username);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while ( resultSet.next() ) {
                profile.setUsername(resultSet.getString("username"));
                profile.setIcno(resultSet.getString("icno"));
                profile.setFirstname(resultSet.getString("firstname"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return profile;
        
    }
    
}