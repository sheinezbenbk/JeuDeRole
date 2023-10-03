package personnage

import item.Item
import jeu.TirageDes


class Arme(nom: String,
           description: String, // suppression de val car attribut importer de la classe Item
           val type: TypeArme,
           val qualité: Qualite,
           val degats: Int):Item(nom,description)   {

    fun calculerDegats(): Int {

        var degats = 0
        val deDegats = TirageDes(this.type.nombreDes, this.type.valeurDeMax)         //Initialisation du dé à utiliser pour les dégats
        val resultatDegats = deDegats.lance()           // Utilisation de la méthode lance() pour obtenir le résultat du lancé DEGATS
        val deCritique = TirageDes(1,20)      //Initialisation du dé à utiliser pour savoir si c'est un coup critique ou pas
        val resultatCritique = deCritique.lance()       // Utilisation de la méthode lance() pour obtenir le résultat du lancé CRITIQUE

        degats = resultatDegats


        if (resultatCritique > this.type.activationCritique) {
            degats = degats * 2
        }

        return degats
    }
    override fun utiliser(cible: Personnage) {
        //cible.equipe(this)
    }
}
