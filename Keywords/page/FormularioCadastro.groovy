package page

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static org.junit.Assert.assertTrue

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import steps.CommonSteps as step
import utils.Variaveis
import utils.FormularioCadastroValidacoes


public class FormularioCadastro {

	/**
	 * Variavel de instancia para enviar a referencia do tipo de Regime de IVA escolhido na sessão Informações de IVA
	 */
	String enviarTipoDeRegimeIVA;

	Variaveis campoValidacoes = new Variaveis()
	Menu menu = new Menu()
	SearchForPersonId pesquisa = new SearchForPersonId()
	ForeignOnlyCountryCodeSearch pesquisaPais = new ForeignOnlyCountryCodeSearch()

	/**
	 * TestObject corresponde o mapeamento dos elementos elencados no Object Repository
	 */
	TestObject VerificarFormulario  			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-VerificarFormulario')
	TestObject Adicionar  			              = findTestObject('Page/Formularios/Cadastro/Adicionar/adicionar')
	TestObject Gravar 				   			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-Gravar')
	TestObject Validar 				   			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-Validar')
	TestObject Publicar    			  			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-Publicar')
	TestObject ComprovativoCadastro    			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-ComprovativoCadastro')
	TestObject DeclaracaoModelo6    			  = findTestObject('Page/Formularios/Cadastro/Adicionar/btn-DeclaracaoModelo6')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Detalhes de Registo
	 */
	TestObject OrigemRegisto    					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/origemRegisto')
	TestObject TipoContribuinte 					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/tipoContribuinte')
	TestObject IndicadorNaoResidente  				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/indicadorNaoResidente')
	TestObject TrabalhadorContaPropria 				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/trabalhadorContaPropria')
	TestObject IniciarRegimeIVA		  				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/iniciarRegimeIVA')
	TestObject ValidacaoListaExcecao  				= findTestObject('Page/Formularios/Cadastro/Adicionar/validacaoListaExcecao')
	TestObject NavFormDetalhesRegisto				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/navForm')
	TestObject NavFormDetalhesRegistoAlt				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/navFormModAlt')
	TestObject TrabalhadorContaOutrem 				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/trabalhadorContaOutrem')
	TestObject Pensionista			 				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/pensionista')
	TestObject Simples				 				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/simples')
	TestObject TipoDeContribuinteColectivo			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/tipoDeContribuinteColectivo')
	TestObject MotivosParaRegistoOficioso			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/motivosParaRegistoOficioso')
	TestObject CessarRegimeIVA                      = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Registo/cessarRegimeIVA')
	/**
	 * Mapeamento dos objectos contidos na aba de navegação Enquadramento de Impostos
	 */
	TestObject NavFormEnquadramento	    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Enquadramento em Impostos/navForm')
	TestObject grupoIRT	 	    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Enquadramento em Impostos/grupodeIRT')
	TestObject RegimeDeII	 			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Enquadramento em Impostos/regimeDeII')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Outras Informações
	 */
	TestObject NavFormOutrasInformacoes	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/navForm')
	TestObject numeroIBAN	 	        = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/numeroIBAN')
	TestObject IBANprincipal	 	    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/ibanPrincipal')
	TestObject Banco			 	    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/selecionarBanco')
	TestObject Conta			 	    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/inserirConta')
	TestObject CodigoSwift			 	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/inserirCodigoSwift')
	TestObject TipoVolume				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/tipoVolumeNegocios')
	TestObject VolumeVendas				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/volumeVendas')
	TestObject PrestacaoServico			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/prestacaoServico')
	TestObject PeriodoValores			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outras Informacoes/periodoValores')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Detalhes para Não Residentes
	 */
	TestObject NavFormDetalhesNaoResidente		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/nav_Form')
	TestObject AssalariadoPrestadorServico		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/assalariadoPrestadorServico')
	TestObject DiplomataRepresentacaoConsular	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/diplomataRepresentacaoConsular')
	TestObject InvestidorDirecto				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/investidorDirecto')
	TestObject InvestidorIndirecto				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/investidorIndirecto')
	TestObject MotivoOutros						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/motivoOutros')
	TestObject NumeroIdentificacaoIRT			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/numeroIdentificacaoIRT')
	TestObject NumeroIdentificacaoIVA			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/numeroIdentificacaoIVA')
	TestObject Outros							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/outros')
	TestObject PaisIRT							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/paisIRT')
	TestObject PaisIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/paisIVA')
	TestObject ProprietarioImovel				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/proprietarioImovel')
	TestObject RepresentadoParaEfeitoDeIRT		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/representadoParaEfeitoDeIRT')
	TestObject RepresentadoParaEfeitoDeIVA		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/representadoParaEfeitoDeIVA')
	TestObject Turista							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/turista')
	TestObject RepresentacaoDeNegocio           = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/representacaodeNegocio')
	TestObject PatrimonioAutonomo               = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/patrimonioAutonomo')
	TestObject TipoEstabelecimento              = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes Para Nao Residentes/indicadorDeRepresentacaoFiscal')
	/**
	 * Mapeamento dos objectos contidos na aba de navegação Outros Detalhes do Contribuinte Singular
	 */
	TestObject NavFormOutrosDetalhesContribuinteSingular	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Singular/NavForm')
	TestObject EstadoCivil									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Singular/estadoCivil')
	TestObject NumeroIdentificacaoConjuge					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Singular/NumeroIdentificacaoConjuge')
	TestObject NifRepresentanteLegal						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Singular/NifRepresentanteLegal')
	TestObject GrauInvalidez								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Singular/grauInvalidez')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Outros Detalhes do Contribuinte Colectivo
	 */
	TestObject NavFormOutrosDetalhesContribuinteColectivo		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/outrosDetalhesContribuinteColectivo')
	TestObject Autonomia										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/autonomia')
	TestObject FontesDeReceitas									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/fontesDeReceitas')
	TestObject Segmento											= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/segmento')
	TestObject TipoDeTributacao									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/tipoDeTributacao')
	TestObject CapitalSocial									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/capitalSocial')
	TestObject ContactosResponsavelTipoDeContacto				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/contactosResponsavelTipoDeContacto')
	TestObject DataConstituicao									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/dataConstituicao')
	TestObject DataPublicacaoDiarioRepublica					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/dataPublicacaoDiarioRepublica')
	TestObject EmailDoResponsavel								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/emailDoResponsavel')
	TestObject Estrangeiro										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/estrangeiro')
	TestObject FonteDeReceitas									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/fonteDeReceitas')
	TestObject IconeDePesquisaNIFOutrosResponsaveisOuGerentes	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/iconeDePesquisaNIFOutrosResponsaveisOuGerentes')
	TestObject NumeroDiarioRepublica							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/nDiarioRepublica')
	TestObject NumeroTrabalhadores								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/nTrabalhadores')
	TestObject OutrosDetalhesContribuinteColetctivo				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/outrosDetalhesContribuinteColectivo')
	TestObject Pais												= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/pais')
	TestObject PessoaResponsavelIconePesquisaNIF				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/pessoaResponsavelIconePesquisaNIF')
	TestObject PrivadoNacional									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/privadoNacional')
	TestObject PublicadoDiarioRepublica							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/publicadoDiarioRepublica')
	TestObject Publico											= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/publico')
	TestObject RepresentanteLegalNumero							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/representanteLegalNumero')
	TestObject TipoDeResponsabilidade							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/tipoDeResponsabilidade')
	TestObject RepresentanteLegalTipoDeResponsabilidade			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/representanteLegalTipoDeResponsabilidade')
	TestObject ContactoResponsavelCodigoDoPais					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/contactoResponsavelCodigoDoPais')
	TestObject NumeroContactosDoResponsavel						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/numeroContactosDoResponsavel')
	TestObject LupaContactosDoResponsavelCodigoDoPais			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/lupaContactosDoResponsavelCodigoDoPais')
	TestObject LupaRepresentanteLegalNif						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/lupaRepresentanteLegalNif')
	TestObject LupaRepresentanteLegalCodigoDoPais				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/lupaRepresentanteLegalCodigoDoPais')
	TestObject RepresentanteLegalTipoDeContacto					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/representanteLegalTipoDeContacto')
	TestObject RepresentanteLegalEmail							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/representanteLegalEmail')
	TestObject RemoverNifResponsavel							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Outros Detalhes do Contribuinte Colectivo/removerNifResponsavel')





	/**
	 * Mapeamento dos objectos contidos na aba de navegação Detalhes de Contribuinte Singular
	 */
	TestObject NavFormDetalhesContribuinteSingular		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nav_Form')
	TestObject PrimeiroNome								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/primeiroNome')
	TestObject NomeIntermedio							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nomeIntermedio')
	TestObject UltimoNome								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/ultimoNome')
	TestObject Genero									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/genero')
	TestObject DataNascimento							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/dataNascimento')
	TestObject NacionalidadePais						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nacionalidadePais')
	TestObject NifDoPaisDeNacionalidade					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nifDoPaisDeNacionalidade')
	TestObject NaturalidadePais							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/naturalidadePais')
	TestObject SelecionarProvincia						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/selecionarProvincia')
	TestObject InserirProvincia							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/inserirProvincia')
	TestObject SelecionarMunicipio						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/selecionarMunicipio')
	TestObject InserirMunicipio							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/inserirMunicipio')
	TestObject NomeDoPai								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nomeDoPai')
	TestObject NomeDaMae								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Contribuinte Singular/nomeDaMae')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Informação de endereço secundário
	 */
	TestObject CodigoPostal								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Endereco Secundario/codigoPostal')
	TestObject InformacaoComplementar					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Endereco Secundario/informacaoComplementar')
	TestObject NavFormInformacaoEnderecoSecundario		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Endereco Secundario/nav_Form')
	TestObject PaisEnderecoSecundario					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Endereco Secundario/pais')
	TestObject ResidenciaHabitual						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Endereco Secundario/residenciaHabitual')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Dados da actividade por conta de outrém
	 */
	TestObject NavFormDadosActividadeOutrem				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/navForm')
	TestObject EntidadeEmpregadora						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/entidadeEmpregadora')
	TestObject DataInicioVinculo						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/dataInicioVinculo')
	TestObject Funcao								    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/funcao')
	TestObject AgentePublico						    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/agentePublico')
	TestObject NumeroAgente						    	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados da actividade por conta de outrem/numeroAgente')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Representação Fiscal
	 */
	TestObject NavFormRepresentacaoFiscal				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_ Representacao Fiscal/navForm')
	TestObject IndicadorRepresentacao					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_ Representacao Fiscal/indicadorRepresentante')
	TestObject PesquisaNifRepresentanteFiscal			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_ Representacao Fiscal/pesquisaNifRepresentante')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Identificação de Agências
	 */
	TestObject NavFormIdentificacaoAgencias			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/navForm')
	TestObject DenominacaoDetalhesAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/denominacao')
	TestObject ProvinciaDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/provincia')
	TestObject AutarquiaDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/autarquia')
	TestObject MunicipioDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/municipio')
	TestObject ComunaDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/comuna')
	TestObject LocalidadeDetalhesAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/localidade')
	TestObject BairroDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/bairro')
	TestObject QuarteiraoDetalhesAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/quarteirao')
	TestObject CondominioDetalhesAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/condominio')
	TestObject EdificioDetalhesAgencia				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/edificio')
	TestObject ResidenciaHabitualDetalhesAgencia	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/residenciaHabitual')
	TestObject CasaDetalhesAgencia					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/casa')
	TestObject AndarDetalhesAgencia					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/andar')
	TestObject CodigoPostalDetalhesAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/codigoPostal')
	TestObject LocalDeReferenciaDetalhesAgencia		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/localDeReferencia')
	TestObject NDeTrabalhadoresDaAgencia			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/NDeTrabalhadoresDaAgencia')
	TestObject TipoContacto							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/tipoContacto')
	TestObject NumeroContacto						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/numero')
	TestObject Email								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/email')
	TestObject LupaPesquisa							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/lupaPesquisa')
	TestObject PesquisarNifDaEmpresaMae				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/btnPesquisarNifDaEmpresaMae')
	TestObject RemoverNifDaEmpresaMae				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/btnRemoverNifDaEmpresaMae')
	TestObject PorcentagemDeParticipacao			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/porcentagemDeParticipacao')
	TestObject ContaIdentificacaoAgencias	 	    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao de Agencias/conta')



