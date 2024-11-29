package data.vocabulary

import org.jetbrains.exposed.dao.id.IntIdTable

object Vocabularies : IntIdTable() {
    val engVocab = text("eng_vocab")
    val ipa = text("ipa").nullable()
}

object PartOfSpeeches : IntIdTable() {
    val vocabulary = reference("vocabulary_id", Vocabularies)
    val partOfSpeech = text("part_of_speech")
}

object PhrasalVerbs : IntIdTable() {
    val vocabulary = reference("vocabulary_id", Vocabularies)
    val phrasalVerb = text("phrasal_verb")
}

object Definitions : IntIdTable() {
    val partOfSpeech = reference("part_of_speech_id", PartOfSpeeches).nullable()
    val phrasalVerb = reference("phrasal_verb_id", PhrasalVerbs).nullable()
    val definition = text("definition")
}

object Examples : IntIdTable() {
    val example = text("examples").nullable()
    val definition = reference("definition_id", Definitions)
}
