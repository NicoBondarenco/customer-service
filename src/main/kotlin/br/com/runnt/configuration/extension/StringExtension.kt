package br.com.runnt.configuration.extension

import java.util.UUID

fun String.toUUID() = UUID.fromString(this)