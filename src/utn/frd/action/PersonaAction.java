package utn.frd.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import utn.frd.bean.Persona;
import utn.frd.db.PersistentManager;

public class PersonaAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String name; 
	private String age; 
	private String gender; 
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	private List<Persona>personas;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	public String execute(){//inicializar coleccion
		personas = PersistentManager.getInstance();
		
		return SUCCESS;
	}
	
	
	public String save(){ 
		personas = PersistentManager.getInstance(); 
		int edad = 0; 
		long idUltimo ;//id de la ultima persona agregada
		long idNuevo = 0; //id de la persona agregada
		int ultimaUbicacion ;
		Persona ultimaPersona;
		try{ 
		edad = Integer.parseInt(age); 
		}catch(Exception e){ 
		addActionError("Ocurrió un error con la edad"); 
		return ERROR; 
		} 
		 
		try{
			if (personas.isEmpty()){
				idNuevo=1;
			}else{
			ultimaUbicacion = personas.size() - 1;
			ultimaPersona=personas.get(ultimaUbicacion); //ultima persona que fue agregada
			idUltimo=ultimaPersona.getId();
			idNuevo= idUltimo +1;
			}
			Persona p = new Persona(idNuevo, name, edad, gender); //creo la persona
			personas.add(p);//agrego una persona a la lista personas
		}catch(Exception e){
			addActionError("Ocurrio un error al crear la persona");
			return ERROR;
		}
		
	
			return SUCCESS; 
		}
	
	public String delete(){
		personas = PersistentManager.getInstance();
		long idElegido;
		try{ 
			idElegido = Integer.parseInt(id); 
			}catch(Exception e){ 
			addActionError("Ocurrió un error"); 
			return ERROR; 
			} 
		
		try{
			personas.removeIf(persona -> persona.getId() == idElegido);
		}catch(Exception e){
			addActionError("Ocurrio un error al eliminar la persona");
			return ERROR;
		}
			return SUCCESS; 
	}
		
	
	public String edit(){
		personas = PersistentManager.getInstance();
		long idElegido;
		int edad = 0;
		try{ 
			idElegido = Integer.parseInt(id); 
			edad = Integer.parseInt(age);
			}catch(Exception e){ 
			addActionError("Ocurrió un error"); 
			return ERROR; 
			} 
			
		try{
			for(Persona p:personas){
				if (p.getId() == idElegido) {			
					p.setGender(getGender());
					p.setName(getName());
					p.setAge(edad);					
				}
			}
		}catch(Exception e){
			addActionError("Ocurrio un error al modificar la persona");
			return ERROR;
			}
			return SUCCESS;
		}
}
	


