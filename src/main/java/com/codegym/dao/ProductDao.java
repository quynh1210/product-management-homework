package com.codegym.dao;

import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{
    Connection connection = DBConnection.getConnection();
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                Product product = new Product(id,name,price,description,image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                String image = resultSet.getString("image");
                product = new Product(id,name,price,description,image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    @Override
    public void create(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, description, image) VALUES (?,?,?,?);");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4,product.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name=?, price=?, description=?, image=? where id=?;;");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4,product.getImage());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
