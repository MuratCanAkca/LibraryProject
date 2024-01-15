package com.library.domain;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_message")
public class ContactMessage implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1 , max=50 , message = "Yazdığınız isim `${validatedValue}` {min} ile {max} arası uzunluğunda olmalıdır ")
	@NotNull(message = "Lütfen İsminizi Giriniz")
	@Column(length = 50 , nullable = false)
	private String name;
	
	@Size(min=5 , max=50 , message = "Yazdığınız başlık `${validatedValue}` {min} ile {max} arası uzunluğunda olmalıdır ")
	@NotNull(message = "Lütfen Başlık Giriniz")
	@Column(length = 50 , nullable = false)
	private String subject;
	
	@Size(min=20 , max=200 , message = "Yazdığınız yorum `${validatedValue}` {min} ile {max} arası uzunluğunda olmalıdır ")
	@NotNull(message = "Lütfen Yorumunuzu Giriniz")
	@Column(length = 200 , nullable = false)
	private String body;
	
	@Email
	@Column(length = 50 , nullable = false)
	private String email;
	
	
}
