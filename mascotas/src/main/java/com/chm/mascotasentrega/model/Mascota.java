package com.chm.mascotasentrega.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity

public class Mascota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(min=5, message="El nombre debe tener al menos 5 caracteres")
	private String nombre;
	private Date fecha_nac;
	private String raza;
	private double peso;
	private boolean tiene_chip;
	

}
