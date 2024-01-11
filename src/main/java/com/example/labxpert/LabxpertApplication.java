package com.example.labxpert;

import com.example.labxpert.Model.*;
import com.example.labxpert.Model.Enum.Role;
import com.example.labxpert.Model.Enum.Sexe;
import com.example.labxpert.Repository.IPersonRepository;
import com.example.labxpert.Service.IFournisseurService;
import com.example.labxpert.Service.IPatientService;
import com.example.labxpert.Service.IReactifService;
import com.example.labxpert.Service.IUserService;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class LabxpertApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LabxpertApplication.class, args);
	}

	private IUserService iUserService;
	private IPatientService iPatientService;
	private IPersonRepository iPersonRepository;
	private IFournisseurService iFournisseurService;
	private IReactifService iReactifService;


	@Override
	public void run(String... args) throws Exception {

		// fournisseur and reactif test crud operation


		//Fournisseur fournisseur = new Fournisseur();
		//fournisseur.setNameComplet("marouane mouslih");
		//fournisseur.setSocieteName("atlas");
		//iFournisseurService.add(fournisseur);

		Fournisseur fournisseur = iFournisseurService.getById(3L);

		//System.out.println(fournisseur.getNameComplet() + "," + fournisseur.getSocieteName());
		Reactif reactif = new Reactif();
		reactif.setNom("nom reactif 3");
		reactif.setDescription("description 3");
		reactif.setFournisseur(fournisseur);
		reactif.setQuantity_stock(18);
		reactif.setDate_exp(LocalDate.now());
		//iReactifService.add(reactif);

		//iFournisseurService.delete(2L);

/*		List<Fournisseur> fff = iFournisseurService.getAll();
		fff.forEach(fournisseur1 -> {
			System.out.println("Fournisseur: " + fournisseur1.getNameComplet() + "," + fournisseur1.getSocieteName());
		});*/

		List<Reactif> rea = iReactifService.getAll();
		rea.forEach(reactif1 -> System.out.println(reactif1.getNom()));
	}
}
