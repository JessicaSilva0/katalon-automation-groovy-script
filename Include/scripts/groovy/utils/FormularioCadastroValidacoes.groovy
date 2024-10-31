package utils

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

import internal.GlobalVariable

public class FormularioCadastroValidacoes {

	/**
	 * Mensagens Obrigatórias da navegação Detalhes de Registo
	 */
	public static final String ObrOrigemRegisto = "Detalhes de Registo: Origem do Registo requerido.";
	public static final String ObrIndicadorNaoResidente = "Indicador de Residente/Não Residente não pode estar vazio.";
	public static final String ObrTipoContribuinteColectivo = "Detalhes de Registo: Tipo de Contribuinte requerido.";
	public static final String ObrTipoContribuinteColectivoInstituicaoPublica = "Instituições Públicas ou Instituições Financeiras nos Grandes Contribuintes não são permitidas em Regime Simplificado de II";
	public static final String ObrMotivosParaRegistoOficioso = "Detalhes de Registo: Motivos para o Registo Oficioso requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Enquadramento em Impostos
	 */

	public static final String condGrupoDeIRT = "Enquadramento em Impostos: Grupo de IRT requerido";
	public static final String obrRegimeDeII = "Enquadramento em Impostos: Regime de II ou Grupo de IRT deve ser selecionado.";


	/**
	 * Mensagens Obrigatórias da navegação Detalhes para Não Residente
	 */
	public static final String ObrInformacaoAdicional = "É obrigatório indicar pelo menos um motivo para o registo de não residente (informação adicional)";


	/**
	 * Mensagens Obrigatórias da navegação Outras Informações e Detalhes para Não Residente
	 */
	public static final String condMotivoOutros = "o motivo Outros deverá ser detalhado.";


	/**
	 * Mensagens Obrigatórias da navegação Outras Informacoes
	 */
	public static final String condIBANprincipal		 = "Outras Informações: Existem mais de um ou nenhum IBAN Principal.";
	public static final String condBanco 			   	 = "Outras Informações: Banco requerido.";
	public static final String condConta 	 		  	 = "Outras Informações: Conta requerido.";
	public static final String condCodigoSwift 	 		 = "Outras Informações: Código Swift requerido.";
	public static final String condTipoVolumeNegocios 	 = "Outras Informações: Tipo requerido.";
	public static final String condVolumeVendas		 	 = "O campo Volume de Vendas deve ser maior que ou igual a zero.";
	public static final String condPrestacaoServico	 	 = "O campo Prestação de Serviços deve ser maior que ou igual a zero.";
	public static final String condPeriodoValores	 	 = "Outras Informações: Período a que se referem a valores requerido.";
	public static final String condValorTotal		 	 = "O campo Total deve ser maior que zero.";
	public static final String condTotalVolumeDeNegocioRegimeIVA   = "Volume de Negócios inferior ou superior ao limiar para ser sujeito passivo de IVA.";

	/**
	 * Mensagens Obrigatórias da navegação Outros Detalhes do Contribuinte Singular
	 */
	public static final String ObrEstadoCivil		 	 = "Outros Detalhes do Contribuinte Singular: Estado Civil requerido.";
	public static final String CondNumIdConjuge		 	 = "Outros Detalhes do Contribuinte Singular: Nº de Identificação do Cônjuge requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Outros Detalhes do Contribuinte Colectivo
	 */
	public static final String ObrTipoResponsabilidade		 				= "Outros Detalhes de Contribuinte Colectivo: Tipo de Responsabilidade requerido.";
	public static final String ObrDataConstituicao		 	 				= "Outros Detalhes de Contribuinte Colectivo: Data da Constituição requerido.";
	public static final String ObrResponsavelInstituicao 	 				= "Outros Detalhes de Contribuinte Colectivo: Responsável pela Instituição requerido.";
	public static final String condTipoResponsabilidadeRepresentanteLegal 	= "Outros Detalhes de Contribuinte Colectivo: Tipo de Responsabilidade do Representante Legal (1) requerido.";
	public static final String condNumeroRepresentanteLegal					= "Outros Detalhes de Contribuinte Colectivo: Número do Representante Legal (1) requerido.";
	public static final String condTipoContactoRepresentanteLegal			= "Outros Detalhes de Contribuinte Colectivo: Tipo de Contacto do Representante Legal (1) requerido.";
	public static final String condCodigoPaisRepresentanteLegal				= "Outros Detalhes de Contribuinte Colectivo: Código do País do Representante Legal (1) requerido.";
	public static final String obrSegmento									= "Tipo de Contribuinte Colectivo: Segmento requerido.";
	public static final String obrFonteReceitas								= "Outros Detalhes de Contribuinte Colectivo: Fonte de Receitas requerido.";
	public static final String obrAutonomia									= "Outros Detalhes de Contribuinte Colectivo: Autonomia requerido.";
	public static final String obrTipoTributacao							= "Tipo de Contribuinte Colectivo: Tipo de Tributação requerido.";




