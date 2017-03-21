package ch.tutteli.assertk.assertions

/**
 * Represents an `is a` assertion for a given `subject` and `clazz`.
 */
class IsAAssertion<T>(subject: Any, clazz: Class<T>) : IOneMessageAssertion {
    override val message by lazy {
        Message(MESSAGE_DESCRIPTION, clazz, clazz.isAssignableFrom(subject::class.java))
    }

    override fun toString() = message.toString()

    companion object {
        internal const val MESSAGE_DESCRIPTION = "is type or sub-type of"
    }
}
