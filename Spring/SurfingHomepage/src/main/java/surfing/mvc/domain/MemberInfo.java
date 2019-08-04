package surfing.mvc.domain;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

//회원가입한 회원 정보 저장

public class MemberInfo {
	private int idx;
	private String id;
	private String pw;
	private String name;
	private String pNum;
	private MultipartFile photo;
	private int level;
	private Timestamp registerDate;

	public MemberInfo() {
		this.registerDate = new Timestamp(System.currentTimeMillis());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", id=" + id + ", pw=" + pw + ", name=" + name + ", pNum=" + pNum + ", photo="
				+ photo + ", level=" + level + ", registerDate=" + registerDate + "]";
	}

	//public LoginInfo toLoginInfo() {
	//	return new LoginInfo(id, pw, name, pNum, photo, level);
	//}
	
	// 파일 사이즈
	public long getFileSize() {
		return photo.getSize();
	}
	
	//파일 이름
	public String getFileName() {
		return photo.getOriginalFilename();
	}

	// 비밀번호 확인
	public boolean matchPassword(String pw) {
		return this.pw.equals(pw);
	}

}