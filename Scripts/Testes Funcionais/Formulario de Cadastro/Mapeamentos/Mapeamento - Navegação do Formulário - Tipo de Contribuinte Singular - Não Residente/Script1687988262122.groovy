import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Validação do Mapeamento da Navegação do Formulário - Tipo de Contribuinte Singular Não Residente'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Mapeamentos/Navegação do Formulário - Tipo de Contribuinte Singular - Não Residente.feature')

'Sair do sistema após validação do formulário'
WebUI.closeBrowser()