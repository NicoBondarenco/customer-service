package br.com.runnt.domain.adapter.repository.customer

import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable


object GenderRepository :
    UUIDTable(name = "${Schema.SCHEMA_CUSTOMER}.${Schema.TABLE_GENDER}", columnName = Schema.COLUMN_ID) {

    val name = varchar("name", 50)
        .uniqueIndex("un_gender_name")

    val description = varchar("description", 2000)

}