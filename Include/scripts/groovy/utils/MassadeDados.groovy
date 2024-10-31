package utils

import com.github.javafaker.Faker
import java.time.LocalDate
import java.time.format.DateTimeFormatter;

public class MassadeDados {

	Faker faker = new Faker(new Locale("pt-BR"));
	def formatoData = new java.text.SimpleDateFormat("dd-MM-yyyy")
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	String numeroDocumentoId = faker.number().digits(13).toString();
	String IBAN = faker.number().digits(30).toString();
	String conta = faker.number().digits(5).toString();
	String contaSwift = faker.number().digits(10).toString();

	String designacaoComercial = faker.company.name();
	String dataInicio =  formatoData.format(faker.date().birthday());
	String dataVinculo =  formatoData.format(faker.date().birthday());
	String numeroAgente = faker.number().digits(5).toString()
	String dataEmissao = formatoData.format(faker.date().birthday());
	String dataValidade = LocalDate.now().plusWeeks(200).format(dateTimeFormatter);
	String bairro = faker.address().cityName();
	String residenciaHabitual = faker.address().streetAddress();
	String localidade = faker.address().cityName();
	String quarteirao = faker.address().cityName();
	String condominio = faker.address().cityName();
	String edificio = faker.address().cityName();
	String casa = faker.address().cityName();
	String andar = faker.address().cityName();
	String localReferencia = faker.address().streetAddress();
	String codigoPostal = faker.address().zipCode();
	String ruaAvLargo = faker.address().cityName();
	String autarquia = faker.address().streetName();
	String numeroAlvara =  faker.number().digits(12).toString();
	String descricao = faker.funnyName().name();
	String funcao = faker.company.profession();
	String primeiroNome = faker.name().firstName();
	String ultimoNome = faker.name().lastName();
	String dataNasc = formatoData.format(faker.date().birthday());
	String nifPaisNacionalidade = faker.number().digits(13).toString();
	String nomePai = faker.name().fullName();
	String nomeMae = faker.name().fullName();
	String numeroContacto = faker.phoneNumber().cellPhone();
	String email = faker.internet().emailAddress();
	String volumeVendas = faker.commerce().price();
	String volumeVendasParaRegimeSimplificado = faker.commerce().price(5000000, 9900000);
	String prestacaoServico = faker.commerce().price();
	String prestacaoServicoParaRegimeSimplificado = faker.commerce().price(1000000, 9900000);
	String percentagemSocios = faker.number().numberBetween(100, 100).toString();
	String numeroRegistoComercial = faker.number().digits(12).toString();
	String denominacao = faker.company().name();
	String numeroDeTrabalhadoresAgencia = faker.number().numberBetween(1, 1000).toString();
	String dataConstituicao = formatoData.format(faker.date().birthday());
	String enderecoWeb = faker.internet().url()
	String numeroEstabelecimentoComercial = faker.number().digits(10).toString();
	String numeroContabilistaOPCA = faker.number().digits(30).toString();
	String numeroFixo = faker.numerify('214######');
	String numeroTelemovel = faker.numerify('913######');
	String publicadoDiarioRepublica = faker.company.name();
	String numeroDiarioRepublica = faker.number().digits(20).toString();
	String dataPublicacaoDiarioRepublica = formatoData.format(faker.date().birthday());
	String capitalSocial = faker.commerce().price(10000, 99000);
	String motivoSuspensaoAtividadeIVA = faker.lorem.paragraph()
	
}