	/**
	 * Mensagens Obrigatórias da navegação Detalhes de Contribuinte Singular
	 */
	public static final String condPrimeiroNome		 	= "Detalhes de Contribuinte Singular: Primeiro Nome requerido.";
	public static final String condUltimoNome		 	= "Detalhes de Contribuinte Singular: Último Nome requerido.";
	public static final String condGenero			 	= "Detalhes de Contribuinte Singular: Gênero requerido.";
	public static final String condDataNascimento	 	= "Detalhes de Contribuinte Singular: Data de Nascimento requerido.";
	public static final String condPais	 			 	= "Detalhes de Contribuinte Singular: País requerido.";
	public static final String condNifPaisNacionalidade	= "Detalhes de Contribuinte Singular: Nif do País de Nacionalidade requerido.";
	public static final String condProvincia		 	= "Detalhes de Contribuinte Singular: Província requerido.";
	public static final String condMunicipio		 	= "Detalhes de Contribuinte Singular: Município requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informação de endereço secundário
	 */
	public static final String condPaisEnderecoSecundario	= "Detalhes de Endereço de Residência: País requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informação Dados Actividade de Outrem
	 */
	public static final String obrEntidadeEmpregadora	= "Dados de Actividade: Entidade empregadora requerido.";
	public static final String obrDataVinculo			= "Dados de Actividade: Data de ínicio do Vínculo requerido.";
	public static final String condNumeroAgente			= "Dados de Actividade: Nº de Agente requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informação Representacao Fiscal
	 */
	public static final String obrRepresentacaoFiscal	= "Representação Fiscal: Nif do Representante Fiscal requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informação de Contacto
	 */
	public static final String obrCodigoPais			= "O código do país deve ser numérico para o campo de contacto.";
	public static final String obrTipoContactoPrincipal	= "Informação de Contacto: Tipo de Contacto Principal requerido.";
	public static final String obrNContacto				= "Informação de Contacto: Nº de Contacto requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Detalhes de Identificacao Contribuinte Singular
	 */
	public static final String obrTipoIdentificacao = "Detalhes de Identificação de Contribuinte Singular: Tipo de Identificação requerido.";
	public static final String obrNumeroDocID		= "Detalhes de Identificação de Contribuinte Singular: Nº do Documento de Identificação requerido.";
	public static final String condDataValidade		= "Detalhes de Identificação de Contribuinte Singular: Data de Validade requerido.";
	public static final String condDataEmissao		= "Detalhes de Identificação de Contribuinte Singular: Data da Emissão requerido.";
	public static final String condDescricao		= "Detalhes de Identificação de Contribuinte Singular: Descrição requerido.";
	public static final String condPaisPassaporte   = "Detalhes de Identificação de Contribuinte Singular: País de Emissão do Passaporte requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informação de endereco
	 */
	public static final String obrProvinciaInformacaoEndereco			= "Informação de endereço: Província requerido.";
	public static final String obrMunicipioInformacaoEndereco			= "Informação de endereço: Município requerido.";
	public static final String obrComunaInformacaoEndereco				= "Informação de endereço: Comuna/Distrito Urbano requerido.";
	public static final String obrBairroInformacaoEndereco				= "Informação de endereço: Bairro requerido.";
	public static final String obrRuaInformacaoEndereco					= "Informação de endereço: Rua, Avenida, Largo requerido.";
	public static final String obrLocalReferenciaInformacaoEndereco		= "Informação de endereço: Local de Referência requerido.";
	public static final String obrReparticaoFiscalInformacaoEndereco	= "Informação de endereço: Repartição Fiscal de Domicílio requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Dados de Actividade
	 */
	public static final String obrDataInicio			= "Dados de Actividade: Data de Início requerido.";
	public static final String obrDesignacaoOuProfissao	= "Dados de Actividade: É necessário preencher um dos seguintes campos: Designação ou Código de Profissão.";
	public static final String obrDesignacaoComercial   = "Dados de Actividade: Designação Comercial requerido.";
	public static final String obrLocalReferencia   	= "Dados de Actividade: Local de Referência requerido.";
	public static final String obrProvincia   			= "Dados de Actividade: Província requerido.";
	public static final String obrMunicipio   			= "Dados de Actividade: Município requerido.";
	public static final String obrComuna   				= "Dados de Actividade: Comuna requerido.";
	public static final String obrBairro   				= "Dados de Actividade: Bairro requerido.";
	public static final String obrResidenciaHabitual   	= "Dados de Actividade: Residência Habitual requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informações de endereço alternativas
	 */
	public static final String obrRuaEnderecoAlternativo			= "Informações de endereço alternativas: Rua, Avenida, Largo requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Informações de IVA
	 */
	public static final String obrSectorInformacoesIVA								= "Informações de IVA: Sector requerido.";
	public static final String obrRealizaImportacoesInformacoesIVA					= "Informações de IVA: Realiza Importações requerido.";
	public static final String obrRealizaExportacoesInformacoesIVA					= "Informações de IVA: Realiza Exportações requerido.";
	public static final String obrTipoRegimeInformacoesIVA							= "Informações de IVA: Tipo de Regime requerido.";
	public static final String obrRegimeInformacoesIVA								= "Informações de IVA: Regime requerido.";
	public static final String obrTipoContabilidadeInformacoesIVA					= "Informações de IVA: Tipo de Contabilidade requerido.";
	public static final String obrOpcaoPelaContabilidadeOrganizadaInformacoesIVA	= "Informações de IVA: Motivo da Contabilidade Organizada requerido.";
	public static final String obrLocalizacaoContabilidadeInformacoesIVA			= "Informações de IVA: Localização da Contabilidade requerido.";
	public static final String obrNifInformacoesIVA									= "Informações de IVA: NIF requerido.";
	public static final String obrTipoContactorPrincipalInformacoesIVA				= "Informações de IVA: Tipo de Contacto Principal requerido.";
	public static final String obrNumeroInformacoesIVA								= "Informações de IVA: Nº de Contacto requerido.";
	public static final String obrCodigoPaisInformacoesIVA							= "Informações de IVA: Código do País requerido.";
	public static final String obrMunicipioInformacoesIVA							= "Informações de IVA: Município (1) requerido.";
	public static final String obrComunaInformacoesIVA								= "Informações de IVA: Comuna/Distrito Urbano (1) requerido.";
	public static final String obrSelecionarRegimeDeExclusao                        = "Informações de IVA: O Regime do IVA não pode ser Geral ou Simplificado para os contribuintes que tenham o regime II como Simplificado.";
	public static final String obrMotivoDeSuspensaoAtividadeIVA                     = "Informações de IVA: Facto que determinou suspensão ou cessação de actividade requerido.";
	
