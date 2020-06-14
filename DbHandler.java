/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

/**
 *
 * @Kelompok 12
 * @Novita - 12s18009
 * @putri - 12s18017
 * @sandraulina - 12s18036
 * @elsa - 12s18050
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import proyek.*;


public class DbHandler {
    private Connection connection;
    private boolean connected;
    public int counter;
    
    public DbHandler(){
        this.connected = false;
    }
    
    public boolean connect(String _host, String _dbName, String _username, String _password){
        String connectionString = "jdbc:mariadb://" + _host + "/" + _dbName;
        
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(connectionString, _username, _password);
            this.connected = true;
         } catch (Exception _e){
             System.out.println("Exception: " + _e.getMessage());
         }
         return(this.connected);
    }
    
    public void disconnect(){
        if(this.connected){
            try{
                this.connection.close();
            } catch (Exception _e){
                System.out.println("Exception: " + _e.getMessage());
            }
        }
        this.connected = false;
        }
    
    public boolean isConnected(){
        return (this.connected);
    }
    
    public void Poin_pelanggaran(String _kode_pelanggaran, String _nama_pelanggaran, String _pengurangan_poin, String _jenis_pelanggaran, String _tanggal_update){
        
    if(this.connected){
        String query = "INSERT INTO poin_pelanggaran(kode_pelanggaran, nama_pelanggaran, pengurangan_poin, jenis_pelanggaran, tanggal_update) VALUES(" + "" + _kode_pelanggaran + "," + "'" + _nama_pelanggaran + "',"+"" + _pengurangan_poin + "," + "" + _jenis_pelanggaran + "," + "'" + _tanggal_update + "'" + ")";
        try{
            Statement stmt = this.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
        } catch (Exception _e){
            System.out.println("Exception: "+ _e.getMessage());
        }
    }
}
    
    public void addPoin_pelanggaran(String _kode_pelanggaran, String _nama_pelanggaran, String _pengurangan_poin, String _jenis_pelanggaran, String _tanggal_update){
        
        if(this.connected){
            String query = "INSERT INTO Poin_pelanggaran(kode_pelanggaran, nama_pelanggaran, pengurangan_poin, jenis_pelanggarana, tanggal update) VALUESkode_pelanggaran, nama_pelanggaran, pengurangan_poin, jenis_pelanggaran, tanggal_update) VALUES(" + "" + _kode_pelanggaran + "," + "'" + _nama_pelanggaran + "',"+"" + _pengurangan_poin + "," + "" + _jenis_pelanggaran + "," + "'" + _tanggal_update + "'" + ")";
            try{
                Statement stmt = this.connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
            } catch (Exception _e){
                System.out.println("Exception: " + _e.getMessage());
            }
      }
    
    }
    
    
    public List<Poin_pelanggaran>getallpoin_pelanggaran(){
        this.counter = 0;
    List<Poin_pelanggaran> buff = new ArrayList<Poin_pelanggaran>();
        Poin_pelanggaran buf2 = null;
    if(this.connected){
        String query = "SELECT kode_pelanggaran, nama_pelanggaran, pengurangan_poin, jenis_pelanggaran, tanggal_update, FROM db_legenda.poin_pelanggaran";
        try{
            Statement stmt = this.connection.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);
                        while (resultSet.next()) {
                            buf2 = new Poin_pelanggaran(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
                                    counter++;
                                        buff.add(buf2);
				}
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		return buff;
   } 
    
    public void Pelanggaran_mahasiswa(String kode_pelanggaran, String NIM, String nama_pelanggaran, String pengurangan_poin, String gelar, String tanggal_update, String total_poin) {
		
		if (this.connected) {
			String query = "INSERT INTO pelanggaran_mahasiswa(kode_pelanggaran, NIM, nama_pelanggaran, pengurangan_poin, gelar, tanggal_update, total_poin ) VALUES(" + "" + kode_pelanggaran + "," + "'" + NIM + "',"+"" + pengurangan_poin + "," + "" + gelar + "," + "'" + tanggal_update + "'" + "" + total_poin +"," +")";
                        try{
                            Statement stmt = this.connection.createStatement();
                            ResultSet resultSet = stmt.executeQuery(query);
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		
	}
    
     public void addPelanggaran_mahasiswa(String kode_pelanggaran, String NIM, String nama_pelanggaran, String pengurangan_poin, String gelar, String tanggal_update, String total_poin){
        
        if(this.connected){
            String query = "INSERT INTO Poin_pelanggarangaran(kode_pelanggaran, NIM, nama_pelanggaran, pengurangan_poin, gelar, tanggal_update, total_poin)VALUES(" + "" + kode_pelanggaran + "," + "'" + NIM + "',"+"" + pengurangan_poin + "," + "" + gelar + "," + "'" + tanggal_update + "'" + "" + total_poin +"," +")";
                        try{
                Statement stmt = this.connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
            } catch (Exception _e){
                System.out.println("Exception: " + _e.getMessage());
            }
      }
    
    }
     
           public List<Pelanggaran_mahasiswa>getallpelanggaran_mahasiswa(){
        this.counter = 0;
    List<Pelanggaran_mahasiswa> buff = new ArrayList<Pelanggaran_mahasiswa>();
        Pelanggaran_mahasiswa buf2 = null;
    if(this.connected){
        String query = "SELECT kode_pelanggaran, NIM, nama_pelanggaran, pengurangan_poin, gelar, tanggal_update, total_poin FROM db_legenda.pelanggaran_mahasiswa";
        try{
            Statement stmt = this.connection.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);
                        while (resultSet.next()) {
                            buf2 = new Pelanggaran_mahasiswa(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
                                    counter++;
                                        buff.add(buf2);
				}
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		return buff;
   }
      
    
     public Pelanggaran_mahasiswa updatetotalpoin( String NIM,String total_poin){
                Pelanggaran_mahasiswa pelanggaran_mahasiswa  = null;
                if (this.connected) {
			String query = "UPDATE `db_legenda`.`pelanggaran_mahasiswa` SET `total_poin`="+ total_poin + " WHERE  `NIM`= '" + NIM + "'";
			try {
				
                                Statement stmt = this.connection.createStatement();
                            
				ResultSet resultSet = stmt.executeQuery(query);
                                
				while (resultSet.next()) {
                                    pelanggaran_mahasiswa.setNIM(resultSet.getString(1));
                                    pelanggaran_mahasiswa.settotal_poin(resultSet.getString(2));
                                    counter++;
                 }
                                        
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		
	
                }
                return (pelanggaran_mahasiswa);
            }
     

       public void Gelar(String _gelar, String _NIM, String _total_poin, String _prodi){
        
    if(this.connected){
        String query = "INSERT INTO gelar(gelar, NIM, total_poin, prodi) VALUES(" + "" + _gelar + "," + "'" + _NIM+ "',"+"" + _total_poin + "," + "" + _prodi + "," + ")";
        try{
            Statement stmt = this.connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
        } catch (Exception _e){
            System.out.println("Exception: "+ _e.getMessage());
        }
    }
}
  
       public void addGelar(String gelar, String NIM, String total_poin, String prodi){
        
        if(this.connected){
            String query = "INSERT INTO gelar(gelar, NIM, total_poin, prodi)VALUES(" + "" + gelar + "," + "'" + NIM + "',"+"" + total_poin + "," + "" + prodi + "," + ")";
                        try{
                Statement stmt = this.connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);
            } catch (Exception _e){
                System.out.println("Exception: " + _e.getMessage());
            }
      }
    
    }     
       
        public List<Gelar>getallgelar(){
        this.counter = 0;
    List<Gelar> buff = new ArrayList<Gelar>();
        Gelar buf2 = null;
    if(this.connected){
        String query = "SELECT gelar, NIM, total_poin, prodi FROM db_legenda.gelar";
        try{
            Statement stmt = this.connection.createStatement();
                    ResultSet resultSet = stmt.executeQuery(query);
                        while (resultSet.next()) {
                            buf2 = new Gelar(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                                    counter++;
                                        buff.add(buf2);
				}
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		return buff;
   }
       public Gelar getgelarbytotal_poin(String _total_poin) {
                this.counter = 0;
		Gelar buff = null;
                
		if (this.connected) {
			String query = "SELECT gelar, NIM, total_poin, prodi  FROM db_legenda.gelar WHERE total_poin ='"+_total_poin+"'";
			try {
				
                                Statement stmt = this.connection.createStatement();
                            
				ResultSet resultSet = stmt.executeQuery(query);
                                
				if (resultSet.next()) {
					buff = new Gelar(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                                  	counter++;
				}
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		return buff;
	} 
       
       public Gelar getgelarbyNIM(String _NIM) {
                this.counter = 0;
		Gelar buff = null;
                
		if (this.connected) {
			String query = "SELECT gelar, NIM, total_poin, prodi  FROM db_legenda.gelar WHERE NIM ='"+_NIM+"'";
			try {
				
                                Statement stmt = this.connection.createStatement();
                            
				ResultSet resultSet = stmt.executeQuery(query);
                                
				if (resultSet.next()) {
					buff = new Gelar(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                                  	counter++;
				}
			} catch (Exception _e) {
				
                                System.out.println("Exception: " + _e.getMessage());
			}
		}
		return buff;
	} 
        }
     
    
    
    
