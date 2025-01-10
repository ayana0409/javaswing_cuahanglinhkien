/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuahanglinhkien_java.controllers;

import com.mycompany.cuahanglinhkien_java.models.Statistic;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import share.GenericController;

/**
 *
 * @author Asus
 */
public class StatisticController {
    GenericController<Statistic> statisticController = new GenericController<>();
    
    public List<Statistic> getSaleStatistic(Date from, Date to) {
        String query = "SELECT p.Id AS ProductId, p.Name AS ProductName, " +
        "SUM(od.QuantitySold) AS TotalQuantitySold, " +
        "SUM(od.SalePrice * od.QuantitySold) AS TotalRevenue " +
        "FROM OrderDetail od  JOIN Orders o ON od.Id = o.Id " +
        "JOIN Product p ON od.Pro_Id = p.Id " +
        "WHERE o.PurchaseDate BETWEEN ? AND ? " +
        "GROUP BY p.Id, p.Name ORDER BY TotalRevenue DESC;";
        try {
            return statisticController.fetchAll(query, s -> {
                try {
                    return new Statistic(s.getInt("productId"), s.getInt("TotalQuantitySold"),
                            s.getString("productName"), s.getFloat("TotalRevenue"));
                } catch (SQLException ex) {
                    Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, from, to);
        } catch (SQLException ex) {
            Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
    public List<Statistic> getImportStatistic(Date from, Date to) {
        String query = "SELECT \n" +
"    p.Id AS ProductID,\n" +
"    p.Name AS ProductName,\n" +
"    SUM(i.QuantityImported) AS TotalQuantityImported,\n" +
"    SUM(i.QuantityImported * i.ImportPrice) AS TotalImportCost\n" +
"FROM \n" +
"    Inventory i\n" +
"JOIN \n" +
"    Product p ON i.Pro_Id = p.Id\n" +
"WHERE \n" +
"    i.ImportDate BETWEEN ? AND ?\n" +
"GROUP BY \n" +
"    p.Id, p.Name;";
        try {
            return statisticController.fetchAll(query, s -> {
                try {
                    return new Statistic(s.getInt("ProductID"), s.getInt("TotalQuantityImported"),
                            s.getString("ProductName"), s.getFloat("TotalImportCost"));
                } catch (SQLException ex) {
                    Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }, from, to);
        } catch (SQLException ex) {
            Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
}