	/**
	 * Mensagens Obrigatórias da navegação Identificação dos Sócios
	 */
	public static final String obrDetalhesDosSocios									= "Identificação dos Sócios: Detalhes do Sócio requerido.";
	public static final String obrPercentagem										= "Identificação dos Sócios: Percentagem requerido.";
	public static final String obrNumerodeIdentificacao								= "Identificação dos Sócios: Nº de Identificação requerido.";

	/**
	 * Mensagens da navegação Detalhes de Identificacao de Contribuinte Colectivo
	 */
	public static final String obrPaisOrigem		  	     = "Detalhes de Identificação de Contribuinte Colectivo: País de Origem requerido.";
	public static final String obrNaturezaLegal		  	     = "Detalhes de Identificação de Contribuinte Colectivo: Natureza Legal requerido.";
	public static final String obrDenominacao		  		 = "Detalhes de Identificação de Contribuinte Colectivo: Denominação requerido.";
	public static final String obrDesignacaoComercialEmpresa = "Detalhes de Identificação de Contribuinte Colectivo: Designação Comercial requerido.";
	public static final String obrDescricaoNaturezaLegal     = "Detalhes de Identificação de Contribuinte Colectivo: Descrição requerido.";
	public static final String condNifPaisOrigem             = "Detalhes de Identificação de Contribuinte Colectivo: Nif  do País de Origem requerido.";

	/**
	 * Mensagens Obrigatórias da navegação Identificação de Agências
	 */

	public static final String obrPorcentagemDeParticipacao = "Identificação de Agências: Porcentagem de Participação requerido.";

	/**
	 * Mensagens Obrigatórias da Consulta de Formulario de Cadastro
	 */

	public static final String obrPessoa = "Neither Person Name nor Id Number filters are provided.";
	public static final String obrValorId 			 = "Both Person ID Type and Person ID Value are required if either one is entered.";
	public static final String obrMorada 			 = "Deve ser especificada, pelo menos, uma Morada, uma Localidade e um Código Postal.";
	public static final String obrDataRececao 		 = "O intervalo de Datas de Receção é obrigatório.";
	public static final String obrLocalizacaoDocumento = "O Número de Localização do Documento é obrigatório.";

	/**
	 * Mensagens de validação do formulário de cadastro
	 */

	public static final String validFormularioVerificadoComExito = "Formulário verificado com êxito.";
}




