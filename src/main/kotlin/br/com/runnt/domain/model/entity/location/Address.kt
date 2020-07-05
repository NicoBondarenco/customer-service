package br.com.runnt.domain.model.entity.location

import br.com.runnt.domain.adapter.repository.location.AddressRepository
import br.com.runnt.domain.model.entity.customer.Customer
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID


class Address(id: EntityID<UUID>) : UUIDEntity(id) {

    companion object : UUIDEntityClass<Address>(
        AddressRepository
    )

    val street by AddressRepository.street

    val number by AddressRepository.number

    val zipcode by AddressRepository.zipcode

    val complement by AddressRepository.complement

    val city by City referencedOn AddressRepository.cityId

    val customer by Customer referencedOn AddressRepository.customerId

}