package br.com.runnt.domain.adapter.repository.location

import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable


object StateRepository :
    UUIDTable(name = "${Schema.SCHEMA_LOCATION}.${Schema.TABLE_STATE}", columnName = Schema.COLUMN_ID) {

    val name = varchar("name", 200)
        .uniqueIndex("un_state_name")

    val acronym = varchar("acronym", 10)
        .uniqueIndex("un_state_acronym")

}