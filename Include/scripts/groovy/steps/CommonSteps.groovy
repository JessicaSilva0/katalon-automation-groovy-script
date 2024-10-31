package steps

import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement;

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

/**Nome: commonSteps
 * Este script corresponde as funções comuns a todas as demais paginas.
 * Serão reutilizados sempre que necessário evitando duplicação de código.
 */
public class CommonSteps {
	static void clicarNoBotao(TestObject) {
		WebUI.click(TestObject)
	}


	static void selecionarMenuItem(TestObject) {
		WebUI.click(TestObject)
	}

	static void clicarNoBotaoEinserirTexto(TestObject, String Texto) {
		WebUI.click(TestObject)
		WebUI.setText(TestObject, Texto)
	}

	static void selecionarOpcao(TestObject, String value) {
		WebUI.click(TestObject)
		if (value == "Vazio" || value == " ") {
			WebUI.selectOptionByValue(TestObject, " ", false)
		}else {
			WebUI.selectOptionByValue(TestObject, value, false)
		}
	}

	static void selecionarOpcaoIndex(TestObject, Object) {
		WebUI.waitForPageLoad(5)
		WebUI.click(TestObject)
		WebUI.selectOptionByIndex(TestObject, Object)
	}

	static void inserirTexto(TestObject, String texto) {
		if (texto == "Vazio" || texto == " " || texto == ""){
			WebUI.setText(TestObject, "")
		}else {
			WebUI.setText(TestObject, texto)
		}
	}

	static void aguardarElementoVisivel(TestObject) {
		WebUI.waitForElementVisible(TestObject, 10)
	}

	static void duploCliqueNoBotao(TestObject) {
		WebUI.doubleClick(TestObject)
	}

	static void validarEstado(TestObject, String status) {
		WebUI.getText(TestObject).contains(status)
	}

	static void pegarNumeroDeclaracao(TestObject) {
		String numeroDeclaracao = WebUI.getText(TestObject)
		WebUI.setText(TestObject, numeroDeclaracao)
		println numeroDeclaracao
	}

	static void aguardarPagina(TestObject) {
		WebUI.waitForPageLoad(5)
		WebUI.waitForElementVisible(TestObject, 10)
	}

	static void aguardarCarregamentoPagina() {
		WebUI.waitForPageLoad(50)
	}

	static void copiarValordoCampo(TestObject) {
		WebUI.doubleClick(TestObject)
		WebUI.sendKeys(TestObject, Keys.chord(Keys.CONTROL, 'c'))
	}

	static void colarValornoCampo(TestObject) {
		WebUI.click(TestObject)
		WebUI.sendKeys(TestObject, Keys.chord(Keys.CONTROL, 'v'))
	}

	static void fecharNavegador() {
		WebUI.closeBrowser()
	}

	/**
	 * Use esta função para verificar se o paramatro passado está contido em uma lista de exceção(pegando todas as mensagens)
	 * @param TestObject
	 *       representa o elemento
	 * @param mensagem
	 *       representa a mensagem parametro para comparação
	 */
	static void validarListaExcecao(TestObject, String mensagem) {
		String lista = WebUI.getText(TestObject)
		boolean contemMensagem = false

		if (lista.contains(mensagem)) {
			contemMensagem = true
		}

		if (contemMensagem) {
			System.out.println("A lista contém a mensagem: " + mensagem)
		} else {
			System.out.println("A lista não contém a mensagem: " + mensagem)
			WebUI.verifyEqual(null, mensagem)
		}
	}

	static void selecionarCheckbox(TestObject) {
		WebUI.check(TestObject)
	}

	static void desmarcarCheckbox(TestObject) {
		WebUI.uncheck(TestObject)
	}

	/**
	 * Use esta função para verificar se um campo é clicável
	 * @param TestObject
	 *       representa o elemento
	 *
	 */
	static boolean verificarCampoClicavel(TestObject) {
		return WebUI.verifyElementClickable(TestObject)
	}

	/**
	 * Use esta função para verificar se um CheckBox está marcado
	 * @param TestObject
	 *       representa o elemento
	 *
	 */
	static boolean verificarCampoCheckBox(TestObject) {
		return WebUI.verifyElementChecked(TestObject, 0)
	}

	static void adicionarDocumento(TestObject) {
		WebUI.uploadFile(TestObject, 'Include/config/README.pdf')
	}

	static void screenshot() {
		WebUI.takeFullPageScreenshot("Screenshot/evidencia.png")
	}

	static void abrirComprovativo(String nomeDaTela) {
		WebUI.switchToWindowTitle(nomeDaTela)
		WebUI.waitForPageLoad(5)
		screenshot()
	}

	static boolean verificarElementoVisivel(TestObject) {
		WebUI.verifyElementVisible(TestObject)
	}

	static void fecharAlerta() {
		if(WebUI.verifyAlertPresent(5)) {
			WebUI.acceptAlert()
		}else {
			WebUI.refresh()
		}
	}




	/**
	 * Use esta função para verificar se um elemento é encontrado num campo de seleção
	 *       elemento - representa o item a ser procurado
	 *       TestObject - representa o campo de seleção
	 */
	static boolean verificarElementoNoCampoDeSelecao(TestObject, String elemento) {

		WebUI.click(TestObject)

		List<WebElement> opcoes = WebUiCommonHelper.findWebElements(TestObject, 30)

		boolean elementoExiste = false

		for (WebElement opcao : opcoes) {
			if (opcao.getText() == elemento) {
				elementoExiste = true
				break
			}
		}

		if (elementoExiste == false) {
			return true;
		}
	}



	static void verificarElementoPresente(TestObject) {
		WebUI.verifyElementPresent(TestObject, 10)
	}
}