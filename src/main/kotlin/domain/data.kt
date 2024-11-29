package domain

data class Vocabulary(
    var engVocab: String? = null,
    var ipa: String? = null,
    var partOfSpeeches: List<PartOfSpeech> = emptyList<PartOfSpeech>().toMutableList(),
    var phrasalVerbs: List<PhrasalVerb> = emptyList<PhrasalVerb>().toMutableList()
)

data class PartOfSpeech(
    var partOfSpeech: String? = null,
    var definitions: List<Definition> = emptyList<Definition>().toMutableList()
)

data class PhrasalVerb(
    var phrasalVerb: String? = null,
    var definitions: List<Definition> = emptyList<Definition>().toMutableList()
)

data class Definition(
    var definition: String? = null,
    var examples: List<String> = emptyList<String>().toMutableList()
)