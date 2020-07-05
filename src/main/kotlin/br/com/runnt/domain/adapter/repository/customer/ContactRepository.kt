package br.com.runnt.domain.adapter.repository.customer

import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption


object ContactRepository :
    UUIDTable(name = "${Schema.SCHEMA_CUSTOMER}.${Schema.TABLE_CONTACT}", columnName = Schema.COLUMN_ID) {

    val description = varchar("description", 250)

    val observation = varchar("observation", 250).nullable()

    val contactTypeId = reference("contact_type_id", ContactTypeRepository, fkName = "fk_contact_contact_type", onDelete = ReferenceOption.RESTRICT)

    val customerId = reference("customer_id", CustomerRepository, fkName = "fk_contact_customer", onDelete = ReferenceOption.RESTRICT)

}