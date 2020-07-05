package br.com.runnt.domain.model.entity.customer

import br.com.runnt.domain.adapter.repository.customer.ContactTypeRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class ContactType(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<ContactType>(
        ContactTypeRepository
    )

    val name by ContactTypeRepository.name

}