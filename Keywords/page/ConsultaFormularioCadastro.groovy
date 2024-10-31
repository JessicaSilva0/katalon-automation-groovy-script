package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step
import utils.FormularioCadastroValidacoes


public class ConsultaFormularioCadastro {

	Menu menu = new Menu()

	/**
	 * Mapeamento dos objectos contidos na Consulta de Formularios de Cadastro
	 */
	TestObject MenuPesquisar  			= findTestObject('Page/Formularios/Cadastro/Pesquisar/menu-pesquisar')
	TestObject Pesquisar  			    = findTestObject('Page/Formularios/Cadastro/Pesquisar/btn-Pesquisar')
	TestObject PesquisaPor  			= findTestObject('Page/Formularios/Cadastro/Pesquisar/pesquisaPor')
	TestObject ValidacaoListaExcecao  	= findTestObject('Page/Formularios/Cadastro/Pesquisar/validacaoListaExcecao')
	TestObject AmbitoDaPesquisa         = findTestObject('Page/Formularios/Cadastro/Pesquisar/ambitoDaPesquisa')
	TestObject Entidade                 = findTestObject('Page/Formularios/Cadastro/Pesquisar/entidade')
	TestObject ResultadoDaPesquisa      = findTestObject('Page/Formularios/Cadastro/Pesquisar/primeiroResultadoDaPesquisa')

	/**
	 * Pesquisa Por Pessoa
	 */
	TestObject NomeCompleto  			= findTestObject('Page/Formularios/Cadastro/Pesquisar/nomeCompleto')
	TestObject PrimeiroNome  			= findTestObject('Page/Formularios/Cadastro/Pesquisar/primeiroNome')
	TestObject UltimoNome   			= findTestObject('Page/Formularios/Cadastro/Pesquisar/ultimoNome')
	TestObject TipoId		   			= findTestObject('Page/Formularios/Cadastro/Pesquisar/tipoId')
	TestObject ValorId		   			= findTestObject('Page/Formularios/Cadastro/Pesquisar/valorId')

	/**
	 * Pesquisa Por Pesquisa Por Data de Receção/Origem do Formulário/Estado
	 */
	TestObject OrigemFormulario		   	= findTestObject('Page/Formularios/Cadastro/Pesquisar/origemFormulario')
	TestObject DataRececaoInicio		= findTestObject('Page/Formularios/Cadastro/Pesquisar/dataRececaoInicio')
	TestObject DataRececaoFim			= findTestObject('Page/Formularios/Cadastro/Pesquisar/dataRececaoFim')
	TestObject Estado					= findTestObject('Page/Formularios/Cadastro/Pesquisar/estado')

	/**
	 * Pesquisa Por Morada
	 */
	TestObject ResidenciaHabitual  		= findTestObject('Page/Formularios/Cadastro/Pesquisar/residenciaHabitual')
	TestObject Municipio  				= findTestObject('Page/Formularios/Cadastro/Pesquisar/municipio')
	TestObject ReparticaoFiscal  		= findTestObject('Page/Formularios/Cadastro/Pesquisar/reparticaoFiscal')

	/**
	 * Pesquisa Por Localização de documento
	 */
	TestObject IndicadorDoDocumento     = findTestObject('Page/Formularios/Cadastro/Pesquisar/identificadorDocumento')


	/**
	 * Pesquisa Por Telefone
	 */
	TestObject TipoDeContacto           = findTestObject('Page/Formularios/Cadastro/Pesquisar/tipoContacto')
	TestObject Numero                   = findTestObject('Page/Formularios/Cadastro/Pesquisar/numero')

	/**
	 * Pesquisa Por Email
	 */
	TestObject EnderecoDeCorreioEletronico = findTestObject('Page/Formularios/Cadastro/Pesquisar/endercoCorreioEletronico')

	public void pesquisarFormulario() {
		WebUI.waitForPageLoad(5)
		menu.menu_formulario_Cadastro()
		step.clicarNoBotao(MenuPesquisar)
	}


