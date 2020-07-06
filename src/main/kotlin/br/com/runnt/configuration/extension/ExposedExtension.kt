package br.com.runnt.configuration.extension

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Function

infix fun <T : String?> ExpressionWithColumnType<T>.ilike(pattern: String): Op<Boolean> = ILikeOp(this, QueryParameter(pattern, columnType))

fun ExpressionWithColumnType<*>.countOver(): CountOver = CountOver(this)

class ILikeOp(expr1: Expression<*>, expr2: Expression<*>) : ComparisonOp(expr1, expr2, "ILIKE")

class CountOver(
    val expr: Expression<*>
) : Function<Long>(LongColumnType()) {
    override fun toQueryBuilder(queryBuilder: QueryBuilder): Unit = queryBuilder {
        +"COUNT("
        +expr
        +") OVER() as "
    }
}