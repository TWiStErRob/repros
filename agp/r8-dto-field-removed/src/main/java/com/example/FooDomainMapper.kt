package com.example

class FooDomainMapper {
	fun map(dto: FooDTO): FooDomain {
		return FooDomain(
			dto.name,
			dto.position.latitude,
			dto.position.longitude
		)
	}
}
