package vkk


const val VK_HEADER_VERSION = 100


typealias VkFlags = Int


inline class VkPipelineCacheHeaderversion(val i: Int) {
    companion object {
        val ONE = VkPipelineCacheHeaderversion(1)
    }
}

inline class VkResult(val i: Int) {

    fun check(message: String = "Fatal : VkResult is $this") {
        if (DEBUG && this != SUCCESS)
            if (VULKAN_NO_EXCEPTIONS)
                System.err.println(message)
            else
                when (this) {
                    ERROR_OUT_OF_HOST_MEMORY -> throw OutOfHostMemoryError(message)
                    ERROR_OUT_OF_DEVICE_MEMORY -> throw OutOfDeviceMemoryError(message)
                    ERROR_INITIALIZATION_FAILED -> throw InitializationFailedError(message)
                    ERROR_DEVICE_LOST -> throw DeviceLostError(message)
                    ERROR_MEMORY_MAP_FAILED -> throw MemoryMapFailedError(message)
                    ERROR_LAYER_NOT_PRESENT -> throw LayerNotPresentError(message)
                    ERROR_EXTENSION_NOT_PRESENT -> throw ExtensionNotPresentError(message)
                    ERROR_FEATURE_NOT_PRESENT -> throw FeatureNotPresentError(message)
                    ERROR_INCOMPATIBLE_DRIVER -> throw IncompatibleDriverError(message)
                    ERROR_TOO_MANY_OBJECTS -> throw TooManyObjectsError(message)
                    ERROR_FORMAT_NOT_SUPPORTED -> throw FormatNotSupportedError(message)
                    ERROR_FRAGMENTED_POOL -> throw FragmentedPoolError(message)
                    ERROR_SURFACE_LOST_KHR -> throw SurfaceLostKhrError(message)
                    ERROR_NATIVE_WINDOW_IN_USE_KHR -> throw NativeWindowInUseKhrError(message)
                    ERROR_OUT_OF_DATE_KHR -> throw OutOfDateKhrError(message)
                    ERROR_INCOMPATIBLE_DISPLAY_KHR -> throw IncompatibleDisplayKhrError(message)
                    ERROR_VALIDATION_FAILED_EXT -> throw ValidationFailedExtError(message)
                    ERROR_INVALID_SHADER_NV -> throw InvalidShaderNvError(message)
                    ERROR_OUT_OF_POOL_MEMORY -> throw OutOfPoolMemoryError(message)
                    ERROR_INVALID_EXTERNAL_HANDLE -> throw InvalidExternalHandleError(message)
                    ERROR_NOT_PERMITTED_EXT -> throw NotPermittedError(message)
                    else -> throw Error(message)
                }
    }

    companion object {
        val SUCCESS = VkResult(0)
        val NOT_READY = VkResult(1)
        val TIMEOUT = VkResult(2)
        val EVENT_SET = VkResult(3)
        val EVENT_RESET = VkResult(4)
        val INCOMPLETE = VkResult(5)
        val ERROR_OUT_OF_HOST_MEMORY = VkResult(-1)
        val ERROR_OUT_OF_DEVICE_MEMORY = VkResult(-2)
        val ERROR_INITIALIZATION_FAILED = VkResult(-3)
        val ERROR_DEVICE_LOST = VkResult(-4)
        val ERROR_MEMORY_MAP_FAILED = VkResult(-5)
        val ERROR_LAYER_NOT_PRESENT = VkResult(-6)
        val ERROR_EXTENSION_NOT_PRESENT = VkResult(-7)
        val ERROR_FEATURE_NOT_PRESENT = VkResult(-8)
        val ERROR_INCOMPATIBLE_DRIVER = VkResult(-9)
        val ERROR_TOO_MANY_OBJECTS = VkResult(-10)
        val ERROR_FORMAT_NOT_SUPPORTED = VkResult(-11)
        val ERROR_FRAGMENTED_POOL = VkResult(-12)
        val ERROR_OUT_OF_POOL_MEMORY = VkResult(-1000069000)
        val ERROR_INVALID_EXTERNAL_HANDLE = VkResult(-1000072003)
        val ERROR_SURFACE_LOST_KHR = VkResult(-1000000000)
        val ERROR_NATIVE_WINDOW_IN_USE_KHR = VkResult(-1000000001)
        val SUBOPTIMAL_KHR = VkResult(1000001003)
        val ERROR_OUT_OF_DATE_KHR = VkResult(-1000001004)
        val ERROR_INCOMPATIBLE_DISPLAY_KHR = VkResult(-1000003001)
        val ERROR_VALIDATION_FAILED_EXT = VkResult(-1000011001)
        val ERROR_INVALID_SHADER_NV = VkResult(-1000012000)
        val ERROR_INVALID_DRM_FORMAT_MODIFIER_PLANE_LAYOUT_EXT = VkResult(-1000158000)
        val ERROR_FRAGMENTATION_EXT = VkResult(-1000161000)
        val ERROR_NOT_PERMITTED_EXT = VkResult(-1000174001)
        val ERROR_INVALID_DEVICE_ADDRESS_EXT = VkResult(-1000244000)
        val ERROR_OUT_OF_POOL_MEMORY_KHR = VkResult.ERROR_OUT_OF_POOL_MEMORY
        val ERROR_INVALID_EXTERNAL_HANDLE_KHR = VkResult.ERROR_INVALID_EXTERNAL_HANDLE
    }

    val description: String
        get() = when (this) {
            // Success Codes
            VkResult.SUCCESS -> "Command successfully completed"
            VkResult.NOT_READY -> "A fence or query has not yet completed"
            VkResult.TIMEOUT -> "A wait operation has not completed in the specified time"
            VkResult.EVENT_SET -> "An event is signaled"
            VkResult.EVENT_RESET -> "An event is unsignaled"
            VkResult.INCOMPLETE -> "A return array was too small for the result"
            VkResult.SUBOPTIMAL_KHR -> "A swapchain no longer matches the surface properties exactly, but can still be used to present to the surface successfully"
            // Error codes
            VkResult.ERROR_OUT_OF_HOST_MEMORY -> "A host memory allocation has failed"
            VkResult.ERROR_OUT_OF_DEVICE_MEMORY -> "A device memory allocation has failed"
            VkResult.ERROR_INITIALIZATION_FAILED -> "Initialization of an object could not be completed for implementation-specific reasons"
            VkResult.ERROR_DEVICE_LOST -> "The logical or physical device has been lost. See Lost Device"
            VkResult.ERROR_MEMORY_MAP_FAILED -> "Mapping of a memory object has failed"
            VkResult.ERROR_LAYER_NOT_PRESENT -> "A requested layer is not present or could not be loaded"
            VkResult.ERROR_EXTENSION_NOT_PRESENT -> "A requested extension is not supported"
            VkResult.ERROR_FEATURE_NOT_PRESENT -> "A requested feature is not supported"
            VkResult.ERROR_INCOMPATIBLE_DRIVER -> "The requested version of Vulkan is not supported by the driver or is otherwise incompatible for implementation-specific reasons"
            VkResult.ERROR_TOO_MANY_OBJECTS -> "Too many objects of the type have already been created"
            VkResult.ERROR_FORMAT_NOT_SUPPORTED -> "A requested format is not supported on this device"
            VkResult.ERROR_FRAGMENTED_POOL -> "A pool allocation has failed due to fragmentation of the pool’s memory. This must only be returned if no attempt to allocate host or device memory was made to accomodate the new allocation. This should be returned in preference to VK_ERROR_OUT_OF_POOL_MEMORY, but only if the implementation is certain that the pool allocation failure was due to fragmentation"
            VkResult.ERROR_OUT_OF_POOL_MEMORY -> "A pool memory allocation has failed. This must only be returned if no attempt to allocate host or device memory was made to accomodate the new allocation. If the failure was definitely due to fragmentation of the pool, VK_ERROR_FRAGMENTED_POOL should be returned instead"
            VkResult.ERROR_INVALID_EXTERNAL_HANDLE -> "An external handle is not a valid handle of the specified type"
            VkResult.ERROR_SURFACE_LOST_KHR -> "A surface is no longer available"
            VkResult.ERROR_NATIVE_WINDOW_IN_USE_KHR -> "The requested window is already in use by Vulkan or another API in a manner which prevents it from being used again"
            VkResult.ERROR_OUT_OF_DATE_KHR -> "A surface has changed in such a way that it is no longer compatible with the swapchain, and further presentation requests using the swapchain will fail. Applications must query the new surface properties and recreate their swapchain if they wish to continue presenting to the surface"
            VkResult.ERROR_INCOMPATIBLE_DISPLAY_KHR -> "The display used by a swapchain does not use the same presentable image layout, or is incompatible in a way that prevents sharing an image"
            VkResult.ERROR_INVALID_SHADER_NV -> "One or more shaders failed to compile or link. More details are reported back to the application via ../../html/vkspec.html#VK_EXT_debug_report if enabled"
            VkResult.ERROR_FRAGMENTATION_EXT -> "A descriptor pool creation has failed due to fragmentation"
            VkResult.ERROR_INVALID_DEVICE_ADDRESS_EXT -> "A buffer creation failed because the requested address is not available."
            else -> "Unknown VkResult type"
        }
}


