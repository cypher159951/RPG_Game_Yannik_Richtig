open class Held(var name: String, var leben: Int) {

    open fun angreifen(boss: Boss) {
    }

    open fun heilen(held: Held) {
    }

    open fun schaden(schaden: Int) {                                            //schaden am Helden vom drake
        leben = leben - schaden                           //hilfe vom Tutor       schaden wird am Helden abgezogen
        if (leben <= 0) {                                                       //leben wird akutalisiert solange größer als 0 HP
            leben = 0
        }
        println("${name} erleidet ${schaden} und hat noch ${leben} Leben")      //Text mit Infos ausgeben
    }



    var beutelGezogen = false                                                   //überprüft ob der Beutel schon einmal benutzt wurde

    open fun beutel(held: Held) {
    }

    open fun vitamine(held: Held) {
    }
}