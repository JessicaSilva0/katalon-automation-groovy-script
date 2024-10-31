Feature: Cadastro do Contribuinte
    Como técnico, quero garantir que ao alterar um contribuinte com regime Afectação real, este deverá ter Operações Mistas e um registo de origem Oficiosa

  Background: 
    Given realizo login no SIGT

  Scenario: Garantir que contribuintes com o tipo de regime Afectação real tenham Operações Mistas e origem de Registo Oficiosa
    Given estou na consulta do formulário de Cadastro
    And pesquiso pelo NIF o formulário a ser alterado
    And altero o cadastro para origem oficiosa, operações mistas e regime de dedução Afetação real
   	When clico no botão Verificar Formulario do Cadastro
    Then devo ver a mensagem Formulário verificado com êxito