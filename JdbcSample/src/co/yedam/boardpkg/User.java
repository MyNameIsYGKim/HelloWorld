package co.yedam.boardpkg;

public class User {
	private String userId;
	private String userName;
	private String userPw;

	public User(String userId, String userName, String userPw) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPw = userPw;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}
