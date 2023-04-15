package tr.com.yusuf.types;
import java.util.Date;
public class StokContract {
	private int id;
	private String ad;
	private int kategoriId;
	private Date tarih;
	private float fiyat;
	
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getAd(){
		return this.ad;
	}
	public void setAd(String ad){
		this.ad = ad;
	}
	public int getKategoriId(){
		return this.kategoriId;
	}
	public void setKategoriId(int kategoriId){
		this.kategoriId = kategoriId; 
	}
	public Date getTarih(){
		return this.tarih;
	}
	public void setTarih(Date tarih){
		this.tarih = tarih;
	}
	public float getFiyat(){
		return this.fiyat;
	}
	public void setFiyat(float fiyat){
		this.fiyat = fiyat;
	}
}