	public void pesquisarPor(
			String pesquisaPor,
			String tipoId,
			String valorId,
			String documentoLocator,
			String email,
			String residenciaHabitual,
			String municipio,
			String reparticaoFiscal,
			String nomeCompleto,
			String primeiroNome,
			String ultimoNome,
			String origemFormulario,
			String dataRececaoInicio,
			String dataRececaoFim,
			String estadoFormulario,
			String tipoContacto,
			String telefone
	) {
		switch (pesquisaPor) {
			case "Pessoa":
				pesquisaPorPessoa(nomeCompleto, primeiroNome, ultimoNome, tipoId, valorId)
				break

			case "Data de Receção/Origem do Formulário/Estado":
				pesquisaPorDatadeRececaoOrigemdoFormularioEestado(origemFormulario, dataRececaoInicio, dataRececaoFim, estadoFormulario)
				break

			case "Morada":
				pesquisaPorMorada(residenciaHabitual, municipio, reparticaoFiscal)
				break

			case "Document Locator":
				pesquisaPorDocumentLocator(documentoLocator)
				break;

			case "Telefone":
				pesquisaPorTelefone(tipoContacto, telefone)
				break;

			case "Email":
				pesquisaPorEmail(email)
				break;
		}
	}



	public void pesquisaPorPessoa(
			String nomeCompleto,
			String primeiroNome,
			String ultimoNome,
			String tipoId,
			String valorId) {

		selecionarPesquisaPor("Pessoa")

		if(nomeCompleto == "" && primeiroNome =="" && ultimoNome =="" && valorId =="") {
			step.clicarNoBotao(Pesquisar)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrPessoa)
		}

		step.inserirTexto(NomeCompleto, nomeCompleto)
		step.inserirTexto(PrimeiroNome, primeiroNome)
		step.inserirTexto(UltimoNome, ultimoNome)

		if (tipoId) {
			selecionarTipoId(tipoId)
			step.clicarNoBotao(Pesquisar)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrValorId)

