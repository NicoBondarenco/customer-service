package br.com.runnt.domain.adapter.repository.location

import br.com.runnt.domain.constant.Schema
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption


object CityRepository :
    UUIDTable(name = "${Schema.SCHEMA_LOCATION}.${Schema.TABLE_CITY}", columnName = Schema.COLUMN_ID) {

    val name = varchar("name", 250)

    val ibge = varchar("ibge", 50)

    val latitude = decimal("latitude", 25, 20)

    val longitude = decimal("longitude", 25, 20)

    val stateId = reference("state_id", StateRepository, fkName = "fk_city_address", onDelete = ReferenceOption.RESTRICT)

}