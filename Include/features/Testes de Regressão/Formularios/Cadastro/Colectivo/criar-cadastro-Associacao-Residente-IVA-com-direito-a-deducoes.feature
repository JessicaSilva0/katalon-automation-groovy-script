Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF colectivos Associação com regime de IVA com direito a deduções
    
  Background: 
  	Given realizo login no SIGT

  Scenario: Contribuinte Coletivo - Residente - Associação com Regime de IVA - Com direito a Dedução
 
    Given estou no formulário de Cadastro
		And preencho os dados do formulario para Associação com Regime de IVA - Com direito a Dedução
		When valido e publico o formulario
		Then imprimo o Comprovativo de Cadastro