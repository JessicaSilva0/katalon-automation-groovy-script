package steps
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import page.Pagamentos

public class PagamentoSteps {
	Pagamentos pagamento = new Pagamentos()
	
		@Given("estou na tela de pagamentos")
		def telaPagamentos() {
			pagamento.abrirMenuPagamentos()
		}
	
		@And("preencho NIF de pagamento")
		def criarPagamentosNIF() {
			pagamento.preencherNIF("NIF")
		}
	
		@And("preencho Itens de Liquidação")
		def itensDeLiquidacao() {
			pagamento.preencherItensdeLiquidacao()
		}
	
		@And("pesquiso pelo Identificador do Documento")
		def pesquisarIdentificadorDocumento() {
			pagamento.pesquisarDC()
		}
	
		@And("preencho método de pagamento")
		def metodoDePagamentos() {
			pagamento.preencherMetodoDePagamento()
		}
	
		@And("clico no botão Validar Pagamento")
		def validarPagamento() {
			pagamento.validarPagamento()
		}
	
		@When("clico no botão Criar Pagamento")
		def clicarNoBotaoCriarPagamento() {
			pagamento.criarPagamento()
		}
	
		@Then("vejo o estado do Pagamento Congelado")
		def estadoDoPagamento() {
			pagamento.validarEstadoPagamento("Congelado")
		}
}
