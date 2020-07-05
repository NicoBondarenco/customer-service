package br.com.runnt.domain.model.entity.location

import br.com.runnt.domain.adapter.repository.location.CityRepository
import br.com.runnt.domain.adapter.repository.location.StateRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID


class State(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<State>(
        StateRepository
    )

    val name by StateRepository.name

    val acronym by StateRepository.acronym

    val cities by City referrersOn CityRepository.stateId

}