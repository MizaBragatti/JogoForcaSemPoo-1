//Siga a ordem de numeracao para conseguir entender corretamente cada item que esta escrevendo.

/*PAckage é como o endereço do código, ou seja, aonde ele esta guardado. 
Se vocee abrir o explorer e navegar nas pastas, vai ver agora que existem mais pastas como: br, com, bootcamp ...etc
Isso por que a ide cria o conceito de pastas e muda a visualização para pacotes.
*/
package br.com.bootcamp.jogo;

/*
Aqui vemos autilização dos pacotes que estão sendo chamados através da palavra reservada: import. 
Reparem que o endereço dos pacotes são chamados para que essa classe possa encontrar os métodos necessérios.
*/
import java.util.Random;
import java.util.Scanner;

/*
public: modificador de acesso de classes/métodos e atributos 
class: palavra chave para indicar o inicio de uma classe no Java
JogoForca: nome da classe(mesmo nome do arquivo em src/main/java). Lembrando que por convencao da comunidade,
as primeiras letras sao SempreMaiusculas
*/
public class JogoForca {

	/*
	 * método main: responsável por executar os nossso códigos, ele é o unico
	 * método no java que pode executar código.
	 * 
	 */
	private static String dica[];

	public static void main(String[] args) {

		/*
		 * String: tipo da variável palavraChave: nome da variável = : sinal de
		 * atribuição(lembre-se: == é igualdade, = é atribuição)
		 */
		String palavraChave = null;
		int qtdLetras = 0;

		/*
		 * println é o commando utilizado para exibir uma mensagem na tela. print( nao
		 * pula linha no console), println(pula uma linha depois do fim da mensagem)
		 */

		System.out.println("Qual nivel de dificuldade? D(Dificil); N(Normal); F(Facil) --> ");
		/*
		 * 04 Uso da classe scanner: Scanner é um classe responsavél por tratar as
		 * entradas de dados no seu programa. Vamos utiliza-la para cuidar da tecla que
		 * o usuário vai digitar na nossa dificuldade Scanner: nome da classe (Tipo da
		 * variável) in : Nome da variavel = : atribuição new : criando umanova
		 * instancia da classse Scaneer(); System.in: indica o parametro que eu quero
		 * utilizar dessa classe, visto que ela me da diversas possibilidades, eu
		 * preciso especificar.
		 */

		Scanner in = new Scanner(System.in);
		/*
		 * Como ela funciona? atraves do comando in.next().toUpperCase() : in.next() :
		 * responsavel por capturar o que o usuario digitou no teclado toUpperCase():
		 * garante que mesmo o usuário digitando letras maiusculas ou minusculas, nós
		 * sempre vamos transformar em maiuscula, para evitar erros desnecessarios. Tudo
		 * isso atribuido a variavel "dificuldade".
		 */
		String dificuldade = in.next().toUpperCase();

		/*
		 * Utilizado switch/case, vamos conhecer uma aplicacao prática dessa estrutura
		 * condicional: switch: indica que esta iniciando a condicao (dificuldade):
		 * valor que sera utilizado como base comparativa nos "cases" case "D": caso o
		 * usuário digite a letra D, nós vamos realizar o trecho que de código
		 * respectivo e assim por diante. palavra = listaPalavraDificil(); : indica que
		 * estou chamando o metodo listaPalavraDificil e atribuindo o seu retorno a
		 * varaivel palavraChave. break; : indica que assim que ele encontrar a condicao
		 * correta, ele deve sair do switch e ir para o proximo bloco de código
		 */
		switch (dificuldade) {
		case "D":
			palavraChave = listaPalavraDificil();
			break;
		case "N":
			palavraChave = listaPalavraNormal();
			break;
		case "F":
			palavraChave = listaPalavraFacil();
			break;

		// default: caso nenhuma das opcoes acima sejam validas ele automaticamente
		// utiliza o default.
		default:
			palavraChave = "";
			System.out.print("Nenhuma letra válda!!");
			break;
		}

		// Aqui estamos exibindo nossa palavra chave na tela pra saber se nossa logica
		// esta funcionando
//		String listaEmString = "";
		montaDica(palavraChave.length());
//		
//		for (String s : dica) {
//			listaEmString += s;
//		}
		int qtdVidas = 10;
		int qtdTracos = palavraChave.length();
		while (qtdVidas > 0 && qtdTracos > 0) {
			System.out.println("Qual letra voce chuta? --> ");
			String letraDigitada = in.next().toLowerCase();

			String[] listaLetrasCorretas = palavraChave.split("");

			int i = 0;
			qtdLetras = palavraChave.length();
			boolean acertou = false;

			while (i < qtdLetras) {
				if (listaLetrasCorretas[i].equals(letraDigitada)) {
					dica[i] = letraDigitada;
					qtdTracos--;
					acertou = true;
				}
				i++;

			}
			if (!acertou) {
				qtdVidas--;
				System.out.println("Voc� tem "+qtdVidas+" de vidas.");
			}
			
			
			acertou = false;

			String novaDica = "";

			for (String s : dica) {
				novaDica += s;
			}

			System.out.println(novaDica);
			// System.out.println(palavraChave);
			// System.out.println(listaEmString);

		}
		in.close();

	}

