package br.unipe.pos.web.model;



	import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**JPA e um pouco Hibernate*/
	/**
	 * 
	 * @author felipe.dias
	 *
	 */
	@Entity
	@Table(name = "persons")// opcional
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
			allowGetters = true)
	public class Person {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@NotBlank
		private String firstName;

		@NotBlank
		private String lastName;

		@Column(nullable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate /**colocando a data da informação criada*/
		private Date createdAt;

		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate /**a hora e data de que o dado foi atualizado*/
		private Date updatedAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

	}

