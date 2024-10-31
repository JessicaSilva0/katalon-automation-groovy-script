package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject

import steps.CommonSteps as step

/**Nome: Menu Page
 * Esta pagina corresponde a pagina de Menus do sistema.
 * Aqui serão definidas as funções e suas interações com os elementos.
 */
public class Menu {
	/**
	 * TestObject: corresponde o mapeamento dos elementos elencados na pasta "Object Repository"
	 */
	TestObject menu				  		= findTestObject('Page/Menu/btn_menu')

	// Menu Formulários
	TestObject formularios 			    = findTestObject('Page/Menu/Formularios/formularios')
	TestObject formulariosDeLiquidacao  = findTestObject('Page/Menu/Formularios/formularioDeLiquidacao')
	TestObject formulariosDeCadastro    = findTestObject('Page/Menu/Formularios/formularioDeCadastro')
	

	//Menu Pagamentos
	TestObject pagamentos			    = findTestObject('Page/Menu/Pagamentos/pagamentos')
	TestObject efectuarPagamentos		= findTestObject('Page/Menu/Pagamentos/efectuarPagamentos')

	public void menu_formulario_Liquidacao() {
		step.clicarNoBotao(menu)
		step.selecionarMenuItem(formularios)
		step.selecionarMenuItem(formulariosDeLiquidacao)
	}

	public void menu_pagamentos_efectuar() {
		step.clicarNoBotao(menu)
		step.selecionarMenuItem(pagamentos)
		step.selecionarMenuItem(efectuarPagamentos)
	}
	
	public void menu_formulario_Cadastro() {
		step.clicarNoBotao(menu)
		step.selecionarMenuItem(formularios)
		step.selecionarMenuItem(formulariosDeCadastro)
	}
}
