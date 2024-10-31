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
 * Feature: Cadastro do Contribuinte
	Como técnico, devo ser capaz de criar um NIF Colectivo Instituição Pública - Residente

  Background:
	Given realizo login no SIGT
	
  Scenario: Contribuinte Coletivo - Residente - Instituição Publica com Regime de IVA - Operações Mistas
	Given estou no formulário de Cadastro
	And seleciono o tipo de contribuinte Colectivo - Instituição Pública
	And preencho o formulário para Contribuinte - Instituição Publica - Residente com Regime de IVA - Operações Mistas
	When valido e publico o formulario
	Then imprimo o Comprovativo de Cadastro
 */


'Como técnico, devo ser capaz de criar um NIF Colectivo Instituição Pública - Residente'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Instituicao-Publica-IVA-operacoes-mistas.feature')