package tr.com.yusuf.types;

public class HesaplarContract {

	private int id;
	private String ad;
	private int yetkiId;
	private int personelId;
	private String sifre;
	
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
	public int getYetkiId(){
		return this.yetkiId;
	}
	public void setYetkiId(int yetkiId){
		this.yetkiId = yetkiId;
	}
	public void getPersonelId(int personelId){
		this.personelId = personelId;
	}
	public String getSifre(){
		return this.sifre;
	}
	public void setSifre(String sifre){
		this.sifre = sifre;
	}
	public int getPersonelId(){
		return this.personelId;
	}
	public void setPersonelId(int personelId){
		this.personelId = personelId;
	}
	@Override 
	public String toString(){
		return String.format("%d %s %d %d %s");
	} 
}