			step.inserirTexto(ValorId, valorId)
		}

		step.clicarNoBotao(Pesquisar)
	}

	public void clicarNoResultadoDaPesquisa() {
		step.clicarNoBotao(ResultadoDaPesquisa)
	}

	public void pesquisaPorDatadeRececaoOrigemdoFormularioEestado(
			String origemFormulario,
			String dataRececaoInicio,
			String dataRececaoFim,
			String estado
	) {
		selecionarPesquisaPor("Data de Receção/Origem do Formulário/Estado")

		if(origemFormulario == "" && dataRececaoInicio =="" && estado =="") {
			step.clicarNoBotao(Pesquisar)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDataRececao)
		}

		selecionarOrigemFormulario(origemFormulario)
		step.inserirTexto(DataRececaoInicio, dataRececaoInicio)
		step.inserirTexto(DataRececaoFim, dataRececaoFim)
		selecionarEstadoFormulario(estado)

		step.clicarNoBotao(Pesquisar)
	}


	public void pesquisaPorMorada(
			String residenciaHabitual,
			String municipio,
			String reparticaoFiscal
	) {

		selecionarPesquisaPor("Morada")

		if(residenciaHabitual == "" && municipio =="" && reparticaoFiscal =="") {
			step.clicarNoBotao(Pesquisar)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrMorada)
		}

		step.inserirTexto(ResidenciaHabitual, residenciaHabitual)
		step.selecionarOpcao(Municipio, municipio)

		step.selecionarOpcao(ReparticaoFiscal, reparticaoFiscal)

		step.clicarNoBotao(Pesquisar)
	}

	public void selecionarTipoId(String tipoId) {
		switch(tipoId) {
			case "Bilhete de Identidade":
				step.selecionarOpcao(TipoId, "AID")
				break

			case "Cartão de Refugiado":
				step.selecionarOpcao(TipoId, "REF")
				break

			case "Cartão de Residente":
				step.selecionarOpcao(TipoId, "RES")
				break

			case "Certidão de Nascimento":
				step.selecionarOpcao(TipoId, "BCER")
				break

			case "Passaporte":
				step.selecionarOpcao(TipoId, "PASS")
				break

			case "Outro":
				step.selecionarOpcao(TipoId, "OTHR")
				break

			case "Nº de Registo Comercial":
				step.selecionarOpcao(TipoId, "COM")
				break

			case "Identificação de Cidadão Estrangeiro":
				step.selecionarOpcao(TipoId, "FID")
				break

			case "BI Legado":
				step.selecionarOpcao(TipoId, "LAID")
				break

			case "NIF":
				step.selecionarOpcao(TipoId, "LNIF")
				break
		}
	}

	public void selecionarPesquisaPor(String pesquisaPor) {
		switch(pesquisaPor) {
			case "Pessoa":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ8")
				break

			case "Data de Receção/Origem do Formulário/Estado":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ13")
				break

			case "Morada":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ3")
				break
			case "Document Locator":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ7")
				break
			case "Telefone":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ11")
				break;
			case "Email":
				step.selecionarOpcao(PesquisaPor, "CM-RGFRMQ12")
				break;
		}
	}

	public void selecionarOrigemFormulario(String origem) {
		switch(origem) {
			case "SIGT":
				step.selecionarOpcao(OrigemFormulario, "SIGT")
				break

			case "FrontOffice":
				step.selecionarOpcao(OrigemFormulario, "PORTAL")
				break

			case "Portal do contribuinte":
				step.selecionarOpcao(OrigemFormulario, "ONLINE")
				break

			case "GUE Portal":
				step.selecionarOpcao(OrigemFormulario, "GUE")
				break

			case "Legado":
				step.selecionarOpcao(OrigemFormulario, "LEGACY")
				break
		}
	}

	public void selecionarEstadoFormulario(String estado) {
		switch(estado) {
			case "A Aguardar Informações":
				step.selecionarOpcao(Estado, "WAITING")
				break

			case "Aguardando aprovação - Nível 1":
				step.selecionarOpcao(Estado, "APPRLVL1")
				break

			case "Aguardando aprovação - Nível 2":
				step.selecionarOpcao(Estado, "APPRLVL2")
				break

			case "Cancelado":
				step.selecionarOpcao(Estado, "CANCELED")
				break

			case "Pendente":
				step.selecionarOpcao(Estado, "PENDING")
				break

			case "Pronto para publicar":
				step.selecionarOpcao(Estado, "READYFORPOST")
				break

			case "Publicado":
				step.selecionarOpcao(Estado, "POSTED")
				break

			case "Re-editado":
				step.selecionarOpcao(Estado, "REEDIT")
				break

			case "Substituído":
				step.selecionarOpcao(Estado, "SUBSTITUTED")
				break
		}
	}

	public void pesquisaPorDocumentLocator(String idDocumento) {

		selecionarPesquisaPor("Document Locator")

		if(idDocumento == "") {
			step.clicarNoBotao(Pesquisar)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrLocalizacaoDocumento)
		}

		step.inserirTexto(IndicadorDoDocumento, idDocumento)
		step.clicarNoBotao(Pesquisar)
	}

	public void pesquisaPorEmail(String email) {

		selecionarPesquisaPor("Email")

		step.inserirTexto(EnderecoDeCorreioEletronico, email)
		step.clicarNoBotao(Pesquisar)
	}

	public void pesquisaPorTelefone(String tipoContacto, String telefone) {
		selecionarPesquisaPor("Telefone")

		switch( tipoContacto ) {
			case "":
			case " ":
				step.selecionarOpcao( TipoDeContacto , " ")
				break;
			case "Estrangeiro":
				step.selecionarOpcao( TipoDeContacto , 'FOREIGN')
				break;
			case "Fixo":
				step.selecionarOpcao( TipoDeContacto , 'LANDLINE')
				break;
			case "Telemóvel":
				step.selecionarOpcao( TipoDeContacto , 'MOBILE')
				break;
		}

		step.inserirTexto(Numero, telefone)
		step.clicarNoBotao(Pesquisar)
	}
}
