/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package grl.kpimodel.impl;

import grl.impl.IntentionalElementImpl;
import grl.kpimodel.Indicator;
import grl.kpimodel.IndicatorGroup;
import grl.kpimodel.KPIModelLink;
import grl.kpimodel.KpimodelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indicator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getKpiModelLinksDest <em>Kpi Model Links Dest</em>}</li>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getTargetValue <em>Target Value</em>}</li>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getThresholdValue <em>Threshold Value</em>}</li>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getWorstValue <em>Worst Value</em>}</li>
 *   <li>{@link grl.kpimodel.impl.IndicatorImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndicatorImpl extends IntentionalElementImpl implements Indicator {
    /**
	 * The cached value of the '{@link #getKpiModelLinksDest() <em>Kpi Model Links Dest</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getKpiModelLinksDest()
	 * @generated
	 * @ordered
	 */
    protected EList kpiModelLinksDest;

    /**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
    protected EList groups;

    /**
	 * The default value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetValue()
	 * @generated
	 * @ordered
	 */
	protected static final double TARGET_VALUE_EDEFAULT = 0.0;

				/**
	 * The cached value of the '{@link #getTargetValue() <em>Target Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetValue()
	 * @generated
	 * @ordered
	 */
	protected double targetValue = TARGET_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getThresholdValue() <em>Threshold Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThresholdValue()
	 * @generated
	 * @ordered
	 */
	protected static final double THRESHOLD_VALUE_EDEFAULT = 0.0;

				/**
	 * The cached value of the '{@link #getThresholdValue() <em>Threshold Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThresholdValue()
	 * @generated
	 * @ordered
	 */
	protected double thresholdValue = THRESHOLD_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getWorstValue() <em>Worst Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorstValue()
	 * @generated
	 * @ordered
	 */
	protected static final double WORST_VALUE_EDEFAULT = 0.0;

				/**
	 * The cached value of the '{@link #getWorstValue() <em>Worst Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorstValue()
	 * @generated
	 * @ordered
	 */
	protected double worstValue = WORST_VALUE_EDEFAULT;

				/**
	 * The default value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_EDEFAULT = "";

				/**
	 * The cached value of the '{@link #getUnit() <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnit()
	 * @generated
	 * @ordered
	 */
	protected String unit = UNIT_EDEFAULT;

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected IndicatorImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected EClass eStaticClass() {
		return KpimodelPackage.Literals.INDICATOR;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getKpiModelLinksDest() {
		if (kpiModelLinksDest == null) {
			kpiModelLinksDest = new EObjectWithInverseResolvingEList(KPIModelLink.class, this, KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST, KpimodelPackage.KPI_MODEL_LINK__IND_DEST);
		}
		return kpiModelLinksDest;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList getGroups() {
		if (groups == null) {
			groups = new EObjectWithInverseResolvingEList.ManyInverse(IndicatorGroup.class, this, KpimodelPackage.INDICATOR__GROUPS, KpimodelPackage.INDICATOR_GROUP__INDICATORS);
		}
		return groups;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTargetValue() {
		return targetValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetValue(double newTargetValue) {
		double oldTargetValue = targetValue;
		targetValue = newTargetValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KpimodelPackage.INDICATOR__TARGET_VALUE, oldTargetValue, targetValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getThresholdValue() {
		return thresholdValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThresholdValue(double newThresholdValue) {
		double oldThresholdValue = thresholdValue;
		thresholdValue = newThresholdValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KpimodelPackage.INDICATOR__THRESHOLD_VALUE, oldThresholdValue, thresholdValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWorstValue() {
		return worstValue;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorstValue(double newWorstValue) {
		double oldWorstValue = worstValue;
		worstValue = newWorstValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KpimodelPackage.INDICATOR__WORST_VALUE, oldWorstValue, worstValue));
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnit() {
		return unit;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(String newUnit) {
		String oldUnit = unit;
		unit = newUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KpimodelPackage.INDICATOR__UNIT, oldUnit, unit));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				return ((InternalEList)getKpiModelLinksDest()).basicAdd(otherEnd, msgs);
			case KpimodelPackage.INDICATOR__GROUPS:
				return ((InternalEList)getGroups()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				return ((InternalEList)getKpiModelLinksDest()).basicRemove(otherEnd, msgs);
			case KpimodelPackage.INDICATOR__GROUPS:
				return ((InternalEList)getGroups()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				return getKpiModelLinksDest();
			case KpimodelPackage.INDICATOR__GROUPS:
				return getGroups();
			case KpimodelPackage.INDICATOR__TARGET_VALUE:
				return new Double(getTargetValue());
			case KpimodelPackage.INDICATOR__THRESHOLD_VALUE:
				return new Double(getThresholdValue());
			case KpimodelPackage.INDICATOR__WORST_VALUE:
				return new Double(getWorstValue());
			case KpimodelPackage.INDICATOR__UNIT:
				return getUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				getKpiModelLinksDest().clear();
				getKpiModelLinksDest().addAll((Collection)newValue);
				return;
			case KpimodelPackage.INDICATOR__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection)newValue);
				return;
			case KpimodelPackage.INDICATOR__TARGET_VALUE:
				setTargetValue(((Double)newValue).doubleValue());
				return;
			case KpimodelPackage.INDICATOR__THRESHOLD_VALUE:
				setThresholdValue(((Double)newValue).doubleValue());
				return;
			case KpimodelPackage.INDICATOR__WORST_VALUE:
				setWorstValue(((Double)newValue).doubleValue());
				return;
			case KpimodelPackage.INDICATOR__UNIT:
				setUnit((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void eUnset(int featureID) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				getKpiModelLinksDest().clear();
				return;
			case KpimodelPackage.INDICATOR__GROUPS:
				getGroups().clear();
				return;
			case KpimodelPackage.INDICATOR__TARGET_VALUE:
				setTargetValue(TARGET_VALUE_EDEFAULT);
				return;
			case KpimodelPackage.INDICATOR__THRESHOLD_VALUE:
				setThresholdValue(THRESHOLD_VALUE_EDEFAULT);
				return;
			case KpimodelPackage.INDICATOR__WORST_VALUE:
				setWorstValue(WORST_VALUE_EDEFAULT);
				return;
			case KpimodelPackage.INDICATOR__UNIT:
				setUnit(UNIT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KpimodelPackage.INDICATOR__KPI_MODEL_LINKS_DEST:
				return kpiModelLinksDest != null && !kpiModelLinksDest.isEmpty();
			case KpimodelPackage.INDICATOR__GROUPS:
				return groups != null && !groups.isEmpty();
			case KpimodelPackage.INDICATOR__TARGET_VALUE:
				return targetValue != TARGET_VALUE_EDEFAULT;
			case KpimodelPackage.INDICATOR__THRESHOLD_VALUE:
				return thresholdValue != THRESHOLD_VALUE_EDEFAULT;
			case KpimodelPackage.INDICATOR__WORST_VALUE:
				return worstValue != WORST_VALUE_EDEFAULT;
			case KpimodelPackage.INDICATOR__UNIT:
				return UNIT_EDEFAULT == null ? unit != null : !UNIT_EDEFAULT.equals(unit);
		}
		return super.eIsSet(featureID);
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (targetValue: ");
		result.append(targetValue);
		result.append(", thresholdValue: ");
		result.append(thresholdValue);
		result.append(", worstValue: ");
		result.append(worstValue);
		result.append(", unit: ");
		result.append(unit);
		result.append(')');
		return result.toString();
	}

} //IndicatorImpl