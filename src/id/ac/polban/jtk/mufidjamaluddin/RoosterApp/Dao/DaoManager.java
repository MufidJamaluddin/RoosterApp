/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class induk untuk koneksi ke Database
 * 
 */
public class DaoManager 
{    
    /**
     * Atribut
     */
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    private Connection jdbcConnection;
    
    /**
     * Konstruktor
     * 
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     */
    public DaoManager(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    /**
     * Method untuk koneksi ke Database MySQL
     * menggunakan Jdbc Driver.
     * Setelah koneksi, jangan lupa untuk disconnect.
     */
    protected void connect()
    {
        try {
            // jika koneksi belum diset atau ditutup
            if (jdbcConnection == null || jdbcConnection.isClosed()) 
            {
                try 
                {
                    // mendapatkan class jdbc driver
                    Class.forName("com.mysql.jdbc.Driver");
                } 
                catch (ClassNotFoundException e) 
                {
                    // kelas gagal ditemukan
                    throw new SQLException(e);            // Gagal koneksi, trace log histori
                }
                // assignment koneksi
                jdbcConnection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk disconnect 
     * koneksi dengan DBMS
     */
    protected void disconnect()
    {
        try 
        {
            // jika koneksi masih ada dan belum ditutup
            if (jdbcConnection != null && !jdbcConnection.isClosed()) 
            {
                // koneksi ditutup
                jdbcConnection.close();
            }
        } 
        catch (SQLException ex) 
        {
            // gagal menutup koneksi, trace log
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk Mendapatkan Reference Connection
     * @return 
     */
    public Connection getJdbcConnection() 
    {
        return jdbcConnection;
    }

}