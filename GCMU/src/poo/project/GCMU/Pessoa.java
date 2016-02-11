package poo.project.GCMU;
/**
 * 
 * @author GCMU
 *	Essa � uma classe mae que contem os atributos comuns entre discente e docente 
 */
public abstract class Pessoa {
	private int matricula;
	private String name;
	private String email;
	private String telefone;
	private String senha;

	public Pessoa(int matricula, String name, String email, String telefone, String senha) {
		this.matricula = matricula;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 *  A fun�ao desse m�todo, ser� de requisitar a chave para o Dicente/Docente.
	 *  Ele ir� printar na tela que a chave foi reservada, se nao, que est� ocupada!
	 * @return
	 */
	public String requisitaChave() {
		return ("ok, Chave Reservada!");
	}
	/**
	 *  A fuA fun�ao desse m�todo, ser� de requisitar materiais para o Docente.
	 *  ele ir� printar na tela que o material foi reservado, se nao, que est� ocupado!
	 * @return
	 */
	public String requisitaMateriais() {
		return ("ok, Material reservado!");
	}
	/**
	 *  A fun�ao desse m�todo, ser� de requisitar um untencio perdido para o Aluno/
	 *  Dicente/Docente. Ele ir� printar na tela que o untencilio foi encontrado!
	 * @return
	 */
	public String requisitaUtensilios() {
		return ("ok, Utencilio Encontrado!");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
