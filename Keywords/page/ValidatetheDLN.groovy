package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step
/**
 * @author jessica-silva
 * Nome: Validate the DLN Page
 * Esta pagina corresponde a pagina de pesquisa por Nº do DC/TC da Page de Pagamentos
 * Aqui serão definidas as funções e suas interações com os elementos.
 */
public class ValidatetheDLN {
	/**
	 * TestObject: corresponde o mapeamento dos elementos elencados na pasta "Object Repository"
	 */
	TestObject numeroDC 			= findTestObject('Page/Validate the DLN/identificadorDocumento')
	TestObject pesquisarDoc 		= findTestObject('Page/Validate the DLN/btn_pesquisar')


	public void pesquisarNumeroDC() {
		step.colarValornoCampo(numeroDC)
	}

	public void botaoPesquisar() {
		step.clicarNoBotao(pesquisarDoc)
	}

	public void abrirPopup() {
		WebUI.switchToWindowTitle('Validate the DLN')
	}

	public void retornarParaTela(String nome) {
		WebUI.switchToWindowTitle(nome)
	}
}
