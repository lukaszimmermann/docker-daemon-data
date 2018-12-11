package dockerdaemon.data.internal

/**
 * Tests whether the input [String] is a valid value for a Docker Hash, as
 * it is used for IDs for containers, images, networks, etc.
 *
 * @param input The input [String] to be tested whether it is a valid Docker ID
 * @param clazz The [Class] that this input [String] should represent as object
 * @throws IllegalArgumentException if the input [String] is not a valid Docker ID
 */
internal fun requireIsValidDockerHash(input: String, clazz: Class<*>) {
    require(isValidDockerHash(input)) {
        "Input String $input is not a valid Docker Hash for class: ${clazz.canonicalName}"
    }
}

/**
 * Checks whether the input [String] is a valid Docker Hash
 *
 * @param input The input [String] which should be checked
 * @return true if the input [String] is a valid Docker Hash, false otherwise
 */
internal fun isValidDockerHash(input: String) = input.matches(dockerHashRegex)

/**
 * The regular expression for Docker Hash values. The sha256: prefix is optional.
 */
private val dockerHashRegex = Regex("(?:sha256:)?[a-z0-9]+")
