package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Member {
	private static final Logger log = LoggerFactory.getLogger(Member.class);
	public static final GuestMember GUEST_MEMBER = new GuestMember();

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private long id;

	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20)
	private String name;

	@Column(nullable = false)
	@JsonIgnore
	private String password;

	@Email
	@Size(min = 6, max = 50)
	@Column(unique = true, nullable = false, length = 50)
	private String email;

	@ManyToMany
	@OrderBy("id ASC")
	@JoinTable(name = "board_list", 
	joinColumns = @JoinColumn(name = "MEMBER_ID"), 
	inverseJoinColumns = @JoinColumn(name = "BOARD_ID"))
	private List<Board> boardList = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="member")
	private List<MemberRole> roles = new ArrayList<>();
	
	public Member() {
		this("", "");
	}

	public Member(String email, String password) {
		this("", password, email);
	}

	public Member(String name, String password, String email) {
		this(0L, name, password, email);
	}

	public Member(long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.roles.add(new MemberRole(MemberRole.USER));
	}

	public boolean matchPassword(String password) {
		return password.equals(this.password);
	}

	public void addBoard(Board board) {
		boardList.add(board);
	}

	@JsonIgnore
	public boolean isGuestMember() {
		return false;
	}

	private static class GuestMember extends Member {
		@Override
		public boolean isGuestMember() {
			return true;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Board> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	
	public List<MemberRole> getRoles() {
		return roles;
	}

	public void setRoles(List<MemberRole> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email;
	}

}
