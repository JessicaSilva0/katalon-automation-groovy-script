# Automação de testes SIGT


## Funcionalidades automatizadas
- Cadastro do contribuinte
- Validação de campos obrigatórios do cadastro de contribuinte
- Alteração dos dados do contribuinte

## Acesso ao projecto
Você pode [acessar o codigo fonte do projeto](http://10.129.106.146/qa-automation/Katalon-qa-automation-cadastro-de-contribuinte.git) ou [baixá-lo](http://10.129.106.146/qa-automation/Katalon-qa-automation-cadastro-de-contribuinte/repository/master/archive.zip)

## Tecnologias utilizadas
 - Katalon IDEA
 - Orientação a objectos
 - Groove
 - Java 8
 - JS
 - GIT
 - Navegadores(Chrome, Edge e Mozila) atualizados

## Manual de montagem de ambiente(Windows)
**1. Baixar ferramentas**
	
   - [Katalon Studio](https://backend.katalon.com/download-lastest-version?platform=win_64&type_download=kse_pe)
   - [GIT](https://github.com/git-for-windows/git/releases/download/v2.39.1.windows.1/Git-2.39.1-64-bit.exe_)(Versão mais atual)

**2. Instalando o Katalon**
	
    1. Após baixá-lo, abrir o arquivo .zip
	2. Extrair os arquivos em uma pasta desejada
	3. Executar o arquivo katalon.exe

**3. Clonando o projecto**

***Pré condições:***

*- Ter instalado o Katalon Studio e GIT*

*- Possuir acesso(user e password) no projecto no GITLAB*

  **(Opção 1)**



    1. Execute o arquivo katalon.exe para abrir a ferramenta
	2. No ícone de GIT, selecionar a opção "Clone Project"
	3. Inserir a URL do projecto(URL)
	4. Informar os dados de autenticação do GIT(User e Password)
	5. Acionar a opção "Next"
	6. Selecionar a Branch que deseja(default develop)
	7. Acionar a opção "Finish" 
 
**(Opção 2)**

	1. No explorador de arquivo do windows, crie uma pasta onde irá armazenar o código
	2. Dentro da pasta, clique com o botão direito e selecione a opção "GIT Bash Here"
	3. Digite o comando: git clone http://10.129.106.146/qa-automation/Katalon-qa-automation-cadastro-de-contribuinte.git
	4. Insira as credenciais do GITLAB(User e Password)
	5. Acione "OK" e aguarde até que seja finalizado o clone
	6. Finalizado o clone, execute o katalon.exe
	7. Com o Katalon aberto, no menu de ferramentas, acesse o "File > Open Project"
	8. Selecione a pasta onde foi feito o clone e pronto!

Use the package manager [pip](https://pip.pypa.io/en/stable/) to install foobar.

**4. Atualizando os drivers para execução**

	1. Com o Katalon aberto, no menu da ferramenta, busque por "Tools"
	2. Selecione o submenu "Update Webdrivers"
	3. Clique em cada driver que deseja atualizar

**5. Plug-in's essenciais**

1. Excel Keywords [Clique aqui para baixar](https://store.katalon.com/product/34/Excel-Keywords)


**6. Executando o primeiro teste**

	1. Acessar a pasta "Test Cases"
	2. Selecionar a pasta que contenha os cenários desejados
	3. Duplo clique no test case desejado
	3. No menu da ferramenta, selecionar a opção "Run" e selecionar o driver desejado para a execução(default Chrome)

