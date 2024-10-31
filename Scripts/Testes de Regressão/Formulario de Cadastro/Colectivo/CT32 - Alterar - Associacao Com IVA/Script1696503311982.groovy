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
    Como técnico, quero garantir que o sistema permite efetuar alteração de um Cadastro de Contribuinte - Coletivo - Associação com IVA de forma esperada.

  Background: 
    Given realizo login no SIGT

  Scenario: Alterar um Cadastro de Contribuinte Coletivo Associacao com IVA
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Coletivo Associacao - com IVA
   	And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero os dados do formulário cadastrado - Associacao - com IVA
    When valido e publico o formulario
   	Then imprimo o Comprovativo de Cadastro
 */


'Como técnico, quero garantir que o sistema permite efetuar alteração de um Cadastro de Contribuinte - Coletivo - Associação com IVA de forma esperada.'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/alterar-cadastro-Associacao-Com-IVA.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()