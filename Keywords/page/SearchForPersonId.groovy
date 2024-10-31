package page

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step

/**Nome: Search For Person Id, Accounts and NIF Page
 * Esta pagina corresponde a pagina de pesquisa por NIF
 * Aqui serão definidas as funções e suas interações com os elementos.
 */
public class SearchForPersonId {
	/**
	 * TestObject: corresponde o mapeamento dos elementos elencados na pasta "Object Repository"
	 */
	TestObject nomePessoa 			= findTestObject('Page/Search for Person Id, Accounts and NIF/nomeDaPessoa')
	TestObject tipoDeIdentificacao 	= findTestObject('Page/Search for Person Id, Accounts and NIF/tipoIdentificacao')
	TestObject numeroId 			= findTestObject('Page/Search for Person Id, Accounts and NIF/numIdentificacao')
	TestObject conta 				= findTestObject('Page/Search for Person Id, Accounts and NIF/conta')
	TestObject pesquisar 			= findTestObject('Page/Search for Person Id, Accounts and NIF/btn_pesquisar')
	TestObject selecionar 			= findTestObject('Page/Search for Person Id, Accounts and NIF/selecionar')

	//TestData serão isolados dos testes, utilizados via excel, internal Data, etc.
	TestData testData = TestDataFactory.findTestData('Data Files/SearchForPersonId/tipoId')

	public void abrirPopup() {
		WebUI.switchToWindowTitle('Search for Person Id, Accounts and NIF')
	}

	public void pesquisaPorNomePessoa(String nome) {
		step.clicarNoBotaoEinserirTexto(nomePessoa, nome)
	}

	public void pesquisaPorNumeroId(String texto) {
		step.clicarNoBotaoEinserirTexto(numeroId, texto)
	}

	public void pesquisaPorConta(String numConta) {
		step.clicarNoBotaoEinserirTexto(conta, numConta)
	}

	public void botaoPesquisar() {
		step.clicarNoBotao(pesquisar)
	}

	public void botaoSelecionar() {
		step.clicarNoBotao(selecionar)
	}

	public void fecharPopup() {
		if(WebUI.getWindowTitle() == "360 Degree Search") {
			WebUI.switchToWindowTitle('360 Degree Search')
		} else {
			WebUI.switchToWindowTitle('Pesquisa a 360 Graus')
		}
	}

	public void retornarParaTela(int index) {
		WebUI.switchToWindowIndex(index)
	}


	public void pesquisaPorTipoId(String tipoId) {
		switch(tipoId) {
			case "Bilhete de Identidade":
				step.selecionarOpcao(tipoDeIdentificacao, "AID")
				break;

			case "Certidão de Nascimento":
				step.selecionarOpcao(tipoDeIdentificacao, "BCER")
				break;

			case "NIF":
				step.selecionarOpcao(tipoDeIdentificacao, "LNIF")
				break;
		}
	}

	public void pesquisarPorNIF(String numeroId) {
		abrirPopup()
		pesquisaPorTipoId("NIF")
		pesquisaPorNumeroId(numeroId)
		botaoPesquisar()
		botaoSelecionar()
		retornarParaTela(0)
	}

}