	/**
	 * Mapeamento dos objectos contidos na aba de navegação Informação de Contacto
	 */
	TestObject NavFormInformacaoContacto				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/navForm')
	TestObject BotaoCodigoPais							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/btn_CodigoPais')
	TestObject BotaoCodigoPaisPrincipal					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/btn_CodigoPaisPrincipal')
	TestObject EmailInformacaoContacto					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/email')
	TestObject NumeroContactoInformacaoContacto			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/nContacto')
	TestObject NumeroInformacaoContacto					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/numero')
	TestObject TipoContactoInformacaoContacto			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/tipoContacto')
	TestObject TipoContactoPrincipalInformacaoContacto	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/tipoContactoPrincipal')
	TestObject EnderecoWeb								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de Contacto/enderecoWeb')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Detalhes de Identificação de Contribuinte Singular
	 */
	TestObject NavFormDetalhesIdentificacaoContribuinteSingular	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/navForm')
	TestObject TipoIdentificacao								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/tipoIdentificacao')
	TestObject NumeroDocumentoIdentificacao						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/numeroDocumentoIdentificacao')
	TestObject DataEmissao										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/dataEmissao')
	TestObject DataValidade										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/dataValidade')
	TestObject PaisEmissaoPassaporte							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/PaisEmissaoPassaporte')
	TestObject Descricao										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/descricao')
	TestObject AnexarDocumento									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/anexarDocumento')
	TestObject ObterDados										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Singular/obterDados')
	/**
	 * Mapeamento dos objectos contidos na aba de navegação Documentos Anexados
	 */
	TestObject navFormDocumentosAnexados			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Documentos Anexados/navForm')
	TestObject Apagar					   		    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Documentos Anexados/btn_Apagar')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Principal
	 */
	TestObject NavFormPrincipal    			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Principal/navForm')
	TestObject NavFormPrincipalAlteracao    	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Principal/navFormAlterar')
	TestObject Estado    					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Principal/estado')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Informação de endereço
	 */
	TestObject NavFormInformacaoEndereco    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/navForm')
	TestObject AndarInformacaoEndereco    			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/andar')
	TestObject AutarquiaInformacaoEndereco    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/autarquia')
	TestObject BairroInformacaoEndereco    			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/bairro')
	TestObject CasaInformacaoEndereco    			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/casa')
	TestObject CodigoPostalInformacaoEndereco    	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/codigoPostal')
	TestObject ComunaInformacaoEndereco    			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/comuna')
	TestObject CondominioInformacaoEndereco    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/condominio')
	TestObject EdificioInformacaoEndereco    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/edificio')
	TestObject LocalidadeInformacaoEndereco    		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/localidade')
	TestObject LocalReferenciaInformacaoEndereco    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/localReferencia')
	TestObject MunicipioInformacaoEndereco   		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/municipio')
	TestObject ObservacoesInformacaoEndereco   		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/observacoes')
	TestObject ProvinciaInformacaoEndereco   		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/provincia')
	TestObject QuarteiraoInformacaoEndereco   		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/quarteirao')
	TestObject ReparticaoFiscalInformacaoEndereco   = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/raparticaoFiscal')
	TestObject RuaAvenidaLargoInformacaoEndereco   	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacao de endereco/ruaAvenidaLargo')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Informações de endereço alternativos
	 */
	TestObject NavFormInformacaoEnderecoAlternativo		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/navForm')
	TestObject AndarEnderecoAlternativo					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/andar')
	TestObject AutarquiaEnderecoAlternativo				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/autarquia')
	TestObject CasaEnderecoAlternativo					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/casa')
	TestObject CodigoPostalEnderecoAlternativo			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/codigoPostal')
	TestObject CondominioEnderecoAlternativo			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/condominio')
	TestObject EdificioEnderecoAlternativo				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/edificio')
	TestObject InformacaoComplemenarEnderecoAlternativo	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/informacaoComplemenar')
	TestObject LocalidadeEnderecoAlternativo			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/localidade')
	TestObject PaisEnderecoAlternativo					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/pais')
	TestObject QuarteiraoEnderecoAlternativo			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/quarteirao')
	TestObject RuaEnderecoAlternativo					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de enderecos alternativos/rua')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Dados de Actividade
	 */
	TestObject NavFormDadosActividade	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/navForm')
	TestObject DesignacaoComercial		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/designacaoComercial')
	TestObject ActividadePrincipal		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/actividadePrincipal')
	TestObject DataInicio				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/dataInicio')
	TestObject CodigoProfissao			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/codigoProfissao')
	TestObject ExerceProfissao			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/exerceProfissao')
	TestObject Designacao				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/designacao')
	TestObject NumeroAlvara				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/numeroAlvara')
	TestObject ActividadeCessada		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/actividadeCessada')
	TestObject ProvinciaActividade		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/provincia')
	TestObject MunicipioActividade		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/municipio')
	TestObject ComunaActividade			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/comuna')
	TestObject BairroActividade			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/bairro')
	TestObject ResidenciaHabitualActividade			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/residenciaHabitual')
	TestObject LocalReferenciaActividade			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Dados de Actividade/localReferencia')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Informações de IVA
	 */
	TestObject NavFormInformacoesDeIVA								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/navForm')
	TestObject ComDireitoADeducaoInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/comDireitoADeducao')
	TestObject SemDireitoADeducaoInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/semDireitoADeducao')
	TestObject OperacoesMistasInformacoesDeIVA						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/operacoesMistas')
	TestObject ObrigadoCativarIVAInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/obrigadoCativarIVA')
	TestObject SectorInformacoesDeIVA								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/sector')
	TestObject RealizaImportacoesInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/realizaImportacoes')
	TestObject RealizaExportacoesInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/realizaExportacoes')
	TestObject RegimeInformacoesDeIVA								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/regime')
	TestObject TipoRenunciaInformacoesDeIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/tipoRenuncia')
	TestObject TipoRegimeInformacoesDeIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/tipoRegime')
	TestObject TipoContabilidadeInformacoesDeIVA					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/tipoContabilidade')
	TestObject OpcaoPelaContabilidadeOrganizadaInformacoesDeIVA		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/opcaoPelaContabilidadeOrganizada')
	TestObject LocalizacaoDaContabilidadeInformacoesDeIVA			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/localizacaoDaContabilidade')
	TestObject ConferePlenosPoderesDeclarativosAoContabilistaInformacoesDeIVA	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/conferePlenosPoderesDeclarativosAoContabilista')
	TestObject NifInformacoesDeIVA									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/nif')
	TestObject TipoContactoPrincipalInformacoesDeIVA				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/tipoContactoPrincipal')
	TestObject NumeroInformacoesDeIVA								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/numero')
	TestObject NumeroContabilistaOPCAInformacoesDeIVA				= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/numeroContabilistaOPCA')
	TestObject EnderecoCorreioElectronicoInformacoesDeIVA			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/enderecoCorreioElectronico')
	TestObject ProvinciaInformacoesDeIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/provincia')
	TestObject AutarquiaInformacoesDeIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/autarquia')
	TestObject MunicipioInformacoesDeIVA							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/municipio')
	TestObject ComunaInformacoesDeIVA								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/comuna')
	TestObject numeroEstabelecimentoComercialInformacoesDeIVA			= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/nEstabelecimentoComercial')
	TestObject MotivoSuspencaoAtividadeIVA                  		= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/motivoSuspencaoAtividadeIVA')
	TestObject NifSuspensaoActividadeIVA                  		    = findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Informacoes de IVA/nifSuspensaoActividadeIVA')

	/**
	 * Mapeamento dos objectos contidos na aba de navegação Identificação dos Sócios
	 */

	TestObject NavFormIdentificacaoDosSocios						= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao dos Socios/navForm')
	TestObject PesquisaNIFIdentificacaoDosSocios					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao dos Socios/pesquisaNIF')
	TestObject PercentagemIdentificacaoDosSocios					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao dos Socios/percentagem')
	TestObject AcrescentarIdentificacaoDosSocios					= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao dos Socios/acrescentar')
	TestObject ApagarIdentificacaoDosSocios							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Identificacao dos Socios/apagar')


	/**
	 * Mapeamento dos objectos contidos na aba de navegação Detalhes de Identificacao do Contribuinte Colectivo
	 */

	TestObject NavFormDetalhesIdentificacaoContribuinteColectivo	= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/navForm')
	TestObject PaisOrigem											= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/paisOrigem')
	TestObject NifPaisOrigem										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/nifPaisOrigem')
	TestObject NumeroRegistoComercial								= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/numeroRegistoComercial')
	TestObject Denominacao											= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/denominacao')
	TestObject DesignacaoComercialEmpresa							= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/designacaoComercial')
	TestObject NaturezaLegal										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/naturezaLegal')
	TestObject BeneficiarioEfectivo									= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/beneficiarioEfectivo')
	TestObject IndicadorFilial										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/indicadorFilial')
	TestObject NifEmpresaMae										= findTestObject('Page/Formularios/Cadastro/Adicionar/nav_Detalhes de Identificacao de Contribuinte Colectivo/nifEmpresaMae')

