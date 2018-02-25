package ch.tutteli.atrium.api.cc.infix.en_UK

import ch.tutteli.atrium.assertions.iterable.contains.builders.IterableContainsBuilder
import ch.tutteli.atrium.creating.Assert
import ch.tutteli.atrium.creating.AssertImpl
import ch.tutteli.atrium.creating.AssertionPlant
import ch.tutteli.atrium.creating.iterable.contains.IterableContains
import ch.tutteli.atrium.creating.iterable.contains.searchbehaviours.IterableContainsInAnyOrderOnlySearchBehaviour

/**
 * Finishes the specification of the sophisticated `contains` assertion where the [Iterable] needs to contain only the
 * [expected] value.
 *
 * Delegates to `the Objects(expected)`.
 *
 * @param expected The value which is expected to be contained within the [Iterable].
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.value(expected: E): AssertionPlant<T>
    = this the Objects(expected)

@Deprecated("use the extension fun `value` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder value expected"))
fun <E, T : Iterable<E>> value(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, expected: E): AssertionPlant<T>
    = the(builder, Values(expected))

/**
 * Finishes the specification of the sophisticated `contains` assertion where the expected [values]
 * need to be contained in [Iterable] where it does not matter in which order.
 *
 * Delegates to `the Objects(values)`.
 *
 * @param values The values which are expected to be contained within the [Iterable].
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.the(values: Values<E>): AssertionPlant<T>
    = this the Objects(values)

@Deprecated("use the extension fun `the` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder the values"))
fun <E, T : Iterable<E>> the(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, values: Values<E>): AssertionPlant<T>
    = builder the values


/**
 * Finishes the specification of the sophisticated `contains` assertion where the [Iterable] needs to contain only the
 * [expected] object.
 *
 * Delegate to `the Objects(expected)`.
 *
 * @param expected The object which is expected to be contained within the [Iterable].
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.`object`(expected: E): AssertionPlant<T>
    = this the Objects(expected)

@Deprecated("se the extension fun `object` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder.`object`(expected)"))
fun <E, T : Iterable<E>> `object`(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, expected: E): AssertionPlant<T>
    = the(builder, Objects(expected))


/**
 * Finishes the specification of the sophisticated `contains` assertion where the expected [objects]
 * need to be contained in [Iterable] where it does not matter in which order.
 *
 * @param objects The objects which are expected to be contained within the [Iterable].
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.the(objects: Objects<E>): AssertionPlant<T>
    = plant.addAssertion(AssertImpl.iterable.contains.objectsInAnyOrderOnly(this, objects.expected, objects.otherExpected))

@Deprecated("use the extension fun `the` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder the objects"))
fun <E, T : Iterable<E>> the(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, objects: Objects<E>): AssertionPlant<T>
    = builder the objects


/**
 * Finishes the specification of the sophisticated `contains` assertion where the [Iterable] needs to contain only one
 * entry which holds all assertions created by the given [assertionCreator].
 *
 * Delegates to `the Entries(assertionCreator)`
 *
 * @param assertionCreator The identification lambda.
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E : Any, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.entry(assertionCreator: Assert<E>.() -> Unit): AssertionPlant<T>
    = this the Entries(assertionCreator)

@Deprecated("use the extension fun `entry` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder entry assertionCreator"))
fun <E : Any, T : Iterable<E>> entry(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, assertionCreator: Assert<E>.() -> Unit): AssertionPlant<T>
    = the(builder, Entries(assertionCreator))


/**
 * Finishes the specification of the sophisticated `contains` assertion where the entry needs to be contained in the
 * [Iterable] which holds all assertions [Entries.assertionCreator] might create -- equally an entry for each further
 * [Entries.otherAssertionCreators] needs to be contained in the [Iterable]  where it does not matter in which order the
 * entries appear.
 *
 * Notice, that a first-wins strategy applies which means your [Entries.assertionCreator] functions -- which kind of
 * serve as identification functions -- should be ordered in such a way that the most specific identification function
 * appears first, not that a less specific function wins. For instance, given a `setOf(1, 2)` you should not search for
 * `entries({ isGreaterThan(0) }, { toBe(1) })` but for `entries({ toBe(1) }, { isGreaterThan(0) })` otherwise
 * `isGreaterThan(0)` matches `1` before `toBe(1)` would match it. As a consequence `toBe(1)` could only match the
 * entry which is left -- in this case `2` -- and of course this would fail.
 *
 * @param entries The method object containing the identification lambdas.
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
infix fun <E : Any, T : Iterable<E>> IterableContains.Builder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>.the(entries: Entries<E, Assert<E>.() -> Unit>): AssertionPlant<T>
    = plant.addAssertion(AssertImpl.iterable.contains.entriesInAnyOrderOnly(this, entries.assertionCreator, entries.otherAssertionCreators))

@Deprecated("use the extension fun `the` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder the entries"))
fun <E : Any, T : Iterable<E>> the(builder: IterableContainsBuilder<E, T, IterableContainsInAnyOrderOnlySearchBehaviour>, entries: Entries<E, Assert<E>.() -> Unit>): AssertionPlant<T>
    = builder the entries


/**
 * Finishes the specification of the sophisticated `contains` assertion where the [Iterable] needs to contain only one
 * entry which holds all assertions created by the given [assertionCreator].
 *
 * Delegates to `the Entries(assertionCreator)`.
 *
 * @param assertionCreator The identification lambda.
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
@JvmName("entry?")
infix fun <E : Any, T : Iterable<E?>> IterableContains.Builder<E?, T, IterableContainsInAnyOrderOnlySearchBehaviour>.entry(assertionCreator: (Assert<E>.() -> Unit)?): AssertionPlant<T>
    = this the Entries(assertionCreator)

@Deprecated("use the extension fun `entry` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder entry assertionCreator"))
fun <E : Any, T : Iterable<E?>> nullableEntry(builder: IterableContainsBuilder<E?, T, IterableContainsInAnyOrderOnlySearchBehaviour>, assertionCreator: (Assert<E>.() -> Unit)?): AssertionPlant<T>
    = nullableEntries(builder, Entries(assertionCreator))


/**
 * Finishes the specification of the sophisticated `contains` assertion where the entry needs to be contained in the
 * [Iterable] which holds all assertions [Entries.assertionCreator] might create -- equally an entry for each further
 * [Entries.otherAssertionCreators] needs to be contained in the [Iterable]  where it does not matter in which order the
 * entries appear.
 *
 * Notice, that a first-wins strategy applies which means your [Entries.assertionCreator] functions -- which kind of serve as
 * identification functions -- should be ordered in such a way that the most specific identification function appears
 * first, not that a less specific function wins. For instance, given a `setOf(1, 2)` you should not search for
 * `entries({ isGreaterThan(0) }, { toBe(1) })` but for `entries({ toBe(1) }, { isGreaterThan(0) })` otherwise
 * `isGreaterThan(0)` matches `1` before `toBe(1)` would match it. As a consequence `toBe(1)` could only match the
 * entry which is left -- in this case `2` -- and of course this would fail.
 *
 * @param entries The method object containing the identification lambdas.
 *
 * @return The [AssertionPlant] for which the assertion was built to support a fluent API.
 * @throws AssertionError Might throw an [AssertionError] if the assertion made is not correct.
 */
@JvmName("entries?")
infix fun <E : Any, T : Iterable<E?>> IterableContains.Builder<E?, T, IterableContainsInAnyOrderOnlySearchBehaviour>.the(entries: Entries<E, (Assert<E>.() -> Unit)?>): AssertionPlant<T>
    = plant.addAssertion(AssertImpl.iterable.contains.nullableEntriesInAnyOrderOnly(this, entries.assertionCreator, entries.otherAssertionCreators))

@Deprecated("use the extension fun `the` instead. This fun is only here to retain binary compatibility, will be removed with 1.0.0", ReplaceWith("builder the entries"))
fun <E : Any, T : Iterable<E?>> nullableEntries(builder: IterableContainsBuilder<E?, T, IterableContainsInAnyOrderOnlySearchBehaviour>, entries: Entries<E, (Assert<E>.() -> Unit)?>): AssertionPlant<T>
    = builder the entries
