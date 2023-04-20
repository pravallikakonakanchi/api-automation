package testdata;

public class GetDataPayload {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	private String userid;
	private String id;
	
	public GetDataPayload(String userid, String id, String accountno, String departmentno, String salary, String pincode) {
		
		this.accountno = accountno;
		this.departmentno = departmentno;
		this.salary = salary;
		this.pincode = pincode;
		this.userid = userid;
		this.id = id;
	}
	
	public String getAccountNo() {
		return accountno;
	}
	
	public String getDeptNo() {
		return departmentno;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public String getUserId() {
		return userid;
	}
	public String getId() {
		return id;
	}
	


}