inline class VkStructureType(val i: Int) {
    companion object {
        val APPLICATION_INFO = VkStructureType(0)
        val INSTANCE_CREATE_INFO = VkStructureType(1)
        val DEVICE_QUEUE_CREATE_INFO = VkStructureType(2)
        val DEVICE_CREATE_INFO = VkStructureType(3)
        val SUBMIT_INFO = VkStructureType(4)
        val MEMORY_ALLOCATE_INFO = VkStructureType(5)
        val MAPPED_MEMORY_RANGE = VkStructureType(6)
        val BIND_SPARSE_INFO = VkStructureType(7)
        val FENCE_CREATE_INFO = VkStructureType(8)
        val SEMAPHORE_CREATE_INFO = VkStructureType(9)
        val EVENT_CREATE_INFO = VkStructureType(10)
        val QUERY_POOL_CREATE_INFO = VkStructureType(11)
        val BUFFER_CREATE_INFO = VkStructureType(12)
        val BUFFER_VIEW_CREATE_INFO = VkStructureType(13)
        val IMAGE_CREATE_INFO = VkStructureType(14)
        val IMAGE_VIEW_CREATE_INFO = VkStructureType(15)
        val SHADER_MODULE_CREATE_INFO = VkStructureType(16)
        val PIPELINE_CACHE_CREATE_INFO = VkStructureType(17)
        val PIPELINE_SHADER_STAGE_CREATE_INFO = VkStructureType(18)
        val PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO = VkStructureType(19)
        val PIPELINE_INPUT_ASSEMBLY_STATE_CREATE_INFO = VkStructureType(20)
        val PIPELINE_TESSELLATION_STATE_CREATE_INFO = VkStructureType(21)
        val PIPELINE_VIEWPORT_STATE_CREATE_INFO = VkStructureType(22)
        val PIPELINE_RASTERIZATION_STATE_CREATE_INFO = VkStructureType(23)
        val PIPELINE_MULTISAMPLE_STATE_CREATE_INFO = VkStructureType(24)
        val PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO = VkStructureType(25)
        val PIPELINE_COLOR_BLEND_STATE_CREATE_INFO = VkStructureType(26)
        val PIPELINE_DYNAMIC_STATE_CREATE_INFO = VkStructureType(27)
        val GRAPHICS_PIPELINE_CREATE_INFO = VkStructureType(28)
        val COMPUTE_PIPELINE_CREATE_INFO = VkStructureType(29)
        val PIPELINE_LAYOUT_CREATE_INFO = VkStructureType(30)
        val SAMPLER_CREATE_INFO = VkStructureType(31)
        val DESCRIPTOR_SET_LAYOUT_CREATE_INFO = VkStructureType(32)
        val DESCRIPTOR_POOL_CREATE_INFO = VkStructureType(33)
        val DESCRIPTOR_SET_ALLOCATE_INFO = VkStructureType(34)
        val WRITE_DESCRIPTOR_SET = VkStructureType(35)
        val COPY_DESCRIPTOR_SET = VkStructureType(36)
        val FRAMEBUFFER_CREATE_INFO = VkStructureType(37)
        val RENDER_PASS_CREATE_INFO = VkStructureType(38)
        val COMMAND_POOL_CREATE_INFO = VkStructureType(39)
        val COMMAND_BUFFER_ALLOCATE_INFO = VkStructureType(40)
        val COMMAND_BUFFER_INHERITANCE_INFO = VkStructureType(41)
        val COMMAND_BUFFER_BEGIN_INFO = VkStructureType(42)
        val RENDER_PASS_BEGIN_INFO = VkStructureType(43)
        val BUFFER_MEMORY_BARRIER = VkStructureType(44)
        val IMAGE_MEMORY_BARRIER = VkStructureType(45)
        val MEMORY_BARRIER = VkStructureType(46)
        val LOADER_INSTANCE_CREATE_INFO = VkStructureType(47)
        val LOADER_DEVICE_CREATE_INFO = VkStructureType(48)
        val PHYSICAL_DEVICE_SUBGROUP_PROPERTIES = VkStructureType(1000094000)
        val BIND_BUFFER_MEMORY_INFO = VkStructureType(1000157000)
        val BIND_IMAGE_MEMORY_INFO = VkStructureType(1000157001)
        val PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES = VkStructureType(1000083000)
        val MEMORY_DEDICATED_REQUIREMENTS = VkStructureType(1000127000)
        val MEMORY_DEDICATED_ALLOCATE_INFO = VkStructureType(1000127001)
        val MEMORY_ALLOCATE_FLAGS_INFO = VkStructureType(1000060000)
        val DEVICE_GROUP_RENDER_PASS_BEGIN_INFO = VkStructureType(1000060003)
        val DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO = VkStructureType(1000060004)
        val DEVICE_GROUP_SUBMIT_INFO = VkStructureType(1000060005)
        val DEVICE_GROUP_BIND_SPARSE_INFO = VkStructureType(1000060006)
        val BIND_BUFFER_MEMORY_DEVICE_GROUP_INFO = VkStructureType(1000060013)
        val BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO = VkStructureType(1000060014)
        val PHYSICAL_DEVICE_GROUP_PROPERTIES = VkStructureType(1000070000)
        val DEVICE_GROUP_DEVICE_CREATE_INFO = VkStructureType(1000070001)
        val BUFFER_MEMORY_REQUIREMENTS_INFO_2 = VkStructureType(1000146000)
        val IMAGE_MEMORY_REQUIREMENTS_INFO_2 = VkStructureType(1000146001)
        val IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2 = VkStructureType(1000146002)
        val MEMORY_REQUIREMENTS_2 = VkStructureType(1000146003)
        val SPARSE_IMAGE_MEMORY_REQUIREMENTS_2 = VkStructureType(1000146004)
        val PHYSICAL_DEVICE_FEATURES_2 = VkStructureType(1000059000)
        val PHYSICAL_DEVICE_PROPERTIES_2 = VkStructureType(1000059001)
        val FORMAT_PROPERTIES_2 = VkStructureType(1000059002)
        val IMAGE_FORMAT_PROPERTIES_2 = VkStructureType(1000059003)
        val PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2 = VkStructureType(1000059004)
        val QUEUE_FAMILY_PROPERTIES_2 = VkStructureType(1000059005)
        val PHYSICAL_DEVICE_MEMORY_PROPERTIES_2 = VkStructureType(1000059006)
        val SPARSE_IMAGE_FORMAT_PROPERTIES_2 = VkStructureType(1000059007)
        val PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2 = VkStructureType(1000059008)
        val PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES = VkStructureType(1000117000)
        val RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO = VkStructureType(1000117001)
        val IMAGE_VIEW_USAGE_CREATE_INFO = VkStructureType(1000117002)
        val PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO = VkStructureType(1000117003)
        val RENDER_PASS_MULTIVIEW_CREATE_INFO = VkStructureType(1000053000)
        val PHYSICAL_DEVICE_MULTIVIEW_FEATURES = VkStructureType(1000053001)
        val PHYSICAL_DEVICE_MULTIVIEW_PROPERTIES = VkStructureType(1000053002)
        val PHYSICAL_DEVICE_VARIABLE_POINTER_FEATURES = VkStructureType(1000120000)
        val PROTECTED_SUBMIT_INFO = VkStructureType(1000145000)
        val PHYSICAL_DEVICE_PROTECTED_MEMORY_FEATURES = VkStructureType(1000145001)
        val PHYSICAL_DEVICE_PROTECTED_MEMORY_PROPERTIES = VkStructureType(1000145002)
        val DEVICE_QUEUE_INFO_2 = VkStructureType(1000145003)
        val SAMPLER_YCBCR_CONVERSION_CREATE_INFO = VkStructureType(1000156000)
        val SAMPLER_YCBCR_CONVERSION_INFO = VkStructureType(1000156001)
        val BIND_IMAGE_PLANE_MEMORY_INFO = VkStructureType(1000156002)
        val IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO = VkStructureType(1000156003)
        val PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES = VkStructureType(1000156004)
        val SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES = VkStructureType(1000156005)
        val DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO = VkStructureType(1000085000)
        val PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO = VkStructureType(1000071000)
        val EXTERNAL_IMAGE_FORMAT_PROPERTIES = VkStructureType(1000071001)
        val PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO = VkStructureType(1000071002)
        val EXTERNAL_BUFFER_PROPERTIES = VkStructureType(1000071003)
        val PHYSICAL_DEVICE_ID_PROPERTIES = VkStructureType(1000071004)
        val EXTERNAL_MEMORY_BUFFER_CREATE_INFO = VkStructureType(1000072000)
        val EXTERNAL_MEMORY_IMAGE_CREATE_INFO = VkStructureType(1000072001)
        val EXPORT_MEMORY_ALLOCATE_INFO = VkStructureType(1000072002)
        val PHYSICAL_DEVICE_EXTERNAL_FENCE_INFO = VkStructureType(1000112000)
        val EXTERNAL_FENCE_PROPERTIES = VkStructureType(1000112001)
        val EXPORT_FENCE_CREATE_INFO = VkStructureType(1000113000)
        val EXPORT_SEMAPHORE_CREATE_INFO = VkStructureType(1000077000)
        val PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO = VkStructureType(1000076000)
        val EXTERNAL_SEMAPHORE_PROPERTIES = VkStructureType(1000076001)
        val PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES = VkStructureType(1000168000)
        val DESCRIPTOR_SET_LAYOUT_SUPPORT = VkStructureType(1000168001)
        val PHYSICAL_DEVICE_SHADER_DRAW_PARAMETER_FEATURES = VkStructureType(1000063000)
        val SWAPCHAIN_CREATE_INFO_KHR = VkStructureType(1000001000)
        val PRESENT_INFO_KHR = VkStructureType(1000001001)
        val DEVICE_GROUP_PRESENT_CAPABILITIES_KHR = VkStructureType(1000060007)
        val IMAGE_SWAPCHAIN_CREATE_INFO_KHR = VkStructureType(1000060008)
        val BIND_IMAGE_MEMORY_SWAPCHAIN_INFO_KHR = VkStructureType(1000060009)
        val ACQUIRE_NEXT_IMAGE_INFO_KHR = VkStructureType(1000060010)
        val DEVICE_GROUP_PRESENT_INFO_KHR = VkStructureType(1000060011)
        val DEVICE_GROUP_SWAPCHAIN_CREATE_INFO_KHR = VkStructureType(1000060012)
        val DISPLAY_MODE_CREATE_INFO_KHR = VkStructureType(1000002000)
        val DISPLAY_SURFACE_CREATE_INFO_KHR = VkStructureType(1000002001)
        val DISPLAY_PRESENT_INFO_KHR = VkStructureType(1000003000)
        val XLIB_SURFACE_CREATE_INFO_KHR = VkStructureType(1000004000)
        val XCB_SURFACE_CREATE_INFO_KHR = VkStructureType(1000005000)
        val WAYLAND_SURFACE_CREATE_INFO_KHR = VkStructureType(1000006000)
        val ANDROID_SURFACE_CREATE_INFO_KHR = VkStructureType(1000008000)
        val WIN32_SURFACE_CREATE_INFO_KHR = VkStructureType(1000009000)
        val DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT = VkStructureType(1000011000)
        val PIPELINE_RASTERIZATION_STATE_RASTERIZATION_ORDER_AMD = VkStructureType(1000018000)
        val DEBUG_MARKER_OBJECT_NAME_INFO_EXT = VkStructureType(1000022000)
        val DEBUG_MARKER_OBJECT_TAG_INFO_EXT = VkStructureType(1000022001)
        val DEBUG_MARKER_MARKER_INFO_EXT = VkStructureType(1000022002)
        val DEDICATED_ALLOCATION_IMAGE_CREATE_INFO_NV = VkStructureType(1000026000)
        val DEDICATED_ALLOCATION_BUFFER_CREATE_INFO_NV = VkStructureType(1000026001)
        val DEDICATED_ALLOCATION_MEMORY_ALLOCATE_INFO_NV = VkStructureType(1000026002)
        val PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_FEATURES_EXT = VkStructureType(1000028000)
        val PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT = VkStructureType(1000028001)
        val PIPELINE_RASTERIZATION_STATE_STREAM_CREATE_INFO_EXT = VkStructureType(1000028002)
        val TEXTURE_LOD_GATHER_FORMAT_PROPERTIES_AMD = VkStructureType(1000041000)
        val PHYSICAL_DEVICE_CORNER_SAMPLED_IMAGE_FEATURES_NV = VkStructureType(1000050000)
        val EXTERNAL_MEMORY_IMAGE_CREATE_INFO_NV = VkStructureType(1000056000)
        val EXPORT_MEMORY_ALLOCATE_INFO_NV = VkStructureType(1000056001)
        val IMPORT_MEMORY_WIN32_HANDLE_INFO_NV = VkStructureType(1000057000)
        val EXPORT_MEMORY_WIN32_HANDLE_INFO_NV = VkStructureType(1000057001)
        val WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV = VkStructureType(1000058000)
        val VALIDATION_FLAGS_EXT = VkStructureType(1000061000)
        val VI_SURFACE_CREATE_INFO_NN = VkStructureType(1000062000)
        val IMAGE_VIEW_ASTC_DECODE_MODE_EXT = VkStructureType(1000067000)
        val PHYSICAL_DEVICE_ASTC_DECODE_FEATURES_EXT = VkStructureType(1000067001)
        val IMPORT_MEMORY_WIN32_HANDLE_INFO_KHR = VkStructureType(1000073000)
        val EXPORT_MEMORY_WIN32_HANDLE_INFO_KHR = VkStructureType(1000073001)
        val MEMORY_WIN32_HANDLE_PROPERTIES_KHR = VkStructureType(1000073002)
        val MEMORY_GET_WIN32_HANDLE_INFO_KHR = VkStructureType(1000073003)
        val IMPORT_MEMORY_FD_INFO_KHR = VkStructureType(1000074000)
        val MEMORY_FD_PROPERTIES_KHR = VkStructureType(1000074001)
        val MEMORY_GET_FD_INFO_KHR = VkStructureType(1000074002)
        val WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_KHR = VkStructureType(1000075000)
        val IMPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR = VkStructureType(1000078000)
        val EXPORT_SEMAPHORE_WIN32_HANDLE_INFO_KHR = VkStructureType(1000078001)
        val D3D12_FENCE_SUBMIT_INFO_KHR = VkStructureType(1000078002)
        val SEMAPHORE_GET_WIN32_HANDLE_INFO_KHR = VkStructureType(1000078003)
        val IMPORT_SEMAPHORE_FD_INFO_KHR = VkStructureType(1000079000)
        val SEMAPHORE_GET_FD_INFO_KHR = VkStructureType(1000079001)
        val PHYSICAL_DEVICE_PUSH_DESCRIPTOR_PROPERTIES_KHR = VkStructureType(1000080000)
        val COMMAND_BUFFER_INHERITANCE_CONDITIONAL_RENDERING_INFO_EXT = VkStructureType(1000081000)
        val PHYSICAL_DEVICE_CONDITIONAL_RENDERING_FEATURES_EXT = VkStructureType(1000081001)
        val CONDITIONAL_RENDERING_BEGIN_INFO_EXT = VkStructureType(1000081002)
        val PHYSICAL_DEVICE_FLOAT16_INT8_FEATURES_KHR = VkStructureType(1000082000)
        val PRESENT_REGIONS_KHR = VkStructureType(1000084000)
        val OBJECT_TABLE_CREATE_INFO_NVX = VkStructureType(1000086000)
        val INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NVX = VkStructureType(1000086001)
        val CMD_PROCESS_COMMANDS_INFO_NVX = VkStructureType(1000086002)
        val CMD_RESERVE_SPACE_FOR_COMMANDS_INFO_NVX = VkStructureType(1000086003)
        val DEVICE_GENERATED_COMMANDS_LIMITS_NVX = VkStructureType(1000086004)
        val DEVICE_GENERATED_COMMANDS_FEATURES_NVX = VkStructureType(1000086005)
        val PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV = VkStructureType(1000087000)
        val SURFACE_CAPABILITIES_2_EXT = VkStructureType(1000090000)
        val DISPLAY_POWER_INFO_EXT = VkStructureType(1000091000)
        val DEVICE_EVENT_INFO_EXT = VkStructureType(1000091001)
        val DISPLAY_EVENT_INFO_EXT = VkStructureType(1000091002)
        val SWAPCHAIN_COUNTER_CREATE_INFO_EXT = VkStructureType(1000091003)
        val PRESENT_TIMES_INFO_GOOGLE = VkStructureType(1000092000)
        val PHYSICAL_DEVICE_MULTIVIEW_PER_VIEW_ATTRIBUTES_PROPERTIES_NVX = VkStructureType(1000097000)
        val PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV = VkStructureType(1000098000)
        val PHYSICAL_DEVICE_DISCARD_RECTANGLE_PROPERTIES_EXT = VkStructureType(1000099000)
        val PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT = VkStructureType(1000099001)
        val PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT = VkStructureType(1000101000)
        val PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT = VkStructureType(1000101001)
        val HDR_METADATA_EXT = VkStructureType(1000105000)
        val ATTACHMENT_DESCRIPTION_2_KHR = VkStructureType(1000109000)
        val ATTACHMENT_REFERENCE_2_KHR = VkStructureType(1000109001)
        val SUBPASS_DESCRIPTION_2_KHR = VkStructureType(1000109002)
        val SUBPASS_DEPENDENCY_2_KHR = VkStructureType(1000109003)
        val RENDER_PASS_CREATE_INFO_2_KHR = VkStructureType(1000109004)
        val SUBPASS_BEGIN_INFO_KHR = VkStructureType(1000109005)
        val SUBPASS_END_INFO_KHR = VkStructureType(1000109006)
        val SHARED_PRESENT_SURFACE_CAPABILITIES_KHR = VkStructureType(1000111000)
        val IMPORT_FENCE_WIN32_HANDLE_INFO_KHR = VkStructureType(1000114000)
        val EXPORT_FENCE_WIN32_HANDLE_INFO_KHR = VkStructureType(1000114001)
        val FENCE_GET_WIN32_HANDLE_INFO_KHR = VkStructureType(1000114002)
        val IMPORT_FENCE_FD_INFO_KHR = VkStructureType(1000115000)
        val FENCE_GET_FD_INFO_KHR = VkStructureType(1000115001)
        val PHYSICAL_DEVICE_SURFACE_INFO_2_KHR = VkStructureType(1000119000)
        val SURFACE_CAPABILITIES_2_KHR = VkStructureType(1000119001)
        val SURFACE_FORMAT_2_KHR = VkStructureType(1000119002)
        val DISPLAY_PROPERTIES_2_KHR = VkStructureType(1000121000)
        val DISPLAY_PLANE_PROPERTIES_2_KHR = VkStructureType(1000121001)
        val DISPLAY_MODE_PROPERTIES_2_KHR = VkStructureType(1000121002)
        val DISPLAY_PLANE_INFO_2_KHR = VkStructureType(1000121003)
        val DISPLAY_PLANE_CAPABILITIES_2_KHR = VkStructureType(1000121004)
        val IOS_SURFACE_CREATE_INFO_MVK = VkStructureType(1000122000)
        val MACOS_SURFACE_CREATE_INFO_MVK = VkStructureType(1000123000)
        val DEBUG_UTILS_OBJECT_NAME_INFO_EXT = VkStructureType(1000128000)
        val DEBUG_UTILS_OBJECT_TAG_INFO_EXT = VkStructureType(1000128001)
        val DEBUG_UTILS_LABEL_EXT = VkStructureType(1000128002)
        val DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT = VkStructureType(1000128003)
        val DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT = VkStructureType(1000128004)
        val ANDROID_HARDWARE_BUFFER_USAGE_ANDROID = VkStructureType(1000129000)
        val ANDROID_HARDWARE_BUFFER_PROPERTIES_ANDROID = VkStructureType(1000129001)
        val ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID = VkStructureType(1000129002)
        val IMPORT_ANDROID_HARDWARE_BUFFER_INFO_ANDROID = VkStructureType(1000129003)
        val MEMORY_GET_ANDROID_HARDWARE_BUFFER_INFO_ANDROID = VkStructureType(1000129004)
        val EXTERNAL_FORMAT_ANDROID = VkStructureType(1000129005)
        val PHYSICAL_DEVICE_SAMPLER_FILTER_MINMAX_PROPERTIES_EXT = VkStructureType(1000130000)
        val SAMPLER_REDUCTION_MODE_CREATE_INFO_EXT = VkStructureType(1000130001)
        val PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_FEATURES_EXT = VkStructureType(1000138000)
        val PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES_EXT = VkStructureType(1000138001)
        val WRITE_DESCRIPTOR_SET_INLINE_UNIFORM_BLOCK_EXT = VkStructureType(1000138002)
        val DESCRIPTOR_POOL_INLINE_UNIFORM_BLOCK_CREATE_INFO_EXT = VkStructureType(1000138003)
        val SAMPLE_LOCATIONS_INFO_EXT = VkStructureType(1000143000)
        val RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT = VkStructureType(1000143001)
        val PIPELINE_SAMPLE_LOCATIONS_STATE_CREATE_INFO_EXT = VkStructureType(1000143002)
        val PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT = VkStructureType(1000143003)
        val MULTISAMPLE_PROPERTIES_EXT = VkStructureType(1000143004)
        val IMAGE_FORMAT_LIST_CREATE_INFO_KHR = VkStructureType(1000147000)
        val PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_FEATURES_EXT = VkStructureType(1000148000)
        val PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT = VkStructureType(1000148001)
        val PIPELINE_COLOR_BLEND_ADVANCED_STATE_CREATE_INFO_EXT = VkStructureType(1000148002)
        val PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV = VkStructureType(1000149000)
        val PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV = VkStructureType(1000152000)
        val DRM_FORMAT_MODIFIER_PROPERTIES_LIST_EXT = VkStructureType(1000158000)
        val DRM_FORMAT_MODIFIER_PROPERTIES_EXT = VkStructureType(1000158001)
        val PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT = VkStructureType(1000158002)
        val IMAGE_DRM_FORMAT_MODIFIER_LIST_CREATE_INFO_EXT = VkStructureType(1000158003)
        val IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT = VkStructureType(1000158004)
        val IMAGE_DRM_FORMAT_MODIFIER_PROPERTIES_EXT = VkStructureType(1000158005)
        val VALIDATION_CACHE_CREATE_INFO_EXT = VkStructureType(1000160000)
        val SHADER_MODULE_VALIDATION_CACHE_CREATE_INFO_EXT = VkStructureType(1000160001)
        val DESCRIPTOR_SET_LAYOUT_BINDING_FLAGS_CREATE_INFO_EXT = VkStructureType(1000161000)
        val PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES_EXT = VkStructureType(1000161001)
        val PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES_EXT = VkStructureType(1000161002)
        val DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO_EXT = VkStructureType(1000161003)
        val DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_LAYOUT_SUPPORT_EXT = VkStructureType(1000161004)
        val PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV = VkStructureType(1000164000)
        val PHYSICAL_DEVICE_SHADING_RATE_IMAGE_FEATURES_NV = VkStructureType(1000164001)
        val PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV = VkStructureType(1000164002)
        val PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV = VkStructureType(1000164005)
        val RAY_TRACING_PIPELINE_CREATE_INFO_NV = VkStructureType(1000165000)
        val ACCELERATION_STRUCTURE_CREATE_INFO_NV = VkStructureType(1000165001)
        val GEOMETRY_NV = VkStructureType(1000165003)
        val GEOMETRY_TRIANGLES_NV = VkStructureType(1000165004)
        val GEOMETRY_AABB_NV = VkStructureType(1000165005)
        val BIND_ACCELERATION_STRUCTURE_MEMORY_INFO_NV = VkStructureType(1000165006)
        val WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV = VkStructureType(1000165007)
        val ACCELERATION_STRUCTURE_MEMORY_REQUIREMENTS_INFO_NV = VkStructureType(1000165008)
        val PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV = VkStructureType(1000165009)
        val RAY_TRACING_SHADER_GROUP_CREATE_INFO_NV = VkStructureType(1000165011)
        val ACCELERATION_STRUCTURE_INFO_NV = VkStructureType(1000165012)
        val PHYSICAL_DEVICE_REPRESENTATIVE_FRAGMENT_TEST_FEATURES_NV = VkStructureType(1000166000)
        val PIPELINE_REPRESENTATIVE_FRAGMENT_TEST_STATE_CREATE_INFO_NV = VkStructureType(1000166001)
        val PHYSICAL_DEVICE_IMAGE_VIEW_IMAGE_FORMAT_INFO_EXT = VkStructureType(1000170000)
        val FILTER_CUBIC_IMAGE_VIEW_IMAGE_FORMAT_PROPERTIES_EXT = VkStructureType(1000170001)
        val DEVICE_QUEUE_GLOBAL_PRIORITY_CREATE_INFO_EXT = VkStructureType(1000174000)
        val PHYSICAL_DEVICE_8BIT_STORAGE_FEATURES_KHR = VkStructureType(1000177000)
        val IMPORT_MEMORY_HOST_POINTER_INFO_EXT = VkStructureType(1000178000)
        val MEMORY_HOST_POINTER_PROPERTIES_EXT = VkStructureType(1000178001)
        val PHYSICAL_DEVICE_EXTERNAL_MEMORY_HOST_PROPERTIES_EXT = VkStructureType(1000178002)
        val PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES_KHR = VkStructureType(1000180000)
        val CALIBRATED_TIMESTAMP_INFO_EXT = VkStructureType(1000184000)
        val PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD = VkStructureType(1000185000)
        val DEVICE_MEMORY_OVERALLOCATION_CREATE_INFO_AMD = VkStructureType(1000189000)
        val PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_PROPERTIES_EXT = VkStructureType(1000190000)
        val PIPELINE_VERTEX_INPUT_DIVISOR_STATE_CREATE_INFO_EXT = VkStructureType(1000190001)
        val PHYSICAL_DEVICE_VERTEX_ATTRIBUTE_DIVISOR_FEATURES_EXT = VkStructureType(1000190002)
        val PHYSICAL_DEVICE_DRIVER_PROPERTIES_KHR = VkStructureType(1000196000)
        val PHYSICAL_DEVICE_FLOAT_CONTROLS_PROPERTIES_KHR = VkStructureType(1000197000)
        val PHYSICAL_DEVICE_DEPTH_STENCIL_RESOLVE_PROPERTIES_KHR = VkStructureType(1000199000)
        val SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE_KHR = VkStructureType(1000199001)
        val PHYSICAL_DEVICE_COMPUTE_SHADER_DERIVATIVES_FEATURES_NV = VkStructureType(1000201000)
        val PHYSICAL_DEVICE_MESH_SHADER_FEATURES_NV = VkStructureType(1000202000)
        val PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV = VkStructureType(1000202001)
        val PHYSICAL_DEVICE_FRAGMENT_SHADER_BARYCENTRIC_FEATURES_NV = VkStructureType(1000203000)
        val PHYSICAL_DEVICE_SHADER_IMAGE_FOOTPRINT_FEATURES_NV = VkStructureType(1000204000)
        val PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV = VkStructureType(1000205000)
        val PHYSICAL_DEVICE_EXCLUSIVE_SCISSOR_FEATURES_NV = VkStructureType(1000205002)
        val CHECKPOINT_DATA_NV = VkStructureType(1000206000)
        val QUEUE_FAMILY_CHECKPOINT_PROPERTIES_NV = VkStructureType(1000206001)
        val PHYSICAL_DEVICE_VULKAN_MEMORY_MODEL_FEATURES_KHR = VkStructureType(1000211000)
        val PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT = VkStructureType(1000212000)
        val IMAGEPIPE_SURFACE_CREATE_INFO_FUCHSIA = VkStructureType(1000214000)
        val PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_FEATURES_EXT = VkStructureType(1000218000)
        val PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT = VkStructureType(1000218001)
        val RENDER_PASS_FRAGMENT_DENSITY_MAP_CREATE_INFO_EXT = VkStructureType(1000218002)
        val PHYSICAL_DEVICE_SCALAR_BLOCK_LAYOUT_FEATURES_EXT = VkStructureType(1000221000)
        val PHYSICAL_DEVICE_MEMORY_BUDGET_PROPERTIES_EXT = VkStructureType(1000237000)
        val PHYSICAL_DEVICE_MEMORY_PRIORITY_FEATURES_EXT = VkStructureType(1000238000)
        val MEMORY_PRIORITY_ALLOCATE_INFO_EXT = VkStructureType(1000238001)
        val PHYSICAL_DEVICE_DEDICATED_ALLOCATION_IMAGE_ALIASING_FEATURES_NV = VkStructureType(1000240000)
        val PHYSICAL_DEVICE_BUFFER_ADDRESS_FEATURES_EXT = VkStructureType(1000244000)
        val BUFFER_DEVICE_ADDRESS_INFO_EXT = VkStructureType(1000244001)
        val BUFFER_DEVICE_ADDRESS_CREATE_INFO_EXT = VkStructureType(1000244002)
        val IMAGE_STENCIL_USAGE_CREATE_INFO_EXT = VkStructureType(1000246000)
        val VALIDATION_FEATURES_EXT = VkStructureType(1000247000)
        val DEBUG_REPORT_CREATE_INFO_EXT = VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
        val RENDER_PASS_MULTIVIEW_CREATE_INFO_KHR = VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO
        val PHYSICAL_DEVICE_MULTIVIEW_FEATURES_KHR = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_FEATURES
        val PHYSICAL_DEVICE_MULTIVIEW_PROPERTIES_KHR = VkStructureType.PHYSICAL_DEVICE_MULTIVIEW_PROPERTIES
        val PHYSICAL_DEVICE_FEATURES_2_KHR = VkStructureType.PHYSICAL_DEVICE_FEATURES_2
        val PHYSICAL_DEVICE_PROPERTIES_2_KHR = VkStructureType.PHYSICAL_DEVICE_PROPERTIES_2
        val FORMAT_PROPERTIES_2_KHR = VkStructureType.FORMAT_PROPERTIES_2
        val IMAGE_FORMAT_PROPERTIES_2_KHR = VkStructureType.IMAGE_FORMAT_PROPERTIES_2
        val PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2_KHR = VkStructureType.PHYSICAL_DEVICE_IMAGE_FORMAT_INFO_2
        val QUEUE_FAMILY_PROPERTIES_2_KHR = VkStructureType.QUEUE_FAMILY_PROPERTIES_2
        val PHYSICAL_DEVICE_MEMORY_PROPERTIES_2_KHR = VkStructureType.PHYSICAL_DEVICE_MEMORY_PROPERTIES_2
        val SPARSE_IMAGE_FORMAT_PROPERTIES_2_KHR = VkStructureType.SPARSE_IMAGE_FORMAT_PROPERTIES_2
        val PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2_KHR = VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2
        val MEMORY_ALLOCATE_FLAGS_INFO_KHR = VkStructureType.MEMORY_ALLOCATE_FLAGS_INFO
        val DEVICE_GROUP_RENDER_PASS_BEGIN_INFO_KHR = VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO
        val DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO_KHR = VkStructureType.DEVICE_GROUP_COMMAND_BUFFER_BEGIN_INFO
        val DEVICE_GROUP_SUBMIT_INFO_KHR = VkStructureType.DEVICE_GROUP_SUBMIT_INFO
        val DEVICE_GROUP_BIND_SPARSE_INFO_KHR = VkStructureType.DEVICE_GROUP_BIND_SPARSE_INFO
        val BIND_BUFFER_MEMORY_DEVICE_GROUP_INFO_KHR = VkStructureType.BIND_BUFFER_MEMORY_DEVICE_GROUP_INFO
        val BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO_KHR = VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO
        val PHYSICAL_DEVICE_GROUP_PROPERTIES_KHR = VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES
        val DEVICE_GROUP_DEVICE_CREATE_INFO_KHR = VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO
        val PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO_KHR = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_IMAGE_FORMAT_INFO
        val EXTERNAL_IMAGE_FORMAT_PROPERTIES_KHR = VkStructureType.EXTERNAL_IMAGE_FORMAT_PROPERTIES
        val PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO_KHR = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO
        val EXTERNAL_BUFFER_PROPERTIES_KHR = VkStructureType.EXTERNAL_BUFFER_PROPERTIES
        val PHYSICAL_DEVICE_ID_PROPERTIES_KHR = VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES
        val EXTERNAL_MEMORY_BUFFER_CREATE_INFO_KHR = VkStructureType.EXTERNAL_MEMORY_BUFFER_CREATE_INFO
        val EXTERNAL_MEMORY_IMAGE_CREATE_INFO_KHR = VkStructureType.EXTERNAL_MEMORY_IMAGE_CREATE_INFO
        val EXPORT_MEMORY_ALLOCATE_INFO_KHR = VkStructureType.EXPORT_MEMORY_ALLOCATE_INFO
        val PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO_KHR = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_SEMAPHORE_INFO
        val EXTERNAL_SEMAPHORE_PROPERTIES_KHR = VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES
        val EXPORT_SEMAPHORE_CREATE_INFO_KHR = VkStructureType.EXPORT_SEMAPHORE_CREATE_INFO
        val PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES_KHR = VkStructureType.PHYSICAL_DEVICE_16BIT_STORAGE_FEATURES
        val DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO_KHR = VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO
        val SURFACE_CAPABILITIES2_EXT = VkStructureType.SURFACE_CAPABILITIES_2_EXT
        val PHYSICAL_DEVICE_EXTERNAL_FENCE_INFO_KHR = VkStructureType.PHYSICAL_DEVICE_EXTERNAL_FENCE_INFO
        val EXTERNAL_FENCE_PROPERTIES_KHR = VkStructureType.EXTERNAL_FENCE_PROPERTIES
        val EXPORT_FENCE_CREATE_INFO_KHR = VkStructureType.EXPORT_FENCE_CREATE_INFO
        val PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES_KHR = VkStructureType.PHYSICAL_DEVICE_POINT_CLIPPING_PROPERTIES
        val RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO_KHR = VkStructureType.RENDER_PASS_INPUT_ATTACHMENT_ASPECT_CREATE_INFO
        val IMAGE_VIEW_USAGE_CREATE_INFO_KHR = VkStructureType.IMAGE_VIEW_USAGE_CREATE_INFO
        val PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO_KHR = VkStructureType.PIPELINE_TESSELLATION_DOMAIN_ORIGIN_STATE_CREATE_INFO
        val PHYSICAL_DEVICE_VARIABLE_POINTER_FEATURES_KHR = VkStructureType.PHYSICAL_DEVICE_VARIABLE_POINTER_FEATURES
        val MEMORY_DEDICATED_REQUIREMENTS_KHR = VkStructureType.MEMORY_DEDICATED_REQUIREMENTS
        val MEMORY_DEDICATED_ALLOCATE_INFO_KHR = VkStructureType.MEMORY_DEDICATED_ALLOCATE_INFO
        val BUFFER_MEMORY_REQUIREMENTS_INFO_2_KHR = VkStructureType.BUFFER_MEMORY_REQUIREMENTS_INFO_2
        val IMAGE_MEMORY_REQUIREMENTS_INFO_2_KHR = VkStructureType.IMAGE_MEMORY_REQUIREMENTS_INFO_2
        val IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2_KHR = VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2
        val MEMORY_REQUIREMENTS_2_KHR = VkStructureType.MEMORY_REQUIREMENTS_2
        val SPARSE_IMAGE_MEMORY_REQUIREMENTS_2_KHR = VkStructureType.SPARSE_IMAGE_MEMORY_REQUIREMENTS_2
        val SAMPLER_YCBCR_CONVERSION_CREATE_INFO_KHR = VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO
        val SAMPLER_YCBCR_CONVERSION_INFO_KHR = VkStructureType.SAMPLER_YCBCR_CONVERSION_INFO
        val BIND_IMAGE_PLANE_MEMORY_INFO_KHR = VkStructureType.BIND_IMAGE_PLANE_MEMORY_INFO
        val IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO_KHR = VkStructureType.IMAGE_PLANE_MEMORY_REQUIREMENTS_INFO
        val PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES_KHR = VkStructureType.PHYSICAL_DEVICE_SAMPLER_YCBCR_CONVERSION_FEATURES
        val SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES_KHR = VkStructureType.SAMPLER_YCBCR_CONVERSION_IMAGE_FORMAT_PROPERTIES
        val BIND_BUFFER_MEMORY_INFO_KHR = VkStructureType.BIND_BUFFER_MEMORY_INFO
        val BIND_IMAGE_MEMORY_INFO_KHR = VkStructureType.BIND_IMAGE_MEMORY_INFO
        val PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES_KHR = VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES
        val DESCRIPTOR_SET_LAYOUT_SUPPORT_KHR = VkStructureType.DESCRIPTOR_SET_LAYOUT_SUPPORT
    }
}


