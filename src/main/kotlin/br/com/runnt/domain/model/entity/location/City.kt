package br.com.runnt.domain.model.entity.location

import br.com.runnt.domain.adapter.repository.location.CityRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID


class City(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<City>(
        CityRepository
    )

    val name by CityRepository.name

    val ibge by CityRepository.ibge

    val latitude by CityRepository.latitude

    val longitude by CityRepository.longitude

    val state by State referencedOn CityRepository.stateId

}