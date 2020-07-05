package br.com.runnt.domain.adapter.repository.location

import br.com.runnt.domain.adapter.repository.customer.CustomerRepository
import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption


object AddressRepository :
    UUIDTable(name = "${Schema.SCHEMA_LOCATION}.${Schema.TABLE_ADDRESS}", columnName = Schema.COLUMN_ID) {

    val street = varchar("street", 250)

    val number = varchar("number", 25)

    val zipcode = varchar("zipcode", 25)

    val complement = varchar("complement", 50).nullable()

    val cityId = reference("city_id", CityRepository, fkName = "fk_address_city", onDelete = ReferenceOption.RESTRICT)

    val customerId = reference("customer_id", CustomerRepository, fkName = "fk_address_customer", onDelete = ReferenceOption.RESTRICT)

}