package sopra.formation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("trainee")
public class Stagiaire extends Personne {
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	@JsonView(Views.ViewCommon.class)
	private Date dtNaissance;
	@Enumerated(EnumType.STRING)
	@Column(name = "studylevel")
	@JsonView(Views.ViewCommon.class)
	private NiveauEtude niveauEtude;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "training_id")
	@JsonView(Views.ViewStagiaireDetail.class)
	private Filiere filiere;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rating_id")
	@JsonView(Views.ViewStagiaire.class)
	private Evaluation evaluation;

	public Stagiaire() {
		super();
	}

	public Stagiaire(String nom, String prenom) {
		super(nom, prenom);
	}

	public Stagiaire(Long id, int version, String nom, String prenom, String email, String telephone, Adresse adresse,
			Date dtNaissance, NiveauEtude niveauEtude) {
		super(id, version, nom, prenom, email, telephone, adresse);
		this.dtNaissance = dtNaissance;
		this.niveauEtude = niveauEtude;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}
