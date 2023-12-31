//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say at the moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)
fun main(args: Array<String>) {
    //Declarando el menu principal
    println("Hello, I'm the Kotlin 8 Ball. What do you want to do?\n" +
            "1. Ask a question\n" +
            "2. Check all answers\n" +
            "3. Exit")
    //leyendo la respuesta del usuario
    val inputValue = readLine()

    //funciones a executar segun la respuesta del usuario
    when(inputValue){
        "1"-> askQuestion()
        "2"-> checkAnswer()
        "3"-> exit()
        else-> showError()
    }
}
fun showError(){
    println("Parece que has elegido una opción no valida")
}
fun exit(){
    println("Hasta luego!")
}
fun askQuestion() {
    println("Which Question do you want do to check")
    readLine()
    println("umm that was your question... the answer to this is:")
    val answerGenerada = answers.keys.random()
    println(answerGenerada)
}
fun checkAnswer() {
    println("Selecciona una opción")
    println("1. Check all the answers")
    println("2. Check only affirmative answers")
    println("3. Check only doubtful answers")
    println("4. Check only negative answers")

    val opcionIngresada = readLine()
    when(opcionIngresada){
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = AFFIRMATIVE_ANSWER)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = DOUBTFUL_ANSWER)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = NEGATIVE_ANSWER)
        else -> println("Respuesta no valida. Adios.")
    }

}

fun mostrarRespuestasPorTipo(tipoDeRespuesta : String = "TODOS") {
    when(tipoDeRespuesta){
        "TODOS" -> answers.keys.forEach { respuesta -> println(respuesta) }
        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }

        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { respuestasDudosas -> println(respuestasDudosas.keys) }

        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { respuestasNegativas -> println(respuestasNegativas.keys) }
    }
}