	public static String[] montaDica(int qtdLetras) {
		dica = new String[qtdLetras];

		for (int i = 0; i < dica.length; i++) {
			dica[i] = " -- ";
		}

		return dica;
	}

	/*
	 * 01 - Aqui estamos criando um método no Java Esse método é resposavel por
	 * nos retornar uma palavra dificil
	 * 
	 * public static: modificador de acesso String: tipo de retorno de um método
	 * podendo ser qualquer valor do tipo primitivo ou objeto.
	 * listaPalavraDificil(): nome do método, sempre com a primeira letra
	 * minuscula.
	 */
	public static String listaPalavraDificil() {
		/*
		 * Criando uma variável do tipo lista de Strings. String[] : tipo da variável
		 * palavras: nome da variável = : atribuição
		 * {"carambola","jatoba","melancia"} : valor da variável
		 */
		String[] palavras = { "carambola", "jatoba", "melancia" };

		/*
		 * Agora vamos ver algo novo. Random é uma classse do java que nos ajuda a
		 * randomizar as coisas. Vamos precisar dela para randomizar nossa lista de
		 * palavras e sempre retornar uma diferente.
		 * 
		 * Random: nome da classe (Tipo da variável) random: instancia da classe (nome
		 * da variavel) = : atribuição new : indica que desejo criar uma nova
		 * instancia da classe Random(). Random(): nome da classe que desejo instanciar.
		 * 
		 * com isso a variavel random tem acesso a todos os métodos publicos da classe
		 * Random().
		 */
		Random random = new Random();

		/*
		 * return : indica o tipo de retorno que vamos dar para quem chamar esse
		 * método. No nosso caso vamos retornar uma String, caso voce tente retornar um
		 * numero a IDE vai apresentar erro. Falei sobre retorno no comeco desse
		 * método.
		 * 
		 * palavras: variavel da nossa lista [random.nextInt(palavras.length)] : [] :
		 * indica o indice da lista de palavras que eu desejo: 1 - carambola, 2 -
		 * jatoba, 3 - melancia random : variavel de instancia que criamos acima . :
		 * utilizado para poder acessar os métodos da classe Random() nextInt() :
		 * método da classe Random que verifica por quantos voce quer randomizar o
		 * numero. (palavras,length) : no local onde colocariamo o numero de vezes que
		 * gostariamos de randomizar, vamos colocar palavras.length por que? length
		 * indica o tamanho da minha lista de string e só vai randomizar um numero ate
		 * o tamaho da lista, para evitar de tentar acessar uma posicao inexistente na
		 * lista
		 */
		return palavras[random.nextInt(palavras.length)];
	}

	// 02
	public static String listaPalavraNormal() {
		String[] palavras = { "laranja", "melao", "maca" };
		Random random = new Random();
		return palavras[random.nextInt(palavras.length)];
	}

	// 03
	public static String listaPalavraFacil() {
		String[] palavras = { "banana", "uva", "abacate" };
		Random random = new Random();
		return palavras[random.nextInt(palavras.length)];
	}
}
