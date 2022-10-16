class Feed(
	val films: List<Film>,
	val attributes: List<Attribute>,
)
class Film(val id: String)
class Attribute(val code: String)
fun f() {
	@Suppress("UNUSED_VARIABLE")
	val feed1: Feed = generateSequence { Feed(emptyList(), emptyList()) }
		.first { feed2 ->
			val uniqueFilms = feed2.films.isEmpty()
			val uniqueFilms2 =
				feed2.films.map(Film::id).isEmpty()
			val uniqueAttributes =
				feed2.attributes.map(Attribute::code)
					.isEmpty()
			uniqueFilms && uniqueFilms2 && uniqueAttributes
		}
}
