package vkk.identifiers

import kool.*
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.NULL
import vkk.VK_CHECK_RESULT
import vkk._10.api.PhysicalDevice_vk10
import vkk._11.api.PhysicalDevice_vk11
import vkk._10.structs.DeviceCreateInfo
import vkk.framed
import vkk.identifiers.Device
import vkk.identifiers.Dispatchable
import vkk.identifiers.Instance
import vkk.stak

/** Wraps a Vulkan physical device handle.  */
class PhysicalDevice
/**
 * Creates a `VkPhysicalDevice` using the specified native handle and Vulkan instance.
 *
 * @param handle   the native `VkDevice` handle
 * @param instance the Vulkan instance from which the physical device was enumerated
 */
constructor(handle: Adr,
            /** Returns the Vulkan instance from which this physical device was enumerated.  */
            val instance: Instance
) :
        Dispatchable(handle, instance.capabilities),

        PhysicalDevice_vk10,

        PhysicalDevice_vk11 {


    // ---------------------------------------------- VK10 -------------------------------------------------------------


    // --- [ vkCreateDevice ] ---

    infix fun MemoryStack.createDevice(createInfo: DeviceCreateInfo): Device =
            framed {
                val handle = this.pointerAdr { VK_CHECK_RESULT(callPPPPI(adr, createInfo write this, NULL, it, capabilities.vkCreateDevice)) }
                Device(handle, this@PhysicalDevice, createInfo)
            }

    infix fun createDevice(createInfo: DeviceCreateInfo): Device =
            stak { it createDevice createInfo }


    // ---------------------------------------------- VK11 -------------------------------------------------------------


}