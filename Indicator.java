/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package grl.kpimodel;

import grl.IntentionalElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indicator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link grl.kpimodel.Indicator#getKpiModelLinksDest <em>Kpi Model Links Dest</em>}</li>
 *   <li>{@link grl.kpimodel.Indicator#getGroups <em>Groups</em>}</li>
 *   <li>{@link grl.kpimodel.Indicator#getTargetValue <em>Target Value</em>}</li>
 *   <li>{@link grl.kpimodel.Indicator#getThresholdValue <em>Threshold Value</em>}</li>
 *   <li>{@link grl.kpimodel.Indicator#getWorstValue <em>Worst Value</em>}</li>
 *   <li>{@link grl.kpimodel.Indicator#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see grl.kpimodel.KpimodelPackage#getIndicator()
 * @model
 * @generated
 */
public interface Indicator extends IntentionalElement {
    /**
	 * Returns the value of the '<em><b>Kpi Model Links Dest</b></em>' reference list.
	 * The list contents are of type {@link grl.kpimodel.KPIModelLink}.
	 * It is bidirectional and its opposite is '{@link grl.kpimodel.KPIModelLink#getIndDest <em>Ind Dest</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Kpi Model Links Dest</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Kpi Model Links Dest</em>' reference list.
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_KpiModelLinksDest()
	 * @see grl.kpimodel.KPIModelLink#getIndDest
	 * @model type="grl.kpimodel.KPIModelLink" opposite="indDest"
	 * @generated
	 */
    EList getKpiModelLinksDest();

    /**
	 * Returns the value of the '<em><b>Groups</b></em>' reference list.
	 * The list contents are of type {@link grl.kpimodel.IndicatorGroup}.
	 * It is bidirectional and its opposite is '{@link grl.kpimodel.IndicatorGroup#getIndicators <em>Indicators</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' reference list.
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_Groups()
	 * @see grl.kpimodel.IndicatorGroup#getIndicators
	 * @model type="grl.kpimodel.IndicatorGroup" opposite="indicators"
	 * @generated
	 */
    EList getGroups();

				/**
	 * Returns the value of the '<em><b>Target Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Value</em>' attribute.
	 * @see #setTargetValue(double)
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_TargetValue()
	 * @model default="0"
	 * @generated
	 */
	double getTargetValue();

				/**
	 * Sets the value of the '{@link grl.kpimodel.Indicator#getTargetValue <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Value</em>' attribute.
	 * @see #getTargetValue()
	 * @generated
	 */
	void setTargetValue(double value);

				/**
	 * Returns the value of the '<em><b>Threshold Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold Value</em>' attribute.
	 * @see #setThresholdValue(double)
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_ThresholdValue()
	 * @model default="0"
	 * @generated
	 */
	double getThresholdValue();

				/**
	 * Sets the value of the '{@link grl.kpimodel.Indicator#getThresholdValue <em>Threshold Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold Value</em>' attribute.
	 * @see #getThresholdValue()
	 * @generated
	 */
	void setThresholdValue(double value);

				/**
	 * Returns the value of the '<em><b>Worst Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Worst Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Worst Value</em>' attribute.
	 * @see #setWorstValue(double)
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_WorstValue()
	 * @model default="0"
	 * @generated
	 */
	double getWorstValue();

				/**
	 * Sets the value of the '{@link grl.kpimodel.Indicator#getWorstValue <em>Worst Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Worst Value</em>' attribute.
	 * @see #getWorstValue()
	 * @generated
	 */
	void setWorstValue(double value);

				/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see #setUnit(String)
	 * @see grl.kpimodel.KpimodelPackage#getIndicator_Unit()
	 * @model default=""
	 * @generated
	 */
	String getUnit();

				/**
	 * Sets the value of the '{@link grl.kpimodel.Indicator#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(String value);

} // Indicator