inline class VkSystemAllocationScope(val i: Int) {

    companion object {
        val COMMAND = VkSystemAllocationScope(0)
        val OBJECT = VkSystemAllocationScope(1)
        val CACHE = VkSystemAllocationScope(2)
        val DEVICE = VkSystemAllocationScope(3)
        val INSTANCE = VkSystemAllocationScope(4)
    }
}

inline class VkInternalAllocationType(val i: Int) {
    companion object {
        val EXECUTABLE = VkInternalAllocationType(0)
    }
}


inline class VkFormat(val i: Int) {
    companion object {
        val UNDEFINED = VkFormat(0)
        val R4G4_UNORM_PACK8 = VkFormat(1)
        val R4G4B4A4_UNORM_PACK16 = VkFormat(2)
        val B4G4R4A4_UNORM_PACK16 = VkFormat(3)
        val R5G6B5_UNORM_PACK16 = VkFormat(4)
        val B5G6R5_UNORM_PACK16 = VkFormat(5)
        val R5G5B5A1_UNORM_PACK16 = VkFormat(6)
        val B5G5R5A1_UNORM_PACK16 = VkFormat(7)
        val A1R5G5B5_UNORM_PACK16 = VkFormat(8)
        val R8_UNORM = VkFormat(9)
        val R8_SNORM = VkFormat(10)
        val R8_USCALED = VkFormat(11)
        val R8_SSCALED = VkFormat(12)
        val R8_UINT = VkFormat(13)
        val R8_SINT = VkFormat(14)
        val R8_SRGB = VkFormat(15)
        val R8G8_UNORM = VkFormat(16)
        val R8G8_SNORM = VkFormat(17)
        val R8G8_USCALED = VkFormat(18)
        val R8G8_SSCALED = VkFormat(19)
        val R8G8_UINT = VkFormat(20)
        val R8G8_SINT = VkFormat(21)
        val R8G8_SRGB = VkFormat(22)
        val R8G8B8_UNORM = VkFormat(23)
        val R8G8B8_SNORM = VkFormat(24)
        val R8G8B8_USCALED = VkFormat(25)
        val R8G8B8_SSCALED = VkFormat(26)
        val R8G8B8_UINT = VkFormat(27)
        val R8G8B8_SINT = VkFormat(28)
        val R8G8B8_SRGB = VkFormat(29)
        val B8G8R8_UNORM = VkFormat(30)
        val B8G8R8_SNORM = VkFormat(31)
        val B8G8R8_USCALED = VkFormat(32)
        val B8G8R8_SSCALED = VkFormat(33)
        val B8G8R8_UINT = VkFormat(34)
        val B8G8R8_SINT = VkFormat(35)
        val B8G8R8_SRGB = VkFormat(36)
        val R8G8B8A8_UNORM = VkFormat(37)
        val R8G8B8A8_SNORM = VkFormat(38)
        val R8G8B8A8_USCALED = VkFormat(39)
        val R8G8B8A8_SSCALED = VkFormat(40)
        val R8G8B8A8_UINT = VkFormat(41)
        val R8G8B8A8_SINT = VkFormat(42)
        val R8G8B8A8_SRGB = VkFormat(43)
        val B8G8R8A8_UNORM = VkFormat(44)
        val B8G8R8A8_SNORM = VkFormat(45)
        val B8G8R8A8_USCALED = VkFormat(46)
        val B8G8R8A8_SSCALED = VkFormat(47)
        val B8G8R8A8_UINT = VkFormat(48)
        val B8G8R8A8_SINT = VkFormat(49)
        val B8G8R8A8_SRGB = VkFormat(50)
        val A8B8G8R8_UNORM_PACK32 = VkFormat(51)
        val A8B8G8R8_SNORM_PACK32 = VkFormat(52)
        val A8B8G8R8_USCALED_PACK32 = VkFormat(53)
        val A8B8G8R8_SSCALED_PACK32 = VkFormat(54)
        val A8B8G8R8_UINT_PACK32 = VkFormat(55)
        val A8B8G8R8_SINT_PACK32 = VkFormat(56)
        val A8B8G8R8_SRGB_PACK32 = VkFormat(57)
        val A2R10G10B10_UNORM_PACK32 = VkFormat(58)
        val A2R10G10B10_SNORM_PACK32 = VkFormat(59)
        val A2R10G10B10_USCALED_PACK32 = VkFormat(60)
        val A2R10G10B10_SSCALED_PACK32 = VkFormat(61)
        val A2R10G10B10_UINT_PACK32 = VkFormat(62)
        val A2R10G10B10_SINT_PACK32 = VkFormat(63)
        val A2B10G10R10_UNORM_PACK32 = VkFormat(64)
        val A2B10G10R10_SNORM_PACK32 = VkFormat(65)
        val A2B10G10R10_USCALED_PACK32 = VkFormat(66)
        val A2B10G10R10_SSCALED_PACK32 = VkFormat(67)
        val A2B10G10R10_UINT_PACK32 = VkFormat(68)
        val A2B10G10R10_SINT_PACK32 = VkFormat(69)
        val R16_UNORM = VkFormat(70)
        val R16_SNORM = VkFormat(71)
        val R16_USCALED = VkFormat(72)
        val R16_SSCALED = VkFormat(73)
        val R16_UINT = VkFormat(74)
        val R16_SINT = VkFormat(75)
        val R16_SFLOAT = VkFormat(76)
        val R16G16_UNORM = VkFormat(77)
        val R16G16_SNORM = VkFormat(78)
        val R16G16_USCALED = VkFormat(79)
        val R16G16_SSCALED = VkFormat(80)
        val R16G16_UINT = VkFormat(81)
        val R16G16_SINT = VkFormat(82)
        val R16G16_SFLOAT = VkFormat(83)
        val R16G16B16_UNORM = VkFormat(84)
        val R16G16B16_SNORM = VkFormat(85)
        val R16G16B16_USCALED = VkFormat(86)
        val R16G16B16_SSCALED = VkFormat(87)
        val R16G16B16_UINT = VkFormat(88)
        val R16G16B16_SINT = VkFormat(89)
        val R16G16B16_SFLOAT = VkFormat(90)
        val R16G16B16A16_UNORM = VkFormat(91)
        val R16G16B16A16_SNORM = VkFormat(92)
        val R16G16B16A16_USCALED = VkFormat(93)
        val R16G16B16A16_SSCALED = VkFormat(94)
        val R16G16B16A16_UINT = VkFormat(95)
        val R16G16B16A16_SINT = VkFormat(96)
        val R16G16B16A16_SFLOAT = VkFormat(97)
        val R32_UINT = VkFormat(98)
        val R32_SINT = VkFormat(99)
        val R32_SFLOAT = VkFormat(100)
        val R32G32_UINT = VkFormat(101)
        val R32G32_SINT = VkFormat(102)
        val R32G32_SFLOAT = VkFormat(103)
        val R32G32B32_UINT = VkFormat(104)
        val R32G32B32_SINT = VkFormat(105)
        val R32G32B32_SFLOAT = VkFormat(106)
        val R32G32B32A32_UINT = VkFormat(107)
        val R32G32B32A32_SINT = VkFormat(108)
        val R32G32B32A32_SFLOAT = VkFormat(109)
        val R64_UINT = VkFormat(110)
        val R64_SINT = VkFormat(111)
        val R64_SFLOAT = VkFormat(112)
        val R64G64_UINT = VkFormat(113)
        val R64G64_SINT = VkFormat(114)
        val R64G64_SFLOAT = VkFormat(115)
        val R64G64B64_UINT = VkFormat(116)
        val R64G64B64_SINT = VkFormat(117)
        val R64G64B64_SFLOAT = VkFormat(118)
        val R64G64B64A64_UINT = VkFormat(119)
        val R64G64B64A64_SINT = VkFormat(120)
        val R64G64B64A64_SFLOAT = VkFormat(121)
        val B10G11R11_UFLOAT_PACK32 = VkFormat(122)
        val E5B9G9R9_UFLOAT_PACK32 = VkFormat(123)
        val D16_UNORM = VkFormat(124)
        val X8_D24_UNORM_PACK32 = VkFormat(125)
        val D32_SFLOAT = VkFormat(126)
        val S8_UINT = VkFormat(127)
        val D16_UNORM_S8_UINT = VkFormat(128)
        val D24_UNORM_S8_UINT = VkFormat(129)
        val D32_SFLOAT_S8_UINT = VkFormat(130)
        val BC1_RGB_UNORM_BLOCK = VkFormat(131)
        val BC1_RGB_SRGB_BLOCK = VkFormat(132)
        val BC1_RGBA_UNORM_BLOCK = VkFormat(133)
        val BC1_RGBA_SRGB_BLOCK = VkFormat(134)
        val BC2_UNORM_BLOCK = VkFormat(135)
        val BC2_SRGB_BLOCK = VkFormat(136)
        val BC3_UNORM_BLOCK = VkFormat(137)
        val BC3_SRGB_BLOCK = VkFormat(138)
        val BC4_UNORM_BLOCK = VkFormat(139)
        val BC4_SNORM_BLOCK = VkFormat(140)
        val BC5_UNORM_BLOCK = VkFormat(141)
        val BC5_SNORM_BLOCK = VkFormat(142)
        val BC6H_UFLOAT_BLOCK = VkFormat(143)
        val BC6H_SFLOAT_BLOCK = VkFormat(144)
        val BC7_UNORM_BLOCK = VkFormat(145)
        val BC7_SRGB_BLOCK = VkFormat(146)
        val ETC2_R8G8B8_UNORM_BLOCK = VkFormat(147)
        val ETC2_R8G8B8_SRGB_BLOCK = VkFormat(148)
        val ETC2_R8G8B8A1_UNORM_BLOCK = VkFormat(149)
        val ETC2_R8G8B8A1_SRGB_BLOCK = VkFormat(150)
        val ETC2_R8G8B8A8_UNORM_BLOCK = VkFormat(151)
        val ETC2_R8G8B8A8_SRGB_BLOCK = VkFormat(152)
        val EAC_R11_UNORM_BLOCK = VkFormat(153)
        val EAC_R11_SNORM_BLOCK = VkFormat(154)
        val EAC_R11G11_UNORM_BLOCK = VkFormat(155)
        val EAC_R11G11_SNORM_BLOCK = VkFormat(156)
        val ASTC_4x4_UNORM_BLOCK = VkFormat(157)
        val ASTC_4x4_SRGB_BLOCK = VkFormat(158)
        val ASTC_5x4_UNORM_BLOCK = VkFormat(159)
        val ASTC_5x4_SRGB_BLOCK = VkFormat(160)
        val ASTC_5x5_UNORM_BLOCK = VkFormat(161)
        val ASTC_5x5_SRGB_BLOCK = VkFormat(162)
        val ASTC_6x5_UNORM_BLOCK = VkFormat(163)
        val ASTC_6x5_SRGB_BLOCK = VkFormat(164)
        val ASTC_6x6_UNORM_BLOCK = VkFormat(165)
        val ASTC_6x6_SRGB_BLOCK = VkFormat(166)
        val ASTC_8x5_UNORM_BLOCK = VkFormat(167)
        val ASTC_8x5_SRGB_BLOCK = VkFormat(168)
        val ASTC_8x6_UNORM_BLOCK = VkFormat(169)
        val ASTC_8x6_SRGB_BLOCK = VkFormat(170)
        val ASTC_8x8_UNORM_BLOCK = VkFormat(171)
        val ASTC_8x8_SRGB_BLOCK = VkFormat(172)
        val ASTC_10x5_UNORM_BLOCK = VkFormat(173)
        val ASTC_10x5_SRGB_BLOCK = VkFormat(174)
        val ASTC_10x6_UNORM_BLOCK = VkFormat(175)
        val ASTC_10x6_SRGB_BLOCK = VkFormat(176)
        val ASTC_10x8_UNORM_BLOCK = VkFormat(177)
        val ASTC_10x8_SRGB_BLOCK = VkFormat(178)
        val ASTC_10x10_UNORM_BLOCK = VkFormat(179)
        val ASTC_10x10_SRGB_BLOCK = VkFormat(180)
        val ASTC_12x10_UNORM_BLOCK = VkFormat(181)
        val ASTC_12x10_SRGB_BLOCK = VkFormat(182)
        val ASTC_12x12_UNORM_BLOCK = VkFormat(183)
        val ASTC_12x12_SRGB_BLOCK = VkFormat(184)
        val G8B8G8R8_422_UNORM = VkFormat(1000156000)
        val B8G8R8G8_422_UNORM = VkFormat(1000156001)
        val G8_B8_R8_3PLANE_420_UNORM = VkFormat(1000156002)
        val G8_B8R8_2PLANE_420_UNORM = VkFormat(1000156003)
        val G8_B8_R8_3PLANE_422_UNORM = VkFormat(1000156004)
        val G8_B8R8_2PLANE_422_UNORM = VkFormat(1000156005)
        val G8_B8_R8_3PLANE_444_UNORM = VkFormat(1000156006)
        val R10X6_UNORM_PACK16 = VkFormat(1000156007)
        val R10X6G10X6_UNORM_2PACK16 = VkFormat(1000156008)
        val R10X6G10X6B10X6A10X6_UNORM_4PACK16 = VkFormat(1000156009)
        val G10X6B10X6G10X6R10X6_422_UNORM_4PACK16 = VkFormat(1000156010)
        val B10X6G10X6R10X6G10X6_422_UNORM_4PACK16 = VkFormat(1000156011)
        val G10X6_B10X6_R10X6_3PLANE_420_UNORM_3PACK16 = VkFormat(1000156012)
        val G10X6_B10X6R10X6_2PLANE_420_UNORM_3PACK16 = VkFormat(1000156013)
        val G10X6_B10X6_R10X6_3PLANE_422_UNORM_3PACK16 = VkFormat(1000156014)
        val G10X6_B10X6R10X6_2PLANE_422_UNORM_3PACK16 = VkFormat(1000156015)
        val G10X6_B10X6_R10X6_3PLANE_444_UNORM_3PACK16 = VkFormat(1000156016)
        val R12X4_UNORM_PACK16 = VkFormat(1000156017)
        val R12X4G12X4_UNORM_2PACK16 = VkFormat(1000156018)
        val R12X4G12X4B12X4A12X4_UNORM_4PACK16 = VkFormat(1000156019)
        val G12X4B12X4G12X4R12X4_422_UNORM_4PACK16 = VkFormat(1000156020)
        val B12X4G12X4R12X4G12X4_422_UNORM_4PACK16 = VkFormat(1000156021)
        val G12X4_B12X4_R12X4_3PLANE_420_UNORM_3PACK16 = VkFormat(1000156022)
        val G12X4_B12X4R12X4_2PLANE_420_UNORM_3PACK16 = VkFormat(1000156023)
        val G12X4_B12X4_R12X4_3PLANE_422_UNORM_3PACK16 = VkFormat(1000156024)
        val G12X4_B12X4R12X4_2PLANE_422_UNORM_3PACK16 = VkFormat(1000156025)
        val G12X4_B12X4_R12X4_3PLANE_444_UNORM_3PACK16 = VkFormat(1000156026)
        val G16B16G16R16_422_UNORM = VkFormat(1000156027)
        val B16G16R16G16_422_UNORM = VkFormat(1000156028)
        val G16_B16_R16_3PLANE_420_UNORM = VkFormat(1000156029)
        val G16_B16R16_2PLANE_420_UNORM = VkFormat(1000156030)
        val G16_B16_R16_3PLANE_422_UNORM = VkFormat(1000156031)
        val G16_B16R16_2PLANE_422_UNORM = VkFormat(1000156032)
        val G16_B16_R16_3PLANE_444_UNORM = VkFormat(1000156033)
        val PVRTC1_2BPP_UNORM_BLOCK_IMG = VkFormat(1000054000)
        val PVRTC1_4BPP_UNORM_BLOCK_IMG = VkFormat(1000054001)
        val PVRTC2_2BPP_UNORM_BLOCK_IMG = VkFormat(1000054002)
        val PVRTC2_4BPP_UNORM_BLOCK_IMG = VkFormat(1000054003)
        val PVRTC1_2BPP_SRGB_BLOCK_IMG = VkFormat(1000054004)
        val PVRTC1_4BPP_SRGB_BLOCK_IMG = VkFormat(1000054005)
        val PVRTC2_2BPP_SRGB_BLOCK_IMG = VkFormat(1000054006)
        val PVRTC2_4BPP_SRGB_BLOCK_IMG = VkFormat(1000054007)
        val G8B8G8R8_422_UNORM_KHR = VkFormat.G8B8G8R8_422_UNORM
        val B8G8R8G8_422_UNORM_KHR = VkFormat.B8G8R8G8_422_UNORM
        val G8_B8_R8_3PLANE_420_UNORM_KHR = VkFormat.G8_B8_R8_3PLANE_420_UNORM
        val G8_B8R8_2PLANE_420_UNORM_KHR = VkFormat.G8_B8R8_2PLANE_420_UNORM
        val G8_B8_R8_3PLANE_422_UNORM_KHR = VkFormat.G8_B8_R8_3PLANE_422_UNORM
        val G8_B8R8_2PLANE_422_UNORM_KHR = VkFormat.G8_B8R8_2PLANE_422_UNORM
        val G8_B8_R8_3PLANE_444_UNORM_KHR = VkFormat.G8_B8_R8_3PLANE_444_UNORM
        val R10X6_UNORM_PACK16_KHR = VkFormat.R10X6_UNORM_PACK16
        val R10X6G10X6_UNORM_2PACK16_KHR = VkFormat.R10X6G10X6_UNORM_2PACK16
        val R10X6G10X6B10X6A10X6_UNORM_4PACK16_KHR = VkFormat.R10X6G10X6B10X6A10X6_UNORM_4PACK16
        val G10X6B10X6G10X6R10X6_422_UNORM_4PACK16_KHR = VkFormat.G10X6B10X6G10X6R10X6_422_UNORM_4PACK16
        val B10X6G10X6R10X6G10X6_422_UNORM_4PACK16_KHR = VkFormat.B10X6G10X6R10X6G10X6_422_UNORM_4PACK16
        val G10X6_B10X6_R10X6_3PLANE_420_UNORM_3PACK16_KHR = VkFormat.G10X6_B10X6_R10X6_3PLANE_420_UNORM_3PACK16
        val G10X6_B10X6R10X6_2PLANE_420_UNORM_3PACK16_KHR = VkFormat.G10X6_B10X6R10X6_2PLANE_420_UNORM_3PACK16
        val G10X6_B10X6_R10X6_3PLANE_422_UNORM_3PACK16_KHR = VkFormat.G10X6_B10X6_R10X6_3PLANE_422_UNORM_3PACK16
        val G10X6_B10X6R10X6_2PLANE_422_UNORM_3PACK16_KHR = VkFormat.G10X6_B10X6R10X6_2PLANE_422_UNORM_3PACK16
        val G10X6_B10X6_R10X6_3PLANE_444_UNORM_3PACK16_KHR = VkFormat.G10X6_B10X6_R10X6_3PLANE_444_UNORM_3PACK16
        val R12X4_UNORM_PACK16_KHR = VkFormat.R12X4_UNORM_PACK16
        val R12X4G12X4_UNORM_2PACK16_KHR = VkFormat.R12X4G12X4_UNORM_2PACK16
        val R12X4G12X4B12X4A12X4_UNORM_4PACK16_KHR = VkFormat.R12X4G12X4B12X4A12X4_UNORM_4PACK16
        val G12X4B12X4G12X4R12X4_422_UNORM_4PACK16_KHR = VkFormat.G12X4B12X4G12X4R12X4_422_UNORM_4PACK16
        val B12X4G12X4R12X4G12X4_422_UNORM_4PACK16_KHR = VkFormat.B12X4G12X4R12X4G12X4_422_UNORM_4PACK16
        val G12X4_B12X4_R12X4_3PLANE_420_UNORM_3PACK16_KHR = VkFormat.G12X4_B12X4_R12X4_3PLANE_420_UNORM_3PACK16
        val G12X4_B12X4R12X4_2PLANE_420_UNORM_3PACK16_KHR = VkFormat.G12X4_B12X4R12X4_2PLANE_420_UNORM_3PACK16
        val G12X4_B12X4_R12X4_3PLANE_422_UNORM_3PACK16_KHR = VkFormat.G12X4_B12X4_R12X4_3PLANE_422_UNORM_3PACK16
        val G12X4_B12X4R12X4_2PLANE_422_UNORM_3PACK16_KHR = VkFormat.G12X4_B12X4R12X4_2PLANE_422_UNORM_3PACK16
        val G12X4_B12X4_R12X4_3PLANE_444_UNORM_3PACK16_KHR = VkFormat.G12X4_B12X4_R12X4_3PLANE_444_UNORM_3PACK16
        val G16B16G16R16_422_UNORM_KHR = VkFormat.G16B16G16R16_422_UNORM
        val B16G16R16G16_422_UNORM_KHR = VkFormat.B16G16R16G16_422_UNORM
        val G16_B16_R16_3PLANE_420_UNORM_KHR = VkFormat.G16_B16_R16_3PLANE_420_UNORM
        val G16_B16R16_2PLANE_420_UNORM_KHR = VkFormat.G16_B16R16_2PLANE_420_UNORM
        val G16_B16_R16_3PLANE_422_UNORM_KHR = VkFormat.G16_B16_R16_3PLANE_422_UNORM
        val G16_B16R16_2PLANE_422_UNORM_KHR = VkFormat.G16_B16R16_2PLANE_422_UNORM
        val G16_B16_R16_3PLANE_444_UNORM_KHR = VkFormat.G16_B16_R16_3PLANE_444_UNORM
    }
}


