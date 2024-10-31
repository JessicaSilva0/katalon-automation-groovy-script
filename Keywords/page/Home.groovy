package page

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import steps.CommonSteps as step

import internal.GlobalVariable
/**@autor: Jessica Silva
 * Nome: Menu Page
 * Esta pagina corresponde a pagina de Menus do sistema.
 * Aqui serão definidas as funções e suas interações com os elementos.
 */
public class Home {
	/**
	 * TestObject: corresponde o mapeamento dos elementos elencados na pasta "Object Repository"
	 */

	TestObject homePage = findTestObject('Page/Principal/frame_main')
	TestObject paginaPrincipal = findTestObject('Page/Home/paginaPrincipal')


	public void paginaInicial() {
		WebUI.waitForPageLoad(5)
		WebUI.waitForElementVisible(homePage, 3)
		WebUI.waitForJQueryLoad(5)
		WebUI.refresh()
	}

	public void clicarEmHome () {
		WebUI.waitForPageLoad(5)
		step.aguardarElementoVisivel(paginaPrincipal)
		step.clicarNoBotao(paginaPrincipal)
	}
}
