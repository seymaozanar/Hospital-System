package com.enviyo.drug.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="disease",schema="grupa")
@Data

public class Disease {

		@Id
		@GeneratedValue(generator="system-uuid")
		@GenericGenerator(name="system-uuid", strategy="uuid")
		@Column(name="id")
		private String id;
		
		@Column(name="disease_name")
		private String disease_name;
		
		@Column(name="disease_description")
        private String disease_description;

		public String getDisease_id() {
			return  id;
		}

		public void setDisease_id(String disease_id) {
			this.id = disease_id;
		}

		public String getDisease_name() {
			return disease_name;
		}

		public void setDisease_name(String disease_name) {
			this.disease_name = disease_name;
		}

		public String getDisease_description() {
			return disease_description;
		}

		public void setDisease_description(String disease_description) {
			this.disease_description = disease_description;
		}

}
