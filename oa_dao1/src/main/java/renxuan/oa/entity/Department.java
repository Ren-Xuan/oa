package renxuan.oa.entity;

public class Department {
	private String sn;
	private String name;
	private String address;
	public Department(String sn, String name, String address) {
		super();
		this.sn = sn;
		this.name = name;
		this.address = address;
	}
	public Department() {
		
	}
	public String getSn() {
		return sn;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