inline class VkImageType(val i: Int) {
    companion object {
        val _1D = VkImageType(0)
        val _2D = VkImageType(1)
        val _3D = VkImageType(2)
    }
}

inline class VkImageTiling(val i: Int) {
    companion object {
        val OPTIMAL = VkImageTiling(0)
        val LINEAR = VkImageTiling(1)
        val DRM_FORMAT_MODIFIER_EXT = VkImageTiling(1000158000)
    }
}

inline class VkPhysicalDeviceType(val i: Int) {
    companion object {
        val OTHER = VkPhysicalDeviceType(0)
        val INTEGRATED_GPU = VkPhysicalDeviceType(1)
        val DISCRETE_GPU = VkPhysicalDeviceType(2)
        val VIRTUAL_GPU = VkPhysicalDeviceType(3)
        val CPU = VkPhysicalDeviceType(4)
    }
}

inline class VkQueryType(val i: Int) {
    companion object {
        val OCCLUSION = VkQueryType(0)
        val PIPELINE_STATISTICS = VkQueryType(1)
        val TIMESTAMP = VkQueryType(2)
        val TRANSFORM_FEEDBACK_STREAM_EXT = VkQueryType(1000028004)
        val ACCELERATION_STRUCTURE_COMPACTED_SIZE_NV = VkQueryType(1000165000)
    }
}

