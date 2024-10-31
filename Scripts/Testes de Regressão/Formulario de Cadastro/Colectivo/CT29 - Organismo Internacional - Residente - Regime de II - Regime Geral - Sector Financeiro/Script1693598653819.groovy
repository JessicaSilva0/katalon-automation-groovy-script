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
    Como técnico, devo ser capaz de publicar o formulário de cadastro e imprimir os comprovativos de Cadastro

  Background: 
    Given realizo login no SIGT
    
  Scenario: Cadastro de Contribuinte Colectivo Residente Organismo Internacional - Regime de II - Regime Geral Sector Financeiro

    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Organismo Internacional com Regime de II - Regime Geral Sector Financeiro
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
    
 */


'Como técnico, devo ser capaz de criar Contribuinte Coletivo - Residente - Organismo Internacional com Regime de II - Regime Geral - Sector Financeiro'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Organismo-Internacional-Regime-de-II-com-Regime-geral-sector-financeiro.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()