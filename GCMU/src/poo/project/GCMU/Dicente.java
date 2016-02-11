package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa um discente que autorizado pelo administrador podera pegar chaves ou materiais
 */
public class Dicente extends Pessoa {
	private String sala;
	private String curso;
	private String turma;

	public Dicente(String sala, String curso, String turma, int matricula, String name, String email, String telefone,
			String senha) {
		super(matricula, name, email, telefone, senha);
		this.turma = turma;
		this.sala = sala;
		this.curso = curso;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
