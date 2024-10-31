import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import steps.CommonSteps as step
/*
 * Feature: Cadastro do Contribuinte
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

 */

'Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Outros Detalhes de Contribuinte Colectivo.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()