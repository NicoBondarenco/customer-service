package br.com.runnt.domain.adapter.repository.customer

import br.com.runnt.domain.constant.Schema
import br.com.runnt.domain.model.BiologicalGender
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.`java-time`.date
import org.jetbrains.exposed.sql.`java-time`.timestamp
import java.time.OffsetDateTime
import java.time.ZoneOffset


object CustomerRepository :
    UUIDTable(name = "${Schema.SCHEMA_CUSTOMER}.${Schema.TABLE_CUSTOMER}", columnName = Schema.COLUMN_ID) {

    val firstName = varchar("first_name", 150)
        .index("idx_customer_first_name")

    val lastName = varchar("last_name", 150)
        .index("idx_customer_last_name")

    val documentNumber = varchar("document_number", 50)
        .nullable()

    val taxId = varchar("tax_id", 50)
        .uniqueIndex("un_customer_tax_id")

    val birthDate = date("birth_date")
        .nullable()

    val mainEmail = varchar("main_email", 250)
        .uniqueIndex("un_customer_main_email")

    val phoneNumber = varchar("phone_number", 50)

    val isWhatsapp = bool("is_whatsapp")

    val createdAt = timestamp("created_at")
        .default(OffsetDateTime.now(ZoneOffset.UTC).toInstant())

    val isActive = bool("is_active")

    val activationDate = timestamp("activation_date")
        .nullable()

    val activationToken = varchar("activation_token", 250)

    val biologicalGender = enumeration("biological_gender", BiologicalGender::class)

    val genderId = reference("gender_id", GenderRepository, fkName = "fk_customer_gender", onDelete = ReferenceOption.RESTRICT)

    init {
        index(
            customIndexName = "un_customer_phone_number", isUnique = true, columns = *arrayOf(
                phoneNumber,
                isActive
            )
        )
    }

}