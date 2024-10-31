package page

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step

/** @autor: Jessica Silva
 * Nome: Pagamentos Page
 * Esta pagina corresponde a pagina de Pagamentos e contém todos os elementos da página.
 * Também aqui serão definidas as funções e suas interações com os elementos.
 */
public class Pagamentos {
	Menu menu = new Menu()
	SearchForPersonId pesquisa = new SearchForPersonId()
	ValidatetheDLN pesquisarDocumento = new ValidatetheDLN()

	/**
	 * TestObject corresponde o mapeamento dos elementos elencados no Object Repository
	 */
	TestObject NIF              = findTestObject('Page/Pagamentos/efectuarPagamentos/Pagamento/nif')
	TestObject NumeroDC         = findTestObject('Page/Pagamentos/efectuarPagamentos/Itens de Liquidacao/numeroDC')
	TestObject ValorDivida      = findTestObject('Page/Pagamentos/efectuarPagamentos/Itens de Liquidacao/montanteDivida')
	TestObject pesquisaDC       = findTestObject('Page/Pagamentos/efectuarPagamentos/Itens de Liquidacao/pesquisaDC')
	TestObject ValorAPagar      = findTestObject('Page/Pagamentos/efectuarPagamentos/Metodos de Pagamento/montantePagamento')
	TestObject Validar      	= findTestObject('Page/Pagamentos/efectuarPagamentos/btn_Validar')
	TestObject CriarPagamento   = findTestObject('Page/Pagamentos/efectuarPagamentos/btn_CriarPagamento')
	TestObject EstadoPagamento  = findTestObject('Page/Pagamentos/efectuarPagamentos/estadoPagamento')
	TestObject eventoPagamento  = findTestObject('Page/Pagamentos/frame_eventoPagamento')
	TestObject paginaPagamento  = findTestObject('Page/Principal/frame_uiMap')


	//TestData serão isolados dos testes, utilizados via excel, internal Data, etc.
	TestData pesquisaPor 	 	= TestDataFactory.findTestData('Data Files/SearchForPersonId/pesquisaPor')


	public void abrirMenuPagamentos() {
		menu.menu_pagamentos_efectuar()
	}

	public void preencherNIF(String tipoId) {
		step.aguardarPagina(paginaPagamento)

		String numeroId  = pesquisaPor.getValue('NIF Actual', 1)

		step.clicarNoBotao(NIF)
		pesquisa.abrirPopup()
		pesquisa.pesquisaPorTipoId(tipoId)
		pesquisa.pesquisaPorNumeroId(numeroId)
		pesquisa.botaoPesquisar()
		pesquisa.retornarParaTela("Formulário Fiscal")
	}

	public void preencherItensdeLiquidacao() {
		step.selecionarOpcaoIndex(NumeroDC, 2)
	}

	public void preencherMetodoDePagamento() {
		step.copiarValordoCampo(ValorDivida)
		step.colarValornoCampo(ValorAPagar)
	}

	public void validarPagamento() {
		step.clicarNoBotao(Validar)
		step.aguardarPagina(paginaPagamento)
	}

	public void criarPagamento() {
		WebUI.waitForPageLoad(50)
		step.aguardarElementoVisivel(CriarPagamento)
		step.duploCliqueNoBotao(CriarPagamento)
		WebUI.waitForPageLoad(150)
	}

	public void validarEstadoPagamento(String status) {
		step.aguardarPagina(eventoPagamento)
		step.validarEstado(EstadoPagamento, status)
	}

	public void pesquisarDC() {
		step.clicarNoBotao(pesquisaDC)
		pesquisarDocumento.abrirPopup()
		pesquisarDocumento.pesquisarNumeroDC()
		pesquisarDocumento.botaoPesquisar()
		pesquisarDocumento.retornarParaTela("Formulário Fiscal")
	}
}
