package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step



public class ForeignOnlyCountryCodeSearch {

	/**
	 * TestObject: corresponde o mapeamento dos elementos elencados na pasta "Object Repository"
	 */
	TestObject CodigoPais 			= findTestObject('Page/Foreign only Coutry Code Search/codigoPais')
	TestObject Pais 				= findTestObject('Page/Foreign only Coutry Code Search/pais')
	TestObject Pesquisar			= findTestObject('Page/Foreign only Coutry Code Search/btn_Pesquisar')

	public void abrirPopup() {
		WebUI.switchToWindowTitle('Foreign only Country Code Search')
	}

	public void pesquisaPorCodigoPais(String codigoPais) {
		step.clicarNoBotaoEinserirTexto(CodigoPais, codigoPais)
	}

	public void pesquisaPorPais(String pais) {
		step.clicarNoBotaoEinserirTexto(Pais, pais)
	}

	public void botaoPesquisar() {
		step.clicarNoBotao(Pesquisar)
	}

	public void retornarParaTela(int index) {
		WebUI.switchToWindowIndex(index)
	}

	public void pesquisarPorCodigoPais(String codigoPais) {
		abrirPopup()
		pesquisaPorCodigoPais(codigoPais)
		botaoPesquisar()
		retornarParaTela(0)
	}
}
