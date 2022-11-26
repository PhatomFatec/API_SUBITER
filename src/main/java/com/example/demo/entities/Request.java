package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "request")
public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "req_id")
	private Long id;

	@Column(name = "req_title")
	private String title;

	@Column(name = "req_description")
	private String description;

	@Column(name = "req_imgurl")
	private String imgUrl;

	@NotBlank(message = "O campo status não pode estar em branco")
	@Column(name = "req_status")
	private String status;

	@Column(name = "req_date")
	private LocalDate requestDate;

	@ManyToOne
	@JoinColumn(name = "u_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;

	@JsonIgnore
	@OneToOne(mappedBy = "request", cascade = CascadeType.ALL)
	private Schedule schedule;

	@JsonIgnore
	@OneToMany(mappedBy = "request")
	private Set<Comment> comment = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
	private Set<Image> image = new HashSet<>();

	public Request() {
	}

	public Request(Long id, String title, String description, String imgUrl, String status, User user,
			Product product) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.imgUrl = imgUrl;
		this.status = status;
		this.requestDate = LocalDate.now();
		this.user = user;
		this.product = product;

	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(id, other.id);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
