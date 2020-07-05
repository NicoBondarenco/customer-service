package br.com.runnt.domain.model.entity.customer

import br.com.runnt.domain.adapter.repository.customer.ContactRepository
import br.com.runnt.domain.adapter.repository.customer.CustomerRepository
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class Customer(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<Customer>(CustomerRepository)

    val firstName by CustomerRepository.firstName

    val lastName by CustomerRepository.lastName

    val documentNumber by CustomerRepository.documentNumber

    val taxId by CustomerRepository.taxId

    val birthDate by CustomerRepository.birthDate

    val mainEmail by CustomerRepository.mainEmail

    val phoneNumber by CustomerRepository.phoneNumber

    val isWhatsapp by CustomerRepository.isWhatsapp

    val createdAt by CustomerRepository.createdAt

    val isActive by CustomerRepository.isActive

    val activationDate by CustomerRepository.activationDate

    val activationToken by CustomerRepository.activationToken

    val biologicalGender by CustomerRepository.biologicalGender

    val gender by Gender referencedOn CustomerRepository.genderId

    val contacts by Contact referrersOn ContactRepository.customerId

}