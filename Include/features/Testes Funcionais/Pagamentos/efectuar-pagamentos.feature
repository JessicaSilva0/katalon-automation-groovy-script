## Este cenário de teste cria para o NIF informado um pagamento de acordo com o numero do documento selecionado.
## Existem duas formas de selecionar a DC (via combobox ou via pesquisa)
Feature: Pagamentos
              Como técnico, devo ser capaz de criar pagamentos no SIGT

    Scenario: Efectuar Pagamento de um Documento de cobrança
        Given estou na tela de pagamentos
        And preencho NIF de pagamento
        And preencho Itens de Liquidação
        And preencho método de pagamento
        And clico no botão Validar Pagamento
        When clico no botão Criar Pagamento
        Then vejo o estado do Pagamento Congelado

