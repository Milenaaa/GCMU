package poo.project.GCMU;
/**
 * 
 * @author GCMU
 *	Essa classe sera de administra��o no qual o administrador ira autorizar que o discente ou docente peguem materias ou chaves
 */
public class Administrador extends Pessoa{
	private String senha;

	public Administrador(String senha, int matricula, String name, String email, String telefone) {
		super(matricula, name, email, telefone, senha);
		this.senha=senha;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 *   A fun�ao desse m�todo, ser� de efetuar o cadastro do Aluno/Dicente/Docente,
	 *  ele ir� printar na tela que o cadastro fou efetuado com sucesso!
	 * @return
	 */
	public String Autoriza(){
		return "ok, cadastro efetuado";
	}
}
