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

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/*
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
     Rule: 
    1 - Validação dos campos obrigatórios sem condicionais
    2 - Na secção Detalhes de Contribuinte Singular ao selecionar os campos Pais Nacionalidade(Diferente de Angola) e Pais Naturalidade(Igual a Angola), os campos "Nif do País de Nacionalidade", "Província" e "Município" passam a ser obrigatórios

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Detalhes de Contribuinte Singular - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Detalhes de Contribuinte Singular
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Detalhes de Contribuinte Singular
    
   Scenario: Singular - Detalhes de Contribuinte Singular - Validação da obrigatoriedade dos campos Pais Nacionalidade e Pais Naturalidade
    Given estou no formulário de Cadastro
    And preencho os campos Pais Nacionalidade diferente de Angola e Pais Naturalidade igual a Angola da secção Detalhes de Contribuinte Singular
    And não preencho os campos obrigatórios da secção Detalhes de Contribuinte Singular
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções dos campos Nif do País de Nacionalidade, Província e Município de Detalhes de Contribuinte Singular

 */

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Detalhes para Não Residentes'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Detalhes de Contribuinte Singular.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()