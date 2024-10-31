Feature: Liquidação e Pagamento de Documento de Cobrança
                    Como técnico, devo ser capaz de liquidar um imposto e realizar seu pagamento manualmente
    Scenario: Efectuar Pagamento do imposto
        Given estou na tela de pagamentos
        And preencho NIF de pagamento
        And pesquiso pelo Identificador do Documento