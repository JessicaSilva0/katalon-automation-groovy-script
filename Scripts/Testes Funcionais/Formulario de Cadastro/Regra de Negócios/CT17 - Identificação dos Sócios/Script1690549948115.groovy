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
*    
Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
  
  
  1 - Na secção Identificação dos Sócios quando não informamos nenhum dos campos, o sistema apresenta uma validação geral "Identificação dos Sócios: Detalhes do Sócio requerido."
  2 - Na secção Identificação dos Sócios quando informamos apenas o campo Nº de Identificação, o sistema apresenta a validação "Identificação dos Sócios: Percentagem requerido."
  3 - Na secção Identificação dos Sócios quando informamos apenas o campo Percentagem, o sistema apresenta a validação "Identificação dos Sócios: Nº de Identificação requerido."

  Background: 
    Given realizo login no SIGT

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios"
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para os campos obrigatórios da secção Identificação dos Sócios não informados, devo visualizar mensagens de obrigatoriedade após veficar o formulário

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios" - Percentagem
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para o campo obrigatório Percentagem não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios" - Nº de Identificação
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para o campo obrigatório Nº de Identificação não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário

 */
'Como Técnico, quero ser capaz de realizar as validações de obrigatoriedade dos campos da secção Identificação dos Sócios'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Identificacao dos Socios.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()