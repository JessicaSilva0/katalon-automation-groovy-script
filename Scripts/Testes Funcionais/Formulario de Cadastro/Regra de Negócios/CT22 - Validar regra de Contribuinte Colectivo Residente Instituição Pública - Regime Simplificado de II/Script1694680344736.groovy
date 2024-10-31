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
Feature: Cadastro do Contribuinte

  Background: 
    Given realizo login no SIGT

  Scenario: Validar regra de Contribuinte Colectivo Residente INSTITUIÇÃO PÚBLICA - Regime Simplificado de II
    Given estou no formulário de Cadastro
    When preencho os dados do formulario para Colectivo Instituição Pública com Regime Simplificado de II
    Then valido a mensagem de exceção para a instituição pública em regime simplificado de II
*/

'Como Técnico, quero ser capaz de validar regra de Contribuinte Colectivo Residente INSTITUIÇÃO PÚBLICA - Regime Simplificado de II'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Validar Regra Instituicao Publica Regime Simplificado II.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
