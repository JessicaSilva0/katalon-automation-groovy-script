package page

import com.github.javafaker.Faker
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step

/** @autor: Jessica Silva
 * Nome: Formulario de Liquidação Page
 * Esta pagina corresponde a pagina de Formulário de Liquidação Genérica e contém todos os elementos da página.
 * Também aqui serão definidas as funções e suas interações com os elementos.
 */
public class FormularioLiquidacao {
	Menu menu = new Menu()
	SearchForPersonId pesquisa = new SearchForPersonId()

	/**
	 * TestObject corresponde o mapeamento dos elementos elencados no Object Repository
	 */
	TestObject Adicionar              = findTestObject('Page/Formularios/Liquidacao/Adicionar/adicionar')
	TestObject Cancelar               = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_Cancelar')
	TestObject Gravar	              = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_Gravar')
	TestObject GravareContinuar	      = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_GravareContinuar')
	TestObject VerificarFormulario    = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_VerificarFormulario')
	TestObject Validar 			      = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_Validar')
	TestObject Publicar 			  = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_Publicar')
	TestObject ImprimirNL			  = findTestObject('Page/Formularios/Liquidacao/Adicionar/btn_ImprimirNotaLiquidacao')
	TestObject Estado				  = findTestObject('Page/Formularios/Liquidacao/Adicionar/estado')
	TestObject NumDocumento			  = findTestObject('Page/Formularios/Liquidacao/Adicionar/documentLocator')

	//Aba de opções do formulário
	TestObject Excecoes               = findTestObject('Page/Formularios/Liquidacao/Adicionar/tab_Excecoes')
	TestObject Versoes 	              = findTestObject('Page/Formularios/Liquidacao/Adicionar/tab_Versoes')
	TestObject Historico              = findTestObject('Page/Formularios/Liquidacao/Adicionar/tab_Historico')

	//Navegação do Formulário: Detalhes do Contribuinte
	TestObject NumeroFiscal           = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Contribuinte/numeroFiscal')

	//Navegação do Formulário: Detalhes do Imposto
	TestObject categoriaImposto       = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/categoriaImposto')
	TestObject tipoImposto            = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/tipoImposto')
	TestObject tipoCobranca           = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/tipoCobranca')
	TestObject formaLiquidacao        = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/formaLiquidacao')
	TestObject tipoLiquidacao         = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/tipoLiquidacao')
	TestObject frequencia             = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/frequenciaDeclaracao')
	TestObject anoExercicio           = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/anoDeclaracao')
	TestObject periodo                = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Detalhes do Imposto/periodo')


	//Navegação do Formulário: Documento Associado
	TestObject DocumentoAssociado     = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Documento Associado/NavForm')
	TestObject documento			  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Documento Associado/documento')


	//Navegação do Formulário: Origem do Facto Tributário
	TestObject OrigemFactoTributario  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Origem do Facto Tributario/navForm')
	TestObject provincia     		  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Origem do Facto Tributario/provincia')
	TestObject municipio	 		  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Origem do Facto Tributario/municipio')

	//Navegação do Formulário: Montante a Pagar
	TestObject MontanteAPagar	 	  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Montante a Pagar/navForm')
	TestObject valor     			  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Montante a Pagar/valorTributavel')
	TestObject taxa	 				  = findTestObject('Page/Formularios/Liquidacao/Adicionar/nav_Montante a Pagar/taxa')

	//Lista de Exceções
	TestObject msgValidacao	 		  = findTestObject('Page/Formularios/Liquidacao/Adicionar/validacaoListaExececoes')


	//TestData serão isolados dos testes, utilizados via excel, internal Data, etc.
	TestData testData 	              = TestDataFactory.findTestData('Data Files/Formulario_Liquidacao/criarLiquidacao')
	TestData pesquisaPor 	 	      = TestDataFactory.findTestData('Data Files/SearchForPersonId/pesquisaPor')
	TestData tipoCategoria 	 		  = TestDataFactory.findTestData('Data Files/Formulario_Liquidacao/categoriaImposto')
	TestData pesquisaImposto 		  = TestDataFactory.findTestData('Data Files/Formulario_Liquidacao/tipoImposto')
	TestData numeroDeclaracao 		  = TestDataFactory.findTestData('Data Files/Formulario_Liquidacao/declaracoes')


