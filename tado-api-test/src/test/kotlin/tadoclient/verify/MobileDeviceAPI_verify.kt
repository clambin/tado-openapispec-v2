package tadoclient.verify

import tadoclient.models.MobileDevice

fun verifyMobileDevice(mobileDevice: MobileDevice, context:String, fullParentName:String = "MobileDevice", ancestorObjectProps:Map<String, Any> = emptyMap()){
    val typeName = "MobileDevice"
    verifyObject(mobileDevice, context, fullParentName, typeName, ancestorObjectProps,
        nullAllowedProperties = listOf(
            // location only available for devices which use geofencing
            "$typeName.location",
            // push notifications only seem to be available for phones, not for tables/iPads
            "$typeName.settings.pushNotifications"))
}