inline class VkSharingMode(val i: Int) {
    companion object {
        val EXCLUSIVE = VkSharingMode(0)
        val CONCURRENT = VkSharingMode(1)
    }
}

inline class VkImageLayout(val i: Int) {

    companion object {
        val UNDEFINED = VkImageLayout(0)
        val GENERAL = VkImageLayout(1)
        val COLOR_ATTACHMENT_OPTIMAL = VkImageLayout(2)
        val DEPTH_STENCIL_ATTACHMENT_OPTIMAL = VkImageLayout(3)
        val DEPTH_STENCIL_READ_ONLY_OPTIMAL = VkImageLayout(4)
        val SHADER_READ_ONLY_OPTIMAL = VkImageLayout(5)
        val TRANSFER_SRC_OPTIMAL = VkImageLayout(6)
        val TRANSFER_DST_OPTIMAL = VkImageLayout(7)
        val PREINITIALIZED = VkImageLayout(8)
        val DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL = VkImageLayout(1000117000)
        val DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL = VkImageLayout(1000117001)
        val PRESENT_SRC_KHR = VkImageLayout(1000001002)
        val SHARED_PRESENT_KHR = VkImageLayout(1000111000)
        val SHADING_RATE_OPTIMAL_NV = VkImageLayout(1000164003)
        val FRAGMENT_DENSITY_MAP_OPTIMAL_EXT = VkImageLayout(1000218000)
        val DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL_KHR = VkImageLayout.DEPTH_READ_ONLY_STENCIL_ATTACHMENT_OPTIMAL
        val DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL_KHR = VkImageLayout.DEPTH_ATTACHMENT_STENCIL_READ_ONLY_OPTIMAL
    }

    val accessMask: VkAccessFlags
        get() = when (this) {
            PREINITIALIZED -> VkAccess.HOST_WRITE_BIT.i
            COLOR_ATTACHMENT_OPTIMAL -> VkAccess.COLOR_ATTACHMENT_WRITE_BIT.i
            DEPTH_STENCIL_ATTACHMENT_OPTIMAL -> VkAccess.DEPTH_STENCIL_ATTACHMENT_WRITE_BIT.i
            TRANSFER_SRC_OPTIMAL -> VkAccess.TRANSFER_READ_BIT.i
            TRANSFER_DST_OPTIMAL -> VkAccess.TRANSFER_WRITE_BIT.i
            SHADER_READ_ONLY_OPTIMAL -> VkAccess.SHADER_READ_BIT.i
            else -> 0
        }
}


