package tr.com.yusuf.types;

public class KategoriContract {
	
	private int id;
	private String ad;
	private int parentId;
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getAdi(){
		return this.ad;
	}
	public void setAdi(String ad){
		this.ad = ad;
	}
	public int getParentId(){
		return this.parentId;
	}
	public void setParentId(int parentId){
		 this.parentId = parentId;
	}
	@Override
	public String toString(){
		return String.format("%d %s %d",id,ad,parentId);
	}
}
