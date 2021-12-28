import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    static Connection con;

    public static void main(String[] args){ 
       
        Integer pilihan;
        int x = 0;
        Scanner input = new Scanner (System.in);
        boolean isLanjutkan = true;
        
    String url = "jdbc:mysql://localhost:3306/karyawan_gaji";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","");
		System.out.println("Driver Ready");

        while (isLanjutkan) {
            System.out.println("");
            System.out.println("========================");
            System.out.println("PROGRAM PENGECEKAN GAJI");
            System.out.println("========================");
            System.out.println("1. Input Gaji Karyawan");
            System.out.println("2. Ubah Data Kaaryawan");
            System.out.println("3. Cek Gaji Karyawan"); 
            System.out.println("4. Hapus Data Karyawan");
            System.out.print("Masukkan Pilihan : ");
            pilihan = input.nextInt();

           
        switch (pilihan) {
            
            case 1 :
                    TerimaGaji karyawan = new TerimaGaji();
                    karyawan.NamaPegawai();
                    karyawan.NoPegawai();
                    karyawan.Jabatan();
                    karyawan.GajiPokok();
                    karyawan.JumlahHariMasuk();
                    karyawan.Potongan();
                    karyawan.TotalGaji();
                    karyawan.Absensi();
                    karyawan.database();
                                        
                    System.out.println("Data Berhasil di Inputkan");
                    System.out.println("");
                    break;

            case 2 :TerimaGaji karyawan3 = new TerimaGaji();
                    karyawan3.ubahData();
                    break;
                    
            case 3 :
                            String cetak = "   program pengecekan gaji";
                            String cetak1 = "Dicetak Pada";

                            String GantiKalimat = cetak.replace("pengecekan", "MENAMPILKAN");
                            System.out.println("---------------------------------");
                            System.out.println(GantiKalimat.toUpperCase());
                            System.out.println("---------------------------------");

                            DateFormat formatTanggal = new SimpleDateFormat("dd MMMM yyyy");
                            DateFormat formatJam = new SimpleDateFormat("HH:mm:ss");
                            Date tanggal = new Date();

                            TerimaGaji karyawan2 = new TerimaGaji(); 
                            karyawan2.Show();

                            System.out.println("-------------------------------");
                            System.out.println("\t"+cetak1.toLowerCase());
                            System.out.println("Tanggal : "+formatTanggal.format(tanggal));
                            System.out.println("Jam     : "+formatJam.format(tanggal)+" WIB ");
                            System.out.println("-------------------------------");      
                            System.out.println("");                                       
                         
                break;
                
            case 4 : 
                    TerimaGaji karyawan5 = new TerimaGaji();
                    karyawan5.delete();
                    karyawan5.showdataBase();
                    break;
                         
            default: 
            System.out.println("MENU TIDAK TERSEDIA !!!!");
            System.out.println("");
                break;
            }
        
        }
    } catch (ClassNotFoundException ex) {
        System.err.println("Driver eror");
        System.exit(0);
    }
    catch(SQLException e){
        System.err.println("Tidak berhasil Koneksi");
    }
    }
}
