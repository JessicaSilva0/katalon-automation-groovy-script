Feature: Cadastro do Contribuinte
    Como tester, quero garantir que os elementos do formulário de navegação "Outros Detalhes de Contribuinte Colectivo" são mapeados e validados conforme sua obrigatoriedade.
    
    Rule: 
    1 - Na secção Outros Detalhes de Contribuinte Colectivo, quando não informamos o tipo de contribuinte colectivo, o sistema não apresenta regras espeficificas
    2 - Na secção Outros Detalhes de Contribuinte Colectivo, quando informamos o tipo de contribuinte colectivo Associação, o sistema habilita o campo obrigatório "Segmento"
		3 - Na secção Outros Detalhes de Contribuinte Colectivo, quando informamos o tipo de contribuinte colectivo Instituição Pública, o sistema habilita os campos obrigatórios "Fonte de Receitas" e "Autonomia"
		4 - Na secção Outros Detalhes de Contribuinte Colectivo, quando informamos o tipo de contribuinte colectivo Organismo Internacional, o sistema habilita o campo obrigatório "Tipo de Tributação"
		

  Background: 
    Given realizo login no SIGT

  Scenario: Validação da obrigatoriedade de campos de Outros Detalhes de Contribuinte Colectivo
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo
    Then verifico o formulário sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo

  Scenario: Validação da obrigatoriedade de campos de Outros Detalhes de Contribuinte Colectivo - Colectivo Associação
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Associação
    Then verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Associação

  Scenario: Validação da obrigatoriedade de campos de Outros Detalhes de Contribuinte Colectivo - Colectivo Intituição Publica
    Given estou no formulário de Cadastro
   	When seleciono o tipo de contribuinte Colectivo - Instituição Pública
    Then verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Instituição Pública
    
 	Scenario: Validação da obrigatoriedade de campos de Outros Detalhes de Contribuinte Colectivo - Colectivo Organismo Internacional
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Organismo Internacional
    Then verifico o formulario sem preencher os campos obrigatórios da secção Outros Detalhes de Contribuinte Colectivo - Organismo Internacional    