	public void abrirFormulario() {
		menu.menu_formulario_Liquidacao()
	}

	public void adicionarFormulario() {
		step.clicarNoBotao(Adicionar)
	}

	public void verificarFormulario() {
		step.clicarNoBotao(VerificarFormulario)
	}

	public void gravarFormulario() {
		step.clicarNoBotao(Gravar)
	}

	public void gravarEcontinuarFormulario() {
		step.clicarNoBotao(GravareContinuar)
	}

	public void cancelarFormulario() {
		step.clicarNoBotao(Cancelar)
	}

	public void validarFormulario() {
		step.clicarNoBotao(Validar)
	}

	public void publicarFormulario() {
		WebUI.waitForPageLoad(20)
		step.aguardarElementoVisivel(Publicar)
		step.clicarNoBotao(Publicar)
	}

	public void imprimirNotaLiquidacao() {
		WebUI.waitForPageLoad(100)
		WebUI.waitForElementPresent(ImprimirNL, 100)
		step.clicarNoBotao(ImprimirNL)
	}

	public void verificarEstadoFormulario(String status) {
		step.validarEstado(Estado, status)
	}

	public void validarMensagemListaExcecoes(String listaExcecao) {
		step.validarListaExcecao(msgValidacao, listaExcecao)
	}

	public void copiarNumeroDeclaracao() {
		WebUI.waitForPageLoad(100)
		String declaracaoNum = step.copiarValordoCampo(NumDocumento)
	}


	public void preencherDetalhesDoContribuinte(String tipoId) {
		String numeroId  = pesquisaPor.getValue('NIF Actual', 1)

		step.clicarNoBotao(NumeroFiscal)
		pesquisa.abrirPopup()
		pesquisa.pesquisaPorTipoId(tipoId)
		pesquisa.pesquisaPorNumeroId(numeroId)
		pesquisa.botaoPesquisar()
		pesquisa.fecharPopup()
	}

	public void preencherDetalhesDoImposto(
			String categoria,
			String imposto,
			String tipoCobranca,
			String formaLiquidacao,
			String tipoLiquidacao,
			String frequenciaDeclaracao,
			String anoDeclaracao,
			String periodo) {

		selecionarTipoImposto(categoria, imposto)
		selecionarTipoCobranca(tipoCobranca)
		selecionarFormaLiquidacao(formaLiquidacao)
		selecionarTipoLiquidacao(tipoLiquidacao)
		selecionarFrequenciaDeclaracao(frequenciaDeclaracao)
		selecionarAno(anoDeclaracao)
		selecionarPeriodo(periodo)

	}

	public void preencherDocumentoAssociado() {

		step.clicarNoBotao(DocumentoAssociado)

		for (def i = 1; i <= testData.getRowNumbers(); i++) {
			String numeroDocumento = testData.getValue('documentoAssociado', i)
			step.clicarNoBotaoEinserirTexto(documento, numeroDocumento)
			break;
		}
	}

	public void preencherOrigemDoFactoTributario(String nomeProvincia, String nomeMunicipio) {
		step.clicarNoBotao(OrigemFactoTributario)
		selecionarProvincia(nomeProvincia)
		selecionarMunicipio(nomeMunicipio)
	}

	public void preencherMontantePagar() {
		Faker faker = new Faker()
		String valorTrib = faker.commerce().price(100000.00, 999999.99)
		String taxaAplicada = faker.number().randomDigitNotZero()
		step.clicarNoBotao(MontanteAPagar)
		step.clicarNoBotaoEinserirTexto(valor, valorTrib)
		step.clicarNoBotaoEinserirTexto(taxa, taxaAplicada)
	}

	public void selecionarTipoImposto(String categoria, String imposto) {
		switch(categoria) {
			case "A":
				step.selecionarOpcao(categoriaImposto, categoria)
				step.selecionarOpcao(tipoImposto, imposto)
				tipoCategoria.getValue('Categoria', 1)
				pesquisaImposto.getValue('tipoImpostoA', 1)
				break;

			case "B":
				step.selecionarOpcao(categoriaImposto, categoria)
				step.selecionarOpcao(tipoImposto, imposto)
				tipoCategoria.getValue('Categoria', 2)
				pesquisaImposto.getValue('tipoImpostoB', 1)
				break;

			case "C":
				step.selecionarOpcao(categoriaImposto, categoria)
				step.selecionarOpcao(tipoImposto, imposto)
				tipoCategoria.getValue('Categoria', 3)
				pesquisaImposto.getValue('tipoImpostoC', 1)
				break;

			case "D":
				step.selecionarOpcao(categoriaImposto, categoria)
				step.selecionarOpcao(tipoImposto, imposto)
				tipoCategoria.getValue('Categoria', 4)
				pesquisaImposto.getValue('tipoImpostoD', 1)
				break;
		}
	}

