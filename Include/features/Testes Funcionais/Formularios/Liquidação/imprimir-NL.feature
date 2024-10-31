Feature: Liquidação de Impostos
    Como técnico, devo ser capaz de validar o formulário de liquidação

    Scenario: Clicar no botão 'Validar formulário' de Liquidação
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
        Then clico no botão Imprimir Nota de Liquidação
