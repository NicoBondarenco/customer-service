package br.com.runnt.domain.adapter.repository.customer

import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable


object ContactTypeRepository :
    UUIDTable(name = "${Schema.SCHEMA_CUSTOMER}.${Schema.TABLE_CONTACT_TYPE}", columnName = Schema.COLUMN_ID) {

    val name = varchar("name", 50)
        .uniqueIndex("un_contact_type_name")

}