package data.film


import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object StarWarsFilms : IntIdTable() {
    val name = varchar("name", 50)
    val director = varchar("director", 50)
}

object Players : IntIdTable() {
    val filmId = reference("film_id", StarWarsFilms)
    val name = varchar("name", 50)
}

object Users: IntIdTable() {
    val name = varchar("name", 50)
}

object UserRatings: IntIdTable() {
    val value = long("value")
    val film = reference("film", StarWarsFilms)
    val user = reference("user", Users)
}

object Actors: IntIdTable() {
    val firstname = varchar("firstname", 50)
    val lastname = varchar("lastname", 50)
}

object StarWarsFilmActors : Table() {
    private val starWarsFilm = reference("starWarsFilm", StarWarsFilms)
    private val actor = reference("actor", Actors)
    override val primaryKey = PrimaryKey(starWarsFilm, actor)
}