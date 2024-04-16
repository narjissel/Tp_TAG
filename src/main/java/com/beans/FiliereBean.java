package com.beans;

import com.entities.FiliereEntity;
import com.service.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedBean;
import java.util.List;


/* cette classe FiliereBean agit comme un contrôleur ou un bean managé dans une application JSF.
Elle utilise les fonctionnalités de Spring pour l'injection de dépendances et la gestion
de la portée de session, tout en exploitant les capacités de JSF pour la gestion du cycle de vie du bean.
Elle interagit avec la couche de service FiliereService pour manipuler les entités FiliereEntity
dans l'application JSF.
*/

@Component
@ManagedBean // C'est une annotation spécifique à JavaServer Faces (JSF) qui marque cette classe
// comme un bean managé par JSF. Elle permet à JSF de gérer le cycle de vie de ce bean et de
// le rendre disponible dans les pages JSF.

@Scope("session") //  Cette annotation définit la portée du bean à la portée de session.
// Cela signifie qu'une instance de ce bean est créée par session utilisateur dans une application web.
public class FiliereBean {
	
	@Autowired //Utilisée pour injecter le service FiliereService dans cette classe.
	// Cette injection permet à FiliereBean d'utiliser les méthodes de FiliereService
	// pour interagir avec la couche de service gérant les entités FiliereEntity.
	private FiliereService filiereService;

	private FiliereEntity filiere;
	private boolean modifyContext;
	
	
	public FiliereBean() {
		
		this.filiere = new FiliereEntity();
		this.modifyContext = false;
	}

	public FiliereEntity getFiliere() {
		return filiere;
	}

	public void setFiliere(FiliereEntity filiere) {
		this.filiere = filiere;
	}
	
	
	public boolean isModifyContext() {
		return modifyContext;
	}

	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}

	public List<FiliereEntity> getFilieres() {
		
		return this.filiereService.getAll();
	}
	
	public String getLabel() {
		return isModifyContext() ? "Modification" : "Ajout";
	}
	
	@Transactional
	public void save() {
		
		this.filiereService.saveOrUpdate(this.filiere);
		this.filiere = new FiliereEntity();
		this.setModifyContext(false);
	}
	@Transactional
	public void modify(FiliereEntity f) {
		
		this.filiere = f;
		this.setModifyContext(true);
	}
	
	@Transactional
	public void delete(FiliereEntity f) {
		
		this.filiereService.delete(f);
		this.filiere = new FiliereEntity();
	}
}
