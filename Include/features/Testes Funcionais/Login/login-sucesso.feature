Feature: Funcionalidade de login

  Scenario: Login realizado com sucesso
    Given estou na página de login
    When Eu insiro meu nome de usuário e senha
    And Eu clico no botão de login
    Then Devo ver a página Inicial
