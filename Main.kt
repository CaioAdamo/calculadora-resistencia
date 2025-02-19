//Criar uma calculadora de resistores
//O usuario vai informar quatro cores e o programa dara a asaida de qual o valor do resistor
//Dica: Usar a calculadora de qualquer site bom.
//Trabalhar com resistores de 4 faixas (4 cores)
// Vermelho, preto, vermelho, Dourado

fun saudacao(){
    println("--------CALCULADORA DE RESISTORES--------\nInforme as cores do resistor separadas por virgula:")
}

fun lerCoresInformadas(): List<String>{
    var coresStr: String = readLine()!!
    coresStr = coresStr.uppercase().replace(" ","")
    return coresStr.split(",")
}

fun obterValorCor(cor: String): Int{
    val valores = mapOf(
        "PRETO" to 0,
        "MARROM" to 1,
        "VERMELHO" to 2,
        "LARANJA" to 3,
        "AMARELO" to 4,
        "VERDE" to 5,
        "AZUL" to 6,
        "VIOLETA" to 7,
        "CINZA" to 8,
        "BRANCO" to 9,
        "OURO" to -1,
        "PRATA" to -2
    )
    return valores[cor]
}

fun calcularResistencia(cores: List<String>): Pair<Int, Double> {
    val primeiroDigito = obterValorCor(cores[0]) ?: 0
    val segundoDigito = obterValorCor(cores[1]) ?: 0
    val multiplicador = Math.pow(10.0, obterValorCor(cores[2])?.toDouble() ?: 0.0).toInt()

    val resistencia = (primeiroDigito * 10 + segundoDigito) * multiplicador

    val tolerancia = when (cores[3]) {
        "OURO" -> 5.0
        "PRATA" -> 10.0
        else -> 20.0
    }

    return Pair(resistencia, tolerancia)
}


fun main() {
    saudacao()

    val listaCores = lerCoresInformadas()
    if(listaCores.size == 4){
        val (resistencia, tolerancia) = calcularResistencia(listaCores)

        println("Valor da resistência: $resistencia ohms")
        println("Tolerância: ±$tolerancia%")
    }else{
        println("A quantidade de cores informadas deve ser 4")
    }
}