inline class VkImageViewType(val i: Int) {
    companion object {
        val _1D = VkImageViewType(0)
        val _2D = VkImageViewType(1)
        val _3D = VkImageViewType(2)
        val CUBE = VkImageViewType(3)
        val _1D_ARRAY = VkImageViewType(4)
        val _2D_ARRAY = VkImageViewType(5)
        val CUBE_ARRAY = VkImageViewType(6)
    }
}


inline class VkComponentSwizzle(val i: Int) {
    companion object {
        val IDENTITY = VkComponentSwizzle(0)
        val ZERO = VkComponentSwizzle(1)
        val ONE = VkComponentSwizzle(2)
        val R = VkComponentSwizzle(3)
        val G = VkComponentSwizzle(4)
        val B = VkComponentSwizzle(5)
        val A = VkComponentSwizzle(6)
    }
}


inline class VkVertexInputRate(val i: Int) {
    companion object {
        val VERTEX = VkVertexInputRate(0)
        val INSTANCE = VkVertexInputRate(1)
    }
}

inline class VkPrimitiveTopology(val i: Int) {
    companion object {
        val POINT_LIST = VkPrimitiveTopology(0)
        val LINE_LIST = VkPrimitiveTopology(1)
        val LINE_STRIP = VkPrimitiveTopology(2)
        val TRIANGLE_LIST = VkPrimitiveTopology(3)
        val TRIANGLE_STRIP = VkPrimitiveTopology(4)
        val TRIANGLE_FAN = VkPrimitiveTopology(5)
        val LINE_LIST_WITH_ADJACENCY = VkPrimitiveTopology(6)
        val LINE_STRIP_WITH_ADJACENCY = VkPrimitiveTopology(7)
        val TRIANGLE_LIST_WITH_ADJACENCY = VkPrimitiveTopology(8)
        val TRIANGLE_STRIP_WITH_ADJACENCY = VkPrimitiveTopology(9)
        val PATCH_LIST = VkPrimitiveTopology(10)
    }
}


