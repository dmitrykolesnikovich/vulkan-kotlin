package identifiers

import kool.Ptr
import kool.adr
import org.lwjgl.system.JNI.*
import vkk.VkResult
import vkk._10.api.Queue_vk10
import vkk._10.structs.BindSparseInfo
import vkk._10.structs.PresentInfoKHR
import vkk._10.structs.SubmitInfo
import vkk._10.structs.write
import vkk.entities.VkFence
import vkk.stak

/** Wraps a Vulkan queue handle.  */
class Queue
/**
 * Creates a `VkQueue` using the specified native handle and device.
 *
 * @param handle the native `VkQueue` handle
 * @param device the device from which the queue was retrieved
 */
constructor(handle: Ptr,
            /** Returns the device from which this `VkQueue` was retrieved.  */
            val device: Device
) :
        DispatchableHandleDevice(handle, device.capabilities),

        Queue_vk10