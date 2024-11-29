package data.vocabulary

import data.vocabulary.PhrasalVerb.Companion.optionalReferrersOn
import data.vocabulary.PhrasalVerb.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Vocabulary(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Vocabulary>(Vocabularies)

    var engVocab by Vocabularies.engVocab
    var ipa by Vocabularies.ipa
    val partOfSpeeches by PartOfSpeech referrersOn PartOfSpeeches.vocabulary
    val phrasalVerbs by PhrasalVerb referrersOn PhrasalVerbs.vocabulary
}

class PartOfSpeech(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PartOfSpeech>(PartOfSpeeches)

    var partOfSpeech by PartOfSpeeches.partOfSpeech
    var vocabulary by Vocabulary referencedOn PartOfSpeeches.vocabulary
    val definitions by Definition optionalReferrersOn Definitions.partOfSpeech
}

class PhrasalVerb(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PhrasalVerb>(PhrasalVerbs)

    var phrasalVerb by PhrasalVerbs.phrasalVerb
    var vocabulary by Vocabulary referencedOn PhrasalVerbs.vocabulary
    val definitions by Definition optionalReferrersOn Definitions.phrasalVerb
}

class Definition(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Definition>(Definitions)

    var definition by Definitions.definition
    var partOfSpeech by PartOfSpeech optionalReferencedOn Definitions.partOfSpeech
    var phrasalVerb by PhrasalVerb optionalReferencedOn Definitions.phrasalVerb
    val examples by Example referrersOn Examples.definition
}

class Example(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Example>(Examples)

    var example by Examples.example
    var definition by Definition referencedOn Examples.definition
}