inline class VkPolygonMode(val i: Int) {
    companion object {
        val FILL = VkPolygonMode(0)
        val LINE = VkPolygonMode(1)
        val POINT = VkPolygonMode(2)
        val FILL_RECTANGLE_NV = VkPolygonMode(1000153000)
    }
}

inline class VkFrontFace(val i: Int) {
    companion object {
        val COUNTER_CLOCKWISE = VkFrontFace(0)
        val CLOCKWISE = VkFrontFace(1)
    }
}


inline class VkCompareOp(val i: Int) {
    companion object {
        val NEVER = VkCompareOp(0)
        val LESS = VkCompareOp(1)
        val EQUAL = VkCompareOp(2)
        val LESS_OR_EQUAL = VkCompareOp(3)
        val GREATER = VkCompareOp(4)
        val NOT_EQUAL = VkCompareOp(5)
        val GREATER_OR_EQUAL = VkCompareOp(6)
        val ALWAYS = VkCompareOp(7)
    }
}

inline class VkStencilOp(val i: Int) {
    companion object {
        val KEEP = VkStencilOp(0)
        val ZERO = VkStencilOp(1)
        val REPLACE = VkStencilOp(2)
        val INCREMENT_AND_CLAMP = VkStencilOp(3)
        val DECREMENT_AND_CLAMP = VkStencilOp(4)
        val INVERT = VkStencilOp(5)
        val INCREMENT_AND_WRAP = VkStencilOp(6)
        val DECREMENT_AND_WRAP = VkStencilOp(7)
    }
}


