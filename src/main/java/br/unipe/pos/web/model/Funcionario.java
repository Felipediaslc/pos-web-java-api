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
	@Table(name = "funcionario")// opcional
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
			allowGetters = true)
	public class Funcionario {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

	
		private Long firstMatricula;

		
		private String lastNameFunc;
		
		
		private String lastCurso;
		
		
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

		public Long getFirstMatricula() {
			return firstMatricula;
		}

		public void setFirstMatricula(Long firstMatricula) {
			this.firstMatricula = firstMatricula;
		}

		public String getLastNameFunc() {
			return lastNameFunc;
		}

		public void setLastNameFunc(String lastNameFunc) {
			this.lastNameFunc = lastNameFunc;
		}

		public String getLastCurso() {
			return lastCurso;
		}

		public void setLastCurso(String lastCurso) {
			this.lastCurso = lastCurso;
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