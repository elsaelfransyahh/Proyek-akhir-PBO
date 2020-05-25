
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author 12S18009 – Novita Enjelia Hutapea  
 * @author 12S18017 – Putri Yohana Panjaitan 
 * @author 12S18036 - Sandraulina Siregar 
 * @author 12S18050 - Elsa Elfransyah Marbun 
 */

public class Mahasiswa {
  private char NIM;
  private char nama;
  private int angkatan; 
  private char prodi;
  private char kode_pelanggaran;
  private Date tanggal_poin_ditambahkan;  
  private int bobot_pelanggaran;
  
  public int get_pelanggaran_mahasiswa(){
  return bobot_pelanggaran;   
  }
  
  public char see_poin_pelanggaran(){
  return kode_pelanggaran;       
  }
  
}
