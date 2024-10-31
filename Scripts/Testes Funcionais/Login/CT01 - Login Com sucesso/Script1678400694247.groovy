import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

/*
 Feature: Funcionalidade de login
 
   Scenario: Login realizado com sucesso
	 Given estou na página de login
	 When Eu insiro meu nome de usuário e senha
	 And Eu clico no botão de login
	 Then Devo ver a página Inicial
 
 */
 
 'Como usuário, quero aceder o SIGT com as credenciais válidas'
 CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Login/login-sucesso.feature')
