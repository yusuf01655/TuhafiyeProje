package tr.com.yusuf.types;

public class YetkilerContract {

	private int id;
	private String ad;
	
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
	@Override
	public String toString(){
		return String.format("%d %s",id,ad);
	}
}