Feature: Funcionalidade de login

  Scenario: Login sem sucesso
    Given estou na página de login
    When Insiro um nome de usuário ou senha incorretos
    And Eu clico no botão de login
    Then Devo ver uma mensagem de erro
