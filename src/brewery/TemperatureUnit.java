/**
 */
package brewery;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>Temperature Unit</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see brewery.BreweryPackage#getTemperatureUnit()
 * @model
 * @generated
 */
public enum TemperatureUnit implements Enumerator {
	/**
	 * The '<em><b>Celsius</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #CELSIUS_VALUE
	 * @generated
	 * @ordered
	 */
	CELSIUS(0, "Celsius", "C"),

	/**
	 * The '<em><b>Farenheit</b></em>' literal object. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #FARENHEIT_VALUE
	 * @generated
	 * @ordered
	 */
	FARENHEIT(1, "Farenheit", "F");

	/**
	 * The '<em><b>Celsius</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Celsius</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #CELSIUS
	 * @model name="Celsius" literal="C"
	 * @generated
	 * @ordered
	 */
	public static final int CELSIUS_VALUE = 0;

	/**
	 * The '<em><b>Farenheit</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Farenheit</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FARENHEIT
	 * @model name="Farenheit" literal="F"
	 * @generated
	 * @ordered
	 */
	public static final int FARENHEIT_VALUE = 1;

	/**
	 * An array of all the '<em><b>Temperature Unit</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final TemperatureUnit[] VALUES_ARRAY = new TemperatureUnit[] {
			CELSIUS, FARENHEIT, };

	/**
	 * A public read-only list of all the '<em><b>Temperature Unit</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<TemperatureUnit> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Temperature Unit</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TemperatureUnit get(final int value) {
		switch (value) {
		case CELSIUS_VALUE:
			return CELSIUS;
		case FARENHEIT_VALUE:
			return FARENHEIT;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temperature Unit</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TemperatureUnit get(final String literal) {
		for (final TemperatureUnit result : VALUES_ARRAY) {
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temperature Unit</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TemperatureUnit getByName(final String name) {
		for (final TemperatureUnit result : VALUES_ARRAY) {
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private TemperatureUnit(final int value, final String name,
			final String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // TemperatureUnit
