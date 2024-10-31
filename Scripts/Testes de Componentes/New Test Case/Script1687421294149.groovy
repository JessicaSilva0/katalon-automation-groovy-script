import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Singular - Trabalhador por conta própria - Identificação de Agências - Mapeamento de campos.feature')

'Sair do sistema após validação do formulário'
WebUI.closeBrowser()