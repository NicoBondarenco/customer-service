package br.com.runnt.domain.model.entity.customer

import br.com.runnt.domain.adapter.repository.customer.GenderRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class Gender(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<Gender>(GenderRepository)

    val name by GenderRepository.name

    val description by GenderRepository.description

}