	/**
	 * Mapeamento dos objectos contidos na barra lateral Contexto Atual
	 */
	TestObject ExpandirContextoAtual						= findTestObject('Page/Formularios/Cadastro/expandirContextoAtual')
	TestObject ItemMenuAlterarFormularioDeCadastro			= findTestObject('Page/Formularios/Cadastro/menuAlterarFormularioDeCadastro')
	TestObject MenuContextoDePessoa							= findTestObject('Page/Formularios/Cadastro/menuContextoDePessoa')

	/**
	 * Mapeamento dos objectos contidos na tela Formulário de Cadastro
	 */
	TestObject InformacaoDoFormulario						= findTestObject('Page/Formularios/Cadastro/informacaoDoFormulario')



	public void abrirFormulario() {
		menu.menu_formulario_Cadastro()
	}

	public void acederMenuAlterarFormularioDeCadastro() {
		step.clicarNoBotao(MenuContextoDePessoa)
		step.clicarNoBotao(ItemMenuAlterarFormularioDeCadastro)
	}

	public void adicionarFormulario() {
		step.clicarNoBotao(Adicionar)
	}

	public void verificarFormulario() {
		step.clicarNoBotao(VerificarFormulario)
	}

	public void preencherDetalhesDoRegisto(
	String contribuinte,
	String tipoContribuinte,
	String origem,
	String indicadorNaoResidente,
	String motivosParaRegistoOficioso,
	boolean iniciarRegimeIva = true) {

		step.clicarNoBotao(NavFormDetalhesRegisto)

		selecionarOrigemRegisto(origem)
		if (origem == "Vazio") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrOrigemRegisto)
			selecionarOrigemRegisto("Normal")
		}

		if (origem == "Oficiosa") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrMotivosParaRegistoOficioso)
			selecionarMotivoParaRegistoOficioso(motivosParaRegistoOficioso)
		}

		selecionarTipoContribuinte(contribuinte)
		if(contribuinte == "COLECTIVO") {
			selecionarTipoDeContribuinteColectivo(tipoContribuinte)
			if(iniciarRegimeIva) {
				iniciarRegimeIVA()
			}
		}
		if (contribuinte == "COLECTIVO" && tipoContribuinte == "") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrTipoContribuinteColectivo)
		}

		selecionarIndicadorNaoResidente(indicadorNaoResidente)
	}

	public void selecionarMotivoParaRegistoOficioso(String motivosParaRegistoOficioso) {
		switch(motivosParaRegistoOficioso) {
			case "Auditoria interna do processo de registo do contribuinte":
			step.selecionarOpcao(MotivosParaRegistoOficioso, "INTA")
			break;
			case "Informação recebida de entidade externa":
			step.selecionarOpcao(MotivosParaRegistoOficioso, "INEX")
			break;
			case "Inspeccionar":
			step.selecionarOpcao(MotivosParaRegistoOficioso, "INSP")
			break;
			case "Outro":
			step.selecionarOpcao(MotivosParaRegistoOficioso, "OTHE")
			break;
			case "" || " ":
			step.selecionarOpcao(MotivosParaRegistoOficioso, " ")
			break;
		}
	}

	public void validarNavegacaoDetalhesDoRegisto() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrIndicadorNaoResidente)
	}

	public void selecionarTipoDeEstabelecimento(String estabelecimento) {
		switch(estabelecimento) {
			case "Com Estabelecimento Estável":
			step.selecionarOpcao(TipoEstabelecimento, "COM")
			break;
			case "Sem Estabelecimento Estável":
			step.selecionarOpcao(TipoEstabelecimento, "SEM")
			break;
		}
	}

	public void selecionarOrigemRegisto(String origem) {
		switch(origem) {
			case "Normal":
			step.selecionarOpcao(OrigemRegisto, "NRM")
			break;

			case "Oficiosa":
			step.selecionarOpcao(OrigemRegisto, "OFF")
			break;

			case "Vazio":
			step.selecionarOpcao(OrigemRegisto, " ")
			break;
		}
	}
	public void selecionarIndicadorNaoResidente(String indicador) {
		switch(indicador) {
			case "Não Residente":
			step.selecionarOpcao(IndicadorNaoResidente, "NRES")
			break;

			case "Residente":
			step.selecionarOpcao(IndicadorNaoResidente, "RESD")
			break;

			case "Vazio":
			step.selecionarOpcao(IndicadorNaoResidente, " ")
			break;
		}
	}

	public void selecionarTipoContribuinte(String contribuinte) {
		switch(contribuinte) {
			case "COLECTIVO":
			step.selecionarOpcao(TipoContribuinte, "COLLECTIVE")
			break;

			case "SINGULAR":
			step.selecionarOpcao(TipoContribuinte, "SINGULAR")
			break;
		}
	}

	public void selecionarTipoDeTrabalhadorPorContaPropria() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(TrabalhadorContaPropria)
	}

	public void selecionarTipoDeTrabalhadorPorContaDeOutrem() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(TrabalhadorContaOutrem)
	}

	public void selecionarTipoDeContribuintePensionista() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(Pensionista)
	}

	public void selecionarTipoDeContribuinteSimples() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(Simples)
	}

	public void selecionarRegimeII(String regimeII) {
		switch(regimeII) {
			case "Regime Geral":
			step.selecionarOpcao(RegimeDeII, "GNAD")
			break;

			case "Regime Geral (Sector Financeiro)":
			step.selecionarOpcao(RegimeDeII, "GRFS")
			break;

			case "Regime Simplificado":
			step.selecionarOpcao(RegimeDeII, "SIMP")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(RegimeDeII, " ")
			break;
		}
	}

	public void selecionarGrupoDeIRT(String grupoDeIRT) {
		switch(grupoDeIRT) {
			case "A":
			step.selecionarOpcao(grupoIRT, "A")
			break;

			case "B":
			step.selecionarOpcao(grupoIRT, "B")
			break;

			case "C":
			step.selecionarOpcao(grupoIRT, "C")
			break;

			case "Vazio":
			step.selecionarOpcao(grupoIRT, " ")
			break;
		}
	}

	public void preencherEnquadramentoEmImpostos(
	String contribuinte,
	String regimeII,
	String grupoDeIRT) {

		step.clicarNoBotao(NavFormEnquadramento)

		if(contribuinte.equals("SINGULAR")) {
			validarNavegacaoEnquadramentoImpostos()
		}

		if (contribuinte.equals("COLECTIVO")) {
			validarRegimeIIEnquadramentoImpostos()
			selecionarRegimeII(regimeII)
		}
		selecionarGrupoDeIRT(grupoDeIRT)
	}

	public void validarRegimeIIEnquadramentoImpostos() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRegimeDeII)
	}

	public void validarNavegacaoEnquadramentoImpostos() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condGrupoDeIRT)
	}

	public void preencherOutrasInformacoesIBAN(
	boolean possuiNumeroIBAN = false,
	String IBAN,
	String codigoBanco,
	String numeroConta,
	String codigoSwift) {
		step.clicarNoBotao(NavFormOutrasInformacoes)
		if(possuiNumeroIBAN == true) {
			step.inserirTexto(numeroIBAN, IBAN)
			validarNavegacaoIBANOutrasInformacoes()
		}else {
			step.inserirTexto(numeroIBAN, IBAN)
			step.selecionarCheckbox(IBANprincipal)
			step.selecionarOpcao(Banco, codigoBanco)
			step.inserirTexto(Conta, numeroConta)
			step.inserirTexto(CodigoSwift, codigoSwift)
		}
	}

	public void preencherOutrasInformacoesVolumeDeNegocios(
	boolean isTrabalhadorContaPropria = false,
	String tipo,
	String volumeVendas,
	String prestacaoServico,
	String periodoValores) {

		if(isTrabalhadorContaPropria == true) {
			selecionarTipoDeTrabalhadorPorContaPropria()
		}

		step.clicarNoBotao(NavFormOutrasInformacoes)
		validarNavegacaoVolumeDeNegociosOutrasInformacoes()
		selecionarTipoVolumeNegocios(tipo)
		step.inserirTexto(VolumeVendas, volumeVendas)
		step.inserirTexto(PrestacaoServico, prestacaoServico)
		selecionarPeriodoVolumeNegocios(periodoValores)

		if(isTrabalhadorContaPropria == true) {
			validarRegraVolumeDeNegocioRegimeSimplificado(isTrabalhadorContaPropria, enviarTipoDeRegimeIVA, tipo, volumeVendas.toDouble(), prestacaoServico.toDouble(), periodoValores)
		}else {
			step.clicarNoBotao(VerificarFormulario)
		}
	}

	public void selecionarTipoVolumeNegocios(String tipo) {
		switch(tipo) {
			case "Declarativo":
			step.selecionarOpcao(TipoVolume, "DEC")
			break;

			case "Estimativa":
			step.selecionarOpcao(TipoVolume, "EST")
			break;

			case "Vazio":
			step.selecionarOpcao(TipoVolume, " ")
			break;
		}
	}

	public void selecionarPeriodoVolumeNegocios(String periodo) {
		switch(periodo) {
			case "Anual":
			step.selecionarOpcao(PeriodoValores, "ANN")
			break;

			case "Mensal":
			step.selecionarOpcao(PeriodoValores, "MON")
			break;

			case "Semestral":
			step.selecionarOpcao(PeriodoValores, "SEM")
			break;

			case "Trimestral":
			step.selecionarOpcao(PeriodoValores, "TRI")
			break;

			case "Vazio":
			step.selecionarOpcao(PeriodoValores, " ")
			break;
		}
	}



	public void validarNavegacaoIBANOutrasInformacoes() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condIBANprincipal)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condBanco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condConta)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condCodigoSwift)
	}

	public void validarNavegacaoVolumeDeNegociosOutrasInformacoes() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTipoVolumeNegocios)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condVolumeVendas)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPrestacaoServico)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPeriodoValores)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condValorTotal)
	}

	public void preencherDetalhesParaNaoResidentes(
	String contribuinte,
	String tipoEstabelecimento,
	String informacaoAdicional,
	String motivoOutros) {

		step.clicarNoBotao(NavFormDetalhesNaoResidente)

		if(contribuinte == "COLECTIVO") {
			selecionarTipoDeEstabelecimento(tipoEstabelecimento)
		}
		if(contribuinte == "COLECTIVO" && tipoEstabelecimento == "Com Estabelecimento Estável" ) {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrInformacaoAdicional)
		}

		switch(informacaoAdicional) {
			case "Proprietario Imovel":
			selecionarProprietarioImovelDetalhesParaNaoResidentes()
			break

			case "Investidor Directo":
			selecionarInvestidorDirectoDetalhesParaNaoResidentes()
			break

			case "Investidor Indirecto":
			selecionarInvestidorIndirectoDetalhesParaNaoResidentes()
			break

			case "Assalariado Prestador de Servico":
			selecionarAssalariadoPrestadorServicoDetalhesParaNaoResidentes()
			break

			case "Turista":
			selecionarTuristaDetalhesParaNaoResidentes()
			break

			case "Diplomata Representacao Consular":
			selecionarDiplomataRepresentacaoConsularDetalhesParaNaoResidentes()
			break

			case "Representação de Negócio":
			selecionarRepresentacaoDeNegocioDetalhesParaNaoResidentes()
			break

			case "Património Autónomo":
			selecionarPatrimonioAutonomoDetalhesParaNaoResidentes()
			break

			case "Outros":
			selecionarOutrosDetalhesParaNaoResidentes()
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condMotivoOutros)
			step.inserirTexto(MotivoOutros, motivoOutros)
			break

			case "Todos":
			selecionarProprietarioImovelDetalhesParaNaoResidentes()
			selecionarInvestidorDirectoDetalhesParaNaoResidentes()
			selecionarInvestidorIndirectoDetalhesParaNaoResidentes()
			selecionarAssalariadoPrestadorServicoDetalhesParaNaoResidentes()
			selecionarTuristaDetalhesParaNaoResidentes()
			selecionarDiplomataRepresentacaoConsularDetalhesParaNaoResidentes()
			break
		}
	}

	public void validarNavegacaoDetalhesParaNaoResidentes() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condMotivoOutros)
	}

	public void selecionarAssalariadoPrestadorServicoDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(AssalariadoPrestadorServico)
	}

	public void selecionarDiplomataRepresentacaoConsularDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(DiplomataRepresentacaoConsular)
	}

	public void selecionarRepresentacaoDeNegocioDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(RepresentacaoDeNegocio)
	}

	public void selecionarPatrimonioAutonomoDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(PatrimonioAutonomo)
	}
	public void selecionarInvestidorDirectoDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(InvestidorDirecto)
	}

	public void selecionarInvestidorIndirectoDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(InvestidorIndirecto)
	}

	public void selecionarProprietarioImovelDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(ProprietarioImovel)
	}

	public void selecionarTuristaDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(Turista)
	}

	public void selecionarOutrosDetalhesParaNaoResidentes() {
		step.selecionarCheckbox(Outros)
	}

	public void selecionarEstadoCivil(String estadoCivil) {
		switch(estadoCivil) {
			case "Casado":
			step.selecionarOpcao(EstadoCivil, "MAR")
			break;

			case "Solteiro":
			step.selecionarOpcao(EstadoCivil, "SIN")
			break;

			case "União de Facto":
			step.selecionarOpcao(EstadoCivil, "LFP")
			break;

			case "Viúvo":
			step.selecionarOpcao(EstadoCivil, "WID")
			break;

			case "Vazio":
			step.selecionarOpcao(EstadoCivil, " ")
			break;
		}
	}

	public void preencherOutrosDetalhesdoContribuinteSingular(
	String estadoCivil,
	String numeroIdConjuge
	) {
		step.clicarNoBotao(NavFormOutrosDetalhesContribuinteSingular)
		selecionarEstadoCivil(estadoCivil)
		if (estadoCivil == "Vazio") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrEstadoCivil)
		}
		else if(estadoCivil == "Casado" || estadoCivil == "União de Facto") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.CondNumIdConjuge)
		}
	}

	public void preencherOutrosDetalhesDoContribuinteColectivo(
	String tipoContribuinte,
	String publicadoDiarioRepublica,
	String numeroDiarioRepublica,
	String dataPublicacaoDiarioRepublica,
	String dataConstituicao,
	String capitalSocial,
	String privadoNacional,
	String publico,
	String estrangeiro,
	String pais,
	String numeroTrabalhadores,
	String numeroDeIdentificacao,
	String tipoResponsabilidade,
	String contactosResponsavelTipoDeContacto,
	String contactoResponsavelCodigoDoPais,
	String numeroContactosDoResponsavel,
	String nifOutrosResponsaveisOuGerentes,
	String emailDoResponsavel,
	String representanteLegalNif,
	String representanteLegalTipoDeResponsabilidade,
	String representanteLegalTipoDeContacto,
	String representanteLegalCodigoDoPais,
	String representanteLegalNumero,
	String representanteLegalEmail,
	String segmento,
	String fonteDeReceitas,
	String autonomia,
	String tipoDeTributacao

	) {

		step.clicarNoBotao(NavFormOutrosDetalhesContribuinteColectivo)
		if (dataConstituicao == "") {
			validarNavegacaoOutrosDetalhesContribuinteColectivoDataConstituicao()
		}

		if (numeroDeIdentificacao == "") {
			validarNavegacaoOutrosDetalhesContribuinteColectivoResponsavelInstituicao()
		}


		step.inserirTexto(PublicadoDiarioRepublica, publicadoDiarioRepublica)
		step.inserirTexto(NumeroDiarioRepublica, numeroDiarioRepublica)
		step.inserirTexto(DataPublicacaoDiarioRepublica, dataPublicacaoDiarioRepublica)
		step.inserirTexto(DataConstituicao, dataConstituicao)
		step.inserirTexto(CapitalSocial, capitalSocial)
		step.inserirTexto(PrivadoNacional, privadoNacional)
		step.inserirTexto(Publico, publico)
		step.inserirTexto(Estrangeiro, estrangeiro)
		step.selecionarOpcao(Pais, pais)
		step.inserirTexto(NumeroTrabalhadores, numeroTrabalhadores)
		step.clicarNoBotao(PessoaResponsavelIconePesquisaNIF)
		pesquisa.pesquisarPorNIF(numeroDeIdentificacao)
		selecionarTipoContacto(ContactosResponsavelTipoDeContacto, contactosResponsavelTipoDeContacto)
		step.inserirTexto(NumeroContactosDoResponsavel, numeroContactosDoResponsavel)
		step.inserirTexto(EmailDoResponsavel, emailDoResponsavel)
		step.clicarNoBotao(IconeDePesquisaNIFOutrosResponsaveisOuGerentes)
		pesquisa.pesquisarPorNIF(nifOutrosResponsaveisOuGerentes)
		step.clicarNoBotao(LupaRepresentanteLegalNif)
		pesquisa.pesquisarPorNIF(representanteLegalNif)
		selecionarTipoResponsabilidade(RepresentanteLegalTipoDeResponsabilidade, representanteLegalTipoDeResponsabilidade)
		selecionarTipoContacto(RepresentanteLegalTipoDeContacto, representanteLegalTipoDeContacto)
		step.inserirTexto(RepresentanteLegalNumero, representanteLegalNumero)
		step.inserirTexto(RepresentanteLegalEmail, representanteLegalEmail)

		if (numeroDeIdentificacao !="" && tipoResponsabilidade == "" ) {
			validarNavegacaoOutrosDetalhesContribuinteColectivoTipoResponsabilidade()
		}
		selecionarTipoResponsabilidade(TipoDeResponsabilidade, tipoResponsabilidade)

		if (representanteLegalNif != "") {
			validarNavegacaoOutrosDetalhesContribuinteColectivoRepresentanteLegal()
		}

		if (representanteLegalTipoDeContacto == "Estrangeiro") {
			validarNavegacaoOutrosDetalhesContribuinteColectivoTipoRepresentanteLegalCodigoPais()
			step.clicarNoBotao(LupaRepresentanteLegalCodigoDoPais)
			pesquisaPais.pesquisarPorCodigoPais(representanteLegalCodigoDoPais)
		}

		if (tipoContribuinte == "ASSOCIAÇÃO") {
			selecionarSegmentoAssociacao(segmento)

			if (segmento == "") {
				validarNavegacaoOutrosDetalhesContribuinteColectivoAssociacao()
			}
		}

		if (tipoContribuinte == "INSTITUIÇÃO PÚBLICA") {
			selecionarFonteDeReceitas(fonteDeReceitas)
			selecionarAutonomiaInstituicaoPublica(autonomia)
			if (fonteDeReceitas == "" && autonomia == "") {
				validarNavegacaoOutrosDetalhesContribuinteColectivoInstituicaoPublica()
			}
		}

		if (tipoContribuinte == "ORGANISMO INTERNACIONAL") {
			selecionarTipodeTributacaoOrganizacaoInternacional(tipoDeTributacao)
			if (tipoDeTributacao == "") {
				validarNavegacaoOutrosDetalhesContribuinteColectivoOrganismoInternacional()
			}
		}
	}

	public void validarNavegacaoOutrosDetalhesContribuinteColectivoResponsavelInstituicao() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrResponsavelInstituicao)
	}
	public void validarNavegacaoOutrosDetalhesContribuinteColectivoDataConstituicao() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrDataConstituicao)
	}

	public void validarNavegacaoOutrosDetalhesContribuinteColectivoTipoResponsabilidade() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrTipoResponsabilidade)
	}

	public void validarNavegacaoOutrosDetalhesContribuinteColectivoTipoRepresentanteLegalCodigoPais() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condCodigoPaisRepresentanteLegal)
	}


	public void validarNavegacaoOutrosDetalhesContribuinteColectivoRepresentanteLegal() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condNumeroRepresentanteLegal)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTipoContactoRepresentanteLegal)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTipoResponsabilidadeRepresentanteLegal)
	}

	public void validarNavegacaoOutrosDetalhesContribuinteColectivoAssociacao() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrSegmento)
	}
	public void validarNavegacaoOutrosDetalhesContribuinteColectivoInstituicaoPublica() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrFonteReceitas)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrAutonomia)
	}
	public void validarNavegacaoOutrosDetalhesContribuinteColectivoOrganismoInternacional() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoTributacao)
	}



	public void preencherDetalhesContribuinteSingular(
	String primeiroNome,
	String ultimoNome,
	String genero,
	String dataNascimento,
	String nacionalidadePais,
	String nifPaisNacionalidade,
	String naturalidadePais,
	String provincia,
	String municipio,
	String nomePai,
	String nomeMae) {

		step.clicarNoBotao(NavFormDetalhesContribuinteSingular)

		if (primeiroNome || ultimoNome || genero || dataNascimento == "") {
			step.clicarNoBotao(VerificarFormulario)
			validarNavegacaoDetalhesContribuinteSingular()
		}
		step.inserirTexto(PrimeiroNome, primeiroNome)
		step.inserirTexto(UltimoNome, ultimoNome)
		selecionarGenero(genero)
		step.inserirTexto(DataNascimento, dataNascimento)


		step.selecionarOpcao(NacionalidadePais, nacionalidadePais)
		if (nacionalidadePais == " ") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPais)
		}else if (nacionalidadePais != "AO"){
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condNifPaisNacionalidade)
			step.inserirTexto(NifDoPaisDeNacionalidade, nifPaisNacionalidade)
		}


		step.selecionarOpcao(NaturalidadePais, naturalidadePais)
		if (naturalidadePais == " ") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPais)
		}

		if (naturalidadePais == "AO") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condProvincia)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condMunicipio)
			step.selecionarOpcao(SelecionarProvincia, provincia)
			step.selecionarOpcao(SelecionarMunicipio, municipio)
		}else {
			step.inserirTexto(InserirProvincia, provincia)
			step.inserirTexto(InserirMunicipio, municipio)
		}

		step.inserirTexto(NomeDoPai, nomePai);
		step.inserirTexto(NomeDaMae, nomeMae);
	}

	public void preencherPaisNacionalidadeDetalhesContribuinteSingular(String nacionalidadePais) {
		step.clicarNoBotao(NavFormDetalhesContribuinteSingular)
		step.selecionarOpcao(NacionalidadePais, nacionalidadePais)
	}
	public void preencherPaisNaturalidadeDetalhesContribuinteSingular(String naturalidadePais) {
		step.clicarNoBotao(NavFormDetalhesContribuinteSingular)
		step.selecionarOpcao(NaturalidadePais, naturalidadePais)
	}
	public void validarNavegacaoDetalhesContribuinteSingular() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPrimeiroNome)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condUltimoNome)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condGenero)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDataNascimento)
	}

	public void validarNavegacaoDetalhesContribuinteSingularComPais() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condNifPaisNacionalidade)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condProvincia)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condMunicipio)
	}

	public void selecionarGenero(String genero) {
		switch(genero) {
			case "Feminino":
			step.selecionarOpcao(Genero, "F")
			break;

			case "Masculino":
			step.selecionarOpcao(Genero, "M")
			break;

			case "Vazio":
			step.selecionarOpcao(Genero, " ")
			break;
		}
	}

	public void preencherInformacaoEnderecoSecundario(
	String pais,
	String residenciaHabitual,
	String informacaoComplementar,
	String codigoPostal) {
		step.clicarNoBotao(NavFormInformacaoEnderecoSecundario)
		step.selecionarOpcao(PaisEnderecoSecundario, pais)
		step.inserirTexto(ResidenciaHabitual, residenciaHabitual)
		step.inserirTexto(InformacaoComplementar, informacaoComplementar)
		step.inserirTexto(CodigoPostal, codigoPostal)
	}

	public void validarNavegacaoInformacaoEnderecoSecundario() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPaisEnderecoSecundario)
	}


	public void preencherDadosActividadeOutrem(
	boolean isTrabalhadorContaOutrem = true,
	boolean isAgentePublico = false,
	String entidade,
	String dataVinculo,
	String funcao,
	String numeroAgente) {

		selecionarTipoDeTrabalhadorPorContaDeOutrem()
		step.clicarNoBotao(NavFormDadosActividadeOutrem)

		step.clicarNoBotao(EntidadeEmpregadora)
		pesquisa.pesquisarPorNIF(entidade)
		step.inserirTexto(DataInicioVinculo, dataVinculo)
		step.inserirTexto(Funcao, funcao)

		if(isTrabalhadorContaOutrem == false) {
			step.clicarNoBotao(VerificarFormulario)
			validarNavegacaoDadosActividadeOutrem()
		}

		if (isAgentePublico == true) {
			step.selecionarCheckbox(AgentePublico)
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condNumeroAgente)
			step.inserirTexto(NumeroAgente, numeroAgente)
		}
	}


	public void validarNavegacaoDadosActividadeOutrem() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrEntidadeEmpregadora)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDataVinculo)
	}

	public void preencherRepresentacaoFiscal(
	boolean isRepresentanteFiscal = false,
	String tipoRepresentacao,
	String NifRepresentante){

		step.clicarNoBotao(NavFormRepresentacaoFiscal)

		if(isRepresentanteFiscal == true) {
			selecionarRepresentanteFiscal(tipoRepresentacao)
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRepresentacaoFiscal)
			step.clicarNoBotao(PesquisaNifRepresentanteFiscal)
			pesquisa.pesquisarPorNIF(NifRepresentante)
		}
	}

	public void selecionarRepresentanteFiscal(String tipoRepresentacao) {
		switch(tipoRepresentacao) {
			case "Com Representação Fiscal":
			step.selecionarOpcao(IndicadorRepresentacao, "LRTR")
			break;

			case "Sem Representação Fiscal":
			step.selecionarOpcao(IndicadorRepresentacao, "LRFS")
			break;
		}
	}

	public void preencherIdentificacaoDeAgencias(
	String tipoContribuinte,
	String denominacao,
	String provincia,
	String autarquia,
	String municipio,
	String comuna,
	String localidade,
	String bairro,
	String quarteirao,
	String condominio,
	String edificio,
	String residenciaHabitual,
	String casa,
	String andar,
	String codigoPostal,
	String localReferencia,
	String numeroDeTrabalhadoresAgencia,
	String tipoContacto,
	String codigoPais,
	String numeroContacto,
	String email,
	String porcentagemDeParticipacao,
	String nifEmpresa) {
		step.clicarNoBotao(NavFormIdentificacaoAgencias)
		step.inserirTexto(DenominacaoDetalhesAgencia, denominacao)
		step.selecionarOpcao(ProvinciaDetalhesAgencia, provincia)
		step.clicarNoBotaoEinserirTexto(AutarquiaDetalhesAgencia, autarquia)
		step.selecionarOpcao(MunicipioDetalhesAgencia, municipio)
		step.selecionarOpcao(ComunaDetalhesAgencia, comuna)
		step.clicarNoBotaoEinserirTexto(LocalidadeDetalhesAgencia, localidade)
		step.inserirTexto(BairroDetalhesAgencia, bairro)
		step.inserirTexto(QuarteiraoDetalhesAgencia, quarteirao)
		step.inserirTexto(CondominioDetalhesAgencia, condominio)
		step.inserirTexto(EdificioDetalhesAgencia, edificio)
		step.inserirTexto(ResidenciaHabitualDetalhesAgencia, residenciaHabitual)
		step.inserirTexto(CasaDetalhesAgencia, casa)
		step.inserirTexto(AndarDetalhesAgencia, andar)
		step.inserirTexto(CodigoPostalDetalhesAgencia, codigoPostal)
		step.inserirTexto(LocalDeReferenciaDetalhesAgencia, localReferencia)
		step.inserirTexto(NDeTrabalhadoresDaAgencia, numeroDeTrabalhadoresAgencia)
		selecionarTipoContacto(TipoContacto,tipoContacto)
		if (tipoContacto == "Estrangeiro") {
			step.clicarNoBotao(LupaPesquisa)
			pesquisaPais.pesquisarPorCodigoPais(codigoPais)
		}
		step.inserirTexto(NumeroContacto, numeroContacto)
		step.inserirTexto(Email, email)
		if (tipoContribuinte == "EMPRESA" && nifEmpresa != "") {
			step.clicarNoBotao(PesquisarNifDaEmpresaMae)
			pesquisa.pesquisarPorNIF(nifEmpresa)
			step.inserirTexto(PorcentagemDeParticipacao, porcentagemDeParticipacao)
		}
		if (tipoContribuinte != "") {
			assertTrue(step.verificarElementoVisivel(ContaIdentificacaoAgencias))
		}
	}

	public void selecionarTipoContacto(TestObject, String tipoContacto) {
		switch(tipoContacto) {
			case "Estrangeiro":
			step.selecionarOpcao(TestObject, "FOREIGN")
			break;

			case "Fixo":
			step.selecionarOpcao(TestObject, "LANDLINE")
			break;

			case "Telemóvel":
			step.selecionarOpcao(TestObject, "MOBILE")
			break;

			case "Vazio" || " ":
			step.selecionarOpcao(TestObject, " ")
			break;
		}
	}

	public void preencherInformacaoDeContacto(
	String contribuinte,
	String tipoContactoPrincipal,
	String numeroContactoPrincipal,
	String tipoContacto,
	String numeroContacto,
	String email,
	String codigoPais,
	String codigoPaisPrincipal,
	String enderecoWeb
	) {
		step.clicarNoBotao(NavFormInformacaoContacto)
		selecionarTipoContacto(TipoContactoPrincipalInformacaoContacto, tipoContactoPrincipal)
		if (tipoContactoPrincipal == "Estrangeiro") {
			step.clicarNoBotao(BotaoCodigoPaisPrincipal)
			pesquisaPais.pesquisarPorCodigoPais(codigoPaisPrincipal)
		}
		step.inserirTexto(NumeroContactoInformacaoContacto, numeroContactoPrincipal)
		selecionarTipoContacto(TipoContactoInformacaoContacto, tipoContacto)
		if (tipoContacto == "Estrangeiro") {
			step.clicarNoBotao(BotaoCodigoPais)
			pesquisaPais.pesquisarPorCodigoPais(codigoPais)
		}
		step.inserirTexto(NumeroInformacaoContacto, numeroContacto)
		step.inserirTexto(EmailInformacaoContacto, email)

		if(contribuinte == "COLECTIVO") {
			step.inserirTexto(EnderecoWeb, enderecoWeb)
		}
	}

	public void validarInformacaoDeContacto(String tipoContactoPrincipal) {

		switch (tipoContactoPrincipal) {
			case "Estrangeiro":
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrCodigoPais)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNContacto)
			break;

			case "Fixo":
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNContacto)
			break;

			case "Telemovel":
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNContacto)
			break;

			case " ":
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoContactoPrincipal)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNContacto)
			break;
		}
	}


	public void preencherDetalhesIdentificacaoContribuinteSingular(
	String tipoId,
	String numeroId,
	String dataValidade,
	String dataEmissao,
	String descricao,
	String paisEmissaoPassaporte) {
		step.clicarNoBotao(NavFormDetalhesIdentificacaoContribuinteSingular)

		switch(tipoId) {
			case "Bilhete de Identidade":
			step.selecionarOpcao(TipoIdentificacao, "AID")
			break;

			case "Cartão de Refugiado":
			step.selecionarOpcao(TipoIdentificacao, "REF")
			break;

			case "Cartão de Residente":
			step.selecionarOpcao(TipoIdentificacao, "RES")
			break;

			case "Certidão de Nascimento":
			step.selecionarOpcao(TipoIdentificacao, "BCER")
			break;

			case "Passaporte":
			step.selecionarOpcao(TipoIdentificacao, "PASS")
			break;

			case "Outro":
			step.selecionarOpcao(TipoIdentificacao, "OTHR")
			break;

			case " ":
			step.selecionarOpcao(TipoIdentificacao, " ")
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoIdentificacao)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			break;
		}

		if(tipoId == "Bilhete de Identidade") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			step.clicarNoBotao(ObterDados)
			step.inserirTexto(DataEmissao, dataValidade)
			step.inserirTexto(DataValidade, dataValidade)
		}

		if(tipoId == "Cartão de Refugiado") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDataValidade)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			step.inserirTexto(DataEmissao, dataEmissao)
			step.inserirTexto(DataValidade, dataValidade)
		}

		if(tipoId == "Cartão de Residente") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDataValidade)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDataEmissao)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			step.inserirTexto(DataEmissao, dataEmissao)
			step.inserirTexto(DataValidade, dataValidade)
		}

		if(tipoId == "Certidão de Nascimento") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			step.inserirTexto(DataEmissao, dataEmissao)
		}

		if(tipoId == "Outro") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDescricao)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			step.inserirTexto(Descricao, descricao)
			step.inserirTexto(DataEmissao, dataEmissao)
			step.inserirTexto(DataValidade, dataValidade)
		}

		if(tipoId == "Passaporte") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroDocID)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condPaisPassaporte)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condDataValidade)
			step.inserirTexto(NumeroDocumentoIdentificacao, numeroId)
			selecionarPaisEmissaoPassaporte(paisEmissaoPassaporte)
			step.inserirTexto(DataEmissao, dataEmissao)
			step.inserirTexto(DataValidade, dataValidade)
		}
	}

	public void anexarDocumento() {
		step.adicionarDocumento(AnexarDocumento)
		step.clicarNoBotao(navFormDocumentosAnexados)
		step.verificarCampoClicavel(Apagar)
	}

	public void selecionarPaisEmissaoPassaporte(String pais) {
		switch(pais) {
			case " ":
			step.selecionarOpcao(PaisEmissaoPassaporte, ' ')
			break;

			case "AFEGANISTÃO":
			step.selecionarOpcao(PaisEmissaoPassaporte, 'AF')
			break;
		}
	}

	public void validarNavegacaoFormularioSingularNaoResidente() {
		step.verificarCampoClicavel(NavFormPrincipal)
		step.verificarCampoClicavel(NavFormDetalhesRegisto)
		step.verificarCampoClicavel(NavFormEnquadramento)
		step.verificarCampoClicavel(NavFormDetalhesNaoResidente)
		step.verificarCampoClicavel(NavFormRepresentacaoFiscal)
		step.verificarCampoClicavel(NavFormDetalhesIdentificacaoContribuinteSingular)
		step.verificarCampoClicavel(NavFormDetalhesContribuinteSingular)
		step.verificarCampoClicavel(NavFormOutrosDetalhesContribuinteSingular)
		step.verificarCampoClicavel(NavFormOutrasInformacoes)
		step.verificarCampoClicavel(NavFormInformacaoContacto)
		step.verificarCampoClicavel(NavFormInformacaoEndereco)
		step.verificarCampoClicavel(NavFormInformacaoEnderecoSecundario)
		step.verificarCampoClicavel(NavFormInformacaoEnderecoAlternativo)
		step.verificarCampoClicavel(navFormDocumentosAnexados)
	}

	public void preencherInformacaoDeEndereco(
	String provicia,
	String autarquia,
	String municipio,
	String comuna,
	String localidade,
	String bairro,
	String quarteirao,
	String condominio,
	String edificio,
	String rua,
	String casa,
	String andar,
	String codigoPostal,
	String localReferencia,
	String reparticaoFiscal,
	String observacoes
	) {
		step.clicarNoBotao(NavFormInformacaoEndereco)
		step.selecionarOpcao(ProvinciaInformacaoEndereco, provicia)
		step.inserirTexto(AutarquiaInformacaoEndereco, autarquia)
		step.selecionarOpcao(MunicipioInformacaoEndereco, municipio)
		step.selecionarOpcao(ComunaInformacaoEndereco, comuna)
		step.inserirTexto(LocalidadeInformacaoEndereco, localidade)
		step.inserirTexto(BairroInformacaoEndereco, bairro)
		step.inserirTexto(QuarteiraoInformacaoEndereco, quarteirao)
		step.inserirTexto(CondominioInformacaoEndereco, condominio)
		step.inserirTexto(EdificioInformacaoEndereco, edificio)
		step.inserirTexto(RuaAvenidaLargoInformacaoEndereco, rua)
		step.inserirTexto(CasaInformacaoEndereco, casa)
		step.inserirTexto(AndarInformacaoEndereco, andar)
		step.inserirTexto(CodigoPostalInformacaoEndereco, codigoPostal)
		step.inserirTexto(LocalReferenciaInformacaoEndereco, localReferencia)
		step.selecionarOpcao(ReparticaoFiscalInformacaoEndereco, reparticaoFiscal)
		step.inserirTexto(ObservacoesInformacaoEndereco, observacoes)
	}

	public void validarInformacaoEndereco() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrProvinciaInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrMunicipioInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrComunaInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrBairroInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRuaInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrLocalReferenciaInformacaoEndereco)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrReparticaoFiscalInformacaoEndereco)
	}

	public void preencherDadosActividade(
	boolean isTrabalhadorContaPropria = false,
	boolean exerceProfissao = false,
	String codigoProfissao,
	String designacaoComercial,
	String dataInicio,
	String designacao,
	String numeroAlvara,
	String provincia,
	String municipio,
	String comuna,
	String bairro,
	String residenciaHabitual,
	String localReferencia
	) {

		if(isTrabalhadorContaPropria == true) {
			selecionarTipoDeTrabalhadorPorContaPropria()
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDesignacaoOuProfissao)
		}

		step.clicarNoBotao(NavFormDadosActividade)
		step.clicarNoBotao(VerificarFormulario)
		validarDadosActividade()

		if(exerceProfissao == true) {
			step.selecionarCheckbox(ExerceProfissao)
			step.selecionarOpcao(CodigoProfissao, codigoProfissao)
		}

		step.inserirTexto(DesignacaoComercial, designacaoComercial)
		step.inserirTexto(DataInicio, dataInicio)
		step.selecionarOpcao(Designacao, designacao)
		step.inserirTexto(NumeroAlvara, numeroAlvara)
		step.selecionarOpcao(ProvinciaActividade, provincia)
		if(municipio != "")
		step.selecionarOpcao(MunicipioActividade, municipio)
		if(comuna != "")
		step.selecionarOpcao(ComunaActividade, comuna)
		step.inserirTexto(BairroActividade, bairro)
		step.inserirTexto(ResidenciaHabitualActividade, residenciaHabitual)
		step.inserirTexto(LocalReferenciaActividade, localReferencia)
	}

	public void validarDadosActividade() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDataInicio)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDesignacaoComercial)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrProvincia)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrMunicipio)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrComuna)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrBairro)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrResidenciaHabitual)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrLocalReferencia)
	}

	public void preencherInformacaoDeEnderecoAlternativas(
	String pais,
	String autarquia,
	String localidade,
	String quarteirao,
	String condominio,
	String edificio,
	String rua,
	String casa,
	String andar,
	String informacaoComplementar,
	String codigoPostal

	) {
		step.clicarNoBotao(NavFormInformacaoEnderecoAlternativo)
		step.selecionarOpcao(PaisEnderecoAlternativo, pais)
		step.inserirTexto(AutarquiaEnderecoAlternativo, autarquia)
		step.inserirTexto(LocalidadeEnderecoAlternativo, localidade)
		step.inserirTexto(QuarteiraoEnderecoAlternativo, quarteirao)
		step.inserirTexto(CondominioEnderecoAlternativo, condominio)
		step.inserirTexto(EdificioEnderecoAlternativo, edificio)
		step.inserirTexto(RuaEnderecoAlternativo, rua)
		step.inserirTexto(CasaEnderecoAlternativo, casa)
		step.inserirTexto(AndarEnderecoAlternativo, andar)
		step.inserirTexto(CodigoPostalEnderecoAlternativo, codigoPostal)
	}

	public void validarInformacaoDeEnderecoAlternativas() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRuaEnderecoAlternativo)
	}

	public void preencherInformacoesDeIVA(
	boolean comDireitoADeducao,
	boolean semDireitoADeducao,
	boolean operacoesMistas,
	boolean obrigadoCativarIVA,
	String sector,
	String realizaImportacoes,
	String realizaExportacoes,
	String regime,
	String tipoRenuncia,
	String tipoRegime,
	String tipoContabilidade,
	String opcaoPelaContabilidadeOrganizada,
	String localizacaoContabilidade,
	boolean conferePlenosPoderesDeclarativosAoContabilista,
	String nif,
	String tipoContactoPrincipal,
	String numero,
	String numeroContabilistaOPCA,
	String enderecoCorreioElectronico,
	String provincia,
	String autarquia,
	String municipio,
	String comuna,
	String numeroEstabelecimentoComercial

	) {
		step.clicarNoBotao(NavFormInformacoesDeIVA)

		if (comDireitoADeducao == true) {
			step.selecionarCheckbox(ComDireitoADeducaoInformacoesDeIVA)
		} else {
			step.desmarcarCheckbox(ComDireitoADeducaoInformacoesDeIVA)
		}
		if (semDireitoADeducao == true) {
			step.selecionarCheckbox(SemDireitoADeducaoInformacoesDeIVA)
		} else {
			step.desmarcarCheckbox(SemDireitoADeducaoInformacoesDeIVA)
		}
		if (operacoesMistas == true) {
			step.selecionarCheckbox(OperacoesMistasInformacoesDeIVA)
			selecionarTipoRegimeActividadesMistas(tipoRegime)
		} else {
			step.desmarcarCheckbox(OperacoesMistasInformacoesDeIVA)
		}
		if (obrigadoCativarIVA == true) {
			step.selecionarCheckbox(ObrigadoCativarIVAInformacoesDeIVA)
			selecionarSector(sector)
		} else {
			step.desmarcarCheckbox(ObrigadoCativarIVAInformacoesDeIVA)
		}

		selecionarRealizaImportacoes(realizaImportacoes)
		selecionarRealizaExortacoes(realizaExportacoes)
		selecionarRegimeIVA(regime)
		selecionarTipoRenuncia(tipoRenuncia)
		selecionarTipoContabilidade(tipoContabilidade)
		if (tipoContabilidade == "Organizada") {
			selecionarOpcaoPelaContabilidadeOrganizada(opcaoPelaContabilidadeOrganizada)
			step.inserirTexto(LocalizacaoDaContabilidadeInformacoesDeIVA, localizacaoContabilidade)
			if (conferePlenosPoderesDeclarativosAoContabilista == true) {
				step.selecionarCheckbox(ConferePlenosPoderesDeclarativosAoContabilistaInformacoesDeIVA)
			}
		}
		if (nif != "Vazio" || nif != "") {
			step.clicarNoBotao(NifInformacoesDeIVA)
			pesquisa.pesquisarPorNIF(nif)
		}
		selecionarTipoContacto(TipoContactoPrincipalInformacoesDeIVA, tipoContactoPrincipal)
		step.inserirTexto(NumeroInformacoesDeIVA, numero)
		step.inserirTexto(NumeroContabilistaOPCAInformacoesDeIVA, numeroContabilistaOPCA)
		step.inserirTexto(EnderecoCorreioElectronicoInformacoesDeIVA, enderecoCorreioElectronico)

		if (provincia != "Vazio") {
			step.selecionarOpcao(ProvinciaInformacoesDeIVA, provincia)
			if (municipio != "Vazio") {
				step.selecionarOpcao(MunicipioInformacoesDeIVA, municipio)
			}
			if (comuna != "Vazio") {
				step.selecionarOpcao(ComunaInformacoesDeIVA, comuna)
			}
		}
		step.inserirTexto(AutarquiaInformacoesDeIVA, autarquia)
		step.inserirTexto(numeroEstabelecimentoComercialInformacoesDeIVA, numeroEstabelecimentoComercial)
	}

	public void selecionarRegimeIVA(String regime) {
		switch(regime) {
			case "Regime Geral":
			step.selecionarOpcao(RegimeInformacoesDeIVA, "GNAD")
			break;

			case "Regime Simplificado":
			step.selecionarOpcao(RegimeInformacoesDeIVA, "SIMP")
			break;

			case "Regime de Exclusão":
			step.selecionarOpcao(RegimeInformacoesDeIVA, "EXCL")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(RegimeInformacoesDeIVA, " ")
			break;
		}

		enviarTipoDeRegimeIVA = regime;
	}

	public void selecionarTipoContabilidade(String tipoContabilidade) {
		switch(tipoContabilidade) {
			case "Não Organizada":
			step.selecionarOpcao(TipoContabilidadeInformacoesDeIVA, "NOR")
			break;

			case "Organizada":
			step.selecionarOpcao(TipoContabilidadeInformacoesDeIVA, "ORG")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(TipoContabilidadeInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarRealizaImportacoes (String realizaImportacoes) {
		switch(realizaImportacoes) {
			case "Não":
			step.selecionarOpcao(RealizaImportacoesInformacoesDeIVA, "N")
			break;

			case "Sim":
			step.selecionarOpcao(RealizaImportacoesInformacoesDeIVA, "Y")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(RealizaImportacoesInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarRealizaExortacoes (String realizaExportacoes) {
		switch(realizaExportacoes) {
			case "Não":
			step.selecionarOpcao(RealizaExportacoesInformacoesDeIVA, "N")
			break;

			case "Sim":
			step.selecionarOpcao(RealizaExportacoesInformacoesDeIVA, "Y")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(RealizaExportacoesInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarOpcaoPelaContabilidadeOrganizada(String opcaoPelaContabilidadeOrganizada) {
		switch(opcaoPelaContabilidadeOrganizada) {
			case "Por Exigência Legal":
			step.selecionarOpcao(OpcaoPelaContabilidadeOrganizadaInformacoesDeIVA, "LEGR")
			break;

			case "Por Opção":
			step.selecionarOpcao(OpcaoPelaContabilidadeOrganizadaInformacoesDeIVA, "CHCE")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(OpcaoPelaContabilidadeOrganizadaInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarTipoRegimeActividadesMistas(String tipoRegime) {
		switch(tipoRegime) {
			case "Afectação Real":
			step.selecionarOpcao(TipoRegimeInformacoesDeIVA, "AFR")
			break;

			case "Pró Rata":
			step.selecionarOpcao(TipoRegimeInformacoesDeIVA, "PRO")
			break;

			case "Pró Rata e Afectação Real":
			step.selecionarOpcao(TipoRegimeInformacoesDeIVA, "AFRO")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(TipoRegimeInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarTipoRenuncia(String tipoRenuncia) {
		switch(tipoRenuncia) {
			case "Renúncia ao Regime Simplificado":
			step.selecionarOpcao(TipoRenunciaInformacoesDeIVA, "RNTR")
			break;

			case "Renúncia à Isenção":
			step.selecionarOpcao(TipoRenunciaInformacoesDeIVA, "WVEX")
			break;

			case "Sujeito passivo afecto à indústria transforma-dora":
			step.selecionarOpcao(TipoRenunciaInformacoesDeIVA, "NWVR")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(TipoRenunciaInformacoesDeIVA, " ")
			break;
		}
	}

	public void selecionarSector (String sector) {
		switch(sector) {
			case "Autarquia Local":
			step.selecionarOpcao(SectorInformacoesDeIVA, "AUT")
			break;

			case "Banco Comercial":
			step.selecionarOpcao(SectorInformacoesDeIVA, "BANC")
			break;

			case "Banco Nacional de Angola":
			step.selecionarOpcao(SectorInformacoesDeIVA, "BANN")
			break;

			case "Estado (excepto Empresas Públicas)":
			step.selecionarOpcao(SectorInformacoesDeIVA, "ESTA")
			break;

			case "Operadora de Telecomunicações":
			step.selecionarOpcao(SectorInformacoesDeIVA, "OPTE")
			break;

			case "Resseguradora":
			step.selecionarOpcao(SectorInformacoesDeIVA, "RESS")
			break;

			case "Seguradora":
			step.selecionarOpcao(SectorInformacoesDeIVA, "SEG")
			break;

			case "Sociedade Investidora Petrolífera":
			step.selecionarOpcao(SectorInformacoesDeIVA, "SOCI")
			break;

			case "Vazio" || " " || "":
			step.selecionarOpcao(SectorInformacoesDeIVA, " ")
			break;
		}
	}

	public void iniciarRegimeIVA() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(IniciarRegimeIVA)
	}

	public void validarInformacoesDeIVAOperacoesMistasEObrigadoACativarIVA() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrSectorInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaImportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaExportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoRegimeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRegimeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoContabilidadeInformacoesIVA)
	}

	public void validarInformacoesDeIVATipoContabilidadeOrganizada() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaImportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaExportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRegimeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrOpcaoPelaContabilidadeOrganizadaInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrLocalizacaoContabilidadeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNifInformacoesIVA)
	}

	public void validarInformacoesDeIVATipoContabilidadeOrganizadaTipoContactoPrincipal() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaImportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaExportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRegimeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrOpcaoPelaContabilidadeOrganizadaInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrLocalizacaoContabilidadeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoContactorPrincipalInformacoesIVA)
	}

	public void validarInformacoesDeIVACodigoPaisNumero() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaImportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaExportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumeroInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrCodigoPaisInformacoesIVA)
	}

	public void validarInformacoesDeIVAMunicipioComuna() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaImportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRealizaExportacoesInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrRegimeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrTipoContabilidadeInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrMunicipioInformacoesIVA)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrComunaInformacoesIVA)
	}

	public void validarInformacoesDeIVARegime() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrSelecionarRegimeDeExclusao)
	}

	public void validarGravarEPublicarFormulario() {
		verificarFormulario()
		step.validarListaExcecao(ValidacaoListaExcecao, "Formulário verificado com êxito.")
		gravarFormulario()
		sleep(3000)
		validarFormulario()
		publicarFormulario()
		step.fecharAlerta()
	}

	public void validarFormulario() {
		step.aguardarElementoVisivel(Validar)
		step.clicarNoBotao(Validar)
	}

	public void gravarFormulario() {
		step.aguardarElementoVisivel(Gravar)
		step.clicarNoBotao(Gravar)
	}

	public void publicarFormulario() {
		step.aguardarElementoVisivel(Publicar)
		step.clicarNoBotao(Publicar)
	}

	public void imprimirComprovativoDeCadastro() {
		sleep(10000)
		step.aguardarElementoVisivel(ComprovativoCadastro)
		step.clicarNoBotao(ComprovativoCadastro)
		step.abrirComprovativo("Formulário de Cadastro")
	}

	public void imprimirDeclaracaoModelo6() {
		sleep(10000)
		step.aguardarElementoVisivel(DeclaracaoModelo6)
		step.clicarNoBotao(DeclaracaoModelo6)
		step.abrirComprovativo("Formulário de Cadastro")
	}

	public void selecionarTipoDeContribuinteColectivo(String tipoDeContribuinteColectivo) {
		switch(tipoDeContribuinteColectivo) {
			case "ASSOCIAÇÃO":
			step.selecionarOpcao(TipoDeContribuinteColectivo, "ASS")
			break;

			case "EMPRESA":
			step.selecionarOpcao(TipoDeContribuinteColectivo, "COM")
			break;

			case "INSTITUIÇÃO PÚBLICA":
			step.selecionarOpcao(TipoDeContribuinteColectivo, "PUB")
			break;

			case "ORGANISMO INTERNACIONAL":
			step.selecionarOpcao(TipoDeContribuinteColectivo, "INT")
			break;

			case "Vazio":
			step.selecionarOpcao(TipoDeContribuinteColectivo, " ")
			break;
		}
	}

	public void preencherIdentificacaoDosSocios(String numeroDeIdentificacao, String percentagem) {
		step.clicarNoBotao(NavFormIdentificacaoDosSocios)
		if(numeroDeIdentificacao == "" && percentagem == "") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDetalhesDosSocios)
		}
		step.inserirTexto(PercentagemIdentificacaoDosSocios, percentagem)
		if(percentagem != "" && numeroDeIdentificacao == "") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNumerodeIdentificacao)
		}
		if (percentagem == "" && numeroDeIdentificacao != "") {
			step.clicarNoBotao(PesquisaNIFIdentificacaoDosSocios)
			pesquisa.pesquisarPorNIF(numeroDeIdentificacao)
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrPercentagem)
			numeroDeIdentificacao = ""
		}
		if(numeroDeIdentificacao != "") {
			step.clicarNoBotao(PesquisaNIFIdentificacaoDosSocios)
			pesquisa.pesquisarPorNIF(numeroDeIdentificacao)
		}
	}


	public void preencherDetalhesIdentificacaoContribuinteColectivo(
	String tipoColectivo,
	String paisOrigem,
	String nifPaisOrigem,
	String numeroRegistoComercial,
	String denominacao,
	String designacaoComercial,
	String naturezaLegal,
	String beneficiarioEfectivo,
	String indicadorFilial,
	String nifEmpresaMae) {

		step.clicarNoBotao(NavFormDetalhesIdentificacaoContribuinteColectivo)


		step.selecionarOpcao(PaisOrigem, paisOrigem)
		if (paisOrigem == " ") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrPaisOrigem)
		} else if (paisOrigem != "AO"){
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condNifPaisOrigem)
			step.inserirTexto(NifPaisOrigem, nifPaisOrigem)
		}

		if(denominacao == "" || naturezaLegal == "") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDenominacao)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrNaturezaLegal)
		}

		step.inserirTexto(Denominacao, denominacao)
		step.selecionarOpcao(NaturezaLegal, naturezaLegal)


		if (tipoColectivo == "EMPRESA") {
			step.clicarNoBotao(VerificarFormulario)
			step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrDesignacaoComercialEmpresa)
			step.inserirTexto(NumeroRegistoComercial, numeroRegistoComercial)
			step.inserirTexto(DesignacaoComercialEmpresa, designacaoComercial)
			step.clicarNoBotao(BeneficiarioEfectivo)
			pesquisa.pesquisarPorNIF(beneficiarioEfectivo)

			switch(indicadorFilial) {
				case "Sim":
				step.selecionarOpcao(IndicadorFilial, "Y")
				step.clicarNoBotao(NifEmpresaMae)
				pesquisa.pesquisarPorNIF(nifEmpresaMae)
				break;

				case "Nao":
				step.selecionarOpcao(IndicadorFilial, "N")
				break;

				case "":
				step.selecionarOpcao(IndicadorFilial, " ")
				break;
			}
		}
	}

	public void validarIdentificacaoDeAgencias() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrPorcentagemDeParticipacao)
	}

	public void selecionarSegmentoAssociacao(String segmento) {
		switch(segmento) {
			case "Mecenato (beneficiário)":
			step.selecionarOpcao(Segmento, "PBEN")
			break;

			case "Utilidade Pública":
			step.selecionarOpcao(Segmento, "PUTL")
			break;

			case "Vazio" || "" || " ":
			step.selecionarOpcao(Segmento, " ")
			break;
		}
	}

	public void selecionarFonteDeReceitas(String fontesDeReceitas) {
		switch(fontesDeReceitas) {
			case "Outros":
			step.selecionarOpcao(FontesDeReceitas, "OTHR")
			break;

			case "Receitas próprias":
			step.selecionarOpcao(FontesDeReceitas, "OWRV")
			break;

			case "Recursos Consignados":
			step.selecionarOpcao(FontesDeReceitas, "CNSG")
			break;

			case "Subsídios":
			step.selecionarOpcao(FontesDeReceitas, "GRNT")
			break;

			case "Transferência do OGE":
			step.selecionarOpcao(FontesDeReceitas, "OGET")
			break;

			case "Vazio" || "" || " ":
			step.selecionarOpcao(FontesDeReceitas, " ")
			break;
		}
	}

	public void selecionarAutonomiaInstituicaoPublica(String autonomia) {
		switch(autonomia) {
			case "Orgão Dependente (OD)":
			step.selecionarOpcao(Autonomia, "DBDY")
			break;

			case "Unidade Orçamental (UO)":
			step.selecionarOpcao(Autonomia, "BUNT")
			break;

			case "Vazio" || "" || " ":
			step.selecionarOpcao(Autonomia, " ")
			break;
		}
	}

	public void selecionarTipodeTributacaoOrganizacaoInternacional(String tipoDeTributacao) {
		switch(tipoDeTributacao) {
			case "Outra":
			step.selecionarOpcao(TipoDeTributacao, "OTHR")
			break;

			case "Reciprocidade/isenção":
			step.selecionarOpcao(TipoDeTributacao, "REXP")
			break;

			case "Reciprocidade/pagamento":
			step.selecionarOpcao(TipoDeTributacao, "RPAY")
			break;

			case "Vazio" || "" || " ":
			step.selecionarOpcao(TipoDeTributacao, " ")
			break;
		}
	}
	public void selecionarTipoResponsabilidade(TestObject, String TipoResponsabilidade) {
		switch (TipoResponsabilidade) {
			case "Adido":
			step.selecionarOpcao(TestObject, "ATTC")
			break;
			case "Administrador":
			step.selecionarOpcao(TestObject, "ADM")
			break;
			case "Coordenador":
			step.selecionarOpcao(TestObject, "CORD")
			break;
			case "Cônsul":
			step.selecionarOpcao(TestObject, "CONS")
			break;
			case "Director":
			step.selecionarOpcao(TestObject, "DIR")
			break;
			case "Director Geral":
			step.selecionarOpcao(TestObject, "GNDR")
			break;
			case "Director-Geral Adjunto":
			step.selecionarOpcao(TestObject, "DGDR")
			break;
			case "Embaixador":
			step.selecionarOpcao(TestObject, "AMBS")
			break;
			case "Gerente Ou Gestor":
			step.selecionarOpcao(TestObject, "MANG")
			break;
			case "Governador":
			step.selecionarOpcao(TestObject, "GOV")
			break;
			case "Ministro":
			step.selecionarOpcao(TestObject, "MIN")
			break;
			case "Ministro Conselheiro":
			step.selecionarOpcao(TestObject, "MINC")
			break;
			case "PCA":
			step.selecionarOpcao(TestObject, "CEO")
			break;
			case "Presidente":
			step.selecionarOpcao(TestObject, "PRES")
			break;
			case "Procurador":
			step.selecionarOpcao(TestObject, "ATRN")
			break;
			case "Representante Legal":
			step.selecionarOpcao(TestObject, "LEGR")
			break;
			case "Secretário Geral":
			step.selecionarOpcao(TestObject, "GSEC")
			break;
			case "Secretário de Estado":
			step.selecionarOpcao(TestObject, "SOS")
			break;
			case "Sócio Gerente":
			step.selecionarOpcao(TestObject, "MANP")
			break;
			case "Vice Presidente":
			step.selecionarOpcao(TestObject, "VPR")
			break;
			case "" || " ":
			step.selecionarOpcao(TestObject, " ")
			break;
		}
	}

	public void validarRegraInstituicoesPublicasRegimeSimplificado() {
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.ObrTipoContribuinteColectivoInstituicaoPublica)
	}


	public void validarRegraVolumeDeNegocioRegimeSimplificado(
	boolean isTrabalhadorContaPropria,
	String tipoRegime,
	String tipo,
	Double volumeVendas,
	Double prestacaoServico,
	String periodoValores) {

		double total;

		step.clicarNoBotao(VerificarFormulario)


		switch(periodoValores) {
			case "Anual":
			total = volumeVendas + prestacaoServico;
			break;
			case "Mensal":
			total = (volumeVendas + prestacaoServico) * 12.0;
			break;
			case "Semestral":
			total = (volumeVendas + prestacaoServico) * 2.0;
			break;
			case "Trimestral":
			total = (volumeVendas + prestacaoServico) * 4.0;
			break;
		}



		if(isTrabalhadorContaPropria == true) {
			if(enviarTipoDeRegimeIVA == "Regime Simplificado") {
				if(((total > 10000000) && (total <= 350000000)) == false) {
					step.clicarNoBotao(VerificarFormulario)
					step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTotalVolumeDeNegocioRegimeIVA)
				}
			} else if((enviarTipoDeRegimeIVA == "Regime Geral") == false) {
				if(total > 350000000) {
					step.clicarNoBotao(VerificarFormulario)
					step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTotalVolumeDeNegocioRegimeIVA)
				}
			}
			else if(enviarTipoDeRegimeIVA == "Regime de Exclusão") {
				if(total > 100000.00) {
					step.clicarNoBotao(VerificarFormulario)
					step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.condTotalVolumeDeNegocioRegimeIVA)
				}
			}
		}
	}

	public void verificarDisponibilidadeRegimeIvaDeCaixa() {

		step.clicarNoBotao(NavFormInformacoesDeIVA)

		boolean validar = step.verificarElementoNoCampoDeSelecao(RegimeInformacoesDeIVA, "CASH")

		if(validar == true) {
			step.clicarNoBotao(NavFormDetalhesRegisto)
			selecionarOrigemRegisto("Oficiosa")
		}

		step.clicarNoBotao(NavFormInformacoesDeIVA)
		step.selecionarOpcao(RegimeInformacoesDeIVA, "CASH")
	}

	public void validarVerificacaoDoFormularioComExito() {
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.validFormularioVerificadoComExito)
	}

	public String capturarNifDoFormularioCadastrado() {
		sleep(10000)
		step.aguardarElementoVisivel(ComprovativoCadastro)

		String text = WebUI.getText(InformacaoDoFormulario)

		def matcher = text =~ /\b\d{9,}\b/

		if (matcher) {
			String nifCorrente = matcher[0]
			nifCorrente = nifCorrente.replaceAll(/^\s+/, '').replaceAll(/\s+$/, '')
			println("Numero do nif a ser alterado: ${nifCorrente}")
			return nifCorrente
		} else {
			return println("Nenhum número com pelo menos 9 dígitos encontrado.")
		}
	}

	public void verificarEstadoDaAlteracao(
	String estadoDaAlteracao) {
		step.clicarNoBotao(NavFormPrincipalAlteracao)
		step.aguardarElementoVisivel(Estado)
		String estadoEsperado = WebUI.getText(Estado)
		assert estadoEsperado.contains(estadoDaAlteracao) : "O texto introduzido '$estadoDaAlteracao' não é equal ao texto  '$estadoEsperado'"
	}

	public void preencherInformacoesDeIVAMotivoDeSuspensaoAtividadeIVA(
	String motivoSuspencaoAtividadeIVA,
	String nif) {

		cessarRegimeIVA()

		step.clicarNoBotao(NavFormInformacoesDeIVA)
		step.inserirTexto(MotivoSuspencaoAtividadeIVA, motivoSuspencaoAtividadeIVA)

		if(motivoSuspencaoAtividadeIVA == " ") {
			validarMotivoDeSuspensaoAtividadeIVA()
		}

		if (nif != "Vazio") {
			step.clicarNoBotao(NifSuspensaoActividadeIVA)
			pesquisa.pesquisarPorNIF(nif)
		}
	}

	public void cessarRegimeIVA() {
		step.clicarNoBotao(NavFormDetalhesRegisto)
		step.selecionarCheckbox(CessarRegimeIVA)
	}

	public void validarMotivoDeSuspensaoAtividadeIVA(){
		step.clicarNoBotao(VerificarFormulario)
		step.validarListaExcecao(ValidacaoListaExcecao, FormularioCadastroValidacoes.obrMotivoDeSuspensaoAtividadeIVA)
	}
	
	public void removerNifDoResponsavel() {
		step.clicarNoBotao(RemoverNifResponsavel)
	}
	
}