inline class VkLogicOp(val i: Int) {
    companion object {
        val CLEAR = VkLogicOp(0)
        val AND = VkLogicOp(1)
        val AND_REVERSE = VkLogicOp(2)
        val COPY = VkLogicOp(3)
        val AND_INVERTED = VkLogicOp(4)
        val NO_OP = VkLogicOp(5)
        val XOR = VkLogicOp(6)
        val OR = VkLogicOp(7)
        val NOR = VkLogicOp(8)
        val EQUIVALENT = VkLogicOp(9)
        val INVERT = VkLogicOp(10)
        val OR_REVERSE = VkLogicOp(11)
        val COPY_INVERTED = VkLogicOp(12)
        val OR_INVERTED = VkLogicOp(13)
        val NAND = VkLogicOp(14)
        val SET = VkLogicOp(15)
    }
}

inline class VkBlendFactor(val i: Int) {
    companion object {
        val ZERO = VkBlendFactor(0)
        val ONE = VkBlendFactor(1)
        val SRC_COLOR = VkBlendFactor(2)
        val ONE_MINUS_SRC_COLOR = VkBlendFactor(3)
        val DST_COLOR = VkBlendFactor(4)
        val ONE_MINUS_DST_COLOR = VkBlendFactor(5)
        val SRC_ALPHA = VkBlendFactor(6)
        val ONE_MINUS_SRC_ALPHA = VkBlendFactor(7)
        val DST_ALPHA = VkBlendFactor(8)
        val ONE_MINUS_DST_ALPHA = VkBlendFactor(9)
        val CONSTANT_COLOR = VkBlendFactor(10)
        val ONE_MINUS_CONSTANT_COLOR = VkBlendFactor(11)
        val CONSTANT_ALPHA = VkBlendFactor(12)
        val ONE_MINUS_CONSTANT_ALPHA = VkBlendFactor(13)
        val SRC_ALPHA_SATURATE = VkBlendFactor(14)
        val SRC1_COLOR = VkBlendFactor(15)
        val ONE_MINUS_SRC1_COLOR = VkBlendFactor(16)
        val SRC1_ALPHA = VkBlendFactor(17)
        val ONE_MINUS_SRC1_ALPHA = VkBlendFactor(18)
    }
}