package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import steps.CommonSteps as step
/**Nome: Login
 * Esta pagina corresponde a pagina de entrada inicial no sistema e contém todos os elementos da página.
 * Também aqui serão definidas as funções e suas interações com os elementos.
 */
public class Login {
	//TestObject corresponde o mapeamento dos elementos elencados no Object Repository
	TestObject utilizador = findTestObject('Page/Login/utilizador')
	TestObject senha      = findTestObject('Page/Login/senha')
	TestObject btn_Login  = findTestObject('Page/Login/btn_login')
	TestObject msgError   = findTestObject('Page/Login/msg_loginError')
	TestObject homePage   = findTestObject('Page/Principal/frame_main')

	//TestData serão isolados dos testes, utilizados via excel, internal Data, etc.
	TestData testData = TestDataFactory.findTestData('Data Files/login/credenciais')

	public void abrirNavegador() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.baseURL)
	}

	public void inserirCredenciais() {

		for (def i = 1; i <= testData.getRowNumbers(); i++) {
			String username = testData.getValue('username', i)
			String password = testData.getValue('password', i)

			step.inserirTexto(utilizador, username)
			step.inserirTexto(senha, password)

			break;
		}

	}

	public void iniciarSessao() {
		step.clicarNoBotao(btn_Login)
	}


	public void loginError() {
		String username = testData.getValue('username', 2)
		String password = testData.getValue('password', 1)
		step.inserirTexto(utilizador, username)
		step.inserirTexto(senha, password)
	}

	public void mensagemErro() {
		WebUI.verifyElementText(msgError, "Unable to Login")
	}
	
}
