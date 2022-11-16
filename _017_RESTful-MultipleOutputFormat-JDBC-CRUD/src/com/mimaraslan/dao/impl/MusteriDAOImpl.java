package com.mimaraslan.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mimaraslan.dao.MusteriDAO;
import com.mimaraslan.model.pojo.entity.bean.Musteri;

public class MusteriDAOImpl implements MusteriDAO{

   static Connection con = null;
	
	@Override
	public Connection veritabaninaBaglantiKur() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firmaveritabani", "root", "root");
			
			if (!con.isClosed()) {
				System.out.println("Veritabanına başarılı olarak bağlandık.");
			}else{
				System.out.println("Veritabanına bağlantı olarak kurulamadı.");
			}
			
			
		} catch (Exception e) {
			System.out.println("Hata: "+e);
		}finally {
			System.out.println("Aha dayı sor.");
		}
		
		return con;
	}
	
	
	@Override
	public List<Musteri> veriOku() {
		veritabaninaBaglantiKur();
		
		List<Musteri> musteriler = new ArrayList<Musteri>();
		Musteri musteri = null;
		
		try {
			PreparedStatement  preparedStatement = con.prepareStatement("SELECT * FROM Musteri");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
			//	System.out.println(resultSet.getInt(1) + " "+ resultSet.getInt(2) + " " +
			//			resultSet.getString(3) + " "+ resultSet.getString(4) );
				
				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(4));
				
				musteriler.add(musteri);
			}
			
			
		} catch (Exception e) {
		System.out.println("HATA: "+e);
		}
			
		
		for (int i = 0; i < musteriler.size(); i++) {
			Object obj = musteriler.get(i).getMusteriId() + " " +
					musteriler.get(i).getMusteriNo() + " " +
					musteriler.get(i).getMusteriAdi() + " " +
					musteriler.get(i).getMusteriSoyadi();
			
			System.out.println(obj);
		}
		
		
		return musteriler;
	}



	@Override
	public Musteri veriOku(int musteriId) {
		veritabaninaBaglantiKur();
	
		Musteri musteri = null;
		
		try {
			
			String sorgu = "SELECT * FROM firmaveritabani.Musteri WHERE musteriId=?";
			
			
			PreparedStatement  preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteriId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
		
				musteri = new Musteri(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(4));

			}

		} catch (Exception e) {
		System.out.println("HATA: "+e);
		}	
		
		System.out.println(musteri);
		/*
			System.out.println(
					musteri.getMusteriId() + " " +
					musteri.getMusteriNo()+ " " +
					musteri.getMusteriAdi()+ " " +
					musteri.getMusteriSoyadi());	
			*/
			
		return musteri;
	}

	@Override
	public boolean veriEkle(Musteri musteri) {
		veritabaninaBaglantiKur();
		
boolean eklemeDurumu = false;
String sonuc = "";		
		try {
			
			String sorgu = "INSERT INTO Musteri (musteriNo, musteriAdi, musteriSoyadi) VALUES (?, ?, ?)";

			PreparedStatement  preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteri.getMusteriNo());
			preparedStatement.setString(2, musteri.getMusteriAdi());
			preparedStatement.setString(3, musteri.getMusteriSoyadi());
			
			eklemeDurumu = preparedStatement.execute();
			
			if(eklemeDurumu == false)
				sonuc = "Ekleme başarılı.";
			else
				sonuc = "Ekleme başarısız.";


		} catch (Exception e) {
		System.out.println("HATA: "+e);
		}	
		
		System.out.println(sonuc);
	
		return eklemeDurumu;

	}

	@Override
	public boolean veriDuzenle(Musteri musteri, int musteriId) {
		veritabaninaBaglantiKur();
		
		boolean duzenlemeDurumu = false;
		String mesajSonuc = "";		
				try {
					
				
				String sorgu =	"UPDATE Musteri"
						+ " SET musteriNo = ?, "
							+ " musteriAdi = ?, "
							+ " musteriSoyadi = ? "
							+ " WHERE musteriId = ?";

					
					PreparedStatement  preparedStatement = con.prepareStatement(sorgu);
					preparedStatement.setInt(1, musteri.getMusteriNo());
					preparedStatement.setString(2, musteri.getMusteriAdi());
					preparedStatement.setString(3, musteri.getMusteriSoyadi());
					preparedStatement.setInt(4, musteriId);
					
					int sorguSonucu = preparedStatement.executeUpdate();
					
					if(sorguSonucu == 1){
						mesajSonuc = "Düzenleme başarılı.";
						duzenlemeDurumu = true;
						}else{
						mesajSonuc = "Düzenleme başarısız.";
						duzenlemeDurumu = false;}


				} catch (Exception e) {
				System.out.println("HATA: "+e);
				}	
				
				System.out.println(mesajSonuc);
			
				return duzenlemeDurumu;
				
		
		
	}

	@Override
	public boolean veriSilme(int musteriId) {
		veritabaninaBaglantiKur();

		boolean silmeDurumu = false;
		String sonuc = "";	
		
		try {
			
			String sorgu = "DELETE FROM Musteri  WHERE musteriId=?";
			
			PreparedStatement  preparedStatement = con.prepareStatement(sorgu);
			preparedStatement.setInt(1, musteriId);

			silmeDurumu = preparedStatement.execute();
			
			if(silmeDurumu == false)
				sonuc = "Silme başarılı.";
			else
				sonuc = "Silme başarısız.";
			
			

		} catch (Exception e) {
		System.out.println("HATA: "+e);
		}	
		
		System.out.println(sonuc);
		
		return silmeDurumu;
		
		
	}

	
	public static void main(String[] args) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		//nesne.veritabaninaBaglantiKur();
		//nesne.veriOku();
		//nesne.veriOku(2);
		
	/*
		Musteri	musteri = new Musteri();
		musteri.setMusteriNo(1299);
		musteri.setMusteriAdi("Faik");
		musteri.setMusteriSoyadi("Turan");
		
		nesne.veriEkle(musteri);
		*/
	//	nesne.veriSilme(10);
		
		
		//nesne.veriDuzenle(nesne.veriOku(13), 6);
		
		/*
		Musteri	musteri = new Musteri();
		musteri.setMusteriNo(1453);
		musteri.setMusteriAdi("Mimar");
		musteri.setMusteriSoyadi("Aslan");
		nesne.veriDuzenle(musteri, 6); 
		*/
		
		}
}
