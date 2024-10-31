Feature: Liquidação e Pagamento de Documento de Cobrança
        Como técnico, devo ser capaz de liquidar um imposto e realizar seu pagamento manualmente

    Scenario: Criar Liquidação genérica de um imposto
        Given estou no formulário de liquidação
        When liquido imposto de selo - Arrendamento
        And clico no botão Verificar Formulario
        And vejo a mensagem de verificação do formulário
        And clico no botão Gravar
        And estado do formulário Pendente
        And clico no botão Validar
        And estado do formulário Pronto para Publicar
        And clico no botão Publicar
        And estado do formulário Publicado
        And vejo o numero da declaracao
        And estou na tela de pagamentos
        And preencho NIF de pagamento
        And pesquiso pelo Identificador do Documento
        And preencho método de pagamento
        And clico no botão Validar Pagamento
        When clico no botão Criar Pagamento
        Then vejo o estado do Pagamento Congelado