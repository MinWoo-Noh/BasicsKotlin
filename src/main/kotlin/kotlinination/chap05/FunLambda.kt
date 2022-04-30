package kotlinination.chap05

fun printMessagesWithPrefix (message : Collection<String>, prefix : String){
    message.forEach{
        println("$prefix $it")
    }
}