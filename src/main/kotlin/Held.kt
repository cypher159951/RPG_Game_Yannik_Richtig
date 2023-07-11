open class Held(var name: String, var leben: Int) {

    open fun angreifen(boss: Boss) {
    }

    open fun heilen(held: Held) {
    }

    open fun schaden(schaden: Int) {                                                //schaden am Helden vom drake
        var aktualisiertesLeben = leben - schaden                                   //schaden wird am Helden abgezogen
        if (aktualisiertesLeben < 0.0) {                                            //leben wird akutalisiert solange größer als 0 HP
            aktualisiertesLeben = 0
        }
        println("${name} erleidet ${schaden} und hat noch ${leben}  Leben")         //Text mit Infos ausgeben
    }

    open fun beutel(held: Held) {
    }

    open fun vitamine(held: Held) {
    }

    open fun fähigkeitAusgefuehrt(held: Held) {                                 //Wird nicht benötigt
    }
}