	public void selecionarTipoCobranca(String cobranca) {
		switch(cobranca) {
			case "Coerciva":
				step.selecionarOpcao(tipoCobranca, "COE")
				break;

			case "Voluntaria":
				step.selecionarOpcao(tipoCobranca, "VOL")
				break;
		}
	}

	public void selecionarFormaLiquidacao(String formaLiq) {
		switch(formaLiq) {
			case "Autoliquidacao":
				step.selecionarOpcao(formaLiquidacao, "SASS")
				break;

			case "Oficiosa":
				step.selecionarOpcao(formaLiquidacao, "OFFI")
				break;
		}

	}

	public void selecionarTipoLiquidacao(String tipoLiq) {
		switch(tipoLiq) {
			case "Adicional":
				step.selecionarOpcao(tipoLiquidacao, "ADDI")
				break;

			case "Correctiva":
				step.selecionarOpcao(tipoLiquidacao, "CORR")
				break;

			case "Custos":
				step.selecionarOpcao(tipoLiquidacao, "COST")
				break;

			case "Definitiva":
				step.selecionarOpcao(tipoLiquidacao, "DEFI")
				break;

			case "Juros":
				step.selecionarOpcao(tipoLiquidacao, "INTE")
				break;

			case "Multas":
				step.selecionarOpcao(tipoLiquidacao, "FINE")
				break;

			case "Outro":
				step.selecionarOpcao(tipoLiquidacao, "OTHE")
				break;

			case "Por Conta":
				step.selecionarOpcao(tipoLiquidacao, "FORC")
				break;

			case "Prestações":
				step.selecionarOpcao(tipoLiquidacao, "INST")
				break;

			case "Provisória":
				step.selecionarOpcao(tipoLiquidacao, "PROV")
				break;

			case "Retenção na Fonte":
				step.selecionarOpcao(tipoLiquidacao, "WITH")
				break;
		}

	}

	public void selecionarFrequenciaDeclaracao(String frequenciaDeclaracao) {
		switch(frequenciaDeclaracao) {
			case "Mensal":
				step.selecionarOpcao(frequencia, "MON")
				break;

			case "Trimestral":
				step.selecionarOpcao(frequencia, "QRT")
				break;

			case "Semestral":
				step.selecionarOpcao(frequencia, "SEM")
				break;

			case "Anual":
				step.selecionarOpcao(frequencia, "ANO")
				break;

			case "Esporádico":
				step.selecionarOpcao(frequencia, "IRR")
				break;
		}


	}

	public void selecionarAno(String anoDeclaracao) {
		switch(anoDeclaracao) {
			case "2020":
				step.selecionarOpcao(anoExercicio, "2020")
				break;

			case "2021":
				step.selecionarOpcao(anoExercicio, "2021")
				break;

			case "2022":
				step.selecionarOpcao(anoExercicio, "2022")
				break;

			case "2023":
				step.selecionarOpcao(anoExercicio, "2023")
				break;
		}
	}

	public void selecionarPeriodo(String periodoDeclaracao) {
		switch(periodoDeclaracao) {
			case "1Semestre":
				step.selecionarOpcao(periodo, "S1")
				break;

			case "2Semestre":
				step.selecionarOpcao(periodo, "S2")
				break;
		}
	}

	public void selecionarProvincia(String tipoProvincia) {
		switch(tipoProvincia) {
			case "BENGO":
				step.selecionarOpcao(provincia, "BO")
				break;

			case "BENGUELA":
				step.selecionarOpcao(provincia, "BA")
				break;
		}
	}

	public void selecionarMunicipio(String tipoMunicipio) {
		switch(tipoMunicipio) {
			case "AMBRIZ":
				step.selecionarOpcao(municipio, "BO#AMBRIZ")
				break;

			case "BALOMBO":
				step.selecionarOpcao(municipio, "BA#BALOMBO")
				break;
		}
	}
}
