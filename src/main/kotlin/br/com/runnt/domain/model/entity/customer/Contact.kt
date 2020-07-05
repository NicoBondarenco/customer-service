package br.com.runnt.domain.model.entity.customer

import br.com.runnt.domain.adapter.repository.customer.ContactRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID


class Contact(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<Contact>(
        ContactRepository
    )

    val description by ContactRepository.description

    val observation by ContactRepository.observation

    val contactType by ContactType referencedOn ContactRepository.contactTypeId

    val customer by Customer referencedOn ContactRepository.customerId

}