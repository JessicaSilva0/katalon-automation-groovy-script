package steps

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import page.Home
import page.Login


/**Nome: LoginSteps
 * Esta pagina corresponde os steps utilizados na feature e nos Tests Cases e busca os elementos da pagina de Login (login)
 */
public class LoginSteps {
	Login login = new Login()
	Home  home  = new Home()


	@Given("estou na página de login")
	public void pagina_login() {
		login.abrirNavegador()
	}

	@When("Eu insiro meu nome de usuário e senha")
	public void insiro_dados_corretos() {
		login.inserirCredenciais()
	}

	@And("Eu clico no botão de login")
	public void inicio_sessao() {
		login.iniciarSessao()
	}

	@Then("Devo ver a página Inicial")
	public void carregar_pagina_Inicial() {
		home.paginaInicial()
	}

	@When("Insiro um nome de usuário ou senha incorretos")
	public void insiro_dados_incorretos() {
		login.loginError()
	}

	@Then("Devo ver uma mensagem de erro")
	public void recebo_mensagem_de_erro() {
		login.mensagemErro()
	}

	@Given("realizo login no SIGT")
	public void aceder_SIGT() {
		login.abrirNavegador()
		login.inserirCredenciais()
		login.iniciarSessao()
		home.paginaInicial()
		
	}
}
