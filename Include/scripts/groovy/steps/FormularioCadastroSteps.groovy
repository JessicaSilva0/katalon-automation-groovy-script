package steps

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import page.ConsultaFormularioCadastro
import page.FormularioCadastro
import page.Home
import utils.Variaveis
import utils.MassadeDados


class FormularioCadastroSteps {

	Home home = new Home()
	FormularioCadastro formulario = new FormularioCadastro()
	ConsultaFormularioCadastro consulta = new ConsultaFormularioCadastro()
	MassadeDados dados = new MassadeDados()
	MassadeDados dadosAlteracao = new MassadeDados()
	Variaveis variaveis = new Variaveis()


	@Given("estou no formulário de Cadastro")
	def irPara_Formulario_Cadastro() {
		formulario.abrirFormulario()
		formulario.adicionarFormulario()
	}

	@Given("estou na consulta do formulário de Cadastro")
	def irPara_Consulta_Formulario_Cadastro() {
		consulta.pesquisarFormulario()
	}

	@And("não preencho os campos obrigatórios da secção Detalhes do Registo")
	def validar_campos_cadastro() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Vazio","Vazio", "")
	}

	@And("não preencho os campos obrigatórios da secção Detalhes de Contribuinte Singular")
	def validar_camposObrigatorios_DetalhesConstribuinteSingular() {
		formulario.preencherDetalhesContribuinteSingular("", "", "", "", " ", "", " ", "", "", "", "")
	}

	@And("não preencho os campos obrigatórios da secção Informação de endereço secundário")
	def validar_camposObrigatorios_InformacaoEnderecoSecundario() {
		formulario.preencherInformacaoEnderecoSecundario("Vazio", "Vazio", "Vazio", "Vazio")
	}

	@And("preencho apenas os campos Pais Nacionalidade diferente de Angola e Pais Naturalidade igual a Angola da secção Detalhes de Contribuinte Singular")
	def validar_camposObrigatorios_DetalhesConstribuinteSingular_pais() {
		formulario.preencherPaisNacionalidadeDetalhesContribuinteSingular("BR")
		formulario.preencherPaisNaturalidadeDetalhesContribuinteSingular("AO")
	}

	@And("seleciono o Indicador de Não Residente {string}")
	def selecionar_indicador_nao_residente(String indicadorNaoResidente) {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", indicadorNaoResidente, "")
	}

	@And("seleciono o campo Outros contido em Informação Adicional Para Não Residente")
	def selecionar_checkboxOutros_informacao_adicional_nao_residente() {
		formulario.selecionarOutrosDetalhesParaNaoResidentes()
	}

	@And("não preencho o campo obrigatório Motivo outros")
	def validar_motivo_outros() {
		formulario.preencherDetalhesParaNaoResidentes("", "","Outros", "")
	}

	@When("clico no botão Verificar Formulario do Cadastro")
	def verificar_formulario_cadastro() {
		formulario.verificarFormulario()
	}

	@Then("visualizo as mensagens de exceções do Detalhes do Registo")
	def validar_mensagem_excecao_DetalhesDoRegisto() {
		formulario.validarNavegacaoDetalhesDoRegisto()
	}

	@And("seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo")
	def seleciono_tipo_de_contribuinte() {
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
	}

	@And("não preencho o campo obrigatório Grupo de IRT")
	def validar_grupoIRT() {
		formulario.preencherEnquadramentoEmImpostos("SINGULAR", "", " ")
	}

	@And("seleciono o Tipo de Contribuinte {string}")
	def selecionar_Tipo_Contribuinte(String tipoContribuinte) {
		formulario.preencherDetalhesDoRegisto(tipoContribuinte , "", "", "", "");
	}

	@Then("deixo vazio a Informação Adicional Para Não Residente Colectivo")
	def validar_mensagem_exceccao_Informacao_Adicional_Para_Nao_Residente() {
		formulario.preencherDetalhesParaNaoResidentes("COLECTIVO", "Com Estabelecimento Estável", "", "")
	}

	@Then("visualizo as mensagens de exceções do Enquadramento em Impostos")
	def validar_mensagem_excecao_EnquadramentoImpostos() {
		formulario.validarNavegacaoEnquadramentoImpostos()
	}

	@And("não preencho os campos obrigatórios da secção Outras Informações")
	def validar_campos_Outras_Informacoes() {
		formulario.preencherOutrasInformacoesIBAN(true, dados.IBAN, "", "", "")
	}

	@Then("visualizo as mensagens de exceções do IBAN - Outras Informações")
	def validar_mensagem_excecao_OutrasInformacoes() {
		formulario.validarNavegacaoIBANOutrasInformacoes()
	}

	@And("não preencho os campos obrigatórios do Volume de Negócios na secção Outras Informações")
	def validar_campos_Outras_Informacoes_volume_negocios() {
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "", "", "", "")
	}

	@Then("visualizo as mensagens de exceções do Volume de Negocios - Outras Informações")
	def validar_mensagem_excecao_OutrasInformacoes_volume_negocios() {
		formulario.validarNavegacaoVolumeDeNegociosOutrasInformacoes()
	}
	@Then("visualizo as mensagens de exceções do Detalhes para Não Residentes")
	def validar_mensagem_excecao_DetalhesParaNaoResidentes() {
		formulario.validarNavegacaoDetalhesParaNaoResidentes()
	}

	@Then("seleciono a opção {string} no campo Estado Civil da secção Outros Detalhes Contribuinte Singular e valido o formulário de cadastro")
	def validar_campos_Outros_Detalhes_Contribuinte_Singular(String estadoCivil) {
		formulario.preencherOutrosDetalhesdoContribuinteSingular(estadoCivil, "")
	}

	@Then("visualizo as mensagens de exceções do Detalhes de Contribuinte Singular")
	def validar_mensagem_excecao_DetalhesConstribuinteSingular() {
		formulario.validarNavegacaoDetalhesContribuinteSingular()
	}

	@Then("visualizo as mensagens de exceções dos campos Nif do País de Nacionalidade, Província e Município de Detalhes de Contribuinte Singular")
	def validar_mensagem_excecao_DetalhesConstribuinteSingular_pais() {
		formulario.validarNavegacaoDetalhesContribuinteSingularComPais()
	}

	@Then("visualizo as mensagens de exceções da secção Informação de endereço secundário")
	def validar_mensagem_excecao_InformacaoEnderecoSecundario() {
		formulario.validarNavegacaoInformacaoEnderecoSecundario()
	}

	@And("seleciono o tipo de contribuinte por Outrém na secção Detalhes do Registo")
	def seleciono_tipo_de_contribuinte_outrem() {
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
	}

	@And("não preencho os Dados de Actividade por conta de outrém")
	def validar_dados_actividade_outrem() {
		formulario.preencherDadosActividadeOutrem(false, true, "", "", "", "")
	}

	@Then("visualizo as mensagens de exceções da secção Dados de Actividade por conta de Outrém")
	def validar_mensagem_excecao_Dados_Actividade_outrem() {
		formulario.validarNavegacaoDadosActividadeOutrem()
	}

	@Then ("visualizo as mensagens de exceções da secção Representação Fiscal")
	def validar_campos_Representacao_Fiscal() {
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
	}
	@And("informo os campos da navegação Identificação de Agencias")
	def informar_campos_identificacao_agencias() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO", "EMPRESA", "Vazio", "Vazio", "")
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "BO", dados.autarquia, "BO#AMBRIZ", "BO#AMBRIZ#AMBRIZ", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Estrangeiro", "55", dados.numeroContacto, dados.email, dados.percentagemSocios, "")
	}

	@And("não preencho os campos obrigatórios da secção Informação de Contacto")
	def informar_campos_informacoes_contacto() {
		formulario.preencherInformacaoDeContacto("", " ", " ", " ", " ", " ", " ", " ", "")
	}

	@Then ("visualizo as mensagens de exceções do Informação de Contacto")
	def validar_campos_vazios_informacoes_contacto() {
		formulario.validarInformacaoDeContacto(" ")
	}

	@And("não preencho os campos obrigatórios da secção Informação de Contacto, exceto os campos Tipo de Contacto Principal Estrangeiro e Código do País")
	def informar_campos_informacao_contacto_estrangeiro() {
		formulario.preencherInformacaoDeContacto("","Estrangeiro", " ", " ", " ", " ", " ", " ","")
	}

	@Then ("visualizo as mensagens de exceções do Informação de Contacto exceto a mensagem de Tipo de Contacto Principal devido ao preenchimento com Estrangeiro")
	def validar_campos_vazios_informacao_contacto_estrangeiro() {
		formulario.validarInformacaoDeContacto("Estrangeiro")
	}

	@And("não preencho os campos obrigatórios da secção Informação de Contacto, exceto o campo Tipo de Contacto Principal Fixo ou Telemóvel")
	def informar_campos_informacao_contacto_fixo_movel() {
		formulario.preencherInformacaoDeContacto("", "Fixo", " ", " ", " ", " ", " ", " ", "")
	}

	@Then ("visualizo as mensagens de exceções do Informação de Contacto exceto a mensagem de Tipo de Contacto Principal devido ao preenchimento com Fixo ou Telemóvel")
	def validar_campos_vazios_informacoao_contacto_fixo_movel() {
		formulario.validarInformacaoDeContacto("Fixo")
	}

	@And("seleciono a opção {string} no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte")
	def validar_campos_Detalhes_Identificacao_Contribuinte_Singular(String tipoId) {
		formulario.preencherDetalhesIdentificacaoContribuinteSingular(tipoId, "", "", "", "", "")
	}

	@Then("anexo o documento do tipo de Identificação: {string}")
	def anexar_Documentos(String tipoId) {
		formulario.preencherDetalhesIdentificacaoContribuinteSingular(tipoId, "102457821ME0357", "11-05-2019", "11-05-2029", "descricao", "descricaoTestes")
		formulario.anexarDocumento()
	}

	@Then("devo visualizar os 14 formulários de cadastro")
	def validar_Navegacao_Formulario_Singular_NaoResidente() {
		formulario.validarNavegacaoFormularioSingularNaoResidente()
	}

	@Then("visualizo as mensagens de exceções de Informação de endereço")
	def validar_campos_vazios_informacao_de_endereco() {
		formulario.validarInformacaoEndereco()
	}

	@And("não preencho os campos obrigatórios na secção Dados de Actividade")
	def validar_campos_Dados_Actividade() {
		formulario.preencherDadosActividade(true, false, "", "", "", " ", "", "", "", "", "", "", "")
	}

	@And("preencho apenas o campo País e deixo os demais campos obrigatórios da secção Informações de endereço alternativas vazios")
	def informar_campos_vazios_informacao_de_endereco_alternativos() {
		formulario.preencherInformacaoDeEnderecoAlternativas("AF", "", "", "", "", "", "", "", "", "", "")
	}

	@And("preencho os dados do formulario para Trabalhador por conta de Outrém - Residente")
	def preencher_formulario_trabalhador_conta_outrem_Residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.preencherDadosActividadeOutrem(true, "102457821ME0357", dados.dataInicio, dados.funcao, "")
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "102457821ME0357")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "YETU", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@When("valido e publico o formulario")
	def validar_e_publicar_formulario() {
		formulario.validarGravarEPublicarFormulario()
	}

	@Then("imprimo o Comprovativo de Cadastro")
	def imprimir_comprovativo_cadastro() {
		formulario.imprimirComprovativoDeCadastro()
	}
	@Then("devo visualizar as mensagens de exceções da secção Informações de endereço alternativas")
	def validar_campos_vazios_informacao_de_endereco_alternativos() {
		formulario.validarInformacaoDeEnderecoAlternativas()
	}

	@And("não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Operações Mistas e Obrigado a cativar o IVA")
	def validar_campos_Informacoes_IVA_OperacoesMistas_ObrigadoCativarIVA() {
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(false, false, true, true, "", "", "", "", "", "", "", "", "", false, "Vazio", "", "", "", "", "Vazio", "", "Vazio", "Vazio", "")
	}

	@Then("visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Tipo de Regime e Sector")
	def validar_campos_vazios_Informacoes_IVA_Com_TipoRegime_Sector() {
		formulario.validarInformacoesDeIVAOperacoesMistasEObrigadoACativarIVA()
	}

	@And("não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Tipo de Contabilidade igual à Organizada")
	def validar_campos_Informacoes_IVA_TipoContabilidadeOrganizada() {
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(false, false, false, false, "", "", "", "", "", "", "Organizada", "Vazio", "", false, "Vazio", "", "", "", "", "Vazio", "", "Vazio", "Vazio", "")
	}

	@Then("visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Opção pela Contabilidade Organizada, Localização da Contabilidade e NIF")
	def validar_campos_vazios_Informacoes_IVA_TipoContabilidadeOrganizada() {
		formulario.validarInformacoesDeIVATipoContabilidadeOrganizada()
	}

	@And("não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Tipo de Contabilidade igual à Organizada e NIF")
	def validar_campos_Informacoes_IVA_TipoContabilidadeOrganizada_NIF() {
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(false, false, false, false, "", "", "", "", "", "", "Organizada", "Vazio", "", false, "007442701UE043", "Vazio", "", "", "", "Vazio", "", "Vazio", "Vazio", "")
	}

	@Then("visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade do campo Tipo de Contacto Principal")
	def validar_campos_vazios_Informacoes_IVA_TipoContabilidadeOrganizada_TipoContactoPrincipal() {
		formulario.validarInformacoesDeIVATipoContabilidadeOrganizadaTipoContactoPrincipal()
	}

	@And("não preencho os campos obrigatórios da secção Informações de IVA exceto os campos NIF e Tipo de Contacto Principal igual a estrangeiro")
	def validar_campos_Informacoes_IVA_NIF_TipoContactoPrincipal() {
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(false, false, false, false, "", "", "", "Regime Geral", "", "", "", "", "", false, "007442701UE043", "Estrangeiro", "", "", "", "Vazio", "", "Vazio", "Vazio","")
	}

	@Then("visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade dos campos Código do País e Número")
	def validar_campos_vazios_Informacoes_IVA_CodigoPais_Numero() {
		formulario.validarInformacoesDeIVACodigoPaisNumero()
	}

	@And("não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Província")
	def validar_campos_Informacoes_IVA_Provincia() {
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(false, false, false, false, "", "", "", "", "", "", "", "", "", false, "", "", "", "", "", "BO", "", "Vazio", "Vazio", "")
	}

	@Then("visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Município e Comuna Distrito Urbano")
	def validar_campos_vazios_Informacoes_IVA_Municipio_Comuna() {
		formulario.validarInformacoesDeIVAMunicipioComuna()
	}

	@Then("valido a mensagem de exceção para o Colectivo Regime simplificado de II e Enquadramento em IVA no Regime como Regime Geral ou Simplificado")
	def validar_obrigacao_de_escolha_de_Regime_de_Exclusao() {
		formulario.validarInformacoesDeIVARegime()
	}


	@And("preencho os dados do formulario para Trabalhador por conta própria e outrém")
	def preencher_formulario_trabalhador_conta_Propria_e_outrem_Residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.preencherDadosActividade(true, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherDadosActividadeOutrem(true, "102457821ME0357", dados.dataInicio, dados.funcao, "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherEnquadramentoEmImpostos("", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Certidão de Nascimento", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@Then("imprimo o Comprovativo de Cadastro e Comprovativo Modelo 6")
	def imprimir_comprovativo_cadastro_modelo_6() {
		formulario.imprimirDeclaracaoModelo6()
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria - Residente")
	def preencher_formulario_trabalhador_conta_Propria_Residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria - Residente IRT C")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IRT_C() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "C")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}
	@And("preencho os dados do formulario para Trabalhador por conta de Outrém - Funcionário Público")
	def preencher_formulario_trabalhador_conta_outrem_Residente_funcionario_publico() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.preencherDadosActividadeOutrem(true, true, "102457821ME0357", dados.dataInicio, dados.funcao, dados.numeroAgente)
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "YETU", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Pensionista")
	def preencher_formulario_pensionista_residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeContribuintePensionista()
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BAI", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Singular Simples")
	def preencher_formulario_simples_residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeContribuinteSimples()
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BAI", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Singular Simples Não Residente")
	def preencher_formulario_simples_nao_residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Não Residente", "")
		formulario.selecionarTipoDeContribuinteSimples()
		formulario.preencherDetalhesParaNaoResidentes("","", "Investidor Directo","")
		formulario.preencherInformacaoEnderecoSecundario("AF", dados.residenciaHabitual, dados.autarquia, dados.codigoPostal)
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BAI", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta de Outrém - Não Residente")
	def preencher_formulario_trabalhador_conta_outrem_NaoResidente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR", "", "Normal", "Não Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.preencherDadosActividadeOutrem(true, "102457821ME0357", dados.dataInicio, dados.funcao, "")
		formulario.preencherEnquadramentoEmImpostos("", "", "A")
		formulario.preencherDetalhesParaNaoResidentes("","", "Proprietario Imovel","")
		formulario.preencherInformacaoEnderecoSecundario("DE", dados.residenciaHabitual, dados.autarquia, dados.codigoPostal)
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "102457821ME0357")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Feminino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "YETU", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria - Não Residente")
	def preencher_formulario_trabalhador_conta_propria_NaoResidente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Não Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherDetalhesParaNaoResidentes("","", "Proprietario Imovel","")
		formulario.preencherInformacaoEnderecoSecundario("DE", dados.residenciaHabitual, dados.autarquia, dados.codigoPostal)
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria, outrém e Pensionista - Residente")
	def preencher_formulario_trabalhador_conta_Propria_outrem_Pensionista_Residente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.selecionarTipoDeContribuintePensionista()
		formulario.preencherDadosActividade(true, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherDadosActividadeOutrem(true, "102457821ME0357", dados.dataInicio, dados.funcao, "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherEnquadramentoEmImpostos("", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Certidão de Nascimento", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria, outrém e Pensionista - Não Residente")
	def preencher_formulario_trabalhador_conta_Propria_outrem_Pensionista_NaoResidente() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Não Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.selecionarTipoDeTrabalhadorPorContaDeOutrem()
		formulario.selecionarTipoDeContribuintePensionista()
		formulario.preencherDadosActividade(true, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherDadosActividadeOutrem(true, "102457821ME0357", dados.dataInicio, dados.funcao, "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherEnquadramentoEmImpostos("", "", "C")
		formulario.preencherDetalhesParaNaoResidentes("","", "Proprietario Imovel","")
		formulario.preencherInformacaoEnderecoSecundario("DE", dados.residenciaHabitual, dados.autarquia, dados.codigoPostal)
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Certidão de Nascimento", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55", "")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Associação com Regime de IVA - Com direito a Dedução")
	def preencher_formulario_para_associacao_com_regime_de_iva_direito_a_deducao() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Geral", "","",
				"Não Organizada", "Vazio", "", false, "", "Fixo", dados.numeroFixo, "", "", "Vazio", "",
				"Vazio", "Vazio", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("ASSOCIAÇÃO", "AO", "", "", dados.denominacao, "",
				"ASST", "", "", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", "", "", "",  dados.dataConstituicao, "", "52",
				"48", "0", " ", "", "","Secretário Geral", "Fixo", "", dados.numeroFixo, "", "", "", "Secretário Geral", "Fixo", "", dados.numeroFixo, "",
				"Mecenato (beneficiário)", "", "", "")
		formulario.preencherInformacaoDeContacto("", "Fixo", dados.numeroFixo, "", "", "", "", "", "")
		formulario.preencherInformacaoDeEndereco("BO", "", "BO#AMBRIZ", "BO#AMBRIZ#AMBRIZ", "", dados.bairro, "","",
				"", dados.ruaAvLargo, "", "", "", dados.localidade, "BO#AMBRIZ#AMBRIZ#19.03", "")
		formulario.preencherDadosActividade("",dados.designacaoComercial, dados.dataConstituicao, "01111", "", "BO", "BO#AMBRIZ",
				"BO#AMBRIZ#AMBRIZ", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
	}


	@Then("valido o formulário sem preencher o tipo do contribuinte Colectivo")
	def validar_Detalhes_Contribuinte_cadastro_colectivo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","","Normal","Residente", "")
	}

	@When("seleciono o tipo de contribuinte Colectivo - Empresa")
	def selecionar_colectivo_empresa() {
		formulario.selecionarTipoContribuinte("COLECTIVO")
		formulario.selecionarTipoDeContribuinteColectivo("EMPRESA")
	}

	@Then("para os campos obrigatórios da secção Identificação dos Sócios não informados, devo visualizar mensagens de obrigatoriedade após veficar o formulário")
	def nao_preenchimento_identificacao_socios() {
		formulario.preencherIdentificacaoDosSocios("", "")
	}

	@Then("para o campo obrigatório Percentagem não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário")
	def nao_preenchimento_identificacao_socios_percentagem() {
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", "")
	}

	@Then("para o campo obrigatório Nº de Identificação não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário")
	def nao_preenchimento_identificacao_socios_numeroDeIdentificacao() {
		formulario.preencherIdentificacaoDosSocios("", dados.percentagemSocios)
	}


	@Then("valido as mensagens de exceções do Detalhes de Identificação do contribuinte Colectivo")
	def detalhes_identificacao_Contribuinte_Colectivo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal","Residente", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", " ", "", "", "", "", " ", "", " ", "")
	}

	@And("seleciono o Contribuinte Colectivo - Regime Simplificado - Regime Geral")
	def validar_Colectivo_Regime_Simplificado_Regime_Geral(){
		formulario.preencherDetalhesDoRegisto("COLECTIVO","Vazio","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("seleciono o Contribuinte Colectivo - Regime Simplificado - Regime Simplificado")
	def validar_Colectivo_Regime_Simplificado_Regime_Simplificado(){
		formulario.preencherDetalhesDoRegisto("COLECTIVO","Vazio","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Simplificado", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("não preencho o campo obrigatório Porcentagem de Participação da sessão Identificação de Agências")
	def nao_informar_campos_identificacao_agencias() {
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", "", "BO", "", "BO#AMBRIZ", "BO#AMBRIZ#AMBRIZ", "", "", "", "", "", "", "", "", "", "", "", " ", "", "", "", "", " ")
	}

	@Then("visualizo as mensagens de exceções da sessão Identificação de Agências")
	def validar_campos_vazios_identificacao_agencias() {
		formulario.validarIdentificacaoDeAgencias()
	}

	@Then("verifico o Formulário sem preencher o campo obrigatório Regime II da secção Enquadramento em Impostos")
	def verificar_Formulario_sem_preencher_o_campo_obrigatorio_regimeII() {
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "")
	}

	@When("seleciono o tipo de contribuinte Colectivo")
	def seleciono_tipo_de_contribuinte_colectivo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO", "", "", "", "")
	}

	@Then("Pesquiso por Pessoa, Data Receção e Morada e visualizo as mensagens de exceções")
	def pesquisar_formulario_por_pessoa() {
		consulta.pesquisarPor("Pessoa", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
		sleep(1)
		consulta.pesquisarPor("Data de Receção/Origem do Formulário/Estado", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
		sleep(1)
		consulta.pesquisarPor("Morada", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
	}

	@Then("Pesquiso por Localização do Documento,  Telefone e  E-mail e visualizo as mensagens de exceções")
	def pesquisar_formulario_por_Localizacao_do_documento() {
		consulta.pesquisarPor("Document Locator", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
		sleep(1)
		consulta.pesquisarPor("Telefone", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
		sleep(1)
		consulta.pesquisarPor("Email", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","")
	}


	@And("preencho os dados do formulario para Colectivo Empresa - Residente")
	def preencher_formulario_coletivo_empresa_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}
	@Then("verifico o formulário sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo")
	def nao_informar_campos_outros_detalhes_contribuinte_colectivo() {
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", "", "", "", "", "", "", "", "", " ", "", "", "", "", "", "", "", "", "", "",
				"","", "", "", "", "", "", "")
	}

	@Then("visualizo as mensagens de exceções da secção Outros Detalhes de Contribuinte Colectivo")
	def validar_Mensagens_execoes_campos_outros_detalhes_contribuinte_colectivo() {
	}

	@When("seleciono o tipo de contribuinte Colectivo - Associação")
	def selecionar_o_tipo_de_contribuinte_colectivo_associacao() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO", "ASSOCIAÇÃO", "", "", "")
	}

	@Then("verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Associação")
	def nao_informar_campos_outros_detalhes_contribuinte_colectivo_associacao() {
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", "", "", "", "", "", "", "", "", " ", "", "", "", "", "", "", "", "", "", "",
				"","", "", "", "", "", "", "")
	}

	@When("seleciono o tipo de contribuinte Colectivo - Instituição Pública")
	def selecionar_o_tipo_de_contribuinte_colectivo_instituicao_publica() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO", "INSTITUIÇÃO PÚBLICA", "", "", "")
	}

	@Then("verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Instituição Pública")
	def verificar_formulario_outros_detalhes_contribuinte_colectivo_instituicao_publica() {
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", "", "", "", "", "", "", "", "", " ", "", "", "", "", "", "", "", "", "", "",
				"","", "", "", "", "", "", "")
	}

	@When("seleciono o tipo de contribuinte Colectivo - Organismo Internacional")
	def selecionar_o_tipo_de_contribuinte_colectivo_organismo_internacional() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO", "ORGANISMO INTERNACIONAL", "", "", "")
	}

	@Then("verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Organismo Internacional")
	def verificar_formulario_outros_detalhes_contribuinte_colectivo_organismo_internacional() {
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", "", "", "", "", "", "", "", "", " ", "", "", "", "", "", "", "", "", "", "",
				"Estrangeiro","", "", "", "", "", "", "")
	}
	@And("preencho os dados do formulario para Colectivo Associação - Residente")
	def preencher_formulario_coletivo_associacao_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Instituição Pública - Residente")
	def preencher_formulario_coletivo_instituicao_publica_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Instituição Pública com Regime de IVA Sem Direito a Deduções")
	def preencher_formulario_coletivo_instituicao_publica_IVA_Sem_Deducoes_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "Outros", "Orgão Dependente (OD)", "")
		formulario.preencherInformacoesDeIVA(false, true, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Organismo Internacional - Residente")
	def preencher_formulario_coletivo_organismo_internacional_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "CONS", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Ministro", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Reciprocidade/pagamento")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("COLECTIVO","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Colectivo Organismo Internacional com Regime em IVA Com Direito a Deduções")
	def preencher_formulario_coletivo_organismo_internacional_IVA_Com_Deducoes_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Outra")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ORGANISMO INTERNACIONAL", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Associação com Regime em IVA Operações Mistas")
	def preencher_formulario_coletivo_associacao_IVA_operacoes_mistas_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Operações Mistas")
	def preencher_formulario_coletivo_empresa_IVA_operacoes_mistas() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Associação Obrigado a Cativar IVA")
	def preencher_formulario_coletivo_associacao_IVA_Cativo_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherInformacoesDeIVA(false, false, false, true, "Banco Nacional de Angola", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Associação com Regime em IVA Com Direito a Deduções")
	def preencher_formulario_coletivo_associacao_IVA_Com_Deducoes_residente() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho o formulário para Contribuinte - Instituição Publica - Residente com Regime de IVA - Operações Mistas")
	def preencher_formulario_coletivo_instituicao_publica_IVA_operacoes_mistas() {
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Não", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
	}

	@And("preencho os dados do formulario para Colectivo Organismo Internacional com Regime de IVA Cativo")
	def preencher_formulario_coletivo_organismo_internacional_iva_cativo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal("Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Reciprocidade/isenção")
		formulario.preencherInformacoesDeIVA(false, false, false, true, "Autarquia Local", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Instituição Publica Obrigado a Cativar IVA")
	def preencher_formulario_coletivo_instituicao_publica_residente_IVA_cativo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "A")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Obrigado a cativar o IVA")
	def preencher_formulario_coletivo_empresa_obrigado_IVA_cativo() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, false, true, "Autarquia Local", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Com direito a deduções")
	def preencher_formulario_coletivo_empresa_IVA_com_direito_deducoes() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Organismo Internacional com Regime em IVA - Operações Mistas")
	def preencher_formulario_coletivo_organismo_internacional_IVA_operacoes_mistas() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Outra")
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ORGANISMO INTERNACIONAL", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Instituição Pública com Regime de II - Regime Geral")
	def preencher_formulario_coletivo_instituicao_publica_residente_regime_II_regime_geral() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral", "")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}



	@And("preencho os dados do formulario para Colectivo Empresa com Regime de II - Regime Geral")
	def preencher_formulario_coletivo_empresa_residente_regime_II_regime_geral() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}


	@And("preencho os dados do formulario para Colectivo Organismo Internacional com Regime de II - Regime Geral")
	def preencher_formulario_coletivo_organismo_internacional_residente_regime_II_regime_geral() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("ORGANISMO INTERNACIONAL", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Reciprocidade/isenção")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Organismo Internacional com Regime de II - Regime Geral Sector Financeiro")
	def preencher_formulario_coletivo_organismo_internacional_residente_regime_II_regime_geral_sector_financeiro() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral (Sector Financeiro)", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("ORGANISMO INTERNACIONAL", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Reciprocidade/isenção")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Associação com Regime de II - Regime Geral")
	def preencher_formulario_coletivo_associacao_residente_regime_II_regime_geral() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("ASSOCIAÇÃO", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Mecenato (beneficiário)", "", "", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Organismo Internacional com Regime de II - Simplificado")
	def preencher_formulario_coletivo_empresa_organismo_internacional_regime_II_regime_simplificado() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Outra")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime de Exclusão", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ORGANISMO INTERNACIONAL", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}


	@And("preencho os dados do formulario para Colectivo Residente Empresa - Regime de II - Regime Geral - Sector Financeiro")
	def preencher_formulario_coletivo_empresa_residente_regime_II_regime_geral_Sector_Financeiro() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral (Sector Financeiro)", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}


	@And("preencho os dados do formulario para Colectivo Empresa com Regime de II - Regime Simplificado")
	def preencher_formulario_coletivo_empresa_residente_regime_II_regime_Simplificado() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime de Exclusão", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}


	@And("preencho os dados do formulario para Colectivo Associação - Residente - Regime de II - Regime Geral - Sector Financeiro")
	def preencher_formulario_coletivo_associacao_residente_regime_II_regime_geral_sector_financeiro() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral (Sector Financeiro)", "")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Instituição Pública com Regime de II - Regime Geral Sector Financeiro")
	def preencher_formulario_coletivo_instituicao_publica_residente_regime_II_regime_geral_sector_financeiro() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Geral (Sector Financeiro)", "")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}

	@And("preencho os dados do formulario para Colectivo Associação com Regime de II - Simplificado")
	def preencher_formulario_coletivo_associacao_residente_regime_II_simplificado() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("ASSOCIAÇÃO", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Mecenato (beneficiário)", "", "", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime de Exclusão", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
	}


	@And("preencho os dados do formulario para Trabalhador por conta própria - Residente IRT B")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IRT_B() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria com IVA Regime Geral")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_geral() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "3500000.00", "5000000.00", "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}
	@And("preencho os dados do formulario para Colectivo Instituição Pública com Regime Simplificado de II")
	def preencher_formulario_coletivo_instituicao_publica_regime_Simplificado_II() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "Regime Simplificado", "")
	}

	@Then("valido a mensagem de exceção para a instituição pública em regime simplificado de II")
	def validar_mensagem_excecao_instituicao_publica_simplicado_II() {
		formulario.validarRegraInstituicoesPublicasRegimeSimplificado()
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria com IVA Regime Simplificado tendo em conta a regra do Volume de Negocio")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Simplificado_com_base_no_Volume_de_Negocio() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Simplificado", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "7800000", "2300000", "Anual")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@Then("preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime Simplificado respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Simplificado_com_base_no_Volume_de_Negocios1() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Simplificado", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "7800000.00", "2300000.00", "Anual")
	}

	@Then("preencho o volume de negocio resultando abaixo de dez milhoes num formulario de um Trabalhador por conta própria com IVA Regime Simplificado nao respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Simplificado_com_base_no_Volume_de_Negocios2() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Simplificado", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "7800000.00", "2200000.00", "Anual")
	}

	@Then("preencho o volume de negocio resultando acima de trezentos e cinquenta milhoes formulario de um Trabalhador por conta própria com IVA Regime Simplificado nao respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Simplificado_com_base_no_Volume_de_Negocios3() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Simplificado", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "339000000.00", "1200000.00", "Anual")
	}

	@Then("preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime Geral respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Geral_com_base_no_Volume_de_Negocios1() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "300000000.00", "51000000.00", "Anual")
	}

	@And("preencho os dados do formulario para Trabalhador por conta própria com IVA Regime Geral tendo em conta a regra do Volume de Negocio")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Geral_com_base_no_Volume_de_Negocio() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "300000000.00", "51000000.00", "Anual")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
	}

	@Then("preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime de Exclusão respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Exclusao_com_base_no_Volume_de_Negocios1() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime de Exclusão", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "78000.00", "21000.00", "Anual")
	}

	@Then("preencho o volume de negocio resultando abaixo de dez milhoes num formulario de um Trabalhador por conta própria com IVA Regime de Exclusão nao respeitando a regra do OGE")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA_Regime_Exclusao_com_base_no_Volume_de_Negocios2() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime de Exclusão", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "350000.00", "20000.00", "Anual")
	}


	@And("preencho os dados do formulario para Trabalhador por conta própria com IVA")
	def preencher_formulario_trabalhador_conta_Propria_Residente_IVA() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "2500000.00", "1300000.00", "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.validarGravarEPublicarFormulario()
	}

	@And("altero o cadastro para origem oficiosa, operações mistas e regime de dedução Afetação real")
	def alterar_registo_para_operacoes_mistas_afetacao_real() {
		formulario.preencherDetalhesDoRegisto("", "", "Oficiosa", "", "Outro")
		formulario.preencherInformacoesDeIVA(false, false, true, false, "", "Sim", "Sim", "Regime de Geral", " ", "Afectação Real", "Não Organizada", "", "", false, "Vazio", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("devo ver a mensagem Formulário verificado com êxito")
	def verificar_a_mensagem_formulario_verificado_com_exito() {
		formulario.validarVerificacaoDoFormularioComExito()
	}

	@And("pesquiso pelo NIF o formulário a ser alterado")
	def pesquisar_pelo_nif_o_formulario_a_ser_alterado() {
		consulta.pesquisaPorPessoa("", "", "", "NIF", "348923023")
		consulta.clicarNoResultadoDaPesquisa()
		formulario.acederMenuAlterarFormularioDeCadastro()
	}

	@And("acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado")
	def aceder_a_tela_consulta_de_formularios_de_cadastro() {
		home.clicarEmHome()
		consulta.pesquisarFormulario()
		consulta.pesquisaPorPessoa("", "", "", "NIF", variaveis.getNif())
		consulta.clicarNoResultadoDaPesquisa()
	}

	@And("verificar se regime de caixa esta disponivel para oficiosa")
	def verificar_regime_iva_de_caixa() {
		formulario.verificarDisponibilidadeRegimeIvaDeCaixa()
	}

	@And("faço a extração do numero do NIF")
	def extrair_o_numero_do_NIF_do_comprovativo_de_cadastro() {
		formulario.capturarNifDoFormularioCadastrado()
	}
	
	@And("pesquiso o contribuinte que foi cadastrado para fazer alteracao")
	def pesquisar_contribuinte_cadastrado_e_clicar_em_alterar() {
		sleep(50000)
		consulta.pesquisarFormulario()
		consulta.pesquisarPor("Pessoa", "Outro", dados.numeroDocumentoId, "", "", "", "", "", "", "", "", "", "", "", "","","")
		consulta.clicarNoResultadoDaPesquisa()
		formulario.acederMenuAlterarFormularioDeCadastro()
	}
	
	
	@And("preencho os dados do formulario em falta devido alteração de simples para Trabalhador por conta própria com IVA")
	def preencher_dados_em_falta_do_formulario_trabalhador_conta_Propria_Residente_IVA() {
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "2500000.00", "1300000.00", "Semestral")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("faço um cadastro de contribuinte Coletctivo Empresa - sem IVA")
	def cadastrar_contribuinte_coletivo_empresa_sem_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "", false)
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("altero o formulário cadastrado para Colectivo Empresa com IVA")
	def alterar_contribuinte_coletivo_empresa_sem_IVA_adicionando_IVA() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@Then("devo ver o estado {string}")
	def verificar_estado_da_alteracao(String estadoDaAlteracao) {
		formulario.verificarEstadoDaAlteracao(estadoDaAlteracao)
	}

	@And("faço um cadastro de contribuinte Singular Conta Própria - sem IVA")
	def cadastrar_contribuinte_singular_conta_propria_sem_IVA() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "2500000.00", "1300000.00", "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("faço um cadastro de contribuinte Singular Conta Própria - com IVA")
	def cadastrar_contribuinte_singular_conta_propria_com_IVA() {
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.selecionarTipoDeTrabalhadorPorContaPropria()
		formulario.iniciarRegimeIVA()
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherDadosActividade(true, true, "00032", dados.designacaoComercial, dados.dataInicio, "69200", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(true, "Estimativa", "2500000.00", "1300000.00", "Semestral")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteSingular("Outro", dados.numeroDocumentoId, dados.dataValidade, dados.dataEmissao, dados.descricao, "")
		formulario.preencherDetalhesContribuinteSingular(dados.primeiroNome, dados.ultimoNome, "Masculino", dados.dataNasc, "AO", dados.nifPaisNacionalidade, "AO", "LA", "LA#LUANDA", dados.nomePai, dados.nomeMae)
		formulario.preencherOutrosDetalhesdoContribuinteSingular("Solteiro", "")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", " ", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("altero o formulário cadastrado para Singular Conta Própria com IVA")
	def alterar_contribuinte_singular_conta_propria_sem_IVA_adicionando_IVA() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherDetalhesDoRegisto("SINGULAR","","Normal", "Residente", "")
		formulario.iniciarRegimeIVA()
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("altero e clico em cessar o regime de IVA sem informar o Motivo da suspensão")
	def cessar_regime_de_IVA() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.cessarRegimeIVA()
		formulario.preencherInformacoesDeIVAMotivoDeSuspensaoAtividadeIVA(" ", "")
	}

	@Then("visualizo a mensagem de exceção da sessão do para informar o Motivo de suspensão")
	def validar_mensagem_excecao_para_informar_motivo_de_suspensao_de_atividade_IVA() {
		formulario.validarMotivoDeSuspensaoAtividadeIVA()
	}

	@And("altero um ou mais campos do formulário cadastrado do Colectivo Empresa")
	def alterar_contribuinte_coletivo_empresa() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "", false)
		formulario.preencherEnquadramentoEmImpostos("", "", "C")
		formulario.preencherOutrasInformacoesIBAN(dadosAlteracao.IBAN, "BMF", dadosAlteracao.conta, dadosAlteracao.contaSwift)
		formulario.preencherInformacaoDeEndereco("LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dados.condominio, dados.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dadosAlteracao.descricao)
	}

	@And("faço um cadastro de contribuinte Colectivo Empresa - Com IVA")
	def cadastrar_contribuinte_colectivo_empresa_com_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendas, dados.prestacaoServico, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("faço um cadastro de contribuinte Coletivo Associacao - com IVA")
	def cadastrar_contribuinte_coletivo_associacao_com_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ASSOCIAÇÃO","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ASSOCIAÇÃO", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "Utilidade Pública", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("altero os dados do formulário cadastrado - Associacao - com IVA")
	def alterar_dados_do_formulario_cadastrado_associacao_com_IVA() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherOutrasInformacoesIBAN(dadosAlteracao.IBAN, "BMF", dadosAlteracao.conta, dadosAlteracao.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dadosAlteracao.numeroContacto, "", "", dadosAlteracao.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dadosAlteracao.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dadosAlteracao.autarquia, dadosAlteracao.localidade, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, "", dadosAlteracao.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ASSOCIAÇÃO", dadosAlteracao.denominacao, "LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.residenciaHabitual, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, dadosAlteracao.numeroDeTrabalhadoresAgencia, "Fixo", "", dadosAlteracao.numeroFixo, dadosAlteracao.email, dadosAlteracao.percentagemSocios, "")
	}

	@And("altero e clico em cessar o regime de IVA e informo o Motivo da suspensão")
	def cessar_regime_de_IVA_informando_o_motivo_da_suspensao() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.cessarRegimeIVA()
		formulario.preencherInformacoesDeIVAMotivoDeSuspensaoAtividadeIVA(dadosAlteracao.motivoSuspensaoAtividadeIVA, "")
	}
	@And("altero um ou mais campos do formulário cadastrado do Colectivo Instituição Pública")
	def alterar_contribuinte_coletivo_instituicao_publica() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "", false)
		formulario.preencherEnquadramentoEmImpostos("", "", "B")
		formulario.preencherOutrasInformacoesIBAN(dadosAlteracao.IBAN, "BMF", dadosAlteracao.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dadosAlteracao.numeroContacto, "", "", dadosAlteracao.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dadosAlteracao.descricao)
	}

	@And("faço um cadastro de contribuinte Colectivo Instituição Pública - Com IVA")
	def cadastrar_contribuinte_colectivo_instituicao_publica_com_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","INSTITUIÇÃO PÚBLICA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(true, "Com Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "PINT", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("INSTITUIÇÃO PÚBLICA", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "0", "100", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "Receitas próprias", "Unidade Orçamental (UO)", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherInformacoesDeIVA(true, false, false, true, "Autarquia Local", "Sim", "Não", "Regime Geral", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("INSTITUIÇÃO PÚBLICA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}


	@And("faço um cadastro de contribuinte Coletivo - Organismo Internacional - com IVA")
	def preencher_formulario_colectivo_organismo_internacional_com_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","ORGANISMO INTERNACIONAL","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "C")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "COOP", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("ORGANISMO INTERNACIONAL", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "Outra")
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Organizada", "Por Opção", dados.localidade, true, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ORGANISMO INTERNACIONAL", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}

	@And("altero os dados do formulário cadastrado - Organismo Internacional - com IVA")
	def alterar_formulario_colectivo_organismo_internacional_com_IVA() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherOutrasInformacoesIBAN(dadosAlteracao.IBAN, "BMF", dadosAlteracao.conta, dadosAlteracao.contaSwift)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dadosAlteracao.numeroContacto, "", "", dadosAlteracao.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dadosAlteracao.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dadosAlteracao.autarquia, dadosAlteracao.localidade, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.ruaAvLargo, dadosAlteracao.casa, dadosAlteracao.andar, "", dadosAlteracao.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("ORGANISMO INTERNACIONAL", dadosAlteracao.denominacao, "LA", dadosAlteracao.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dadosAlteracao.localidade, dadosAlteracao.bairro, dadosAlteracao.quarteirao, dadosAlteracao.condominio, dadosAlteracao.edificio, dadosAlteracao.residenciaHabitual, dadosAlteracao.casa, dadosAlteracao.andar, dadosAlteracao.codigoPostal, dadosAlteracao.localReferencia, dadosAlteracao.numeroDeTrabalhadoresAgencia, "Fixo", "", dadosAlteracao.numeroFixo, dadosAlteracao.email, dadosAlteracao.percentagemSocios, "")
	}

	@And("altero o formulário cadastrado para Colectivo Empresa de IVA - Regime Geral para Simplificado")
	def alterar_contribuinte_coletivo_empresa_de_IVA_Regime_Geral_para_Regime_Simplificado() {
		formulario.acederMenuAlterarFormularioDeCadastro()
		formulario.preencherOutrasInformacoesIBAN(dadosAlteracao.IBAN, "BMF", dadosAlteracao.conta, dadosAlteracao.contaSwift)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Não", "Regime Simplificado", "Renúncia ao Regime Simplificado", "", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
	}

	@And("preencho os dados do formulario para Colectivo Empresa com Regime Geral de IVA")
	def preencher_formulario_coletivo_empresa_Regime_Geral_IVA() {
		formulario.preencherDetalhesDoRegisto("COLECTIVO","EMPRESA","Normal", "Residente", "")
		formulario.preencherEnquadramentoEmImpostos("COLECTIVO", "", "B")
		formulario.preencherRepresentacaoFiscal(false, "Sem Representação Fiscal", "")
		formulario.preencherDetalhesIdentificacaoContribuinteColectivo("EMPRESA", "AO", "", dados.numeroRegistoComercial, dados.denominacao, dados.designacaoComercial, "RPOF", "", "Sim", "")
		formulario.preencherOutrosDetalhesDoContribuinteColectivo("", dados.publicadoDiarioRepublica, dados.numeroDiarioRepublica, dados.dataPublicacaoDiarioRepublica, dados.dataConstituicao, dados.capitalSocial, "100", "0", "0", "Vazio", dados.numeroDeTrabalhadoresAgencia, "", "Representante Legal", "Fixo", "", dados.numeroFixo, "", dados.email, "", "Administrador", "Telemóvel", "", dados.numeroTelemovel, dados.email, "", "", "", "")
		formulario.preencherDadosActividade(false, false, "", dados.designacaoComercial, dados.dataInicio, "09900", dados.numeroAlvara, "LA", "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.bairro, dados.residenciaHabitual, dados.localReferencia)
		formulario.preencherOutrasInformacoesVolumeDeNegocios(false, "Estimativa", dados.volumeVendasParaRegimeSimplificado, dados.prestacaoServicoParaRegimeSimplificado, "Semestral")
		formulario.preencherOutrasInformacoesIBAN(dados.IBAN, "BMF", dados.conta, dados.contaSwift)
		formulario.preencherInformacoesDeIVA(true, false, false, false, "", "Sim", "Sim", "Regime Geral", "Renúncia ao Regime Simplificado", "Pró Rata e Afectação Real", "Não Organizada", "", "", false, "", "Fixo", dados.numeroFixo, dados.numeroContabilistaOPCA, dados.email, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.numeroEstabelecimentoComercial)
		formulario.preencherIdentificacaoDosSocios("102457821ME0357", dados.percentagemSocios)
		formulario.preencherInformacaoDeContacto("","Estrangeiro", dados.numeroContacto, "", "", dados.email, "55", "55","")
		formulario.preencherInformacaoDeEndereco("LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, "LA#LUANDA#INGOMBOTA#04.01", dados.descricao)
		formulario.preencherInformacaoDeEnderecoAlternativas("DE", dados.autarquia, dados.localidade, dados.quarteirao, dados.condominio, dados.edificio, dados.ruaAvLargo, dados.casa, dados.andar, "", dados.codigoPostal)
		formulario.preencherIdentificacaoDeAgencias("EMPRESA", dados.denominacao, "LA", dados.autarquia, "LA#LUANDA", "LA#LUANDA#INGOMBOTA", dados.localidade, dados.bairro, dados.quarteirao, dados.condominio, dados.edificio, dados.residenciaHabitual, dados.casa, dados.andar, dados.codigoPostal, dados.localReferencia, dados.numeroDeTrabalhadoresAgencia, "Fixo", "", dados.numeroFixo, dados.email, dados.percentagemSocios, "")
		formulario.validarGravarEPublicarFormulario()
		variaveis.setNif(formulario.capturarNifDoFormularioCadastrado())
	}


}