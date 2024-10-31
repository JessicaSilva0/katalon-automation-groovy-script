package steps

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import page.FormularioLiquidacao

public class FormularioLiquidacaoSteps {
	FormularioLiquidacao formulario = new FormularioLiquidacao()


	@Given("estou no formulário de liquidação")
	def irPara_MenuFormulario_Liquidacao() {
		formulario.abrirFormulario()
		formulario.adicionarFormulario()
	}

	@When("liquido imposto de selo - Arrendamento")
	def inserir_dados_formulario() {
		formulario.preencherDetalhesDoContribuinte("NIF")
		formulario.preencherDetalhesDoImposto("A", "F75", "Voluntaria", "Autoliquidacao", "Definitiva", "Semestral", "2023", "1Semestre")
		formulario.preencherDocumentoAssociado()
		formulario.preencherOrigemDoFactoTributario("BENGO", "AMBRIZ")
		formulario.preencherMontantePagar()
	}

	@And("clico no botão Verificar Formulario")
	def verificar_formulario() {
		formulario.verificarFormulario()
	}

	@And("clico no botão Gravar")
	def gravar_formulario() {
		formulario.gravarFormulario()
	}

	@And("clico no botão Validar")
	def validar_formulario() {
		formulario.validarFormulario()
	}

	@And("clico no botão Publicar")
	def publicar_formulario() {
		formulario.publicarFormulario()
	}

	@Then("clico no botão Imprimir Nota de Liquidação")
	def imprimir_formulario() {
		formulario.imprimirNotaLiquidacao()
	}

	@And("estado do formulário Pendente")
	def estado_pendente() {
		formulario.verificarEstadoFormulario("Pendente")
	}

	@And("estado do formulário Pronto para Publicar")
	def estado_prontoPublicar() {
		formulario.verificarEstadoFormulario("Pronto para Publicar")
	}

	@And("estado do formulário Publicado")
	def estado_publicado() {
		formulario.verificarEstadoFormulario("Publicado")
	}

	@And("vejo o numero da declaracao")
	def declaracao_formulario() {
		formulario.copiarNumeroDeclaracao()
	}

	@And("vejo a mensagem de verificação do formulário")
	def validarMensagem_formulario() {
		formulario.validarMensagemListaExcecoes("Formulário verificado com êxito.")
	}
}
