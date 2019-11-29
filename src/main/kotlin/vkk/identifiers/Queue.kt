package identifiers

import kool.Ptr
import kool.adr
import org.lwjgl.system.Checks
import org.lwjgl.system.JNI.*
import org.lwjgl.system.MemoryUtil
import org.lwjgl.vulkan.VkBindSparseInfo
import org.lwjgl.vulkan.VkQueue
import vkk.VkResult
import vkk.classes.BindSparseInfo
import vkk.classes.PresentInfoKHR
import vkk.classes.SubmitInfo
import vkk.classes.write
import vkk.entities.VkFence
import vkk.stak

/** Wraps a Vulkan queue handle.  */
class Queue
/**
 * Creates a `VkQueue` using the specified native handle and device.
 *
 * @param handle the native `VkQueue` handle
 * @param device the device from which the queue was retrieved
 */(
    handle: Ptr,
    /** Returns the device from which this `VkQueue` was retrieved.  */
    val device: Device
) : DispatchableHandleDevice(handle, device.capabilities) {

    // --- [ vkQueueBindSparse ] ---
    fun bindSparse(bindInfos: Array<BindSparseInfo>, fence: VkFence = VkFence.NULL): VkResult = stak { s ->
        VkResult(callPPJI(adr, bindInfos.size, bindInfos write s, fence.L, capabilities.vkQueueBindSparse))
    }

    // --- [ vkQueuePresentKHR ] ---
    infix fun presentKHR(presentInfo: PresentInfoKHR): VkResult = stak { s ->
        presentInfo.native(s) { pPresentInfo ->
            VkResult(callPPI(adr, pPresentInfo, capabilities.vkQueuePresentKHR)).apply { check() }
        }
    }

    // --- [ vkQueueSubmit ] ---
    fun submit(submit: SubmitInfo, fence: VkFence = VkFence.NULL): VkResult = stak { s ->
        VkResult(callPPJI(adr, 1, submit write s, fence.L, capabilities.vkQueueSubmit)).apply { check() }
    }

    // --- [ vkQueueWaitIdle ] ---
    fun waitIdle(): VkResult =
        VkResult(callPI(adr, capabilities.vkQueueWaitIdle)).apply { check() }
}