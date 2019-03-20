/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.DBConnectoin;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import model.Meter;
import model.RepairModel;
import model.Transformer;
import model.WindView;



/**
 *
 * @author san
 */
public class DBController {
   
    public static void saveMeterReading(int kk) throws SQLException {
        Random random = new Random();
        Connection connection=DBConnectoin.getDBConnection();
        PreparedStatement ps=connection.prepareStatement("Insert into wind "
                + "(Value,idMeter,time) values (?,?,?)");
        ps.setObject(1, random.nextInt(30));
        ps.setObject(2, 100);
        ps.setObject(3, new Date());        
        ps.executeUpdate();
    }

    public static int saveTransFormer(Transformer transformer) throws SQLException {
        Connection connection=DBConnectoin.getDBConnection();
        PreparedStatement ps=connection.prepareStatement("Insert into transformer "
                + "(idtransformer,Model,Location,Description) value (?,?,?,?)");
        
        ps.setObject(1, transformer.getIdTransformer());
        ps.setObject(2, transformer.getModel());
        ps.setObject(3, transformer.getLocation());
        ps.setObject(4, transformer.getDescription());   
        int res=ps.executeUpdate();
        return res;
    }

    public static int saveMeterDetails(Meter meter) throws SQLException {
        Connection connection=DBConnectoin.getDBConnection();
        PreparedStatement ps=connection.prepareStatement("Insert into meter"
                + "(idMeter,Type,Max_Value,idtransformer) values(?,?,?,?)");
        
        ps.setObject(1, meter.getIdMeter());
        ps.setObject(2, meter.getType());
        ps.setObject(3, meter.getMaxValue());
        ps.setObject(4, meter.getIdTransformer());
        int res=ps.executeUpdate();
        return res;
    }
    
    
    
    //select time,Value,Type,tf.idtransformer from meter m inner join transformer tf on m.idtransformer=tf.idtransformer inner join wind w on m.idMeter=w.idMeter;
    //inner join transformer tf on m.idtransformer=tf.idtransformer inner join wind w on m.idMeter=w.idMeter;

    public static List<WindView> getWindView() throws SQLException {
        List<WindView> list=new ArrayList<>();
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select time,Value,Type,tf.idtransformer from meter m "
                + "inner join transformer tf on m.idtransformer=tf.idtransformer "
                + "inner join wind w on m.idMeter=w.idMeter");
        
        while (rs.next()) {
            WindView windView = new WindView(rs.getInt("Value"),rs.getString("Type"),rs.getTimestamp("time"),rs.getInt("tf.idtransformer"));
            list.add(windView);            
        }        
        return list;
    }

    public static ResultSet getGraph() throws SQLException {
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery("select time,Value from wind");
        return rs;
    }

    public static ResultSet getTransformerId() throws SQLException {
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select idTransformer from transformer");
        return resultSet;
    }    

    public static ResultSet getMeterMaxValue(String toString) throws SQLException {
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select Type,Max_Value from meter where idtransformer="+toString);
        return resultSet;
    }

    public static void SaveRepair(RepairModel repairModel) throws SQLException, FileNotFoundException {
        Connection connection=DBConnectoin.getDBConnection();
        Date date=new Date();
        int id=(int) date.getTime();
        PreparedStatement ps=connection.prepareStatement("Insert into Repair (idRepair,Description,idtransformer,time)"
                + "values(?,?,?,?)");
        ps.setObject(1, id);
        ps.setObject(2, repairModel.getDescription());
        ps.setObject(3, repairModel.getIdTransfomer());
        ps.setObject(4, date);
        int q=ps.executeUpdate();    
        ps=connection.prepareStatement("Insert into repairgallery (idRepair,image)"
                + "values (?,?)");
        for (File file1 : repairModel.getFiles()) {
            FileInputStream fis=new FileInputStream(file1);
            int len=(int) file1.length();
            ps.setObject(1, id);
            ps.setBinaryStream(2, fis,len);
            q=ps.executeUpdate();
            System.out.println(q);
            
        }
        
    }

    public static ResultSet getRepair(String toString) throws SQLException {
        int idt=Integer.parseInt(toString);
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select idRepair,Description,time from repair where idtransformer="+idt);                
        return resultSet;
    }

    public static List<Image> getImage(int valueAt) throws SQLException, IOException {
        Connection connection=DBConnectoin.getDBConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select Image from repairgallery where idRepair="+valueAt);
        List<Image> list=new ArrayList();
        while (resultSet.next()) {
            InputStream fos=resultSet.getBinaryStream("Image");
            Image image = ImageIO.read(fos);
            list.add(image);            
        }
        return list;
    }
}
//select Image,Description,time from repair r where r.idtransformer=444 inner join repairgallery rg on r.idRepair=rg.idRepair