import data.vocabulary.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

const val fileName = "real.txt"

fun main() {
    Database.connect("jdbc:sqlite:vocabulary.sqlite", "org.sqlite.JDBC")
    transaction {
        SchemaUtils.create(Vocabularies, PartOfSpeeches, PhrasalVerbs, Definitions, Examples)
        val linesAfterPreProcessing = preprocessing()
        val vocabularyList = dataProcess(linesAfterPreProcessing)
        for(vocabularyItem in vocabularyList) {
            logVocabulary(vocabularyItem)
            addData(vocabularyItem)
        }
    }
}