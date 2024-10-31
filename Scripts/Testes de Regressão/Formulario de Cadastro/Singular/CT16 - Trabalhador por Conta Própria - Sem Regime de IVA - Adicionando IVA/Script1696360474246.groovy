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

/**
 *Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de efetuar alteração de um Cadastro de Contribuinte Singular Conta Própria sem IVA - adicionando IVA

  Background: 
    Given realizo login no SIGT

  Scenario: Alterar um Cadastro de Contribuinte Singular Conta Própria sem IVA - adicionando IVA
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Singular Conta Própria - sem IVA
   	And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero o formulário cadastrado para Singular Conta Própria com IVA
    When valido e publico o formulario
   	Then devo ver o estado "Aguardando aprovação - Nível 1"

 */


'Como técnico, devo ser capaz de efetuar alteração de um Cadastro de Contribuinte Singular Conta Própria sem IVA - adicionando IVA'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Singular/alterar-cadastro-Singular-Conta-Propria-Sem-IVA-Adicionar-IVA.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()